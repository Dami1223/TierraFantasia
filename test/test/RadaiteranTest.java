package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import estados.Muerto;
import estados.RadaiteranEnfurezido;
import estados.RadaiteranMeditando;
import estados.RadaiteranNormal;
import principal.Personaje;
import razas.Radaiteran;
import razas.Vainilla;
import utils.Posicion;

public class RadaiteranTest {

	private static final double ATAQUE_BASICO_RADAITERAN = 84.00;
	private static final double SALUD_MAXIMA_RADAITERAN = 192.00;
	private static final double ATAQUE_BASICO_VAINILLA = 100;
	private static final double SALUD_MAXIMA_VAINILLA = 1000;
	Personaje radaiteran;
	Personaje vainilla;

	@Before
	void setUp() {
		radaiteran = new Personaje();
		vainilla = new Personaje();
		radaiteran.elegirRaza(new Radaiteran(radaiteran));
		vainilla.elegirRaza(new Vainilla(vainilla));
		radaiteran.mover(new Posicion(0, 0));
		vainilla.mover(new Posicion(0, 7));
	}

	@Test
	void instanciarRadaiteranTest() {
		setUp();
		assertEquals(new RadaiteranNormal(null), radaiteran.getRaza().getEstado());
		assertEquals(SALUD_MAXIMA_RADAITERAN, radaiteran.getSalud());
	}

	@Test
	void descontarVidaRecibirAtaqueTest() {
		setUp();
		vainilla.atacar(radaiteran);
		assertEquals(SALUD_MAXIMA_RADAITERAN - ATAQUE_BASICO_VAINILLA, radaiteran.getSalud());
	}

	@Test
	void descontarVidaAlAtacarTest() {
		setUp();
		radaiteran.atacar(vainilla);
		assertEquals(SALUD_MAXIMA_VAINILLA - (ATAQUE_BASICO_RADAITERAN + 2), vainilla.getSalud());
	}

	@Test
	void aumentarDañoAlAtacarNormalTest() {
		setUp();
		double daño = 0;
		for (int i = 1; i <= 10; i++) {
			radaiteran.atacar(vainilla);
			daño += ATAQUE_BASICO_RADAITERAN + 2 * i;
			assertEquals(SALUD_MAXIMA_VAINILLA - daño, vainilla.getSalud());
		}
	}

	@Test
	void aumentarDañoAlAtacarEnfurezidoTest() {
		setUp();
		vainilla.atacar(radaiteran);
		assertEquals(new RadaiteranEnfurezido(null), radaiteran.getRaza().getEstado());
		assertEquals(SALUD_MAXIMA_RADAITERAN - ATAQUE_BASICO_VAINILLA, radaiteran.getSalud());
		double daño = ATAQUE_BASICO_RADAITERAN * 2;
		double saludVainilla = SALUD_MAXIMA_VAINILLA;
		for (int i = 1; i <= 2; i++) {
			radaiteran.atacar(vainilla);
			daño += 2;
			saludVainilla -= daño;
			assertEquals(saludVainilla, vainilla.getSalud());
		}
		radaiteran.atacar(vainilla);
		daño += 2;
		assertEquals(saludVainilla - daño / 2 - 2, vainilla.getSalud());
	}

	@Test
	void curarSaludDespuesDeDescansarTest() {
		setUp();
		vainilla.atacar(radaiteran);
		assertEquals(new RadaiteranEnfurezido(null), radaiteran.getRaza().getEstado());
		assertEquals(SALUD_MAXIMA_RADAITERAN - ATAQUE_BASICO_VAINILLA, radaiteran.getSalud());
		radaiteran.descansar();
		assertEquals(new RadaiteranMeditando(null), radaiteran.getRaza().getEstado());
		assertEquals((SALUD_MAXIMA_RADAITERAN - ATAQUE_BASICO_VAINILLA) + 25, radaiteran.getSalud());
	}

	@Test
	void aumentarSaludMaximaDespuesDeDescansarTest() {
		setUp();
		radaiteran.descansar();
		assertEquals(new RadaiteranMeditando(null), radaiteran.getRaza().getEstado());
		assertEquals(SALUD_MAXIMA_RADAITERAN + 25, radaiteran.getSalud());
	}

	@Test
	void muertoEnNormalTest() {
		setUp();
		vainilla.atacar(radaiteran);
		vainilla.atacar(radaiteran);
		radaiteran.descansar();
		assertEquals(0, radaiteran.getSalud());
		assertEquals(new Muerto(null), radaiteran.getRaza().getEstado());
		radaiteran.atacar(vainilla);
		assertEquals(SALUD_MAXIMA_VAINILLA, vainilla.getSalud());
	}

	@Test
	void muertoEnDescansadoTest() {
		setUp();
		radaiteran.descansar();
		assertEquals(new RadaiteranMeditando(null), radaiteran.getRaza().getEstado());
		vainilla.atacar(radaiteran);
		vainilla.atacar(radaiteran);
		vainilla.atacar(radaiteran);
		radaiteran.descansar();
		assertEquals(0, radaiteran.getSalud());
		assertEquals(new Muerto(null), radaiteran.getRaza().getEstado());
		radaiteran.atacar(vainilla);
		assertEquals(SALUD_MAXIMA_VAINILLA, vainilla.getSalud());
	}

	@Test
	void muertoEnEnfurecidoTest() {
		setUp();
		vainilla.atacar(radaiteran);
		assertEquals(new RadaiteranEnfurezido(null), radaiteran.getRaza().getEstado());
		vainilla.atacar(radaiteran);
		vainilla.atacar(radaiteran);
		radaiteran.descansar();
		assertEquals(0, radaiteran.getSalud());
		assertEquals(new Muerto(null), radaiteran.getRaza().getEstado());
		radaiteran.atacar(vainilla);
		assertEquals(SALUD_MAXIMA_VAINILLA, vainilla.getSalud());
	}
}
