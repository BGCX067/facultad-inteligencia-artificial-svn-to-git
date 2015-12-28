package tetris;

import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest {

	public boolean isGoalState(Object objeto){
		
		boolean objetivo;
		
		Pantalla pantalla;
		
		pantalla = (Pantalla) objeto;
		
		objetivo = pantalla.getProxima() == null;
		
		

		if(objetivo){
			System.out.println("Estado final: \n"+ pantalla.toString());
		}
		return objetivo;
	}
}
