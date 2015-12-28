package main;

import tetris.*;
import java.io.*;

public class Juego {

	public static void jugar(char[] piezas){
		
		Pantalla pantalla;
		String cadena;
		String pieza;
		Movimiento movimiento;
		int rotaciones;
		int desplazamiento;
		boolean seguir;
		
		System.out.print("Bienvenido al Tetris!\n\nLos teclas son:\n");
		System.out.print("1-Rotar/desplazar pieza a la derecha\n");
		System.out.print("2-Rotar/desplazar pieza a la izquierda\n");
		System.out.print("3-Continuar\n");
		System.out.print("4-Salir\n\n");
		
		pantalla = new Pantalla(piezas);
		
		cadena = null;
		
		while(pantalla.getProxima() != null && pantalla.getPuntaje() >= 0){
			
			pieza = pantalla.getProxima();
			rotaciones = 0;
			desplazamiento = 1;
			
			//Se gira la pieza:
			
			do {

				movimiento = buscar(pieza, rotaciones);
				
				System.out.print(redibujar(movimiento, desplazamiento));
				System.out.print(redibujar(pantalla));
				//new heuristica.HeuristicaCuadradosNoMoviles().getMaximoPuntaje(pantalla);
				System.out.print("Rotar la pieza? ");

				cadena = consola().toUpperCase();
				
				seguir = false;
				
				if(cadena.equals("1")){
					rotaciones = siguiente(pieza, rotaciones);
				} else if (cadena.equals("2")){
					rotaciones = anterior(pieza, rotaciones);
				} else if (cadena.equals("3") || cadena.equals("4")) {
					seguir = true;
				}
				
				System.out.print("\n");
			
			} while (!seguir);
			
			if(cadena.equals("4")) break;
			
			//Se mueve la pieza:
			
			do {

				System.out.print(redibujar(movimiento, desplazamiento));
				System.out.print(redibujar(pantalla));
				System.out.print("Desplazar la pieza? ");

				cadena = consola().toUpperCase();
				
				seguir = false;
				
				if(cadena.equals("1")){
					
					desplazamiento--;
					if (desplazamiento == 0) desplazamiento = 1;
				
				} else if (cadena.equals("2")){
					
					desplazamiento++;
					if (desplazamiento == Ventana.ancho - movimiento.ancho + 2)
						desplazamiento = Ventana.ancho - movimiento.ancho + 1;
					
				} else if (cadena.equals("3") || cadena.equals("4")) {
					
					seguir = true;
				}
				
				System.out.print("\n");
			
			} while (!seguir);
			
			if(cadena.equals("4")) break;
			
			//Se ubica la pieza:
			
			pantalla.mover(movimiento, desplazamiento);
		}
		
		if(!cadena.equals("4")) System.out.print(redibujar(pantalla));
		System.out.print("Game over!" + "\n\n");
	}
	
	public static String redibujar(Movimiento movimiento, int desplazamiento){
		
		String nuevo;
		String espacio;
		String[] partes;
		
		nuevo = new String("");
		espacio = new String("");
		
		for(int j = 1; j < desplazamiento; j++) espacio = espacio + "  ";
		
		partes = movimiento.toString().split("\n");
		
		for(int i = 0; i < partes.length; i++)
			nuevo = nuevo + espacio + partes[i] + "\n";

		nuevo = nuevo.replace('|', ' ').replace('-', ' ') + "\n";
		
		return nuevo;
	}
	
	public static String redibujar(Pantalla pantalla){
		
		String nuevo;
		String[] partes;
		String piezas;
		String puntos;
		
		nuevo = new String("");
		
		partes = pantalla.toString().split("\n");
		
		piezas = partes[Ventana.alto + 1];
		puntos = partes[Ventana.alto + 2];
		
		for(int i = 0; i < partes.length; i++){
			
			if(!partes[i].equals("") && partes[i].charAt(0) == '|'){
				
				nuevo = nuevo + partes[i];
				
				if(i == 0){
					nuevo = nuevo + "  " + piezas + "\n";
				} else if (i == 1){
					nuevo = nuevo + "  " + puntos + "\n";
				} else {
					nuevo = nuevo + "\n";
				}
			}
		}
		
		nuevo = nuevo + "\n";
		
		return nuevo;
	}
	
	public static int anterior(String pieza, int rotaciones){
		
		int anterior;
		
		if(pieza.equals("O")){
			anterior = 0;
		} else if (pieza.equals("I") || pieza.equals("S") || pieza.equals("Z")){
			anterior = rotaciones - 1;
			if(anterior < 0) anterior = 1;
		} else {
			anterior = rotaciones - 1;
			if(anterior < 0) anterior = 3;
		}
		
		return anterior;
	}
	
	public static int siguiente(String pieza, int rotaciones){
		
		int siguiente;
		
		if(pieza.equals("O")){
			siguiente = 0;
		} else if (pieza.equals("I") || pieza.equals("S") || pieza.equals("Z")){
			siguiente = rotaciones + 1;
			if(siguiente > 1) siguiente = 0;
		} else {
			siguiente = rotaciones + 1;
			if(siguiente > 3) siguiente = 0;
		}
		
		return siguiente;
	}
	
	public static String consola(){
		 
		String cadena;
		BufferedReader buffer;

		cadena = new String("");

		try {

			buffer = new BufferedReader(new InputStreamReader(System.in));
			cadena = buffer.readLine();

		} catch(Exception e){ e.printStackTrace(); }

		return cadena;
	}
	
	public static Movimiento buscar(String pieza, int rotaciones){
		
		Movimiento buscado;
		
		buscado = null;
		
		for(Movimiento movimiento : Movimientos.getInstance().getTabla().get(pieza))
			if(movimiento.rotaciones == rotaciones)
				buscado = movimiento;
		
		return buscado;
	}
}
