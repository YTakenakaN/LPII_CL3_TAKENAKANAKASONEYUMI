package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassProductocl3Imp;
import Dao.ClassUsuariocl3Imp;
import model.TblProductocl3;
import model.TblUsuariocl3;

/**
 * Servlet implementation class ControladorUsuarioCl3
 */
public class ControladorUsuarioCl3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuarioCl3() {
        super();
        // TODO Auto-generated constructor stub
    }//Fin del constructor


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}//Fin del método doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recuperamos los valores del formulario
		String usuariocl3 =request.getParameter("usuariocl3");
		String passwordcl3=request.getParameter("passwordcl3");
		
		//instanciar las respectivas entidades
		TblUsuariocl3 tblusuariocl3=new TblUsuariocl3();
		ClassUsuariocl3Imp validar= new ClassUsuariocl3Imp();
		ClassProductocl3Imp crud= new ClassProductocl3Imp();
		
		//asignamos valores 
		tblusuariocl3.setUsuariocl3(usuariocl3);
		tblusuariocl3.setPasswordcl3(passwordcl3);

		//invocamos al método registrar
		String resultado=validar.ValidarUsuario(tblusuariocl3);
		
		
		//Condicional según resultado
		if(resultado.equals("Credenciales correctas. Bienvenido.")){
			//actualizar listado de productos
			List<TblProductocl3> listadoproductocl3=crud.ListadoProductocl3();
			//invocamos al listado de productos para la vista
			request.setAttribute("listadodeproductos", listadoproductocl3);
			//redireccionamos
			request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);	
		}else{
			if(resultado.equals("Contraseña incorrecta.")){
				String mensaje ="Contraseña incorrecta";
				//seteamos el mensaje para enviar a la vista
				request.setAttribute("mensaje", mensaje);
				//redireccionamos
				request.getRequestDispatcher("/index.jsp").forward(request, response);	
			}else{
				String mensaje ="Usuario no encontrado";
				//seteamos el mensaje para enviar a la vista
				request.setAttribute("mensaje", mensaje);
				//redireccionamos
				request.getRequestDispatcher("/index.jsp").forward(request, response);	
			}
		}//Fin de condicional

	}//Fin del método doPost

}//Fin del controlador
