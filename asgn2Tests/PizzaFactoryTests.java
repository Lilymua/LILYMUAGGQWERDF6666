package asgn2Tests;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Ziyang Wang
 * 
 */
public class PizzaFactoryTests {
	Pizza testPizza;

	// Test PizzaFactory function
	// ***************************************************************************************************
	@Test
	public void testMargheritaPizza() throws PizzaException {
		testPizza = PizzaFactory.getPizza("PZM", 1, LocalTime.parse("20:00:00"), LocalTime.parse("20:25:00"));
	}

	@Test
	public void testVegetarianPizza() throws PizzaException {
		testPizza = PizzaFactory.getPizza("PZV", 2, LocalTime.parse("19:00:00"), LocalTime.parse("19:20:00"));
	}

	@Test
	public void testMeatLoversPizza() throws PizzaException {
		testPizza = PizzaFactory.getPizza("PZL", 3, LocalTime.parse("21:00:00"), LocalTime.parse("21:35:00"));
	}

	// Test Pizza Exception in pizzaFactory
	// ***************************************************************************************************

	// Invalid pizzaQuantity
	@Test(expected = PizzaException.class)
	public void testInvalidPizzaCode() throws PizzaException {
		testPizza = PizzaFactory.getPizza("ABC", 1, LocalTime.parse("20:00:00"), LocalTime.parse("20:25:00"));
	}

	@Test(expected = PizzaException.class)
	public void testInvalidPizzaQuantityWhichIsLessThanOne() throws PizzaException {
		testPizza = PizzaFactory.getPizza("PZM", 0, LocalTime.parse("20:00:00"), LocalTime.parse("20:25:00"));
	}

	@Test(expected = PizzaException.class)
	public void testInvalidPizzaQuantityWhichIsMoreThanEleven() throws PizzaException {
		testPizza = PizzaFactory.getPizza("PZM", 11, LocalTime.parse("20:00:00"), LocalTime.parse("20:25:00"));
	}

	// Invalid orderTime
	@Test(expected = PizzaException.class)
	public void testInvalidOrderTimeWhichIsEalierThan7PM() throws PizzaException {
		testPizza = PizzaFactory.getPizza("PZM", 1, LocalTime.parse("18:59:00"), LocalTime.parse("19:20:00"));
	}

	@Test(expected = PizzaException.class)
	public void testInvalidOrderTimeWhichIsLaterThan11PM() throws PizzaException {
		testPizza = PizzaFactory.getPizza("PZM", 1, LocalTime.parse("23:01:00"), LocalTime.parse("23:20:00"));
	}

	@Test(expected = PizzaException.class)
	public void testInvalidOrderTimeDeliveryTimeEalierThanOrderTimeCase1() throws PizzaException {
		testPizza = PizzaFactory.getPizza("PZM", 1, LocalTime.parse("21:00:00"), LocalTime.parse("20:35:00"));
	}

	@Test(expected = PizzaException.class)
	public void testInvalidOrderTimeDeliveryTimeEalierThanOrderTimeCase2() throws PizzaException {
		testPizza = PizzaFactory.getPizza("PZM", 1, LocalTime.parse("21:35:00"), LocalTime.parse("21:00:00"));
	}

	// Invalid pizza time
	@Test(expected = PizzaException.class)
	public void testInvalidPizzaTimeWhichIsLessThan10minutesCase1() throws PizzaException {
		testPizza = PizzaFactory.getPizza("PZM", 1, LocalTime.parse("21:00:00"), LocalTime.parse("21:09:00"));
	}

	@Test(expected = PizzaException.class)
	public void testInvalidPizzaTimeWhichIsLessThan10minutesCase2() throws PizzaException {
		testPizza = PizzaFactory.getPizza("PZM", 1, LocalTime.parse("20:55:00"), LocalTime.parse("21:00:00"));
	}

	@Test(expected = PizzaException.class)
	public void testInvalidPizzaTimeWhichIsMoreThan1HourCase1() throws PizzaException {
		testPizza = PizzaFactory.getPizza("PZM", 1, LocalTime.parse("21:20:00"), LocalTime.parse("22:20:00"));
	}

	@Test(expected = PizzaException.class)
	public void testInvalidPizzaTimeWhichIsMoreThan1HourCase2() throws PizzaException {
		testPizza = PizzaFactory.getPizza("PZM", 1, LocalTime.parse("20:00:00"), LocalTime.parse("22:00:00"));
	}

}
