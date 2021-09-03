package juego;

public class AtributoCarta {
	private String nombre; 
	private double valor;
	
	public AtributoCarta(String nombre, double valor) { 
		this.nombre=nombre; 
		this.valor=valor;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getValor() {
		return valor;
	}
	
	public boolean equals(Object o) { 
		try { 
			AtributoCarta a = (AtributoCarta)o;
			return (this.nombre.equals(a.getNombre()));
		}catch(Exception e) { 
			return false;
		}
	}

}