package Visual;

import Logica.ControladorDeFecha;
import Logica.EstadoDeAnimo;
import Logica.TipoDeEstado;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPixeles extends JPanel {

    public String rutaNueva;
    public final String RUTAPREDETERMINADA = "src/main/resources/fondoPanel.jpg";
    public Image fondo;

    public PanelPixeles(Ventana ventana) {
        this.rutaNueva = null;
        this.pintarComienzo();
        initComponents(ventana);
    }

    private void initComponents(Ventana ventana) {

        int diasDelMes = ventana.getAnhoEnPixeles().getDIAS_DEL_MES() + 1;
        int mesesDelAnho = ventana.getAnhoEnPixeles().getMESES_DEL_ANHO() + 1;
        GridLayout orden = new GridLayout(diasDelMes, mesesDelAnho);
        this.setLayout(orden);

        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun",
            "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};

        int posicion = 0;
        for (int dia = 0; dia < diasDelMes; dia++) {
            for (int mes = 0; mes < mesesDelAnho; mes++) {
                if (dia > 0 && mes > 0) {
                    JButton boton = crearBoton();
                    EstadoDeAnimo estado = ventana.getAnhoEnPixeles().getEstadoEnLaFecha(dia, mes);
                    boton.setBackground(estado.getColor());
                    ControladorDeFecha control = new ControladorDeFecha();
                    /*f (estado.getTipo() == TipoDeEstado.SIN_ESPECIFICAR && ) {
                        boton.setEnabled(false);
                    }*/
                    if (ventana.getAnhoEnPixeles().getUsuarioEsNuevo()) {
                        if (control.validarFechaPasada(dia + 6, mes)) {
                            boton.setEnabled(false);
                        } else if (control.validarFechaFutura(dia + 1, mes)) {
                            boton.setEnabled(false);
                        } else {
                            setListener(boton, ventana, posicion);
                        }
                    } else {
                        if (estado.getTipo() == TipoDeEstado.SIN_ESPECIFICAR) {
                            boton.setEnabled(false);
                        } else {
                            setListener(boton, ventana, posicion);
                        }
                    }
                    //System.out.println(estado.toString());
                    this.add(boton);
                    posicion++;
                } else if (dia > 0 && mes == 0) {
                    this.add(new JLabel(String.valueOf(dia)));
                } else if (dia == 0 && mes > 0) {
                    this.add(new JLabel(meses[mes - 1]));
                } else {
                    this.add(new JLabel(""));
                }

            }
        }
    }

    private JButton crearBoton() {
        JButton boton = new JButton();
        boton.setFocusPainted(true);
        boton.setContentAreaFilled(true);
        boton.setFocusable(true);
        return boton;

    }

    private void pintarComienzo() {
        if (this.rutaNueva == null) {
            this.rutaNueva = this.RUTAPREDETERMINADA;
        } else {
            this.updateUI();
        }
    }

    @Override
    public void paint(Graphics g) {
        this.fondo = new ImageIcon(this.rutaNueva).getImage();
        g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }

    private void setListener(JButton boton, Ventana v, int posicion) {
        boton.addActionListener(
                (ActionEvent e) -> {
                    DialogOpcionActualizar dialogo = new DialogOpcionActualizar(v, true, boton, posicion);
                    dialogo.setVisible(true);
                }
        );
    }
}
