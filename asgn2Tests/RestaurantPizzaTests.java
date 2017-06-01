package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in
 * the asgn2Restaurant.PizzaRestaurant class as well as processLog and
 * resetDetails.
 * 
 * @author Ziyang Wang
 *
 */
public class RestaurantPizzaTests {
	private PizzaRestaurant restaurant;

	// Test PizzaRestaurant Pizza Part
	// ************************************************************************************************
	@Before
	@Test
	public void setUp() throws CustomerException, PizzaException, LogHandlerException {
		restaurant = new PizzaRestaurant();
	}

	// Test processLog Function
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

	// Test getPizzaByIndex Function
	@Test
	public void testGetPizzaByIndexCase1() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170101.txt");
		assertEquals("Vegetarian", restaurant.getPizzaByIndex(0).getPizzaType());
		assertEquals(2, restaurant.getPizzaByIndex(0).getQuantity());
		assertEquals(20.0, restaurant.getPizzaByIndex(0).getOrderPrice(), 0);
		assertEquals(11.0, restaurant.getPizzaByIndex(0).getOrderCost(), 0);
		assertEquals(9.0, restaurant.getPizzaByIndex(0).getOrderProfit(), 0);
	}

	@Test
	public void testGetPizzaByIndexCase2() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170102.txt");
		assertEquals("Vegetarian", restaurant.getPizzaByIndex(0).getPizzaType());
		assertEquals(5, restaurant.getPizzaByIndex(0).getQuantity());
		assertEquals(50.0, restaurant.getPizzaByIndex(0).getOrderPrice(), 0);
		assertEquals(27.5, restaurant.getPizzaByIndex(0).getOrderCost(), 0);
		assertEquals(22.5, restaurant.getPizzaByIndex(0).getOrderProfit(), 0);
	}

	@Test
	public void testGetPizzaByIndexCase3() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170103.txt");
		assertEquals("Vegetarian", restaurant.getPizzaByIndex(0).getPizzaType());
		assertEquals(2, restaurant.getPizzaByIndex(0).getQuantity());
		assertEquals(20.0, restaurant.getPizzaByIndex(0).getOrderPrice(), 0);
		assertEquals(11.0, restaurant.getPizzaByIndex(0).getOrderCost(), 0);
		assertEquals(9.0, restaurant.getPizzaByIndex(0).getOrderProfit(), 0);
	}

	// Test getNumPizzaOrders Function
	@Test
	public void testGetNumPizzaOrdersCase1() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170101.txt");
		assertEquals(3, restaurant.getNumPizzaOrders());
	}

	@Test
	public void testGetNumPizzaOrdersCase2() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170102.txt");
		assertEquals(10, restaurant.getNumPizzaOrders());
	}

	@Test
	public void testGetNumPizzaOrdersCase3() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170103.txt");
		assertEquals(100, restaurant.getNumPizzaOrders());
	}

	// Test getTotalProfit Function
	@Test
	public void testGetTotalProfitCase1() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170101.txt");
		assertEquals(36.5, restaurant.getTotalProfit(), 0);
	}

	@Test
	public void testGetTotalProfitCase2() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170102.txt");
		assertEquals(316.5, restaurant.getTotalProfit(), 0);
	}

	@Test
	public void testGetTotalProfitCase3() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170103.txt");
		assertEquals(2849, restaurant.getTotalProfit(), 0);
	}

	// Test resetDetails Function
	@Test
	public void testResetDetails() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog("./logs/20170103.txt");
		restaurant.resetDetails();
		assertEquals(0, restaurant.getNumPizzaOrders());
		assertEquals(0, restaurant.getTotalProfit(), 0);
	}

	// Test Exceptions
	// ******************************************************************************************************
	@Test(expected = LogHandlerException.class)
	public void testErrorFileException() throws LogHandlerException, CustomerException, PizzaException {
		restaurant.processLog("./error/file");
	}

	@Test(expected = PizzaException.class)
	public void testGetInvalidPizzaIndex() throws LogHandlerException, CustomerException, PizzaException {
		restaurant.processLog("./logs/20170101.txt");
		restaurant.getPizzaByIndex(3);
	}
}
