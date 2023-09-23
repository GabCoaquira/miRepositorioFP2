import java.util.*;
public class Actividad5{
	public static void main(String[] args){
		Random rand = new Random();		
		int n = rand.nextInt(5);
		String[] ejercito1 = new String[n];
		int m = rand.nextInt(5);
		String[] ejercito2 = new String[m];
		crearEjercito(ejercito1);
		crearEjercito(ejercito2);
		System.out.println("Primer ejercito:");
		imprimirEjercito(ejercito1);
		System.out.println("Segundo ejercito:");
		imprimirEjercito(ejercito2);
		System.out.println("El ejercito ganador es:");
		imprimirGanador(ejercito1, ejercito2);
	}
	public static void crearEjercito(String[] a){
		for(int i = 0; i < a.length; i++){
			a[i] = "Soldado" + i;
		}
	}
	public static void imprimirEjercito(String[] a){
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}
	public static void imprimirGanador(String[] a, String[] b){
		if(a.length == b.length){
			System.out.println("Es un empate!!!");
		}
		if(a.length > b.length){
			System.out.println("Ejercito1:");
			imprimirEjercito(a);
		}else{
			System.out.println("Ejercito2:");
			imprimirEjercito(b);
		}
	}
}