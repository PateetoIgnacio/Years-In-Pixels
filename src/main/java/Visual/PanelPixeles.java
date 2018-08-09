package Visual;

import Logica.ControladorDeFecha;
import Logica.EstadoDeAnimo;
import Logica.TipoDeEstado;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPixeles extends JPanel {

    public PanelPixeles(Ventana ventana) {
        actualizarComponentes(ventana);
    }

    private void actualizarComponentes(Ventana ventana) {
        
        int diasDelMes = ventana.getAnhoEnPixeles().getDIAS_DEL_MES()+1;
        int mesesDelAnho = ventana.getAnhoEnPixeles().getMESES_DEL_ANHO()+1;
        GridLayout orden = new GridLayout(diasDelMes, mesesDelAnho);
        this.setLayout(orden);
        
        String [] meses = {"Ene","Feb","Mar","Abr","May","Jun",
                           "Jul","Ago","Sep","Oct","Nov","Dic"};
        
        System.out.println("La cantidad de elementos es "+ventana.getAnhoEnPixeles().cantidadDeElementos());
        int posicion = 0;
        for (int dia = 0; dia < diasDelMes; dia++) {
            for (int mes = 0; mes < mesesDelAnho; mes++) {
                if (dia > 0 && mes > 0) {
                    JButton boton = crearBoton();
                    EstadoDeAnimo estado = ventana.getAnhoEnPixeles().getEstadoEnLaFecha(dia, mes);
                    boton.setBackground(estado.getColor());
                    ControladorDeFecha control = new ControladorDeFecha();
                    if(estado.getTipo() == TipoDeEstado.SIN_ESPECIFICAR || !control.validarFechaFutura(dia+1, mes)) {
                        boton.setEnabled(false);
                    }
                    setListener(boton, ventana);
                    this.add(boton);
                    posicion++;
                }
                else if (dia > 0 && mes == 0){
                    this.add(new JLabel(String.valueOf(dia)));
                }
                else if (dia == 0 && mes > 0){
                    this.add(new JLabel(meses[mes-1]));
                }
                else {
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

    private void setListener(JButton boton, Ventana v) {
        boton.addActionListener(
                (ActionEvent e) -> {
                    DialogOpcionActualizar dialogo = new DialogOpcionActualizar(v, true, boton);
                    dialogo.setVisible(true);
                }
        );
    }
}
