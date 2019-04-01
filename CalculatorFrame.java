/************************************************************
 *                                                          *
 *  CSCI 470-1   Assignment 4                   Spring 2019 *
 *                                                          *
 *  Programmer:  Samuel Piecz                               *  
 *               z1732715                                   *
 *                                                          * 
 *                                                          *   
 *                                                          *
 *  Date Due:    3/19/19                                    *
 *                                                          *
 ************************************************************/ 

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CalculatorFrame extends JFrame implements ActionListener 
{
	private final JButton[] buttons; // array of buttons
	private static final String[] names = 
	{"7", "8", "9", "C", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};

	public CalculatorFrame()
	{
		super("Calculator");

        JPanel mainPanel = new JPanel(); // panel for other two panels
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel textPanel = new JPanel(); // panel for text 
        textPanel.setLayout(new GridLayout(1, 1));
        textPanel.setBorder(new EmptyBorder(0, 0, 5, 0));

        JPanel buttonPanel = new JPanel(new FlowLayout()); // panel for text 
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

		JTextField textField = new JTextField();   // Make a JTextField;
		textPanel.add(textField); // Add textfield to panel
		mainPanel.add(textPanel, "North"); // Add textPanel to main panel 

		buttons = new JButton[names.length];

		for (int count = 0; count < names.length; count++)
		{
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this); // register listener
			buttonPanel.add(buttons[count]); // add button to JFrame
		}

		mainPanel.add(buttonPanel, "Center");
        add(mainPanel);
	}

	// handle button events by toggling between layouts
	@Override
	public void actionPerformed(ActionEvent event)
	{ 
		JOptionPane.showMessageDialog(null, event.getActionCommand());
	} 
}
