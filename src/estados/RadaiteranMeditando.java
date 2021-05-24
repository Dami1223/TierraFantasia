package estados;

import principal.Personaje;
import utils.Arma;

public class RadaiteranMeditando extends Estado {

	public RadaiteranMeditando(Personaje personaje) {
		super(personaje);
	}

	@Override
	public void atacar(Personaje oponente) {

	}

	@Override
	public void recibirAtaque(Arma arma) {
		this.personaje.getRaza().setEstado(new RadaiteranEnfurezido(personaje));
		this.personaje.recibirAtaque(arma);
	}

	@Override
	public void descansar() {
		this.personaje.getRaza().aumentarSaludMaxima(25);
		this.personaje.restaurarSalud(25);
	}

}
