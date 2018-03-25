package transport.section;

import java.util.List;

import transport.Place;
import transport.SectionPaquebot;

public class Ocean extends SectionPaquebot {

	public Ocean(List<Place> places, double pleinTarif) {
		super(places, pleinTarif);
	}

	@Override
	protected int getPourcentagePleinTarif() {
		return 75;
	}

}
