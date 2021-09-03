package estrategias;

import juego.Carta;

public class EstrategiaObstinada implements Estrategia {
	private String atributo;
	
	public EstrategiaObstinada(String atributo) {
		this.atributo=atributo;
	}

	public String getAtributo(Carta c) {
		return c.getMismoAtributo(this.atributo);
	}
}
