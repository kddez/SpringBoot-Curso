package med.voll.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        String telefone,
        String nome,
        @NotNull
        Long id,

        DadosEndereco endereco) {
}
