package asgn2Tests;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Pizza objects in
 * the asgn2Restaurant.LogHander class.
 * 
 * @author Ziyang Wang
 * 
 */

public class LogHandlerPizzaTests {
	ArrayList<Pizza> pizzas;
	Pizza pizza;

	@Before
	@Test
	public void setUp() throws PizzaException, LogHandlerException {
		pizzas = new ArrayList<Pizza>();
	}

	// Test LogHandler Functions
	// ************************************************************************************************

	@Test
	public void testPopulatePizzaDatasetFunction() throws PizzaException, LogHandlerException {
		pizzas = LogHandler.populatePizzaDataset("./logs/20170101.txt");
	}

	@Test
	public void testCreatPizzaFunction() throws PizzaException, LogHandlerException {
		pizzas.add(LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2"));
	}

	// Test LogHandlerExceptions
	// **************************************************************************************************
	@Test(expected = LogHandlerException.class)
	public void testPopulatePizzaDataSetException() throws PizzaException, LogHandlerException {
		pizzas = LogHandler.populatePizzaDataset("./error/file");
	}

	@Test(expected = LogHandlerException.class)
	public void testCreatePizzaException() throws PizzaException, LogHandlerException {
		pizzas.add(LogHandler.createPizza(null));
	}
}
