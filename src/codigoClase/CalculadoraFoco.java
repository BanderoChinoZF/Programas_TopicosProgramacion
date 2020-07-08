import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
public class CalculadoraFoco extends JFrame implements FocusListener {
    FlowLayout flujo = new FlowLayout();
    JTextField num1 = new JTextField(10);
    JLabel mas = new JLabel(" + ");
    JTextField num2 = new JTextField(10);
    JLabel igual = new JLabel(" = ");
    JTextField resultado = new JTextField("0", 8);
    public CalculadoraFoco(){
        super("Calculadora a través de FocusListener");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        setLayout(flujo);
        num1.addFocusListener(this);
        add(num1); add(mas);
        num2.addFocusListener(this);
        add(num2); add(igual);
        resultado.setEnabled(false);
        add(resultado);
       
        pack();
        setVisible(true);
    }
    @Override
    public void focusGained(FocusEvent e) {
		if (e.getSource() == num1){
			num1.setSelectionStart(0);
			num1.setSelectionEnd(num1.getText().length());
		}
		else if (e.getSource() == num2) {
			num2.setSelectionStart(0);
			num2.setSelectionEnd(num2.getText().length());
		}
        try{
				
            float total = Float.parseFloat( num1.getText() ) + Float.parseFloat( num2.getText() );
            resultado.setText(" " + total);
        }catch(NumberFormatException em){
            num1.setText("0");
            num2.setText("0");
            resultado.setText("0");
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        focusGained(e);
    }
    public static void main(String[] args) {
        new CalculadoraFoco();
    }
}