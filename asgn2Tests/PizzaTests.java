package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.PizzaTopping;
import asgn2Pizzas.VegetarianPizza;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza,
 * asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. Note that
 * an instance of asgn2Pizzas.MeatLoversPizza should be used to test the
 * functionality of the asgn2Pizzas.Pizza abstract class.
 * 
 * @author Ziyang Wang
 *
 */
public class PizzaTests {

	protected MargheritaPizza margherita;
	protected VegetarianPizza vegetarian;
	protected MeatLoversPizza meatLovers;

	@Before
	@Test
	public void setUp() throws PizzaException {
		margherita = new MargheritaPizza(1, LocalTime.parse("20:00:00"), LocalTime.parse("20:25:00"));
		vegetarian = new VegetarianPizza(2, LocalTime.parse("19:00:00"), LocalTime.parse("19:20:00"));
		meatLovers = new MeatLoversPizza(3, LocalTime.parse("21:00:00"), LocalTime.parse("21:35:00"));
	}

	// Test Pizza information can be read
	// ***************************************************************************************************

	// Test calculateCostPerPizza function
	// each calculation is not cumulative
	@Test
	public void calculateMargheritaPizzaTwice() {
		margherita.calculateCostPerPizza();
		margherita.calculateCostPerPizza();
		assertEquals(1.5, margherita.getCostPerPizza(), 0);

	}

	@Test
	public void calculateVegetarianPizzaThrice() {
		vegetarian.calculateCostPerPizza();
		vegetarian.calculateCostPerPizza();
		vegetarian.calculateCostPerPizza();
		assertEquals(5.5, vegetarian.getCostPerPizza(), 0);

	}

	@Test
	public void calculateMeatLoversPizzaQuartic() {
		meatLovers.calculateCostPerPizza();
		meatLovers.calculateCostPerPizza();
		meatLovers.calculateCostPerPizza();
		meatLovers.calculateCostPerPizza();
		assertEquals(5, meatLovers.getCostPerPizza(), 0);

	}

	// Test getCostPerPizza function
	@Test
	public void testGetMargheritaPizzaaCostPerpizza() throws PizzaException {
		assertEquals(1.5, margherita.getCostPerPizza(), 0);
	}

	@Test
	public void testGetVegetarianPizzaCostPerpizza() throws PizzaException {
		assertEquals(5.5, vegetarian.getCostPerPizza(), 0);
	}

	@Test
	public void testGetMeatLoversPizzaCostPerpizza() throws PizzaException {
		assertEquals(5.0, meatLovers.getCostPerPizza(), 0);
	}

	// Test getPricePerPizza function
	@Test
	public void testGetMargheritaPizzaaPricePerpizza() throws PizzaException {
		assertEquals(8.0, margherita.getPricePerPizza(), 0);
	}

	@Test
	public void testGetVegetarianPizzaPricePerpizza() throws PizzaException {
		assertEquals(10.0, vegetarian.getPricePerPizza(), 0);
	}

	@Test
	public void testGetMeatLoversPizzaPricePerpizza() throws PizzaException {
		assertEquals(12.0, meatLovers.getPricePerPizza(), 0);
	}

	// Test getOrderCost function
	@Test
	public void testGetMargheritaPizzaaOrderCost() throws PizzaException {
		assertEquals(1.5, margherita.getOrderCost(), 0);
	}

	@Test
	public void testGetVegetarianPizzaOrderCost() throws PizzaException {
		assertEquals(11.0, vegetarian.getOrderCost(), 0);
	}

	@Test
	public void testGetMeatLoversPizzaOrderCost() throws PizzaException {
		assertEquals(15.0, meatLovers.getOrderCost(), 0);
	}

	// Test getOrderPrice function
	@Test
	public void testGetMargheritaPizzaaOrderPrice() throws PizzaException {
		assertEquals(8.0, margherita.getOrderPrice(), 0);
	}

	@Test
	public void testGetVegetarianPizzaOrderPrice() throws PizzaException {
		assertEquals(20.0, vegetarian.getOrderPrice(), 0);
	}

	@Test
	public void testGetMeatLoversPizzaOrderPrice() throws PizzaException {
		assertEquals(36.0, meatLovers.getOrderPrice(), 0);
	}

	// Test getOrderProfit function
	@Test
	public void testGetMargheritaPizzaaOrderProfit() throws PizzaException {
		assertEquals(6.5, margherita.getOrderProfit(), 0);
	}

	@Test
	public void testGetVegetarianPizzaOrderProfit() throws PizzaException {
		assertEquals(9.0, vegetarian.getOrderProfit(), 0);
	}

	@Test
	public void testGetMeatLoversPizzaOrderProfit() throws PizzaException {
		assertEquals(21.0, meatLovers.getOrderProfit(), 0);
	}

	// Test containsTopping function
	@Test
	public void testMargheritaPizzacontainsTopping() throws PizzaException {
		assertTrue(margherita.containsTopping(PizzaTopping.CHEESE));
		assertTrue(margherita.containsTopping(PizzaTopping.TOMATO));
		assertFalse(margherita.containsTopping(PizzaTopping.BACON));
		assertFalse(margherita.containsTopping(PizzaTopping.SALAMI));
		assertFalse(margherita.containsTopping(PizzaTopping.PEPPERONI));
		assertFalse(margherita.containsTopping(PizzaTopping.CAPSICUM));
		assertFalse(margherita.containsTopping(PizzaTopping.MUSHROOM));
		assertFalse(margherita.containsTopping(PizzaTopping.EGGPLANT));
	}

