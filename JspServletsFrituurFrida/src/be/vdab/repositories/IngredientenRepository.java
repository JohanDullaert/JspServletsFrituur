package be.vdab.repositories;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import be.vdab.entities.Saus;	

public class IngredientenRepository {
	
	private final SausRepository sausRepository = new SausRepository();
	
	public Set<String> findAll(){
		Set<String> ingredienten = new HashSet<>();
		for (Saus saus : sausRepository.findAll()) {
			ingredienten.addAll(Arrays.asList(saus.getIngredienten()));
		}
		return ingredienten;
	}
	
	
	

}
