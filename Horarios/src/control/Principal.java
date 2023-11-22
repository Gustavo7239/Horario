package control;

import modelo.dao.HorarioDAO;
import modelo.data.Horario;

public class Principal {

	public static void main(String[] args) {
		HorarioDAO.seleccionarHorarios().forEach(System.out::println);
		
		System.out.println("...................................");
		
		Horario h1 = new Horario(0, "miMiniHorario100","DAM", null);
		HorarioDAO.insertarUnHorario(h1);
		
		HorarioDAO.seleccionarHorarios().forEach(System.out::println);
		
		System.out.println(HorarioDAO.isHorarioInBD("miMiniHorario100"));
		
		HorarioDAO.borrarHorario(HorarioDAO.isHorarioInBD("miMiniHorario100"));
		System.out.println("...................................");
		
		HorarioDAO.seleccionarHorarios().forEach(System.out::println);
	}

}
