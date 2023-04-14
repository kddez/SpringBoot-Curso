package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        String telefone,
        @NotNull
        Long id,
        String nome,
        DadosEndereco endereco) {


}
