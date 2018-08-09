package Visual;

import Logica.AnhoEnPixeles;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelOpcionesDeGrafico extends JPanel {

    private String[] nombreMeses = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };
    private JButton meses[];

    /* se guardaran la cantidad de veces un estado fue escogido (dato mensual) */
    private int[] datosPrueba;
    private int mesesValidos;

    public PanelOpcionesDeGrafico(int cantidad, AnhoEnPixeles anhoEnPixeles) {
        this.datosPrueba = new int[cantidad];
        this.mesesValidos = anhoEnPixeles.getMesesTranscurridos();
        this.meses = new JButton[12];
        inicializarArreglo();
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
        c.ipady = 50;
        c.weightx = 0.0;
        this.add(titulo, c);

        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.ipady = 0;
        int mes = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < 3; j++) {
                c.gridx = j;
                c.gridy = i;
                if (mes >= mesesValidos) {
                    this.meses[mes].setEnabled(false);
                }
                this.add(this.meses[mes], c);
                mes++;
            }
        }

    }

    private void inicializarArreglo() {
        for (int i = 0; i < 12; i++) {
            this.meses[i] = new JButton(nombreMeses[i]);
            setListener(this.meses[i], this.nombreMeses[i]);
        }
    }

    private void setListener(JButton boton, String mes) {
        boton.addActionListener(
                (ActionEvent e) -> {
                    generarDatosRandom(this.datosPrueba.length);
                    if (this.mesesValidos > 1) {
                        PanelRepresentacionGrafico rep = new PanelRepresentacionGrafico(this.datosPrueba, mes);
                    }
                }
        );
    }

    private JLabel initJLabelTitulo() {
        String titulo = "Selecciona un mes";
        JLabel label = new JLabel(titulo);
        label.setFont(new Font("Noteworthy", 0, 30));
        return label;
    }

    private void generarDatosRandom(int cantEstados) {
        Random random = new Random();
        for (int i = 0; i < cantEstados; i++) {
            /* numeros arbitrarios mas que nada para probar los graficos 
               evidentemente no se ajustan a las posibilidades reales 
             */
            this.datosPrueba[i] = random.nextInt(10 + 1) + 1;
        }
    }
}
