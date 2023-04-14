package med.voll.api.Service;

import lombok.AllArgsConstructor;
import med.voll.api.consulta.Consulta;
import med.voll.api.consulta.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class ConsultaService {

    @Autowired
    private final ConsultaRepository consultaRepository;

}
