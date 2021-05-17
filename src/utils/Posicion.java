package utils;

public class Posicion {
	
	private double x;
	private double y;
	
	public Posicion() {
		this.x = 0;
		this.y = 0;
	}
	
	public Posicion(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double calcularDistancia(Posicion otro) {
		return Math.sqrt(Math.pow(this.x - otro.x, 2)+Math.pow(this.y-otro.y, 2));
	}

}
