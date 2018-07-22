package Visual;

import Logica.EstadoDeAnimo;
import Logica.TipoDeEstado;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPixeles extends JPanel {

    public PanelPixeles(Ventana ventana) {
        initComponents(ventana);
    }

    private void initComponents(Ventana ventana) {

        int diasDelMes = ventana.getAnhoEnPixeles().getDIAS_DEL_MES()+1;
        int mesesDelAnho = ventana.getAnhoEnPixeles().getMESES_DEL_ANHO()+1;
        GridLayout orden = new GridLayout(diasDelMes, mesesDelAnho);
        this.setLayout(orden);
        
        String [] meses = {"Ene","Feb","Mar","Abr","May","Jun",
                           "Jul","Ago","Sep","Oct","Nov","Dic"};
        
        for (int dia = 0; dia < diasDelMes; dia++) {
            for (int mes = 0; mes < mesesDelAnho; mes++) {
                if (dia > 0 && mes > 0) {
                    JButton boton = crearBoton();
                    EstadoDeAnimo estado = ventana.getAnhoEnPixeles().getEstadoEnLaFecha(dia-1, mes-1);
                    boton.setBackground(estado.getColor());
                    if(estado.getTipo() == TipoDeEstado.SIN_ESPECIFICAR) {
                        boton.setEnabled(false);
                    }
                    setListener(boton);
                    this.add(boton);
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
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setFocusable(false);
        return boton;

    }

    private void setListener(JButton boton) {
        boton.addActionListener(
                (ActionEvent e) -> {
                    DialogOpcionActualizar dialogo = new DialogOpcionActualizar(null, true, boton);
                    dialogo.setVisible(true);
                }
        );
    }
}
