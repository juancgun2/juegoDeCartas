package juego;

public class PosimaFortalecedora extends Posima{
	private double valor;
	
	public PosimaFortalecedora(String nombre,double valor) {
		super(nombre);
		this.valor=valor;
	}

	@Override
	public Double aplicarPosima(String nombre, double valor) {
		double operacion = valor*this.valor/100;
		return valor +=operacion;
	}

}

