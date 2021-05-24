package utils;

import efectos.Efecto;

public class Arma {

	private String nombre;
	private double daño;
	private double rangoMinimo;
	private double rangoMaximo;
	private Efecto efecto;

	public Arma(String nombre, double daño, double rangoMinimo, double rangoMaximo, Efecto efecto) {
		this.daño = daño;
		this.rangoMinimo = rangoMinimo;
		this.rangoMaximo = rangoMaximo;
		this.efecto = efecto;
	}

	public boolean puedeAtacar(double distancia) {
		return rangoMinimo <= distancia && distancia <= rangoMaximo;
	}

	public double getDaño() {
		return daño;
	}

	public String getNombre() {
		return nombre;
	}

	public Efecto getEfecto() {
		return this.efecto;
	}

	public void setDaño(double daño) {
		this.daño = daño;
	}

	public void aumentarDaño(int aumento) {
		this.daño += aumento;
	}

}
