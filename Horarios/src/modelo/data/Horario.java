package modelo.data;

public class Horario {
	private int id_horario;
	private String nombre;
	private String curso;
	private String descripcion;
	
	public Horario() {
		super();
	}
	public Horario(int id_horario, String nombre, String curso, String descripcion) {
		super();
		this.id_horario = id_horario;
		this.nombre = nombre;
		this.curso = curso;
		this.descripcion = descripcion;
	}
	
	public int getId_horario() {
		return id_horario;
	}
	public void setId_horario(int id_horario) {
		this.id_horario = id_horario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Horario [id_horario=" + id_horario + ", nombre=" + nombre + ", curso=" + curso + ", descripcion="
				+ descripcion + "]";
	}
}
