package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer,
 * asgn2Customers.DriverDeliveryCustomer, asgn2Customers.DroneDeliveryCustomer
 * classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer
 * should be used to test the functionality of the asgn2Customers.Customer
 * abstract class.
 * 
 * @author Joshua Wong
 * 
 *
 */
public class CustomerTests {

	protected PickUpCustomer jerry;
	protected DriverDeliveryCustomer leo;
	protected DroneDeliveryCustomer nessaj;

	@Before
	@Test
	public void setUp() throws CustomerException {
		jerry = new PickUpCustomer("Jerry Wang", "0123456789", 0, 0);
		leo = new DriverDeliveryCustomer("Leo Song", "0987654321", 5, 5);
		nessaj = new DroneDeliveryCustomer("Nessaj Chen", "0111222333", 3, 4);
	}

	// test customer information can be read
	// ***************************************************************************************************

	// Test getName function
	@Test
	public void testGetPickUpCustomerName() {
		assertEquals("Jerry Wang", jerry.getName());
	}

	@Test
	public void testGetDriverDeliveryCustomerName() {
		assertEquals("Leo Song", leo.getName());
	}

	@Test
	public void testGetDroneDeliveryCustomerName() {
		assertEquals("Nessaj Chen", nessaj.getName());
	}

	// Test getMobileNumber function
	@Test
	public void testGetPickUpCustomerMobileNumber() {
		assertEquals("0123456789", jerry.getMobileNumber());
	}

	@Test
	public void testGetDriverDeliveryCustomerMobileNumber() {
		assertEquals("0987654321", leo.getMobileNumber());
	}

	@Test
	public void testGetDroneDeliveryCustomerMobileNumber() {
		assertEquals("0111222333", nessaj.getMobileNumber());
	}

	// Test getCustomerType function
	@Test
	public void testGetPickUpCustomerType() {
		assertEquals("Pick Up", jerry.getCustomerType());
	}

	@Test
	public void testGetDriverDeliveryCustomerType() {
		assertEquals("Driver Delivery", leo.getCustomerType());
	}

	@Test
	public void testGetDroneDeliveryCustomerType() {
		assertEquals("Drone Delivery", nessaj.getCustomerType());
	}

	// Test getLocationX function
	@Test
	public void testGetPickUpCustomerLocationX() {
		assertEquals(0, jerry.getLocationX());
	}

	@Test
	public void testGetDriverDeliveryCustomeLocationX() {
		assertEquals(5, leo.getLocationX());
	}

	@Test
	public void testGetDroneDeliveryCustomerLocationX() {
		assertEquals(3, nessaj.getLocationX());
	}

	// Test getLocationY function
	@Test
	public void testGetPickUpCustomerLocationY() {
		assertEquals(0, jerry.getLocationY());
	}

	@Test
	public void testGetDriverDeliveryCustomeLocationY() {
		assertEquals(5, leo.getLocationY());
	}

	@Test
	public void testGetDroneDeliveryCustomerLocationY() {
		assertEquals(4, nessaj.getLocationY());
	}

	// Test getDeliveryDistance function
	@Test
	public void testGetDeliveryDistanceOfPickUpCustomer() throws CustomerException {
		assertEquals(0, jerry.getDeliveryDistance(), 0);
	}

	@Test
	public void testGetDeliveryDistanceOfDriverDeliveryCustomer() throws CustomerException {
		assertEquals(10, leo.getDeliveryDistance(), 0);
	}

	@Test
	public void testGetDeliveryDistanceOfDroneDeliveryCustomer() throws CustomerException {
		assertEquals(5, nessaj.getDeliveryDistance(), 0);
	}

	// Test Customer Exception
	// ***************************************************************************************************
	@Test(expected = CustomerException.class)
	public void testTheLengthOfNameIsSmallerThanOne() throws CustomerException {
		leo = new DriverDeliveryCustomer("", "0123456789", 5, 5);
	}

	@Test(expected = CustomerException.class)
	public void testTheLengthOfNameIsBiggerThanTwenty() throws CustomerException {
		leo = new DriverDeliveryCustomer("abcdefghigklmn opqrstuvwxyz", "0123456789", 5, 5);
	}

	@Test(expected = CustomerException.class)
	public void testTheNameIsOnlyWhiteSpace() throws CustomerException {
		leo = new DriverDeliveryCustomer(" ", "0123456789", 5, 5);
	}

	@Test(expected = CustomerException.class)
	public void testTheLengthOfMobileNumberIsNotEqualToTen() throws CustomerException {
		leo = new DriverDeliveryCustomer("Leo Song", "012345678", 5, 5);
	}

	@Test(expected = CustomerException.class)
	public void testTheLengthOfMobilerIsNotBeginWith0() throws CustomerException {
		leo = new DriverDeliveryCustomer("Leo Song", "1234567890", 5, 5);
	}

	// Invalid Pickup Customer Location
	@Test(expected = CustomerException.class)
	public void testThePickUpCustomerLocationNotEqualToZero() throws CustomerException {
		jerry = new PickUpCustomer("Jerry Wang", "0123456789", 1, 0);
	}

	@Test(expected = CustomerException.class)
	public void testThePickUpCustomerLocationYNotEqualToZero() throws CustomerException {
		jerry = new PickUpCustomer("Jerry Wang", "0123456789", 0, 3);
	}

	@Test(expected = CustomerException.class)
	public void testThePickUpCustomerLocationXAndLocationYNotEqualToZero() throws CustomerException {
		jerry = new PickUpCustomer("Jerry Wang", "0123456789", 1, 3);
	}

	// Invalid DriverDelivery Customer Location
	@Test(expected = CustomerException.class)
	public void testTheDriverDeliveryCustomerLocationXAndLocationYIsEqualTozero() throws CustomerException {
		leo = new DriverDeliveryCustomer("Leo Song", "0987654321", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testTheDriverDeliveryCustimerLocationXIsGreatThanTen() throws CustomerException {
		leo = new DriverDeliveryCustomer("Leo Song", "0987654321", 11, 5);
	}

	@Test(expected = CustomerException.class)
	public void testTheDriverDeliveryCustimerLocationXIsLessThanNegativeTen() throws CustomerException {
		leo = new DriverDeliveryCustomer("Leo Song", "0987654321", -11, 5);
	}

	@Test(expected = CustomerException.class)
	public void testTheDriverDeliveryCustimerLocationYIsGreatThanTen() throws CustomerException {
		leo = new DriverDeliveryCustomer("Leo Song", "0987654321", 5, 11);
	}

	@Test(expected = CustomerException.class)
	public void testTheDriverDeliveryCustimerLocationYIsLessThanNegativeTen() throws CustomerException {
		leo = new DriverDeliveryCustomer("Leo Song", "0987654321", 5, -11);
	}

}