package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IUsuariocl3;
import model.TblUsuariocl3;

public class ClassUsuariocl3Imp implements IUsuariocl3 {

	public String ValidarUsuario(TblUsuariocl3 usuario) {
		//Establecemos conexión con unidad de persistencia
		EntityManagerFactory em=Persistence.createEntityManagerFactory("LPII_CL3_TAKENAKANAKASONEYUMI"); 
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		//Buscamos el usuario ingresado
		List<TblUsuariocl3> listado = emanager.createQuery("select c from TblUsuariocl3 c", TblUsuariocl3.class).getResultList();
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		
		TblUsuariocl3 usuarioEncontrado=null;
		for (TblUsuariocl3 usuarioDeLista: listado){
			if(usuarioDeLista.getUsuariocl3().equals(usuario.getUsuariocl3())){
				usuarioEncontrado = usuarioDeLista;
			}
		}

		String resultado;
		//Validamos la existencia del usuario
		if(usuarioEncontrado!=null){
			//Validamos la contraseña
			if(usuarioEncontrado.getPasswordcl3().equals(usuario.getPasswordcl3())){
				resultado="Credenciales correctas. Bienvenido.";
			}
			else{
				resultado="Contraseña incorrecta.";
			}
		}else{
			resultado="Usuario no encontrado.";			
		}

		return resultado;
		
	}

}
