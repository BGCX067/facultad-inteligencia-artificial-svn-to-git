package problema;

public class Parametros {

	public static int longitud_cadena = 5;
	//probProximaLetra[0][1] prob de letra A, dado que estoy en letra empty
	public  static final double[][] probProximaLetra =
				// Letra.Empty, Letra.A, Letra.B, Letra.C	
/*Letra.Empty */{ {0.25 , 0.25, 0.25,0.25},
/*Letra.A	 */ {0.5 , 0, 0.25, 0.25},
/*Letra.B	 */ {0.125 ,0.5, 0.125, 0.25},
/*Letra.C	 */ {0.25 ,0.125, 0.5, 0.125}};

	//probConfusionLetra [0][1] prob de letra empty, sea interpretada como letra A 
	public  static final double[][] probConfusionLetraTrivial =
				// Letra.Empty, Letra.A, Letra.B, Letra.C	
/*Letra.Empty */{ {1 , 0, 0, 0},
/*Letra.A	 */ {0 , 1, 0, 0},
/*Letra.B	 */ {0 ,0, 1, 0},
/*Letra.C	 */ {0 ,0,0, 1}};
	//probConfusionLetra [0][1] prob de letra empty, sea interpretada como letra A 
	public  static final double[][] probConfusionLetra =
				// Letra.Empty, Letra.A, Letra.B, Letra.C	
/*Letra.Empty */{ {0.9 , 0.1, 0, 0},
/*Letra.A	 */ {0.1 , 0.8, 0.1, 0},
/*Letra.B	 */ {0 ,0.1, 0.8, 0.1},
/*Letra.C	 */ {0 ,0.1,0.1, 0.8}};
}
