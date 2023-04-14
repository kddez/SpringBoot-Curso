package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.service.ConsultaService;
import med.voll.api.domain.consulta.*;
import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCadastroConsulta;
import med.voll.api.domain.consulta.DadosListagemConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;
    @Autowired
    private ConsultaRepository cRepository;

    @Autowired
    private PacienteRepository pRepository;
    @Autowired
    private MedicoRepository mRepository;
    @PostMapping
    @Transactional
    public ResponseEntity marcarConsulta(@RequestBody @Valid DadosCadastroConsulta dados, UriComponentsBuilder uriBuilder){
        Paciente paciente = pRepository.findById(dados.paciente().getId())
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));

        Medico medico = mRepository.findById(dados.medico().getId())
                        .orElseThrow(() -> new IllegalArgumentException("Medico não encontrado"));

        Consulta consulta = new Consulta(dados, paciente, medico);
            cRepository.save(consulta);

        var uri = uriBuilder.path("/consultas/{id}").buildAndExpand(consulta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemConsulta(consulta));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemConsulta>> listarConsulta(@PageableDefault(size = 10) Pageable paginacao){
       var page = cRepository.findAllByAtivoTrue(paginacao).map(DadosListagemConsulta::new);

       return ResponseEntity.ok(page);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var consulta = cRepository.getReferenceById(id);
        consulta.desmarcarConsulta();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalhar(@PathVariable Long id){
        var consulta = cRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoConsulta(consulta));
    }

}
