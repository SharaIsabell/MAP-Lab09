package view;

import java.util.Map;

import controller.ReservaAcentoEvent;
import model.ReservaAcento;
import model.StatusAcento;

public class Quiosque implements ReservaAcentoListener{
	
	public void acentoReservado(ReservaAcentoEvent resEvent) {
		System.out.println();
		System.out.println("Quiosque notificado que novo acento foi reservado");
		
	}
	
	public void mostrarCadeiras(ReservaAcentoEvent resEvent) {
		System.out.println();
		ReservaAcento res = (ReservaAcento)resEvent.getSource();
		System.out.println("Listagem das cadeiras");
		for(Map.Entry<Integer, StatusAcento> acento : res.getAcentos().entrySet()) {
			System.out.println(acento.getKey() + " " + acento.getValue());
		}
	}
}
