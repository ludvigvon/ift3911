package transport;

import java.util.List;

public abstract class SectionPaquebot extends BaseSection {

	public SectionPaquebot(List<Place> places, double pleinTarif, String abbrev) {
		super(places, pleinTarif, abbrev);
	}

}
