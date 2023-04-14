package med.voll.api.consulta;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.medico.Medico;
import med.voll.api.paciente.Paciente;

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
