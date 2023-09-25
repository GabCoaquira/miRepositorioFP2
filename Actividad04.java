import java.util.*;
public class Actividad04{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Soldado[] soldados = new Soldado[5];
		for (int i = 0; i < soldados.length; i++) {
			System.out.println("Soldado " + (i+1));
			System.out.print("Nombre: ");
			String nomb = sc.next();
			System.out.print("Nivel de vida: ");
			int vida = sc.nextInt();
			soldados[i] = new Soldado();
			soldados[i].setNombre(nomb);
			soldados[i].setVida(vida);
		}
		System.out.println("Soldados ingresados:");
		for (int i = 0; i < soldados.length; i++) {
			System.out.println("Soldado " + (i+1));
			System.out.println("Nombre: " + soldados[i].getNombre());
			System.out.println("NIvel de vida: " + soldados[i].getVida());
		}
	}
}