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
		checkPanel =  new JPanel();
		hexContent = new JPanel(new BorderLayout());
		
		
		// check box for enable / disable hex buttons
		jBox = new JCheckBoxMenuItem("Hexadecimal?");
	    jBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jBox.getState()) // enabling hex buttons
				{
					hexPanel.setVisible(true);
					frame.setMinimumSize(new Dimension(250, 329));
				}
				else // disabling hex buttons
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
//		String command = event.getActionCommand();
//
//		super.actionPerformed(event);
//
//		if (command.equals("A") || command.equals("B") || command.equals("C") || command.equals("D")
//				|| command.equals("E") || command.equals("F")) {
//			String hex = command.toUpperCase();
//			hexEngine.numberPressed(hex);
//		}
//		redisplay();
		
		String command = event.getActionCommand();

		if (jBox.getState()) {
			if (command.equals("0") ||
				command.equals("1") ||
				command.equals("2") ||
				command.equals("3") ||
				command.equals("4") ||
				command.equals("5") ||
				command.equals("6") ||
				command.equals("7") ||
				command.equals("8") ||
				command.equals("9")) 
			{
				try {
					calc.numberPressed(Integer.parseInt(command));
				} catch (NumberFormatException | StackUnderflow | IncorrectString e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				calc.hexPressed(command);
			}
			else if (command.equals("A") || 
				     command.equals("B") || 
				     command.equals("C") || 
				     command.equals("D") || 
				     command.equals("E") || 
				     command.equals("F")) 
			{
				int hexNum = Integer.parseInt(command, 16);
				try {
					calc.numberPressed(hexNum / 10);
				} catch (StackUnderflow | IncorrectString e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					calc.numberPressed(hexNum % 10);
				} catch (StackUnderflow | IncorrectString e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				calc.hexPressed(command);
			}
		}
		else {
			if (command.equals("0") ||
			    command.equals("1") ||
			    command.equals("2") ||
			    command.equals("3") ||
			    command.equals("4") ||
			    command.equals("5") ||
			    command.equals("6") ||
			    command.equals("7") ||
			    command.equals("8") ||
			    command.equals("9")) 
			{
				int number = Integer.parseInt(command);
				try {
					calc.numberPressed(number);
				} catch (StackUnderflow | IncorrectString e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		if(command.equals("+")) {
	        calc.plus();
	    }
	    else if(command.equals("-")) {
	        calc.minus();
	    }
	    else if(command.equals("=")) {
	        try {
				calc.equals();
			} catch (IncorrectString | StackUnderflow e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    else if (command.equals("÷")) {
        	calc.div();
        }
        else if (command.equals("x")) {
        	calc.mult();
        }
	    else if(command.equals("AC")) 
	    {
	    	calc.clear();
	    }
		redisplay();
	}

	public void redisplay() {
		String str = calc.getDisplayValue();
		
		if (jBox.getState()) {
			if (calc.calculated) 
			{
				display.setText("" + Integer.toHexString(Integer.parseInt(calc.getDisplayValue())).toUpperCase());
			}
			else if (!calc.calculated) 
			{
				display.setText("" + calc.getHexDisplayValue());
			}
			
			
		} 
		else 
		{
			display.setText("" + calc.getDisplayValue());
		}
	}

}