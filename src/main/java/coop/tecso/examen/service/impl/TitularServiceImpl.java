package coop.tecso.examen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.Titular;
import coop.tecso.examen.repository.TitularRepository;
import coop.tecso.examen.service.TitularService;

@Service
public class TitularServiceImpl implements TitularService {

	@Autowired
	TitularRepository titularRepository;
	
	
	@Override
	public void saveTitular(Titular titular) {
		titularRepository.save(titular);
	}

	@Override
	public String deleteTitular(Long id) {
		titularRepository.deleteById(id);
		return "";
	}

	@Override
	public Titular findById(Long id) {
		// TODO Auto-generated method stub
		
		return titularRepository.findById(id).orElse(null);
	}

	@Override
	public List<Titular> findAll() {
		// TODO Auto-generated method stub
		return titularRepository.findAll();
	}

}
