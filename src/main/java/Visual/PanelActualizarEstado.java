package Visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelActualizarEstado extends JPanel {

    private final int TAMANHO_BOTON = 50;
    private JButton[] botonesDeColor;
    
    public String rutaNueva;
    public final String RUTAPREDETERMINADA = "src/main/resources/fondoPanel.jpg";
    public Image fondo;

    public PanelActualizarEstado(Ventana ventana) {
        this.rutaNueva = null;
        pintarComienzo();
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
                        c.anchor = GridBagConstraints.CENTER;
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
        boton.setBackground(v.getAnhoEnPixeles().getDetalleEstado(indice).getColor());
        switch (indice){
            case 0:
                boton.setToolTipText("Vivo, activo, feliz, energético, motivado, productivo");
                break;
            case 1:
                boton.setToolTipText("Sin eventos, promedio, normal");
                break;
            case 2:
                boton.setToolTipText("Enfermo, cansando, desmotivado, aburrido, perezoso");
                break;
            case 3:
                boton.setToolTipText("Triste, solitario, deprimido, inseguro, deprimido");
                break;
            case 4:
                boton.setToolTipText("Enojado, frustrado, irritable, molesto, gruñón");
                break;
        }
        boton.setSize(new Dimension(this.TAMANHO_BOTON, this.TAMANHO_BOTON));
        return boton;
    }
    
    private JLabel crearLabelOpcion(int opcion) {
        JLabel label = new JLabel();
        String texto;
        switch (opcion) {
            case 0:
                label.setIcon(new ImageIcon(getClass().getResource("/feliz.png")));
                label.setToolTipText("Vivo, activo, feliz, energético, motivado, productivo");
                break;
            case 1:
                label.setIcon(new ImageIcon(getClass().getResource("/normal.png")));
                label.setToolTipText("Sin eventos, promedio, normal");
                break;
            case 2:
                label.setIcon(new ImageIcon(getClass().getResource("/enfermo.png")));
                label.setToolTipText("Enfermo, cansando, desmotivado, aburrido, perezoso");
                break;
            case 3:
                label.setIcon(new ImageIcon(getClass().getResource("/triste.png")));
                label.setToolTipText("Triste, solitario, deprimido, inseguro, deprimido");
                break;
            default:
                label.setIcon(new ImageIcon(getClass().getResource("/enojado.png")));
                label.setToolTipText("Enojado, frustrado, irritable, molesto, gruñón");
                break;
        }
        return label;
    }

    private void setListener(JButton boton, int i) {
        boton.addActionListener(
                (ActionEvent e) -> {
                    boton.setEnabled(true);
                }
        );
    }
    private void pintarComienzo(){
        if(this.rutaNueva == null){
            this.rutaNueva = this.RUTAPREDETERMINADA;
        }else
            this.updateUI();
    }
    
    @Override
    public void paint(Graphics g){
        this.fondo = new ImageIcon(this.rutaNueva).getImage();
        g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }

}