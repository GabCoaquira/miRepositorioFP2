import java.util.*;
public class Laboratorio7{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		for(int w = 1; w > 0; w++){
			System.out.println("¿Desea empezar una nueva batalla?");
			String seguir = sc.next();
			if(seguir.equals("no")){
				break;
			}
			List<ArrayList<Soldado>> tablero = new ArrayList<>();
			for(int i = 0; i < 10; i++){
				ArrayList<Soldado> fila = new ArrayList<Soldado>();
				for(int j = 0; j < 10; j++){
					fila.add(new Soldado());
				}
				tablero.add(fila);
			}
			int m = (int)(Math.random()*10+1);
			for (int i = 0; i < m; i++) {
				String nomb = "Soldado" + i + "X1";
				int fil = (int)(Math.random()*10);
				String col = "";
				String banco = "ABCDEFGHIJ";
				int al = (int)(Math.random()*(banco.length() + 1));
				char caracter = banco.charAt(al);
				col += caracter;
				int c = numero(col);
				int punt = (int)(Math.random()*5+1);
				ArrayList<Soldado> f1 = tablero.get(fil);
				Soldado s1 = new Soldado();
				s1.setNombre(nomb);
				s1.setFila(fil + 1);
				s1.setCol(col);
				s1.setVida(punt);
				f1.set(c, s1);
				tablero.set(fil, f1);
			}
			int n = (int)(Math.random()*10+1);
			for (int i = 0; i < n; i++) {
				String nomb = "Soldado" + i + "X2";
				int fil = (int)(Math.random()*10);
				String col = "";
				String banco = "ABCDEFGHIJ";
				int al = (int)(Math.random()*(banco.length() + 1));
				char caracter = banco.charAt(al);
				col += caracter;
				int c = numero(col);
				int punt = (int)(Math.random()*5+1);
				ArrayList<Soldado> f2 = tablero.get(fil);
				Soldado s2 = new Soldado();
				s2.setNombre(nomb);
				s2.setFila(fil + 1);
				s2.setCol(col);
				s2.setVida(punt);
				f2.set(c, s2);
				tablero.set(fil, f2);
			}
			mostrarTablero(tablero);
			mostrarMayorVida(tablero);
			promedioVida(tablero);
			mostrarSoldados(tablero);
			ordenarBurbuja(tablero);
			ordenarSeleccion(tablero);
			mostrarGanador(tablero);
		}
	}
	public static int numero(String n){
		switch(n){
			case "A":
				return 0;
			case "B":
				return 1;
			case "C":
				return 2;
			case "D":
				return 3;
			case "E":
				return 4;
			case "F":
				return 5;
			case "G":
				return 6;
			case "H":
				return 7;
			case "I":
				return 8;
			case "J":
				return 9;
		}
		return -1;
	}
	public static void mostrarTablero(List<ArrayList<Soldado>> tablero){
		for (int i = 0; i < 10; i++){
			ArrayList<Soldado> f1 = tablero.get(i);
			for (int j = 0; j < 10; j++){
				Soldado s1 = f1.get(j);
				if(s1.getVida() != 0){
					String name = s1.getNombre();
					int life = s1.getVida();
					char ultimo = name.charAt(name.length() - 1);
					if(Character.compare(ultimo, '1') == 0){
						System.out.print("|1-" + life);
					}else{
						System.out.print("|2-" + life);
					}
				}else{
					System.out.print("|___");
				}
			}
			System.out.println("");
		}
	}
	public static void mostrarMayorVida(List<ArrayList<Soldado>> tablero){
		int mayor1 = 0;
		Soldado SoldMax1 = new Soldado();
		for(int i = 0; i < 10; i++) {
			ArrayList<Soldado> f1 = tablero.get(i);
			for(int j = 0; j < 10; j++){
				Soldado s1 = f1.get(j);
				int puntos = s1.getVida();
				if(puntos > mayor1){
					String name = s1.getNombre();
					char ultimo = name.charAt(name.length() - 1);
					if(Character.compare(ultimo, '1') == 0){
						mayor1 = puntos;
						SoldMax1 = s1;
					}
					
				}
			}
		}
		System.out.println("El soldado con mayor vida del primer ejercito es: " + SoldMax1.getNombre());
		System.out.println("Vida: " + mayor1);
		int mayor2 = 0;
		Soldado SoldMax2 = new Soldado();
		for(int i = 0; i < 10; i++) {
			ArrayList<Soldado> f1 = tablero.get(i);
			for(int j = 0; j < 10; j++){
				Soldado s2 = f1.get(j);
				int puntos = s2.getVida();
				if(puntos > mayor2){
					String name = s2.getNombre();
					char ultimo = name.charAt(name.length() - 1);
					if(Character.compare(ultimo, '2') == 0){
						mayor2 = puntos;
						SoldMax2 = s2;
					}
					
				}
			}
		}
		System.out.println("El soldado con mayor vida del segundo ejercito es: " + SoldMax2.getNombre());
		System.out.println("Vida: " + mayor2);
	}
	public static void promedioVida(List<ArrayList<Soldado>> tablero){
		double suma1 = 0.0;
		int contador1 = 0;
		for(int i = 0; i < 10; i++) {
			ArrayList<Soldado> f1 = tablero.get(i);
			for(int j = 0; j < 10; j++){
				Soldado s1 = f1.get(j);
				int puntos = s1.getVida();
				if(puntos > 0){
					String name = s1.getNombre();
					char ultimo = name.charAt(name.length() - 1);
					if(Character.compare(ultimo, '1') == 0){
						suma1 = suma1 + puntos;
						contador1++;
					}
				}
			}
		}
		double promedio1 = suma1/contador1;
		System.out.println("El promedio de puntos de vida del primer ejercito  es: " + promedio1);
		double suma2 = 0.0;
		int contador2 = 0;
		for(int i = 0; i < 10; i++) {
			ArrayList<Soldado> f1 = tablero.get(i);
			for(int j = 0; j < 10; j++){
				Soldado s2 = f1.get(j);
				int puntos = s2.getVida();
				if(puntos > 0){
					String name = s2.getNombre();
					char ultimo = name.charAt(name.length() - 1);
					if(Character.compare(ultimo, '2') == 0){
						suma2 = suma2 + puntos;
						contador2++;
					}
				}
			}
		}
		double promedio2 = suma2/contador2;
		System.out.println("El promedio de puntos de vida del segundo ejercito  es: " + promedio2);
	}
	public static void mostrarSoldados(List<ArrayList<Soldado>> tablero){
		System.out.println("Primer ejercito:");
		for(int i = 0; i < 10; i++) {
			ArrayList<Soldado> f1 = tablero.get(i);
			for(int j = 0; j < 10; j++){
				Soldado s1 = f1.get(j);
				int puntos = s1.getVida();
				if(puntos > 0){
					String name = s1.getNombre();
					char ultimo = name.charAt(name.length() - 1);
					if(Character.compare(ultimo, '1') == 0){
						System.out.println(s1.getNombre() + ":");
						System.out.println("Vida: " + s1.getVida());
						System.out.println("Fila: " + s1.getFila());
						System.out.println("Columna: " + s1.getCol());
					}
				}
			}
		}
		System.out.println("Segundo ejercito:");
		for(int i = 0; i < 10; i++) {
			ArrayList<Soldado> f1 = tablero.get(i);
			for(int j = 0; j < 10; j++){
				Soldado s2 = f1.get(j);
				int puntos = s2.getVida();
				if(puntos > 0){
					String name = s2.getNombre();
					char ultimo = name.charAt(name.length() - 1);
					if(Character.compare(ultimo, '2') == 0){
						System.out.println(s2.getNombre() + ":");
						System.out.println("Vida: " + s2.getVida());
						System.out.println("Fila: " + s2.getFila());
						System.out.println("Columna: " + s2.getCol());
					}
				}
			}
		}
	}
	public static void ordenarBurbuja(List<ArrayList<Soldado>> tablero){
		ArrayList<Soldado> ejercito1 = new ArrayList<Soldado>();
		ArrayList<Soldado> ejercito2 = new ArrayList<Soldado>();
		for(int i = 0; i < 10; i++) {
			ArrayList<Soldado> f1 = tablero.get(i);
			for(int j = 0; j < 10; j++){
				Soldado s1 = f1.get(j);
				int puntos = s1.getVida();
				if(puntos > 0){
					String name = s1.getNombre();
					char ultimo = name.charAt(name.length() - 1);
					if(Character.compare(ultimo, '1') == 0){
						ejercito1.add(s1);
					}
					if(Character.compare(ultimo, '2') == 0){
						ejercito2.add(s1);
					}
				}
			}
		}
		System.out.println("Ranking de poder del primer ejercito:");
		for(int i = 0; i < ejercito1.size(); i++){
			for(int j = 0; j < ejercito1.size() - 1; j++){
				Soldado actual = ejercito1.get(j);
				Soldado siguiente = ejercito1.get(j + 1);
				if(actual.getVida() < siguiente.getVida()){
					ejercito1.remove(j + 1);
					ejercito1.remove(j);
					ejercito1.add(j, siguiente);
					ejercito1.add(j + 1, actual);
				}
			}
		}
		for(int i = 0; i < ejercito1.size(); i++){
			System.out.println(ejercito1.get(i).getNombre() + ":");
			System.out.println("Vida: " + ejercito1.get(i).getVida());
			System.out.println("Fila: " + ejercito1.get(i).getFila());
			System.out.println("Columna: " + ejercito1.get(i).getCol());
		}
		System.out.println("Ranking de poder del segundo ejercito:");
		for(int i = 0; i < ejercito2.size(); i++){
			for(int j = 0; j < ejercito2.size() - 1; j++){
				Soldado actual = ejercito2.get(j);
				Soldado siguiente = ejercito2.get(j + 1);
				if(actual.getVida() < siguiente.getVida()){
					ejercito2.remove(j + 1);
					ejercito2.remove(j);
					ejercito2.add(j, siguiente);
					ejercito2.add(j + 1, actual);
				}
			}
		}
		for(int i = 0; i < ejercito2.size(); i++){
			System.out.println(ejercito2.get(i).getNombre() + ":");
			System.out.println("Vida: " + ejercito2.get(i).getVida());
			System.out.println("Fila: " + ejercito2.get(i).getFila());
			System.out.println("Columna: " + ejercito2.get(i).getCol());
		}
	}
	public static void ordenarSeleccion(List<ArrayList<Soldado>> tablero){
		ArrayList<Soldado> ejercito1 = new ArrayList<Soldado>();
		ArrayList<Soldado> ejercito2 = new ArrayList<Soldado>();
		for(int i = 0; i < 10; i++) {
			ArrayList<Soldado> f1 = tablero.get(i);
			for(int j = 0; j < 10; j++){
				Soldado s1 = f1.get(j);
				int puntos = s1.getVida();
				if(puntos > 0){
					String name = s1.getNombre();
					char ultimo = name.charAt(name.length() - 1);
					if(Character.compare(ultimo, '1') == 0){
						ejercito1.add(s1);
					}
					if(Character.compare(ultimo, '2') == 0){
						ejercito2.add(s1);
					}
				}
			}
		}
		System.out.println("Ranking de poder del primer ejercito:");
		for(int i = 0; i < ejercito1.size(); i++){
			int mayor = 0;
			Soldado max = new Soldado();
			int pos = i;
			for(int j = i + 1; j < ejercito1.size(); j++){
				Soldado sj = ejercito1.get(j);
				if(sj.getVida() > mayor){
					mayor = sj.getVida();
					pos = j;
				}
			}
			if(pos != i){
				max = ejercito1.get(pos);
				Soldado tmp = ejercito1.get(i);
				ejercito1.remove(i);
				ejercito1.add(i, max);
				ejercito1.remove(pos);
				ejercito1.add(pos, tmp);
			}
		}
		for(int i = 0; i < ejercito1.size(); i++){
			System.out.println(ejercito1.get(i).getNombre() + ":");
			System.out.println("Vida: " + ejercito1.get(i).getVida());
			System.out.println("Fila: " + ejercito1.get(i).getFila());
			System.out.println("Columna: " + ejercito1.get(i).getCol());
		}
		System.out.println("Ranking de poder del segundo ejercito:");
		for(int i = 0; i < ejercito2.size(); i++){
			int mayor = 0;
			Soldado max = new Soldado();
			int pos = i;
			for(int j = i + 1; j < ejercito2.size(); j++){
				Soldado sj = ejercito2.get(j);
				if(sj.getVida() > mayor){
					mayor = sj.getVida();
					pos = j;
				}
			}
			if(pos != i){
				max = ejercito2.get(pos);
				Soldado tmp = ejercito2.get(i);
				ejercito2.remove(i);
				ejercito2.add(i, max);
				ejercito2.remove(pos);
				ejercito2.add(pos, tmp);
			}
		}
		for(int i = 0; i < ejercito2.size(); i++){
			System.out.println(ejercito2.get(i).getNombre() + ":");
			System.out.println("Vida: " + ejercito2.get(i).getVida());
			System.out.println("Fila: " + ejercito2.get(i).getFila());
			System.out.println("Columna: " + ejercito2.get(i).getCol());
		}
	}
	//se mostrará como ganador al ejercito que tenga mayor vida en total
	public static void mostrarGanador(List<ArrayList<Soldado>> tablero){
		int suma1 = 0;
		for(int i = 0; i < 10; i++) {
			ArrayList<Soldado> f1 = tablero.get(i);
			for(int j = 0; j < 10; j++){
				Soldado s1 = f1.get(j);
				int puntos = s1.getVida();
				if(puntos > 0){
					String name = s1.getNombre();
					char ultimo = name.charAt(name.length() - 1);
					if(Character.compare(ultimo, '1') == 0){
						suma1 = suma1 + puntos;
					}
				}
			}
		}
		int suma2 = 0;
		for(int i = 0; i < 10; i++) {
			ArrayList<Soldado> f1 = tablero.get(i);
			for(int j = 0; j < 10; j++){
				Soldado s2 = f1.get(j);
				int puntos = s2.getVida();
				if(puntos > 0){
					String name = s2.getNombre();
					char ultimo = name.charAt(name.length() - 1);
					if(Character.compare(ultimo, '2') == 0){
						suma2 = suma2 + puntos;
					}
				}
			}
		}
		if(suma1 == suma2){
			System.out.println("Es un empate!!!");
		}else{
			if(suma1 > suma2){
				System.out.println("El ganador es el Ejercito X1!!!");
			}else{
				System.out.println("El ganador es el Ejercito X2!!!");
			}
		}
	}
}