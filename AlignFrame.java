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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;

public class AlignFrame extends JFrame implements ActionListener 
{
	private final JButton[] buttons; // array of buttons
	private static final String[] names = 
	{"Ok", "Cancel", "Help"};

	public AlignFrame()
	{
		super("Calculator");

        // Main panel
        JPanel mainPanel = new JPanel(); 
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Left panel
        JPanel leftPanel = new JPanel();  
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JPanel snapGrid = new JPanel();
        snapGrid.setLayout(new GridLayout(1,1));
        JCheckBox snapCheckBox = new JCheckBox("Snap to Grid"); 
        snapGrid.add(snapCheckBox);
        leftPanel.add(snapGrid);

        JPanel showGrid = new JPanel();
        showGrid.setLayout(new GridLayout(1,1));
        JCheckBox showCheckBox = new JCheckBox("Show Grid"); 
        showGrid.add(showCheckBox);
        leftPanel.add(showGrid);


        // Center panel
        JPanel centerPanel = new JPanel();  
        JPanel centerNorthPanel = new JPanel();  
        JPanel centerCenterPanel = new JPanel();  
        JPanel centerSouthPanel = new JPanel();  

        JPanel xPanel = new JPanel();
        JPanel xPanelA = new JPanel();
        JPanel xPanelB = new JPanel();

        JPanel yPanel = new JPanel();
        JPanel yPanelA = new JPanel();
        JPanel yPanelB = new JPanel();

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        xPanel.setLayout(new FlowLayout());
        yPanel.setLayout(new FlowLayout());


        JLabel labelX = new JLabel("X: ");
        xPanel.add(labelX);
		JTextField textFieldX = new JTextField("8        ");   
        xPanel.add(textFieldX);
        JLabel labelY = new JLabel("Y: ");
        yPanel.add(labelY);
		JTextField textFieldY = new JTextField("8        ");   
        yPanel.add(textFieldY);

        centerPanel.add(xPanel);
        centerPanel.add(yPanel);
        centerPanel.setBorder(new EmptyBorder(25, 0, 0, 0));

        // Right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(3,1,10,10));

		buttons = new JButton[names.length];

		for (int count = 0; count < names.length; count++)
		{
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this); // register listener
			rightPanel.add(buttons[count]); // add button to JFrame
		}

		mainPanel.add(leftPanel, "West");
		mainPanel.add(centerPanel, "Center");
		mainPanel.add(rightPanel, "East");
        add(mainPanel);
	}

	// handle button events by toggling between layouts
	@Override
	public void actionPerformed(ActionEvent event)
	{ 
		JOptionPane.showMessageDialog(null, event.getActionCommand());
	} 
}
