public class Laboratorio5{
	public static void main(String[] args){
		int n = (int)(Math.random()*10+1);
		Soldado [][] ejercito1 = new Soldado[10][10];
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				ejercito1[i][j] = new Soldado();
			}
		}
		String nomb, col;
		int fil, punt;
		for (int i = 0; i < n; i++) {
			nomb = "Soldado" + i;
			fil = (int)(Math.random()*10);
			col = "";
			String banco = "ABCDEFGHIJ";
			int al = (int)(Math.random()*(banco.length() + 1));
			char caracter = banco.charAt(al);
			col += caracter;
			int c = numero(col);
			punt = (int)(Math.random()*5+1);
			ejercito1 [fil][c].setNombre(nomb);
			ejercito1 [fil][c].setFila(fil);
			ejercito1 [fil][c].setCol(col);
			ejercito1 [fil][c].setVida(punt);
		}
		mostrarTablero(ejercito1);
		mostrarMayorVida(ejercito1);
		promedioVida(ejercito1);
		vidaTotal(ejercito1);
		mostrarSoldados(ejercito1);
	}
	public static void mostrarTablero(Soldado [][] ejercito1){
		for (int i = 0; i < ejercito1.length; i++){
			for (int j = 0; j < ejercito1[i].length; j++){
				Soldado s1 = ejercito1[i][j];
				if(s1.getVida() != 0){
					System.out.print("|s");
				}else{
					System.out.print("|_");
				}
			}
			System.out.println("");
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
	public static void mostrarMayorVida(Soldado [][] ejer){
		int mayor = 0;
		Soldado SoldMax = new Soldado();
		for(int i = 0; i < ejer.length; i++) {
			for(int j = 0; j < ejer[i].length; j++){
				int puntos = ejer[i][j].getVida();
				if(puntos > mayor){
					mayor = puntos;
					SoldMax = ejer[i][j];
				}
			}
		}
		System.out.println(SoldMax.getNombre());
		System.out.println("Vida: " + mayor);
	}
	public static void promedioVida(Soldado [][] ejer){
		double suma = 0.0;
		double contador = 0.0;
		for(int i = 0; i < ejer.length; i++) {
			for(int j = 0; j < ejer[i].length; j++){
				int puntos = ejer[i][j].getVida();
				if(puntos > 0){
					suma = suma + puntos;
					contador++;
				}
			}
		}
		double promedio = suma/contador;
		System.out.println("El promedio de puntos de vida es: " + promedio);
	}
	public static void vidaTotal(Soldado [][] ejer){
		int suma = 0;
		for(int i = 0; i < ejer.length; i++) {
			for(int j = 0; j < ejer[i].length; j++){
				int puntos = ejer[i][j].getVida();
				if(puntos > 0){
					suma = suma + puntos;
				}
			}
		}
		System.out.println("El nivel de vida de todo el ejercito es: " + suma);
	}
	public static void mostrarSoldados(Soldado [][] ejer){
		for(int i = 0; i < ejer.length; i++) {
			for(int j = 0; j < ejer[i].length; j++){
				int puntos = ejer[i][j].getVida();
				if(puntos > 0){
					System.out.println(ejer[i][j].getNombre() + ":");
					System.out.println("Vida: " + ejer[i][j].getVida());
					System.out.println("Fila: " + ejer[i][j].getFila());
					System.out.println("Columna: " + ejer[i][j].getCol());
				}
			}
		}
	}
}