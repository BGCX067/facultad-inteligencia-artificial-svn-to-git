package tetris;

import java.util.*;

import heuristica.HeuristicaPenalizaHuecos;
import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Sucesor implements SuccessorFunction {
	
	HeuristicaPenalizaHuecos euristica;
	
	public Sucesor(HeuristicaPenalizaHuecos heuristica){
	 this.euristica= heuristica;
	}
	
	public Sucesor(){

	}

	public List<Successor> getSuccessors(Object objeto){
		
		Pantalla pantalla;
		Pantalla nuevaPantalla;
		List<Successor> sucesores;
		
		pantalla = (Pantalla) objeto;
		
		sucesores = new ArrayList<Successor>();
		ArrayList<Successor> evitados = new ArrayList<Successor>();
		for(Movimiento movimiento : Movimientos.getInstance().getTabla().get(pantalla.getProxima())){
		
			for(int desplazamiento = 1; desplazamiento <= Ventana.ancho - movimiento.ancho + 1; desplazamiento++){

				nuevaPantalla = pantalla.clone();
				nuevaPantalla.mover(movimiento, desplazamiento);
					
				if(nuevaPantalla.getPuntaje() >= 0 ){
						
					if(euristica != null && euristica.evitar(nuevaPantalla))
					{
						evitados.add(new Successor("Pieza: " + pantalla.getProxima() +
													" / Rotaciones: " + movimiento.rotaciones +
													" / Desplazamiento: " + (desplazamiento - 1) +
													" / Puntos totales: " + nuevaPantalla.getPuntaje() + 
													" / Lineas totales: " + nuevaPantalla.getLineas(), nuevaPantalla));
					}
					else
					{
						sucesores.add(new Successor("Pieza " + pantalla.getProxima() +
													" / Rotaciones: " + movimiento.rotaciones +
													" / Desplazamiento: " + (desplazamiento - 1) +
													" / Puntos totales: " + nuevaPantalla.getPuntaje() + 
													" / Lineas totales: " + nuevaPantalla.getLineas(), nuevaPantalla));
					}
				}
			}
		}
		
		/*if(sucesores.isEmpty()){
			return evitados;
		}*/
		
		return sucesores;
	}
}
