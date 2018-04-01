package transport.place;

import transport.Place;

public class LibreState implements transport.PlaceState {

	@Override
	public void goNext(Place context) {
		if (context.reservation != null)
			context.setNextState(new ReserveState());
	}

}
