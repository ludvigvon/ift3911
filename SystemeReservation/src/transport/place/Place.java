package transport.place;

import transport.section.BaseSection;

public abstract class Place {
	public BaseSection section;

	public Place(BaseSection section) {
		this.section = section;
	}
	
}
