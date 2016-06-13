package be.vdab.valueobjects;

import java.io.Serializable;
import java.util.Objects;

import be.vdab.util.Utilities;

public class Adres implements Serializable {

	public static final long serialVersionUID = 1L;

	private final String straat;
	private final String huisNr;
	private final Gemeente gemeente;

	/**
	 * 
	 * @param straat
	 *            not null and not empty (only white spaces is also considered
	 *            empty)
	 * @param huisNr
	 *            not null and not empty (only white spaces is also considered
	 *            empty)
	 * @param gemeente
	 *            not null
	 */
	public Adres(String straat, String huisNr, Gemeente gemeente) {
		this.straat = Utilities.checkStringNotNullAndNotEmpty(straat);
		this.huisNr = Utilities.checkStringNotNullAndNotEmpty(huisNr);
		this.gemeente = Objects.requireNonNull(gemeente);
	}

	public String getStraat() {
		return straat;
	}
	
	public String getHuisNr() {
		return huisNr;
	}

	public Gemeente getGemeente() {
		return gemeente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gemeente == null) ? 0 : gemeente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Adres)) {
			return false;
		}
		Adres other = (Adres) obj;
		if (gemeente == null) {
			if (other.gemeente != null) {
				return false;
			}
		} else if (!gemeente.equals(other.gemeente)) {
			return false;
		}
		if (huisNr == null) {
			if (other.huisNr != null) {
				return false;
			}
		} else if (!huisNr.equals(other.huisNr)) {
			return false;
		}
		if (straat == null) {
			if (other.straat != null) {
				return false;
			}
		} else if (!straat.equals(other.straat)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Adres [straat=" + straat + ", huisNr=" + huisNr + ", gemeente=" + gemeente + "]";
	}
}
