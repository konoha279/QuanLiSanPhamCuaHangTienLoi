/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChuyenCanh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class ChuyenController {
    private JPanel Root;

    public ChuyenController(JPanel jpnRoot) {
        this.Root = jpnRoot;
    }

   public void setView(Component jpanel,JButton button,String nameColor)
   {
       button.setBackground(Color.decode(nameColor));
       
       Root.removeAll();
       Root.setLayout(new BorderLayout());
       Root.add(jpanel);
       
       Root.validate();
       Root.repaint();
   }   
}
