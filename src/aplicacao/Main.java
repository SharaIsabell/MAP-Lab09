package aplicacao;

import model.ReservaAcento;
import view.PainelCentral;
import view.Quiosque;

public class Main {
	public static void main(String[] args) {
		ReservaAcento res = new ReservaAcento();
		Quiosque quiosque = new Quiosque();
		PainelCentral painel = new PainelCentral();
		res.addReservaAcentoListener(quiosque);
		res.addReservaAcentoListener(painel);
		res.reservaAcento(6);
		res.reservaAcento(8);
		res.reservaAcento(2);
	}
}
