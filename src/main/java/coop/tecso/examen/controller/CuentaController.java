package coop.tecso.examen.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.CuentaDto;
import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.model.Cuenta;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.service.CuentaService;
import coop.tecso.examen.service.MovimientoService;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
	
	@Autowired
	CuentaService cuentaService;
	
	@Autowired
	MovimientoService movimientoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/listar")
	public List<CuentaDto> findAll(){
		List<Cuenta> cuentas = this.cuentaService.findAll();
		return cuentas.stream().map(cuenta -> convertToDto(cuenta)).collect(Collectors.toList());
	}
	
	@PostMapping("/")
	public CuentaDto saveCuenta(@RequestBody @Valid CuentaDto cuentaDto){
		Cuenta cuenta= this.convertToEntity(cuentaDto);
		this.cuentaService.saveCuenta(cuenta);
		return this.convertToDto(cuenta);
	}
	
	@DeleteMapping("/{selected}")
	public void deleteCuenta(@PathVariable("selected") String id) {
		if (id != null && !id.isEmpty()) {
			Optional<Cuenta> existe = cuentaService.findById(new Long(id));
			if(existe.isPresent()){
				if(existe.get().getMovimientos() == null || existe.get().getMovimientos().size()==0){
					cuentaService.deleteCuenta(new Long(id));
				}else{
					System.out.println("NO SE PUEDEN BORRAR CUENTAS CON MOVIMIENTO");
				}
			}
		}
	}
	
	@PutMapping("/")
	public CuentaDto editarCuenta(@RequestBody CuentaDto CuentaDto) {
		return this.saveCuenta(CuentaDto);
	}
	
	@PostMapping("/movimiento/{cuenta}")
	public MovimientoDto saveMovimiento(@RequestBody MovimientoDto movimientoDto, @PathVariable("cuenta") Long cuenta){
		Movimiento movimiento= this.convertToEntity(movimientoDto);
		if (cuenta != null && cuenta!=0L) {
			Optional<Cuenta> existe = cuentaService.findById(cuenta);
			if(existe.isPresent()){
				movimiento.setCuenta(existe.get());
				this.movimientoService.saveMovimiento(movimiento);
				//ACTUALIZAR CUENTA
				if(movimiento.getTipo().equalsIgnoreCase("D")){
					existe.get().setSaldo(existe.get().getSaldo() + movimiento.getImporte());
				}else{
					existe.get().setSaldo(existe.get().getSaldo() - movimiento.getImporte());
				}
				this.cuentaService.saveCuenta(existe.get());
				return this.convertToDto(movimiento);
			}
		}
		return null;
	}
	
	@GetMapping("/movimiento/{cuenta}")
	public List<MovimientoDto> listarMovimientoCuenta(@PathVariable("cuenta") String cuenta){
		if(cuenta!=null & !cuenta.isEmpty()){
			Optional<Cuenta> cuentaSeleccionada = this.cuentaService.findById(new Long(cuenta));
			if(cuentaSeleccionada.isPresent()){
				List<Movimiento> movimientos = this.movimientoService.findByCuenta(cuentaSeleccionada.get());
				return movimientos.stream().map(movimiento -> convertToDto(movimiento)).collect(Collectors.toList());
			}
		}
		return null;
	}
	
	
	private CuentaDto convertToDto(Cuenta cuenta) {
		return modelMapper.map(cuenta, CuentaDto.class);
	}

	private Cuenta convertToEntity(CuentaDto cuentaDto) {
		return modelMapper.map(cuentaDto, Cuenta.class);
	}
	
	
	private MovimientoDto convertToDto(Movimiento movimiento) {
		return modelMapper.map(movimiento, MovimientoDto.class);
	}
	
	private Movimiento convertToEntity(MovimientoDto movimientoDto) {
		return modelMapper.map(movimientoDto, Movimiento.class);
	}


}
