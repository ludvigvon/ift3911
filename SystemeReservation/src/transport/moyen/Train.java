package transport.moyen;

import java.util.List;

import transport.BaseSection;
import transport.MoyenTransport;

public class Train extends MoyenTransport {

	public Train(String modele, List<BaseSection> sections) {
		super(modele, sections);
	}

}