	@Test
	public void testVegetarianPizzacontainsTopping() throws PizzaException {
		assertTrue(vegetarian.containsTopping(PizzaTopping.CHEESE));
		assertTrue(vegetarian.containsTopping(PizzaTopping.TOMATO));
		assertFalse(vegetarian.containsTopping(PizzaTopping.BACON));
		assertFalse(vegetarian.containsTopping(PizzaTopping.SALAMI));
		assertFalse(vegetarian.containsTopping(PizzaTopping.PEPPERONI));
		assertTrue(vegetarian.containsTopping(PizzaTopping.CAPSICUM));
		assertTrue(vegetarian.containsTopping(PizzaTopping.MUSHROOM));
		assertTrue(vegetarian.containsTopping(PizzaTopping.EGGPLANT));
	}

	@Test
	public void testMeatLoversPizzacontainsTopping() throws PizzaException {
		assertTrue(meatLovers.containsTopping(PizzaTopping.CHEESE));
		assertTrue(meatLovers.containsTopping(PizzaTopping.TOMATO));
		assertTrue(meatLovers.containsTopping(PizzaTopping.BACON));
		assertTrue(meatLovers.containsTopping(PizzaTopping.SALAMI));
		assertTrue(meatLovers.containsTopping(PizzaTopping.PEPPERONI));
		assertFalse(meatLovers.containsTopping(PizzaTopping.CAPSICUM));
		assertFalse(meatLovers.containsTopping(PizzaTopping.MUSHROOM));
		assertFalse(meatLovers.containsTopping(PizzaTopping.EGGPLANT));
	}

	// Test getQuantity function
	@Test
	public void testTheInformationOfMargheritaPizzaCanBeRead() throws PizzaException {
		assertEquals(1, margherita.getQuantity());
	}

	@Test
	public void testTheInformationOfVegetarianPizzaCanBeRead() throws PizzaException {
		assertEquals(2, vegetarian.getQuantity());
	}

	@Test
	public void testTheInformationOfMeatLoversPizzaCanBeRead() throws PizzaException {
		assertEquals(3, meatLovers.getQuantity());
	}

	// Test getPizzaType function
	@Test
	public void testGetMargheritaPizzaType() throws PizzaException {
		assertEquals("Margherita", margherita.getPizzaType());
	}

	@Test
	public void testGetVegetarianPizzaType() throws PizzaException {
		assertEquals("Vegetarian", vegetarian.getPizzaType());
	}

	@Test
	public void testGetMeatLoversPizzaType() throws PizzaException {
		assertEquals("Meat Lovers", meatLovers.getPizzaType());
	}

	// Test Pizza Exception
	@Test(expected = PizzaException.class)
	public void testTheQuantityOfPizzaIsLessThanOne() throws PizzaException {
		meatLovers = new MeatLoversPizza(0, LocalTime.parse("21:00:00"), LocalTime.parse("21:35:00"));
	}

	@Test(expected = PizzaException.class)
	public void testTheQuantityOfPizzaIsGreatThanTen() throws PizzaException {
		meatLovers = new MeatLoversPizza(11, LocalTime.parse("21:00:00"), LocalTime.parse("21:35:00"));
	}

	@Test(expected = PizzaException.class)
	public void testTheOrderTimeOfPizzaIsEarlierThan7pm() throws PizzaException {
		meatLovers = new MeatLoversPizza(3, LocalTime.parse("18:55:00"), LocalTime.parse("19:10:00"));
	}

	@Test(expected = PizzaException.class)
	public void testTheOrderTimeOfPizzaIsLaterThan11pm() throws PizzaException {
		meatLovers = new MeatLoversPizza(3, LocalTime.parse("23:01:00"), LocalTime.parse("23:20:00"));
	}

	@Test(expected = PizzaException.class)
	public void testTheOrderTimeIsLaterThanTheDeliveryTimeCase1() throws PizzaException {
		meatLovers = new MeatLoversPizza(3, LocalTime.parse("21:00:00"), LocalTime.parse("20:35:00"));
	}

	@Test(expected = PizzaException.class)
	public void testTheOrderTimeIsLaterThanTheDeliveryTimeCase2() throws PizzaException {
		meatLovers = new MeatLoversPizza(3, LocalTime.parse("21:35:00"), LocalTime.parse("21:00:00"));
	}

	@Test(expected = PizzaException.class)
	public void testNotEnoughTimeForCookPizzaCase1() throws PizzaException {
		meatLovers = new MeatLoversPizza(3, LocalTime.parse("21:00:00"), LocalTime.parse("21:09:00"));
	}

	@Test(expected = PizzaException.class)
	public void testNotEnoughTimeForCookPizzaCase2() throws PizzaException {
		meatLovers = new MeatLoversPizza(3, LocalTime.parse("20:55:00"), LocalTime.parse("21:00:00"));
	}

	@Test(expected = PizzaException.class)
	public void testPizzaIsThrownOutCase1() throws PizzaException {
		meatLovers = new MeatLoversPizza(3, LocalTime.parse("21:20:00"), LocalTime.parse("22:20:00"));
	}

	@Test(expected = PizzaException.class)
	public void testPizzaIsThrownOutCase2() throws PizzaException {
		meatLovers = new MeatLoversPizza(3, LocalTime.parse("20:00:00"), LocalTime.parse("22:00:00"));
	}

}