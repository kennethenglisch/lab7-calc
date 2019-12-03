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
	// The value of an existing left operand.
	// protected int leftOperand;

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
		if(result > 9) {
			int temp = result / 9;
			int rest = result % 9;
			String valueString = "(" + temp + "*" + 9 + "+" + rest +")";
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
	 */
	public void numberPressed(int number) {
		if (buildingDisplayValue) {
			// Incorporate this digit.
			displayValue = displayValue + number;
		} else {
			// Start building a new number.
			displayValue += number;
			buildingDisplayValue = true;
		}
	}

	/**
	 * The 'plus' button was pressed.
	 */
	public void plus() {
		displayValue += "+";
		lastOperator = '+';
	}

	/**
	 * The 'minus' button was pressed.
	 */
	public void minus() {
		displayValue += "-";
		lastOperator = '-';
	}

	/**
	 * The 'multiply' button was pressed.
	 */
	public void mult() {
		displayValue += "*";
		lastOperator = '*';
	}

	/**
	 * The 'division' button was pressed.
	 */
	public void div() {
		displayValue += "/";
		lastOperator = '/';
	}

	/**
	 * The '=' button was pressed.
	 */
	public void equals() throws IncorrectString, StackUnderflow{
		// This should complete the building of a second operand,
		// so ensure that we really have a left operand, an operator
		// and a right operand.
			String postfix = post.infixToPostfix(displayValue);
			result = post.evaluate(postfix);
			String display = checkResult(result);
			displayValue = display;
			lastOperator = '=';
			buildingDisplayValue = false;
		
	}

	/**
	 * The 'C' (clear) button was pressed. Reset everything to a starting state.
	 */
	public void clear() {
		lastOperator = '?';
		haveLeftOperand = false;
		buildingDisplayValue = false;
		displayValue = "";
	}

	/**
	 * @return The title of this calculation engine.
	 */
	public String getTitle() {
		return "Java Calculator";
	}

	/**
	 * @return The author of this engine.
	 */
	public String getAuthor() {
		return "David J. Barnes and Michael Kolling";
	}

	/**
	 * @return The version number of this engine.
	 */
	public String getVersion() {
		return "Version 1.0";
	}

	/**
	 * Report an error in the sequence of keys that was pressed.
	 */
	protected void keySequenceError() {
		System.out.println("A key sequence error has occurred.");
		// Reset everything.
		clear();
	}
}