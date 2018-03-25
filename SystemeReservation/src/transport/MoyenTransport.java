package transport;

import java.util.List;

public abstract class MoyenTransport {
	public String modele;
	public List<BaseSection> sections;
	
	public MoyenTransport(String modele, List<BaseSection> sections) {
		this.modele = modele;
		this.sections = sections;
	}
	
}
