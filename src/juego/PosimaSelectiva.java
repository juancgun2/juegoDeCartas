package juego;

public class PosimaSelectiva extends Posima {
	private String selectivo;
	private double valor;
	
	public PosimaSelectiva(String nombre,double valor,String selectivo) {
		super(nombre);
		this.valor=valor;
		this.selectivo=selectivo;
	}
	
	public void setSelectivo(String selectivo) {
		this.selectivo=selectivo;
	}

	@Override
	public Double aplicarPosima(String nombre, double valor) {
		if(nombre.equals(selectivo)) {
			double operacion = valor*this.valor/100;
			return valor+=operacion;
		}
		return valor;
	}

}
