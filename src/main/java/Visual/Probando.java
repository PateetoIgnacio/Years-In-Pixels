package Visual;

import javax.swing.*;
import java.awt.*;

public class Probando extends JPanel {
    private JLabel textoTitulo;
    private JButton boton;

    public Probando(JFrame ventana){
        initComponents(ventana);
    }

    private void initComponents(JFrame ventana) {

        GridBagLayout distro;
        distro = new GridBagLayout();

        this.setLayout(distro);

        JPanel panel = new JPanel();
        Dimension dimensionPanel = ventana.getPreferredSize();
        panel.setPreferredSize(dimensionPanel);
        panel.setBackground(Color.pink);
/*

        JPanel panelAux = new JPanel();
        panelAux.setPreferredSize(new Dimension((int) dimensionPanel.getWidth()/2,(int) dimensionPanel.getHeight()/2));
        panelAux.setBackground(Color.black);

        JButton boton = new JButton("botón");
        panelAux.add(boton);
        boton.setLocation(250, 250);
*/
        this.add(panel);

        System.out.println("Las medidas son: "+ventana.getPreferredSize() );

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
