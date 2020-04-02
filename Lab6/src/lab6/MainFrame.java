package lab6;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
 


public class MainFrame extends JFrame {
 ConfigPanel configPanel;
 ControlPanel controlPanel;
 DrawingPanel canvas;
 ShapesPanel shapesPanel;
 

 public MainFrame() {
    super("My Drawing Application");
    init();
 }
 
 private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        shapesPanel = new ShapesPanel(this);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);
        add(configPanel,BorderLayout.NORTH);
        add(shapesPanel, BorderLayout.WEST);
        pack();
    }
 public void clearfield(){
    this.canvas.createOffscreenImage();
    this.configPanel.sidesField.setValue(3);
    this.canvas.createOffscreenImage();
 }
 public void setImage(BufferedImage img)
 {
     this.canvas.image = img;
 }
 
 }