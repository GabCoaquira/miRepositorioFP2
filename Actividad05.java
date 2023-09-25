import java.util.*;
public class Actividad05{
	public static void main(String[] args){
		Random rand = new Random();		
		int n = rand.nextInt(5);
		Soldado[] ejercito1 = new Soldado[n];
		int m = rand.nextInt(5);
		Soldado[] ejercito2 = new Soldado[m];
		crearEjercito(ejercito1);
		crearEjercito(ejercito2);
		System.out.println("Primer ejercito:");
		imprimirEjercito(ejercito1);
		System.out.println("Segundo ejercito:");
		imprimirEjercito(ejercito2);
		System.out.println("El ejercito ganador es:");
		imprimirGanador(ejercito1, ejercito2);
	}
	public static void crearEjercito(Soldado[] a){
		for(int i = 0; i < a.length; i++){
			String nomb = "Soldado " + i;
			a[i] = new Soldado();
			a[i].setNombre(nomb);
		}
	}
	public static void imprimirEjercito(Soldado[] a){
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i].getNombre());
		}
	}
	public static void imprimirGanador(Soldado[] a, Soldado[] b){
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