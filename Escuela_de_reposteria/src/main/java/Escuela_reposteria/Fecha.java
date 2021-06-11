package Escuela_reposteria;

public class Fecha {
	private int dia;
	private int mes;
	private int ano;
	
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	Fecha(){
		this.dia=1;
		this.mes=1;
		this.ano=1111;
	}
	
	Fecha(int d, int m, int a){
		this.dia=d;
		this.mes=m;
		this.ano=a;
	}
	
	Fecha(String a){
		//Con este constructor estamos intentando evitar los posibles errores que podriamos tener a la hora de introducir una fecha.
		//de esta manera, podremos 
		
		if(a.contains("/")) { //Si la fecha introducida contiene barras. 
			String [] f = a.split("/");
			this.dia=Integer.parseInt(f[0]);
			this.mes=Integer.parseInt(f[1]);
			this.ano=Integer.parseInt(f[2]);
		}
		else if(a.contains("-")) {// si la fecha introducida no contiene barras sino que contiene guiones.
			String [] f = a.split("-");
			this.dia=Integer.parseInt(f[2]);
			this.mes=Integer.parseInt(f[1]);
			this.ano=Integer.parseInt(f[0]);
		}
	}
	
	//Para que las consultas queden mas cortas, en lugar de que imprima: el dia primero, 
	//el mes despues y por ultimo el ano, nos lo imprima todo junto ponemos el siguiente siguiente metodo.
		public String mysql() {
			return this.ano+"-"+this.mes+"-"+this.dia;
		}
		
		public String Imprimir() {
			return this.ano+"/"+this.mes+"/"+this.dia;
		}
}
