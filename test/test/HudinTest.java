package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import estados.HudinNormal;
import estados.HudinPiedra;
import estados.Muerto;
import principal.Personaje;
import razas.Hudin;
import razas.Vainilla;
import utils.Posicion;

class HudinTest {

	private static final double DAÑO_VENENO = 2.00;
	private static final double ATAQUE_BASICO_HUDIN = 49.00;
	private static final double SALUD_MAXIMA_HUDIN = 196.00;
	private static final double ATAQUE_BASICO_VAINILLA = 100;
	private static final double SALUD_MAXIMA_VAINILLA = 1000;
	Personaje hudin;
	Personaje vainilla;

	@Before
	void setUp() {
		hudin = new Personaje();
		vainilla = new Personaje();
		hudin.elegirRaza(new Hudin(hudin));
		vainilla.elegirRaza(new Vainilla(vainilla));
		hudin.mover(new Posicion(0, 0));
		vainilla.mover(new Posicion(0, 3));
	}

	@Test
	void instanciarHudinTest() {
		setUp();
		assertEquals(new HudinNormal(null), hudin.getRaza().getEstado());
		assertEquals(SALUD_MAXIMA_HUDIN, hudin.getSalud());
	}

	@Test
	@DisplayName("Descuenta la salud al recibir ataque")
	void descontarVidaRecibirAtaqueTest() {
		setUp();
		vainilla.atacar(hudin);
		assertEquals((SALUD_MAXIMA_HUDIN - ATAQUE_BASICO_VAINILLA), hudin.getSalud());
	}

	@Test
	void envenenarAlAtacarTest() {
		setUp();
		vainilla.mover(new Posicion(0, 7));
		hudin.atacar(vainilla);
		double vidaBixuver = vainilla.getSalud();
		vainilla.atacar(hudin);
		vainilla.atacar(hudin);
		vainilla.atacar(hudin);
		// pasan 3 turnos, el veneno le tuvo que sacar 6 de salud
		assertEquals(vidaBixuver - DAÑO_VENENO * 3, vainilla.getSalud());
	}

	@Test
	void descontarVidaAlAtacarTest() {
		setUp();
		vainilla.mover(new Posicion(0, 7));
		hudin.atacar(vainilla);
		assertEquals(SALUD_MAXIMA_VAINILLA - (ATAQUE_BASICO_HUDIN) - DAÑO_VENENO, vainilla.getSalud());
	}

	@Test
	void restaurarSaludDespuesDeDescansarTest() {
		setUp();
		vainilla.atacar(hudin);
		assertEquals(SALUD_MAXIMA_HUDIN - ATAQUE_BASICO_VAINILLA, hudin.getSalud());
		hudin.descansar();
		assertEquals(new HudinPiedra(null), hudin.getRaza().getEstado());
		assertEquals(SALUD_MAXIMA_HUDIN, hudin.getSalud());
	}

	@Test
	void aumentoDefensaDespuesDeDescansarTest() {
		setUp();
		hudin.descansar();
		assertEquals(new HudinPiedra(null), hudin.getRaza().getEstado());
		vainilla.atacar(hudin);
		assertEquals(SALUD_MAXIMA_HUDIN - (ATAQUE_BASICO_VAINILLA * 3 / 4), hudin.getSalud());
	}

	@Test
	void muertoEnNormalTest() {
		setUp();
		vainilla.atacar(hudin);
		vainilla.atacar(hudin);
		hudin.descansar();
		assertEquals(0, hudin.getSalud());
		assertEquals(new Muerto(null), hudin.getRaza().getEstado());
		hudin.atacar(vainilla);
		assertEquals(SALUD_MAXIMA_VAINILLA, vainilla.getSalud());
	}
	
	@Test
	void muertoEnPiedraTest() {
		setUp();
		hudin.descansar();
		assertEquals(new HudinPiedra(null), hudin.getRaza().getEstado());
		vainilla.atacar(hudin);
		vainilla.atacar(hudin);
		vainilla.atacar(hudin);
		hudin.descansar();
		assertEquals(0, hudin.getSalud());
		assertEquals(new Muerto(null), hudin.getRaza().getEstado());
		hudin.atacar(vainilla);
		assertEquals(SALUD_MAXIMA_VAINILLA, vainilla.getSalud());
	}

}
