package modelo.dao;

import java.sql.Statement;
import java.util.List;
import java.sql.Connection;

import modelo.data.Asignatura;

public class AsignaturaDAO {
	private static Connection connection;
	
	public static boolean insertaUnaAsignatura(Asignatura asignatura) {
		Conexion con = new Conexion();
		boolean rowInserted = false;
		
		try {
			Statement statement = connection.createStatement();
			int idHorario = 0;
			if((idHorario = HorarioDAO.isHorarioInBD(asignatura.getHorario().getNombre()))==0) {
				System.out.println("[ERROR]: No existe el horario indicado");
			}else {
				String sql = "INSERT INTO asignatura VALUES ('0', '"+asignatura.getHorario()+"', '"+asignatura.getNombre()+"', '"+asignatura.getEnlace()+"');";
				rowInserted = statement.executeUpdate(sql) > 0;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowInserted;
	}
	
	public static List<Asignatura> seleccionarAsignaturas(){
		
	}
}
