package estados;

import principal.Personaje;
import utils.Arma;

public class HudinNormal extends Estado {

	public HudinNormal(Personaje personaje) {
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
		this.personaje.restaurarSalud(this.personaje.getRaza().getSaludMaxima());
		this.personaje.getRaza().setEstado(new HudinPiedra(this.personaje));
	}

}
