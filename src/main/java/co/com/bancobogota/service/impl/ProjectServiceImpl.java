package co.com.bancobogota.service.impl;

import java.util.List;

import co.com.bancobogota.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.bancobogota.repository.IProjectRepository;
import co.com.bancobogota.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private IProjectRepository repos;
	
	@Override
	public List<Project> listarTodos() {
		return repos.findAll();
	}

	@Override
	public Project listarPorId(int id) {
		return repos.findById(id).orElse(null);
	}

	@Override
	public Project registrar(Project entidad) {
		try {
			return repos.save(entidad);
        } catch(Exception e ) {
            throw new RuntimeException(e.getMessage());
        }		
	}

	@Override
	public Project actualizar(Project entidad) {
		try {
			return repos.save(entidad);
        } catch(Exception e ) {
            throw new RuntimeException(e.getMessage());
        }
		
	}

	@Override
	public boolean eliminar(int id) {
		try {
			repos.deleteById(id);
			return true;
		} catch(Exception e ) {
			return false;
		}
	}

	
}
