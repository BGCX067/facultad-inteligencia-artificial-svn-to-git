package heuristica;

import java.util.*;

import tetris.*;

public class HeuristicaCuadradosNoMoviles extends HeuristicaMaximoPuntaje {

	public double getMaximoPuntaje(Pantalla pantalla){
		
		double maximo;
		boolean tapada;
		boolean vacia;
		int cuadradosEnLinea;
		List<Integer> cuadradosEnLineaAnteriores;
		int puntaje;
		int faltanParaLineas;
		int cuadradosParaLineas;
		List<Integer> ganancia;
		int posicion;
		int base;
		int cuadrados;
		double hechos;

		vacia = false;
		cuadradosEnLinea = 0;
		cuadradosEnLineaAnteriores = new ArrayList<Integer>(Ventana.alto);
		
		faltanParaLineas = 0;
		cuadradosParaLineas = 0;
		
		ganancia = new ArrayList<Integer>();
		ganancia.add(0,0);
		posicion = 1;
		base = 0;
		
		for(int i = 1; i <= Ventana.alto - 1 && !vacia; i++){
			
			tapada = false;
			
			for(int j = 1; j <= Ventana.ancho; j++){
				
				if(!pantalla.getVentana().ocupado(new Coordenada(i,j))){
					if(!tapada && pantalla.getVentana().ocupado(new Coordenada(i+1,j)))
						tapada = true;
				} else {
					cuadradosEnLinea++;
				}
			}
			
			if(cuadradosEnLinea != 0){
	
				cuadradosEnLineaAnteriores.add(cuadradosEnLineaAnteriores.size(), cuadradosEnLinea);
				cuadradosEnLinea = 0;
				
				if(tapada) {
					
					puntaje = 0;
					
					for(int indice = 0; indice < cuadradosEnLineaAnteriores.size(); indice++){
						
						for(int k = 1; k <= Ventana.ancho - cuadradosEnLineaAnteriores.get(indice); k++){
							
							if(k == Ventana.ancho - cuadradosEnLineaAnteriores.get(indice)) puntaje = Pantalla.tabla(indice + 1);
							ganancia.add(posicion, base + puntaje);
							
							posicion++;
						}
						
						cuadradosParaLineas = cuadradosParaLineas + cuadradosEnLineaAnteriores.get(indice);
						faltanParaLineas = faltanParaLineas + Ventana.ancho - cuadradosEnLineaAnteriores.get(indice);
					}
					
					base = base + puntaje;
					cuadradosEnLineaAnteriores.clear();
				}
				
			} else {
				
				vacia = true;
			}
		}
		
		cuadrados = (pantalla.getPiezas().length - pantalla.getIndice()) * 4 +
					pantalla.getVentana().ocupados() - cuadradosParaLineas;
		
		maximo = Double.MIN_VALUE;
		
		for(int usar = 0; usar <= faltanParaLineas; usar++){
			
			hechos = puntos(cuadrados - usar) + (double) ganancia.get(usar);
			if(hechos > maximo) maximo = hechos;
		}
		
		return maximo;
	}
}
	
