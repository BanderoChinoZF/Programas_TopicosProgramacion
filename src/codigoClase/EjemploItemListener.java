import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class EjemploItemListener extends JFrame implements ItemListener{
    private BorderLayout borde;
    private String[] cadenaCombo = {" ", "haya", "allá", "halla"};
    private JComboBox<String> combo;
   
    private String[] cadenaEtiqueta = {" ", "Cuando Juan haya terminado, tomaremos el té.",
            "María siempre halla un trébol de 4 hojas.", "Pedro estaba allá, con sus amigos."};
    private JLabel etiqueta = new JLabel("");
   
    public EjemploItemListener(){
        super("Demostración de ItemListener");
        setSize(350,100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        combo = new JComboBox<String>(cadenaCombo);
        combo.addItemListener(this);
        //for( int i = 0; i > cadenaCombo.length; i++){
        //    combo.addItem(cadenaCombo[i]);
        //}
        add(combo, BorderLayout.NORTH);
        add(etiqueta, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int eleccion = combo.getSelectedIndex();
        etiqueta.setText(cadenaEtiqueta[eleccion]);
    }
    
	public static void main(String[] args){
        new EjemploItemListener();
    }
}