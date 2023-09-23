import java.util.*;
public class Actividad3{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] soldados = new String[5];
		for(int i = 0; i < 5; i++){
			System.out.println("ingresar nombre del soldado:");
			soldados[i] = sc.next();
		}
		for(int i = 0; i < 5; i++){
			System.out.println("Soldado " + i + ": " + soldados[i]);
		}
	}
}