package Visual;

import Logica.EstadoDeAnimo;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DialogOpcionActualizar extends JDialog {
    
    private final int TAMANHO_BOTON = 50;
    private ArrayList <EstadoDeAnimo> estados;
    
    public DialogOpcionActualizar(Ventana ventana, boolean modal, JButton botonCalendario, int posicion) {
        super(ventana, modal);
        this.estados = ventana.getAnhoEnPixeles().getDetalles();
        initComponents(ventana, botonCalendario, posicion);
    }

    private void initComponents(Ventana ventana, JButton botonCalendario, int posicion) {
        this.setTitle("Escoge un color");
        this.setLocationRelativeTo(null);
        this.setSize(this.TAMANHO_BOTON * 5, this.TAMANHO_BOTON + 20);
        initButtons(ventana, botonCalendario, posicion);
    }

    private void initButtons(Ventana ventana, JButton botonCalendario, int posicion) {
        for (int i = 0; i < this.estados.size(); i++) {
            Container orden = getContentPane();
            orden.setLayout(null);
            JButton botonDeColor = crearBoton(i, estados.get(i).getColor());
            setListener(ventana, botonDeColor, botonCalendario, i, posicion);
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

    private void setListener(Ventana ventana, JButton botonDeColor, JButton botonARepresentar, int i, int posicion) {
        botonDeColor.addActionListener(
                (ActionEvent e) -> {
                    botonARepresentar.setContentAreaFilled(true);
                    botonARepresentar.setBackground(botonDeColor.getBackground()); 
                    ventana.getAnhoEnPixeles().actualizarCambioEnEstado(this.estados.get(i), posicion);
                    dispose();
                });
    }
}
