package med.voll.api.service;

import lombok.AllArgsConstructor;
import med.voll.api.domain.consulta.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsultaService {

    @Autowired
    private final ConsultaRepository consultaRepository;



}
