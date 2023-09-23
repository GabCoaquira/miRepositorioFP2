import java.util.*;
public class Actividad2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String soldado1, soldado2, soldado3, soldado4, soldado5;
		System.out.println("ingresar nombres de los soldados:");
		soldado1 = sc.next();
		soldado2 = sc.next();
		soldado3 = sc.next();
		soldado4 = sc.next();
		soldado5 = sc.next();
		System.out.println("ingresar el nivel de vida de los soldados:");
		int vida1 = sc.nextInt();
		int vida2 = sc.nextInt();
		int vida3 = sc.nextInt();
		int vida4 = sc.nextInt();
		int vida5 = sc.nextInt();
		System.out.println("Primer soldado: " + soldado1);
		System.out.println("Nivel de vida: " + vida1);
		System.out.println("Segundo soldado: " + soldado2);
		System.out.println("Nivel de vida: " + vida2);
		System.out.println("Tercer soldado: " + soldado3);
		System.out.println("Nivel de vida: " + vida3);
		System.out.println("Cuarto soldado: " + soldado4);
		System.out.println("Nivel de vida: " + vida4);
		System.out.println("Quinto soldado: " + soldado5);
		System.out.println("Nivel de vida: " + vida5);
	}
}