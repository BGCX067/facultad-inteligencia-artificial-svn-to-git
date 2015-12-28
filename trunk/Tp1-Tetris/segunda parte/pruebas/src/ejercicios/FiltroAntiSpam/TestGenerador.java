package ejercicios.FiltroAntiSpam;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

import sun.net.www.MimeEntry;

import junit.framework.TestCase;

public class TestGenerador extends TestCase {

	public void testPrueba1() throws Exception {
		String root = "D:\\Vivi\\facu\\InteligenciaArtificial\\Tp1-Tetris\\segunda parte\\archivos\\";
		String outputFile = root +"TestOut\\Prueba1.arff";
		String inputPath = root +"Test";
		HashMap<String,Atributo> atributos = new HashMap<String,Atributo>();
		
		atributos.put("SubjectSpam",new Atributo("SubjectSpam",new String[]{"salud","oferta","llam","familia","precio","publicidad", "bajá de peso", "baja de peso","viagra"},"?","Subject"));
		//atributos.put("SubjectSpam2",new Atributo("SubjectSpam2",new String[]{"$"},"?","Subject"));
		atributos.put("SubjectNoSpam",new Atributo("SubjectNoSpam",new String[]{"FCEyN","Materia","Re: [Docentes]","Re: [Alumnos]"},"?","Subject"));
		
		atributos.put("Subject",new Atributo("Subject",new String[]{"Materia","Re: [Docentes]","Re: [Alumnos]","imperdible","salud","familia","precio","publicidad", "bajá de peso", "baja de peso","viagra"},"?","Subject"));
		
		
		atributos.put("Imagen",new Atributo("Imagen",new String[]{"<img"},"?",""));
		atributos.put("PalabrasValidas",new Atributo("PalabrasValidas",new String[]{"informamos",
				"tesis","enseñ","asamblea","concurso","FCEyN"},"?",""));
		atributos.put("Saludos",new Atributo("Saludos",new String[]{"saludo","abrazo"},"?",""));
				
		atributos.put("PalabrasFacu",new Atributo("PalabrasFacu",new String[]{"docentes","JTP","materias",
			"estudiantes","exacta","aula","pabell"},"?",""));
		
		atributos.put("PalabrasInvalidas",new Atributo("PalabrasInvalidas",new String[]{
				"considerado SPAM", "tbol","futbol",
				"venus"},"?",""));
		atributos.put("PalabrasVentas",new Atributo("PalabrasVentas",new String[]{
				"fabrica","calidad","envio","envío","domicilio","free",
				"precio increible","promoci","garant",
				"sin cargo"},"?",""));
		
		atributos.put("CaracteristicaMailNeg",new Atributo("CaracteristicaMailNeg",new String[]{
		"@hotmail."},"?",""));
	
	//	atributos.put("X-MSMail-Priority:",new Atributo("X-MSMail-Priority:",new String[]{
		//"X-MSMail-Priority:"},"?",""));
	
		atributos.put("AttachmentExt",new Atributo("AttachmentExt",new String[]{
				".pdf",".gif"},"?",""));
		atributos.put("HTMLValues",new Atributo("HTMLValues",new String[]{
				"size=" ,  "text/css"},"?",""));
		atributos.put("Script",new Atributo("Script",new String[]{
				"JavaScript","script",
				"behavior:"},"?",""));
		//atributos.put("whiteList",new AtributoNegativo("whiteList",new String[]{
		//"USER_IN_WHITELIST"},"?","") );
		//atributos.put("Trabajo",new Atributo("Trabajo",new String[]{
		//		"trabajo","laboral"},"?",""));
		
	//	atributos.put("Script2",new Atributo("Script2",new String[]{
		//"script"},"?",""));
		atributos.put("CuentaTable",new AtributoAcumulativo("CuentaTable",null,"?","<table",4));
		//atributos.put("CuentaEnters",new AtributoEmptyLine("CuentaEnters",null,"?","",20));
		//atributos.put("CuentaFont",new AtributoAcumulativo("CuentaFont",null,"?","font",5));
		GeneradorDataSet.Generar(outputFile, inputPath, atributos);
		
	}
	public void LtestPrueba2() throws Exception {
		String root = "D:\\Vivi\\facu\\InteligenciaArtificial\\Tp1-Tetris\\segunda parte\\archivos\\";
		String outputFile = root +"TestOut\\Prueba2.arff";
		String inputPath = root +"Test";
		HashMap<String,Atributo> atributos = new HashMap<String,Atributo>();
		
		atributos.put("Subject",new Atributo("Subject",new String[]{"Materia","Re: [Docentes]","Re: [Alumnos]","imperdible","salud","familia","precio","publicidad", "bajá de peso", "baja de peso","viagra"},"?","Subject"));
		
		atributos.put("Imagen",new Atributo("Imagen",new String[]{"<img","informamos",
				"tesis","enseñ","asamblea","concurso"},"?",""));
		
		atributos.put("PalabrasInvalidas",new Atributo("PalabrasInvalidas",new String[]{
				"considerado SPAM", "fútbol","futbol","saludo","abrazo",
				"venus"},"?",""));
		atributos.put("PalabrasVentas",new Atributo("PalabrasVentas",new String[]{
				"fabrica","calidad","envio","envío","domicilio","free",
				"precio increible","promoci","garantía","garantia",
				"sin cargo","docentes","JTP","materias",
				"estudiantes","exacta","aula","pabellon","pabellón"},"?",""));
		
		atributos.put("CaracteristicaMailNeg",new Atributo("CaracteristicaMailNeg",new String[]{
		"@hotmail."},"?",""));
	
		atributos.put("AttachmentExt",new Atributo("AttachmentExt",new String[]{
				".pdf",".gif"},"?",""));
		atributos.put("HTMLValues",new Atributo("HTMLValues",new String[]{
				"<font","size=" , "color", "face","text/css"},"?",""));
		atributos.put("Script",new Atributo("Script",new String[]{
				"JavaScript","script"},"?",""));
		
	//	atributos.put("Script2",new Atributo("Script2",new String[]{
		//"script"},"?",""));
		
		GeneradorDataSet.Generar(outputFile, inputPath, atributos);
		
	}

}
