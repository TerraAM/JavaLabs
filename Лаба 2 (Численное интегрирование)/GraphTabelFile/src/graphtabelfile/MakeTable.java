package graphtabelfile;

import javax.swing.JTable;

public class MakeTable {
    public MyJTable getTable(double xMin, double xMax, int n){
        Double[][] cells;
        String[] colNames = new String[]{" X ", " Точно ", "Средн.т", "Гаусса.3"};
        int k=4;
        double x = 0, dx = (xMax - xMin) / (n-1);
        cells = new Double [n][k];
        for (int i=0;i<n;i++){
            x += 0.1f;
            cells[i][0] = x;
            cells[i][1] = MyFunc.getMyIntegr(xMin, xMax);
            cells[i][2] = new Integr_cr().integr(xMin,xMax,n);
            cells[i][3] = new Integr_gauss3().integr(xMin,xMax,n);
        }
        return new MyJTable(cells,colNames);
    }
}

class MyJTable extends JTable{
    public MyJTable(final Object[][]rowData,final Object[] columnNames){
        super(rowData,columnNames);
    }
    @Override
    public boolean isCellEditable(int i,int i1){
        return false;
    }
}
