package transport.place;

import transport.Place;

public class LibreState implements transport.PlaceState {

	@Override
	public void goNext(Place context) {		
		context.setNextState(new ReserveState());
	}

}
