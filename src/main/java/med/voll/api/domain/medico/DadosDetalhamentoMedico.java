package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, Boolean status, String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco)
{
    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.isAtivo(), medico.getNome() ,medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
