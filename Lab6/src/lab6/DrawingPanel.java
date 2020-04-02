package lab6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class DrawingPanel extends JPanel {
 final MainFrame frame;
 final static int W = 800;
 final static int H = 600;
 BufferedImage image; //the offscreen image
 Graphics2D graphics; //the "tools" needed to draw in the image
 
 public DrawingPanel(MainFrame frame)
 {
   this.frame = frame;
   createOffscreenImage();
   init();
 }
 
 void createOffscreenImage() {
    image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
    graphics = image.createGraphics();
    graphics.setColor(Color.WHITE); //fill the image with white
    graphics.fillRect(0, 0, W, H);
 }
 private void init()
 {
    setPreferredSize(new Dimension(W, H));
    setBorder(BorderFactory.createEtchedBorder()); //for fun
    this.addMouseListener(new MouseAdapter() {
               @Override
               public void mousePressed(MouseEvent e) {
                   drawShape(e.getX(), e.getY());
                   repaint();
               } 
           });
 }
 private void drawShape(int x, int y) {
    Random random = new Random();
    int radius = frame.configPanel.getShapeSize();
    int sides = frame.configPanel.getSides();
    int c1,c2,c3,opac;
    if(frame.configPanel.colorComboBox.getSelectedItem().toString().contains("Bl"))
    {
        c1=0;
        c2=0;
        c3=0;
    }
    else
    {
        c1 = (int)(random.nextInt(255));
        c2 = (int)(random.nextInt(255));
        c3 = (int)(random.nextInt(255));
    }
    opac = (int)(random.nextInt(255));
    Color color= new Color(c1,c2,c3,opac);
    graphics.setColor(color);
    if(frame.configPanel.sidesField.isVisible())
        //graphics.fill(new RegularPolygon(x, y, radius, sides));
        {
            frame.configPanel.polyShapes.add(new Shapes(sides, radius, color,x,y));
            frame.configPanel.polys.addItem(frame.configPanel.polyShapes.size());
        }
    else{
        
        frame.configPanel.circleShapes.add(new Shapes(0,radius, color,x,y));
        frame.configPanel.circles.addItem(frame.configPanel.circleShapes.size());
    }
        //graphics.fillOval(x-radius ,y-radius , 2*radius, 2*radius);
 }
 @Override
 public void update(Graphics g) {
 }

 @Override
 protected void paintComponent(Graphics g) {
    g.drawImage(image, 0, 0, this);
 }
              
}
