package TestEntidades;

import java.util.List;

import Dao.ClassProductocl3Imp;
import model.TblProductocl3;

public class TestEntidadProducto {

	public static void main(String[] args) {
		//realizamos la respectiva instancia de las clases..
		TblProductocl3 productocl3 = new TblProductocl3();
		ClassProductocl3Imp crud = new ClassProductocl3Imp();
		
		/*Registrar producto*/
		//asignamos valores
		productocl3.setNombrecl3("Falda");
		productocl3.setPrecioventacl3(30);
		productocl3.setPreciocompcl3(15);
		productocl3.setEstadocl3("Vigente");
		productocl3.setDescripcl3("Descuento");
		//invocamos al método registrar
		crud.RegistrarProductocl3(productocl3);

		/*Listar producto
		List<TblProductocl3> listado = crud.ListadoProductocl3();
		
		for (TblProductocl3 list:listado){
			//imprimimos por pantalla
			System.out.println("Nombre: "+ list.getNombrecl3()+" Precio venta: " + list.getPrecioventacl3()+" Precio compra: "+list.getPreciocompcl3()+
			" Estado: "+list.getEstadocl3()+" Descripción: "+list.getDescripcl3());
		}//Fin del bucle for 
		*/
		
	}//fin del metodo main
}//Fin de la entidad

