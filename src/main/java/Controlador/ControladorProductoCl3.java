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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Hacer instancias
		TblProductocl3 producto=new TblProductocl3();
		ClassProductocl3Imp crud = new ClassProductocl3Imp();

		//recuperamos la accion y el código
		String accion= request.getParameter("accion");
		//aplicamos una condicion
		if(accion!=null){
			switch(accion){
			case "Modificar":
				int idproductoscl3=Integer.parseInt(request.getParameter("idproductoscl3"));
				//asignar el codigo...
				producto.setIdproductoscl3(idproductoscl3);
				TblProductocl3 buscarcod=crud.BuscarProductocl3(producto);
				//enviar los valores buscados por codigo de la bd
				//al formulario actualizar
				request.setAttribute("idproductoscl3", buscarcod.getIdproductoscl3());
				request.setAttribute("nombrecl3", buscarcod.getNombrecl3());
				request.setAttribute("precioventacl3", buscarcod.getPrecioventacl3());
				request.setAttribute("preciocompcl3", buscarcod.getPreciocompcl3());
				request.setAttribute("estadocl3", buscarcod.getEstadocl3());
				request.setAttribute("descripcl3", buscarcod.getDescripcl3());

				//redireccionar
				request.getRequestDispatcher("/FormActualizarProductocl3.jsp").forward(request, response);
				//salimos
				break;
			case "Eliminar":
				int codeliminar=Integer.parseInt(request.getParameter("idproductoscl3"));
				//asignamos el codigo a eliminar
				producto.setIdproductoscl3(codeliminar);
				//invocamos al método eliminar
				crud.EliminarProductocl3(producto);
				//refrescar el listado
				List<TblProductocl3> listado = crud.ListadoProductocl3();
				request.setAttribute("listadodeproductos",listado);
				//redireccionar
				request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
				//salimos
				break;		
				
			case "Listar":
				List<TblProductocl3> listado2= crud.ListadoProductocl3();
				//invocamos el listado de productos para la vista
				request.setAttribute("listadodeproductos", listado2);
				//redireccionamos
				request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
						
				}//fin de switch
		}//fin del if
}

	/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperamos los valores del formulario
		String idproductoscl3 =request.getParameter("idproductoscl3");
		String nombrecl3 =request.getParameter("nombrecl3");
		double precioventacl3 =Double.parseDouble(request.getParameter("precioventacl3"));
		double preciocompcl3= Double.parseDouble(request.getParameter("preciocompcl3"));	
		String estadocl3=request.getParameter("estadocl3");
		String descripcl3= request.getParameter("descripcl3");
		
		List<TblProductocl3> listadoproductocl3=null;
		
		//instanciar las respectivas entidades
		TblProductocl3 productocl3=new TblProductocl3();
		ClassProductocl3Imp crud= new ClassProductocl3Imp();
		
		//asignamos valores 
		productocl3.setNombrecl3(nombrecl3);
		productocl3.setPrecioventacl3(precioventacl3);
		productocl3.setPreciocompcl3(preciocompcl3);
		productocl3.setEstadocl3(estadocl3);
		productocl3.setDescripcl3(descripcl3);
		if (idproductoscl3!=null){
			//recupero el código a actualizar
			int cod= Integer.parseInt(idproductoscl3);
			//asigno el código a actualizar
			productocl3.setIdproductoscl3(cod);
			//invoco el método actualizar
			crud.ActualizarProductocl3(productocl3);	
			//actualizar listado producto
			listadoproductocl3=crud.ListadoProductocl3();
		}else{
			
			//invocamos al método registrar
			crud.RegistrarProductocl3(productocl3);
			//actualizar listado de producto
			listadoproductocl3=crud.ListadoProductocl3();
			
			}//fin del else
		
			//actualizar listado de productos
			listadoproductocl3=crud.ListadoProductocl3();
			//invocamos al listado de productos para la vista
			request.setAttribute("listadodeproductos", listadoproductocl3);
			
			//redireccionamos
			request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);

	}//fin de metodo doPost

}
