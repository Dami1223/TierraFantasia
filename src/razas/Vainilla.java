package razas;

import estados.Rica;
import principal.Personaje;
import utils.Arma;

public class Vainilla extends Raza {

	public Vainilla(Personaje personaje) {
		super(personaje, 1000, new Arma("Azucar", 100, 0, 100,null), new Rica(personaje));
	}

	@Override
	public void atacar(Personaje oponente) {
		estado.atacar(oponente);
	}

	@Override
	public void recibirAtaque(Arma arma) {
		estado.recibirAtaque(arma);
	}

	@Override
	public void descansar() {
		// TODO Auto-generated method stub
	}

}
