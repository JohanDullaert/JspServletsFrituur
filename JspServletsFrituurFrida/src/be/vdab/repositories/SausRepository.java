package be.vdab.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import be.vdab.entities.Saus;

public class SausRepository {

	// oef 10 MVC: er is nog geen sprake van toevoegen of verwijderen van
	// sauzen,
	// dus concurrent lijkt me overbodig op deze moment (cursus is wel met
	// create)
	private final static Map<Long, Saus> SAUZEN = new ConcurrentHashMap<>();

	static {
		SAUZEN.put(1L, new Saus(1, "mayonaise", new String[] { "ei", "olie", "mosterd" }));
		SAUZEN.put(2L, new Saus(2, "cocktail", new String[] {}));
		SAUZEN.put(3L, new Saus(3, "mosterd", new String[] { "chilli" }));
		SAUZEN.put(4L, new Saus(4, "tartare", new String[] { "mayo", "pikkels", "mosterd" }));
		SAUZEN.put(5L, new Saus(5, "vinaigrette", new String[] { "olie", "honing", "bieslook" }));
	}

	// waarom niet ineens een list van sauzen maken ipv een map? (cfr cursus)
	// Is dat om een databank wat te faken?
	public List<Saus> findAll() {
		return new ArrayList<>(SAUZEN.values());
	}

	public List<Saus> findByHasIngredient(String... ingredienten) {
		List<Saus> sauzen = new ArrayList<>();
		for (Saus saus : SAUZEN.values()) {
			for (String ingredient : ingredienten) {
				if (saus.hasIngredient(ingredient)) {
					sauzen.add(saus);
					// spring uit lus ingredienten, 1 ingredient bevatten is
					// voldoende om de lijst te halen
					break;
				}
			}
		}
		return sauzen;
	}

	public List<Saus> findByHasAllIngredients(String[] ingredienten) {
		List<Saus> sauzen = new ArrayList<>();
		for (Saus saus : SAUZEN.values()) {
			if (saus.hasAllIngredients(ingredienten)) {
				sauzen.add(saus);
			}
		}
		return sauzen;
	}

	public void delete(Long nummer) {
		SAUZEN.remove(nummer);
	}

}
