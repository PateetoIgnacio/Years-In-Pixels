package Visual;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelConfiguracion extends JPanel {

    public String rutaNueva;
    public final String RUTAPREDETERMINADA = "src/main/resources/fondoPanel.jpg";
    public Image fondo;

    public PanelConfiguracion(Ventana ventana) {
        this.rutaNueva = null;
        pintarComienzo();
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
            for (int columna = 1; columna < 3; columna++) {
                switch (fila) {
                    case 0:
                        initButton(columna, c, ventana);
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

    private void initButton(int opcion, GridBagConstraints c, Ventana ventana) {
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
                boton.setToolTipText("Cambia los colores de tus emoticones");
                setListenerColores(boton, ventana);
                break;
            case 2:
                boton.setText("Fondo");
                boton.setToolTipText("Cambiar la imagen del fondo");
                setListenerFondo(boton);
                break;
        }
        this.add(boton, c);
    }

    private JLabel crearLabelOpciones(int opcion) {
        JLabel jLabel = new JLabel();
        String texto;
        switch (opcion) {
            case 0:
                texto = "Cambia los colores de tus emoticones";
                break;
            default:
                texto = "Cambiar la imagen del fondo";
                break;
        }
        jLabel.setText(texto);
        jLabel.setFont(new Font("Noteworthy", 0, 17));
        return jLabel;
    }

    private void pintarComienzo() {
        if (this.rutaNueva == null) {
            this.rutaNueva = this.RUTAPREDETERMINADA;
        } else {
            this.updateUI();
        }
    }
    
    private void pintarPanel(String ruta){
        this.rutaNueva = ruta;
        this.updateUI();
    }
    
    public void paint(Graphics g) {
        this.fondo = new ImageIcon(this.rutaNueva).getImage();
        g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }

    private void setListenerColores(JButton boton, Ventana ventana) {
        boton.addActionListener(
                (ActionEvent e) -> {
                    VentanaEleccionColoresPersonalizados vEleccColores = new VentanaEleccionColoresPersonalizados(ventana);
                    vEleccColores.setVisible(true);
                }
        );
    }

    private void setListenerFondo(JButton boton) {
        boton.addActionListener(
                (ActionEvent e) -> {
                    buscarImagen();
                }
        );
    }
    
    private void buscarImagen(){
        JFileChooser jFileC = new JFileChooser();
        jFileC.showOpenDialog(this);
        File archivo = jFileC.getSelectedFile();
        if(archivo != null){
            this.rutaNueva = archivo.getAbsolutePath();
            pintarPanel(this.rutaNueva);
        }
    }
}
