/**
 * The main class of a simple calculator. Create one of these and you'll get the
 * calculator on screen.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Calculator {
	private CalcEngine engine;
	private UserInterface gui;
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
	}

	/**
	 * Create a new calculator and show it.
	 */
	public Calculator() {
		HexCalc hexEngine = new HexCalc();
		engine = new CalcEngine();
		gui = new Hexadecimal(engine, hexEngine);
	}

	/**
	 * In case the window was closed, show it again.
	 */
	public void show() {
		gui.setVisible(true);
	}
}