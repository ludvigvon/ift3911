package transport.section;

import java.util.List;

import transport.place.Place;

public abstract class Section extends BaseSection {

	public Section(List<Place> places, double pleinTarif) {
		super(places, pleinTarif);
	}

}
