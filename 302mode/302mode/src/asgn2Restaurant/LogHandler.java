package asgn2Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to
 * return Pizza and Customer object - either as an individual Pizza/Customer
 * object or as an ArrayList of Pizza/Customer objects.
 * 
 * @author Joshua Wong and Ziyang Wang
 *
 */
public class LogHandler {

	/**
	 * Returns an ArrayList of Customer objects from the information contained
	 * in the log file ordered as they appear in the log file.
	 * 
	 * @param filename
	 *            The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained
	 *         in the log file ordered as they appear in the log file.
	 * @throws CustomerException
	 *             If the log file contains semantic errors leading that violate
	 *             the customer constraints listed in Section 5.3 of the
	 *             Assignment Specification or contain an invalid customer code
	 *             (passed by another class).
	 * @throws LogHandlerException
	 *             If there was a problem with the log file not related to the
	 *             semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename)
			throws CustomerException, LogHandlerException {
		String csvFile = filename;
		BufferedReader br = null;
		String line = "";
		ArrayList<Customer> customers = new ArrayList<Customer>();

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				customers.add(createCustomer(line));
			}
		} catch (IOException | LogHandlerException e) {
			throw new LogHandlerException("Error happend when populate PizzaDataset");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return customers;
	}

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in
	 * the log file ordered as they appear in the log file. .
	 * 
	 * @param filename
	 *            The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in
	 *         the log file ordered as they appear in the log file. .
	 * @throws PizzaException
	 *             If the log file contains semantic errors leading that violate
	 *             the pizza constraints listed in Section 5.3 of the Assignment
	 *             Specification or contain an invalid pizza code (passed by
	 *             another class).
	 * @throws LogHandlerException
	 *             If there was a problem with the log file not related to the
	 *             semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException {
		String csvFile = filename;
		BufferedReader br = null;
		String line = "";
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

		try {

			br = new BufferedReader(new FileReader(csvFile));

			while ((line = br.readLine()) != null) {
				pizzas.add(createPizza(line));
			}
		} catch (IOException | LogHandlerException e) {
			throw new LogHandlerException("Error happend when populate PizzaDataset");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return pizzas;
	}

	/**
	 * Creates a Customer object by parsing the information contained in a
	 * single line of the log file. The format of each line is outlined in
	 * Section 5.3 of the Assignment Specification.
	 * 
	 * @param line
	 *            - A line from the log file
	 * @return- A Customer object containing the information from the line in
	 *          the log file
	 * @throws CustomerException
	 *             - If the log file contains semantic errors leading that
	 *             violate the customer constraints listed in Section 5.3 of the
	 *             Assignment Specification or contain an invalid customer code
	 *             (passed by another class).
	 * @throws LogHandlerException
	 *             - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException {
		String csvSplit = ",";
		String[] doc;

		try {
			doc = line.split(csvSplit);
		} catch (Exception e) {
			throw new LogHandlerException("Error happend when creat Customer");
		}

		String customerCode = doc[4];
		String name = doc[2];
		String mobileNumber = doc[3];
		int locationX = Integer.parseInt(doc[5]);
		int locationY = Integer.parseInt(doc[6]);

		return CustomerFactory.getCustomer(customerCode, name, mobileNumber, locationX, locationY);
	}

	/**
	 * Creates a Pizza object by parsing the information contained in a single
	 * line of the log file. The format of each line is outlined in Section 5.3
	 * of the Assignment Specification.
	 * 
	 * @param line
	 *            - A line from the log file
	 * @return- A Pizza object containing the information from the line in the
	 *          log file
	 * @throws PizzaException
	 *             If the log file contains semantic errors leading that violate
	 *             the pizza constraints listed in Section 5.3 of the Assignment
	 *             Specification or contain an invalid pizza code (passed by
	 *             another class).
	 * @throws LogHandlerException
	 *             - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException {
		String csvSplit = ",";
		String[] doc;

		try {
			doc = line.split(csvSplit);
		} catch (Exception e) {
			throw new LogHandlerException("Error happend when creat Pizza");
		}

		String pizzaCode = doc[7];
		int quantity = Integer.parseInt(doc[8]);
		DateTimeFormatter fml = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime orderTime = LocalTime.parse(doc[0], fml);
		LocalTime deliveryTime = LocalTime.parse(doc[1], fml);

		return PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
	}
}
