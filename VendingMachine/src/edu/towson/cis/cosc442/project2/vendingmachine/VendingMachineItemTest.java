package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {
	
	VendingMachineItem VMI;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	
	
	@Test //Testing Normal input into the Vending Machine contructor
	public void constructorNormalInput() {
		
		VMI = new VendingMachineItem("Candy", 1.00);
		
		assertEquals(1.00, VMI.getPrice(), 0); // 1 is expected, VMI.getPrice is actual, 0 is the delta or how close they need to be (0 must have exact match)
		
		assertTrue((VMI.getName().equals("Candy")));	
		
	}
	
	@Test //Testing bad input to constructor
	public void constructorBadInput() {
		
		boolean caught = false;
		
		try {
			VMI = new VendingMachineItem("Chips", -1);
		} catch (VendingMachineException exception) {
			caught = true; // If exception is caught variable gets set to true
		}
		
		assertTrue(caught);
				
	}
	
	@Test
	public void getNameTest() {
		
		VMI = new VendingMachineItem("Fritos", 2.00);
		
		assertTrue(VMI.getName().equals("Fritos"));

	}
	
	@Test
	public void getPriceTest() {
		
		VMI = new VendingMachineItem("Twix", 1.75);
		
		assertEquals(1.75,VMI.getPrice(),0);
	

	}

}
