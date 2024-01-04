package modelo.dao;

import java.sql.Connection;	
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.data.Asignatura;
import modelo.data.Horario;
import modelo.data.Recurso;

public class RecursoDAO {
	private static Connection connection;
	
	public static void insertarAsignaturaRecurso(int idAsignatura, int idRecurso) {
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();
		try{
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO `asignatura_recurso` (`id_asignatura`, `id_recurso`) VALUES ('"+idAsignatura+"', '"+idRecurso+"')";
			boolean rowInserted = statement.executeUpdate(sql) > 0;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertarRecurso(Recurso recurso) {
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();
		try{
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO `recurso` (`id_recurso`, `nombre`, `enlace`) VALUES ('0', '"+recurso.getNombre()+"', '"+recurso.getEnlace()+"');";
			boolean rowInserted = statement.executeUpdate(sql) > 0;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int isRecursoInBD(String nombreRecurso) {
		ResultSet rs;
		int idResultado = 0;
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();
		try{
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM `recurso` WHERE `nombre` LIKE '"+nombreRecurso+"'";
			rs = statement.executeQuery(sql);
			if(rs.next()) {
				idResultado = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return idResultado;
	}
	
	private static Recurso obtenerRecursoPorId(int idRecurso) {
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();
		ResultSet rs;
		Recurso resultado = new Recurso();
		
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM `recurso` WHERE `id_recurso` = "+idRecurso;
			rs = statement.executeQuery(sql);
			
			if(rs.next()) {
				resultado = new Recurso(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public static List<Recurso> todosLosRecursosDeAsignatura(String nombreAsignatura) {
		List<Recurso> listaRecursos = new ArrayList<Recurso>();
		Conexion con = new Conexion();
		ResultSet rs;
		connection = con.getJdbcConnection();
		int idAsignatura = AsignaturaDAO.isAsignaturaInBD(nombreAsignatura);
		
		try {
			String sql = "SELECT * FROM `asignatura_recurso` WHERE `id_asignatura` = "+idAsignatura+"";
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				listaRecursos.add(obtenerRecursoPorId(rs.getInt(2)));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaRecursos;
	}
	
	public static List<Recurso> todosLosRecursos() {
		List<Recurso> listaRecursos = new ArrayList<Recurso>();
		Conexion con = new Conexion();
		ResultSet rs;
		connection = con.getJdbcConnection();
		
		try {
			String sql = "SELECT * FROM `recurso`";
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				listaRecursos.add(obtenerRecursoPorId(rs.getInt(1)));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listaRecursos;
	}
	
	public static void borrarUnRecursoAsignatura(int idRecurso) {
		ResultSet rs;
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();
		try{
			
			Statement statement = connection.createStatement();
			String sql = "DELETE FROM `asignatura_recurso` WHERE `id_recurso` LIKE "+idRecurso;
			rs = statement.executeQuery(sql);
			boolean rowInserted = statement.executeUpdate(sql) > 1;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void borrarUnRecurso(String nombreRecurso) {
		ResultSet rs;
		int idRecurso = isRecursoInBD(nombreRecurso);
		Conexion con = new Conexion();
		connection = con.getJdbcConnection();
		try{
			borrarUnRecursoAsignatura(idRecurso);
			
			Statement statement = connection.createStatement();
			String sql = "DELETE FROM `recurso` WHERE `recurso`.`id_recurso` = "+idRecurso;
			rs = statement.executeQuery(sql);
			boolean rowInserted = statement.executeUpdate(sql) > 1;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
