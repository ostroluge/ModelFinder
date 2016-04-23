package org.acteacademie.modelfinder.domain.customobject;

import org.acteacademie.modelfinder.domain.Accessories;
import org.acteacademie.modelfinder.domain.Annonce;

public class AnnonceAccessories {

	private Annonce annonce;
	
	private Accessories accessories;

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public Accessories getAccessories() {
		return accessories;
	}

	public void setAccessories(Accessories accessories) {
		this.accessories = accessories;
	}
}
