package juego;
import java.util.ArrayList;

public class Juego {
	Jugador j1;
	Jugador j2;
	private ArrayList<Posima> posimas;
	private ArrayList<String> resultados;
	private int rondasJugadas; 
	private Mazo mazo;
	
	public Juego(Jugador j,Jugador j1) { 
		if(!j.equals(j1)) { // no se aceptan jugadores con el mismo nombre
			this.j1=j;
			this.j2=j1;
		}
		resultados = new ArrayList<String>();
		posimas = new ArrayList<Posima>(); 
		mazo = new Mazo();
		rondasJugadas=0; 
	} 
	
	public void addPosima(Posima p) {
		this.posimas.add(p);
	}
	
	public int getRondasJugadas() { 
		return rondasJugadas;
	} 
	
	public void llenarMazo(Mazo m) {
		int cantidadCartas = m.getCantidadCartas();
		for (int i = 0; i < cantidadCartas; i++) {
			mazo.addCarta(m.getCarta());
		}
	} 
	//si getCarta no recibe un numero, no puedo implementar eso ----->
	//ademas, si en getCarta uso un remove, el log se complica mas aun. PREGUNTAR !!
	private void repartirCartas() { 
		mazo.mezclar();
		int cartas= mazo.getCantidadCartas();
		int cantidadPosimas = posimas.size();
		for (int i = 0; i < cartas; i++) { // -----> no puedo implementar esto.
			Carta c = mazo.getCarta();
			if((i==0)||(i%2==0)){ 
				if(i<cantidadPosimas)
					c.setPosima(posimas.get(i));
				j1.addCarta(c);
			}else { 
				if(i<cantidadPosimas)
					c.setPosima(posimas.get(i));
				j2.addCarta(c);
			}
		}
	}
	
	public void jugar() { 
		this.repartirCartas();
		Jugador ganador = null;
		while((rondasJugadas<10)&&(j1.tieneCartas())&&(j2.tieneCartas())) { 
			if(rondasJugadas==0) 
				ganador = jugarRonda(j1,j2);
			else {
				if(ganador.equals(j1))
					ganador=this.jugarRonda(ganador,j2);
				else 
					ganador=this.jugarRonda(ganador,j1);
			}
			rondasJugadas++;
		}
		this.imprimirResultados();
	}
	
	private Jugador jugarRonda(Jugador j1,Jugador j2) { 
		int rondasJugadas = this.rondasJugadas+1;
		String resultado;
		Jugador ganador = j1.enfrentamiento(j2);
		resultado = "------- "+"Ronda "+rondasJugadas+" --------"+"\n";
		resultado+=ganador.getLog();
		this.resultados.add(resultado);
		return ganador;
	}
		
		/*
		String nombreAtributo = "";
		if(j1.ganoRonda()||!j1.ganoRonda()&&!j2.ganoRonda())
			nombreAtributo = j1.getNombreAtributo(j1.getCarta(0));
		else if(j2.ganoRonda())
			nombreAtributo = j2.getNombreAtributo(j2.getCarta(0));
		int resultado = j1.getCarta(0).compararCarta(j2.getCarta(0), nombreAtributo);
		if(resultado>0) {
			resultados.add(this.generarResultado(j1, j2, j1.getCarta(0), j2.getCarta(0),nombreAtributo,false));
			j1.ganoRonda(j2.perdioRonda());
		}else if(resultado<0) {
			resultados.add(this.generarResultado(j2, j1, j2.getCarta(0), j1.getCarta(0),nombreAtributo,false));
			j2.ganoRonda(j1.perdioRonda());
		}else { 
			resultados.add(this.generarResultado(j2, j1, j2.getCarta(0), j1.getCarta(0),nombreAtributo,true));
			j1.empate();
			j2.empate();
		}
	}*/
	
	/*private String generarResultado(Jugador j1,Jugador j2, Carta c1, Carta c2,String atributo,boolean empate) { 
		int cantidadCartasGanador = j1.cantidadCartas()+1;
		int cantidadCartasPerdedor = j2.cantidadCartas()-1;
		String resultado = "------- "+"Ronda "+this.rondasJugadas+" --------"+"\n"; 
		if(j2.ganoRonda())
			resultado +="El jugador "+ j2.getNombre()+ " selecciona competir por el atributo "+ atributo+"\n";
		else
			resultado +="El jugador "+ j1.getNombre()+ " selecciona competir por el atributo "+ atributo+"\n";
		resultado+= "La carta de " +j1.getNombre()+ " es "+ c1.myToString(atributo)+"\n";
		resultado+= "La carta de "+ j2.getNombre()+ " es " +c2.myToString(atributo)+"\n";
		if(!empate)
			resultado+= "Gano la ronda "; 
		else
			resultado+= "Empataron la ronda";
		resultado+= j1.getNombre()+" y queda con "+cantidadCartasGanador+" ("+j2.getNombre()+
		" posee ahora "+ cantidadCartasPerdedor + " cartas)"+"\n";
		return resultado;
	}*/
	
	private void imprimirResultados() {
		for (String resultado : resultados) {
			System.out.println(resultado);
		}
	}
}
	
	

