package news;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class updataPerson extends JFrame {
    private JPanel p ;
    private JLabel name,address,phoneNumber,postNumber,Email,homePhoneNumber;
    private JTextField textField1,textField2,textField3,textField4,textField5,textField6;
    private JButton ok,cancle;

    private DefaultTableModel tablemodel=new DefaultTableModel();
    public updataPerson() throws SQLException, ClassNotFoundException {
        super("更新联系人");
        p= new JPanel();
        name = new JLabel("姓名");
        address = new JLabel("地址");
        phoneNumber = new JLabel("电话");
        postNumber = new JLabel("邮编");
        Email = new JLabel("邮箱");
        homePhoneNumber = new JLabel("家庭电话");
        textField1 = new JTextField(65);
        textField2 = new JTextField(70);
        textField3 = new JTextField(70);
        textField4 = new JTextField(70);
        textField5 = new JTextField(70);
        textField6 = new JTextField(70);
        ok = new JButton("确定");
        cancle = new JButton("取消");

        name.setBounds(30, 60, 60, 25);
        textField1.setBounds(95, 60, 120, 25);
        address.setBounds(60, 90, 60, 25);
        textField2.setBounds(125, 90, 60, 25);
        phoneNumber.setBounds(90,120,60,25);
        textField3.setBounds(125, 90, 60, 25);
        postNumber.setBounds(120,150,60,25);
        textField4.setBounds(125, 90, 60, 25);
        Email.setBounds(150,180,60,25);
        textField5.setBounds(125, 90, 60, 25);
        homePhoneNumber.setBounds(180,210,60,25);
        textField6.setBounds(125, 90, 60, 25);
        p.add(name);
        p.add(textField1);

        p.add(ok);
        p.add(cancle);

        p.add(address);
        p.add(textField2);
        p.add(phoneNumber);
        p.add(textField3);
        p.add(postNumber);
        p.add(textField4);
        p.add(Email);
        p.add(textField5);
        p.add(homePhoneNumber);
        p.add(textField6);
        p.add(ok);
        p.add(cancle);


        textField2.setEditable(false);
        textField3.setEditable(false);
        textField4.setEditable(false);
        textField5.setEditable(false);
        textField6.setEditable(false);
        
        this.setVisible(true);
        this.add(p);
        this.setSize(800,500);
        this.setLocation(300,300);
        this.setResizable(true);


        Statement s = Link.Connection();
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textField2.setEditable(true);
                    textField3.setEditable(true);
                    textField4.setEditable(true);
                    textField5.setEditable(true);
                    textField6.setEditable(true);
                    String names = textField1.getText();
                    String s1 = textField2.getText();
                    String s2 = textField3.getText();
                    String s3 = textField4.getText();
                    String s4 = textField5.getText();
                    String s5 = textField6.getText();

                    String sql = ( "update person set address = '"+s1+"', phoneNumber = '"+s2+"',postNumber = '"+s3+"'" +
                            ",email = '"+s4+"',homephoneNumber = '"+s5+"' where nameid like'"+names+"'");
                int rows = s.executeUpdate(sql);
                    System.out.println(rows);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

}
