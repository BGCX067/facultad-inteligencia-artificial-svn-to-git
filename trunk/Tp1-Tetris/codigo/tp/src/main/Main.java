package main;

import heuristica.*;
import busquedas.*;
import java.util.*;
import java.io.*;

import tetris.*;
import aima.search.framework.*;
import aima.search.informed.*;
import aima.search.uninformed.*;
import aima.search.framework.EvaluationFunction;

public class Main {

	private static final char[] piezas1 = 
		
	{'T', 'T', 'T', 'Z', 'O', 'S', 'S', 'T', 'O', 'S', 'O', 'L', 'S', 'L', 'S', 'I', 'L',
	'T', 'L', 'O', 'L', 'T', 'Z', 'I', 'L', 'T', 'Z', 'I', 'I', 'T', 'I', 'Z', 'O', 'L',
	'Z', 'S', 'L', 'I', 'S', 'I', 'I', 'O', 'I', 'L', 'T', 'I', 'I', 'L', 'O', 'L', 'I',
	'S', 'Z', 'I', 'O', 'T', 'T', 'S', 'L', 'S', 'T', 'O', 'O', 'L', 'I', 'Z', 'T', 'T',
	'T', 'S', 'O', 'T', 'L', 'O', 'L', 'L', 'O', 'I', 'S', 'T', 'Z', 'L', 'O', 'O', 'L',
	'O', 'Z', 'S', 'S', 'S', 'S', 'Z', 'Z', 'I', 'I', 'T', 'S', 'Z', 'Z', 'L', 'S', 'S',
	'T', 'S', 'Z', 'S', 'I', 'O', 'S', 'L', 'O', 'L', 'T', 'Z', 'O', 'Z', 'I', 'S', 'T',
	'S', 'S', 'I', 'S', 'T', 'Z', 'O', 'T', 'T', 'T', 'L', 'S', 'Z', 'L', 'I', 'Z', 'Z',
	'Z', 'T', 'O', 'L', 'L', 'L', 'O', 'O', 'O', 'T', 'T', 'T', 'T', 'Z', 'Z', 'I', 'T',
	'T', 'Z', 'L', 'T', 'T', 'O', 'L', 'S', 'T', 'I', 'Z', 'L', 'S', 'L', 'T', 'O', 'T',
	'Z', 'T', 'O', 'S', 'L', 'O', 'S', 'Z', 'I', 'T', 'O', 'L', 'I', 'S', 'O', 'O', 'L',
	'O', 'T', 'O', 'I', 'I', 'I', 'L', 'T', 'O', 'I', 'S', 'L', 'S'};
	
	private static final char[] piezas2 = 
	
	{'I', 'O', 'L', 'I', 'J', 'T', 'L', 'L', 'I', 'S', 'O', 'I',
	 'S', 'Z', 'Z', 'S', 'Z', 'J', 'Z', 'Z', 'Z', 'Z', 'O', 'O', 'I', 'S',
	 'J', 'J', 'S', 'T', 'J', 'Z', 'S', 'I', 'S', 'I', 'S', 'O', 'Z', 'I',
	 'S', 'I', 'T', 'T', 'S', 'Z', 'I', 'T', 'I', 'T', 'S', 'L', 'J', 'J',
	 'T', 'J', 'L', 'J', 'J', 'S'};

	public static void main(String[] args) {
		
		System.out.print("Empezando...\n\n");
		
		Juego.jugar(piezas1);
		
		//Juego.jugar(Auxiliares.aleatoria(10));
		
		//char usadas[] = Auxiliares.aleatoria(5);
		//comparar(usadas);
		
		//retroalimentarVorazPrimeroElMejor(null, usadas, new HeuristicaEstadistica(30.0), Integer.MAX_VALUE);
		//hintParaAEstrella(null, usadas, new HeuristicaEstadistica(30.0), new HeuristicaCuadradosNoMoviles(), 2);
		
		//tramos(piezas1, new HeuristicaCuadradosNoMoviles(), 4);
		//tramos(piezas1, new HeuristicaCuadradosNoMoviles(), 5);
		
		//corridas(150, 7, 50000, 500000);
		
		//DFS("DFS con HeuristicaCuadradosNoMoviles:\n\n", new HeuristicaCuadradosNoMoviles());
		//DFS("DFS con HeuristicaCuadradosMoviles:\n\n", new HeuristicaCuadradosMoviles());
		
		//BFS("BFS con HeuristicaCuadradosNoMoviles:\n\n", new HeuristicaCuadradosNoMoviles());
		//BFS("BFS con HeuristicaCuadradosMoviles:\n\n", new HeuristicaCuadradosMoviles());
		
		//retroalimentarVorazPrimeroElMejor(null, piezas1, new HeuristicaCuadradosNoMoviles(), 1);
		//retroalimentarVorazPrimeroElMejor(null, piezas1, new HeuristicaCuadradosMoviles(), 1);
		
		//DFS("DFS con HeuristicaMaximasLineas:\n\n", new HeuristicaMaximasLineas());
		
		//comparar(piezas1);
		
		System.out.print("Terminado!");
	}
	
