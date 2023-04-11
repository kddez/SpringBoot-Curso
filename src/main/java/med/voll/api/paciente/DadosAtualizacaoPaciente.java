package med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        String telefone,
        String nome,
        @NotNull
        Long id,

        DadosEndereco endereco) {
}
