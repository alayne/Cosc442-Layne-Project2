package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	
	VendingMachine VM;
	VendingMachineItem VMI;
	VendingMachineItem VMI2;
	
	@Before
	public void setUp() throws Exception {
		
		VM = new VendingMachine();
		VMI = new VendingMachineItem("Candy", 1.00);
		VMI2 = new VendingMachineItem("Chips", 2.00);
		
	}

	@After
	public void tearDown() throws Exception {
		//VM.removeItem("A");
		//VM.removeItem("B");
		
	}

	@Test // Test adding item to empty slot
	public void addItemTest() {
		
		VM.addItem(VMI, "A");
		
		assertEquals(VMI, VM.getItem("A"));
		
	}
	
	// Testing trying to add an item to an already occupied slot. First adds an item, then adds another item to same slot
	@Test
	public void addItemToOccupiedSlotTest() {
		boolean caught = false;
		VM.addItem(VMI, "A");
		
		
		try{
			VM.addItem(VMI2, "A");
		}
		catch (VendingMachineException exception) {
			caught = true;
		}
		
		assertTrue(caught);
		
	}
	
	// Tests adding an item to an invalid slot. Tries to add item to slot E
	@Test
	public void addItemInvalidSlotTest() {
		boolean caught = false;
		
		try{
			VM.addItem(VMI2, "E");
		}
		catch (VendingMachineException exception) {
			caught = true;
		}
		assertTrue(caught);
		
	}
	
	// Test removing item normally. First adding the item, then removing it, then trying to get the removed item
	@Test
	public void removeItemTest() {
		
		boolean caught = false;
		VM.addItem(VMI, "A");
		
		VM.removeItem("A");
		
		try {
			VM.getItem("A");
		}
		catch (VendingMachineException exception) {
			caught = true;
		}
		
		assertTrue(caught);
		
	}
	
	@Test // Testing removing an item from a slot that has no item in it, should throw an error
	public void removeItemEmptySlotTest() {
		
		boolean caught = false;
		
		try {
			VM.removeItem("A");
		}
		catch (VendingMachineException exception) {
			caught = true;
		}
		
		assertTrue(caught);
		
	}
	
	
	@Test // Testing ability to insert money into a machine with balance of 0. 
	public void insertMoneyTest() {
		
		VM.insertMoney(10.00);
		
		assertEquals(10.00, VM.getBalance(), 0);
		
		
	}
	
	@Test // Tests adding a negativ 
	public void insertNegativeAmountTest() {
		
		boolean caught = false;
		try { 
			VM.insertMoney(-1.00);
		}
		catch (VendingMachineException exception) {
			
			caught = true;
		}
		
		assertTrue(caught);
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
}
