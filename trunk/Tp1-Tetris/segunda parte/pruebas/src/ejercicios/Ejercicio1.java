package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		System.out.println("Comenzando...");
		
		//parsearResultadosParaJ48("c:\\dump\\ejercicio1\\");
		//parsearResultadosParaIBK("c:\\dump\\ejercicio1\\");
		//parsearResultadosParaMultilayerPerceptron("c:\\dump\\ejercicio1\\");
			
		System.out.println("Terminado!");
	}

	@SuppressWarnings("unused")
	private static void prepararTestsParaJ48() {
		
		Double confidenceFactor;
		String bat;
		
		confidenceFactor = 0.0001;
		bat = "";
		
		bat = bat + "java weka.classifiers.trees.J48 -t c:\\dump\\vote.arff -split-percentage 80 -C 0.001 -M 2 > c:\\dump\\ejercicio1\\resultados\\J48\\J48_0.001.txt\n";
		confidenceFactor = confidenceFactor + 0.025;

		while (confidenceFactor < 1){
		
			bat = bat + "java weka.classifiers.trees.J48 -t c:\\dump\\vote.arff -split-percentage 80 -C " + confidenceFactor.toString().substring(0, 5) + " -M 2 > c:\\dump\\ejercicio1\\resultados\\J48\\J48_" + confidenceFactor.toString().substring(0, 5) + ".txt\n";
			confidenceFactor = confidenceFactor + 0.025;
		}
		
		bat = bat + "@pause\n";
			
		guardarEn(bat, "c:\\dump\\ejercicio1\\tests\\J48.bat");
	}
	
	@SuppressWarnings("unused")
	private static void prepararTestsParaMultilayerPerceptron() {
		
		int hiddenLayers;
		int max;
		String bat;
		
		max = 20;
		hiddenLayers = 0;
		bat = "";

		while (hiddenLayers <= max){
		
			bat = bat + "java weka.classifiers.functions.MultilayerPerceptron -t c:\\dump\\vote.arff -split-percentage 80 -L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H " + hiddenLayers + " > c:\\dump\\ejercicio1\\resultados\\MultilayerPerceptron\\MultilayerPerceptron_" + hiddenLayers + ".txt\n";
			hiddenLayers = hiddenLayers + 1;
		}
		
		bat = bat + "@pause\n";
			
		guardarEn(bat, "c:\\dump\\ejercicio1\\tests\\MultilayerPerceptron.bat");
	}
		
	private static void parsearResultadosParaJ48(String pathEjercicio){
		
		Double confidenceFactor;
		String confidenceFactorString;
		String tamanios;
		String porcentajes;
		String linea;
		String partes[];
		String training;
		String testing;
		String hojas;
		String nodos;
		
		confidenceFactor = 0.0001;

		training = "";
		testing = "";
		tamanios = "confidencia hojas nodos\n";
		porcentajes = "confidencia testing training\n";
		
		while (confidenceFactor < 1){
		
			if(confidenceFactor == 0.0001){
				confidenceFactorString = "0.001"; 
			} else {
				confidenceFactorString = confidenceFactor.toString().substring(0, 5);
			}
			
			linea = buscar(pathEjercicio + "resultados\\J48\\J48_" + confidenceFactorString + ".txt", "", "Number of Leaves(.*)");
			partes = linea.split(":");
			hojas = partes[1].trim();
			
			linea = buscar(pathEjercicio + "resultados\\J48\\J48_" + confidenceFactorString + ".txt", "", "Size of the tree(.*)");
			partes = linea.split(":");
			nodos = partes[1].trim();
			
			linea = buscar(pathEjercicio + "resultados\\J48\\J48_" + confidenceFactorString + ".txt", "=== Error on training split ===", "Correctly Classified Instances(.*)");
			partes = linea.split(" ");
			for(int i = 0; i < partes.length; i++) if(partes[partes.length - 1 - i].contains(".")) training = partes[partes.length - 1 - i];
			
			linea = buscar(pathEjercicio + "resultados\\J48\\J48_" + confidenceFactorString + ".txt", "=== Error on test split ===", "Correctly Classified Instances(.*)");
			partes = linea.split(" ");
			for(int i = 0; i < partes.length; i++) if(partes[partes.length - 1 - i].contains(".")) testing = partes[partes.length - 1 - i];
    		
			tamanios = tamanios + confidenceFactorString + " " + hojas + " " + nodos + "\n";
			porcentajes = porcentajes + confidenceFactorString + " " + testing + " " + training + "\n";
			
			confidenceFactor = confidenceFactor + 0.025;
		}
		
		guardarEn(tamanios, pathEjercicio + "tablas\\J48_tamanios.txt");
		guardarEn(porcentajes, pathEjercicio + "tablas\\J48_porcentajes.txt");
	}

	private static void parsearResultadosParaIBK(String pathEjercicio){
		
		String porcentajes;
		String testing;
		String training;
		String linea;
		String partes[];
		Set<Integer> vecinos;
		
		porcentajes = "vecinos testing training\n";
		testing = "";
		training = "";
		
		vecinos = new HashSet<Integer>();
		vecinos.add(1);
		vecinos.add(3);
		vecinos.add(5);
		vecinos.add(7);
		vecinos.add(9);
		vecinos.add(13);
		vecinos.add(21);
		
		for(Integer k : vecinos){
		
			linea = buscar(pathEjercicio + "resultados\\IBK\\IBK_" + k + ".txt", "=== Error on training split ===", "Correctly Classified Instances(.*)");
			partes = linea.split(" ");
			for(int i = 0; i < partes.length; i++) if(partes[partes.length - 1 - i].contains(".")) training = partes[partes.length - 1 - i];
			
			linea = buscar(pathEjercicio + "resultados\\IBK\\IBK_" + k + ".txt", "=== Error on test split ===", "Correctly Classified Instances(.*)");
			partes = linea.split(" ");
			for(int i = 0; i < partes.length; i++) if(partes[partes.length - 1 - i].contains(".")) testing = partes[partes.length - 1 - i];
					
			porcentajes = porcentajes + k + " " + testing + " " + training + "\n";
		}
					
		guardarEn(porcentajes, pathEjercicio + "tablas\\IBK_porcentajes.txt");
	}
	
	private static void parsearResultadosParaMultilayerPerceptron(String pathEjercicio){
		
		int hiddenLayers;
		int max;
		String porcentajes;
		String linea;
		String partes[];
		String training;
		String testing;
		
		max = 20;
		hiddenLayers = 0;

		training = "";
		testing = "";
		porcentajes = "hiddenLayers testing training\n";
		
		while (hiddenLayers <= max){
			
			linea = buscar(pathEjercicio + "resultados\\MultilayerPerceptron\\MultilayerPerceptron_" + hiddenLayers + ".txt", "=== Error on training split ===", "Correctly Classified Instances(.*)");
			partes = linea.split(" ");
			for(int i = 0; i < partes.length; i++) if(partes[partes.length - 1 - i].contains(".")) training = partes[partes.length - 1 - i];
			
			linea = buscar(pathEjercicio + "resultados\\MultilayerPerceptron\\MultilayerPerceptron_" + hiddenLayers + ".txt", "=== Error on test split ===", "Correctly Classified Instances(.*)");
			partes = linea.split(" ");
			for(int i = 0; i < partes.length; i++) if(partes[partes.length - 1 - i].contains(".")) testing = partes[partes.length - 1 - i];
    		
			porcentajes = porcentajes + hiddenLayers + " " + testing + " " + training + "\n";
			
			hiddenLayers = hiddenLayers + 1;
		}
		
		guardarEn(porcentajes, pathEjercicio + "tablas\\MultilayerPerceptron_porcentajes.txt");
	}
	
	private static String buscar(String nombre, String patron1, String patron2){
		
		String linea;
		File archivo;
		FileReader fr;
		BufferedReader br;
		boolean proxima;
		
        linea = null;
		archivo = null;
		fr = null;
		br = null;
		proxima = false;

		try {
			
			 archivo = new File (nombre);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         while((linea = br.readLine()) != null){
	        	 //System.out.println(linea);
	        	 if(linea.matches(patron1)) proxima = true;
	        	 if(linea.matches(patron2) && (patron1.equals("") || proxima)) break;
	         }
	         
		} catch(Exception e){ e.printStackTrace(); } finally {

			try { if(null != fr) fr.close(); } catch (Exception e2){ e2.printStackTrace(); }
		}

		return linea;
	}

	public static void guardarEn(String cadena, String nombre){

		try {
			
			File archivo = new File(nombre);
			FileWriter writer = new FileWriter(archivo, true);
			writer.write(cadena);
			writer.close();

		} catch(IOException e){ e.printStackTrace(); };
	}
}
