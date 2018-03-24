package transport.section;

import java.util.List;

import transport.place.Place;

public class Ocean extends SectionPaquebot {

	public Ocean(List<Place> places, double pleinTarif) {
		super(places, pleinTarif);
	}

	@Override
	protected int getPourcentagePleinTarif() {
		return 75;
	}

}
