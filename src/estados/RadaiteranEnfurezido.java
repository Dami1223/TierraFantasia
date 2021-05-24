package estados;

import principal.Personaje;
import utils.Arma;

public class RadaiteranEnfurezido extends Estado {
	private int turnos = 2;

	public RadaiteranEnfurezido(Personaje personaje) {
		super(personaje);
	}

	@Override
	public void atacar(Personaje oponente) {
		if (this.turnos == 0) {
			this.personaje.getRaza().setEstado(new RadaiteranNormal(this.personaje));
			this.personaje.getRaza().getArma().setDaño(this.personaje.getRaza().getArma().getDaño() / 2);
			this.personaje.atacar(oponente);
		} else {
			this.turnos--;
			oponente.recibirAtaque(this.personaje.getRaza().getArma());
		}
	}

	@Override
	public void recibirAtaque(Arma arma) {
		this.personaje.reducirSalud(arma.getDaño());
		if (this.personaje.getSalud() == 0)
			this.personaje.getRaza().setEstado(new Muerto(personaje));
		else {
			this.turnos = 2;
			this.personaje.getRaza().getArma().setDaño(this.personaje.getRaza().getArma().getDaño() * 2);
		}
	}

	@Override
	public void descansar() {
		this.personaje.getRaza().setEstado(new RadaiteranMeditando(personaje));
		this.personaje.descansar();
	}

}
