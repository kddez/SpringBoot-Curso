package med.voll.api.domain.consulta;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

public record DadosCadastroConsulta(
        @NotNull
        @Future(message = "A data e hora da consulta deve ser no futuro")
        LocalDateTime data,
        @NotBlank
        String descricao,

        String Status,
        @NotNull
        @Valid
        Paciente paciente,
        @NotNull
        @Valid
        Medico medico)
{

}
