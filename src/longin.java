import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class longin extends JFrame {
    private JPanel p;
    private JLabel lblName, lblPwd;
    private JTextField txtName;
    private JPasswordField txtPwd;
    private JButton btnOk, btnCancle;

    public longin() {
        super("登录");
        p = new JPanel();
        p.setLayout(null);
        lblName = new JLabel("用户名");
        lblPwd = new JLabel("密    码");
        txtName = new JTextField(20);
        txtPwd = new JPasswordField(20);
        txtPwd.setEchoChar('*');
        btnOk = new JButton("确定");
        btnCancle = new JButton("清空");
        lblName.setBounds(30, 30, 60, 25);
        txtName.setBounds(95, 30, 120, 25);
        lblPwd.setBounds(30, 60, 60, 25);
        txtPwd.setBounds(95, 60, 120, 25);
        btnOk.setBounds(60, 90, 60, 25);
        btnCancle.setBounds(125, 90, 60, 25);
        p.add(lblName);
        p.add(txtName);
        p.add(lblPwd);
        p.add(txtPwd);
        p.add(btnOk);
        p.add(btnCancle);
        this.add(p);
        this.setSize(250, 170);
        this.setLocation(300, 300);

        this.setVisible(true);
        // 设置窗体不可改变大小
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 注册确定按钮的事件处理
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 获取用户输入的用户名
                String strName = txtName.getText();
                // 获取用户输入的密码
                String strPwd = new String(txtPwd.getPassword());
                // 在消息对话框中显示用户输入的信息
                if (strName.equals("admin") && strPwd.equals("123456"))
                    JOptionPane.showMessageDialog(null, "恭喜您，登录成功！", "提示窗口", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "登录失败！", "提示窗口", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        // 注册取消按钮的事件处理
        btnCancle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 清空文本框中的文本
                txtName.setText("");
                txtPwd.setText("");
            }
        });
    }

    public static void main(String[] args) {
        longin f = new longin();
        f.setVisible(true);
    }
}
