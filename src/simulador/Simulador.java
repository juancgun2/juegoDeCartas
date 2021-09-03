package simulador;

import estrategias.*;
import juego.*;

public class Simulador {

	public static void main(String[] args) {
		Jugador j1 = new Jugador("juan");
		Jugador j2 = new Jugador("Blas");
		Juego juego = new Juego(j1,j2);
		PosimaFortalecedora p = new PosimaFortalecedora("fortal",15);
		PosimaEstatica p1 = new PosimaEstatica("estatica",50);
		PosimaReductora p2 = new PosimaReductora("reductora",21);
		PosimaCocktail p3 = new PosimaCocktail("cocktail");
		PosimaSelectiva p4 = new PosimaSelectiva("selectiva",13,"fuerza");
		PosimaFortalecedora p5 = new PosimaFortalecedora("fortal",70);
		PosimaReductora p6 = new PosimaReductora("reductora",70);
		PosimaReductora p7 = new PosimaReductora("reductora",70);
		PosimaEstatica p8 = new PosimaEstatica("estatica",10);
		j2.setEstrategia(new EstrategiaAmbiciosa());
		p3.addPosima(p);
		juego.addPosima(p);
		juego.addPosima(p1);
		juego.addPosima(p2);
		juego.addPosima(p3);
		juego.addPosima(p4);
		juego.addPosima(p5);
		juego.addPosima(p6);
		juego.addPosima(p7);
		juego.addPosima(p8);
		Mazo mazo = VisorMazo.crearMazo("src/simulador/superheroes.json");
		//src/simulador/autos.json
		//src/simulador/superheroes.json
		juego.llenarMazo(mazo);
		juego.jugar();
		
		
	}

}
