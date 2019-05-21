package coop.tecso.examen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.Cuenta;
import coop.tecso.examen.repository.CuentaRepository;
import coop.tecso.examen.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Override
	public void saveCuenta(Cuenta cuenta) {
		this.cuentaRepository.save(cuenta);

	}

	@Override
	public void deleteCuenta(Long id) {
		// TODO Auto-generated method stub
		this.cuentaRepository.deleteById(id);
	}

	@Override
	public Optional<Cuenta> findById(Long id) {
		// TODO Auto-generated method stub
		return this.cuentaRepository.findById(id);
	}

	@Override
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return this.cuentaRepository.findAll();
	}

}
