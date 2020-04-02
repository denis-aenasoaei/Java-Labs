package lab6;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
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
    JLabel sizeLabel;
    JSpinner sizeField;
    JLabel circlesLabel = new JLabel("Select the cicle");
    JComboBox circles = new JComboBox();
    JLabel polysLabel = new JLabel("Select the polygon");
    JComboBox polys = new JComboBox();
    
    JButton draw = new JButton("Draw");
    JButton delete = new JButton("Delete");
    
    public ArrayList<Shapes> circleShapes = new ArrayList<>();
    public ArrayList<Shapes> polyShapes = new ArrayList<>();
    
 
 public ConfigPanel(MainFrame frame)
   {
     this.frame = frame;
     init();
   }
 private void init() {
    sidesLabel = new JLabel("Number of sides:");
    sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
    sizeLabel = new JLabel("Size of the shape");
    sizeField = new JSpinner(new SpinnerNumberModel(0,0,600,1));
    sizeField.setValue(30);
    sidesField.setValue(4); //default number of sides
    colorComboBox = new JComboBox();//create the colorCombo, containing the values: Random and Black
    colorComboBox.addItem("Random");
    colorComboBox.addItem("Black");
    add(sidesLabel); //JPanel uses FlowLayout by default
    add(sidesField);
    add(sizeLabel);
    add(sizeField);
    add(colorComboBox);
    add(circlesLabel);
    circlesLabel.setVisible(false);
    add(circles);
    circles.setVisible(false);
    add(polysLabel);
    add(polys);
    add(draw);
    add(delete);
    draw.addActionListener(this::drawAll);
    delete.addActionListener(this::deleteShape);
 }
 
 public void drawAll(ActionEvent e)
 {
     frame.canvas.graphics.setColor(Color.WHITE);
     frame.canvas.graphics.fillRect(0, 0, frame.canvas.W, frame.canvas.H);
     for(var shape : circleShapes)
     {
         frame.canvas.graphics.setColor(shape.getColor());
         frame.canvas.graphics.fillOval(shape.getX() - shape.getRadius() ,shape.getY() - shape.getRadius() , 2*shape.getRadius(), 2*shape.getRadius());
     }
     
     for(var shape : polyShapes)
     {
         frame.canvas.graphics.setColor(shape.getColor());
         frame.canvas.graphics.fill(new RegularPolygon(shape.getX(), shape.getY(), shape.getRadius(), shape.getSides()));
     }
     frame.canvas.repaint();
 }
 public void deleteShape(ActionEvent e)
 {
     if(polys.isVisible())
     {
         polyShapes.remove((int) polys.getSelectedItem() -1);
         polys.removeItem(polys.getSelectedItem());
     }
     else
     {
         circleShapes.remove((int) circles.getSelectedItem()-1);
         circles.removeItem(circles.getSelectedItem());
     }
     
     frame.canvas.graphics.setColor(Color.WHITE);
     frame.canvas.graphics.fillRect(0, 0, frame.canvas.W, frame.canvas.H);
     
     for(var shape : circleShapes)
     {
         frame.canvas.graphics.setColor(shape.getColor());
         frame.canvas.graphics.fillOval(shape.getX() - shape.getRadius() ,shape.getY() - shape.getRadius() , 2*shape.getRadius(), 2*shape.getRadius());
     }
     
     for(var shape : polyShapes)
     {
         frame.canvas.graphics.setColor(shape.getColor());
         frame.canvas.graphics.fill(new RegularPolygon(shape.getX(), shape.getY(), shape.getRadius(), shape.getSides()));
     }
     frame.canvas.repaint();
 }
 public int getSides(){
     return (int)sidesField.getValue();
 }
 public int getShapeSize()
 {
     return (int)sizeField.getValue();
 }
}