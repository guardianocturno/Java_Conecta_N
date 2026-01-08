package ConectaN;
import java.util.Scanner;

public class metodosConectaN {
	Scanner sc = new Scanner(System.in);

	char[][] tablero;
	public void crearTablero(int fila, int columna) {
		tablero = new char[fila][columna];
		for (int n = 0; n < fila; n++) {
			for (int n1 = 0; n1 < columna ;n1++) {
				tablero[n][n1]='*';
			}
		}
		
	}	
	
	public void mostrarTablero(int fila, int columna){
		for (int c = 0; c < fila; c++) {
			for (int f = 0; f < columna;f++) {
				System.out.print(tablero[c][f] + " ");
			}
			System.out.println(); 
		}
		
		//System.out.println("tamaño de columna: " + tablero[0].length);
		//System.out.println("tamaño de fila: " + tablero.length);

	}
	
	public void colocarPiezaA() {
		System.out.print("Di en que columna quieres poner la ficha A : ");
		int columna = sc.nextInt();
			for (int c=columna; c<=columna;c++) {
				for (int fila=tablero.length-1; fila>=0;fila--) {
					if (tablero[fila][columna]=='*') {
						tablero[fila][columna]='A';
						break;
					}
				}
			}
	}
	
	public void colocarPiezaB() {
		System.out.print("Di en que columna quieres poner la ficha B : ");
		int columna = sc.nextInt();
			for (int c=columna; c<=columna;c++) {
				for (int fila=tablero.length-1; fila>=0;fila--) {
					if (tablero[fila][columna]=='*') {
						tablero[fila][columna]='B';
						break;
					}
				}
			}
	}

	public void comprobarVertical() {
		for (int columna=0; columna<tablero[0].length;columna++) {
			int J1=0;
			int J2=0;
			for (int fila=0; fila<tablero.length;fila++) {
				if (tablero[fila][columna]=='A') {
					J1++;
					}
				else if (tablero[fila][columna]=='B'){
					J2++;
				}
				}
			if (J1==tablero.length) {
				System.out.print("Jugador 1 ha ganado en la columna " + columna);
			}else if (J2==tablero.length) {
				System.out.print("Jugador 2 ha ganado en la columna " + columna);
			}
			}
		
	}
	
	public void comprobarHorizontal() {
		for (int fila=0; fila<tablero.length;fila++) {
			int J1=0;
			int J2=0;
			for (int columna=0; columna<tablero[0].length;columna++) {
				if (tablero[fila][columna]=='A') {
					J1++;
					}
				else if (tablero[fila][columna]=='B'){
					J2++;
				}
				}
			if (J1==tablero[0].length) {
				System.out.print("Jugador 1 ha ganado en la fila " + fila);
			}else if (J2==tablero[0].length) {
				System.out.print("Jugador 2 ha ganado en la fila " + fila);
			}
			}
		
	}
	
	public void comprobarDiagonalDescendente() {
		int J1=0;
		int J2=0;

		for (int columna=0;columna<tablero[0].length;columna++) {
			for (int fila=0;fila<=columna;fila++) {
				if (tablero[fila][columna]=='A') {
					J1++;
					}
				else if (tablero[fila][columna]=='B'){
					J2++;
				}
			}
			if (J1==tablero.length) {
				System.out.print("Jugador 1 ha ganado en la Diagonal Descendente");
			}else if (J2==tablero.length) {
				System.out.print("Jugador 2 ha ganado en la Diagonal Descendente");
			}
		}
	}
	
}

