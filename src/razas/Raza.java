package razas;

import estados.Estado;
import principal.Personaje;
import utils.Arma;

public abstract class Raza {

	protected Personaje personaje;
	protected double saludMaxima;
	protected Arma arma;
	protected Estado estado;

	public Raza(Personaje personaje, double saludMaxima, Arma arma, Estado estado) {
		this.personaje = personaje;
		this.saludMaxima = saludMaxima;
		this.arma = arma;
		this.estado = estado;
	}

	public abstract void atacar(Personaje oponente);

	public abstract void recibirAtaque(Arma arma);

	public abstract void descansar();

	public boolean puedeAtacar(double distancia) {
		return arma.puedeAtacar(distancia);
	}

	public double getSaludMaxima() {
		return saludMaxima;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public Arma getArma() {
		return arma;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
