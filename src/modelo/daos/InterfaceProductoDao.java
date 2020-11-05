package modelo.daos;

import java.util.List;

import modelo.beans.Producto;

public interface InterfaceProductoDao {

	public Producto buscarPorCodigo(int codigo);

	public boolean altaProducto(Producto producto);

	public Producto list(int codigo);

	public List findAll();

	public boolean delete(int codigo);

}
