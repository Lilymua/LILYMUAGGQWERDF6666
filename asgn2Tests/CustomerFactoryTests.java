package asgn2Tests;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Joshua Wong
 *
 */
public class CustomerFactoryTests {

	Customer testCustomer;

	// Test customerFactory function
	// ***************************************************************************************************
	@Test
	public void testPickUpCustomer() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("PUC", "Test Customer", "0123456789", 0, 0);
	}

	@Test
	public void testDriverDeliveryCustomer() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("DVC", "Test Customer", "0123456789", 5, 5);
	}

	@Test
	public void testDroneDeliveryCustomer() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("DNC", "Test Customer", "0123456789", 3, 4);
	}

	// Test Customer Exception in customerFactory
	// ***************************************************************************************************

	// Invalid Customer Code
	@Test(expected = CustomerException.class)
	public void testInvalidCustomerCode() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("ABC", "Test Customer", "0123456789", 0, 0);
	}

	// Invalid Customer name
	@Test(expected = CustomerException.class)
	public void testInvalidNameWhichIsLessThanOne() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("PUC", "", "0123456789", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testInvalidNameWhichIsBiggerThanTwentyLength() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("PUC", "ABCDEFGHIJKLMN OPQRSTUVWXYZ", "0123456789", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testInvalidNameWhichIsOnlyWhiteSpace() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("PUC", " ", "0123456789", 0, 0);
	}

	// Invalid Customer mobile number
	@Test(expected = CustomerException.class)
	public void testInvalidMobileNumberWhichIsNotEqualToTen() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("PUC", "Test Customer", "012345678", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testInvalidMobileNumberWhichIsIsNotBeginWithZero() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("PUC", "Test Customer", "1234567890", 0, 0);
	}

	// Invalid Pickup Customer Location
	@Test(expected = CustomerException.class)
	public void testInvalidPickUpCustomerLocationXIsNotEqualZero() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("PUC", "Test Customer", "0123456789", 1, 0);
	}

	@Test(expected = CustomerException.class)
	public void testInvalidPickUpCustomerLocationYIsNotEqualZero() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("PUC", "Test Customer", "0123456789", 0, 1);
	}

	@Test(expected = CustomerException.class)
	public void testInvalidPickUpCustomerLocationXAndLocationYIsNotEqualZero() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("PUC", "Test Customer", "0123456789", 1, 1);
	}

	// Invalid DriveDelivry and DroneDelivery Customer Location
	@Test(expected = CustomerException.class)
	public void testInvalidDriveDeliveryCustomerLocationXAndLocationYIsEqualZero() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("DVC", "Test Customer", "0123456789", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testInvalidDriveDeliveryCustomerLocationXIsGreatThanTen() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("DVC", "Test Customer", "0123456789", 11, 5);
	}

	@Test(expected = CustomerException.class)
	public void testInvalidDriveDeliveryCustomerLocationXIsLessThanNegativeTen() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("DVC", "Test Customer", "0123456789", -11, 5);
	}

	@Test(expected = CustomerException.class)
	public void testInvalidDriveDeliveryCustomerLocationYIsGreatThanTen() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("DVC", "Test Customer", "0123456789", 5, 11);
	}

	@Test(expected = CustomerException.class)
	public void testInvalidDriveDeliveryCustomerLocationYIsLessThanNegativeTen() throws CustomerException {
		testCustomer = CustomerFactory.getCustomer("DVC", "Test Customer", "0123456789", 5, -11);
	}

}