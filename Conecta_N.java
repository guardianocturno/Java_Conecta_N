package ConectaN;
import java.util.Scanner;
public class Conecta_N {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		metodosConectaN juego = new metodosConectaN();
		
		System.out.print("Dime las filas del tablero: ");
		int p = sc.nextInt();
		System.out.print("Dime las columnas del tablero: ");
		int m = sc.nextInt();
		
		juego.crearTablero(p,m);
		juego.mostrarTablero(p,m);
		
		juego.colocarPiezaA();
		juego.colocarPiezaB();
		juego.mostrarTablero(p,m);
		
		
		juego.colocarPiezaA();
		juego.mostrarTablero(p,m);
		juego.comprobarDiagonalDescendente();
		
		
		//juego.colocarPiezaA();
		//juego.mostrarTablero(p,m);

		//juego.colocarPiezaA();
		//juego.mostrarTablero(p,m);

		//juego.comprobarFila();

	}

}
