package med.voll.api.domain.consulta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class  Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private boolean ativo;

    private LocalDateTime data;

    private String descricao;

    @ManyToOne
    @JoinColumn(name="fk_medicos")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name="fk_pacientes")
    private Paciente paciente;

    public Consulta(DadosCadastroConsulta dados, Paciente paciente, Medico medico) {
        this.ativo = true;
        this.medico = medico;
        this.paciente = paciente;
        this.data = dados.data();
        this.descricao = dados.descricao();

    }

    public void desmarcarConsulta() {
        this.ativo = false;
    }







}


