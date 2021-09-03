package juego;

import estrategias.*;

public class Jugador {
	private String nombre; 
	private Mazo mazo; 
	private String logRonda;
	private Estrategia estrategia;
	
	public Jugador(String nombre) { 
		this.nombre=nombre;
		mazo= new Mazo();
		estrategia = new EstrategiaTimbera();
	}
	
	public void setEstrategia(Estrategia e) {
		this.estrategia=e;
	}
	
	public String getNombre() { 
		return nombre;
	}
	
	private void setLogRonda(String log) {
		this.logRonda=log;
	}
	
	public String getLog() {
		return this.logRonda;
	}
	
	public void addCarta(Carta c) { 
		mazo.addCarta(c);
	} 
	
	public int cantidadCartas() {
		return mazo.getCantidadCartas();
	}
	
	public boolean tieneCartas() { 
		return mazo.getCantidadCartas()>0;
	} 
	
	private Carta getCarta() {
		return mazo.getCarta();
	}
	
	private void ganoRonda(Carta cartaJugada, Carta cartaGanada) { 
		this.addCarta(cartaJugada);
		this.addCarta(cartaGanada);
	} 
	
	private void empate(Carta cartaJugada) { //cartaJugada es la carta que saco del mazo para jugar la ronda
		this.addCarta(cartaJugada);
	}
	
	private String getNombreAtributo(Carta c) {
		return estrategia.getAtributo(c);
	}
	
	public boolean equals(Object o) { 
		try { 
			Jugador j = (Jugador)o; 
			return this.getNombre().equals(j.getNombre());
		}catch(Exception e) { 
			return false;
		}
		
	}
	
	public Jugador enfrentamiento(Jugador j) {
		Carta cartaGanador = this.getCarta(); // hace referencia al ganador de la ronda anterior, este es el que elige atributo
		Carta cartaPerdedor = j.getCarta(); // hace referencia al perdedor de la ronda anterior
		String atributo = this.getNombreAtributo(cartaGanador);
		String log = this.toStringEleccionCartas(j, cartaGanador, cartaPerdedor, atributo);
		int resultado = cartaGanador.compararCarta(cartaPerdedor, atributo);
		if ( resultado > 0) { 
			this.ganoRonda(cartaGanador,cartaPerdedor);
			this.setLogRonda(log+this.toStringGanador(j, atributo, cartaGanador, cartaPerdedor));
			return this;
		}else if (resultado < 0) {
			j.ganoRonda(cartaGanador,cartaPerdedor);
			j.setLogRonda(log+j.toStringGanador(this, atributo, cartaGanador, cartaPerdedor));
			return j;
		} else {
			this.empate(cartaGanador); // agrego la carta que le saque para jugar la ronda
			j.empate(cartaPerdedor); 
			return this;
			}
	}
	
	private String toStringEleccionCartas(Jugador j, Carta cartaGanador, Carta cartaPerdedor, String atributo) { 
		String resultado;
		resultado="El jugador "+ this.getNombre()+ " selecciona competir por el atributo "+ atributo+"\n";
		resultado+= "La carta de " +this.getNombre()+ " es "+ cartaGanador.myToString(atributo)+"\n";
		resultado+= "La carta de "+ j.getNombre()+ " es " +cartaPerdedor.myToString(atributo)+"\n";
		return resultado;
	}

	private String toStringGanador(Jugador j, String atributo, Carta cartaGanador, Carta cartaPerdedor) { 
		String resultado = "Gano la ronda "+this.getNombre()+" y queda con "+this.cantidadCartas()+" "
							+ "("+j.getNombre()+ " posee ahora "+ j.cantidadCartas() + " cartas)"+"\n";
		return resultado;
	}
}
