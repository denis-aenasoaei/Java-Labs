/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author denis
 */
public class ShapesPanel extends Panel{
    final MainFrame frame;
    JButton polygonBtn;
    JButton circleBtn;
    
    ShapesPanel(MainFrame mainFrame)
    {
        this.frame = mainFrame;
        init();
    }
    
    private void init()
    {
        setLayout(new GridLayout(2,1));
        polygonBtn = new JButton("Draw Polygons");
        circleBtn = new JButton ("Draw Circles");
        add(polygonBtn);
        add(circleBtn);
        polygonBtn.addActionListener(this::polygonPressed);
        circleBtn.addActionListener(this::circlePressed);
    }
    
    void polygonPressed(ActionEvent e)
    {
        frame.configPanel.sidesLabel.setVisible(true);
        frame.configPanel.sidesField.setVisible(true);
        
        frame.configPanel.circles.setVisible(false);
        frame.configPanel.circlesLabel.setVisible(false);
        
        frame.configPanel.polys.setVisible(true);
        frame.configPanel.polysLabel.setVisible(true);
    }
    
    void circlePressed(ActionEvent e)
    {
        frame.configPanel.sidesLabel.setVisible(false);
        frame.configPanel.sidesField.setVisible(false);
        
        frame.configPanel.polys.setVisible(false);
        frame.configPanel.polysLabel.setVisible(false);
        
        frame.configPanel.circles.setVisible(true);
        frame.configPanel.circlesLabel.setVisible(true);
        
    }
    
}
