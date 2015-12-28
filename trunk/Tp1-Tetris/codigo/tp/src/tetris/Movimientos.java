package tetris;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public  class  Movimientos {
	
	private Map<String, Set<Movimiento>> tabla;
	private static Movimientos movimientos;
	
	private Movimientos(){
		
		Movimiento movimiento;
		String cadena;
		
		tabla = new HashMap<String, Set<Movimiento>>();
		cadena = new String("");
		
		//Para la pieza "I":
		
			tabla.put(new String("I"), new HashSet<Movimiento>());
			cadena = cadena + "Para la letra I:\n\n";
			
			//Sin girar:
		
			movimiento = new Movimiento("I", 1, 4, new HashSet<Coordenada>(), 0);		
			movimiento.forma.add(new Coordenada(1,1));
			movimiento.forma.add(new Coordenada(1,2));
			movimiento.forma.add(new Coordenada(1,3));
			movimiento.forma.add(new Coordenada(1,4));		
			
			tabla.get("I").add(movimiento);
			cadena = cadena + movimiento.toString();
		
			//1 giro:
		
			movimiento = new Movimiento("I", 4, 1, new HashSet<Coordenada>(), 1);		
			movimiento.forma.add(new Coordenada(1,1));
			movimiento.forma.add(new Coordenada(2,1));
			movimiento.forma.add(new Coordenada(3,1));
			movimiento.forma.add(new Coordenada(4,1));
			
			tabla.get("I").add(movimiento);
			cadena = cadena + movimiento.toString();
			
			
		//Para la pieza "J":
			
			tabla.put(new String("J"), new HashSet<Movimiento>());
			cadena = cadena + "Para la letra J:\n\n";
		
			//Sin girar:
		
			movimiento = new Movimiento("J", 2, 3, new HashSet<Coordenada>(), 0);		
			movimiento.forma.add(new Coordenada(1,1));
			movimiento.forma.add(new Coordenada(2,1));
			movimiento.forma.add(new Coordenada(2,2));
			movimiento.forma.add(new Coordenada(2,3));		
			
			tabla.get("J").add(movimiento);
			cadena = cadena + movimiento.toString();
			
			//1 giro:
			
			movimiento = new Movimiento("J", 3, 2, new HashSet<Coordenada>(), 1);		
			movimiento.forma.add(new Coordenada(1,1));
			movimiento.forma.add(new Coordenada(1,2));
			movimiento.forma.add(new Coordenada(2,1));
			movimiento.forma.add(new Coordenada(3,1));		
			
			tabla.get("J").add(movimiento);
			cadena = cadena + movimiento.toString();
			
			//2 giros:
			
			movimiento = new Movimiento("J", 2, 3, new HashSet<Coordenada>(), 2);		
			movimiento.forma.add(new Coordenada(1,1));
			movimiento.forma.add(new Coordenada(1,2));
			movimiento.forma.add(new Coordenada(1,3));
			movimiento.forma.add(new Coordenada(2,3));		
			
			tabla.get("J").add(movimiento);
			cadena = cadena + movimiento.toString();
			
			//3 giros:
			
			movimiento = new Movimiento("J", 3, 2, new HashSet<Coordenada>(), 3);		
			movimiento.forma.add(new Coordenada(1,2));
			movimiento.forma.add(new Coordenada(2,2));
			movimiento.forma.add(new Coordenada(3,1));
			movimiento.forma.add(new Coordenada(3,2));
			
			tabla.get("J").add(movimiento);
			cadena = cadena + movimiento.toString();
		
		//Para la pieza "L":
			
			tabla.put(new String("L"), new HashSet<Movimiento>());
			cadena = cadena + "Para la letra L:\n\n";
			
			//Sin girar:
		
			movimiento = new Movimiento("L", 2, 3, new HashSet<Coordenada>(), 0);		
			movimiento.forma.add(new Coordenada(1,3));
			movimiento.forma.add(new Coordenada(2,1));
			movimiento.forma.add(new Coordenada(2,2));
			movimiento.forma.add(new Coordenada(2,3));		
			
			tabla.get("L").add(movimiento);
			cadena = cadena + movimiento.toString();
			
			//1 giro:
			
			movimiento = new Movimiento("L", 3, 2, new HashSet<Coordenada>(), 1);		
			movimiento.forma.add(new Coordenada(1,1));
			movimiento.forma.add(new Coordenada(2,1));
			movimiento.forma.add(new Coordenada(3,1));
			movimiento.forma.add(new Coordenada(3,2));		
			
			tabla.get("L").add(movimiento);
			cadena = cadena + movimiento.toString();
			
			//2 giros:
			
			movimiento = new Movimiento("L", 2, 3, new HashSet<Coordenada>(), 2);		
			movimiento.forma.add(new Coordenada(1,1));
			movimiento.forma.add(new Coordenada(1,2));
			movimiento.forma.add(new Coordenada(1,3));
			movimiento.forma.add(new Coordenada(2,1));		
			
			tabla.get("L").add(movimiento);
			cadena = cadena + movimiento.toString();
			
			//3 giros:
			
			movimiento = new Movimiento("L", 3, 2, new HashSet<Coordenada>(), 3);		
			movimiento.forma.add(new Coordenada(1,1));
			movimiento.forma.add(new Coordenada(1,2));
			movimiento.forma.add(new Coordenada(2,2));
			movimiento.forma.add(new Coordenada(3,2));
			
			tabla.get("L").add(movimiento);
			cadena = cadena + movimiento.toString();
			
		//Para la pieza "O":
			
			tabla.put(new String("O"), new HashSet<Movimiento>());
			cadena = cadena + "Para la letra O:\n\n";
		
			//Sin girar:
		
			movimiento = new Movimiento("O", 2, 2, new HashSet<Coordenada>(), 0);		
			movimiento.forma.add(new Coordenada(1,1));
			movimiento.forma.add(new Coordenada(1,2));
			movimiento.forma.add(new Coordenada(2,1));
			movimiento.forma.add(new Coordenada(2,2));		
			
			tabla.get("O").add(movimiento);
			cadena = cadena + movimiento.toString();
			
		//Para la pieza "T":
			
			tabla.put(new String("T"), new HashSet<Movimiento>());
			cadena = cadena + "Para la letra T:\n\n";
			
			//Sin girar:
		
			movimiento = new Movimiento("T", 2, 3, new HashSet<Coordenada>(), 0);		
			movimiento.forma.add(new Coordenada(1,2));
			movimiento.forma.add(new Coordenada(2,1));
			movimiento.forma.add(new Coordenada(2,2));
			movimiento.forma.add(new Coordenada(2,3));		
			
			tabla.get("T").add(movimiento);
			cadena = cadena + movimiento.toString();
			
			//1 giro:
			
			movimiento = new Movimiento("T", 3, 2, new HashSet<Coordenada>(), 1);		
			movimiento.forma.add(new Coordenada(1,1));
			movimiento.forma.add(new Coordenada(2,1));
			movimiento.forma.add(new Coordenada(3,1));
			movimiento.forma.add(new Coordenada(2,2));		
			
			tabla.get("T").add(movimiento);
			cadena = cadena + movimiento.toString();
			
			//2 giros:
			
			movimiento = new Movimiento("T", 2, 3, new HashSet<Coordenada>(), 2);		
			movimiento.forma.add(new Coordenada(1,1));
			movimiento.forma.add(new Coordenada(1,2));
			movimiento.forma.add(new Coordenada(1,3));
			movimiento.forma.add(new Coordenada(2,2));		
			
			tabla.get("T").add(movimiento);
			cadena = cadena + movimiento.toString();
			
			//3 giros:
			
			movimiento = new Movimiento("T", 3, 2, new HashSet<Coordenada>(), 3);		
			movimiento.forma.add(new Coordenada(2,1));
			movimiento.forma.add(new Coordenada(1,2));
			movimiento.forma.add(new Coordenada(2,2));
			movimiento.forma.add(new Coordenada(3,2));
			
			tabla.get("T").add(movimiento);
			cadena = cadena + movimiento.toString();

		//Para la pieza "S":
			
			tabla.put(new String("S"), new HashSet<Movimiento>());
			cadena = cadena + "Para la letra S:\n\n";
			
			//Sin girar:
		
			movimiento = new Movimiento("S", 2, 3, new HashSet<Coordenada>(), 0);		
			movimiento.forma.add(new Coordenada(2,1));
			movimiento.forma.add(new Coordenada(2,2));
			movimiento.forma.add(new Coordenada(1,2));
			movimiento.forma.add(new Coordenada(1,3));		
			
			tabla.get("S").add(movimiento);
			cadena = cadena + movimiento.toString();
			
			//1 giro:
			
			movimiento = new Movimiento("S", 3, 2, new HashSet<Coordenada>(), 1);		
			movimiento.forma.add(new Coordenada(1,1));
			movimiento.forma.add(new Coordenada(2,1));
			movimiento.forma.add(new Coordenada(2,2));
			movimiento.forma.add(new Coordenada(3,2));		
			
			tabla.get("S").add(movimiento);
			cadena = cadena + movimiento.toString();
			
		//Para la pieza "Z":
			
			tabla.put(new String("Z"), new HashSet<Movimiento>());
			cadena = cadena + "Para la letra Z:\n\n";
			
			//Sin girar:
		
			movimiento = new Movimiento("Z", 2, 3, new HashSet<Coordenada>(), 0);		
			movimiento.forma.add(new Coordenada(1,1));
			movimiento.forma.add(new Coordenada(1,2));
			movimiento.forma.add(new Coordenada(2,2));
			movimiento.forma.add(new Coordenada(2,3));		
			
			tabla.get("Z").add(movimiento);
			cadena = cadena + movimiento.toString();
			
			//1 giro:
			
			movimiento = new Movimiento("Z", 3, 2, new HashSet<Coordenada>(), 1);		
			movimiento.forma.add(new Coordenada(2,1));
			movimiento.forma.add(new Coordenada(3,1));
			movimiento.forma.add(new Coordenada(2,2));
			movimiento.forma.add(new Coordenada(1,2));		
			
			tabla.get("Z").add(movimiento);
			cadena = cadena + movimiento.toString();
			
			//System.out.print(cadena);
	}
	
	public static Movimientos getInstance(){
		
		if(movimientos == null) movimientos = new Movimientos();
		
		return movimientos;
	}
	
	public Map<String, Set<Movimiento>> getTabla(){
		
		return tabla;
	}
	

}
