package view;

import controller.ReservaAcentoEvent;

public interface ReservaAcentoListener extends java.util.EventListener{
	void acentoReservado(ReservaAcentoEvent res);
	void mostrarCadeiras(ReservaAcentoEvent res);
}
