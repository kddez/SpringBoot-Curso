package med.voll.api.service;

import lombok.AllArgsConstructor;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
}
