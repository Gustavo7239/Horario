package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.data.Horario;

public class HorarioDAO {
	private static Connection connection;
	
	public static void insertarUnHorario(Horario horario) {
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();
		
		try {
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO horario VALUES (0,'"+ horario.getNombre()+"', '"+horario.getCurso()+"', '"+horario.getDescripcion()+"');";
			boolean rowInserted = statement.executeUpdate(sql) > 0;	
					
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertarUnHorarioSinId(Horario horario) {
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO horario (nombre, curso, descripcion) VALUES ('"+horario.getNombre()+"', '"+horario.getCurso()+"', '"+horario.getDescripcion()+"');";
			boolean rowInserted = statement.executeUpdate(sql) > 0;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean borrarHorario(int id) {
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();
		boolean rowDeleted=false;
		try {
			
			Statement statement = connection.createStatement();
			String sql = "DELETE FROM horario WHERE id_horario = "+id;
			rowDeleted = statement.executeUpdate(sql) > 0;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	public static List<Horario> seleccionarHorarios(){
		List<Horario> listaHorarios = new ArrayList<Horario>();
		ResultSet rs;
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM horario";
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				listaHorarios.add(new Horario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listaHorarios;
	}
	
	public static int isHorarioInBD(String nombre) {
		List<Horario> listaHorarios = new ArrayList<Horario>();
		ResultSet rs;
		int idHorario = 0;
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();	
		try {
			Statement statement = connection.createStatement();
		    String sql= "select id_horario from horario where nombre ='"+nombre+"'";
			rs=statement.executeQuery(sql);
			if(rs.next()) {
				idHorario=rs.getInt(1);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return idHorario;
	}
}
