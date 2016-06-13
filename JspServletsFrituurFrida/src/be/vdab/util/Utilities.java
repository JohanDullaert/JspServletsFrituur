package be.vdab.util;

import java.util.Objects;

/**
 * provides helper methodes
 * 
 * @author Johan.Dullaert
 *
 */
public class Utilities {

	private Utilities() {
		// no instance needed
	}

	/**
	 * validates if the parameter is not null and not empty (only white spaces
	 * is also considered empty)
	 * 
	 * @param string
	 * @return the string given as parameter (unchanged) if the validation
	 *         succeeds
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 *             if the string is empty (only white spaces is also considered
	 *             empty)
	 */
	public static String checkStringNotNullAndNotEmpty(String string)
			throws NullPointerException, IllegalArgumentException {
		Objects.requireNonNull(string);
		if (string.trim().isEmpty()) {
			throw new IllegalArgumentException("string may not be empty");
		}
		return string;
	}

	/**
	 * validates if the parameter is not null and contains no not null and no
	 * not empty (only white spaces is also considered empty) elements
	 * 
	 * @param arrayOfString
	 * @return the unchanged arrayOfString if validation succeeds
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public static String[] checkArrayOfStringsContainsNoNullAndNoEmptyElements(String[] arrayOfString)
			throws NullPointerException, IllegalArgumentException {
		Objects.requireNonNull(arrayOfString);
		for (String string : arrayOfString) {
			checkStringNotNullAndNotEmpty(string);
		}
		return arrayOfString;
	}

}
