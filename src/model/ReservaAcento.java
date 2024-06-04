package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import controller.ReservaAcentoEvent;
import view.ReservaAcentoListener;

public class ReservaAcento {
	private List<ReservaAcentoListener> reservaListeners = new ArrayList<>();
	private HashMap<Integer, StatusAcento> acentos = new HashMap<>();

	public ReservaAcento() {
		for(int i = 1; i <= 10; i++) { // Inicia o ônibus com 10 acentos, 9 disponíveis e 1 indisponível
			acentos.put(i, StatusAcento.DISPONIVEL);
			if(i == 10) {
				acentos.put(i, StatusAcento.INDISPONIVEL);
			}
		}
	}
	
	public void reservaAcento(int numAcento) {
		if(acentos.get(numAcento) == StatusAcento.RESERVADO || acentos.get(numAcento) == StatusAcento.INDISPONIVEL) {
			throw new RuntimeException("Acento indisponível para reserva");
		}
		acentos.put(numAcento, StatusAcento.RESERVADO);
		disparaAcentoReservado();
	}

	private void disparaAcentoReservado() {
		List<ReservaAcentoListener> rl;
		synchronized (this) {
			rl = (List)(((ArrayList) reservaListeners).clone());
		}
		
		ReservaAcentoEvent evento = new ReservaAcentoEvent(this);
		for(ReservaAcentoListener res : rl) {
			res.acentoReservado(evento);
			res.mostrarCadeiras(evento);
		}
	}

	public synchronized void addReservaAcentoListener(ReservaAcentoListener resL) {
		if(!reservaListeners.contains(resL)) {
			reservaListeners.add(resL);
			return;
		}
		throw new RuntimeException("ReservaAcentoListener já existe");
	}
	
	public synchronized void removeReservaAcentoListener(ReservaAcentoListener resL) {
		if(reservaListeners.contains(resL)) {
			reservaListeners.remove(resL);
		}
		throw new RuntimeException("ReservaAcentoListener não existe");
	}
	
	
	// Getters
	public List<ReservaAcentoListener> getReservaListeners() {
		return reservaListeners;
	}

	public HashMap<Integer, StatusAcento> getAcentos() {
		return acentos;
	}
}
