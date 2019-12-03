/**
 * The main part of the calculator doing the calculations.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class CalcEngine {
	Postfix post = new Postfix();
	
	int result = 0;
	// The calculator's state is maintained in three fields:
	// buildingDisplayValue, haveLeftOperand, and lastOperator.

	// Are we already building a value in the display, or will the
	// next digit be the first of a new one?
	protected boolean buildingDisplayValue;
	// Has a left operand already been entered (or calculated)?
	protected boolean haveLeftOperand;
	// The most recent operator that was entered.
	private char lastOperator;

	// The current value (to be) shown in the display.
	protected String displayValue;
	
	protected String internalDisplayValue;
	
	protected String dV;
	// The value of an existing left operand.
	// protected int leftOperand;
	
	int temp;
	/**
	 * Create a CalcEngine.
	 */
	public CalcEngine() {
		clear();
	}

	/**
	 * @return The value that should currently be displayed on the calculator
	 *         display.
	 */
	public String getDisplayValue() {
		if(lastOperator == '=') {
		return Integer.toString(result);
		}
		else {
			return displayValue;
		}
	}
	
	public String checkResult(int result) {
		String str = "";
		String valueString;
		
		if(result > 9) 
		{
			temp = result / 9;
			int rest = result % 9;
			if (temp > 9)
					str += checkResult(temp);
			
			if (str.equals(""))
				valueString = "(" + (temp > 1 ? temp + "*" : "") + 9 + (rest > 0 ? "+" + rest : "") +")";
			else
				valueString = "(" + str + "*" + 9 + (rest > 0 ? "+" + rest : "") + ")";
			
			return valueString;
		}
		else {
			return Integer.toString(result);
		}
	}

	/**
	 * A number button was pressed. Either start a new operand, or incorporate this
	 * number as the least significant digit of an existing one.
	 * 
	 * @param number The number pressed on the calculator.
	 * @throws IncorrectString 
	 * @throws StackUnderflow 
	 */
	public void numberPressed(int number) throws StackUnderflow, IncorrectString 
	{
		if (buildingDisplayValue) 
		{
			dV += number;
			System.out.println(dV);
			
			internalDisplayValue = internalDisplayValue.substring(0, internalDisplayValue.length() - 1) + checkResult(Integer.parseInt(dV));
			
			displayValue += number;
		}
		else 
		{
			displayValue += number;
			dV = Integer.toString(number);
			internalDisplayValue += number;
			buildingDisplayValue = true;
			
			System.out.println(internalDisplayValue);
		}
	}

	/**
	 * The 'plus' button was pressed.
	 */
	public void plus() {
		displayValue += "+";
		internalDisplayValue += "+";
		lastOperator = '+';
		buildingDisplayValue = false;
		result = 0;
		dV = "";
	}

	/**
	 * The 'minus' button was pressed.
	 */
	public void minus() {
		displayValue += "-";
		internalDisplayValue += "-";
		lastOperator = '-';
		buildingDisplayValue = false;
		result = 0;
		dV = "";
	}

	/**
	 * The 'multiply' button was pressed.
	 */
	public void mult() {
		displayValue += "*";
		internalDisplayValue += "*";
		lastOperator = '*';
		buildingDisplayValue = false;
		result = 0;
		dV = "";
	}

	/**
	 * The 'division' button was pressed.
	 */
	public void div() {
		displayValue += "/";
		internalDisplayValue += "/";
		lastOperator = '/';
		buildingDisplayValue = false;
		result = 0;
		dV = "";
	}

	/**
	 * The '=' button was pressed.
	 */
	public void equals() throws IncorrectString, StackUnderflow
	{
			String postfix = post.infixToPostfix(internalDisplayValue);
			result = post.evaluate(postfix);
			String display = checkResult(result);
			displayValue = Integer.toString(result);
			
//			System.out.println(internalDisplayValue);
			internalDisplayValue = display;
//			System.out.println(internalDisplayValue);
			
			
			lastOperator = '=';
			buildingDisplayValue = false;
	}

	/**
	 * The 'AC' (clear) button was pressed. Reset everything to a starting state.
	 */
	public void clear() {
		lastOperator = ' ';
		haveLeftOperand = false;
		buildingDisplayValue = false;
		displayValue = "";
		internalDisplayValue = "";
		dV = "";
	}

	/**
	 * @return The title of this calculation engine.
	 */
	public String getTitle() {
		return "Java Calculator";
	}

//	/**
//	 * @return The author of this engine.
//	 */
//	public String getAuthor() {
//		return "David J. Barnes and Michael Kolling";
//	}
//
//	/**
//	 * @return The version number of this engine.
//	 */
//	public String getVersion() {
//		return "Version 1.0";
//	}

	/**
	 * Report an error in the sequence of keys that was pressed.
	 */
	protected void keySequenceError() {
		System.out.println("A key sequence error has occurred.");
		// Reset everything.
		clear();
	}
}