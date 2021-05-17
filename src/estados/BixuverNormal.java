package estados;

import principal.Personaje;
import utils.Arma;

public class BixuverNormal extends Estado {

	public BixuverNormal(Personaje personaje) {
		super(personaje);
	}

	@Override
	public void atacar(Personaje oponente) {
		oponente.recibirAtaque(this.personaje.getRaza().getArma());
	}

	@Override
	public void recibirAtaque(Arma arma) {
		this.personaje.reducirSalud(arma.getDaño() / 6);
		if (this.personaje.getSalud() == 0)
			this.personaje.getRaza().setEstado(new Muerto(personaje));
	}

	@Override
	public void descansar() {
		this.personaje.getRaza().setEstado(new BixuverDescansado(this.personaje));
	}

}
