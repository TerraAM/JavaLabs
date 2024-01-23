package graphtabelfile;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SouthPanel extends JPanel {
    public SouthPanel(){
        String str = MyFunc.getMyFuncStr();
        JLabel lbl1 = new JLabel("Функция: " + str);
        lbl1.setFont(new Font("SansSerif",Font.ITALIC+Font.BOLD,22));
        add(lbl1);
    }
}
