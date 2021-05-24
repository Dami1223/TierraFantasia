package razas;

import estados.RadaiteranEnfurezido;
import estados.RadaiteranNormal;
import principal.Personaje;
import utils.Arma;

public class Radaiteran extends Raza {

	public Radaiteran(Personaje personaje) {
		super(personaje, 192, new Arma("Arco", 84, 7, 48, null), new RadaiteranNormal(personaje));
	}

	@Override
	public void atacar(Personaje oponente) {
		this.arma.aumentarDaño(2);
		this.estado.atacar(oponente);
	}

	@Override
	public void recibirAtaque(Arma arma) {
		this.setEstado(new RadaiteranEnfurezido(personaje));
		this.estado.recibirAtaque(arma);
	}

	@Override
	public void descansar() {
		this.estado.descansar();
	}

	public void aumentarSaludMaxima(double aumento) {
		this.saludMaxima += aumento;
	}

}
