package transport.section;

import java.util.List;

import transport.Place;
import transport.Section;

public class Premiere extends Section {

	public Premiere(List<Place> places, double pleinTarif) {
		super(places, pleinTarif);
	}

	@Override
	protected int getPourcentagePleinTarif() {
		return 100;
	}

}
