package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.medico.Medico;

import java.util.List;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private boolean ativo;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    @ManyToMany (mappedBy = "pacientes")
    private List<Medico> medicos;


    public Paciente(DadosCadastroPaciente dados){
        this.ativo = true;
        this.cpf = dados.cpf();
        this.endereco = new Endereco((dados.endereco()));
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
