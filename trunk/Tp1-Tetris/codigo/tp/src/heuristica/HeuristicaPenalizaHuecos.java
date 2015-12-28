package heuristica;

import tetris.Coordenada;	
import tetris.Movimiento;
import tetris.Pantalla;
import tetris.Ventana;
import aima.search.framework.HeuristicFunction;

public class HeuristicaPenalizaHuecos extends HeuristicaPuntosMovimiento {

	
	public double getHeuristicValue(Object estado) {

		Pantalla pantalla = (Pantalla) estado;
		Coordenada coordenada = new Coordenada(0,0);
		int cantHuecos = getHuecos(pantalla, coordenada);
		
		return 1900 - pantalla.getIndice()*10+ cantHuecos*31 - Pantalla.tabla(pantalla.getUltimaJugada().lineasHechas)*13+pantalla.getVentana().getMaximaFilaOcupada()*17- pantalla.getVentana().getCantidadHuecos()*2;
	}
	private int getHuecos(Pantalla pantalla, Coordenada coord) {
		Ventana ventana = pantalla.getVentana();
		int cantHuecos = 0;
		Coordenada mejorCoordenada = null;
		for (Coordenada c : pantalla.getUltimaJugada().coordenadas) {
			int fila = c.getFila();
			int col = c.getColumna();
			// si dejo un hueco derecho 
			if(!ventana.ocupadoOFueraDeTablero(new Coordenada(fila, col+1)) &&
					ventana.ocupado(new Coordenada(fila, col+2)) &&
					pantalla.getUltimaJugada().coordenadas.contains(new Coordenada(fila+1, col+1))){
				cantHuecos ++;
			}
			// si dejo un hueco izquierdo
			if(!ventana.ocupadoOFueraDeTablero(new Coordenada(fila, col-1)) &&
					ventana.ocupado(new Coordenada(fila, col-2)) &&
					pantalla.getUltimaJugada().coordenadas.contains(new Coordenada(fila+1, col-1))){
				cantHuecos ++;
			}
			//  si dejo un hueco abajo
			if(!ventana.ocupadoOFueraDeTablero(new Coordenada(fila-1, col)) && fila>1 )/*&&
					ventana.ocupadoOFueraDeTablero(new Coordenada(fila-2, col)))*/{
				cantHuecos ++;
			}
			if(mejorCoordenada==null ||
					mejorCoordenada.getFila()>c.getFila())
			{
				mejorCoordenada = c;
			}
			
		}
		coord.setFila(mejorCoordenada.getFila());
		return cantHuecos ;//+ mejorCoordenada.getFila();
	}
	public boolean evitar(Pantalla pantalla)
	{
		//double value = getHuecos(pantalla);
		return false;//value > 0;
		
	}
}
