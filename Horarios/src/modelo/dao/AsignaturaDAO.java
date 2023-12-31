package modelo.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.data.Asignatura;
import modelo.data.Horario;

public class AsignaturaDAO {
	private static Connection connection;
	
	public static boolean insertaUnaAsignatura(Asignatura asignatura) {
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();
		boolean rowInserted = false;
		
		try {
			Statement statement = connection.createStatement();
			int idHorario = 0;
			if((idHorario = HorarioDAO.isHorarioInBD(asignatura.getHorario().getNombre()))==0) {
				System.out.println("[ERROR]: No existe el horario indicado");
			}else {
				//String sql1 = "INSERT INTO asignatura VALUES ('0', '"+asignatura.getHorario()+"', '"+asignatura.getNombre()+"', '"+asignatura.getEnlace()+"');";
				
				String sql = "INSERT INTO asignatura(id_asignatura, id_horario, nombre, enlace) VALUES ('0','"+asignatura.getHorario().getId_horario()+"','"+asignatura.getNombre()+"','"+asignatura.getEnlace()+"')";
				
				rowInserted = statement.executeUpdate(sql) > 0;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowInserted;
	}
	
	public static List<Asignatura> seleccionarAsignaturas(){
		List<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
		Conexion con = new Conexion();
		ResultSet rs;
		connection = con.getJdbcConnection();
		try {
			String sql = "SELECT id_asignatura, asignatura.id_horario, asignatura.nombre, enlace, horario.id_horario ,horario.nombre, horario.curso, horario.descripcion  FROM asignatura,horario  WHERE asignatura.id_asignatura = horario.id_horario;";
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				listaAsignaturas.add(new Asignatura(rs.getInt(1),new Horario(rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)),rs.getString(3),rs.getString(4)));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaAsignaturas;
	}
	
	public static List<Asignatura> verAsignaturasDeUnHorario(String nameHorario){
		List<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
		Conexion con = new Conexion();
		ResultSet rs;
		connection = con.getJdbcConnection();
		try {
			if(HorarioDAO.isHorarioInBD(nameHorario)!=0) {
				int idHorario = HorarioDAO.isHorarioInBD(nameHorario);
				String sql = "SELECT id_asignatura, asignatura.id_horario, asignatura.nombre, enlace, horario.id_horario ,horario.nombre, horario.curso, horario.descripcion FROM asignatura,horario WHERE asignatura.id_asignatura = horario.id_horario AND horario.id_horario = "+idHorario+";";
				Statement statement = connection.createStatement();
				rs = statement.executeQuery(sql);
				while(rs.next()) {
					listaAsignaturas.add(new Asignatura(rs.getInt(1),new Horario(rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)),rs.getString(3),rs.getString(4)));
				}
			}else {
				System.out.println("El nombre del horario no se encuentra en la Base de Datos.");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaAsignaturas;
	}
	
	public static boolean BorrarAsignatura(int id) {
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();
		boolean rowDeleted=false;
		try {
			Statement statement = connection.createStatement();
			
			String sql = "DELETE FROM asignatura WHERE id_asignatura="+id;
			rowDeleted = statement.executeUpdate(sql) > 0;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	public static int isAsignaturaInBD(String nombre) {
		List<Asignatura> listaAsignatura = new ArrayList<Asignatura>();
		ResultSet rs;
		int idAsignatura = 0;
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();	
		try {
			Statement statement = connection.createStatement();
		    String sql= "select id_asignatura from asignatura where nombre ='"+nombre+"'";
			rs=statement.executeQuery(sql);
			if(rs.next()) {
				idAsignatura=rs.getInt(1);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return idAsignatura;
	}
}
