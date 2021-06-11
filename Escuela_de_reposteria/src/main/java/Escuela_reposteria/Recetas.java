package Escuela_reposteria;

import java.util.Scanner;

/**
 * Clase para la introduccion de recetas
 * 
 * @author Ruth
 *
 */
public class Recetas {
	// Clase creada para definir todas las variables y metodos que dispondra de la
	// clase receta en nuestro programa

	// Declaracion de variables
	private String Id_receta; // Cada receta tendrá un id único para poder identificarlas.

	private String Nivel; // Nos da el nivel de dificultad de la receta, podremos buscar en funcion del
							// nivel de dificultad de la receta
	private String Título; // Le damos un titulo a la receta, ya que más tarde podremos buscar recetas por
							// su titulo
	private String[] Ingredientes; // Crearemos un array para almacenar los ingredientes ya que posteriormente
									// buscaremos recetas en función de sus ingredientes.
	private String[] Procedimiento; // Creamos un String en el que guardaremos el procedimiento a llevar a cabo para
									// realizar la receta.
	private String Sabor; // Podremos más tarde buacar recetas en función de su sabor.
	private String Tiempo;
	private int num_porciones;
	private String Tipo_postre; // más tarde podremos buscar recetas en funcion del tipo de postre(bizcochos,
								// galletas, cremas...etc).
	private int idUsuario;
	private int Valoracion;

	/**
	 * Metodo creado para obtener el ID de la receta
	 * 
	 * @return ID_receta
	 */
	public String getId_receta() {
		return Id_receta;
	}

	/**
	 * Metodo creado para introducir el id de la receta
	 * 
	 * @param id_receta
	 */
	public void setId_receta(String id_receta) {
		Id_receta = id_receta;
	}

	/**
	 * Metodo creado para obtener el nivel del usuario
	 * 
	 * @return Nivel
	 */
	public String getNivel() {
		return Nivel;
	}

	/**
	 * Metodo creado para introducir el nivel del usuario
	 * 
	 * @param nivel
	 */
	public void setNivel(String nivel) {
		Nivel = nivel;
	}

	/**
	 * Metodo creado para obtener el titulo de la receta
	 * 
	 * @return Titulo
	 */
	public String getTítulo() {
		return Título;
	}

	/**
	 * Metodo creado para introducir el titulo de la receta
	 * 
	 * @param título
	 */
	public void setTítulo(String título) {
		Título = título;
	}

	/**
	 * Metodo creado para obeteer los ingredientes de una receta
	 * 
	 * @return Ingredientes
	 */
	public String[] getIngredientes() {
		return Ingredientes;
	}

	/**
	 * Metodo creado para introducir los ingredientes de una receta
	 * 
	 * @param ingredientes
	 */
	public void setIngredientes(String[] ingredientes) {
		Ingredientes = ingredientes;
	}

	/**
	 * Metodo creado para obtener los pasos de una receta
	 * 
	 * @return Procedimiento
	 */
	public String[] getProcedimiento() {
		return Procedimiento;
	}

	/**
	 * Metodo creado para introducir los pasos de una receta
	 * 
	 * @param procedimiento
	 */
	public void setProcedimiento(String[] procedimiento) {
		Procedimiento = procedimiento;
	}

	/**
	 * Metodo creado para obtener el sabor de una receta
	 * 
	 * @return Sabor
	 */
	public String getSabor() {
		return Sabor;
	}

	/**
	 * Metodo creado para introducir el sabor de una receta
	 * 
	 * @param sabor
	 */
	public void setSabor(String sabor) {
		Sabor = sabor;
	}

	/**
	 * Metodo creado para obtener el tiempo que lleva elaborar la receta
	 * 
	 * @return
	 */
	public String getTiempo() {
		return Tiempo;
	}

	/**
	 * MEtodo para introducir el tiempo que lleva elaborar la receta
	 * 
	 * @param tiempo
	 */
	public void setTiempo(String tiempo) {
		Tiempo = tiempo;
	}

