import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.BoxLayout;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPanel;

public class Hexadecimal extends UserInterface {

	JPanel panel;
	CalcEngine decEngine;
	HexCalc hexEngine;

	JPanel checkPanel;
	JCheckBoxMenuItem jBox;
	JPanel hexPanel;

	JPanel hexContent;

	public Hexadecimal(CalcEngine decEngine, HexCalc hexEngine) {
		super(decEngine);
		this.decEngine = decEngine;
		this.hexEngine = hexEngine;
		addHexButtons();

	}

	public void addHexButtons() {
		frame.setMinimumSize(new Dimension(250, 250));
		checkPanel = new JPanel();
		hexContent = new JPanel(new BorderLayout());

		// check box for enable / disable hex buttons
		jBox = new JCheckBoxMenuItem("Hexadecimal?");
		jBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jBox.getState()) // enabling hex buttons
				{
					hexPanel.setVisible(true);
					frame.setMinimumSize(new Dimension(250, 329));
				} else // disabling hex buttons
				{
					hexPanel.setVisible(false);
					frame.setMinimumSize(new Dimension(250, 250));
					frame.setSize(250, 250);

				}
				// clearing the display every time we change state of the state of the check box
				calc.clear();
				redisplay();
			}
		});

		checkPanel.add(jBox);

		hexContent.add(checkPanel, BorderLayout.NORTH);

		// creating panel and buttons for hex buttons
		hexPanel = new JPanel(new GridLayout(3, 2));
		hexPanel.setVisible(false);

		addButton(hexPanel, "F");
		addButton(hexPanel, "E");
		addButton(hexPanel, "D");

		addButton(hexPanel, "C");
		addButton(hexPanel, "B");
		addButton(hexPanel, "A");

		hexContent.add(hexPanel, BorderLayout.CENTER);

		// putting all created buttons with the main panel into the frame (south)
		frame.getContentPane().add(hexContent, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent event) {

		String command = event.getActionCommand();

		if (jBox.getState()) {
			if (command.equals("A") || command.equals("B") || command.equals("C") || command.equals("D")
					|| command.equals("E") || command.equals("F")) {
				try {
					((HexCalc)calc).numberPressed(command);
				} catch (StackUnderflow | IncorrectString e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		super.actionPerformed(event);
	}

	public void redisplay() {
		if (jBox.getState()) {
				display.setText(((HexCalc)calc).getHexDisplayValue());
		} else
			display.setText(calc.getDisplayValue());
	}
}