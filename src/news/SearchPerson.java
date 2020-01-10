package news;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.ResultSetMetaData;

public class SearchPerson extends JFrame {
    private JPanel p;
    private JLabel name;
    private JTextField field;
    private JButton ok, cancle;

    private DefaultTableModel tablemodel = new DefaultTableModel();
    private JPanel panel = new JPanel(new BorderLayout());
    private JTable table = new JTable();

    public SearchPerson() throws SQLException, ClassNotFoundException {
        super("查询联系人");
        this.setVisible(true);
        this.setSize(800, 500);
        this.setLocation(300, 300);
        this.setResizable(true);

        p = new JPanel();
        name = new JLabel("姓名");
        field = new JTextField(70);
        ok = new JButton("确定");
        cancle = new JButton("取消");
        p.add(name);
        p.add(field);
        p.add(ok);
        p.add(cancle);
        this.add(p);
        dateinti();
        table.setModel(tablemodel);
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);
        name.setBounds(30, 60, 60, 25);
        field.setBounds(95, 60, 120, 25);

    }

    void dateinti() throws SQLException, ClassNotFoundException {
        Statement s = Link.Connection();
        panel = new JPanel(new BorderLayout());
        this.setSize(800, 500);
        this.setLocation(200, 30);
        this.setVisible(true);
        this.add(panel);
        tablemodel = new DefaultTableModel();

            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tablemodel.setColumnCount(0);
                    tablemodel.setRowCount(0);
                    String name = field.getText();
                    System.out.println(name);
                    if (name.equals("")) {
                        JOptionPane.showMessageDialog(null, "请输入正确的姓名");
                        return;
                    }
                    try {
                        ResultSet res;
                        String sql = "SELECT  * from person where nameid like '" + name + "'";
                        res = s.executeQuery(sql);
                        ResultSetMetaData metadate = (ResultSetMetaData) res.getMetaData();
                        String[] tille = new String[metadate.getColumnCount()];
                        for (int i = 0; i < metadate.getColumnCount(); i++) {
                            tille[i] = metadate.getColumnName(i + 1);
                            tablemodel.addColumn(tille[i]);
                        }
                        while (res.next()) {
                            String names = res.getString("nameid");
                            String cname = res.getString("address");
                            String ctel = res.getString("phoneNumber");
                            String post = res.getString("postNumber");
                            String ema = res.getString("email");
                            String home = res.getString("homephoneNumber");
                            tablemodel.addRow(new Object[]{names, cname, ctel, post, ema, home});
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                }
            });
            cancle.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        new window();
                }
            });
    }
}
