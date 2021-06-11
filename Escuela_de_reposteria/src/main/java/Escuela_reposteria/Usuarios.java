package Escuela_reposteria;

public class Usuarios {

	/**
	 * @author RUTH
	 */

	// Declara las variables de las que estará formada la clase
	private int ID;
	private String Nombre;
	private String Apellido;
	private Fecha FNacimiento;
	private String DNI;
	private String Telefono;
	private String Contrasena;
	private String Nivel;

	/*
	 * Genera los getters y setters de cada una de las variables ya que son
	 * privadas. De esta manera se puede acceder a estas variables desde otra clase.
	 */
	/**
	 * Metodo para obtener la id del usuario
	 * 
	 * @return ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Metodo para introducir la id del usuario
	 * 
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Metodo para obtener el nombre del usuario
	 * 
	 * @return Nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * Metodo para introducir el nombre de usuario
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	/**
	 * Metodo para obtener el apellido del usuario
	 * 
	 * @return Apellido
	 */
	public String getApellido() {
		return Apellido;
	}

	/**
	 * Metodo para introducir el apellido
	 * 
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	/**
	 * Metodo para obtener la fecha de nacimeinto
	 * 
	 * @return FNacimiento
	 */
	public Fecha getFNacimiento() {
		return FNacimiento;
	}

	/**
	 * Metodo para introducir la fecha de nacimiento
	 * 
	 * @param fNacimiento
	 */
	public void setFNacimiento(Fecha fNacimiento) {
		FNacimiento = fNacimiento;
	}

	/**
	 * Metodo para obtener el Dni del ususario
	 * 
	 * @return DNI
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * Metodo para introducir el DNI del usuario
	 * 
	 * @param dNI
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	/**
	 * Metodo para obtener el telefono de cada usuario
	 * 
	 * @return Telefono
	 */
	public String getTelefono() {
		return Telefono;
	}

	/**
	 * Metodo para introducir el telefono del usuario
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	/**
	 * Metodo para obtenr la contrasena del usuario
	 * 
	 * @return Contrasena
	 */
	public String getContrasena() {
		return Contrasena;
	}

	/**
	 * Metodo para introduir la contrasena
	 * 
	 * @param contrasena
	 */
	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

	/**
	 * Metodo para obtener el nivel del usuario
	 * 
	 * @return Nivel
	 */
	public String getNivel() {
		return Nivel;
	}

	/**
	 * Metodo para introducir el Nivel del usuario
	 * 
	 * @param nivel
	 */
	public void setNivel(String nivel) {
		Nivel = nivel;
	}

	Usuarios() { // El constructor por defecto da valores por defecto a las variables
		this.ID = 1111;
		this.Nombre = "Datos no introducidos";
		this.Apellido = "Datos no introducidos";
		this.FNacimiento = new Fecha();
		this.DNI = "Datos no introducidos";
		this.Telefono = "Datos no introducidos";
		this.Contrasena = "Dato no introducido";
		this.Nivel = "Datos no introducidos";
	}

	// El método infoUsuario se encarga de imprimir la información del usuario

	void infoUsuario() {
		System.out.println("ID: " + this.ID);
		System.out.println("Nombre: " + this.Nombre);
		System.out.println("Apellido: " + this.Apellido);
		System.out.println("Fecha de nacimiento " + this.FNacimiento.Imprimir());
		System.out.println("DNI: " + this.DNI);
		System.out.println("Teléfono: " + this.Telefono);
		System.out.println("Contrasena: " + this.Contrasena);
		System.out.println("Nivel: " + this.Nivel);
	}

	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param FechaNacimiento
	 * @param dni
	 * @param telef
	 * @param contrasena
	 * @param nivel
	 * 
	 *                        Este método se encarga de guardar información en cada
	 *                        una de las variables de la clase
	 */

	Usuarios(int id, String nombre, String apellido, Fecha FechaNacimiento, String dni, String telef, String contrasena,
			String nivel) {
		this.ID = id;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.FNacimiento = FechaNacimiento;
		this.DNI = dni;
		this.Telefono = telef;
		this.Contrasena = contrasena;
		this.Nivel = nivel;
	}
}
