package estados;

import principal.Personaje;
import utils.Arma;

public abstract class Estado {

	protected Personaje personaje;

	public Estado(Personaje personaje) {
		this.personaje = personaje;
	}

	abstract public void atacar(Personaje oponente);

	abstract public void recibirAtaque(Arma arma);

	abstract public void descansar();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
