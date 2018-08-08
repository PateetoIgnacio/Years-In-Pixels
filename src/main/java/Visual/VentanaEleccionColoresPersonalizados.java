package Visual;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

public class VentanaEleccionColoresPersonalizados extends JFrame implements ActionListener{
    
    JButton estado1;
    JButton estado2;
    JButton estado3;
    JButton estado4;
    JButton estado5;
    

    public VentanaEleccionColoresPersonalizados() {
        initComponents();
        this.setSize(405, 250);
        this.setLocationRelativeTo(null);
    }
    
    private void initComponents(){
        this.estado1 = new JButton();
        this.estado2 = new JButton();
        this.estado3 = new JButton();
        this.estado4 = new JButton();
        this.estado5 = new JButton();
        
        getContentPane().setLayout(null);
        
        this.estado1.setBounds(10, 70, 70, 70);
        this.estado1.addActionListener(this);
        getContentPane().add(this.estado1);
        
        this.estado2.setBounds(85, 70, 70, 70);
        this.estado2.addActionListener(this);
        getContentPane().add(this.estado2);
        
        this.estado3.setBounds(160, 70, 70, 70);
        this.estado3.addActionListener(this);
        getContentPane().add(this.estado3);
        
        this.estado4.setBounds(235, 70, 70, 70);
        this.estado4.addActionListener(this);
        getContentPane().add(this.estado4);
        
        this.estado5.setBounds(310, 70, 70, 70);
        this.estado5.addActionListener(this);
        getContentPane().add(this.estado5);
        
        this.setVisible(true);
        
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.estado1 == e.getSource()){
            ColorChooser claseColorChooser = new ColorChooser();
        }else if(this.estado2 == e.getSource()){
            ColorChooser claseColorChooser = new ColorChooser();
        }else if(this.estado3 == e.getSource()){
            ColorChooser claseColorChooser = new ColorChooser();
        }else if(this.estado4 == e.getSource()){
            ColorChooser claseColorChooser = new ColorChooser();
        }else if(this.estado5 == e.getSource()){
            ColorChooser claseColorChooser = new ColorChooser();
        }
    }
    
}
