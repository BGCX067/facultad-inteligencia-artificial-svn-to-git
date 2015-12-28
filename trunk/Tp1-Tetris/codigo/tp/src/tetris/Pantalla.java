package tetris;

import java.util.*;

public class Pantalla {
	
	private char[] piezas;
	private Ventana ventana;
	private int indice;
	private int puntos;
	private int lineas;
	private Jugada ultimaJugada;
	private double penalizacion;
	private List<String> acciones;
	
	public Pantalla(char[] piezas){
		
		this.piezas = piezas;
		this.ventana = new Ventana();
		this.indice = 0;
		this.puntos = 0;
		this.lineas = 0;
		this.acciones = new LinkedList<String>();
	}
	
	private Pantalla(char[] piezas, Ventana ventana, int indice, int puntos, int lineas, Jugada ultimaJugada, double penalizacion, List<String> acciones){
		
		this.piezas = piezas;
		this.ventana = ventana;
		this.indice = indice;
		this.puntos = puntos;
		this.lineas = lineas;
		this.ultimaJugada = ultimaJugada;
		this.penalizacion= penalizacion;
		this.acciones = acciones;
	}

	public void mover(Movimiento movimiento, int desplazamiento){
		
		Jugada jugada;
		
		jugada = ventana.colocar(movimiento.forma, movimiento.ancho, movimiento.alto, desplazamiento);
			
		indice++;
	
		setPuntaje(jugada.lineasHechas);

		ultimaJugada = jugada;
		
		acciones.add("Pieza: " + movimiento.letra + " / Rotaciones: " + movimiento.rotaciones + " / Desplazamiento: " + (desplazamiento - 1) +
					 " (Lleva " + getPuntaje() + " puntos y " + getLineas() + " lineas)");
	}

	public void optima(Set<Pantalla> soluciones){
		
		Iterator<Pantalla> iterador;
		Pantalla nuevaPantalla;
		int optimo;
		
		//Si quedan piezas por mover las muevo:
		
		if(getProxima() != null){
		
			//Para cada rotacion posible de la pieza actual:
		
			for(Movimiento movimiento : Movimientos.getInstance().getTabla().get(getProxima())){
			
				//Para cada desplazamiento posible de la pieza actual:
			
				for(int desplazamiento = 1; desplazamiento <= Ventana.ancho - movimiento.ancho + 1; desplazamiento++){

					//Muevo la pieza:
				
					nuevaPantalla = clone();
					nuevaPantalla.mover(movimiento, desplazamiento);
						
					//Si no perdio sigo moviendo las demas piezas:
				
					if(nuevaPantalla.getPuntaje() >= 0)
						nuevaPantalla.optima(soluciones);
				}
			}
			
		} else {
		
			//Si no quedan piezas por mover me fijo si el puntaje de la pantalla igual o supero
			//al de las pantallas que son solucion, en ese caso la agrego tambien:
			
			if(soluciones.isEmpty()){
				
				soluciones.add(this);
				
			} else {
				
				iterador = soluciones.iterator();
				optimo = iterador.next().getPuntaje();
				
				if(getPuntaje() > optimo){
					
					//System.out.print("Se ha hallado una solucion que hace " + getPuntaje() + " puntos.\n");
					soluciones.clear();
					soluciones.add(this);
					
				} else if(getPuntaje() == optimo){
					
					soluciones.add(this);
				}
			}
		}
	}
	
	public Pantalla clone(){
		
		Pantalla pantalla;
		List<String> acciones;
		
		acciones = new LinkedList<String>();
		for(int i = 0; i < this.acciones.size(); i++) acciones.add(this.acciones.get(i));
		
		pantalla = new Pantalla(piezas, ventana.clone(), indice, puntos, lineas, this.ultimaJugada,this.penalizacion, acciones);
			
		return pantalla;
	}
	
	public boolean equals(Object objeto){
		
		Pantalla pantalla;
		boolean iguales;
		
		pantalla = (Pantalla) objeto;
		iguales = pantalla.indice == indice && pantalla.puntos == puntos && pantalla.ventana.equals(ventana);
		
		return iguales;
	}
	
	public int hashCode(){
		
		int numero;
		
		numero = ventana.hashCode();
		
		return numero;
	}
	
	public static int tabla(int lineas){
		
		int puntaje;
		
		switch(lineas){
	 	
			case 0: puntaje = 0; break;
			case 1: puntaje = 10; break;
			case 2: puntaje = 30; break;
			case 3: puntaje = 50; break;
			default: puntaje = 80; break;
		}
		
		return puntaje;
	}
	
	//Debugging:
	
	public String toString(){
		
		String cadena;
		
		cadena = new String(ventana.toString() + "Piezas: ");
		
		if(indice < piezas.length){
		
			for(int i = indice ; i < piezas.length; i++){

				cadena = cadena + piezas[i];
				if(i != piezas.length - 1) cadena = cadena + ", ";
			}
			
		} else {
			
			cadena = cadena + "-";
		}
		
		if(puntos >= 0){
			cadena = cadena + "\nPuntos: " + puntos + "\n\n";

		} else {
			cadena = cadena + "\nPuntos: -\n\n";
		}
		
		return cadena;
	}
	
	public void setPuntaje(int lineas) {
		
		if(lineas != -1){
			puntos = puntos + tabla(lineas);
			this.lineas = this.lineas + lineas;
		} else {
			puntos = -1;
			this.lineas = -1;
		}
	}
	
	public int getPuntaje(){
		
		return puntos;
	}
	
	public int getLineas(){
		return lineas;
	}
	
	public List<String> getAcciones(){
		return acciones;
	}
	
	public String getProxima(){
		
		String pieza;
		
		if(indice < piezas.length){
			pieza = new String(piezas[indice] + "");
		} else {
			pieza = null;
		}
		
		return pieza;
	}
	
	public char[] getPiezas(){
		
		return piezas;
	}
	
	public void setIndice(int indice){
		
		this.indice = indice;
	}
	
	public int getIndice(){
		
		return indice;
	}
	
	public Ventana getVentana() {
		return ventana;
	}

	public Jugada getUltimaJugada() {
		return ultimaJugada;
	}

	public void setUltimaJugada(Jugada ultimaJugada) {
		this.ultimaJugada = ultimaJugada;
	}
	
	public double getPenalizacion() {
		return penalizacion;
	}

	public void setPenalizacion(double penalizacion) {
		this.penalizacion += penalizacion;
	}
}

