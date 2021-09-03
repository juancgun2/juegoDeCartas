package juego;
import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
	private ArrayList<Carta> cartas; 
	
	public Mazo() { 
		cartas = new ArrayList<Carta>();
	}
	
	// compara la PRIMER carta con la que viene por parametro
	private boolean sonIguales(Carta c) { 
		return cartas.get(0).equals(c);
	}
	
	//agrega carta si son iguales
	public void addCarta(Carta c) { 
		if(cartas.isEmpty())
			cartas.add(c);
		else if(sonIguales(c))  
			cartas.add(c);
	}
	
	public int getCantidadCartas() { 
		return cartas.size();
	}
	
	protected Carta getCarta() { 
		return cartas.remove(0);
	}
	
	public void mezclar() {
		Collections.shuffle(cartas);
	}
}
