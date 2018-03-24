package transport.section;

import java.util.List;

import transport.place.Place;

public class Deluxe extends SectionPaquebot {

	public Deluxe(List<Place> places, double pleinTarif) {
		super(places, pleinTarif);
	}

	@Override
	protected int getPourcentagePleinTarif() {
		return 100;
	}

}
