package razas;

import efectos.Veneno;
import estados.HudinNormal;
import principal.Personaje;
import utils.Arma;

public class Hudin extends Raza {

	public Hudin(Personaje personaje) {
		super(personaje, 196, new Arma("Catapulta", 49, 7, 48, new Veneno()), new HudinNormal(personaje));
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
		this.estado.descansar();
	}

}
