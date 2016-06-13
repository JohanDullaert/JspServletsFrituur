package be.vdab.entities;

import java.io.Serializable;
import java.util.Arrays;

import be.vdab.util.Utilities;

public class Saus implements Serializable {

	public static final long serialVersionUID = 1L;

	private long nummer;
	private String naam;
	private String[] ingredienten;

	public Saus(long nummer, String naam, String[] ingredienten) {
		setNummer(nummer);
		setNaam(naam);
		setIngredienten(ingredienten);
	}

	public long getNummer() {
		return nummer;
	}

	public final void setNummer(long nummer) {
		this.nummer = nummer;
	}

	public String getNaam() {
		return naam;
	}

	public final void setNaam(String naam) {
		this.naam = Utilities.checkStringNotNullAndNotEmpty(naam);
	}

	public String[] getIngredienten() {
		return ingredienten;
	}

	public final void setIngredienten(String[] ingredienten) {
		this.ingredienten = Utilities.checkArrayOfStringsContainsNoNullAndNoEmptyElements(ingredienten);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (nummer ^ (nummer >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Saus)) {
			return false;
		}
		Saus other = (Saus) obj;
		if (naam == null) {
			if (other.naam != null) {
				return false;
			}
		} else if (!naam.equals(other.naam)) {
			return false;
		}
		return nummer == other.nummer;
	}

	@Override
	public String toString() {
		return "Saus [nummer=" + nummer + ", naam=" + naam + ", ingredienten=" + Arrays.toString(ingredienten) + "]";
	}

}
