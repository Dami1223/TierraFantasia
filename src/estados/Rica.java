package estados;

import principal.Personaje;
import utils.Arma;

public class Rica extends Estado {

	public Rica(Personaje personaje) {
		super(personaje);
	}

	@Override
	public void atacar(Personaje oponente) {
		oponente.recibirAtaque(this.personaje.getRaza().getArma());

	}

	@Override
	public void recibirAtaque(Arma arma) {
		this.personaje.reducirSalud(arma.getDaño());
	}

	@Override
	public void descansar() {
		// TODO Auto-generated method stub
	}

}
