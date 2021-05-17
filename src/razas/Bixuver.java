package razas;

import estados.BixuverNormal;
import principal.Personaje;
import utils.Arma;

public class Bixuver extends Raza {

	public Bixuver(Personaje personaje) {
		super(personaje, 103, new Arma("Alabarda", 87, 0, 3,null), new BixuverNormal(personaje));
	}

	@Override
	public void atacar(Personaje oponente) {
		estado.atacar(oponente);
		personaje.restaurarSalud(personaje.getSalud() * 0.02);
	}

	@Override
	public void recibirAtaque(Arma arma) {
		estado.recibirAtaque(arma);
	}

	@Override
	public void descansar() {
		estado.descansar();
	}

}
