package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProductocl3;
import model.TblProductocl3;

public class ClassProductocl3Imp implements IProductocl3 {

	public void RegistrarProductocl3(TblProductocl3 producto) {
		//establecer conexión con la unidad de persistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_TAKENAKANAKASONEYUMI");
		//gestionar las entidades
		EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//registramos
		em.persist(producto);
		//emitimos mensaje por consola
		System.out.print("Producto Registrado en la BD");
		//configuramos
		em.getTransaction().commit();
		//cerramos
		em.close();
	}//fin de método registrar producto

	public List<TblProductocl3> ListadoProductocl3() {
		//establecer conexión con la unidad de persistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_TAKENAKANAKASONEYUMI");
		//gestionar las entidades
		EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//recuperamos los productos de la bd
		//**** Utilizando JPQL
		List<TblProductocl3> listadoproductos = em.createQuery("select c from TblProductocl3 c", TblProductocl3.class).getResultList();
		//confirmamos
		em.getTransaction().commit();
		//cerramos
		em.close();
		return listadoproductos;
	}//fin de metodo listado

	public void ActualizarProductocl3(TblProductocl3 producto) {
		//establecer conexión con la unidad de persistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_TAKENAKANAKASONEYUMI");
		//gestionar las entidades
		EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//actualizamos
		em.merge(producto);
		//confirmamos
		em.getTransaction().commit();
		//emitimos mensaje por consola
		System.out.print("Producto actualizado en la BD");
		//cerramos
		em.close();
	}//fin de método actualizar

	public void EliminarProductocl3(TblProductocl3 producto) {
		//establecer conexión con la unidad de persistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_TAKENAKANAKASONEYUMI");
		//gestionar las entidades
		EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//recuperamos el código a eliminar
		TblProductocl3 elim=em.merge(producto);
		//elimminar registro
		em.remove(elim);
		//confirmamos
		em.getTransaction().commit();
		//emitimos mensaje por consola
		System.out.print("Producto eliminado en la BD");
		//cerramos
		em.close();
	}//fin de método eliminar

	public TblProductocl3 BuscarProductocl3(TblProductocl3 producto) {
		//establecer conexión con la unidad de persistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_TAKENAKANAKASONEYUMI");
		//gestionar las entidades
		EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//recuperamos el código a buscar
		TblProductocl3 busprod = em.find(TblProductocl3.class, producto.getIdproductoscl3());
		//confirmamos
		em.getTransaction().commit();
		//cerramos
		em.close();
		return busprod;
	}//Fin de método buscar

}
