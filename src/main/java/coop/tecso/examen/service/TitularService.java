package coop.tecso.examen.service;

import java.util.List;

import coop.tecso.examen.model.Titular;

public interface TitularService {
	public void saveTitular(Titular titular);

	public String deleteTitular(Long id);

	public Titular findById(Long id);
	
	public List<Titular> findAll();

}
