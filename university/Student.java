package com.janpolin.oopda.university;

/**
 * Student class. Child of Person class.
 * 
 * @author napoli54
 */
public class Student extends Person {
	String major = "";

	/**
	 * Student constructor. Uses Parent superclass and adds major
	 * 
	 * @param id
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param email
	 * @param ssn
	 * @param age
	 * @param major
	 */
	public Student(int id, String firstName, String middleName, String lastName, String email, String ssn, int age,
			String major) {

		super(id, firstName, middleName, lastName, email, ssn, age);
		this.major = major;
	}

	/**
	 * default String major getter
	 * 
	 * @return String major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * default String major setter
	 * 
	 * @param String major
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * overridden toString method to include Student's major
	 * 
	 * @return formatted String representation of Student's full name, class, and
	 *         major
	 */
	public String toString() {
		return this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName() + " (Student)\nMajor: "
				+ this.major;
	}
}
