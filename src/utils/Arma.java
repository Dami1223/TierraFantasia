package utils;

import efectos.Efecto;

public class Arma {

	private String nombre;
	private double da�o;
	private double rangoMinimo;
	private double rangoMaximo;
	private Efecto efecto;

	public Arma(String nombre, double da�o, double rangoMinimo, double rangoMaximo, Efecto efecto) {
		this.da�o = da�o;
		this.rangoMinimo = rangoMinimo;
		this.rangoMaximo = rangoMaximo;
		this.efecto = efecto;
	}

	public boolean puedeAtacar(double distancia) {
		return rangoMinimo <= distancia && distancia <= rangoMaximo;
	}

	public double getDa�o() {
		return da�o;
	}

	public String getNombre() {
		return nombre;
	}

	public Efecto getEfecto() {
		return this.efecto;
	}

	public void setDa�o(double da�o) {
		this.da�o = da�o;
	}

	public void aumentarDa�o(int aumento) {
		this.da�o += aumento;
	}

}
