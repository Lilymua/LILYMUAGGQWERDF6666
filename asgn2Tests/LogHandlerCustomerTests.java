package asgn2Tests;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects
 * in the asgn2Restaurant.LogHander class.
 *
 * @author Joshua Wong
 * 
 */

public class LogHandlerCustomerTests {
	ArrayList<Customer> customers;
	Customer customer;

	@Before
	@Test
	public void setUp() throws CustomerException, LogHandlerException {
		customers = new ArrayList<Customer>();
	}

	// Test LogHandler Functions
	// ************************************************************************************************

	@Test
	public void testPopulateCustomerDatasetFunction() throws CustomerException, LogHandlerException {
		customers = LogHandler.populateCustomerDataset("./logs/20170101.txt");
	}

	@Test
	public void testCreatCustomerFunction() throws CustomerException, LogHandlerException {
		customers.add(LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2"));
	}

	// Test LogHandlerExceptions
	// **************************************************************************************************
	@Test(expected = LogHandlerException.class)
	public void testPopulateCustomerDataSetException() throws CustomerException, LogHandlerException {
		customers = LogHandler.populateCustomerDataset("./error/file");
	}

	@Test(expected = LogHandlerException.class)
	public void testCreateCustomerException() throws CustomerException, LogHandlerException {
		customers.add(LogHandler.createCustomer(null));
	}
}
