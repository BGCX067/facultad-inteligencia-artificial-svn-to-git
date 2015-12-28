package tetris;

import java.util.Set;

public class Movimiento {
	
	public String letra;
	public int ancho;
	public int alto;
	public Set<Coordenada> forma;
	public int rotaciones;
	
	Movimiento(String letra, int alto, int ancho, Set<Coordenada> forma, int rotaciones){
		
		this.letra = letra;
		this.ancho = ancho;
		this.alto = alto;
		this.forma = forma;
		this.rotaciones = rotaciones;
	}
	
	//Debugging:
	
	public String toString(){
		
		String cadena;
		
		cadena = new String("");
		
		for(int i = 1; i <= alto; i++){
			
			cadena = cadena + "| ";
			
			for(int j = 1; j <= ancho; j++){
				
				if(forma.contains(new Coordenada(i,j))){
					cadena = cadena + "X ";
				} else {
					cadena = cadena + "- ";
				}
			}
			
			cadena = cadena + "|\n";
		}
		
		cadena = cadena + "\n";
		
		return cadena;
	}		
	
	
}