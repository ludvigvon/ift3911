package transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CieTransport {
	protected String id;
	public String name;
	public List<MoyenTransport> moyensTransport;
	
	
	public CieTransport(String id, String name) {
		this.id = id;
		this.name = name;
		this.moyensTransport = new ArrayList<MoyenTransport>();
	}
	
	public String getId() {
		return id;
	}
	
	public MoyenTransport getMoyenTransport(String modele) {
		Optional<MoyenTransport> moyen = moyensTransport.stream().filter(m -> m.modele == modele).findFirst();
		if (moyen.isPresent())
			return moyen.get();
		return null;
	}
}
