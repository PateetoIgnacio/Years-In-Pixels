package Visual;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelOpcionesDeGrafico extends JPanel {

    private String[] nombreMeses = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };
    private JButton[] botonesMeses;
    private int estadisticas[][];
    private int mesesValidos;
    private int idUsuarioARepresentar;

    public String rutaNueva;
    public final String RUTAPREDETERMINADA = "src/main/resources/fondoPanel.jpg";
    public Image fondo;

    public PanelOpcionesDeGrafico(Ventana ventana) {
        this.idUsuarioARepresentar = ventana.getAnhoEnPixeles().getIndiceUsuarioRepresentado();
        this.estadisticas = ventana.getAnhoEnPixeles().getUsuarioDeLaLista(this.idUsuarioARepresentar).getEstadisticasMensuales();
        this.botonesMeses = new JButton[ventana.getAnhoEnPixeles().getMESES_DEL_ANHO()];
        this.mesesValidos = ventana.getAnhoEnPixeles().getMesesTranscurridos();
        this.rutaNueva = null;
        pintarComienzo();
        initComponents();
    }

    private void initComponents() {
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel titulo = initJLabelTitulo();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.ipadx = 0;
        c.ipady = 70;
        c.weightx = 0.0;
        this.add(titulo, c);

        inicializarArregloBotones();

        c.fill = GridBagConstraints.CENTER;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.ipady = 10;
        int mes = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                c.gridx = j;
                c.gridy = i;
                if (mes >= this.mesesValidos) {
                    this.botonesMeses[mes].setEnabled(false);
                }
                setListener(this.botonesMeses[mes], this.estadisticas, mes);
                this.add(this.botonesMeses[mes], c);
                mes++;
            }
        }

    }

    private void setListener(JButton boton, int[][] datos, int mesAEvaluar) {

        boton.addActionListener((ActionEvent e) -> {
            PanelRepresentacionGrafico representacion = new PanelRepresentacionGrafico(this.estadisticas, boton.getText(), mesAEvaluar);
        });
    }

    private JLabel initJLabelTitulo() {
        String titulo = "Selecciona un mes";
        JLabel label = new JLabel(titulo);
        label.setFont(new Font("Noteworthy", 0, 30));
        return label;
    }

    private void pintarComienzo() {
        if (this.rutaNueva == null) {
            this.rutaNueva = this.RUTAPREDETERMINADA;
        } else {
            this.updateUI();
        }
    }

    public void pintarPanel(String ruta) {
        this.rutaNueva = ruta;
        this.updateUI();
    }

    public void paint(Graphics g) {
        this.fondo = new ImageIcon(this.rutaNueva).getImage();
        g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }

    private void inicializarArregloBotones() {
        JButton boton = new JButton();
        for (int mes = 0; mes < this.botonesMeses.length; mes++) {
            boton.setText(this.nombreMeses[mes]);
            boton.setFont(new Font("Noteworthy", 0, 15));
            this.botonesMeses[mes] = boton;
        }
    }

}
