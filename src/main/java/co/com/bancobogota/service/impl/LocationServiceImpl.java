package co.com.bancobogota.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.bancobogota.model.Location;
import co.com.bancobogota.repository.ILocationRepository;
import co.com.bancobogota.service.ILocationService;

@Service
public class LocationServiceImpl implements ILocationService {

	@Autowired
	private ILocationRepository repos;
	
	@Override
	public List<Location> listarTodos() {
		return repos.findAll();
	}

	@Override
	public Location listarPorId(int id) {
		return repos.findById(id).orElse(null);
	}

	@Override
	public Location registrar(Location entidad) {
		try {
			return repos.save(entidad);
        } catch(Exception e ) {
            throw new RuntimeException(e.getMessage());
        }		
	}

	@Override
	public Location actualizar(Location entidad) {
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
