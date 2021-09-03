package estrategias;

import juego.Carta;

public class EstrategiaTimbera implements Estrategia {

	public String getAtributo(Carta c) {
		return c.getRandomAtributoCarta();
	}
}
