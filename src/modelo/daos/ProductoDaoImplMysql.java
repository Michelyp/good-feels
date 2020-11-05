package modelo.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.beans.Producto;

public class ProductoDaoImplMysql implements InterfaceProductoDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	Producto p = new Producto();

	public ProductoDaoImplMysql() {
		String url = "jdbc:mysql://localhost:3307/ProductosdbMP";
		String usuario = "root";
		String password = "";
		try {
			// Conexoión con al base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, usuario, password);
			if (conn != null) {
				System.out.println("Conexión establecida");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se puede conectar" + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean altaProducto(Producto producto) {
		//sentencia sql para añadir el nuevo producto a la tabla 
		sql = "insert into productos(descripcion,precio_unitario) values ('" + producto.getDescripcion() + "','"
				+ producto.getPrecioUnitario() + "')";

		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();

			System.out.println("Producto insertado");
		} catch (SQLException e) {
			System.out.println("Producto NO insertado");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List findAll() {
		ArrayList<Producto> list = new ArrayList<>();
		sql = "select * from productos";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Producto pro = new Producto();
				pro.setCodigo(rs.getInt("codigo"));
				pro.setDescripcion(rs.getString("descripcion"));
				pro.setPrecioUnitario(rs.getDouble("precio_unitario"));
				list.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean delete(int codigo) {
		sql = "delete from productos where codigo=" + codigo;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Producto buscarPorCodigo(int codigo) {

		sql = "select * from productos where codigo = ? ";
		Producto producto = null;
		// pasamos la sentencia sql
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			// La dirección del fichero se une al resulset
			rs = ps.executeQuery();
			// si devuelve true existe la fila en el sql y sino no existe
			if (rs.next()) {
				producto = new Producto();
				producto.setCodigo(rs.getInt(1));
				producto.setDescripcion(rs.getString(2));
				producto.setPrecioUnitario(rs.getDouble(3));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return producto;
	}

	@Override
	public Producto list(int codigo) {
		String sql = "select * from persona where codigo=" + codigo;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				p.setCodigo(rs.getInt("codigo"));
				p.setDescripcion(rs.getString("DNI"));
				p.setPrecioUnitario(rs.getDouble("precio_unitario"));

			}
		} catch (Exception e) {
		}
		return p;
	}

}
