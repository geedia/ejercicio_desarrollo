package coop.tecso.examen.service;

import java.util.List;

import coop.tecso.examen.model.Cuenta;
import coop.tecso.examen.model.Movimiento;

public interface MovimientoService {
	public void saveMovimiento(Movimiento movimiento);

	public List<Movimiento> findByCuenta(Cuenta cuenta);

}
