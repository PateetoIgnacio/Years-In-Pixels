
package Visual;

import Logica.AnhoEnPixeles;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{
    private final int MEDIDA_EN_X = 750; //Width
    private final int MEDIDA_EN_Y = 750; //Height
    private Dimension dimension;
    private PanelActualizarEstado panelActualizarEstado;
    private PanelPixeles panelPixeles;
    private AnhoEnPixeles anhoEnPixeles = new AnhoEnPixeles();
    private Probando probando = new Probando(this);
    
    public Ventana(){
        initComponents();
    }
    
    private void initComponents(){

        this.panelActualizarEstado = new PanelActualizarEstado(this);

        this.panelPixeles = new PanelPixeles();
        this.panelPixeles.setBackground(Color.BLACK);
        
        this.panelActualizarEstado = new PanelActualizarEstado(this);
        this.add(this.panelActualizarEstado);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(50, 0);
        this.setVisible(true);
    }
    public int getMEDIDA_EN_X(){
        return this.MEDIDA_EN_X;
    }
    public int getMEDIDA_EN_Y(){
        return this.MEDIDA_EN_Y;
    }
    public AnhoEnPixeles getAnhoEnPixeles(){
        return this.anhoEnPixeles;
    }
}
