package modelo.data;

public class Asignatura {
	private int id_asignatura;
	private Horario horario;
	private String nombre;
	private String enlace;
	
	public Asignatura() {
		super();
	}
	public Asignatura(int id_asignatura, Horario horario, String nombre, String enlace) {
		super();
		this.id_asignatura = id_asignatura;
		this.horario = horario;
		this.nombre = nombre;
		this.enlace = enlace;
	}
	
	public int getId_asignatura() {
		return id_asignatura;
	}
	public void setId_asignatura(int id_asignatura) {
		this.id_asignatura = id_asignatura;
	}
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	
	@Override
	public String toString() {
		return "Asignatura [id_asignatura=" + id_asignatura + ", id_horario=" + id_horario + ", nombre=" + nombre
				+ ", enlace=" + enlace + "]";
	}
}
