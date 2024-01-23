package graphtabelfile;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class MakeGraph extends JPanel{
    public MakeGraph(double xMin, double xMax, int n){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String str = "Integrals of "+MyFunc.getMyFuncStr();
        String series1 = "точно";
        String series2 = "численно";
        double y = MyFunc.getMyIntegr(xMin, xMax);
        dataset.addValue(y, series1, "Integer");
        
        y = new Integr_cr().integr(xMin,xMax,n);
        dataset.addValue(y, series2, "cr");
        y = new Integr_lt().integr(xMin,xMax,n);
        dataset.addValue(y, series2, "lt");
        y = new Integr_rt().integr(xMin,xMax,n);
        dataset.addValue(y, series2, "rt");
        y = new Integr_tr().integr(xMin,xMax,n);
        dataset.addValue(y, series2, "tr");
        y = new Integr_simp().integr(xMin,xMax,n);
        dataset.addValue(y, series2, "simp");
        y = new Integr_38().integr(xMin,xMax,n);
        dataset.addValue(y, series2, "3/8");
        y = new Integr_gauss1().integr(xMin,xMax,n);
        dataset.addValue(y, series2, "gauss1");
        y = new Integr_gauss2().integr(xMin,xMax,n);
        dataset.addValue(y, series2, "gauss2");
        y = new Integr_gauss3().integr(xMin,xMax,n);
        dataset.addValue(y, series2, "gauss3");
        
        JFreeChart chart = ChartFactory.createBarChart(str, "method", "Integral",
                        dataset,PlotOrientation.VERTICAL, true,true,false);
        
        setLayout(new BorderLayout());
        
        add(new ChartPanel(chart));
    }
}
