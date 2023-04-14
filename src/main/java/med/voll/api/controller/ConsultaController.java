package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Service.ConsultaService;
import med.voll.api.consulta.*;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public void marcarConsulta(@RequestBody @Valid DadosCadastroConsulta dados){
        Paciente paciente = pRepository.findById(dados.paciente().getId())
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));

        Medico medico = mRepository.findById(dados.medico().getId())
                        .orElseThrow(() -> new IllegalArgumentException("Medico não encontrado"));



        Consulta consulta = new Consulta(dados, paciente, medico);
            cRepository.save(consulta);

    }

    @GetMapping
    public Page<DadosListagemConsulta> listarConsulta(@PageableDefault(size = 10) Pageable paginacao){
        return cRepository.findAllByAtivoTrue(paginacao).map(DadosListagemConsulta::new);


    }


}
