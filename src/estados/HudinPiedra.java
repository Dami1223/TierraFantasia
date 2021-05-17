package estados;

import principal.Personaje;
import utils.Arma;

public class HudinPiedra extends Estado {

	private int turnos;

	public HudinPiedra(Personaje personaje) {
		super(personaje);
		this.turnos = 3;
	}

	@Override
	public void atacar(Personaje personaje) {
		if (this.turnos == 0) {
			personaje.recibirAtaque(this.personaje.getRaza().getArma());
			this.personaje.getRaza().setEstado(new HudinNormal(this.personaje));
		} else
			this.turnos--;
	}

	@Override
	public void recibirAtaque(Arma arma) {
		this.personaje.reducirSalud(arma.getDaño() * 3 / 4);
		if (this.turnos == 0) {
			this.personaje.getRaza().setEstado(new HudinNormal(this.personaje));
		} else
			this.turnos--;
	}

	@Override
	public void descansar() {
		this.personaje.restaurarSalud(this.personaje.getRaza().getSaludMaxima());
		this.personaje.getRaza().setEstado(new HudinPiedra(this.personaje));
	}

}
