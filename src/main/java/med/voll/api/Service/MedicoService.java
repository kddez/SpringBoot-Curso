package med.voll.api.Service;

import lombok.AllArgsConstructor;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MedicoService {

    @Autowired
    private final MedicoRepository medicoRepository;


}
