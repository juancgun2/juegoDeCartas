package estrategias;

import juego.Carta;

public class EstrategiaAmbiciosa implements Estrategia {
	
	public String getAtributo(Carta c) {
		return c.getAtributoMayor();
	}
}
