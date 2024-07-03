package Interfaces;

import java.util.List;

import model.TblProductocl3;

public interface IProductocl3 {

	//declaramos los métodos
	public void RegistrarProductocl3(TblProductocl3 producto);
	public List<TblProductocl3> ListadoProductocl3();
	public void ActualizarProductocl3(TblProductocl3 producto);
	public void EliminarProductocl3(TblProductocl3 producto);
	public TblProductocl3 BuscarProductocl3 (TblProductocl3 producto);

}//fin de la interfaz

