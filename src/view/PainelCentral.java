package view;

import java.util.HashMap;
import java.util.Map;

import controller.ReservaAcentoEvent;
import model.ReservaAcento;
import model.StatusAcento;



public class PainelCentral implements ReservaAcentoListener{
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	
	//cores utilizadas
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	
	public void acentoReservado(ReservaAcentoEvent res) {
		System.out.println();
		System.out.println("Painel notificado que novo acento foi reservado");
	}
	public void mostrarCadeiras(ReservaAcentoEvent resEvent) {
		System.out.println();
		System.out.println("Disposicao de cadeiras atualizadas");
		ReservaAcento res = (ReservaAcento)resEvent.getSource();
		for(Map.Entry<Integer, StatusAcento> acento : res.getAcentos().entrySet()) {
			if(acento.getValue() == StatusAcento.DISPONIVEL) {
				System.out.print(ANSI_GREEN_BACKGROUND + acento.getKey() + ANSI_RESET);
			}
			else if(acento.getValue() == StatusAcento.RESERVADO) {
				System.out.print(ANSI_YELLOW_BACKGROUND + acento.getKey() + ANSI_RESET);
			}
			else {
				System.out.print(ANSI_RED_BACKGROUND + acento.getKey() + ANSI_RESET);
			}
			System.out.print(" ");
		}
	}
}
