package transport.place;

import transport.Place;
import transport.PlaceState;

public class ConfirmeState implements PlaceState {

	@Override
	public void goNext(Place context) {
		// TODO si annulation ou modif, libre
		context.setNextState(new LibreState());
	}

}
