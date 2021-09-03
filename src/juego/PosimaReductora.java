package juego;

public class PosimaReductora extends Posima{
	private double valor;
	
	public PosimaReductora(String nombre,double valor) {
		super(nombre);
		this.valor=valor;
	}

	@Override
	public Double aplicarPosima(String nombre, double valor) {
		double operacion = valor*this.valor/100;
		return valor-=operacion;
	}

}
