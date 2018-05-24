package Visual;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class PanelRepresentacionGrafico {

    public PanelRepresentacionGrafico(int datos[], String mes) {
        initComponents(datos, mes);
    }

    private void initComponents(int datos[], String mes) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(datos[0], "feliz", "feliz");
        dataset.addValue(datos[1], "promedio", "promedio");
        dataset.addValue(datos[2], "cansado", "cansado");
        dataset.addValue(datos[3], "triste", "triste");
        dataset.addValue(datos[4], "enojado", "enojado");

        JFreeChart jf = ChartFactory.createBarChart3D("Datos de " + mes, "Estados de animo",
                "Repeticiones", dataset, PlotOrientation.VERTICAL, true, true, true);

        ChartFrame f = new ChartFrame(mes, jf);
        f.setSize(800, 600);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
