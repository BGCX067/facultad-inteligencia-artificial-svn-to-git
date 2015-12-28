package main;

import java.util.Random;
import tetris.*;

public class Auxiliares {
	
	public static char[] aleatoria(int cantidad){
		
		char[] aleatoria;
		Random generador;
		int pieza;
		
		generador = new Random();
		aleatoria = new char[cantidad];
		
		for(int i = 0; i < cantidad; i++){
			
			pieza = generador.nextInt() % 7;
			
			switch(pieza * Integer.signum(pieza)){
			 	
			 	case 0: aleatoria[i] = 'I'; break;
			 	case 1: aleatoria[i] = 'J'; break; 
			 	case 2: aleatoria[i] = 'L'; break; 
			 	case 3: aleatoria[i] = 'O'; break; 
			 	case 4: aleatoria[i] = 'S'; break; 
			 	case 5: aleatoria[i] = 'T'; break;
			 	case 6: aleatoria[i] = 'Z'; break; 
			 }
		}
		
		return aleatoria;
	}
	
	public static long tamano(char[] piezas){
		
		long tamano;
		
		tamano = 1;
		
		for(int i = 0; i < piezas.length; i++){
			
			if(piezas[i] == 'I'){
		 		tamano = tamano * (1 * (Ventana.ancho - 1 + 1) + 1 * (Ventana.ancho - 4 + 1));
			} else if(piezas[i] == 'J' || piezas[i] == 'L' || piezas[i] == 'T'){		
		 		tamano = tamano * (2 * (Ventana.ancho - 2 + 1) + 2 * (Ventana.ancho - 3 + 1));
			} else if (piezas[i] == 'O'){
	 			tamano = tamano * (1 * (Ventana.ancho - 2 + 1));
			} else {
	 			tamano = tamano * (1 * (Ventana.ancho - 3 + 1) + 1 * (Ventana.ancho - 2 + 1));
			}
		}
		
		return tamano;
	}
}
