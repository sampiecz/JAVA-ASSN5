import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
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
import javax.swing.JSlider;

public class TipApp extends JFrame implements ActionListener, ChangeListener
{
    private final JButton calculateButton = new JButton("Calculate");
    private final JButton clearButton = new JButton("Clear");
    private JTextField myJTextField = new JTextField();
    private JSlider myJSlider = new JSlider();
    private JSpinner myJSpinner = new JSpinner();
    private TipCalculator myTipCalculator = new TipCalculator();
    private JPanel myJPanel = new JPanel(new GridLayout(4, 2, 5, 5));

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

		calculateButton.addActionListener(this);
		clearButton.addActionListener(this);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}


	private void initComponents()
	{
		myJPanel.add(new JLabel("Bill Amount"));
		myJPanel.add(myJTextField);
		myJPanel.add(new JLabel("Tip Percentage"));
		myJPanel.add(myJSlider);
		myJPanel.add(new JLabel("Party Size"));
		myJPanel.add(myJSpinner);
		myJPanel.add(calculateButton);
		myJPanel.add(clearButton);
        add(myJPanel);
	}

    public void calculateTips() 
    {
    }

	@Override
    public void stateChanged(ChangeEvent e)
    {
        System.out.println(myJSlider.getValue());
    } 

	@Override
	public void actionPerformed(ActionEvent event)
	{ 
		// Store users input 
		String input = event.getActionCommand();
			
		if(input.equals("Calculate"))
		{
			// Try to convert input to double
			try 
			{
				double billAmount = Double.parseDouble(input);	

				// If double is less than zero error
				if (billAmount < 0)
				{			
					JOptionPane.showMessageDialog(null, "Bill amount must be greater than 0.");
				}
                else
				{
					// If it is a number greater than 0 
					// then we can set the bill amount and call appropriate methods
					myTipCalculator.setBillAmount(billAmount);
					myTipCalculator.getTotalBill();
					myTipCalculator.getIndividualShare();
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
			myJTextField.setText("0");
			myJSlider.setValue(20);
			myJSpinner.setValue(1);
		}

		// These are in the wrong place for sure
		this.calculateButton.addActionListener(this);
		this.clearButton.addActionListener(this);
	} 

}
