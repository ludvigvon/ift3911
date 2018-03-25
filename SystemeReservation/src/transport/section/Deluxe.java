package transport.section;

import java.util.List;

import transport.Place;
import transport.SectionPaquebot;

public class Deluxe extends SectionPaquebot {

	public Deluxe(List<Place> places, double pleinTarif) {
		super(places, pleinTarif);
	}

	@Override
	protected int getPourcentagePleinTarif() {
		return 100;
	}

}
