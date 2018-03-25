package transport;

import java.util.List;

public abstract class Section extends BaseSection {

	public Section(List<Place> places, double pleinTarif, String abbrev) {
		super(places, pleinTarif, abbrev);
	}

}
