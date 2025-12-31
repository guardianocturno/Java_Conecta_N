package Juego2;
import java.util.Scanner;

public class juego {
	Scanner sc = new Scanner(System.in);
	//Creamos el array tablero
	char[][] tablero;

	
	//Creamos el metodo tablero para poder crear el tablero, para eso nos hara falta un entero que sera i
	public void tablero(int i) {
		//Creamos el tablero con el mismo ancho que largo
		tablero = new char[i][i];
		
		//Recoremos cada posicion del array para rellenarlo con * que simula el vacio
		for (int n = 0; n < i; n++) {
			for (int n1 = 0; n1 < i;n1++) {
				tablero[n][n1]='*';
			}
		}
		
	}
	
	public void mostrarTablero() {
		for (int n = 0; n < tablero.length; n++) {
			for (int n1 = 0; n1 < tablero.length;n1++) {
				System.out.print(tablero[n][n1] + " ");
			}
			System.out.println(); 
		}
		
	}
	
	public void ponerFichaRoja() {
		int tamaño = tablero.length-1;
		System.out.print("Di en que columna quieres poner la ficha: ");
		int columna = sc.nextInt();
		//esto recorre el array de abajo a arriba
		//Porque si hay una pieza abajo deberia ponerse arriba de esta misma
			for (int i = columna; i<=columna;i++) {
				for (int fila = tamaño; fila>=0; fila--) {
					if (tablero[fila][columna]=='*') {
						tablero[fila][columna] = 'a';
						break;
					}
										
				}
			}
	}
		
	public void ponerFichaAmarilla() {
		int tamaño = tablero.length-1;
		System.out.print("Di en que columna quieres poner la ficha: ");
		int columna = sc.nextInt();
		//esto recorre el array de abajo a arriba
		//Porque si hay una pieza abajo deberia ponerse arriba de esta misma
			for (int i = columna; i<=columna;i++) {
				for (int fila = tamaño; fila>=0; fila--) {
					if (tablero[fila][columna]=='*') {
						tablero[fila][columna] = 'b';
						break;
					}
										
				}
			}
		
	}
	
	public boolean comprobarFila() {
        int tamaño = tablero.length;
        for (int x = 0; x < tamaño; x++) {
            int j1 = 0;
            int j2 = 0;
            for (int i = 0; i < tamaño; i++) {
                if (tablero[x][i] == 'a') j1++;
                else if (tablero[x][i] == 'b') j2++;
            }
            if (j1 == tamaño || j2 == tamaño) return true;
        }
        return false;
    }

    public boolean comprobarColumna() {
        int tamaño = tablero.length;
        for (int x = 0; x < tamaño; x++) {
            int j1 = 0;
            int j2 = 0;
            for (int i = 0; i < tamaño; i++) {
                if (tablero[i][x] == 'a') j1++;
                else if (tablero[i][x] == 'b') j2++;
            }
            if (j1 == tamaño || j2 == tamaño) return true;
        }
        return false;
    }

    // Diagonal principal (Arriba-Izquierda a Abajo-Derecha)
    public boolean comprobarDI() {
        int tamaño = tablero.length;
        int j1 = 0;
        int j2 = 0;
        for (int x = 0; x < tamaño; x++) {
            if (tablero[x][x] == 'a') j1++;
            else if (tablero[x][x] == 'b') j2++;
        }
        return (j1 == tamaño || j2 == tamaño);
    }

	
	//comprobarID= comprobar de Izquierda a Derecha en vertical
	public boolean comprobarID() {
		    // Usamos directamente tablero.length
		    int tamaño = tablero.length;
		    int j1 = 0;
	        int j2 = 0;
		    for (int x = 0; x < tamaño; x++) {
		    	for (int i = tamaño-1; i >= 0; i--)
		              if (tablero[i][x] == 'a') {
		                j1++;
		            } else if (tablero[i][x] == 'b') {
		                j2++; 
		            }
			    if (j1 == tamaño || j2 == tamaño) return true;
		        }
    		return false;
	}
	
	//Ayuda de Gemini
	public boolean hayGanador() {
	    if (comprobarFila() || comprobarColumna() || comprobarID ()|| comprobarDI()) {
	        System.out.println("¡PARTIDA FINALIZADA!");
	        return true;
	    }
	    return false;
	}
	
	public void realizarComprobaciones() {
		comprobarFila();
	    comprobarColumna();
	    comprobarDI();
	    comprobarID();
	    hayGanador();
	}
	
	public boolean Turno() {
		System.out.println("---------------------------");
		mostrarTablero();
		ponerFichaRoja();
		//Ayuda de Gemini el if
		if (hayGanador()) {
	        mostrarTablero(); // Mostramos cómo quedó
	        return true;      // Devolvemos true para avisar que el juego terminó
	    }
	    realizarComprobaciones();
	    ponerFichaAmarilla();
	    if (hayGanador()) {
	        mostrarTablero(); // Mostramos cómo quedó
	        return true;      // Devolvemos true para avisar que el juego terminó
	    }
	    realizarComprobaciones();
	    hayGanador();
	    System.out.println("---------------------------");
	    return false; // Devolvemos false porque nadie ha ganado todavía
	}
	
	public static void main(String[] args) {
	    juego juego = new juego();
	    juego.tablero(2); // Tablero de 2x2
	    
	    while (true) {
	    	// Ejecutamos el turno. Si devuelve true, hacemos break para salir
	    	//Ayuda de Gemini el if
	    	if (juego.Turno()) {
	            break; 
	        }
	    }
	    


	}

		
		
}
