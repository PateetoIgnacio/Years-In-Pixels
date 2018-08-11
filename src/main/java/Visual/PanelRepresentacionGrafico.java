package Visual;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class PanelRepresentacionGrafico {

    public PanelRepresentacionGrafico(int datos[][], String nombreMes, int numMes) {
        initComponents(datos, nombreMes, numMes);
    }

    private void initComponents(int datos[][] , String nombreMes, int numMes) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(datos[numMes][0], "feliz", "feliz");
        dataset.addValue(datos[numMes][1], "promedio", "promedio");
        dataset.addValue(datos[numMes][2], "cansado", "cansado");
        dataset.addValue(datos[numMes][3], "triste", "triste");
        dataset.addValue(datos[numMes][4], "enojado", "enojado");

        JFreeChart jf = ChartFactory.createBarChart3D("Datos de " + nombreMes, "Estados de animo",
                "Repeticiones", dataset, PlotOrientation.VERTICAL, true, true, true);

        ChartFrame f = new ChartFrame(nombreMes, jf);
        f.setSize(800, 600);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
