package co.com.bancobogota.api;

import java.util.List;

import co.com.bancobogota.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
@RequestMapping( "/api/projects" )
public class LocationRestController {

	@Autowired
	private IProjectService iProjectService;

	@GetMapping
	@Cacheable( value = "projects" )
	public List<Project> listarTodos() {
		return iProjectService.listarTodos();
	}

	@GetMapping( path = "/{id}")
	@Cacheable( value="project", key="#id")
	public Project listarPorId(@PathVariable("id") int id) {
		System.out.println("Employee fetching from database:: "+id);
		Project data =  iProjectService.listarPorId(id);
		if ( data == null) throw new RuntimeException("Element not fount frences-"+id);
		return data;
	}
	
	@PostMapping
	public Project registrar(@RequestBody Project entidad) {
		return iProjectService.registrar(entidad);
	}

	@PutMapping( path ="/{id}" )
	@CachePut( value = "project", key = "#id")
	public Project actualizar(@RequestBody Project entidad, @PathVariable String id) {
		System.out.println("Ejecutando modificación");
		return iProjectService.actualizar(entidad);
	}
	
	@DeleteMapping( path ="/{id}" )
	@CacheEvict( value = "project", allEntries = true)
	public void eliminar(@PathVariable("id") int id) {
		iProjectService.eliminar(id);
	}

}
