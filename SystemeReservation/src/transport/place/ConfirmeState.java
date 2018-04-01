package transport.place;

import reservation.Annulation;
import transport.Place;
import transport.PlaceState;

public class ConfirmeState implements PlaceState {

	@Override
	public void goNext(Place context) {
		if (context.reservation.changements.stream().anyMatch(c -> c instanceof Annulation)) // si annulation, redevient libre
			context.setNextState(new LibreState());
	}
}
