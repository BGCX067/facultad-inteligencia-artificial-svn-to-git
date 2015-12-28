package tetris;

public class Coordenada {
	
	public Coordenada(int fila, int columna){
		
		this.fila = fila;
		this.columna = columna;
	}
	
	public boolean equals(Object objeto){
		
		boolean iguales;
		
		iguales = objeto.hashCode() == this.hashCode();
		
		return iguales;
	}
	
	public int hashCode(){
		
		int numero;
		
		numero = fila * 10 + columna;
		
		return numero;
	}
		
	public int getFila(){
		
		return fila;
	}
	
	public int getColumna(){
		
		return columna;
	}
	
	//Debugging:
	
	public String toString(){
		
		String cadena;
		
		cadena = "(" + fila + ", " + columna + ")";
		
		return cadena;
	}
	
	private int fila;
	private int columna;
	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
}

