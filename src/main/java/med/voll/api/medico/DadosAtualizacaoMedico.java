package med.voll.api.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        String telefone,
        @NotNull
        Long id,
        String nome,
        DadosEndereco endereco) {


}
