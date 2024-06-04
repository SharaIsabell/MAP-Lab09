package controller;

import model.ReservaAcento;

public class ReservaAcentoEvent extends java.util.EventObject{
	private static final long serialVersionUID = 1L;

	public ReservaAcentoEvent(ReservaAcento source) {
		super(source);
	}

}

/* Event --> Listener --> Source
 * Controller --> View --> Model
 */