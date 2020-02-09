package com.janpolin.oopda.university;

import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonApp {

	private static final Logger appLogger = Logger.getLogger(Person.class.getName());

	/**
	 * main method of PersonApp. prompt user for input, validate it, create a Person
	 * with that input. Create a hard-coded Student and Instructor. Add them all to
	 * a HashMap then display their information.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		HashMap<Integer, Person> pMap = new HashMap<>();
		appLogger.setLevel(Level.INFO);

		int id = 0;
		String firstName = "";
		String middleName = "";
		String lastName = "";
		String email = "";
		String ssn = "";
		String ageInput = "";
		int age = 0;
		int i = 0;

		/**
		 * take user input and validate it
		 */
		System.out.println("Enter your information\nFirst Name:");
		firstName = scanner.nextLine();
		while (!Person.validName(firstName)) {
			appLogger.log(Level.INFO, "INVALID FIRST NAME");
			System.out.println("First Name:");
			firstName = scanner.nextLine();
		}
		System.out.println("Middle Name:");
		middleName = scanner.nextLine();
		while (!Person.validName(middleName)) {
			appLogger.log(Level.INFO, "INVALID MIDDLE NAME");
			System.out.println("Middle Name:");
			middleName = scanner.nextLine();
		}
		System.out.println("Last Name:");
		lastName = scanner.nextLine();
		while (!Person.validName(lastName)) {
			appLogger.log(Level.INFO, "INVALID LAST NAME");
			System.out.println("Last Name:");
			lastName = scanner.nextLine();
		}
		System.out.println("E-Mail Address:");
		email = scanner.nextLine();
		while (!Person.validEmail(email)) {
			appLogger.log(Level.INFO, "INVALID E-MAIL");
			System.out.println("E-Mail Address:");
			email = scanner.nextLine();
		}
		System.out.println("Social Security Number in ###-##-#### format:");
		ssn = scanner.nextLine();
		while (!Person.validSSN(ssn)) {
			appLogger.log(Level.INFO, "INVALID SSN");
			System.out.println("Social Security Number in ###-##-#### format:");
			ssn = scanner.nextLine();
		}
		System.out.println("Age:");
		ageInput = scanner.nextLine();
		while (!Person.vaildAge(ageInput)) {
			appLogger.log(Level.INFO, "INVALID AGE");
			System.out.println("Age:");
			ageInput = scanner.nextLine();
		}
		age = Integer.parseInt(ageInput.trim());

		Person person = new Person(id, firstName, middleName, lastName, email, ssn, age);

		id++;
		firstName = "Rich";
		middleName = "E.";
		lastName = "Rich";
		email = "RichE@faculty.school.edu";
		ssn = "444-22-0000";
		age = 50;

		Instructor instructor = new Instructor(id, firstName, middleName, lastName, email, ssn, age, "English");

		id++;
		firstName = "Brad";
		middleName = "T.";
		lastName = "Bard";
		email = "bard@students.school.edu";
		ssn = "123-645-6789";
		age = 19;

		Student student = new Student(id, firstName, middleName, lastName, email, ssn, age, "Computer Science");

		/**
		 * and person, student, and instructor to HashMap pMap
		 */
		person.addHashMap(pMap);
		instructor.addHashMap(pMap);
		student.addHashMap(pMap);

		/**
		 * loop through HashMap pMap displaying information. check to see which Person
		 * is the oldest and display if they are or are not.
		 */
		while (pMap.containsKey(i)) {
			Person curr = pMap.get(i);
			System.out.println("Name: " + curr.toString());
			System.out.println("Domain: " + curr.getEmailDomain());
			System.out.println("Last Four SSN: " + curr.getLast4SSN());
			System.out.println("Age: " + curr.getAge());

			if (curr.getAge() == Person.getMaxAge()) {
				System.out.println("This person is the oldest.\n");
			} else {
				System.out.println("This person is not the oldest.\n");
			}
			i++;
			appLogger.log(Level.INFO, "INCREMENTING INDEX");
		}

		scanner.close();
	}

}
