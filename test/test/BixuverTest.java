package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import estados.BixuverDescansado;
import estados.BixuverNormal;
import estados.Muerto;
import principal.Personaje;
import razas.Bixuver;
import razas.Vainilla;
import utils.Posicion;

class BixuverTest {
	private static final double ATAQUE_BASICO_BIXUVER = 87.00;
	private static final double SALUD_MAXIMA_BIXUVER = 103.00;
	private static final double ATAQUE_BASICO_VAINILLA = 100;
	private static final double SALUD_MAXIMA_VAINILLA = 1000;
	Personaje bixuver;
	Personaje vainilla;

	@Before
	void setUp() {
		bixuver = new Personaje();
		vainilla = new Personaje();
		bixuver.elegirRaza(new Bixuver(bixuver));
		vainilla.elegirRaza(new Vainilla(vainilla));
		bixuver.mover(new Posicion());
		vainilla.mover(new Posicion());
	}

	@Test
	void instanciarBixuverTest() {
		setUp();
		assertEquals(new BixuverNormal(null), bixuver.getRaza().getEstado());
		assertEquals(SALUD_MAXIMA_BIXUVER, bixuver.getSalud());
	}

	@Test
	void descontarVidaRecibirAtaqueTest() {
		setUp();
		vainilla.atacar(bixuver);
		assertEquals(SALUD_MAXIMA_BIXUVER - ATAQUE_BASICO_VAINILLA / 6.00, bixuver.getSalud());
	}

	@Test
	void descontarVidaAlAtacarTest() {
		setUp();
		bixuver.atacar(vainilla);
		assertEquals(SALUD_MAXIMA_VAINILLA - ATAQUE_BASICO_BIXUVER, vainilla.getSalud());
	}

	@Test
	void curarVidaAlAtacarTest() {
		setUp();
		bixuver.atacar(vainilla);
		assertEquals(SALUD_MAXIMA_BIXUVER, bixuver.getSalud());
		vainilla.atacar(bixuver);
		bixuver.atacar(vainilla);
		assertEquals((SALUD_MAXIMA_BIXUVER - ATAQUE_BASICO_VAINILLA / 6) * 1.02, bixuver.getSalud());
	}

	@Test
	void aumentoDefensaDespuesDeDescansarTest() {
		setUp();
		bixuver.descansar();
		assertEquals(new BixuverDescansado(null), bixuver.getRaza().getEstado());
		vainilla.atacar(bixuver);
		assertEquals(new BixuverNormal(null), bixuver.getRaza().getEstado());
		assertEquals(SALUD_MAXIMA_BIXUVER - ATAQUE_BASICO_VAINILLA / (2.00 * 6.00), bixuver.getSalud());
	}

	@Test
	void muertoEnNormalTest() {
		setUp();
		vainilla.atacar(bixuver);
		vainilla.atacar(bixuver);
		vainilla.atacar(bixuver);
		vainilla.atacar(bixuver);
		vainilla.atacar(bixuver);
		vainilla.atacar(bixuver);
		vainilla.atacar(bixuver);
		bixuver.descansar();
		assertEquals(0, bixuver.getSalud());
		assertEquals(new Muerto(null), bixuver.getRaza().getEstado());
		bixuver.atacar(vainilla);
		assertEquals(SALUD_MAXIMA_VAINILLA, vainilla.getSalud());
	}

	@Test
	void muertoEnDescansadoTest() {
		setUp();
		bixuver.descansar();
		assertEquals(new BixuverDescansado(null), bixuver.getRaza().getEstado());
		vainilla.atacar(bixuver);
		vainilla.atacar(bixuver);
		vainilla.atacar(bixuver);
		vainilla.atacar(bixuver);
		vainilla.atacar(bixuver);
		vainilla.atacar(bixuver);
		vainilla.atacar(bixuver);
		bixuver.descansar();
		assertEquals(0, bixuver.getSalud());
		assertEquals(new Muerto(null), bixuver.getRaza().getEstado());
		bixuver.atacar(vainilla);
		assertEquals(SALUD_MAXIMA_VAINILLA, vainilla.getSalud());
	}

}