	public static void disco(String cadena, String nombre){

		try {
			
			File archivo = new File(nombre);
			FileWriter writer = new FileWriter(archivo, true);
			writer.write(cadena);
			writer.close();

		} catch(IOException e){ e.printStackTrace(); };
	}
	
	public static void BFS(String nombre, HeuristicFunction heuristica){
		
		Problem problema = new Problem(new Pantalla(piezas1),
				   new Sucesor(),
				   new Objetivo(),
				   heuristica);
		
		System.out.print(busquedaLibreria(nombre, new BreadthFirstSearch(new TreeSearch()), problema, true));		
	}
	
	public static void DFS(String nombre, HeuristicFunction heuristica){
		
		Problem problema = new Problem(new Pantalla(piezas1),
				   new Sucesor(),
				   new Objetivo(),
				   heuristica);
		
		System.out.print(busquedaLibreria(nombre, new DepthFirstSearch(new TreeSearch()), problema, true));		
	}
	
	public static void corridas(int corridas, int cantidad, int inferior, int superior){
		
		char[] piezas;
		Busqueda.Ejecucion ejecucionMoviles;
		Busqueda.Ejecucion ejecucionNoMoviles;
		Problem problemaMoviles;
		Problem problemaNoMoviles;
		Busqueda busqueda;
		long tamano;
		
		busqueda = new AEstrella();
		
		for(int i = 0; i < corridas; i++){
			
			System.out.print("Empezando corrida " + (i + 1) + "\n");
		
			do {
				
				piezas = Auxiliares.aleatoria(cantidad);
				tamano = Auxiliares.tamano(piezas);
				
			} while (!(tamano <= superior && tamano >= inferior));
			
			problemaMoviles = new Problem(new Pantalla(piezas),
					   new Sucesor(),
					   new Objetivo(),
					   new CostoMaximoPuntaje(),
					   new HeuristicaCuadradosMoviles());
			
			ejecucionMoviles = busqueda.buscar(problemaMoviles);
			
			problemaNoMoviles = new Problem(new Pantalla(piezas),
					   new Sucesor(),
					   new Objetivo(),
					   new CostoMaximoPuntaje(),
					   new HeuristicaCuadradosNoMoviles());
			
			ejecucionNoMoviles = busqueda.buscar(problemaNoMoviles);
			
			disco(tamano + " " + ejecucionMoviles.tiempo + " " + ejecucionNoMoviles.tiempo + "\n", "C:\\tiempos.txt");
			disco(tamano + " " + ejecucionMoviles.nodosExpandidos + " " + ejecucionNoMoviles.nodosExpandidos + "\n", "C:\\expandidos.txt");
			disco(tamano + " " + ejecucionMoviles.nodosEnFrontera + " " + ejecucionNoMoviles.nodosEnFrontera + "\n", "C:\\memoria.txt");
		}
	}
	
