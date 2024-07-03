package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassProductocl3Imp;
import model.TblProductocl3;

/**
 * Servlet implementation class ControladorProductoCl3
 */
public class ControladorProductoCl3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProductoCl3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperamos los valores del formulario
		String nombrecl3 =request.getParameter("nombrecl3");
		double precioventacl3 =Double.parseDouble(request.getParameter("precioventacl3"));
		double preciocompcl3= Double.parseDouble(request.getParameter("preciocompcl3"));	
		String estadocl3=request.getParameter("estadocl3");
		String descripcl3= request.getParameter("descripcl3");
				
		//instanciar las respectivas entidades
		TblProductocl3 productocl3=new TblProductocl3();
		ClassProductocl3Imp crud= new ClassProductocl3Imp();
		
		//asignamos valores 
		productocl3.setNombrecl3(nombrecl3);
		productocl3.setPrecioventacl3(precioventacl3);
		productocl3.setPreciocompcl3(preciocompcl3);
		productocl3.setEstadocl3(estadocl3);
		productocl3.setDescripcl3(descripcl3);
		
		//invocamos al método registrar
		crud.RegistrarProductocl3(productocl3);
		
		//actualizar listado de productos
		List<TblProductocl3> listadoproductocl3=crud.ListadoProductocl3();
		//invocamos al listado de productos para la vista
		request.setAttribute("listadodeproductos", listadoproductocl3);
		
		//redireccionamos
		request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);

	}//fin de metodo doPost

}