	/**
	 * Metodo para obtener el numero de porciones de esa receta
	 * 
	 * @return num_porciones
	 */
	public int getNum_porciones() {
		return num_porciones;
	}

	/**
	 * Metodo para introducir el numero de porciones de esa receta
	 * 
	 * @param num_porciones
	 */
	public void setNum_porciones(int num_porciones) {
		this.num_porciones = num_porciones;
	}

	/**
	 * Metodo para obtener el tipo de postre
	 * 
	 * @return Tipo_pstre
	 */
	public String getTipo_postre() {
		return Tipo_postre;
	}

	/**
	 * Metodo para introducir el tipo de postre
	 * 
	 * @param tipo_postre
	 */
	public void setTipo_postre(String tipo_postre) {
		Tipo_postre = tipo_postre;
	}

	/**
	 * Metodo para obtener el id del usuario
	 * 
	 * @return idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Metodo para introducir el id del usuario
	 * 
	 * @param idUsuario
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Metodo para obtener la valoracion de una receta
	 * 
	 * @return Valoracion
	 */
	public int getValoracion() {
		return Valoracion;
	}

	/**
	 * Metodo ara introducir la valoracion a una receta
	 * 
	 * @param valoracion
	 */
	public void setValoracion(int valoracion) {
		Valoracion = valoracion;
	}

	/**
	 * metodo para crear Recetas por defecto
	 */
	Recetas() {
		this.Id_receta = "Dato no introducido";
		this.Nivel = "Dato no introducido";
		this.Título = "Dato no introducido";
		this.Ingredientes = new String[0];
		this.Procedimiento = new String[0];
		this.Sabor = "Dato no introducido";
		this.Tiempo = "Dato no introducido";
		this.num_porciones = 1;
		this.Tipo_postre = "Dato no introducido";
		this.idUsuario = 0;
		this.Valoracion = 0;
	}

	/**
	 * Metodo por el cual pide al usuario los datos de las recetas y los guarda en
	 * sus respectivas variables
	 */
	public void DatosRecetas() {
		Scanner t = new Scanner(System.in);
		System.out.println("El ID de la receta se genera de forma automatica");
		this.Id_receta = null;
		System.out.println("¿Que usuario ha creado esta receta?(Introduce tu id)");
		this.idUsuario = t.nextInt();
		System.out.println("¿Cual es el nivel de la receta?");
		this.Nivel = t.next();
		System.out.println("¿Cual es el titulo de la receta?");
		t.nextLine();
		this.Título = t.nextLine();
		System.out.println("¿Cuantos ingredientes tiene la receta?");
		this.Ingredientes = new String[t.nextInt()];
		t.nextLine();
		for (int i = 0; i < this.Ingredientes.length; i++) {
			System.out.println("Introduce un ingrediente " + (i + 1));
			this.Ingredientes[i] = t.nextLine();
		}
		System.out.println("Cuantos pasos tiene la receta");
		this.Procedimiento = new String[t.nextInt()];
		t.nextLine();
		for (int i = 0; i < this.Procedimiento.length; i++) {
			System.out.println("Introduce el paso número " + (i + 1));
			this.Procedimiento[i] = t.nextLine();
		}
		System.out.println("¿Cual es el sabor principal de la receta?");
		this.Sabor = t.nextLine();
		System.out.println("¿Cuanto tiempo tardas en elaborar la receta?");
		this.Tiempo = t.nextLine();
		System.out.println("¿Que tipo de postre es?");
		this.Tipo_postre = t.nextLine();
		System.out.println("¿Cuantas porciones puedes obtener con esta receta?");
		this.num_porciones = t.nextInt();
		System.out.println("Por ultimo, ¿Que valoracion le das a la receta?(Recuerda que será un número del 1 al 5)");
		this.Valoracion = t.nextInt();
	}

}
