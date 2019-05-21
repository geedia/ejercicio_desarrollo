package coop.tecso.examen.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import coop.tecso.examen.model.Cuenta;
import coop.tecso.examen.model.Movimiento;

public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {
	
	public List<Movimiento> findByCuenta(Cuenta cuenta);

}
