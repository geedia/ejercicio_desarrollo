package coop.tecso.examen.service;

import java.util.List;
import java.util.Optional;

import coop.tecso.examen.model.Cuenta;

public interface CuentaService {
	public void saveCuenta(Cuenta cuenta);

	public void deleteCuenta(Long id);

	public Optional<Cuenta> findById(Long id);

	public List<Cuenta> findAll();
	
}
