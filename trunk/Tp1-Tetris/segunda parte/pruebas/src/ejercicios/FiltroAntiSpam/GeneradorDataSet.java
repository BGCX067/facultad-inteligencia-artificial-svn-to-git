package ejercicios.FiltroAntiSpam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

public class GeneradorDataSet {

	
	public static void Generar(String outputFile, String inputPath, HashMap<String,Atributo> atributos) throws MessagingException{
		
		try {

			File archivo = new File(outputFile);
			FileWriter writer = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(writer);
			
			GenerarEncabezado(atributos, bw);
			
			File dir = new File(inputPath);
			File[] files = dir.listFiles();
			for (File subDir: files) {
				if(subDir.isDirectory()){
					for (File file: subDir.listFiles()) {
						GenerarRegistro(file,bw, atributos, subDir.getName());
					}
				}
				
			}
			bw.close();
			writer.close();

		} catch(IOException e){ e.printStackTrace(); };
	}

	private static void GenerarEncabezado(HashMap<String,Atributo> atributos,
			BufferedWriter bw) throws IOException {
	
		bw.write("@relation spam \n");
		for (String  a : atributos.keySet()) {
			bw.write("@attribute"+atributos.get(a).toString() +"\n");
		}
		bw.write("@attribute 'Class' { 'spam', 'noSpam'} \n@data \n");
	}

	private static void GenerarRegistro(File file, BufferedWriter bw, HashMap<String,Atributo> atributos, String className) throws IOException, MessagingException {
		 Properties props = System.getProperties();
		 Session mailSession = Session.getDefaultInstance(props, null);

	     InputStream source = new FileInputStream(file);
	     MimeMessage message = new MimeMessage(mailSession, source);


		BufferedReader reader = new BufferedReader(new FileReader(file));
		HashMap<String, String> resultados = new HashMap<String, String>();
		String line =reader.readLine();
		while(line !=  null){
			for (String key : atributos.keySet()) {
				resultados.put(key, atributos.get(key).GetValue(line, resultados.get(key)));	
			}
			line =reader.readLine();
		}
		//para respetar el orden de iteracion de encabezado
		for (String  a : atributos.keySet()) {
			bw.write(atributos.get(a).GetFinalValue(resultados.get(a))+",");
		}
		
		bw.write(className+"\n");
	}
}
