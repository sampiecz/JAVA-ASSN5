import java.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add2 extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;

	private JButton addButton = new JButton("Add Numbers");
	private JButton clearButton = new JButton("Clear Numbers");
	private JTextField num1Field = new JTextField(10);
	private JTextField num2Field = new JTextField(10);
	private JLabel sumLabel = new JLabel();

	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
			Add2 frame = new Add2("Sum of Two Numbers");
			frame.createAndShowGUI();
		});
	}

	private void CreateAndShowGUI()
	{
		initComponents();

		addButton.addActionListener(this);
		clearButton.addActionListener(this);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private void initComponents()
	{
		JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.add(new JLabel("First number:"));
		panel.add(num1Field);
	}

}
