package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class VentanaEleccionColoresPersonalizados extends JFrame implements ActionListener{
    
    JButton estado1;
    JButton estado2;
    JButton estado3;
    JButton estado4;
    JButton estado5;
    
    private JLabel tituloSugerente;
    private JLabel tituloSug2;
    
    JButton btnAplicar;
    JButton btnCancelar;

    public VentanaEleccionColoresPersonalizados() {
        initComponents();
    }
    
    private void initComponents(){
        this.estado1 = new JButton();
        this.estado2 = new JButton();
        this.estado3 = new JButton();
        this.estado4 = new JButton();
        this.estado5 = new JButton();
        this.tituloSugerente = new JLabel("Presiona un botón");
        this.tituloSug2 = new JLabel("para cambiarle el color");
        this.btnAplicar = new JButton("Aplicar");
        this.btnCancelar = new JButton("Cancelar");

        getContentPane().setLayout(null);
        
        this.tituloSugerente.setBounds(100, 20, 200, 40);
        this.tituloSugerente.setFont(new Font("Elianto", 0, 20));
        getContentPane().add(this.tituloSugerente);
        
        this.tituloSug2.setBounds(70, 40, 250, 40);
        this.tituloSug2.setFont(new Font("Elianto", 0, 20));
        getContentPane().add(this.tituloSug2);
        
        this.estado1.setBounds(10, 100, 70, 70);
        this.estado1.setToolTipText("Vivo, activo, feliz, energético, motivado, productivo");
        this.estado1.addActionListener(this);
        getContentPane().add(this.estado1);
        
        this.estado2.setBounds(85, 100, 70, 70);
        this.estado2.setToolTipText("Sin eventos, promedio, normal");
        this.estado2.addActionListener(this);
        getContentPane().add(this.estado2);
        
        this.estado3.setBounds(160, 100, 70, 70);
        this.estado3.setToolTipText("Enfermo, cansando, desmotivado, aburrido, perezoso");
        this.estado3.addActionListener(this);
        getContentPane().add(this.estado3);
        
        this.estado4.setBounds(235, 100, 70, 70);
        this.estado4.setToolTipText("Triste, solitario, deprimido, inseguro, deprimido");
        this.estado4.addActionListener(this);
        getContentPane().add(this.estado4);
        
        this.estado5.setBounds(310, 100, 70, 70);
        this.estado5.setToolTipText("Enojado, frustrado, irritable, molesto, gruñón");
        this.estado5.addActionListener(this);
        getContentPane().add(this.estado5);
        
        
        this.btnAplicar.setBounds(100, 300, 90, 30);
        this.btnAplicar.addActionListener(this);
        getContentPane().add(this.btnAplicar);
        
        this.btnCancelar.setBounds(200, 300, 90, 30);
        this.btnCancelar.addActionListener(this);
        getContentPane().add(this.btnCancelar);
        
        this.setVisible(true);
        this.setSize(405, 400);
        this.setLocationRelativeTo(null);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.estado1 == e.getSource()){
            ColorChooser claseColorChooser = new ColorChooser(estado1);
        }else if(this.estado2 == e.getSource()){
            ColorChooser claseColorChooser = new ColorChooser(estado2);
        }else if(this.estado3 == e.getSource()){
            ColorChooser claseColorChooser = new ColorChooser(estado3);
        }else if(this.estado4 == e.getSource()){
            ColorChooser claseColorChooser = new ColorChooser(estado4);
        }else if(this.estado5 == e.getSource()){
            ColorChooser claseColorChooser = new ColorChooser(estado5);
        }else if(this.btnAplicar == e.getSource()){
            //Hacer cambios ---
            this.dispose();
        }
    }
    
}
