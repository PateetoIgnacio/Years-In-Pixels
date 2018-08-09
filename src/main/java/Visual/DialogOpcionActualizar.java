package Visual;

import Logica.EstadoDeAnimo;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;

public class DialogOpcionActualizar extends JDialog {

    private final int TAMANHO_BOTON = 50;

    public DialogOpcionActualizar(Ventana ventana, boolean modal, JButton botonCalendario) {
        super(ventana, modal);
        initComponents(ventana, botonCalendario);
    }

    private void initComponents(Ventana ventana, JButton botonCalendario) {
        this.setTitle("Escoge un color");
        this.setLocationRelativeTo(null);
        this.setSize(this.TAMANHO_BOTON * 5, this.TAMANHO_BOTON + 20);
        initButtons(ventana, botonCalendario);
    }

    private void initButtons(Ventana ventana, JButton botonCalendario) {
        EstadoDeAnimo estado1 = ventana.getAnhoEnPixeles().getEstado(0);
        EstadoDeAnimo estado2 = ventana.getAnhoEnPixeles().getEstado(1);
        EstadoDeAnimo estado3 = ventana.getAnhoEnPixeles().getEstado(2);
        EstadoDeAnimo estado4 = ventana.getAnhoEnPixeles().getEstado(3);
        EstadoDeAnimo estado5 = ventana.getAnhoEnPixeles().getEstado(4);
        
        Color[] arregloColores = {estado1.getColor(), estado2.getColor(), 
            estado3.getColor(), estado4.getColor(), estado5.getColor()};
        for (int i = 0; i < arregloColores.length; i++) {
            Container orden = getContentPane();
            orden.setLayout(null);
            JButton botonDeColor = crearBoton(i, arregloColores[i]);
            setListener(botonDeColor, botonCalendario);
            orden.add(botonDeColor);
        }
    }

    private JButton crearBoton(int i, Color color) {
        JButton botonDeColor = new JButton();
        botonDeColor.setBackground(color);
        botonDeColor.setSize(TAMANHO_BOTON, TAMANHO_BOTON);
        botonDeColor.setLocation(TAMANHO_BOTON * i, 0);
        return botonDeColor;
    }

    private void setListener(JButton botonDeColor, JButton botonARepresentar) {
        botonDeColor.addActionListener(
                (ActionEvent e) -> {
                    botonARepresentar.setContentAreaFilled(true);
                    botonARepresentar.setBackground(botonDeColor.getBackground());

                    dispose();
                });
    }
}
