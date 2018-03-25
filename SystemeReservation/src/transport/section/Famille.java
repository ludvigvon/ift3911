package transport.section;

import java.util.List;

import transport.Place;
import transport.SectionPaquebot;

public class Famille extends SectionPaquebot {

	public Famille(List<Place> places, double pleinTarif) {
		super(places, pleinTarif);
	}

	@Override
	protected int getPourcentagePleinTarif() {
		return 90;
	}

}
