import javax.swing.JFrame;

public class CalculatorTest 
{
   public static void main(String[] args)
   { 
      CalculatorFrame calculatorFrame = new CalculatorFrame(); 
      calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      calculatorFrame.setSize(600, 400); 
      calculatorFrame.setVisible(true); 
   } 
}
