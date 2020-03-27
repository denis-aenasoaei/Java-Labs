package lab6;



import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


public class ConfigPanel extends JPanel {
 final MainFrame frame;
 JLabel label; // we’re drawing regular polygons
 JSpinner sidesField; // number of sides
 JComboBox colorComboBox; // the color of the shape
 JLabel sidesLabel;
 
 public ConfigPanel(MainFrame frame)
   {
     this.frame = frame;
     init();
   }
 private void init() {
    sidesLabel = new JLabel("Number of sides:");
    sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
    sidesField.setValue(4); //default number of sides
    colorComboBox = new JComboBox();//create the colorCombo, containing the values: Random and Black
    colorComboBox.addItem("Random");
    colorComboBox.addItem("Black");
    add(sidesLabel); //JPanel uses FlowLayout by default
    add(sidesField);
    add(colorComboBox);

 }
 public int getSides(){
     return (int)sidesField.getValue();
 }
}