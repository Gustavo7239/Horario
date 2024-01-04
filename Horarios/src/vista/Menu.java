package vista;

import java.util.List;
import java.util.Scanner;

import modelo.data.Horario;

public class Menu {
	
	public static void MenuBienvenida() {
		System.out.println("Bienvenida");
	}
	
	public static int Principal() {
		while(true) {
			Scanner teclado = new Scanner(System.in);
			System.out.println("______________[HORARIOS]______________");
			//Select
			System.out.println("1. Ver todos los horarios");
			System.out.println("2. Ver todas las asignaturas");
			System.out.println("3. Ver las asignaturas de un horario");
			System.out.println("4. Ver todos los recursos de una asignatura"); //Nuevo
			//Insert
			System.out.println("5. Crear un horario");
			System.out.println("6. Crear una asignatura de un horario");
			System.out.println("7. Crear un recurso");						  //Nuevo
			System.out.println("8. Agregar un recurso a una asignatura");      //Nuevo
			//Update
			System.out.println("9. Modificar un horario");
			System.out.println("10. Modificar una asignatura");
			System.out.println("11. Modificar un recurso");   				  //Nuevo
			//Delete
			System.out.println("12. Borrar un horario");
			System.out.println("13. Borrar una asignatura");
			System.out.println("14. Borrar un recurso");      				  //Nuevo
			System.out.println("______________________________________");
			System.out.print("> ");
			
			try {
				int respuesta = teclado.nextInt();
				if(respuesta<1 || respuesta>14) {
					System.out.println("[ERROR]: El valor introducido esta fuera de los limites.");
					continuar();
					}
				else return respuesta;
			}catch (Exception e) {
				System.out.println("[ERROR]: El valor introducido no es un numero.");
				continuar();
			}
		}
	}
	
	public static void continuar() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Pulse ENTER para continuar.");
		String linea = teclado.nextLine();
	}
	
	public static void generarTablaHorarios(List<Horario> horarios) {
        // Verificar si la lista está vacía
        if (horarios == null || horarios.isEmpty()) {
            System.out.println("La lista de horarios está vacía.");
            return;
        }

        // Obtener el número de atributos
        int numAtributos = Horario.class.getDeclaredFields().length;

        // Construir la tabla con StringBuilder
        StringBuilder tabla = new StringBuilder();

        //tabla.append("____________________________________________________________\n");
        // Encabezado de la tabla
        for (int i = 0; i < numAtributos; i++) {
            tabla.append(String.format("%-15s", "|  " + Horario.class.getDeclaredFields()[i].getName()));
        }
        tabla.append("\n");
        tabla.append("------------------------------------------------------------");
        tabla.append("\n");

        // Filas de datos
        for (Horario horario : horarios) {
            tabla.append(String.format("%-15s", "|  " + horario.getId_horario()));
            tabla.append(String.format("%-15s", "|  " + horario.getNombre()));
            tabla.append(String.format("%-15s", "|  " + horario.getCurso()));
            tabla.append(String.format("%-15s", "|  " + horario.getDescripcion()));
            tabla.append("\n");
        }

        // Imprimir la tabla
        System.out.println(tabla.toString());
    }
}
