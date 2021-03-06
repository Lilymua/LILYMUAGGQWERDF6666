package asgn2Pizzas;

import java.time.LocalTime;
import java.util.ArrayList;

import asgn2Exceptions.PizzaException;

/**
 * An abstract class that represents pizzas sold at the Pizza Palace restaurant.
 * The Pizza class is used as a base class of VegetarianPizza, MargheritaPizza
 * and MeatLoversPizza. Each of these subclasses have a different set of
 * toppings. A description of the class's fields and their constraints is
 * provided in Section 5.1 of the Assignment Specification.
 * 
 * @author Joshua Wong
 *
 */
public abstract class Pizza {

	protected int quantity;
	protected LocalTime orderTime;
	protected LocalTime deliveryTime;
	protected String type;
	protected double price;
	protected double perCost;
	protected ArrayList<PizzaTopping> toppings;
	protected boolean withTopping;

	private static final LocalTime OPEN_TIME = LocalTime.parse("19:00:00");
	private static final LocalTime CLOSE_TIME = LocalTime.parse("23:00:00");

	/**
	 * This class represents a pizza produced at the Pizza Palace restaurant. A
	 * detailed description of the class's fields and parameters is provided in
	 * the Assignment Specification, in particular in Section 5.1. A
	 * PizzaException is thrown if the any of the constraints listed in Section
	 * 5.1 of the Assignment Specification are violated.
	 *
	 * PRE: TRUE POST: All field values except cost per pizza are set
	 * 
	 * @param quantity
	 *            - The number of pizzas ordered
	 * @param orderTime
	 *            - The time that the pizza order was made and sent to the
	 *            kitchen
	 * @param deliveryTime
	 *            - The time that the pizza was delivered to the customer
	 * @param type
	 *            - A human understandable description of this Pizza type
	 * @param price
	 *            - The price that the pizza is sold to the customer
	 * @throws PizzaException
	 *             if supplied parameters are invalid
	 * 
	 */
	public Pizza(int quantity, LocalTime orderTime, LocalTime deliveryTime, String type, double price)
			throws PizzaException {
		if (quantity < 1) {
			throw new PizzaException("At least one pizza must be ordered for the order to be valid");
		} else if (quantity > 10) {
			throw new PizzaException("The maximum number of pizzas in any one order is 10");
		} else if (orderTime.isBefore(OPEN_TIME) || orderTime.isAfter(CLOSE_TIME)) {
			throw new PizzaException(
					"The restaurant begins taking orders at 7:00pm and stops taking orders at 11:00 pm");
		} else if ((deliveryTime.getHour() < orderTime.getHour()) || ((deliveryTime.getHour() == orderTime.getHour())
				&& (deliveryTime.getMinute() < orderTime.getMinute()))) {
			throw new PizzaException("the orderTime is later than deliveryTime");
		} else if (((deliveryTime.getHour() == orderTime.getHour())
				&& (deliveryTime.getMinute() - orderTime.getMinute() < 10))
				|| ((deliveryTime.getHour() - orderTime.getHour() == 1)
						&& (deliveryTime.getMinute() + 60 - orderTime.getMinute() < 10))) {
			throw new PizzaException("A pizza takes at least 10 minutes to cook");
		} else if ((deliveryTime.getHour() - orderTime.getHour() == 1)
				&& (deliveryTime.getMinute() >= orderTime.getMinute())
				|| (deliveryTime.getHour() - orderTime.getHour() > 1)) {
			throw new PizzaException("The is thrown out after 1 hour");
		} else {
			this.quantity = quantity;
			this.orderTime = orderTime;
			this.deliveryTime = deliveryTime;
			this.type = type;
			this.price = price;
		}
	}

	/**
	 * Calculates how much a pizza would could to make calculated from its
	 * toppings.
	 * 
	 * <P>
	 * PRE: TRUE
	 * <P>
	 * POST: The cost field is set to sum of the Pizzas's toppings
	 */
	public final void calculateCostPerPizza() {
		this.perCost = 0;
		for (int i = 0; i < toppings.size(); i++)
			this.perCost += toppings.get(i).getCost();
	}

	/**
	 * Returns the amount that an individual pizza costs to make.
	 * 
	 * @return The amount that an individual pizza costs to make.
	 */
	public final double getCostPerPizza() {
		return perCost;
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * 
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza() {
		return price;
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into
	 * account the type and quantity of pizzas.
	 * 
	 * @return The amount that the entire order costs to make, taking into
	 *         account the type and quantity of pizzas.
	 */
	public final double getOrderCost() {
		return perCost * quantity;
	}

	/**
	 * Returns the amount that the entire order is sold to the customer, taking
	 * into account the type and quantity of pizzas.
	 * 
	 * @return The amount that the entire order is sold to the customer, taking
	 *         into account the type and quantity of pizzas.
	 */
	public final double getOrderPrice() {
		return price * quantity;
	}

	/**
	 * Returns the profit made by the restaurant on the order which is the order
	 * price minus the order cost.
	 * 
	 * @return Returns the profit made by the restaurant on the order which is
	 *         the order price minus the order cost.
	 */
	public final double getOrderProfit() {
		return getOrderPrice() - getOrderCost();
	}

	/**
	 * Indicates if the pizza contains the specified pizza topping or not.
	 * 
	 * @param topping
	 *            - A topping as specified in the enumeration PizzaTopping
	 * @return Returns true if the instance of Pizza contains the specified
	 *         topping and false otherwise.
	 */
	public final boolean containsTopping(PizzaTopping topping) {
		if (toppings.contains(topping) == true) {
			withTopping = true;
		} else {
			withTopping = false;
		}
		return withTopping;
	}

	/**
	 * Returns the quantity of pizzas ordered.
	 * 
	 * @return the quantity of pizzas ordered.
	 */
	public final int getQuantity() {
		return quantity;
	}

	/**
	 * Returns a human understandable description of the Pizza's type. The valid
	 * alternatives are listed in Section 5.1 of the Assignment Specification.
	 * 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType() {
		return type;
	}

	/**
	 * Compares *this* Pizza object with an instance of an *other* Pizza object
	 * and returns true if if the two objects are equivalent, that is, if the
	 * values exposed by public methods are equal. You do not need to test this
	 * method.
	 * 
	 * @return true if *this* Pizza object and the *other* Pizza object have the
	 *         same values returned for getCostPerPizza(), getOrderCost(),
	 *         getOrderPrice(), getOrderProfit(), getPizzaType(),
	 *         getPricePerPizza() and getQuantity().
	 * 
	 */
	@Override
	public boolean equals(Object other) {
		Pizza otherPizza = (Pizza) other;
		return ((this.getCostPerPizza()) == (otherPizza.getCostPerPizza())
				&& (this.getOrderCost()) == (otherPizza.getOrderCost()))
				&& (this.getOrderPrice()) == (otherPizza.getOrderPrice())
				&& (this.getOrderProfit()) == (otherPizza.getOrderProfit())
				&& (this.getPizzaType() == (otherPizza.getPizzaType())
						&& (this.getPricePerPizza()) == (otherPizza.getPricePerPizza())
						&& (this.getQuantity()) == (otherPizza.getQuantity()));
	}

}
