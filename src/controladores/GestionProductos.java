package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Producto;
import modelo.daos.ProductoDaoImplMysql;

/**
 * Servlet implementation class Productos
 */
@WebServlet("/GestionProductos")
public class GestionProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// los jsp con los que le vamos a direccionar
	String addProductos = "Productos.jsp";
	String VerTodos = "VerTodos.jsp";
	String consultar = "Consultar.jsp";
	int codigo;

	/**
	 * Default constructor.
	 */
	public GestionProductos() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acceso = "";
		String option = request.getParameter("opcion");
		Producto p = new Producto();
		ProductoDaoImplMysql pro = new ProductoDaoImplMysql();
		switch (option) {

		// muestra toda la lista de productos
		case "VerTodos":
			acceso = VerTodos;

			break;

		case "add":
			acceso = addProductos;
			break;

		// agrega un producto nuevo a la base de datos
		case "Agregar":

			String descripcion = request.getParameter("textdescripcion");
			double precioUnitario = ParseDouble(request.getParameter("textprecio"));

			/*
			 * la descripción y el precio no pueden estar vacíos en el caso que este vacío
			 * le mostrara un menddaje
			 */
			if (descripcion.length() > 0 && precioUnitario > 0) {

				p.setDescripcion(descripcion);
				p.setPrecioUnitario(precioUnitario);
				pro.altaProducto(p);
				acceso = VerTodos;
			} else {
				request.setAttribute("mensaje", "Verifique los campos");
				request.getRequestDispatcher("Productos.jsp").forward(request, response);
				System.out.println("esta vacío");
			}
			break;
			
		// elimina el producto de la base de datos
		case "eliminar":
			codigo = Integer.parseInt(request.getParameter("codigo"));
			p.setCodigo(codigo);
			pro.delete(codigo);
			request.setAttribute("mensaje", "Producto eliminado");
			request.getRequestDispatcher("Productos.jsp").forward(request, response);
			acceso = VerTodos;
			break;

		/*
		 * Consulta con el código del producto si se encuentra en la base de datos, en
		 * caso contrario le mostrar un mensaje
		 */
		case "consultar":
			try {
				codigo = Integer.parseInt(request.getParameter("codigo"));
			} catch (NumberFormatException e) {
				// Log it if needed
				System.out.println("El parametro recibido no es número");

			}
			Producto producto = pro.buscarPorCodigo(codigo);
			if (producto != null) {
				p.setCodigo(codigo);
				request.setAttribute("producto", producto);
				request.getRequestDispatcher("Consultar.jsp").forward(request, response);
				System.out.println("Se puede consultar el producto");
				acceso = "consultar";

			} else {
				request.setAttribute("mensaje", "El producto NO existe verifique.");
				request.getRequestDispatcher("Consultar.jsp").forward(request, response);
				System.out.println("Producto NO consultado");
			}
			break;

		default:
			System.out.println("Opción erronea");
		}
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// método que verifica el double no sea vacío o nulo
	double ParseDouble(String strNumber) {
		if (strNumber != null && strNumber.length() > 0) {
			try {
				return Double.parseDouble(strNumber);
			} catch (Exception e) {
				return -1;
			}
		} else
			return 0;
	}

}