	public static void comparar(char[] usadas){
			
		Pantalla pantalla = new Pantalla(usadas);
		Set<Pantalla> soluciones = new HashSet<Pantalla>();
		Iterator<Pantalla> iterador;
		Problem problema;
		long t0;
		long t;
		
		/*
		//Descripcion:
		
		System.out.print("Descripcion del problema: \n\n");
		System.out.print("Alto x ancho: " + Ventana.alto + " x " + Ventana.ancho + "\n");
		System.out.print("Piezas: ");
		for(int i = 0; i < usadas.length; i++) System.out.print(usadas[i] + ", ");
		System.out.print("\nTamaño: " + Auxiliares.tamano(usadas) + "\n\n");
		
		//Backtracking:

		System.out.print("Backtracking: ");
		t0 = System.currentTimeMillis();
		pantalla.optima(soluciones);
		t = System.currentTimeMillis();
		iterador = soluciones.iterator();
		System.out.print(iterador.next().getPuntaje());	
		System.out.print(" (" + (((double)(t - t0))/1000) + " seg.)\n\n");

		//Busquedas informadas:
		
		//A*:

		problema = new Problem(new Pantalla(usadas),
							   new Sucesor(),
							   new Objetivo(),
							   new CostoMaximoPuntaje(),
							   new HeuristicaEstrella());
		
		System.out.print(busquedaPropia("A* (propia) con HeuristicaEstrella: ",
						 new AEstrella(), problema, false));

		System.out.print(busquedaLibreria("A* con HeuristicaEstrella: ",
						 new AStarSearch(new TreeSearch()), problema, false));
		
		problema = new Problem(new Pantalla(usadas),
				   new Sucesor(),
				   new Objetivo(),
				   new CostoMaximoPuntaje(),
				   new HeuristicaCuadradosMoviles());
		
		System.out.print(busquedaPropia("A* (propia) con HeuristicaCuadradosMoviles: ",
										new AEstrella(), problema, false));
		
		System.out.print(busquedaLibreria("A* con HeuristicaCuadradosMoviles: ",
		 				 new AStarSearch(new TreeSearch()), problema, false));
		
		problema = new Problem(new Pantalla(usadas),
				   new Sucesor(),
				   new Objetivo(),
				   new CostoMaximoPuntaje(),
				   new HeuristicaCuadradosNoMoviles());
		
		System.out.print(busquedaPropia("A* (propia) con HeuristicaCuadradosNoMoviles: ",
										new AEstrella(), problema, false));
		
		//Recursive Best First:
		
		problema = new Problem(new Pantalla(usadas),
				   new Sucesor(),
				   new Objetivo(),
				   new CostoMaximoPuntaje(),
				   new HeuristicaCuadradosNoMoviles());
		
		System.out.print(busquedaLibreria("Recursive Best First con HeuristicaCuadradosNoMoviles: ",
						 new RecursiveBestFirstSearch(new HeuristicaCuadradosNoMoviles()), problema, false));
	
		//Greedy First Best:
		
		problema = new Problem(new Pantalla(usadas),
				   new Sucesor(),
				   new Objetivo(),
				   new CostoMaximoPuntaje(),
				   new HeuristicaEstrella());

		System.out.print(busquedaPropia("Greedy First Best (propio) con HeuristicaEstrella: ",
						 new VorazPrimeroElMejor(), problema, false));

		System.out.print(busquedaLibreria("Greedy First Best con HeuristicaEstrella: ",
						 new GreedyBestFirstSearch(new TreeSearch()), problema, false));
		
		problema = new Problem(new Pantalla(usadas),
				   new Sucesor(),
				   new Objetivo(),
				   new CostoMaximoPuntaje(),
				   new HeuristicaCuadradosMoviles());

		System.out.print(busquedaPropia("Greedy First Best (propio) con HeuristicaCuadradosMoviles: ",
						 new VorazPrimeroElMejor(), problema, true));
		
		System.out.print(busquedaLibreria("Greedy First Best con HeuristicaCuadrados: ",
						 new GreedyBestFirstSearch(new TreeSearch()), problema, false));
		
		problema = new Problem(new Pantalla(usadas),
				   new Sucesor(),
				   new Objetivo(),
				   new CostoMaximoPuntaje(),
				   new HeuristicaCuadradosNoMoviles());
		
		System.out.print(busquedaPropia("Greedy First Best (propio) con HeuristicaCuadradosNoMoviles: ",
				 new VorazPrimeroElMejor(), problema, true));
		*/
		
		problema = new Problem(new Pantalla(usadas),
				   new Sucesor(),
				   new Objetivo(),
				   new CostoMaximasLineas(),
				   new HeuristicaMaximasLineas());

		System.out.print(busquedaPropia("Greedy First Best (propio) con HeuristicaMaximasLineas: ",
						 new VorazPrimeroElMejor(), problema, true));
	}
	
	public static NodeWrapper hintParaAEstrella(NodeWrapper objetivo, char[] usadas, HeuristicFunction heuristicaParaVoraz, HeuristicFunction heuristicaParaAEstrella, int limite){
		
		Busqueda.Ejecucion ejecucion;
		Problem problema;
		AEstrella aestrella;
		
		if(objetivo == null){
		
			problema = new Problem(new Pantalla(usadas),
					   new Sucesor(),
					   new Objetivo(),
				       new CostoMaximoPuntaje(),
				       heuristicaParaVoraz);
		
		 	objetivo = retroalimentarVorazPrimeroElMejor(objetivo, usadas, heuristicaParaVoraz, limite);
		}
		
		problema = new Problem(new Pantalla(usadas),
				   new Sucesor(),
				   new Objetivo(),
				   new CostoMaximoPuntaje(),
				   heuristicaParaAEstrella);
		
		System.out.print("A* (propio) con hint: \n\n");
		
		aestrella = new AEstrella();
		aestrella.setHint(objetivo);
		
		ejecucion = aestrella.buscar(problema);
		
		objetivo = ejecucion.resultado;
		
		System.out.print("La busqueda ha terminado (" + ejecucion.tiempo + " seg).\n\n");
		
		return objetivo;
	}
	
