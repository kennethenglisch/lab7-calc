import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class TestPrecedence {
	
	HexCalc hexEngine;
	
	TestPrecedence()
	{
		hexEngine = new HexCalc();
	}

	@Test
	void testPositiveMultiplication() throws IncorrectString, StackUnderflow {
		
		// ------ Check that it is cleared ------
		
				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());
		
		// --------- Test 1 | 1+2*3 = 7 ---------
		
				hexEngine.numberPressed(1);
				hexEngine.plus();
				hexEngine.numberPressed(2);
				hexEngine.mult();
				hexEngine.numberPressed(3);
				hexEngine.equals();
				
				assertEquals("7", hexEngine.getDisplayValue());
		
		
		// ------ Check that it is cleared ------

				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());
		
		// --------- Test 2 | 1*2+3 = 6 ---------
		
				hexEngine.numberPressed(1); 
				hexEngine.mult();
				hexEngine.numberPressed(2);
				hexEngine.plus();
				hexEngine.numberPressed(3);
				hexEngine.equals();
				
				assertEquals("5", hexEngine.getDisplayValue());
		
		// ------ Check that it is cleared ------

		hexEngine.clear();
		assertEquals("", hexEngine.getDisplayValue());
		
		// --------- Test 3 | 1*2+3*4 = 14 ---------
		
				hexEngine.numberPressed(1);
				hexEngine.mult();
				hexEngine.numberPressed(2);
				hexEngine.plus();
				hexEngine.numberPressed(3);
				hexEngine.mult();
				hexEngine.numberPressed(4);
				hexEngine.equals();
				
				assertEquals("14", hexEngine.getDisplayValue());
				
		// ------ Check that it is cleared ------

				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());
				
		// --------- Test 4 | 1+2*3+4 = 11 ---------
				
				hexEngine.numberPressed(1);
				hexEngine.plus();
				hexEngine.numberPressed(2);
				hexEngine.mult();
				hexEngine.numberPressed(3);
				hexEngine.plus();
				hexEngine.numberPressed(4);
				hexEngine.equals();
				
				assertEquals("11", hexEngine.getDisplayValue());
				
		// ------ Check that it is cleared ------

				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());
				
		// --------- Test 5 | 1+2*3*4+5 = 30 ---------
				
				hexEngine.numberPressed(1);
				hexEngine.plus();
				hexEngine.numberPressed(2);
				hexEngine.mult();
				hexEngine.numberPressed(3);
				hexEngine.mult();
				hexEngine.numberPressed(4);
				hexEngine.plus();
				hexEngine.numberPressed(5);
				hexEngine.equals();
				
				assertEquals("30", hexEngine.getDisplayValue());
				
		// ------ Check that it is cleared ------

				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());
	}
	
	@Test
	void testNegativeMultiplication() throws IncorrectString, StackUnderflow
	{
		// ------ Check that it is cleared ------
		
				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());

		// --------- Test 6 | 1-2*3 = -5 ---------

				hexEngine.numberPressed(1);
				hexEngine.minus();
				hexEngine.numberPressed(2);
				hexEngine.mult();
				hexEngine.numberPressed(3);
				hexEngine.equals();
				
				assertEquals("-5", hexEngine.getDisplayValue());
				
		// ------ Check that it is cleared ------
				
				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());
				
		// --------- Test 7 | 1*2-3 = -1 ---------
				
				hexEngine.numberPressed(1);
				hexEngine.mult();
				hexEngine.numberPressed(2);
				hexEngine.minus();
				hexEngine.numberPressed(3);
				hexEngine.equals();
				
				assertEquals("-1", hexEngine.getDisplayValue());
		
		// ------ Check that it is cleared ------

				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());
				
		// --------- Test 8 | 1*2-3*4 = -10 ---------
		
				hexEngine.numberPressed(1);
				hexEngine.mult();
				hexEngine.numberPressed(2);
				hexEngine.minus();
				hexEngine.numberPressed(3);
				hexEngine.mult();
				hexEngine.numberPressed(4);
				hexEngine.equals();
				
				assertEquals("-10", hexEngine.getDisplayValue());
				
		// ------ Check that it is cleared ------

				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());
				
		// --------- Test 9 | 1-2*3-4 = 11 ---------
				
				hexEngine.numberPressed(1);
				hexEngine.minus();
				hexEngine.numberPressed(2);
				hexEngine.mult();
				hexEngine.numberPressed(3);
				hexEngine.minus();
				hexEngine.numberPressed(4);
				hexEngine.equals();
				
				assertEquals("-9", hexEngine.getDisplayValue());
				
		// ------ Check that it is cleared ------

				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());
	}
	
	@Test
	void testPositiveDivision() throws IncorrectString, StackUnderflow
	{
		// ------ Check that it is cleared ------
		
				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());

		// --------- Test 10 | 4/2+1+3 = 6 ---------

				hexEngine.numberPressed(4);
				hexEngine.div();
				hexEngine.numberPressed(2);
				hexEngine.plus();
				hexEngine.numberPressed(1);
				hexEngine.plus();
				hexEngine.numberPressed(3);
				hexEngine.equals();
				
				assertEquals("6", hexEngine.getDisplayValue());
				
		// ------ Check that it is cleared ------
				
				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());

		// --------- Test 11 | 1+4/2+3 = 6 ---------

				hexEngine.numberPressed(1);
				hexEngine.plus();
				hexEngine.numberPressed(4);
				hexEngine.div();
				hexEngine.numberPressed(2);
				hexEngine.plus();
				hexEngine.numberPressed(3);
				hexEngine.equals();
				
				assertEquals("6", hexEngine.getDisplayValue());
				
		// ------ Check that it is cleared ------
				
				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());

		// --------- Test 12 | 1+3+4/2 = 6 ---------

				hexEngine.numberPressed(1);
				hexEngine.plus();
				hexEngine.numberPressed(3);
				hexEngine.plus();
				hexEngine.numberPressed(4);
				hexEngine.div();
				hexEngine.numberPressed(2);
				hexEngine.equals();
				
				assertEquals("6", hexEngine.getDisplayValue());
	}
	
	@Test
	void testNegativeDivision() throws IncorrectString, StackUnderflow
	{
		// ------ Check that it is cleared ------
		
				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());

		// --------- Test 13 | 4/2-1-3 = -2 ---------

				hexEngine.numberPressed(4);
				hexEngine.div();
				hexEngine.numberPressed(2);
				hexEngine.minus();
				hexEngine.numberPressed(1);
				hexEngine.minus();
				hexEngine.numberPressed(3);
				hexEngine.equals();
				
				assertEquals("-2", hexEngine.getDisplayValue());	
				
		// ------ Check that it is cleared ------
				
				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());
		
		// --------- Test 14 | 1-4/2-3 = -4 ---------

				hexEngine.numberPressed(1);
				hexEngine.minus();
				hexEngine.numberPressed(4);
				hexEngine.div();
				hexEngine.numberPressed(2);
				hexEngine.minus();
				hexEngine.numberPressed(3);
				hexEngine.equals();
				
				assertEquals("-4", hexEngine.getDisplayValue());
				
		// ------ Check that it is cleared ------
		
				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());

		// --------- Test 15 | 1-3-4/2 = -4 ---------

				hexEngine.numberPressed(1);
				hexEngine.minus();
				hexEngine.numberPressed(3);
				hexEngine.minus();
				hexEngine.numberPressed(4);
				hexEngine.div();
				hexEngine.numberPressed(2);
				hexEngine.equals();
				
				assertEquals("-4", hexEngine.getDisplayValue());		
	}
	
	@Test
	void testPositiveDivisionMultiplication() throws IncorrectString, StackUnderflow
	{
		// ------ Check that it is cleared ------
		
				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());

		// --------- Test 16 | 1+4/2*5+3 = 14 ---------

				hexEngine.numberPressed(1);
				hexEngine.plus();
				hexEngine.numberPressed(4);
				hexEngine.div();
				hexEngine.numberPressed(2);
				hexEngine.mult();
				hexEngine.numberPressed(5);
				hexEngine.plus();
				hexEngine.numberPressed(3);
				hexEngine.equals();
				
				assertEquals("14", hexEngine.getDisplayValue());		
	}
	
	@Test
	void testNegativeDivisionMultiplication() throws IncorrectString, StackUnderflow
	{
		// ------ Check that it is cleared ------
		
				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());

		// --------- Test 17 | 1-4/2*5-3 = -12 ---------

				hexEngine.numberPressed(1);
				hexEngine.minus();
				hexEngine.numberPressed(4);
				hexEngine.div();
				hexEngine.numberPressed(2);
				hexEngine.mult();
				hexEngine.numberPressed(5);
				hexEngine.minus();
				hexEngine.numberPressed(3);
				hexEngine.equals();
				
				assertEquals("-12", hexEngine.getDisplayValue());		
	}
	
	@Test
	void testPositiveNegativeDivisionMultiplication() throws IncorrectString, StackUnderflow
	{
		// ------ Check that it is cleared ------
		
				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());

		// --------- Test 18 | 1+4/2*5-3 = 8 ---------

				hexEngine.numberPressed(1);
				hexEngine.plus();
				hexEngine.numberPressed(4);
				hexEngine.div();
				hexEngine.numberPressed(2);
				hexEngine.mult();
				hexEngine.numberPressed(5);
				hexEngine.minus();
				hexEngine.numberPressed(3);
				hexEngine.equals();
				
				assertEquals("8", hexEngine.getDisplayValue());		
				
		// ------ Check that it is cleared ------
				
				hexEngine.clear();
				assertEquals("", hexEngine.getDisplayValue());

		// --------- Test 19 | 1-4/2*5+3 = -6 ---------

				hexEngine.numberPressed(1);
				hexEngine.minus();
				hexEngine.numberPressed(4);
				hexEngine.div();
				hexEngine.numberPressed(2);
				hexEngine.mult();
				hexEngine.numberPressed(5);
				hexEngine.plus();
				hexEngine.numberPressed(3);
				hexEngine.equals();
				
				assertEquals("-6", hexEngine.getDisplayValue());		
	}
}
