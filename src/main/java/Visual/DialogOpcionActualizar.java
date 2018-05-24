package Visual;

import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;

public class DialogOpcionActualizar extends JDialog {

    private final int TAMANHO_BOTON = 60;

    public DialogOpcionActualizar(Frame frame, boolean modal, JButton botonCalendario) {
        super(frame, modal);
        initComponents(botonCalendario);
    }

    private void initComponents(JButton botonCalendario) {
        this.setTitle("Escoge un color");
        this.setLocationRelativeTo(null);
        this.setSize(this.TAMANHO_BOTON * 5, this.TAMANHO_BOTON + 20);
        initButtons(botonCalendario);
    }

    private void initButtons(JButton botonCalendario) {
        Color[] arregloColores = {Color.yellow, Color.green, Color.blue, Color.orange, Color.red};
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
