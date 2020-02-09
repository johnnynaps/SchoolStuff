package com.janpolin.oopda.university;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Person class. Parent to Instructor and Student classes. To initialize people
 * and perform functions on them.
 * 
 * @author napoli54
 */
public class Person {
	/**
	 * static class level logger for all of the person class
	 */
	private static final Logger personLogger = Logger.getLogger(Person.class.getName());

	private int id = 0;
	private String firstName = "";
	private String middleName = "";
	private String lastName = "";
	private String email = "";
	private String ssn = "";
	private int age = 0;
	private static int maxAge = 0;

	/**
	 * default Person constructor containing logger level settings. compares age to
	 * current maxAge
	 */
	public Person() {
		personLogger.setLevel(Level.WARNING);
		setMaxAge();
	}

	/**
	 * Person constructor with parameters containing logger level settings. compares
	 * age to current maxAge
	 * 
	 * @param id         identification number for each instance of a Person
	 * @param firstName  person's validated first name
	 * @param middleName person's validated middle name
	 * @param lastName   person's validated last name
	 * @param email      person's validated e-mail
	 * @param ssn        person's validated SSN
	 * @param age        person's validated age
	 */
	public Person(int id, String firstName, String middleName, String lastName, String email, String ssn, int age) {
		personLogger.setLevel(Level.WARNING);
		setMaxAge();

		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.ssn = ssn;
		this.age = age;
	}

	/**
	 * default identification number getter
	 * 
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * default first name getter
	 * 
	 * @return String firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * default first name setter
	 * 
	 * @param String firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * default middle name getter
	 * 
	 * @return String middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * default middle name setter
	 * 
	 * @param String middleName
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * default last name getter
	 * 
	 * @return String lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * default last name setter
	 * 
	 * @param String lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * default e-mail getter
	 * 
	 * @return String email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * default email setter
	 * 
	 * @param String email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * default SSN getter
	 * 
	 * @return String ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * default SSN setter
	 * 
	 * @param Stringssn
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * default age getter
	 * 
	 * @return int age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * default age setter
	 * 
	 * @param int age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * overridden toString method returning first name, middle name, last name, and
	 * class
	 * 
	 * @return String first name, middle name, last name, and class
	 */
	public String toString() {
		return this.firstName + " " + this.middleName + " " + this.lastName + " (Person)";
	}

	/**
	 * method to separate e-mail at the '@' and return the domain
	 * 
	 * @return String of e-mail domain
	 */
	public String getEmailDomain() {
		String email = this.email;
		String[] arrEmail = email.split("@");
		return arrEmail[1];
	}

	/**
	 * method to separate the SSN by the - (dashes) and return the last four
	 * 
	 * @return String last four of ssn
	 */
	public String getLast4SSN() {
		String ssn = this.ssn;
		String[] arrSSN = ssn.split("-");
		return arrSSN[2];
	}

	/**
	 * method sets a maximum age to compare each Person against. If the current age
	 * is larger than maxAge, set maxAge to the current age.
	 */
	public void setMaxAge() {
		if (maxAge < this.age) {
			maxAge = this.age;
		}
	}

	/**
	 * static method to return the current value of the maximum age.
	 * 
	 * @return int maxAge
	 */
	public static int getMaxAge() {
		return maxAge;
	}

	/**
	 * method to add the referenced Person to the passed in HashMap using their id
	 * as the key value
	 * 
	 * @param HashMap pMap
	 */
	public void addHashMap(HashMap<Integer, Person> pMap) {
		pMap.put(this.id, this);
	}

	/**
	 * method to validate e-mail using ReGex to make sure it uses legal word
	 * characters. it is not outrageously extensive but gets the job done. a valid
	 * e-mail must contain '@' and '.' with the '.' following the '@' there must be
	 * only one '@' and the domain must be at least one character in length.
	 * 
	 * @param String testEmail
	 * @return boolean
	 */
	public static boolean validEmail(String testEmail) {
		if (testEmail == null) {
			personLogger.log(Level.WARNING, "NULL EMAIL VALUE ENTERED");
			return false;
		} else if (testEmail.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+$"))
			return true;
		else {
			personLogger.log(Level.WARNING, "INVALID E-MAIL ENTERED");
			return false;
		}
	}

	/**
	 * static method to validate the string age passed. If under 16, disallow. If
	 * NumberFormatException, log message.
	 * 
	 * @param testAge
	 * @return boolean
	 */
	public static boolean vaildAge(String testAge) {
		try {

			if (Integer.parseInt(testAge.trim()) >= 16) {
				if (Integer.parseInt(testAge.trim()) >= 100) {
					personLogger.log(Level.WARNING, "AGE OVER 100");
				}
				return true;
			} else if (Integer.parseInt(testAge.trim()) < 16) {
				personLogger.log(Level.WARNING, "AGE UNDER 16");
				return false;
			} else {
				personLogger.log(Level.WARNING, "INVALID VALUE ENTERED");
				return false;
			}
		} catch (NumberFormatException ex) {
			personLogger.log(Level.WARNING, "AGE ENTERED WAS AN INVALID NUMBER");
			return false;
		}
	}

	/**
	 * method to validate SSN using ReGex. there must be two '-' it must be 11 total
	 * characters, and compromised of only digits
	 * 
	 * @param String testSSN
	 * @return boolean
	 */
	public static boolean validSSN(String testSSN) {
		if (testSSN == null) {
			personLogger.log(Level.WARNING, "NULL SSN VALUE ENTERED");
			return false;
		} else if (testSSN.matches("^\\d{3}-\\d{2}-\\d{4}$")) {
			return true;
		} else {
			personLogger.log(Level.WARNING, "INVALID SSN ENTERED");
			return false;
		}
	}

	/**
	 * method to validate a name passed in. must be Alphabetic with dishes or
	 * whitespace (e.g. Jean-Claude Camille François van Varenberg)
	 * 
	 * @param String testName
	 * @return boolean
	 */
	public static boolean validName(String testName) {
		if (testName == null) {
			personLogger.log(Level.WARNING, "NULL NAME VALUE ENTERED");
			return false;
		} else if (testName.matches("^[\\p{Alpha}-\\s]*$")) {
			return true;
		} else {
			personLogger.log(Level.WARNING, "INVALID NAME ENTERED");
			return false;
		}
	}
}
