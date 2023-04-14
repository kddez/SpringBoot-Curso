package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.paciente.Paciente;

public record DadosDetalhamentoPaciente(Long id, Boolean status, String nome, String email, String telefone, String cpf, Endereco endereco) {

   public DadosDetalhamentoPaciente(Paciente paciente){
       this(paciente.getId(), paciente.isAtivo(),paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
   }
}
