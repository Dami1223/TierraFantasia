package efectos;

import principal.Personaje;

public class Veneno extends Efecto{

	@Override
	public void aplicarEfecto(Personaje personaje) {
		personaje.reducirSalud(2);
	}

}
