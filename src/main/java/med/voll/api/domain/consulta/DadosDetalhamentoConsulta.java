package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id,
                                    String status,
                                    String descricao,
                                    String nomeDoPaciente,
                                    String cpf,
                                    String nomeDoMedico,
                                    Especialidade especialidade,
                                    String crm,
                                    LocalDateTime data) {
    public DadosDetalhamentoConsulta(Consulta consulta){
        this(consulta.getId(), consulta.getStatus(), consulta.getDescricao(), consulta.getPaciente().getNome(), consulta.getPaciente().getCpf(),
                consulta.getMedico().getNome(), consulta.getMedico().getEspecialidade(), consulta.getMedico().getCrm(), consulta.getData());
    }
}
