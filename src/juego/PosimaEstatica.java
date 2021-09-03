package juego;

public class PosimaEstatica extends Posima {
	private double valor;

	public PosimaEstatica(String nombre,double valor) {
		super(nombre);
		this.valor=valor;
	}

	@Override
	public Double aplicarPosima(String nombre, double valor) {
		return this.valor;
	}

}
