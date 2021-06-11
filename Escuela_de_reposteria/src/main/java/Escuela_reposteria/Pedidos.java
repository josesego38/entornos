package Escuela_reposteria;

/**
 * @author RUTH
 */

public class Pedidos {
// Al principio de la clase se declaran todas las variables que contendrá la
// clase pedidos

	private String id_pedido;
	private Usuarios id_usuario;
	private Articulos[] id_articulo;
	private float importe;
	private Fecha Fecha_pedido;
	private String[] factura;

	/*
	 * Una vez declaradas, como son privadas se declaran los getters y setters de
	 * cada una para poder acceder a las variables desde otras clases.
	 */
	/**
	 * Metodo para la obtencion del id del pedido
	 * 
	 * @return id_pedido
	 */
	public String getId_pedido() {
		return id_pedido;
	}

	/**
	 * Metodo para introducir el id del pedido
	 * 
	 * @param id_pedido
	 */
	public void setId_pedido(String id_pedido) {
		this.id_pedido = id_pedido;
	}

	/**
	 * Metodo para la obtencon del id del usuario
	 * 
	 * @return id_usario
	 */
	public Usuarios getId_usuario() {
		return id_usuario;
	}

	/**
	 * Metodo para introducir el id del usuario
	 * 
	 * @param id_usuario
	 */
	public void setId_usuario(Usuarios id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * Metodo para la obtencion del id de los articulos
	 * 
	 * @return id_articulo
	 */
	public Articulos[] getId_articulo() {
		return id_articulo;
	}

	/**
	 * Metodo para introducir el id de los articulos
	 * 
	 * @param id_articulo
	 */
	public void setId_articulo(Articulos[] id_articulo) {
		this.id_articulo = id_articulo;
	}

	/**
	 * MEtodo para obtener el importe
	 * 
	 * @return importe
	 */
	public float getImporte() {
		return importe;
	}

	/**
	 * Metodo para introducir el importe
	 * 
	 * @param importe
	 */
	public void setImporte(float importe) {
		this.importe = importe;
	}

	/**
	 * MEtodo para obtener la fecha del pedido
	 * 
	 * @return Fecha_pedido
	 */
	public Fecha getFecha_pedido() {
		return Fecha_pedido;
	}

	/**
	 * Metodo para introducir la fecha del pedido
	 * 
	 * @param fecha_pedido
	 */
	public void setFecha_pedido(Fecha fecha_pedido) {
		Fecha_pedido = fecha_pedido;
	}

	/**
	 * Metodo para obtener la factura
	 * 
	 * @return factura
	 */
	public String[] getFactura() {
		return factura;
	}

	/**
	 * Metodo para introducir la factura
	 * 
	 * @param factura
	 */
	public void setFactura(String[] factura) {
		this.factura = factura;
	}

// El constructor por defecto se encarga de dar un valor por defecto a cada una
// de las variables

	Pedidos() {
		this.id_pedido = "Dato no introducido";
		this.id_usuario = new Usuarios();
		this.id_articulo = new Articulos[0];
		this.importe = 0;
		this.Fecha_pedido = new Fecha();
		this.factura[0] = "Dato no introducido";

	}
}
