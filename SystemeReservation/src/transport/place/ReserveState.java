package transport.place;

import java.time.Duration;
import java.time.LocalDateTime;

import transport.Place;
import transport.PlaceState;

public class ReserveState implements PlaceState {

	private LocalDateTime  heureReservation;

	public ReserveState() {
		this.heureReservation = LocalDateTime.now();
	}

	@Override
	public void goNext(Place context) {
		// TODO si annulation ou modif, LIBRE. Si paiement, CONFIRTME 		
		LocalDateTime  now = LocalDateTime.now();
		
		long nbHrs = Duration.between(heureReservation, now).toHours();
		
		// si plus de 24h, redevient libre
		if (nbHrs>=24) {
			context.setNextState(new LibreState());
		}
			
	}

}
