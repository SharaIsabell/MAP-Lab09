package testes;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import model.ReservaAcento;
import model.StatusAcento;
import view.PainelCentral;
import view.Quiosque;

public class ReservaAcentoTest {

	static ReservaAcento res;
	static Quiosque quiosque;
	static PainelCentral painel;
	
	@BeforeClass
	public static void criarObjetos(){
		res = new ReservaAcento();
		quiosque = new Quiosque();
		painel = new PainelCentral();
		res.addReservaAcentoListener(painel);
	}
	
	@Test
    public void addReservaAcentoListenerSizeTest() {
        assertEquals(2, res.getReservaListeners().size());
        assertTrue(res.getReservaListeners().contains(painel));
    }
	
	@Test(expected = RuntimeException.class)
	public void reservaAcentoTest() {
		res.reservaAcento(2);
		res.reservaAcento(2);
	}
	
	@Test(expected = RuntimeException.class)
	public void addReservaAcentoListenerTest() {
		res.addReservaAcentoListener(quiosque);
		res.addReservaAcentoListener(quiosque);
	}
	
	@Test(expected = RuntimeException.class)
	public void removeReservaAcentoListenerTest() {
		res.removeReservaAcentoListener(quiosque);
		res.removeReservaAcentoListener(quiosque);
	}
	
	@Test
	public void getReservaListenersTest() {
		assertEquals(painel, res.getReservaListeners().get(0));
	}
	
	@Test
	public void getAcentosTest() {
		assertEquals(StatusAcento.DISPONIVEL, res.getAcentos().get(5));
	}
}
