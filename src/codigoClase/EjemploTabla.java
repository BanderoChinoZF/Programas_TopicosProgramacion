import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class EjemploTabla extends JFrame {

	
 public EjemploTabla() {
      super("Tabla de usuarios");
      //array bidimensional de objetos con los datos de la tabla
	  Object[][] datos = {{"Daniel","Villar","Esquiar", 5, false},{"Carlos", "Villar","Patinar", 3, true},{"Karinna","Villar","Escalar", 2, false},{"Mario","Diaz","Correr", 7, true},{"Sylvia","Uribe","Modelar", 4, false}};

      //array de String's con los títulos de las columnas

      String[] columnNames = {"Nombre","Apellido","Pasatiempo","Años de Practica","Soltero(a)"};
      //creamos el Modelo de la tabla con los datos anteriores

      DefaultTableModel dtm= new DefaultTableModel(datos,columnNames);
      //se crea la Tabla con el modelo DefaultTableModel

      final JTable table = new JTable(dtm);
      // una vez creada la tabla con su modelo
      // podemos agregar columnas

      String[] newColumn= {"Flan","Pastel","Helado","Barquillo","Manzana" };
      dtm.addColumn("Postre",newColumn);
      //filas

      Object[] newRow={"Pepe", "Grillo","Tenis", new Integer(5), new Boolean(false),"Pera"};
      dtm.addRow(newRow);
      //o modificar una celda en especifico

      dtm.setValueAt("Catherine", 1, 1);
      //se define el tamaño

      table.setPreferredScrollableViewportSize(new Dimension(500, 70));
      //Creamos un JscrollPane y le agregamos la JTable

      JScrollPane scrollPane = new JScrollPane(table);
      //Agregamos el JScrollPane al contenedor

      getContentPane().add(scrollPane, BorderLayout.CENTER);
      //manejamos la salida

      addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          System.exit(0);
        } 
     });
 }
 
 public static void main(String[] args) {
  EjemploTabla frame = new EjemploTabla();
     frame.pack();
     frame.setVisible(true);
   }
}
