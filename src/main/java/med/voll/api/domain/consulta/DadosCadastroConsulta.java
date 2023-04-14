package med.voll.api.domain.consulta;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

public record DadosCadastroConsulta(
        @NotNull
        LocalDateTime data,
        @NotBlank
        String descricao,
        @NotNull
        @Valid
        Paciente paciente,
        @NotNull
        @Valid
        Medico medico)
{

}