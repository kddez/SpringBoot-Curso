package med.voll.api.service;

import lombok.AllArgsConstructor;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicoService {

    @Autowired
    private final MedicoRepository medicoRepository;


}
