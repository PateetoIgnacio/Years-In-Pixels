package Visual;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelConfiguracion extends JPanel {

    public JButton btnAjustarColores;
    public JButton btnAjustarNotificacion;
    public JButton btnEditarFondo;

    public PanelConfiguracion(Ventana ventana) {
        initComponents(ventana);
    }

    private void initComponents(Ventana ventana) {
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        JLabel label = crearJLabelTitulo();
        c = asignarParametrosParaTitulo(c);
        this.add(label, c);

        for (int fila = 0; fila < 2; fila++) {
            for (int columna = 1; columna <= 3; columna++) {
                switch (fila) {
                    case 0:
                        initButton(columna, c);
                        break;
                    default:
                        label = crearLabelOpciones(columna - 1);
                        c.anchor = GridBagConstraints.LINE_START;
                        c.gridx = 1;
                        c.gridy = columna;
                        this.add(label, c);
                        break;

                }
            }
        }

    }

    private JLabel crearJLabelTitulo() {
        JLabel jLabel = new JLabel();
        jLabel.setText("Personalizar");
        jLabel.setFont(new Font("Noteworthy", 0, 30));
        return jLabel;
    }

    private GridBagConstraints asignarParametrosParaTitulo(GridBagConstraints c) {
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.ipadx = 0;
        c.ipady = 100;
        c.weightx = 0.0;
        c.weighty = 0.0;
        return c;
    }

    private void initButton(int opcion, GridBagConstraints c) {

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = opcion;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        JButton boton = new JButton();
        switch (opcion) {
            case 1:
                boton.setText("Colores");
                break;
            case 2:
                boton.setText("Notificaciones");
                break;
            default:
                boton.setText("Fondo");
                break;

        }
        setListener(boton);
        this.add(boton);
    }

    private JLabel crearLabelOpciones(int opcion) {
        JLabel jLabel = new JLabel();
        String texto;
        switch (opcion) {
            case 0:
                texto = "Cambia los colores de tus emoticones";
                break;
            case 1:
                texto = "Activa/Desactiva, cambia la hora del recordatorio";
                break;
            default:
                texto = "Se siente vacío un fondo blanco, ¿no?";
                break;
        }
        jLabel.setText(texto);
        jLabel.setFont(new Font("Noteworthy", 0, 17));
        return jLabel;
    }

    private void setListener(JButton boton) {
        boton.addActionListener(
                (ActionEvent e) -> {
                    System.out.println("presionaste un botón");
                }
        );
    }

}
