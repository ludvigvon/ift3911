package transport.section;

import java.util.List;

import transport.Place;
import transport.SectionPaquebot;

public class Interieur extends SectionPaquebot {

	public Interieur(List<Place> places, double pleinTarif) {
		super(places, pleinTarif, "I");
	}

	@Override
	protected int getPourcentagePleinTarif() {
		return 50;
	}

}
