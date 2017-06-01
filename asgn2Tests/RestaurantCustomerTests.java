package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer
 * objects in the asgn2Restaurant.PizzaRestaurant class as well as processLog
 * and resetDetails.
 * 
 * @author Joshua Wong
 */
public class RestaurantCustomerTests {
	private PizzaRestaurant restaurant;

	// Test PizzaRestaurant Customer Part
	@Before
	@Test
	public void setUp() throws CustomerException, PizzaException, LogHandlerException {
		restaurant = new PizzaRestaurant();
	}

	// Test ProcessLog Function
	@Test
	public void testProcessLogCase1() throws CustomerException, PizzaException, LogHandlerException {
		assertTrue(restaurant.processLog("./logs/20170101.txt"));
	}

	@Test
	public void testProcessLogCase2() throws CustomerException, PizzaException, LogHandlerException {
		assertTrue(restaurant.processLog("./logs/20170102.txt"));
	}

	@Test
	public void testProcessLogCase3() throws CustomerException, PizzaException, LogHandlerException {
		assertTrue(restaurant.processLog("./logs/20170103.txt"));
	}

	// Test getNumCustomerIndex Function
	@Test
	public void testGetCustomerByIndexCase1() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170101.txt");
		assertEquals("Casey Jones", restaurant.getCustomerByIndex(0).getName());
		assertEquals("0123456789", restaurant.getCustomerByIndex(0).getMobileNumber());
		assertEquals("Driver Delivery", restaurant.getCustomerByIndex(0).getCustomerType());
		assertEquals(5, restaurant.getCustomerByIndex(0).getLocationX());
		assertEquals(5, restaurant.getCustomerByIndex(0).getLocationY());
	}

	@Test
	public void testGetCustomerByIndexCase2() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170102.txt");
		assertEquals("Emma Brown", restaurant.getCustomerByIndex(0).getName());
		assertEquals("0602547760", restaurant.getCustomerByIndex(0).getMobileNumber());
		assertEquals("Driver Delivery", restaurant.getCustomerByIndex(0).getCustomerType());
		assertEquals(-1, restaurant.getCustomerByIndex(0).getLocationX());
		assertEquals(0, restaurant.getCustomerByIndex(0).getLocationY());
	}

	@Test
	public void testGetCustomerByIndexCase3() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170103.txt");
		assertEquals("Aiden Zhang", restaurant.getCustomerByIndex(0).getName());
		assertEquals("0161429209", restaurant.getCustomerByIndex(0).getMobileNumber());
		assertEquals("Driver Delivery", restaurant.getCustomerByIndex(0).getCustomerType());
		assertEquals(-3, restaurant.getCustomerByIndex(0).getLocationX());
		assertEquals(9, restaurant.getCustomerByIndex(0).getLocationY());
	}

	// Test getNumCustomerOrders Function
	@Test
	public void testGetNumCustomerOrdersCase1() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170101.txt");
		assertEquals(3, restaurant.getNumCustomerOrders());
	}

	@Test
	public void testGetNumCustomerOrdersCase2() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170102.txt");
		assertEquals(10, restaurant.getNumCustomerOrders());
	}

	@Test
	public void testGetNumCustomerOrdersCase3() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170103.txt");
		assertEquals(100, restaurant.getNumCustomerOrders());
	}

	// Test getTotalDeliveryDistance Function
	@Test
	public void testGetTotalDeliveryDistanceCase1() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170101.txt");
		assertEquals(15.00, restaurant.getTotalDeliveryDistance(), 0);
	}

	@Test
	public void testGetTotalDeliveryDistanceCase2() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170102.txt");
		assertEquals(41.0, restaurant.getTotalDeliveryDistance(), 0);
	}

	@Test
	public void testGetTotalDeliveryDistanceCase3() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170103.txt");
		assertEquals(519.0, restaurant.getTotalDeliveryDistance(), 0);
	}

	// Test resetDetails Function
	@Test
	public void testResetDetails() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170103.txt");
		restaurant.resetDetails();
		assertEquals(0, restaurant.getNumCustomerOrders());
		assertEquals(0, restaurant.getTotalDeliveryDistance(), 0);
	}

	// Test Exceptions
	// ******************************************************************************************************
	@Test(expected = LogHandlerException.class)
	public void testErrorFileException() throws LogHandlerException, CustomerException, PizzaException {
		restaurant.processLog("./error/file");
	}

	@Test(expected = CustomerException.class)
	public void testGetInvalidCustomerIndex() throws LogHandlerException, CustomerException, PizzaException {
		restaurant.processLog("./logs/20170101.txt");
		restaurant.getCustomerByIndex(3);
	}
}