package control;

import java.util.Scanner;

import modelo.dao.AsignaturaDAO;
import modelo.dao.HorarioDAO;
import modelo.data.Horario;
import vista.Menu;

public class Principal {

	public static void main(String[] args) {
		/*
		System.out.println("...................................");
		
		Horario h1 = new Horario(0, "miMiniHorario100","DAM", null);
		HorarioDAO.insertarUnHorario(h1);
		
		HorarioDAO.seleccionarHorarios().forEach(System.out::println);
		
		System.out.println(HorarioDAO.isHorarioInBD("miMiniHorario100"));
		
		HorarioDAO.borrarHorario(HorarioDAO.isHorarioInBD("miMiniHorario100"));
		System.out.println("...................................");
		
		HorarioDAO.seleccionarHorarios().forEach(System.out::println);
		*/
		
		while(true) {
			int valor = Menu.Principal();
			switch(valor) {
				case 1 -> VerTodosLosHorarios();
				case 2 -> VerTodasLasAsignaturas();
				case 3 -> VerLasAsignaturarDeUnHorario();
				case 4 -> CrearUnHorario();
				case 5 -> CrearUnaAsignatura();
				case 6 -> ModificarUnHorario();
				case 7 -> ModificarUnaAsignatura();
				case 8 -> BorrarUnHorario();
				case 9 -> BorrarUnaAsignatura();
			}
			Menu.continuar();
		}
	}

	private static void VerLasAsignaturarDeUnHorario() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca el nombre del horario para hacer la consulta: \n> ");
		String name = teclado.nextLine();
		AsignaturaDAO.verAsignaturasDeUnHorario(name).forEach(System.out::println);
	}

	private static void VerTodasLasAsignaturas() {
		AsignaturaDAO.seleccionarAsignaturas().forEach(System.out::println);
	}

	private static void VerTodosLosHorarios() {
		Menu.generarTablaHorarios(HorarioDAO.seleccionarHorarios());
	}

	private static void BorrarUnaAsignatura() {
	}

	private static void BorrarUnHorario() {
	}

	private static void ModificarUnaAsignatura() {
	}

	private static void ModificarUnHorario() {
	}

	private static void CrearUnaAsignatura() {
	}

	private static void CrearUnHorario() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca el nombre de su horario: \n> ");
		String nombreHorario = teclado.nextLine();
		System.out.print("Introduzca el nombre del curso: \n> ");
		String nombreCurso = teclado.nextLine();
		System.out.print("Introduzca una descripcion: \n> ");
		String descripcion = teclado.nextLine();
		
		Horario h = new Horario(0, nombreHorario, nombreCurso, descripcion);
		HorarioDAO.insertarUnHorarioSinId(h);
		System.out.println("Se ha introducido el horario correctamente.");
	}

}
