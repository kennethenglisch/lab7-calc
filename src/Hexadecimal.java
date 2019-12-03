import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Hexadecimal extends UserInterface {

	JPanel panel;
	CalcEngine decEngine;
	HexCalc hexEngine;

	public Hexadecimal(CalcEngine decEngine, HexCalc hexEngine) {
		super(decEngine);
		this.decEngine = decEngine;
		this.hexEngine = hexEngine;

	}

	protected void makeFrame() {
		super.makeFrame();

		JPanel contentPane = (JPanel) frame.getContentPane();

		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		panel = new JPanel();
		addButton(panel, "a");
		addButton(panel, "b");
		addButton(panel, "c");
		addButton(panel, "d");
		addButton(panel, "e");
		addButton(panel, "f");

		Checkbox check = new Checkbox("Hexadecimal");
		check.addItemListener(event -> {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				((JPanel) frame.getContentPane()).add(panel);
				frame.pack();
				calc = hexEngine;
			} else {
				((JPanel) frame.getContentPane()).remove(panel);
				frame.pack();
				calc = decEngine;
			}
			calc.clear();
			super.redisplay();
		});
		contentPane.add(check);
		frame.pack();
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();

		super.actionPerformed(event);

		if (command.equals("a") || command.equals("b") || command.equals("c") || command.equals("d")
				|| command.equals("e") || command.equals("f")) {
			String hex = command.toUpperCase();
			hexEngine.numberPressed(hex);
		}
		redisplay();
	}

	public void redisplay() {
		if (calc == hexEngine) {
			display.setText("" + hexEngine.toHex(calc.getDisplayValue()));
		} else {
			display.setText("" + calc.getDisplayValue());
		}
	}

}