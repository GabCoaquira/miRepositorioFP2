import java.util.*;
public class Actividad4{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] soldados = new String[5];
		for(int i = 0; i < 5; i++){
			System.out.println("ingresar nombre del soldado:");
			soldados[i] = sc.next();
		}
		int[] nivelVida = new int[5];
		for(int i = 0; i < 5; i++){
			System.out.println("ingresar nivel de vida del soldado:");
			nivelVida[i] = sc.nextInt();
		}
		System.out.println("Nombres de los soldados:");
		for(int i = 0; i < 5; i++){
			System.out.println("Soldado " + i + ": " + soldados[i]);
		}
		System.out.println("Nivel de vida de los soldados:");
		for(int i = 0; i < 5; i++){
			System.out.println("Nivel de vida del soldado " + i + ": " + nivelVida[i]);
		}
	}
}