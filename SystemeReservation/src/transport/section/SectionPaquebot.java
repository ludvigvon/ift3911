package transport.section;

import java.util.List;

import transport.place.Place;

public abstract class SectionPaquebot extends BaseSection {

	public SectionPaquebot(List<Place> places, double pleinTarif) {
		super(places, pleinTarif);
	}

}
