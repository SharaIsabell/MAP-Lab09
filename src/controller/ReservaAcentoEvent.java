package controller;

public class ReservaAcentoEvent extends java.util.EventObject{
	private static final long serialVersionUID = 1L;

	public ReservaAcentoEvent(Object source) {
		super(source);
	}

}


/* Event --> Listener --> Source
 * Controller --> View --> Model
 */