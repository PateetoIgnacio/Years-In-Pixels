package Visual;

import javax.swing.*;
import java.awt.*;

public class Probando extends JPanel {
    private JLabel textoTitulo;
    private JButton boton;
    private JButton boton2;

    public Probando(JFrame ventana){
        initComponents(ventana);
    }

    private void initComponents(JFrame ventana) {

        GridBagLayout distro = new GridBagLayout();
        this.setLayout(distro);
        
      
    }

    private void initLabelTitulo() {
        String textoTitulo = "¿Como estuviste hoy?";
        this.textoTitulo = new JLabel();
        this.textoTitulo.setText(textoTitulo);
    }

    private void initBoton(){
        String tct = "Opción";
        this.boton = new JButton(tct);
        this.setPreferredSize(new Dimension (50, 50));
    }
}
