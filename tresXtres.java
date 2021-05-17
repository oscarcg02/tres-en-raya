import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner; 

public class tresXtres {
	static Scanner entrada = new Scanner(System.in);
	// tablero
	static String [] tablero = {" ","_","_","_","_","_","_","_","_","_","1","2","3","A","B","C"};
	//variables tipo String
	static String jugador1;
	static String jugador2;
	static String turno;
	static String coordenada;
	
	//variables tipo int
	static int posicion;
	
	//variables tipo boolean
	static boolean quienGano = false;
	static boolean hayEmpate = false;
	static boolean repetirTurno = false;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {			

			log.logFile("COMIENZA LA PARTIDA" );//añade informacion al .txt
			nombreJugador();
			jugadorStart();
			while (!quienGano) {
				mostrarTablero(tablero);
				hayEmpate = empate(tablero);
				if (hayEmpate) {
					System.out.println("Empate");
					log.logFile("La partida quedo en tablas, no hubo ningun ganador" );//añade informacion al .txt
					quienGano = true;
				}
				else {
					jugada(tablero);
					quienGano = quienGana(tablero);
					if(quienGano) {
						mostrarTablero(tablero);
						System.out.println("Nuestr@ ganador es " + turno + "!");
						log.logFile(turno + " gano la partida" );//añade informacion al .txt
					}
					else {
						if(!repetirTurno) {
							cambiarTurno();
						}
						else {
							repetirTurno = false;
							System.out.println("Es el turno de " + turno);
						}
							
					}
				
				}
				
				
				
			}
			log.logFile("FIN DE LA PARTIDA" );//añade informacion al .txt
			}
	
	
	/**
     * Introduce nombre de jugador 
	 * @throws IOException 
     */
	public static void nombreJugador() throws IOException {
		//Introduce el nombre del primer jugador
		System.out.println("Escribe el nombre del primer jugador");
		jugador1 = entrada.next();
		log.logFile("El primer jugador es " + jugador1 );//añade informacion al .txt
		
		//Introduce el nombre del segundo jugador
		System.out.println("Escribe el nombre del segundo jugador");
		jugador2 = entrada.next();
		log.logFile("El segundo jugador es " + jugador2 );//añade informacion al .txt
		
		//Imprimer el nombre de ambos jugadores
		System.out.println("Jugador1: " + jugador1);
		System.out.println("Jugador2: " + jugador2);
	}
	/**
     * Escoje quien empieza
	 * @throws IOException 
     */
	public static void jugadorStart() throws IOException {
		boolean empate = true;
		while(empate) {
			System.out.println(jugador1 + " tira el dado");
			Dado d1;
		    d1=new Dado();
		    d1.lanzarDado();
		    d1.getDado();
		    log.logFile(jugador1 + " ha sacado un " + d1.getDado());//añade informacion al .txt
		    
			System.out.println(jugador2 + " tira el dado");
			Dado d2;
		    d2=new Dado();
		    d2.lanzarDado();
		    d2.getDado();
		    log.logFile(jugador2 + " ha sacado un " + d2.getDado());//añade informacion al .txt
		    
		    if(d1.getDado() > d2.getDado()) {
		    	System.out.println("Empieza " + jugador1 );
		    	turno = jugador1;
		    	empate = false;
		    	log.logFile(jugador1 + " empieza");
		    }
		    
		    if(d1.getDado() < d2.getDado()) {
		    	System.out.println("Empieza " + jugador2 );
		    	turno = jugador2;
		    	empate = false;
		    	log.logFile(jugador2 + " empieza");
		    }
		    
		    if(d1.getDado() == d2.getDado()){
		    	System.out.println("Empate se tira otra vez");
		    	empate = true;
		    	log.logFile("Se empato y se volvio a tirar el dado");
		    }
		}
		
	}
	
	/**
     * Muestra el tablero
     */
	public static void mostrarTablero(String [] tablero) {
		System.out.println(tablero[0] + " " + tablero[10] + " " + tablero[11] + " " + tablero[12]);
		System.out.println(tablero[13] + "|" + tablero[1] + "|" + tablero[2] + "|" + tablero[3] + "|");
		System.out.println(tablero[14] + "|" + tablero[4] + "|" + tablero[5] + "|" + tablero[6] + "|");
		System.out.println(tablero[15] + "|" + tablero[7] + "|" + tablero[8] + "|" + tablero[9] + "|");
	}
	
	/**
     * Coloca la ficha en el tablero y comprueba que no haya una en esa posicion
	 * @throws IOException 
     */
	public static void tirada(String ficha) throws IOException {
		if(tablero[posicion].equals("X") || tablero[posicion].equals("O")) {
			System.out.println("Ya hay una ficha en esa posicion");
			repetirTurno = true;
			log.logFile( turno + " coloco la ficha en una posicion ya ocupada" );//añade informacion al .txt
		}
		else {
			tablero[posicion] = ficha;
			log.logFile( turno + " coloco ficha en la posicion " + posicion );//añade informacion al .txt
		}
	
	}
	
