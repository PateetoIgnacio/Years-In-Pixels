package Visual;

import Logica.EstadoDeAnimo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class VentanaEleccionColoresPersonalizados extends JFrame implements ActionListener{
    
    JButton estado1;
    JButton estado2;
    JButton estado3;
    JButton estado4;
    JButton estado5;
    
    private JLabel lblFeliz;
    private JLabel lblNormal;
    private JLabel lblEnfermo;
    private JLabel lblTriste;
    private JLabel lblEnojado;
    
    private JLabel tituloSugerente;
    private JLabel tituloSug2;
    
    JButton btnAplicar;
    JButton btnCancelar;

    public VentanaEleccionColoresPersonalizados(Ventana ventana) {
        initComponents(ventana);
    }
    
    private void initComponents(Ventana ventana){
        this.estado1 = new JButton();
        this.estado2 = new JButton();
        this.estado3 = new JButton();
        this.estado4 = new JButton();
        this.estado5 = new JButton();
        this.tituloSugerente = new JLabel("Presiona un botón");
        this.tituloSug2 = new JLabel("para cambiarle el color");
        this.btnAplicar = new JButton("Aplicar");
        this.btnCancelar = new JButton("Cancelar");
        this.lblFeliz = new JLabel();
        this.lblNormal = new JLabel();
        this.lblEnfermo = new JLabel();
        this.lblTriste = new JLabel();
        this.lblEnojado = new JLabel();
        
        EstadoDeAnimo estadoAux = null;
        Color colorAux = null;
        
        getContentPane().setLayout(null);
        
        this.tituloSugerente.setBounds(100, 20, 200, 40);
        this.tituloSugerente.setFont(new Font("Elianto", 0, 20));
        getContentPane().add(this.tituloSugerente);
        
        this.tituloSug2.setBounds(70, 40, 250, 40);
        this.tituloSug2.setFont(new Font("Elianto", 0, 20));
        getContentPane().add(this.tituloSug2);
        //-------------------------------------------------------------------------------------------
        estadoAux = ventana.getAnhoEnPixeles().getDetalleEstado(0);
        colorAux = estadoAux.getColor();
        this.estado1.setBackground(colorAux);
        this.estado1.setBounds(10, 100, 70, 70);
        this.estado1.setToolTipText("Vivo, activo, feliz, energético, motivado, productivo");
        this.estado1.addActionListener(this);
        getContentPane().add(this.estado1);
        
        this.lblFeliz.setIcon(new ImageIcon(getClass().getResource("/feliz.png")));
        this.lblFeliz.setBounds(10, 190, 64, 64);
        getContentPane().add(this.lblFeliz);
        //--------------------------------------------------------------------------------------------
        estadoAux = ventana.getAnhoEnPixeles().getDetalleEstado(1);
        colorAux = estadoAux.getColor();
        this.estado2.setBackground(colorAux);
        this.estado2.setBounds(85, 100, 70, 70);
        this.estado2.setToolTipText("Sin eventos, promedio, normal");
        this.estado2.addActionListener(this);
        getContentPane().add(this.estado2);
        
        this.lblNormal.setIcon(new ImageIcon(getClass().getResource("/normal.png")));
        this.lblNormal.setBounds(85, 190, 64, 64);
        getContentPane().add(this.lblNormal);
        //--------------------------------------------------------------------------------------------
        estadoAux = ventana.getAnhoEnPixeles().getDetalleEstado(2);
        colorAux = estadoAux.getColor();
        this.estado3.setBackground(colorAux);
        this.estado3.setBounds(160, 100, 70, 70);
        this.estado3.setToolTipText("Enfermo, cansando, desmotivado, aburrido, perezoso");
        this.estado3.addActionListener(this);
        getContentPane().add(this.estado3);
        
        this.lblEnfermo.setIcon(new ImageIcon(getClass().getResource("/enfermo.png")));
        this.lblEnfermo.setBounds(160, 190, 64, 64);
        getContentPane().add(this.lblEnfermo);
        //--------------------------------------------------------------------------------------------
        estadoAux = ventana.getAnhoEnPixeles().getDetalleEstado(3);
        colorAux = estadoAux.getColor();
        this.estado4.setBackground(colorAux);
        this.estado4.setBounds(235, 100, 70, 70);
        this.estado4.setToolTipText("Triste, solitario, deprimido, inseguro, deprimido");
        this.estado4.addActionListener(this);
        getContentPane().add(this.estado4);
        
        this.lblTriste.setIcon(new ImageIcon(getClass().getResource("/triste.png")));
        this.lblTriste.setBounds(235, 190, 64, 64);
        getContentPane().add(this.lblTriste);
        //--------------------------------------------------------------------------------------------
        estadoAux = ventana.getAnhoEnPixeles().getDetalleEstado(4);
        colorAux = estadoAux.getColor();
        this.estado5.setBackground(colorAux);
        this.estado5.setBounds(310, 100, 70, 70);
        this.estado5.setToolTipText("Enojado, frustrado, irritable, molesto, gruñón");
        this.estado5.addActionListener(this);
        getContentPane().add(this.estado5);
        
        this.lblEnojado.setIcon(new ImageIcon(getClass().getResource("/enojado.png")));
        this.lblEnojado.setBounds(310, 190, 64, 64);
        getContentPane().add(this.lblEnojado);
        //--------------------------------------------------------------------------------------------
        this.btnAplicar.setBounds(100, 300, 90, 30);
        setListenerAplicar(ventana, this.btnAplicar);
        getContentPane().add(this.btnAplicar);
        
        this.btnCancelar.setBounds(200, 300, 90, 30);
        this.btnCancelar.addActionListener(this);
        getContentPane().add(this.btnCancelar);
        
        pack();
        this.setSize(405, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.estado1 == e.getSource()){
            FrameColorChooser claseColorChooser = new FrameColorChooser(estado1);
        }else if(this.estado2 == e.getSource()){
            FrameColorChooser claseColorChooser = new FrameColorChooser(estado2);
        }else if(this.estado3 == e.getSource()){
            FrameColorChooser claseColorChooser = new FrameColorChooser(estado3);
        }else if(this.estado4 == e.getSource()){
            FrameColorChooser claseColorChooser = new FrameColorChooser(estado4);
        }else if(this.estado5 == e.getSource()){
            FrameColorChooser claseColorChooser = new FrameColorChooser(estado5);
        }else if(this.btnCancelar == e.getSource()){
            this.dispose();
        }
    }
    
    public void setListenerAplicar(Ventana ventana, JButton btnPresionado) {
        btnPresionado.addActionListener(
                (ActionEvent e) -> {
                    Color colores [] = new Color[5];
                    colores[0] = this.estado1.getBackground();
                    colores[1] = this.estado2.getBackground();
                    colores[2] = this.estado3.getBackground();
                    colores[3] = this.estado4.getBackground();
                    colores[4] = this.estado5.getBackground();
                    ventana.getAnhoEnPixeles().reasigarColoresDeEstados(colores);
                    this.dispose();
                }
        );
    }
    
}
