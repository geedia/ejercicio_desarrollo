package coop.tecso.examen.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.TitularDto;
import coop.tecso.examen.model.Titular;
import coop.tecso.examen.service.TitularService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/titular")
public class TitularController {
	@Autowired
	TitularService titularService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/{id}")
	public TitularDto findById(@PathVariable Long id){
		Titular titular = titularService.findById(id);
		if(titular!=null) {
			return this.convertToDto(titular);
		}
		return null;
	}
	
	@GetMapping("/listar")
	public List<TitularDto> findAll(){
		List<Titular> titulares = this.titularService.findAll();
		return titulares.stream().map(titular -> convertToDto(titular)).collect(Collectors.toList());
	}
	
	@PostMapping("/")
	public TitularDto SaveTitular(@RequestBody TitularDto titularDto){
		Titular titular = this.convertToEntity(titularDto);
		this.titularService.saveTitular(titular);
		return this.convertToDto(titular);
	}
	
	@DeleteMapping("/{selected}")
	public void deleteImage(@PathVariable("selected") String id) {
		if (id != null && !id.isEmpty()) {
			Titular existe = titularService.findById(new Long(id));
			if(existe !=null){
				titularService.deleteTitular(new Long(id));
			}
		}
	}
	
	@PutMapping("/")
	public TitularDto editarTitular(@RequestBody TitularDto titularDto) {
		return this.SaveTitular(titularDto);
	}
	
	
	/**
	 * Convertir entidad a DTO
	 * @param Titular
	 * @return
	 */
	private TitularDto convertToDto(Titular titular) {
		return modelMapper.map(titular, TitularDto.class);
	}

	/**
	 * Convertir DTO a entidad
	 * @param TitularDto
	 * @return
	 */
	private Titular convertToEntity(TitularDto titularDto) {
		return modelMapper.map(titularDto, Titular.class);
	}
}
