package graphtabelfile;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new MainFrame();
        frame.setTitle("graph_table_file");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
    class MyFunc{
        public static double getMyFunc(double x){
            return Math.sin(x);
        }
        public static String getMyFuncStr(){
            return "sin(x)";
        }
        public static double getMyIntegr(double xMin, double xMax){
            double y1 = -Math.cos(xMin);
            double y2 = -Math.cos(xMax);
            return y2-y1;
        }
    }
