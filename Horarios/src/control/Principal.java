package control;

import java.util.Scanner;

import modelo.dao.AsignaturaDAO;
import modelo.dao.HorarioDAO;
import modelo.dao.RecursoDAO;
import modelo.data.Asignatura;
import modelo.data.Horario;
import modelo.data.Recurso;
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
				case 4 -> VerRecursosDeUnaAsignatura();
				case 5 -> CrearUnHorario();
				case 6 -> CrearUnaAsignatura();
				case 7 -> CrearUnRecurso();
				case 8 -> AgregarRecursoAUnaAsignatura();
				case 9 -> ModificarUnHorario();
				case 10 -> ModificarUnaAsignatura();
				case 11 -> ModificarUnRecurso();
				case 12 -> BorrarUnHorario();
				case 13 -> BorrarUnaAsignatura();
				case 14 -> BorrarUnRecurso();
			}
			Menu.continuar();
		}
	}

	private static void BorrarUnRecurso() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Estos son todos los recursos disponibles: ");
		RecursoDAO.todosLosRecursos().forEach(System.out::println);
		System.out.println("Introduzca el nombre del recurso a borrar: \n> ");
		String nombreRecurso = teclado.nextLine();
		if(RecursoDAO.isRecursoInBD(nombreRecurso)!=0) {
			RecursoDAO.borrarUnRecurso(nombreRecurso);
			System.out.println("Se ha borrado exitosamente el recurso: "+nombreRecurso);
		}else {
			System.out.println("[ERROR]: No se ha encontrado el recurso introducido.");
		}
	}

	private static void ModificarUnRecurso() {
		
	}

	private static void AgregarRecursoAUnaAsignatura() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Elija los el nombre de la asignatura a la que pertenecera el recurso: \n> ");
		AsignaturaDAO.seleccionarAsignaturas().forEach(System.out::println);
		String nombreAsignatura = teclado.nextLine();
		int idAsignatura = AsignaturaDAO.isAsignaturaInBD(nombreAsignatura);
		while(idAsignatura == 0) {
			System.out.println("[ERROR]: No existe el nombre de asignatura.");
			System.out.println("Elija los el nombre de la asignatura a la que pertenecera el recurso: \n> ");
			AsignaturaDAO.seleccionarAsignaturas().forEach(System.out::println);
			nombreAsignatura = teclado.nextLine();
			idAsignatura = AsignaturaDAO.isAsignaturaInBD(nombreAsignatura);
		}
		System.out.println("Listo. Asignatura seleccionada.");
		
		while(true) {
			System.out.print("¿Su recurso existe?: \n> ");
			String existe = teclado.nextLine();
			
			if(existe.toLowerCase().equals("no")) {
				System.out.println("Entonces crearemos el Recurso");
				CrearUnRecurso();
				break;
			}else if(existe.toLowerCase().equals("si")) {
				break;
			}else {
				System.out.println("Respuesta incorrecta, introduzca [Si/No]");
			}
		}
		
		System.out.print("Elija el nombre del recurso: \n> ");
		RecursoDAO.todosLosRecursos().forEach(System.out::println);
		String nombreRecurso = teclado.nextLine();
		int idRecurso = RecursoDAO.isRecursoInBD(nombreRecurso);
		while(idRecurso == 0) {
			System.out.println("[ERROR]: No existe el nombre del recurso.");
			System.out.print("Elija el nombre del recurso: \n> ");
			RecursoDAO.todosLosRecursos().forEach(System.out::println);
			nombreRecurso = teclado.nextLine();
			idRecurso = RecursoDAO.isRecursoInBD(nombreRecurso);
		}
		System.out.println("Listo. Recurso seleccionado.");
		
		RecursoDAO.insertarAsignaturaRecurso(idAsignatura, idRecurso);
		System.out.println("Relacion establecida.");
		
	}

	private static void CrearUnRecurso() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca el nombre de su nuevo Recurso: \n> ");
		String nombreRecurso = teclado.nextLine();
		System.out.print("Introduzca el enlace: \n> ");
		String enlaceRecurso = teclado.nextLine();
		RecursoDAO.insertarRecurso(new Recurso(0,nombreRecurso,enlaceRecurso));
	}

	private static void VerRecursosDeUnaAsignatura() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca el nombre de la asignatura para hacer la consulta: \n> ");
		String nombreAsignatura = teclado.nextLine();
		RecursoDAO.todosLosRecursosDeAsignatura(nombreAsignatura).forEach(System.out::println);
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
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduzca el nombre de la asignatura a borrar: \n> ");
		String nombreAsignatura= teclado.nextLine();
		
		int idAsignatura;
		if((idAsignatura = AsignaturaDAO.isAsignaturaInBD(nombreAsignatura))==0) {
			System.out.println("[ERROR]: Nombre de la Asignatura no existe.");
		}else {
			AsignaturaDAO.BorrarAsignatura(idAsignatura);
			System.out.println("Se borro la asignatura exitosamente.");
		}
	}

	private static void BorrarUnHorario() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduzca el nombre del horario a borrar: \n> ");
		String nombreHorario = teclado.nextLine();
		
		int idHorario;
		if((idHorario = HorarioDAO.isHorarioInBD(nombreHorario))==0) {
			System.out.println("[ERROR]: Nombre de horario no existe.");
		}else {
			HorarioDAO.borrarHorario(idHorario);
		}
		
	}

	private static void ModificarUnaAsignatura() {
		
	}

	private static void ModificarUnHorario() {
		
	}

	private static void CrearUnaAsignatura() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduzca el nombre del horario al que pertenece esta asignatura: \n> ");
		String nombreHorario = teclado.nextLine();
		
		int idHorario;
		if((idHorario = HorarioDAO.isHorarioInBD(nombreHorario))==0) {
			System.out.println("[ERROR]: Nombre de horario no existe.");
		}else {
			Horario horarioConsulta = HorarioDAO.encontrarHorarioPorId(idHorario);
			
			System.out.print("Introduzca el nombre de la nueva asignatura: \n> ");
			String nombreAsignatura = teclado.nextLine();
			
			System.out.print("Ahora introduzca un enlace: \n> ");
			String enlace = teclado.nextLine();
			
			Asignatura a =new Asignatura(0,horarioConsulta,nombreAsignatura,enlace);
			System.out.println("introduciendo...");
			
			AsignaturaDAO.insertaUnaAsignatura(a);
			
		}
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
