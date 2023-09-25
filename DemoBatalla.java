import java.util.*;
public class DemoBatalla {
	public static void main(String [] args){
		Nave [] misNaves = new Nave[10];
		Scanner sc = new Scanner(System.in);
		String nomb, col;
		int fil, punt;
		boolean est;
		for (int i = 0; i < misNaves.length; i++) {
			System.out.println("Nave " + (i+1));
			System.out.print("Nombre: ");
			nomb = sc.next();
			System.out.println("Fila ");
			fil = sc.nextInt();
			System.out.print("Columna: ");
			col = sc.next();
			System.out.print("Estado: ");
			est = sc.nextBoolean();
			System.out.print("Puntos: ");
			punt = sc.nextInt();
			misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves
			misNaves[i].setNombre(nomb);
			misNaves[i].setFila(fil);
			misNaves[i].setColumna(col);
			misNaves[i].setEstado(est);
			misNaves[i].setPuntos(punt);
		}
		System.out.println("\nNaves creadas:");
		mostrarNaves(misNaves);
		mostrarPorNombre(misNaves);
		mostrarPorPuntos(misNaves);
		System.out.println("\nNave con mayor número de puntos: "); 
		mostrarMayorPuntos(misNaves);
	}
	//Método para mostrar todas las naves
	public static void mostrarNaves(Nave [] flota){
		for (int i = 0; i < flota.length; i++) {
			System.out.println("Nave " + (i+1));
			System.out.println("Nombre: " + flota[i].getNombre());
			System.out.println("Fila " + flota[i].getFila());
			System.out.println("Columna: " + flota[i].getColumna());
			System.out.println("Estado: " + flota[i].getEstado());
			System.out.println("Puntos: " + flota[i].getPuntos());
		}
	}
	//Método para mostrar todas las naves de un nombre que se pide por teclado
	public static void mostrarPorNombre(Nave [] flota){
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Que nave desea buscar?");
		String x = sc.next();
		for (int i = 0; i < flota.length; i++) {
			String name = flota[i].getNombre();
			if(name.equals(x)){
				System.out.println("Nave " + (i+1));
				System.out.println("Nombre: " + name);
			}
		}
	}
	//Método para mostrar todas las naves con un número de puntos inferior o igual
	//al número de puntos que se pide por teclado
	public static void mostrarPorPuntos(Nave [] flota){
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese un numero:");
		int n = sc.nextInt();
		for (int i = 0; i < flota.length; i++) {
			int puntos = flota[i].getPuntos();
			if(puntos <= n){
				System.out.println("Nave " + (i+1));
				System.out.println("Puntos: " + puntos);
			}
		}
	}
	//Método que devuelve la Nave con mayor número de Puntos
	public static void mostrarMayorPuntos(Nave [] flota){
		int mayor = 0;
		int naveMax = 0;
		for(int i = 0; i < flota.length; i++) {
			int puntos = flota[i].getPuntos();
			if(puntos > mayor){
				mayor = puntos;
				naveMax = i + 1;
			}
		}
		System.out.println("Nave " + naveMax);
		System.out.println("Puntos: " + mayor);
	}
}