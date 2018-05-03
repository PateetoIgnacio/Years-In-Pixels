
package Visual;

import Logica.AnhoEnPixeles;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPixeles extends JPanel{
    private final int TAMANHO_BOTONES = 23;
    private AnhoEnPixeles ahnoPixeles = new AnhoEnPixeles();

    public PanelPixeles() { inicializarBotones(); }
    
    private void inicializarBotones() {
        GridLayout orden = new GridLayout(this.ahnoPixeles.getDIAS_DEL_MES(), this.ahnoPixeles.getMESES_DEL_ANHO());
        this.setLayout(orden);
        
        for(int dia = 1; dia <= this.ahnoPixeles.getDIAS_DEL_MES(); dia++) {
            for (int mes = 1; mes <= this.ahnoPixeles.getMESES_DEL_ANHO(); mes++) {
                JButton boton = crearBoton();
                if (this.ahnoPixeles.getControlador().validacionNegativa(dia, mes)) {
                    boton.setEnabled(false);
                }
                setListener(boton);
                this.add(boton);
            }
        }
    }
    private JButton crearBoton(){
        JButton boton = new JButton();
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setPreferredSize(new Dimension(this.TAMANHO_BOTONES, this.TAMANHO_BOTONES));
        boton.setFocusable(false);
        return boton;
        
    }
    private void setListener(JButton boton){
        boton.addActionListener(
                (ActionEvent e) -> {
                    DialogOpcionActualizar dialogPrueba = new DialogOpcionActualizar(null, true, boton);
                    dialogPrueba.setVisible(true);
                }
        );
    }
}