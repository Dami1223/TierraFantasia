package principal;

import efectos.Efecto;
import razas.Raza;
import utils.Arma;
import utils.Posicion;

public class Personaje {

	private double salud;
	private Raza raza;
	private Posicion posicion;
	private Efecto efecto;

	public void atacar(Personaje oponente) {
		if (this.efecto != null)
			this.efecto.aplicarEfecto(this);
		if (raza.puedeAtacar(this.posicion.calcularDistancia(oponente.posicion)))
			raza.atacar(oponente);
	}

	public void recibirAtaque(Arma arma) {
		if (arma.getEfecto() != null) {
			this.efecto = arma.getEfecto();
			this.efecto.aplicarEfecto(this);
		}
		raza.recibirAtaque(arma);
	}

	public void descansar() {
		if (this.efecto != null)
			this.efecto = null;
		raza.descansar();
	}

	public void restaurarSalud(double curacion) {
		if ((salud += curacion) > raza.getSaludMaxima())
			salud = raza.getSaludMaxima();
	}

	public void reducirSalud(double daño) {
		if ((salud -= daño) <= 0)
			salud = 0;
	}

	public void elegirRaza(Raza raza) {
		if (this.raza == null) {
			this.raza = raza;
			this.salud = raza.getSaludMaxima();
		} else {
			System.out.println("Ya elegista raza");
		}
	}

	public void mover(Posicion posicion) {
		this.posicion = posicion;
	}

	public Raza getRaza() {
		return this.raza;
	}

	public double getSalud() {
		return salud;
	}

}