	public static NodeWrapper nodoAdHoc(int piezas, int puntaje){
		
		NodeWrapper nodo;
		Node interno;
		double costo;
		
		costo = 80 * piezas - puntaje; 
		
		interno = new Node();
		interno.setPathCost(costo);
		
		nodo = new NodeWrapper(interno);
		nodo.setCost(costo);
		
		return nodo;
	}
	
	public static NodeWrapper retroalimentarVorazPrimeroElMejor(NodeWrapper objetivo, char[] usadas, HeuristicFunction heuristica, int limite){
		
		Problem problema;
		VorazPrimeroElMejor voraz;
		NodeWrapper ultimo;
		long t0;
		long t;
		int veces;
		
		problema = new Problem(new Pantalla(usadas),
				   new Sucesor(),
				   new Objetivo(),
				   new CostoMaximoPuntaje(),
				   heuristica);

		System.out.print("Greedy First Best (propio) retroalimentado: \n\n");
		
		voraz = new VorazPrimeroElMejor();
		
		t0 = System.currentTimeMillis();
		if(objetivo == null) objetivo = voraz.buscar(problema).resultado;
		System.out.print("Ultimo mejor resultado: " + ((80 * usadas.length) - objetivo.getNode().getPathCost()) + "\n");		
		ultimo = objetivo.clone();
		
		voraz.setCota(objetivo);
		veces = 1;

		while (objetivo != null && veces < limite){
			
			objetivo = voraz.buscar(problema).resultado;
			
			if(objetivo != null){
				System.out.print("Ultimo mejor resultado: " + ((80 * usadas.length) - objetivo.getNode().getPathCost()) + "\n");
				ultimo = objetivo.clone();
			}
			
			voraz.setCota(objetivo);
			veces++;
		}
		
		t = System.currentTimeMillis();
		
		if(objetivo == null) objetivo = ultimo;
		objetivo.setCost(objetivo.getNode().getPathCost());
		
		System.out.print("La busqueda ha terminado (" + (((double)(t - t0))/1000) + " seg).\n\n");
		
		return objetivo;
	}
	
	public static void tramos(char[] usadas, HeuristicFunction heuristica, int offset){
		
		class Elemento {
			
			public int comienzo;
			public NodeWrapper nodo;
			
			public Pantalla getPantalla(){
				return (Pantalla) nodo.getNode().getState();
			}
		}
		
		Busqueda.Ejecucion ejecucion;
		Stack<Elemento> pila;
		Set<NodeWrapper> apilar;
		char[] piezas;
		VorazPrimeroElMejor voraz;
		Problem problema;
		boolean terminar;
		boolean parar;
		Elemento elemento;
		Elemento tope;
		int maximo;
		
		pila = new Stack<Elemento>();
		apilar = null;
		piezas = new char[offset];
		voraz = new VorazPrimeroElMejor();

		elemento = new Elemento();
		elemento.nodo = new NodeWrapper(new Node(new Pantalla(piezas)));
		elemento.comienzo = 0;
		
		maximo = 0;
		parar = false;
		pila.push(elemento);

		while (!pila.isEmpty() && !parar){

			tope = pila.pop();
			
			if(tope.comienzo < usadas.length){
				
				for(int i = 0; i < offset; i++)
					piezas[i] = usadas[tope.comienzo + i];
		
				tope.getPantalla().setIndice(0);

				problema = new Problem(tope.getPantalla(),
						   new Sucesor(),
						   new Objetivo(),
						   new CostoMaximoPuntaje(),
						   heuristica);
			
				System.out.print("Realizando busqueda entre " + tope.comienzo + " y " + (tope.comienzo + offset) + ".\n");
		
				terminar = false;
		
				while(!terminar){
			
					ejecucion = voraz.buscar(problema);
				
					if(ejecucion.resultado != null){
						apilar = ejecucion.resultados;
					} else {
						terminar = true;
					}
				
					voraz.setCota(ejecucion.resultado);
				}
				
				System.out.print("Pongo " + apilar.size() + " nodos en la pila\n");
					
				for(NodeWrapper nodo : apilar){
			
					elemento = new Elemento();
					elemento.nodo = nodo;	
					elemento.comienzo = tope.comienzo + offset;
					pila.push(elemento);
				}
					
				apilar.clear();
			
			} else {
				
				if(maximo < tope.getPantalla().getPuntaje()){
					
					maximo = tope.getPantalla().getPuntaje();
					
					disco("Mejor resultado hasta el momento: \n\nEstado final: \n\n" + tope.getPantalla() + "Acciones:\n\n" + accionesLibreria(tope.getPantalla().getAcciones())  + "\n", "c:\\luis\\mejores.txt");
					System.out.print("Mejor resultado hasta el momento: \n\nEstado final: \n\n" + tope.getPantalla() + "Acciones:\n\n" + accionesLibreria(tope.getPantalla().getAcciones())  + "\n");
					
					System.out.print("(Acciones: " + tope.getPantalla().getAcciones().size() + ")\n");
					disco("(Acciones: " + tope.getPantalla().getAcciones().size() + ")\n", "c:\\luis\\mejores.txt");
					
					//parar = true;
				}
			}
		}
	}
	
