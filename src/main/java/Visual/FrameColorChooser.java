package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameColorChooser extends JFrame implements ChangeListener, ActionListener {

    private JColorChooser color;
    private JButton btnEstablecer;
    private JButton btnSeleccionado;
    private JButton btnCancelar;

    public FrameColorChooser(JButton btnSeleccionado) {
        this.btnSeleccionado = btnSeleccionado;
        this.color = new JColorChooser();
        this.iniComponents();
    }

    private void iniComponents() {
//        jcc.getSelectionModel().addChangeListener(this.getListeners());
        
        this.setLayout(new BorderLayout());
        this.add(color, BorderLayout.CENTER);
        
        JPanel botones = new JPanel(new FlowLayout());
        
        this.btnEstablecer = new JButton("Establecer");
        this.btnEstablecer.setBackground(Color.LIGHT_GRAY);
        this.btnEstablecer.addActionListener(this);
        
        this.btnCancelar = new JButton("Cancelar");
        this.btnCancelar.addActionListener(this);
        this.btnCancelar.setBackground(Color.LIGHT_GRAY);
        
        
        botones.add(this.btnEstablecer);
        botones.add(this.btnCancelar);
        
        
        this.add(botones, BorderLayout.SOUTH);
        color.setMaximumSize(new Dimension(100,100));
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Cambiar Color");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void changed(ObservableValue ov, Object t, Object t1) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.btnCancelar == e.getSource()) {
            this.dispose();
        }
        if (this.btnEstablecer == e.getSource()) {
            this.btnSeleccionado.setBackground(color.getColor());
            this.dispose();
        }
    }

}
