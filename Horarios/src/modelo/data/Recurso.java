package modelo.data;

public class Recurso {
	private int id_recurso;
	private String nombre;
	private String enlace;
	
	public Recurso() {
		super();
	}
	
	public Recurso(int id_recurso, String nombre, String enlace) {
		super();
		this.id_recurso = id_recurso;
		this.nombre = nombre;
		this.enlace = enlace;
	}

	public int getId_recurso() {
		return id_recurso;
	}

	public void setId_recurso(int id_recurso) {
		this.id_recurso = id_recurso;
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
		return "Recurso [id_recurso=" + id_recurso + ", nombre=" + nombre + ", enlace=" + enlace + "]";
	}
}
