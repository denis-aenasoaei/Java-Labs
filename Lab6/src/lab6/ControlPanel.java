package lab6;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton exitBtn = new JButton("Exit");
    JButton resetBtn = new JButton("Reset");
    JButton loadBtn = new JButton("Load");
    
    public ControlPanel(MainFrame frame) 
    {
        this.frame = frame; 
        init();
    }
    private void init() {
       setLayout(new GridLayout(1, 4));
       add(saveBtn);
       add(exitBtn);
       add(loadBtn);
       add(resetBtn);
       saveBtn.addActionListener(this::save);
       loadBtn.addActionListener(this::load);
       resetBtn.addActionListener(this::reset);
       exitBtn.addActionListener(this::exit);
    }
    
 private void save(ActionEvent e) {
 
     try {
        ImageIO.write(frame.canvas.image, "jpg", new File("e:/test.png"));
    }
     catch (IOException ex)
     {
         System.err.println(ex); 
     }
 }
 private void load(ActionEvent e) {
      try 
      {
        File toLoad = new File("e:/test.png");          
        frame.canvas.image = ImageIO.read(toLoad);
      }
      catch (IOException ex) 
      {
          System.err.println(ex);
      }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        
  
    private void reset(ActionEvent e)
    {
       this.frame.clearfield(); 
       this.frame.repaint();
    }

    private void exit(ActionEvent e) 
    {
        System.exit(0);
 }
}