package transport.section;

import java.util.List;

import transport.Place;
import transport.Section;

public class Affaire extends Section {

	public Affaire(List<Place> places, double pleinTarif) {
		super(places, pleinTarif);
	}

	@Override
	protected int getPourcentagePleinTarif() {
		return 75;
	}

}
