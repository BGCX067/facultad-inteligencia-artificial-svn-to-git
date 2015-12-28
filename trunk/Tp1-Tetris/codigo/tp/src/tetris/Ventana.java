package tetris;

import java.util.*;

public class Ventana {
	
	public static final int alto = 20;
	public static final int ancho = 10;
	private Set<Coordenada> ocupados;
	
	public Ventana(){
		
		ocupados = new HashSet<Coordenada>();
	}

	public Jugada colocar(Set<Coordenada> pieza, int ancho, int alto, int desplazamiento){
		
		Coordenada actual;
		boolean toco;
		int lineas;
		int superior;
		int inferior;
		boolean todas;
		boolean encontre;
		int borde;
		Set<Coordenada> nuevasCoordenadas = new HashSet<Coordenada>();
		
		//Bajo la pieza hasta que toque las demas:
		
		actual = new Coordenada(Ventana.alto + 1, desplazamiento);
		toco = false;
		
		do {
			
			actual = new Coordenada(actual.getFila() - 1, actual.getColumna());
			
			for(int j = 1; j <= ancho && !toco; j++){
				
				borde = -1;
				
				for(int i = 1; i <= alto && borde == -1; i++)
					if(pieza.contains(new Coordenada (alto - i + 1, j)))
						borde = alto - i + 1;

				toco = ocupados.contains(new Coordenada (actual.getFila() + (alto - borde) - 1, actual.getColumna() + j - 1));
			}
				
			if(actual.getFila() == 1) toco = true;
			
		} while (!toco);
		
		//Si se pasa de la pantalla pierde:
		
		if(actual.getFila() + alto - 1 <= Ventana.alto){
		
			//Pongo la pieza:
			
			for(int i = 1; i <= alto; i++)
				for(int j = 1; j <= ancho; j++)
					if(pieza.contains(new Coordenada(alto - i + 1,j))){ 
					
						Coordenada nuevaCoordenada = new Coordenada(actual.getFila() + i - 1, actual.getColumna() + j - 1);
						ocupados.add(nuevaCoordenada);
						nuevasCoordenadas.add(nuevaCoordenada); 
					}
			
			lineas = 0;
			inferior = 1;
			superior = actual.getFila() + alto - 1;
		
			do {
			
				//Busca si se formaron lineas formadas:
				
				encontre = false;
				
				for(int i = inferior; i <= superior && !encontre; i++){
					
					todas = true;
					
					for(int j = 1; j <= Ventana.ancho && todas; j++)
						todas = ocupados.contains(new Coordenada(i,j));
					
					if(todas){
						
						//Si encuentra una linea la saca y vuelve a empezar hasta que no encuentre mas lineas:
						
						encontre = true;
						lineas++;
						superior--;
						inferior = i;
						
						for(int k = i; k <= Ventana.alto; k++){
							
							for(int j = 1; j <= Ventana.ancho; j++){
								
								if(ocupados.contains(new Coordenada(k,j))){
									ocupados.remove(new Coordenada(k,j));
									if(k != i) ocupados.add(new Coordenada(k-1,j));
								}
							}
						}
					}
				}
			
			} while (encontre);
			
		} else {
			
			lineas = -1;
		}
		
		//Al final devuelve todas las lineas que encontro:
		
		return new Jugada(nuevasCoordenadas, lineas);
	}

	public Ventana clone(){
		
		Ventana ventana;
		
		ventana = new Ventana();
		
		for(Coordenada c : ocupados) ventana.ocupados.add(c);
		
		return ventana;
	}
	
	public boolean equals(Object objeto){
		
		Ventana ventana;
		boolean iguales;
		
		ventana = (Ventana) objeto;
		iguales = ocupados.containsAll(ventana.ocupados) &&
				  ventana.ocupados.containsAll(ocupados);
		
		return iguales;
	}
	
	public int hashCode(){
		
		int numero;
		
		numero = ocupados.size();
		
		return numero;
	}
	
	//Debugging:
	
	public String toString(){
		
		String cadena;	
		
		cadena = new String("");
		
		for(int i = 1; i <= Ventana.alto; i++){
			 
			cadena = cadena + "| ";
			
			for(int j = 1; j <= Ventana.ancho; j++){
				
				if(ocupados.contains(new Coordenada(Ventana.alto - i + 1, j))){
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

	public boolean ocupado(Coordenada coordenada){
		return ocupados.contains(coordenada);
	}
	
	public int ocupados(){
		
		int ocupados;
		
		ocupados = this.ocupados.size();
		
		return ocupados;
	}
	
	public boolean ocupadoOFueraDeTablero(Coordenada coordenada){
		
		if( coordenada.getFila()<1 || coordenada.getFila()>Ventana.alto)
			return true;
		else if(coordenada.getColumna()<1 || coordenada.getColumna()>Ventana.ancho)
			return true;
		else
			return ocupados.contains(coordenada);
	
	}

	public int getMaximaFilaOcupada() {
		return getMaximaFilaOcupada(null);
	}
	public int getMaximaFilaOcupada(Integer columna) {
		int maxFila =0 ;
		for (Coordenada coordenada : ocupados) {
			if(coordenada.getFila()>maxFila  && (columna==null ||coordenada.getColumna()== columna.intValue())){
				maxFila = coordenada.getFila();
			}
		}
		return maxFila;
	}
	
	public int getCantidadHuecos(){
		int hueco=0;
		for (int i = 1; i < Ventana.ancho; i++) {
			for (int j = 1; j < Ventana.alto; j++) {
				if(!ocupado(new Coordenada(i,j)) && i<getMaximaFilaOcupada(j))
				{
				hueco++;
				}
			}
		}
		return hueco;
	}
}
