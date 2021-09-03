package juego;

import java.util.ArrayList;

public class PosimaCocktail extends Posima {
	private ArrayList<Posima> posimas;
	
	public PosimaCocktail(String nombre) {
		super(nombre);
		posimas = new ArrayList<Posima>();
	}
	
	public void addPosima(Posima p) {
		posimas.add(p);
	}

	@Override
	public Double aplicarPosima(String nombre, double valor) {
		for (Posima posima : posimas) {
			valor=posima.aplicarPosima(nombre,valor);
		}
		return valor;
	}
}	
