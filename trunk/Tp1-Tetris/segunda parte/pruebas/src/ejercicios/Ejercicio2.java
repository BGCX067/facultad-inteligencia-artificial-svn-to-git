package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		System.out.println("Comenzando...");
		
		//prepararModelos("C:\\dump\\ejercicio2\\");
		//crearDatasets("C:\\dump\\ejercicio2\\vote.arff", "C:\\dump\\ejercicio2\\");
		//prepararTests("C:\\dump\\ejercicio2\\");
		//parsearResultados("C:\\dump\\ejercicio2\\");
		
		System.out.println("Terminado!");
	}

	private static void parsearResultados(String pathEjercicio){
		
		double porcentaje;
		String tamanios;
		String porcentajesJ48;
		String porcentajesIbk;
		String porcentajesMultilayerPerceptron;
		String linea;
		String partes[];
		Set<String> estrategias;
		
		estrategias = new HashSet<String>();
		estrategias.add("moda");
		estrategias.add("modaclase");
		estrategias.add("modelo");
		
		for(String estrategia : estrategias){

			tamanios = "faltantes hojas nodos\n";
			porcentajesJ48 = "faltantes cross-validation\n";
			porcentajesIbk = "faltantes cross-validation\n";
			porcentajesMultilayerPerceptron = "faltantes cross-validation\n";
			
			porcentaje = 0;
		
			while (porcentaje <= 85){

				linea = Ejercicio1.buscar(pathEjercicio + "resultados\\" + estrategia + "\\J48\\J48_" + porcentaje + ".txt", "", "Number of Leaves(.*)");
				partes = linea.split(":");
				tamanios = tamanios + porcentaje + " " + partes[1].trim();
			
				linea = Ejercicio1.buscar(pathEjercicio + "resultados\\" + estrategia + "\\J48\\J48_" + porcentaje + ".txt", "", "Size of the tree(.*)");
				partes = linea.split(":");
				tamanios = tamanios + " " + partes[1].trim() + "\n";
			
				linea = Ejercicio1.buscar(pathEjercicio + "resultados\\" + estrategia + "\\J48\\J48_" + porcentaje + ".txt", "=== Stratified cross-validation ===", "Correctly Classified Instances(.*)");
				partes = linea.split(" ");
				for(int i = 0; i < partes.length; i++) if(partes[partes.length - 1 - i].contains(".")) porcentajesJ48 = porcentajesJ48 + porcentaje + " " + partes[partes.length - 1 - i] + "\n";
			
				linea = Ejercicio1.buscar(pathEjercicio + "resultados\\" + estrategia + "\\IBK\\IBK_" + porcentaje + ".txt", "=== Stratified cross-validation ===", "Correctly Classified Instances(.*)");
				partes = linea.split(" ");
				for(int i = 0; i < partes.length; i++) if(partes[partes.length - 1 - i].contains(".")) porcentajesIbk = porcentajesIbk + porcentaje + " " + partes[partes.length - 1 - i] + "\n";
				
				linea = Ejercicio1.buscar(pathEjercicio + "resultados\\" + estrategia + "\\MultilayerPerceptron\\MultilayerPerceptron_" + porcentaje + ".txt", "=== Stratified cross-validation ===", "Correctly Classified Instances(.*)");
				partes = linea.split(" ");
				for(int i = 0; i < partes.length; i++) if(partes[partes.length - 1 - i].contains(".")) porcentajesMultilayerPerceptron = porcentajesMultilayerPerceptron + porcentaje + " " + partes[partes.length - 1 - i] + "\n";
				
				porcentaje = porcentaje + 2.5;
			}
		
			Ejercicio1.guardarEn(tamanios, pathEjercicio + "tablas\\" + estrategia + "\\J48_tamanios.txt");
			Ejercicio1.guardarEn(porcentajesJ48, pathEjercicio + "tablas\\" + estrategia + "\\J48_porcentajes.txt");
			Ejercicio1.guardarEn(porcentajesIbk, pathEjercicio + "tablas\\" + estrategia + "\\IBK_porcentajes.txt");
			Ejercicio1.guardarEn(porcentajesMultilayerPerceptron, pathEjercicio + "tablas\\" + estrategia + "\\MultilayerPerceptron_porcentajes.txt");
		}
	}

	@SuppressWarnings("unused")
	public static void prepararTests(String pathEjercicio){
		
		String j48;
		String ibk;
		String multilayerPerceptron;
		Set<String> estrategias;
		double porcentaje;

		j48 = "";		
		ibk = "";
		multilayerPerceptron = "";
		
		estrategias = new HashSet<String>();
		estrategias.add("moda");
		estrategias.add("modaclase");
		estrategias.add("modelo");
		
		for(String estrategia : estrategias){
		
			porcentaje = 0;
			
			while (porcentaje <= 85){
		
				j48 = j48 + "java weka.classifiers.trees.J48 -t " + pathEjercicio + "\\datasets\\" + estrategia + "\\" + estrategia + "_" + porcentaje + ".arff -C 0.25 -M 2 > " + pathEjercicio + "resultados\\" + estrategia + "\\J48\\J48_" + porcentaje + ".txt\n";
				ibk = ibk + "java weka.classifiers.lazy.IBk -t " + pathEjercicio + "\\datasets\\" + estrategia + "\\" + estrategia + "_" + porcentaje + ".arff -K 1 -W 0 -A \"weka.core.neighboursearch.LinearNNSearch -A \\\"weka.core.EuclideanDistance -R first-last\\\"\" > " + pathEjercicio + "resultados\\" + estrategia + "\\IBK\\IBK_" + porcentaje + ".txt\n";
				multilayerPerceptron = multilayerPerceptron + "java weka.classifiers.functions.MultilayerPerceptron -t " + pathEjercicio + "\\datasets\\" + estrategia + "\\" + estrategia + "_" + porcentaje + ".arff -L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H a > " + pathEjercicio + "resultados\\" + estrategia + "\\MultilayerPerceptron\\MultilayerPerceptron_" + porcentaje + ".txt\n"; 
				
				porcentaje = porcentaje + 2.5;
			}
		}
		
		j48 = j48 + "@pause\n";
		ibk = ibk + "@pause\n";
		multilayerPerceptron = multilayerPerceptron + "@pause\n";
			
		Ejercicio1.guardarEn(j48, pathEjercicio + "tests\\J48.bat");
		Ejercicio1.guardarEn(ibk, pathEjercicio + "tests\\IBK.bat");
		Ejercicio1.guardarEn(multilayerPerceptron, pathEjercicio + "tests\\MultilayerPerceptron.bat");
	}
	
	@SuppressWarnings("unused")
	private static void crearDatasets(String dataset, String pathEjercicio){
		
		Set<String> estrategias;
		double porcentaje;
		Map<Integer,Map<Integer,String>> instancias;
		String salida;
		
		estrategias = new HashSet<String>();
		estrategias.add("moda");
		estrategias.add("modaclase");
		estrategias.add("modelo");
		
		for(String estrategia : estrategias){
		
			porcentaje = 0;
			
			while(porcentaje <= 85){
			
				instancias = new HashMap<Integer,Map<Integer,String>>();
				
				datasetAnterior(dataset, instancias);
				completarSegunEstrategia(pathEjercicio, instancias, porcentaje, estrategia);
				salida = datasetNuevo(instancias);
				
				Ejercicio1.guardarEn(salida, pathEjercicio + "datasets\\" + estrategia + "\\" + estrategia + "_" + porcentaje + ".arff");
				
				porcentaje = porcentaje + 2.5;
			}
		}
	}

	private static void completarSegunEstrategia(String pathEjercicio, Map<Integer, Map<Integer, String>> instancias, double porcentaje, String estrategia) {

		if(estrategia.equals("moda")){
			completarConModa(instancias,porcentaje);
		} else if(estrategia.equals("modaclase")){
			completarConModaClase(instancias,porcentaje);
		} else if(estrategia.equals("modelo")){
			completarConModelo(pathEjercicio, instancias,porcentaje);
		}
	}

	private static void completarConModelo(String pathEjercicio, Map<Integer, Map<Integer, String>> instancias, double porcentaje) {
		
		int atributos;
		int faltantes;
		int puestos;
		double actual;
		String modelo;
		String linea;
		String partes[];
		
		faltantes = faltantes(instancias);
		
		atributos = instancias.get(instancias.keySet().iterator().next()).keySet().size();
		actual = 0;
		puestos = 0;
		modelo = null;
		
		for(int i = 0; i < instancias.size() && actual < porcentaje; i++){
			
			for(int j = 0; j < atributos - 1 && actual < porcentaje; j++){
				
				if(instancias.get(i).get(j).equals("?")){
					
					linea = Ejercicio1.buscar(pathEjercicio + "modelos\\predic_" + (j + 1) + ".txt", "", "(.*)" + (i + 1) + "        " + "(.*)");
					
					partes = linea.split(" ");
					
					for(int k = 0; k < partes.length; k++)
						if(partes[k].contains(":") && !partes[k].contains("?"))
							modelo = "'" + partes[k].charAt(partes[k].length() - 1) + "'";
					
					//System.out.println("i = " + (i + 1) + " j = " + (j + 1));
					//System.out.println(linea + " -> " + modelo);
					
					instancias.get(i).put(j,modelo);
					puestos++;
					actual = ((double) puestos / (double) faltantes) * 100;
				}
			}
		}		
	}

	private static void prepararModelos(String pathEjercicio){
		
		String bat;
		int atributo;
		int totales;
		
		totales = 17;
		atributo = 2;
		
		bat = "java weka.filters.unsupervised.attribute.Reorder -i " + pathEjercicio + "vote.arff -R 2-last,1 -o " + pathEjercicio + "\\modelos\\vote_1.arff\n";
		bat = bat + "java weka.classifiers.trees.J48 -t " + pathEjercicio + "modelos\\vote_1.arff -d " + pathEjercicio + "modelos\\vote_1.model -C 0.25 -M 2\n";
		bat = bat + "java weka.classifiers.trees.J48 -l " + pathEjercicio + "modelos\\vote_1.model -p " + totales + " -T " + pathEjercicio + "\\modelos\\vote_1.arff > " + pathEjercicio + "modelos\\predic_1.txt\n";
		bat = bat + "del " + pathEjercicio + "modelos\\vote_1.model\n";
		bat = bat + "del " + pathEjercicio + "modelos\\vote_1.arff\n\n";
		
		while(atributo < totales){
			
			bat = bat + "java weka.filters.unsupervised.attribute.Reorder -i " + pathEjercicio + "vote.arff -R 1-" + (atributo - 1) + "," + (atributo + 1) + "-last," + atributo + " -o " + pathEjercicio + "modelos\\vote_" + atributo + ".arff\n";
			bat = bat + "java weka.classifiers.trees.J48 -t " + pathEjercicio + "modelos\\vote_" + atributo + ".arff -d " + pathEjercicio + "modelos\\vote_" + atributo + ".model -C 0.25 -M 2\n";
			bat = bat + "java weka.classifiers.trees.J48 -l " + pathEjercicio + "modelos\\vote_" + atributo + ".model -p " + totales + " -T " + pathEjercicio + "modelos\\vote_" + atributo + ".arff > " + pathEjercicio + "modelos\\predic_" + atributo + ".txt\n\n";
			bat = bat + "del " + pathEjercicio + "modelos\\vote_" + atributo + ".model\n";
			bat = bat + "del " + pathEjercicio + "modelos\\vote_" + atributo + ".arff\n\n";
			
			atributo++;
		}
		
		bat = bat + "@pause\n";
		
		Ejercicio1.guardarEn(bat, pathEjercicio + "tests\\Modelos.bat");
	}

	private static void completarConModaClase(Map<Integer, Map<Integer, String>> instancias, double porcentaje) {
		
		Map<Integer,Map<String,Map<String,Integer>>> estadistica;
		Map<String,Map<String,Integer>> elemento;
		int atributos;
		int faltantes;
		int puestos;
		double actual;
		String media;
		
		faltantes = faltantes(instancias);
		
		estadistica = new HashMap<Integer,Map<String,Map<String,Integer>>>();
		
		atributos = instancias.get(instancias.keySet().iterator().next()).keySet().size();
		
		for(int i = 0; i < atributos - 1; i++){
			
			elemento = new HashMap<String,Map<String,Integer>>();
			elemento.put("'republican'", new HashMap<String,Integer>());
			elemento.put("'democrat'", new HashMap<String,Integer>());
			
			elemento.get("'republican'").put("'y'", 0);
			elemento.get("'democrat'").put("'y'", 0);
			elemento.get("'republican'").put("'n'", 0);
			elemento.get("'democrat'").put("'n'", 0);
			
			for(int j = 0; j < instancias.size(); j++){
					
				if(instancias.get(j).get(i).equals("'y'")){
					elemento.get(instancias.get(j).get(atributos - 1)).put("'y'", elemento.get(instancias.get(j).get(atributos - 1)).get("'y'") + 1);
				} else if(instancias.get(j).get(i).equals("'n'")){
					elemento.get(instancias.get(j).get(atributos - 1)).put("'n'", elemento.get(instancias.get(j).get(atributos - 1)).get("'n'") + 1);
				}
			}

			estadistica.put(i,elemento);
		}
		
		puestos = 0;
		actual = 0;
		
        for(int i = 0; i < instancias.size() && actual < porcentaje; i++){
        	
        	for(int j = 0; j < atributos - 1 && actual < porcentaje; j++){
        		
        		if(instancias.get(i).get(j).equals("?")){
        		  			
        			if(estadistica.get(j).get(instancias.get(i).get(atributos - 1)).get("'y'") >
        			   estadistica.get(j).get(instancias.get(i).get(atributos - 1)).get("'n'")){
        				media = "'y'";
        			} else {
        				media = "'n'";
        			}
        			
        			instancias.get(i).put(j, media);
        			puestos++;
        			
        			actual = ((double) puestos / (double) faltantes) * 100;
        		}
        	}
		}
	}

	private static void completarConModa(Map<Integer, Map<Integer, String>> instancias, double porcentaje) {
		
		Map<Integer,Map<String,Integer>> estadistica;
		Map<String,Integer> elemento;
		int atributos;
		int faltantes;
		int puestos;
		double actual;
		String media;
		
		faltantes = faltantes(instancias);
		
		estadistica = new HashMap<Integer,Map<String,Integer>>();
		
		atributos = instancias.get(instancias.keySet().iterator().next()).keySet().size();
		
		for(int i = 0; i < atributos - 1; i++){
			
			elemento = new HashMap<String,Integer>();
			elemento.put("'y'", 0);
			elemento.put("'n'", 0);
			
			for(int j = 0; j < instancias.size(); j++){
				
				if(instancias.get(j).get(i).equals("'y'")){
					elemento.put("'y'", elemento.get("'y'") + 1);
				} else if(instancias.get(j).get(i).equals("'n'")){
					elemento.put("'n'", elemento.get("'n'") + 1);
				}
			}

			estadistica.put(i,elemento);
		}
		
		puestos = 0;
		actual = 0;
		
        for(int i = 0; i < instancias.size() && actual < porcentaje; i++){
        	
        	for(int j = 0; j < atributos - 1 && actual < porcentaje; j++){
        		
        		if(instancias.get(i).get(j).equals("?")){
        		
        			if(estadistica.get(j).get("'y'") > estadistica.get(j).get("'n'")){
        				media = "'y'";
        			} else {
        				media = "'n'";
        			}
        			
        			instancias.get(i).put(j, media);
        			puestos++;
        			
        			actual = ((double) puestos / (double) faltantes) * 100;
        		}
        	}
		}
	}
	
	private static int faltantes(Map<Integer, Map<Integer, String>> instancias){
		
		int faltantes;
		
		faltantes = 0;
		
        for(int i = 0; i < instancias.size(); i++)
        	for(int j = 0; j < instancias.get(i).size(); j++)
        		if(instancias.get(i).get(j).equals("?")) faltantes++;
		
		return faltantes;
	}

	private static String datasetNuevo(Map<Integer, Map<Integer, String>> instancias) {
		
        String salida;
        String linea;
		File archivo;
		FileReader fr;
		BufferedReader br;
		
        salida = "";
		linea = null;
		archivo = null;
		fr = null;
		br = null;

		try {
			
			 archivo = new File ("C:\\dump\\ejercicio2\\base.arff");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         while((linea = br.readLine()) != null) salida = salida + linea + "\n"; 
	         
		} catch(Exception e){ e.printStackTrace(); } finally {

			try { if(null != fr) fr.close(); } catch (Exception e2){ e2.printStackTrace(); }
		}
       
        for(int i = 0; i < instancias.size(); i++){
        	
        	for(int j = 0; j < instancias.get(i).size(); j++){

        		if(j < instancias.get(i).size() - 1){
        			salida = salida + instancias.get(i).get(j) + ",";
        		} else {
        			salida = salida + instancias.get(i).get(j);
        		}
        	}
        	
        	salida = salida + "\n";
		}
		
		return salida;
	}

	private static void datasetAnterior(String nombre, Map<Integer, Map<Integer, String>> instancias){
		
		String linea;
		String partes[];
		File archivo;
		FileReader fr;
		BufferedReader br;
		int cuenta;
		Map<Integer, String> instancia;
		
        linea = null;
		archivo = null;
		fr = null;
		br = null;
		cuenta = 0;

		try {
			
			 archivo = new File (nombre);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         while((linea = br.readLine()) != null){
	        	 
	        	 if(!(linea.charAt(0) == '%' || linea.charAt(0) == '@')){
	        		
	        		 instancia = new HashMap<Integer,String>();
	        		 partes = linea.split(",");
	        		 for(int i = 0; i < partes.length; i++) instancia.put(i, partes[i]); 
	        		 instancias.put(cuenta, instancia);
	        		 cuenta++;
	        	 }
	         }
	         
		} catch(Exception e){ e.printStackTrace(); } finally {

			try { if(null != fr) fr.close(); } catch (Exception e2){ e2.printStackTrace(); }
		}
	}

}
