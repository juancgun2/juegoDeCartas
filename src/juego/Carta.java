package juego;
import java.util.ArrayList;

public class Carta {
	private String nombre; 
	private Posima posima;
	private ArrayList<AtributoCarta> atributos;
	
	public Carta(String nombre) { 
		this.nombre=nombre; 
		atributos= new ArrayList<>();
		posima=null;
	} 
	
	public void addAtributo(AtributoCarta a) {
		this.atributos.add(a);
	}
	
	public void setPosima(Posima p) {
		this.posima=p;
	}
	
	public String getNombre() { 
		return nombre;
	}
	
	public boolean tieneAtributo(AtributoCarta atributo) { 
		return atributos.contains(atributo);
	}
	
	public String getRandomAtributoCarta() { 
		int min=0; 
		int max= atributos.size()-1;
		int i = (int) (Math.random()*(max-min+1)+min);
		if(i>this.getCantidadAtributos())
			i-=this.getCantidadAtributos();
		return atributos.get(i).getNombre();
	}
	
	public int getCantidadAtributos() { 
		return atributos.size();
	}
	
	public Double getValorPosima(String nombre) { 
		for (int i = 0; i < atributos.size(); i++) {
			if(atributos.get(i).getNombre().equals(nombre)) {
				if(this.posima!=null)
					return posima.aplicarPosima(nombre, atributos.get(i).getValor());
				return atributos.get(i).getValor();
			}
		}
		return 0.0;
	}
	
	private double getValor(String nombre) {
		for (AtributoCarta a : atributos) {
			if(a.getNombre().equals(nombre)) {
				return a.getValor();
			}
		}
		return 0.0;
	}
	
	protected int compararCarta(Carta c, String atributo) { 
		return this.getValorPosima(atributo).compareTo(c.getValorPosima(atributo));
	}
	
	@Override
	public boolean equals(Object o) { 
		try {
			Carta carta = (Carta)o; 
			if(this.atributos.size()==carta.getCantidadAtributos()) { 
				for (int i = 0; i < atributos.size(); i++) {
					if(!carta.tieneAtributo(atributos.get(i))) {
						return false;
					}
				}
				return true;
			}else { 
				return false;
			}
		}catch(Exception e) { 
			return false;
		}
	}

	public String getAtributoMayor() {
		AtributoCarta aux = new AtributoCarta("aux",-99.0);
		for (AtributoCarta atributoCarta : atributos) {
			if(atributoCarta.getValor()>aux.getValor())
				aux=atributoCarta;
		}
		return aux.getNombre();
	}

	public String getMismoAtributo(String nombre) {
		for (AtributoCarta atributoCarta : atributos) {
			if(atributoCarta.getNombre().equals(nombre))
				return atributoCarta.getNombre();
		}
		return null;
	}

	public String myToString(String atributo) {
		String retorno= this.getNombre()+" con "+atributo+"  "+ this.getValor(atributo);
		if(posima!=null) { 
			retorno+=" se aplico posima "+ posima.getNombre()+" valor resultante " + this.getValorPosima(atributo);
		}
		return retorno;
	}
}
