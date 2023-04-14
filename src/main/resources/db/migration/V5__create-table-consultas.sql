CREATE TABLE consultas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  fk_medicos BIGINT NOT NULL,
  fk_pacientes BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (fk_medicos) REFERENCES medicos(id),
  FOREIGN KEY (fk_pacientes) REFERENCES pacientes(id)
);
