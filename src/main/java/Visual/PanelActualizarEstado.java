package Visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelActualizarEstado extends JPanel {

    private final int TAMANHO_BOTON = 50;
    private JButton[] botonesDeColor;

    public PanelActualizarEstado(Ventana ventana) {
        initComponents(ventana);
    }

    private void initComponents(Ventana ventana) {
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel titulo = initJLabelTitulo();

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        
        c.gridwidth = 2;
        c.gridheight = 1;
        
        c.ipadx = 0;
        c.ipady = 150;
        
        c.weightx = 0.0;
        this.add(titulo, c);
        
        inicializarArregloDeBotones(ventana);

        int cantidadDeItem = 2;
        for (int opcion = 0; opcion < this.botonesDeColor.length; opcion++) {
            for (int item = 0; item < cantidadDeItem; item++) {
                c.fill = GridBagConstraints.NONE;
                c.gridx = item;
                c.gridy = opcion + 1;
                c.gridwidth = 1;
                c.gridheight = 1;
                c.ipadx = 0;
                c.ipady = 25;
                c.weightx = 1.0;

                switch (item) {
                    case 0:
                         c.anchor = GridBagConstraints.CENTER;
                        this.botonesDeColor[opcion] = crearBoton(ventana, opcion);
                        setListener(botonesDeColor[opcion], opcion);
                        this.add(this.botonesDeColor[opcion], c);
                        break;
                    case 1:
                        c.anchor = GridBagConstraints.LINE_START;
                        JLabel label = crearLabelOpcion(opcion);
                        this.add(label, c);
                        break;
                }
            }
        }
    }

    private JLabel initJLabelTitulo() {
        JLabel label = new JLabel("¿Cómo estuviste hoy?");
        label.setFont(new Font("Noteworthy", 0, 30));
        return label;
    }

    private void inicializarArregloDeBotones(Ventana v) {
        int cantidadDeEstados = v.getAnhoEnPixeles().getCANTIDAD_DE_ESTADOS(); //no se considera el SIN_ESPECIFICAR
        this.botonesDeColor = new JButton[cantidadDeEstados];
    }
    
    private JButton crearBoton(Ventana v, int indice) {
        JButton boton = new JButton();
        boton.setBackground(v.getAnhoEnPixeles().getEstado(indice).getColor());
        boton.setSize(new Dimension(this.TAMANHO_BOTON, this.TAMANHO_BOTON));
        return boton;
    }
    
    private JLabel crearLabelOpcion(int opcion) {
        JLabel label = new JLabel();
        String texto;
        switch (opcion) {
            case 0:
                texto = "Vivo. activo. feliz. energético. motivado. productivo";
                break;
            case 1:
                texto = "Sin eventos. promedio. normal";
                break;
            case 2:
                texto = "Enfermo. cansando. desmotivado. aburrido. perezoso";
                break;
            case 3:
                texto = "Triste. solitario. deprimido. inseguro. deprimido";
                break;
            default:
                texto = "Enojado. frustrado. irritable. molesto. gruñón";
                break;
        }
        label.setText(texto);
        label.setFont(new Font("Noteworthy", 0, 17));
        return label;
    }

    private void setListener(JButton boton, int i) {
        boton.addActionListener(
                (ActionEvent e) -> {
                    boton.setEnabled(true);
                }
        );
    }


}