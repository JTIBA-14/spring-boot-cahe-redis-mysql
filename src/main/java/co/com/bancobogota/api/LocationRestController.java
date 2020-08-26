package co.com.bancobogota.api;

import java.util.List;

import co.com.bancobogota.model.Project;
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

import co.com.bancobogota.service.IProjectService;

@RestController
@RequestMapping( "/api/location" )
public class LocationRestController {

	@Autowired
	private IProjectService iProjectService;

	@GetMapping
	@Cacheable( value = "locations" )
	public List<Project> listarTodos() {
		return iProjectService.listarTodos();
	}

	@GetMapping( path = "/{id}")
	@Cacheable( value="location", key="#id")
	public Project listarPorId(@PathVariable("id") int id) {
		System.out.println("Employee fetching from database:: "+id);
		Project data =  iProjectService.listarPorId(id);
		if ( data == null) throw new RuntimeException("Element not fount frences-"+id);
		return data;
	}
	
	@PostMapping
	public void registrar(@RequestBody Project entidad) {
		iProjectService.registrar(entidad);
		
	}

	@PutMapping( path ="/{id}" )
	public void actualizar(@RequestBody Project entidad) {
		iProjectService.actualizar(entidad);
	}
	
	@DeleteMapping( path ="/{id}" )
	public void eliminar(@PathVariable("id") int id) {
		iProjectService.eliminar(id);
	}

}
