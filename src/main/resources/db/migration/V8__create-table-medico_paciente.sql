CREATE TABLE medico_paciente (
    medico_fk BIGINT NOT NULL,
    paciente_fk BIGINT NOT NULL,
    PRIMARY KEY (medico_fk, paciente_fk),
    FOREIGN KEY (medico_fk) REFERENCES medicos(id),
    FOREIGN KEY (paciente_fk) REFERENCES pacientes(id)
);
