package graphtabelfile;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class EastPanel extends JPanel{
    public EastPanel(){
        double xMin = Verify.xMin;
        double xMax = Verify.xMax;
        int n = Verify.n;
        JTable tb1 = null;
        try{
            setLayout(new BorderLayout());
            MakeTable makeTable = new MakeTable();
            tb1 = makeTable.getTable(xMin,xMax,n);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Ошибка при построении таблицы!");
        }
            TableColumnModel cm = tb1.getColumnModel();
            int w = Math.round(0.2f*MainFrame.getW());
            int h = Math.round(0.8f*MainFrame.getH());
            int mw = (w/2-10)>50?w/2-10:50;
            cm.getColumn(0).setMaxWidth(mw);
            cm.getColumn(1).setMaxWidth(mw);
            JScrollPane jsp = new JScrollPane(tb1);
            jsp.setPreferredSize(new Dimension(w,h));
            add(jsp);
    }
}
