import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent; 
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;

public class TipApp extends JFrame implements ActionListener, ChangeListener
{
    private final JButton calculateButton = new JButton("Calculate");
    private final JButton clearButton = new JButton("Clear");
    private JLabel totalBill = new JLabel("$0.00");
    private JLabel individualShare = new JLabel("$0.00");
    private JTextField billAmountJTextField = new JTextField();
    private JSlider myJSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 50, 20);
    private JSpinner myJSpinner = new JSpinner(new SpinnerNumberModel(1, 0, 50, 1));
    private TipCalculator myTipCalculator = new TipCalculator();
    private JPanel mainPanel = new JPanel(new GridLayout(6, 2, 5, 5));

    
    public static void main(String[] args)
    {
		EventQueue.invokeLater(() ->
		{
			TipApp myTipApp  = new TipApp();
			myTipApp.createAndShowGUI();
		});
    }

	private void createAndShowGUI()
	{
		initComponents();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}


	private void initComponents()
	{
        // Bill amount row
		mainPanel.add(new JLabel("Bill Amount"));
		mainPanel.add(billAmountJTextField);

        // Tip percentage row
		mainPanel.add(new JLabel("Tip Percentage"));
        myJSlider.setMinorTickSpacing(5);
        myJSlider.setMajorTickSpacing(10); 
        myJSlider.setPaintTicks(true); 
        myJSlider.setPaintLabels(true);
        myJSlider.setValue(20);
		mainPanel.add(myJSlider);
        
        // Party size row
		mainPanel.add(new JLabel("Party Size"));
		mainPanel.add(myJSpinner);

        // Buttons row
        calculateButton.addActionListener(this);
        clearButton.addActionListener(this);
		mainPanel.add(calculateButton);
		mainPanel.add(clearButton);

        // Total bill with tip row
		mainPanel.add(new JLabel("Total Bill (with Tip)"));
		mainPanel.add(totalBill);

        // Individual share row 
		mainPanel.add(new JLabel("Individual Share"));
		mainPanel.add(individualShare);

        // Add main panel to frame
        add(mainPanel);
	}

    public void calculateTips() 
    {
    }

	@Override
    public void stateChanged(ChangeEvent e)
    {
       double partySize = (Integer)myJSpinner.getValue();
       myTipCalculator.setTipPercentage((int) myJSlider.getValue()); 
       myTipCalculator.setPartySize(partySize); 
    } 

	@Override
	public void actionPerformed(ActionEvent event)
	{ 

		// Store users input 
		String input = event.getActionCommand();
			
		if(input.equals("Calculate"))
		{
			try 
			{

                // Try to convert input 
				double billAmount = Double.parseDouble(billAmountJTextField.getText());	
				double tipPercentage = myJSlider.getValue();	
				double partySize = (Integer)myJSpinner.getValue();	


				// If double is less than zero error
				if (billAmount <= 0)
				{			
					JOptionPane.showMessageDialog(null, "Bill amount must be greater than 0.");
				}
                else
				{
					// If it is a number greater than 0 
					// then we can set the bill amount and call appropriate methods
					myTipCalculator.setBillAmount(billAmount);
					myTipCalculator.setTipPercentage((int) tipPercentage );
					myTipCalculator.setPartySize(partySize);
					totalBill.setText("$" + String.valueOf(myTipCalculator.getTotalBill()));
					individualShare.setText("$" + String.valueOf(myTipCalculator.getIndividualShare()));
				}

			}
			catch( Exception e)
			{
				// Need a number 
				JOptionPane.showMessageDialog(null, "Bill amount must be numeric.");
			}

		}
		else if(input.equals("Clear"))
		{
			// Set user interface back to initial state
			billAmountJTextField.setText("");
			myJSlider.setValue(20);
			myJSpinner.setValue(1);

            myTipCalculator.setBillAmount(0.0);
            myTipCalculator.setTipPercentage(0);
            myTipCalculator.setPartySize(0.0);

            totalBill.setText("$0.00");
            individualShare.setText("$0.00");
		}
	} 

}
