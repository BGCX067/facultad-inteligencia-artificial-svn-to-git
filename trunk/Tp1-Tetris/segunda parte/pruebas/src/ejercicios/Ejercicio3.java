package ejercicios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		System.out.println("Comenzando...");
		
		//crearDatasets("C:\\dump\\ejercicio3\\");
		//prepararTests("C:\\dump\\ejercicio3\\");
		//parsearResultados("C:\\dump\\ejercicio3\\");
		
		System.out.println("Terminado!");
	}

	@SuppressWarnings("unused")
	private static void crearDatasets(String pathEjercicio) {
		
		Double porcentaje;
		String porcentajeString;
		String bat;
		
		porcentaje = 0.0;
		bat = "";
		
		while(porcentaje <= 35){
			
			if(porcentaje.toString().length() > 4){
				porcentajeString = porcentaje.toString().substring(0, 5);
			} else {
				porcentajeString = porcentaje.toString();
			}
			
			bat = bat + "java weka.filters.unsupervised.attribute.AddNoise -i " + pathEjercicio + "vote.arff -C last -P " + porcentajeString + " -S 1 -o " + pathEjercicio + "datasets\\ruido_" + porcentajeString + ".arff\n";
			porcentaje = porcentaje + 0.05;
		}
		
		bat = bat + "@pause\n";
		
		Ejercicio1.guardarEn(bat, pathEjercicio + "tests\\Ruido.bat");
	}

	@SuppressWarnings("unused")
	public static void prepararTests(String pathEjercicio){
		
		String j48;
		String ibk;
		String multilayerPerceptron;
		Set<String> estrategias;
		Double porcentaje;
		String porcentajeString;

		j48 = "";		
		ibk = "";
		multilayerPerceptron = "";
		
		porcentaje = 0.0;
			
		while (porcentaje <= 35){
			
			if(porcentaje.toString().length() > 4){
				porcentajeString = porcentaje.toString().substring(0, 5);
			} else {
				porcentajeString = porcentaje.toString();
			}
		
			j48 = j48 + "java weka.classifiers.trees.J48 -t " + pathEjercicio + "datasets\\ruido_" + porcentajeString + ".arff -C 0.25 -M 2 > " + pathEjercicio + "resultados\\J48\\J48_" + porcentajeString + ".txt\n";
			ibk = ibk + "java weka.classifiers.lazy.IBk -t " + pathEjercicio + "datasets\\ruido_" + porcentajeString + ".arff -K 1 -W 0 -A \"weka.core.neighboursearch.LinearNNSearch -A \\\"weka.core.EuclideanDistance -R first-last\\\"\" > " + pathEjercicio + "resultados\\IBK\\IBK_" + porcentajeString + ".txt\n";
			multilayerPerceptron = multilayerPerceptron + "java weka.classifiers.functions.MultilayerPerceptron -t " + pathEjercicio + "datasets\\ruido_" + porcentajeString + ".arff -L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H a > " + pathEjercicio + "resultados\\MultilayerPerceptron\\MultilayerPerceptron_" + porcentajeString + ".txt\n"; 
				
			porcentaje = porcentaje + 0.05;
		}
		
		j48 = j48 + "@pause\n";
		ibk = ibk + "@pause\n";
		multilayerPerceptron = multilayerPerceptron + "@pause\n";
			
		Ejercicio1.guardarEn(j48, pathEjercicio + "tests\\J48.bat");
		Ejercicio1.guardarEn(ibk, pathEjercicio + "tests\\IBK.bat");
		Ejercicio1.guardarEn(multilayerPerceptron, pathEjercicio + "tests\\MultilayerPerceptron.bat");
	}

	private static void parsearResultados(String pathEjercicio){
		
		Double porcentaje;
		String porcentajeString;
		String tamanios;
		String porcentajesJ48;
		String porcentajesIbk;
		String porcentajesMultilayerPerceptron;
		String linea;
		String partes[];
		
		tamanios = "faltantes hojas nodos\n";
		porcentajesJ48 = "faltantes cross-validation\n";
		porcentajesIbk = "faltantes cross-validation\n";
		porcentajesMultilayerPerceptron = "faltantes cross-validation\n";
			
		porcentaje = 0.0;
		
		while (porcentaje <= 35){
			
			if(porcentaje.toString().length() > 4){
				porcentajeString = porcentaje.toString().substring(0, 5);
			} else {
				porcentajeString = porcentaje.toString();
			}

			linea = Ejercicio1.buscar(pathEjercicio + "resultados\\J48\\J48_" + porcentajeString + ".txt", "", "Number of Leaves(.*)");
			partes = linea.split(":");
			tamanios = tamanios + porcentajeString + " " + partes[1].trim();
			
			linea = Ejercicio1.buscar(pathEjercicio + "resultados\\J48\\J48_" + porcentajeString + ".txt", "", "Size of the tree(.*)");
			partes = linea.split(":");
			tamanios = tamanios + " " + partes[1].trim() + "\n";
			
			linea = Ejercicio1.buscar(pathEjercicio + "resultados\\J48\\J48_" + porcentajeString + ".txt", "=== Stratified cross-validation ===", "Correctly Classified Instances(.*)");
			partes = linea.split(" ");
			for(int i = 0; i < partes.length; i++) if(partes[partes.length - 1 - i].contains(".")) porcentajesJ48 = porcentajesJ48 + porcentajeString + " " + partes[partes.length - 1 - i] + "\n";
			
			linea = Ejercicio1.buscar(pathEjercicio + "resultados\\IBK\\IBK_" + porcentajeString + ".txt", "=== Stratified cross-validation ===", "Correctly Classified Instances(.*)");
			partes = linea.split(" ");
			for(int i = 0; i < partes.length; i++) if(partes[partes.length - 1 - i].contains(".")) porcentajesIbk = porcentajesIbk + porcentajeString + " " + partes[partes.length - 1 - i] + "\n";
				
			linea = Ejercicio1.buscar(pathEjercicio + "resultados\\MultilayerPerceptron\\MultilayerPerceptron_" + porcentajeString + ".txt", "=== Stratified cross-validation ===", "Correctly Classified Instances(.*)");
			partes = linea.split(" ");
			for(int i = 0; i < partes.length; i++) if(partes[partes.length - 1 - i].contains(".")) porcentajesMultilayerPerceptron = porcentajesMultilayerPerceptron + porcentajeString + " " + partes[partes.length - 1 - i] + "\n";
				
			porcentaje = porcentaje + 0.05;
		}
		
		Ejercicio1.guardarEn(tamanios, pathEjercicio + "tablas\\J48_tamanios.txt");
		Ejercicio1.guardarEn(porcentajesJ48, pathEjercicio + "tablas\\J48_porcentajes.txt");
		Ejercicio1.guardarEn(porcentajesIbk, pathEjercicio + "tablas\\IBK_porcentajes.txt");
		Ejercicio1.guardarEn(porcentajesMultilayerPerceptron, pathEjercicio + "tablas\\MultilayerPerceptron_porcentajes.txt");
	}
}
