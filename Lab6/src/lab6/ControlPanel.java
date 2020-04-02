package lab6;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton exitBtn = new JButton("Exit");
    JButton resetBtn = new JButton("Reset");
    JButton loadBtn = new JButton("Load");
    
    JFileChooser fileChooser = new JFileChooser();
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
       fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    }
    
 private void save(ActionEvent e) {
 
     try {
         int result = fileChooser.showSaveDialog(this);
         if (result == JFileChooser.APPROVE_OPTION) {
             System.out.println(fileChooser.getSelectedFile());
             File chosen =  fileChooser.getSelectedFile();
            ImageIO.write(frame.canvas.image, "png", new File(chosen.getAbsolutePath()));
         }
         
    }
     catch (IOException ex)
     {
         System.err.println(ex); 
     }
 }
 private void load(ActionEvent e) {
      try 
      {
          int result = fileChooser.showOpenDialog(saveBtn);
          if (result == JFileChooser.APPROVE_OPTION) {
              
              System.out.println(fileChooser.getSelectedFile());
              var toLoad = ImageIO.read(fileChooser.getSelectedFile());
              frame.setImage(toLoad);
              frame.canvas.repaint();
        }
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