package med.voll.api.Service;

import lombok.AllArgsConstructor;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
}
