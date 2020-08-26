package co.com.bancobogota.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.bancobogota.model.Location;
import co.com.bancobogota.service.ILocationService;

@RestController
@RequestMapping( "/api/location" )
public class LocationRestController {

	@Autowired
	private ILocationService iLocationService;

	@GetMapping
	@Cacheable( value = "locations" )
	public List<Location> listarTodos() {
		return iLocationService.listarTodos();
	}

	@GetMapping( path = "/{id}")
	@Cacheable( value="location", key="#id")
	public Location listarPorId(@PathVariable("id") int id) {
		System.out.println("Employee fetching from database:: "+id);
		Location data =  iLocationService.listarPorId(id);
		if ( data == null) throw new RuntimeException("Element not fount frences-"+id);
		return data;
	}
	
	@PostMapping( path = "/registrar" )
	public void registrar(@RequestBody Location entidad) {
		iLocationService.registrar(entidad);
		
	}

	@PutMapping( path ="/actualizar" )
	public void actualizar(@RequestBody Location entidad) {
		iLocationService.actualizar(entidad);
	}
	
	@DeleteMapping( path ="/eliminar/{id}" )
	public void eliminar(@PathVariable("id") int id) {
		iLocationService.eliminar(id);
	}

}