	public static void retroalimentarAEstrella(char[] usadas, HeuristicFunction heuristica, int offset){
		
		Problem problema;
		Pantalla ultimo;
		int comienzo;
		char[] piezas;
		AEstrella aestrella;
		
		piezas = new char[offset];
		aestrella = new AEstrella();
		
		comienzo = 0;
		ultimo = new Pantalla(piezas);

		while (comienzo < usadas.length){
			
			for(int i = 0; i < offset; i++)
				piezas[i] = usadas[comienzo + i];
			
			ultimo.setIndice(0);

			problema = new Problem(ultimo,
					   new Sucesor(),
				       new Objetivo(),
				       new CostoMaximoPuntaje(),
				       heuristica);
			
			System.out.print("Realizando busqueda entre " + comienzo + " y " + (comienzo + offset) + ":\n");
			ultimo = (Pantalla) aestrella.buscar(problema).resultado.getNode().getState();
			System.out.print(ultimo);

			comienzo = comienzo + offset;
		}
	}
	
	public static String busquedaPropia(String nombre, Busqueda busqueda, Problem problema, boolean completo){
		
		String descripcion;
		String[] partes;
		String resultado;
		Busqueda.Ejecucion ejecucion;
		
		descripcion = new String(nombre);
		
		try {
			
			ejecucion = busqueda.buscar(problema);
			
			if(completo){
				descripcion = descripcion + "\n\n" + ejecucion.resultado.getNode().getState() + "\n" + accionesLibreria(SearchUtils.actionsFromNodes(ejecucion.resultado.getNode().getPathFromRoot()));
			} else {
				partes = ejecucion.resultado.getNode().getAction().split(":");
				resultado = partes[partes.length - 1].trim();
				descripcion = descripcion + resultado;
			}
			
			descripcion = descripcion + "(" + ejecucion.tiempo + " seg.)\n\n";
			
		} catch (Exception e) {	e.printStackTrace(); }
		
		return descripcion;
	}

	public static String busquedaLibreria(String nombre, Search busqueda, Problem problema, boolean completo){
		
		String descripcion;
		SearchAgent agente;
		List<String> acciones;
		String[] partes;
		long t0;
		long t;

		descripcion = new String(nombre);
		
		try {
			
			busqueda = new AStarSearch(new TreeSearch());
			
			if(completo){
				t0 = System.currentTimeMillis();
				agente = new SearchAgent(problema, busqueda);
				t = System.currentTimeMillis();
				descripcion = descripcion + accionesLibreria(agente.getActions()) + "\n" + metricasLibreria(agente.getInstrumentation()) + "\n";
			} else {
				t0 = System.currentTimeMillis();
				acciones = (List<String>) busqueda.search(problema);
				t = System.currentTimeMillis();
				partes = acciones.get(acciones.size() - 1).split(":");
				descripcion = descripcion + partes[partes.length - 1].trim();
			}		
			
			descripcion = descripcion + "(" + (((double)(t - t0))/1000) + " seg.)\n\n";
			
		} catch (Exception e) {	e.printStackTrace(); }
		
		return descripcion;
	}
	
	public static String metricasLibreria(Properties metricas) {
		
		String cadena;
		String metrica;
		String valor;
		Iterator iterador;
		
		cadena = new String("");
		iterador = metricas.keySet().iterator();
		
		while (iterador.hasNext()){
			
			metrica = (String) iterador.next();
			valor = metricas.getProperty(metrica);
			cadena = cadena + metrica + ": " + valor + "\n";
		}
		
		return cadena;
	}

	public static String accionesLibreria(List acciones){
		
		String cadena;
		String accion;
		
		cadena = new String("");
		
		for (int i = 0; i < acciones.size(); i++) {
			accion = (String) acciones.get(i);
			cadena = cadena + accion + "\n";
		}
		
		return cadena;
	}

}
