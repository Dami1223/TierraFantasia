package estados;

import principal.Personaje;
import utils.Arma;

public class Muerto extends Estado {

	public Muerto(Personaje personaje) {
		super(personaje);
	}

	@Override
	public void atacar(Personaje oponente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recibirAtaque(Arma arma) {
		// TODO Auto-generated method stub

	}

	@Override
	public void descansar() {
		// TODO Auto-generated method stub

	}

}
