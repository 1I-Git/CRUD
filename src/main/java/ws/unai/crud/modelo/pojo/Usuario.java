package ws.unai.crud.modelo.pojo;

public class Usuario {

	//Variable
	private int id;
	private String nombre;
	private String correo;
	private String direccion;
	private int telefono;
	
	//Constructores
	public Usuario() {
		super();
	}
	
	public Usuario(int id, String nombre, String correo, String direccion, int telefono) {
		super();
		this.id = 0;
		this.nombre = "nombre_default";
		this.correo = "correo_default";
		this.direccion = "direccion_default";
		this.telefono = 00000000;
	}

	//Getter & Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	//ToSring
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}
	
	
	
}
