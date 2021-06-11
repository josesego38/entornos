package Escuela_reposteria;

public class Articulos {
	private int id;
	private String Marca;
	private String Articulo;
	private float Precio;
	private int Stock;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getArticulo() {
		return Articulo;
	}
	public void setArticulo(String articulo) {
		Articulo = articulo;
	}
	public float getPrecio() {
		return Precio;
	}
	public void setPrecio(float precio) {
		Precio = precio;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	
	Articulos(){
		this.id=0;
		this.Marca="Dato no introducido";
		this.Articulo="Dato no introducido";
		this.Precio=0;
		this.Stock=0;
	}

}
