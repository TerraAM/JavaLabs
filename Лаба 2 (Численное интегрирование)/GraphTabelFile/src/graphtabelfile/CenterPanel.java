package graphtabelfile;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CenterPanel extends JPanel{
    public CenterPanel(){
        double xMin = Verify.xMin;
        double xMax = Verify.xMax;
        int n = Verify.n;
        try{
            setLayout(new BorderLayout());
            add(new MakeGraph(xMin,xMax,n));
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Ошибка при построении графика!");
        }
    }
}
