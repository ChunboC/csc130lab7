package lab7;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * <p>
 * Title: CovidCase.java
 * </p>
 *
 * <p>
 * Description: class represents an instance of reported COVID-19 cases,
 * encapsulating information such as the date of reporting, the country code,
 * country name, WHO region, the number of new cases and deaths reported, as
 * well as cumulative cases and deaths.
 * </p>
 *
 * @author Chunbo Cheng
 */
public class CovidCase implements Comparable<CovidCase> {
	java.time.LocalDate dateReported;
	String countryCode;
	String country;
	String whoRegion;
	int newcases;
	int cumulativeCases;
	int newDeaths;
	int cumulativeDeaths;

	/**
	 * Default constructor for CovidCase.
	 */
	public CovidCase() {
		super();
	}

	/**
	 * Constructor for creating a CovidCase object from an array of strings.
	 * 
	 * @param arr An array containing the information of a CovidCase.
	 */
	public CovidCase(String[] arr) {
		countryCode = arr[1];
		country = arr[2];
		whoRegion = arr[3];
		try {
			dateReported = LocalDate.parse(arr[0]);
		} catch (DateTimeParseException e) {
			dateReported = LocalDate.parse("1/1/1900");
		}
		try {
			newcases = Integer.parseInt(arr[4]);
		} catch (NumberFormatException e) {
			newcases = 0;
		}
		try {
			cumulativeCases = Integer.parseInt(arr[5]);
		} catch (NumberFormatException e) {
			cumulativeCases = 0;
		}
		try {
			newDeaths = Integer.parseInt(arr[6]);
		} catch (NumberFormatException e) {
			newDeaths = 0;
		}
		try {
			cumulativeDeaths = Integer.parseInt(arr[7]);
		} catch (NumberFormatException e) {
			cumulativeDeaths = 0;
		}
	}

	/**
	 * Constructor for creating a CovidCase object with specific attributes.
	 * 
	 * @param dateReported     The date the case was reported.
	 * @param countryCode      The country code.
	 * @param country          The name of the country.
	 * @param whoRegion        The WHO region.
	 * @param newcases         The number of new cases reported.
	 * @param cumulativeCases  The cumulative number of cases reported.
	 * @param newDeaths        The number of new deaths reported.
	 * @param cumulativeDeaths The cumulative number of deaths reported.
	 */
	public CovidCase(LocalDate dateReported, String countryCode, String country, String whoRegion, int newcases,
			int cumulativeCases, int newDeaths, int cumulativeDeaths) {
		super();
		this.dateReported = dateReported;
		this.countryCode = countryCode;
		this.country = country;
		this.whoRegion = whoRegion;
		this.newcases = newcases;
		this.cumulativeCases = cumulativeCases;
		this.newDeaths = newDeaths;
		this.cumulativeDeaths = cumulativeDeaths;
	}

	/**
	 * Gets the date when the case was reported.
	 * 
	 * @return The dateReported.
	 */
	public java.time.LocalDate getDateReported() {
		return dateReported;
	}

	/**
	 * Sets the date when the case was reported.
	 * 
	 * @param dateReported The dateReported to set.
	 */
	public void setDateReported(java.time.LocalDate dateReported) {
		this.dateReported = dateReported;
	}

	/**
	 * Gets the country code.
	 * 
	 * @return The countryCode.
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Sets the country code.
	 * 
	 * @param countryCode The countryCode to set.
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Gets the name of the country.
	 * 
	 * @return The country.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the name of the country.
	 * 
	 * @param country The country to set.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the WHO region.
	 * 
	 * @return The whoRegion.
	 */
	public String getWhoRegion() {
		return whoRegion;
	}

	/**
	 * Sets the WHO region.
	 * 
	 * @param whoRegion The whoRegion to set.
	 */
	public void setWhoRegion(String whoRegion) {
		this.whoRegion = whoRegion;
	}

	/**
	 * Gets the number of new cases reported.
	 * 
	 * @return The newcases.
	 */
	public int getNewcases() {
		return newcases;
	}

	/**
	 * Sets the number of new cases reported.
	 * 
	 * @param newcases The newcases to set.
	 */
	public void setNewcases(int newcases) {
		this.newcases = newcases;
	}

	/**
	 * Gets the cumulative number of cases reported.
	 * 
	 * @return The cumulativeCases.
	 */
	public int getCumulativeCases() {
		return cumulativeCases;
	}

	/**
	 * Sets the cumulative number of cases reported.
	 * 
	 * @param cumulativeCases The cumulativeCases to set.
	 */
	public void setCumulativeCases(int cumulativeCases) {
		this.cumulativeCases = cumulativeCases;
	}

	/**
	 * Gets the number of new deaths reported.
	 * 
	 * @return The newDeaths.
	 */
	public int getNewDeaths() {
		return newDeaths;
	}

	/**
	 * Sets the number of new deaths reported.
	 * 
	 * @param newDeaths The newDeaths to set.
	 */
	public void setNewDeaths(int newDeaths) {
		this.newDeaths = newDeaths;
	}

	/**
	 * Gets the cumulative number of deaths reported.
	 * 
	 * @return The cumulativeDeaths.
	 */
	public int getCumulativeDeaths() {
		return cumulativeDeaths;
	}

	/**
	 * Sets the cumulative number of deaths reported.
	 * 
	 * @param cumulativeDeaths The cumulativeDeaths to set.
	 */
	public void setCumulativeDeaths(int cumulativeDeaths) {
		this.cumulativeDeaths = cumulativeDeaths;
	}

	/**
	 * Returns a string representation of the CovidCase.
	 * 
	 * @return A string representation of the CovidCase.
	 */
	@Override
	public String toString() {
		return "CovidCase [dateReported=" + dateReported + ", countryCode=" + countryCode + ", country=" + country
				+ ", whoRegion=" + whoRegion + ", newcases=" + newcases + ", cumulativeCases=" + cumulativeCases
				+ ", newDeaths=" + newDeaths + ", cumulativeDeaths=" + cumulativeDeaths + "]";
	}

	/**
	 * Compares this CovidCase to another CovidCase for ordering.
	 * 
	 * @param o The CovidCase to be compared.
	 * @return A negative integer, zero, or a positive integer as this CovidCase is
	 *         less than, equal to, or greater than the specified CovidCase.
	 */
	@Override
	public int compareTo(CovidCase o) {
		if (countryCode.equals(o.getCountryCode()))
			return dateReported.compareTo(o.getDateReported());
		return countryCode.compareTo(o.getCountryCode());
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * @param o The reference object with which to compare.
	 * @return true if this object is the same as the obj argument; false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (o.getClass().getSimpleName().equals("CovidCase")) {
			return countryCode.equalsIgnoreCase(((CovidCase) o).getCountryCode());
		}
		return false;
	}
}
