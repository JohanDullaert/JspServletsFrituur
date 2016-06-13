package be.vdab.valueobjects;

import java.io.Serializable;

import be.vdab.exceptions.PostCodeException;
import be.vdab.util.Utilities;

public class Gemeente implements Serializable {

	public static final long serialVersionUID = 1L;

	private final String naam;
	private final int postCode;

	/**
	 * 
	 * @param naam
	 *            not null and not empty (only white spaces is also considered
	 *            empty)
	 * @param postCode
	 *            between 1000 and 10000 (inclusive)
	 * @throws PostCodeException
	 */
	public Gemeente(String naam, int postCode) throws PostCodeException {
		this.naam = Utilities.checkStringNotNullAndNotEmpty(naam);
		this.postCode = checkPostCode(postCode);
	}	

	public String getNaam() {
		return naam;
	}

	public int getPostCode() {
		return postCode;
	}

	/**
	 * public static method to provide a check for clients if the postcode
	 * parameter is valid (must be between 1000 and 10000 (inclusive))
	 * 
	 * @param postCode
	 * @return true if validation succeeds, false if validation false
	 */
	public static boolean isValidPostCode(int postCode) {
		try {
			checkPostCode(postCode);
			return true;
		} catch (PostCodeException e) {
			// exception is not ignored but translated to the boolean false
			return false;
		}
	}

	private static int checkPostCode(int postCode) throws PostCodeException {
		if (postCode < 1000 || postCode > 10000) {
			throw new PostCodeException(
					postCode + " is not a valid postcode (must be between 1000 and 10000 (inclusive)");
		}
		return postCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Gemeente)){
			return false;
		}			
		Gemeente other = (Gemeente) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return (postCode == other.postCode);
	}

	@Override
	public String toString() {
		return "Gemeente [naam=" + naam + ", postCode=" + postCode + "]";
	}
}
