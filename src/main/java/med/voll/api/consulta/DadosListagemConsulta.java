package med.voll.api.consulta;

import med.voll.api.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosListagemConsulta(Long id,
                                    String descricao,
                                    String nomeDoPaciente,
                                    String cpf,
                                    String nomeDoMedico,
                                    Especialidade especialidade,
                                    String crm,
                                    LocalDateTime data) {
    public DadosListagemConsulta(Consulta consulta){
        this(consulta.getId(), consulta.getDescricao(), consulta.getPaciente().getNome(), consulta.getPaciente().getCpf(),
                consulta.getMedico().getNome(), consulta.getMedico().getEspecialidade(), consulta.getMedico().getCrm(), consulta.getData());
    }
}
