package transport;

import transport.place.LibreState;

public abstract class Place {
	public BaseSection section;
	private PlaceState currentState;

	public Place(BaseSection section) {
		this.section = section;
		this.currentState = new LibreState();
	}
	
	public void goNextState() {
		currentState.goNext(this);
	}
	
	public void setNextState(PlaceState state) {
		this.currentState = state;
	}
	
	public PlaceState getState() {
		return currentState;
	}
	
	public boolean isDisponible() {
		return currentState instanceof LibreState;
	}
}
