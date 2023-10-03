import java.util.*;
public class Laboratorio4{
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
		System.out.println("Naves creadas:");
		mostrarNaves(misNaves);
		mostrarPorNombre(misNaves);
		mostrarPorPuntos(misNaves);
		System.out.println("Nave con mayor número de puntos:"); 
		mostrarMayorPuntos(misNaves);
		System.out.println("Ingresar el nombre que desea buscar:");
		String nombre = sc.next();
		int pos = busquedaLinealNombre(misNaves,nombre);
		if(pos == -1){
			System.out.println("Nave no encontrada");
		}else{
			System.out.println("Nave " + (pos + 1));
			System.out.println("Nombre: " + misNaves[pos].getNombre());
			System.out.println("Fila: " + misNaves[pos].getFila());
			System.out.println("Columna: " + misNaves[pos].getColumna());
			System.out.println("Estado: " + misNaves[pos].getEstado());
			System.out.println("Puntos: " + misNaves[pos].getPuntos());
		}
		ordenarPorPuntosBurbuja(misNaves);
		mostrarNaves(misNaves);
		ordenarPorNombreBurbuja(misNaves);
		mostrarNaves(misNaves);
		System.out.println("Ingresar el nombre que desea buscar:");
		String name = sc.next();
		int bin = busquedaBinariaNombre(misNaves,name);
		if(bin == -1){
			System.out.println("Nave no encontrada");
		}else{
			System.out.println("Nave " + (bin + 1));
			System.out.println("Nombre: " + misNaves[bin].getNombre());
			System.out.println("Fila: " + misNaves[bin].getFila());
			System.out.println("Columna: " + misNaves[bin].getColumna());
			System.out.println("Estado: " + misNaves[bin].getEstado());
			System.out.println("Puntos: " + misNaves[bin].getPuntos());
		}
	}
	//Método para mostrar todas las naves
	public static void mostrarNaves(Nave [] flota){
		for (int i = 0; i < flota.length; i++) {
			System.out.println("Nave " + (i+1));
			System.out.println("Nombre: " + flota[i].getNombre());
			System.out.println("Fila: " + flota[i].getFila());
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
	//Método para buscar la primera nave con un nombre que se pidio por teclado
	public static int busquedaLinealNombre(Nave [] flota, String s){
		for (int i = 0; i < flota.length; i++) {
			String name = flota[i].getNombre();
			if(name.equals(s)){
				return i;
			}
		}
		return -1;
	}
	//Método que ordena por numero de puntos de menor a mayor
	public static void ordenarPorPuntosBurbuja(Nave [] flota){
		for(int i = 0; i < flota.length; i++){
			for(int j = 0; j < flota.length - 1; j++){
				Nave ahora = flota[j];
				int actual = flota[j].getPuntos();
				int siguiente = flota[j + 1].getPuntos();
				if(actual > siguiente){
					flota[j] = flota[j + 1];
					flota[j + 1] = ahora;
				}
			}
		}
	}
	//Método que ordena por nombre de A a Z
	public static void ordenarPorNombreBurbuja(Nave [] flota){
		for(int i = 0; i < flota.length; i++){
			for(int j = 0; j < flota.length - 1; j++){
				Nave ahora = flota[j];
				String actual = flota[j].getNombre();
				String siguiente = flota[j + 1].getNombre();
				if(actual.compareTo(siguiente) > 0){
					flota[j] = flota[j + 1];
					flota[j + 1] = ahora;
				}
			}
		}
	}
	//Método para buscar la primera nave con un nombre que se pida
	public static int busquedaBinariaNombre(Nave [] flota, String s){
		int media;
		int baja = 0;
		int alta = flota.length - 1;
		while(baja <= alta){
			media = (alta + baja)/2;
			String name = flota[media].getNombre();
			if(name.equals(s)){
				return media;
			}else{
				if(s.compareTo(name) < 0){
					alta = media - 1;
				}else{
					baja = media + 1;
				}
			}
		}
		return -1;
	}
	
}