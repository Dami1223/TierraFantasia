package estados;

import principal.Personaje;
import utils.Arma;

public class RadaiteranNormal extends Estado {

	public RadaiteranNormal(Personaje personaje) {
		super(personaje);
	}

	@Override
	public void atacar(Personaje oponente) {
		oponente.recibirAtaque(this.personaje.getRaza().getArma());
	}

	@Override
	public void recibirAtaque(Arma arma) {
		this.personaje.getRaza().setEstado(new RadaiteranEnfurezido(personaje));
		this.personaje.recibirAtaque(arma);
	}

	@Override
	public void descansar() {
		this.personaje.getRaza().setEstado(new RadaiteranMeditando(personaje));
		this.personaje.descansar();
	}

}
