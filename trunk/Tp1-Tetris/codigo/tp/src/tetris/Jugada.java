package tetris;

import java.util.Set;

public  class Jugada{
	public Movimiento movimiento;
	public int puntos;
	public int lineasHechas;
	public Set<Coordenada> coordenadas ;
	public Jugada(Movimiento movimiento, int puntos){
		this.movimiento = movimiento;
		this.puntos = puntos;
		
	}
	public Jugada(Set<Coordenada> coordenada, int lineasHechas){
		this.coordenadas = coordenada;
		this.lineasHechas = lineasHechas;
	}
}