package utils;

import efectos.Efecto;
import efectos.Veneno;

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

}