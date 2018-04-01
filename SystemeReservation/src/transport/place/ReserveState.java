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
		LocalDateTime  now = LocalDateTime.now();
		
		long nbHrs = Duration.between(heureReservation, now).toHours();
				
		if (context.reservation.paiement != null) { // si paiement, devient confimee
			context.setNextState(new ConfirmeState());
		}		
		else if (nbHrs>=24) { // si plus de 24 heures et non payee, redevient libre
			context.setNextState(new LibreState());
		}
			
	}

}
