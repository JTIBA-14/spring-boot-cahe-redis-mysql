package co.com.bancobogota.service;

import java.util.List;

public interface ICrudService<T> {
	
	public List<T> listarTodos();

	public T listarPorId(int id);

	public T registrar(T entidad);

	public T actualizar(T entidad);

	public boolean eliminar(int id);
}
