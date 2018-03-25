package transport.section;

import java.util.List;

import transport.Place;
import transport.SectionPaquebot;

public class Suite extends SectionPaquebot {

	public Suite(List<Place> places, double pleinTarif) {
		super(places, pleinTarif, "S");
	}

	@Override
	protected int getPourcentagePleinTarif() {
		return 90;
	}

}
