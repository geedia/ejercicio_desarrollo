package coop.tecso.examen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.Cuenta;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.repository.MovimientoRepository;
import coop.tecso.examen.service.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService {

	 @Autowired
	 MovimientoRepository movimientoRepository;
	 
	@Override
	public void saveMovimiento(Movimiento movimiento) {
		this.movimientoRepository.save(movimiento);

	}

	@Override
	public List<Movimiento> findByCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return this.movimientoRepository.findByCuenta(cuenta);
	}

}
