package transport.place;

import transport.Place;

public class LibreState implements transport.PlaceState {

	@Override
	public void goNext(Place context) {
		// TODO Auto-generated method stub
		context.setNextState(new ReserveState());
	}

}
