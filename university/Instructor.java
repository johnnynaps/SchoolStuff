package com.janpolin.oopda.university;

/**
 * Instructor class. Child of Person class.
 * 
 * @author napoli54
 */
public class Instructor extends Person {
	String department = "";

	/**
	 * Instructor constructor. Uses Person superclass and adds department
	 * 
	 * @param id
	 * @param firstName
	 * @param middleName
	 * @param lastNAme
	 * @param email
	 * @param ssn
	 * @param age
	 * @param department
	 */
	public Instructor(int id, String firstName, String middleName, String lastNAme, String email, String ssn, int age,
			String department) {

		super(id, firstName, middleName, lastNAme, email, ssn, age);
		this.department = department;
	}

	/**
	 * default String department getter
	 * 
	 * @return String department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * default String department setter
	 * 
	 * @param String department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * overridden toString method to include Instructor's department
	 * 
	 * @return formatted String representation of Instructor's full name, class, and
	 *         department
	 */
	public String toString() {
		return this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName()
				+ " (Instructor)\nDepartment: " + this.department;
	}
}
