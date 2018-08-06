package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorChooser extends JFrame implements ChangeListener, ActionListener {

    JColorChooser color;

    public ColorChooser() {
        this.color = new JColorChooser();
        this.color.setMaximumSize(new Dimension(100, 100));
        this.setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(this.color, BorderLayout.CENTER);
        this.setVisible(true);
        pack();
    }

    @Override
    public void changed(ObservableValue ov, Object t, Object t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