	/**
     * Establece la posicion segun las cordenadas intorducidas por el usuario 
	 * @throws IOException 
     */
	public static void jugada(String [] tablero) throws IOException {
		if(turno == jugador1) {
			System.out.println("Escribe la posicion en la que quieres poner tu ficha");
			String coordenada = entrada.next().toUpperCase();
			switch (coordenada) {
			case "A1":
        		posicion = 1;
        		tirada("X");
        	break;
        	case "A2":
        		posicion = 2;
        		tirada("X");
        	break;
        	case "A3":
        		posicion = 3;
        		tirada("X");
        	break;
        	case "B1":
        		posicion = 4;
        		tirada("X");
        	break;
        	case "B2":
        		posicion = 5;
        		tirada("X");
        	break;
        	case "B3":
        		posicion = 6;
        		tirada("X");
        	break;
        	case "C1":
        		posicion = 7;
        		tirada("X");
        	break;
        	case "C2":
        		posicion = 8;
        		tirada("X");
        	break;
        	case "C3":
        		posicion = 9;
        		tirada("X");
        	break;
            default:
            		System.out.println("Coordenada introducida incorrecta");
            		repetirTurno = true;
            		log.logFile(turno + " introdujo coordenada incorrecta" );//añade informacion al .txt
			}
			
			
		}
		if(turno == jugador2) {
			System.out.println("Escribe la posicion en la que quieres poner tu ficha");
			String coordenada = entrada.next().toUpperCase();
			switch (coordenada) {
        	case "A1":
        		posicion = 1;
        		tirada("O");
        	break;
        	case "A2":
        		posicion = 2;
        		tirada("O");
        		
        	break;
        	case "A3":
        		posicion = 3;
        		tirada("O");
        	break;
        	case "B1":
        		posicion = 4;
        		tirada("O");
        	break;
        	case "B2":
        		posicion = 5;
        		tirada("O");
        	break;
        	case "B3":
        		posicion = 6;
        		tirada("O");
        	break;
        	case "C1":
        		posicion = 7;
        		tirada("O");
        	break;
        	case "C2":
        		posicion = 8;
        		tirada("O");
        	break;
        	case "C3":
        		posicion = 9;
        		tirada("O");
        	break;
        	
 
        	default:
        		System.out.println("Coordenada introducida incorrecta");
        		repetirTurno = true;
        		log.logFile(turno + " introdujo coordenada incorrecta" );//añade informacion al .txt
			}
		}
	}
	
	/**
     * Cambia el turno po cada jugada
     */
	public static void cambiarTurno() {
		if(turno == jugador1) {
			turno = jugador2;
			System.out.println("Es el turno de " + turno);
		}
		else{
			turno = jugador1;
			System.out.println("Es el turno de " + turno);
		}
	}
	
	/**
     * Comprueba si hay ganador
     */
	public static boolean quienGana(String [] tablero){
		boolean resultado = false;
		if(tablero[1].equals(tablero[2]) && tablero[1].equals(tablero[3]) && !tablero[1].equals("_")) {
			resultado = true;
		}
		else if(tablero[4].equals(tablero[5]) && tablero[4].equals(tablero[6]) && !tablero[4].equals("_")) {
			resultado = true;
		}
		else if(tablero[7].equals(tablero[8]) && tablero[7].equals(tablero[9]) && !tablero[7].equals("_")) {
			resultado = true;
		}
		else if(tablero[1].equals(tablero[4]) && tablero[1].equals(tablero[7]) && !tablero[1].equals("_")) {
			resultado = true;
		}
		else if(tablero[2].equals(tablero[5]) && tablero[2].equals(tablero[8]) && !tablero[2].equals("_")) {
			resultado = true;
		}
		else if(tablero[3].equals(tablero[6]) && tablero[3].equals(tablero[9]) && !tablero[3].equals("_")) {
			resultado = true;
		}
		else if(tablero[1].equals(tablero[5]) && tablero[1].equals(tablero[9]) && !tablero[1].equals("_")) {
			resultado = true;
		}
		else if(tablero[3].equals(tablero[5]) && tablero[3].equals(tablero[7]) && !tablero[3].equals("_")) {
			resultado = true;
		}		
		
		return resultado;
		
	}
	
	/**
     * Comprueba si hay empate
     */
	public static boolean empate(String [] tablero){
		boolean resultado = false;
		if(!tablero[1].equals("_") && !tablero[2].equals("_") && !tablero[3].equals("_") && !tablero[4].equals("_") && !tablero[5].equals("_") && !tablero[6].equals("_") && !tablero[7].equals("_") && !tablero[8].equals("_") && !tablero[9].equals("_")) {
			resultado = true;
		}
		return resultado;
		
	}
	
}
