package news;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

public class SortPerson extends JFrame {
    private JButton j1, j2, j3, j4, j5, j6;
    private JPanel panel = new JPanel(new BorderLayout());

    private DefaultTableModel tablemodel = new DefaultTableModel();
    private JTable table = new JTable();

    public SortPerson() throws SQLException, ClassNotFoundException {
        super("用户排序");

        j1 = new JButton("姓名排序");
        j2 = new JButton("地址排序");
        j3 = new JButton("电话排序");
        j4 = new JButton("邮编排序");
        j5 = new JButton("邮箱排序");
        j6 = new JButton("家庭电话排序");
        panel.add(j1);
        panel.add(j2);
        panel.add(j3);
        panel.add(j4);
        panel.add(j5);
        panel.add(j6);
        panel.setLayout(new FlowLayout());

        this.add(panel);
        this.setSize(900, 500);
        this.setLocation(200, 30);
        this.setVisible(true);

        dateinti();
        table.setModel(tablemodel);
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);


        Statement statement = Link.Connection();

        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablemodel.setColumnCount(0);
                tablemodel.setRowCount(0);
                String sql = "select * from person order by nameid ";
                try {
                  ResultSet rs=statement.executeQuery(sql);
                    shows(rs);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablemodel.setColumnCount(0);
                tablemodel.setRowCount(0);
                String sql = "select * from person order by address ";
                try {
                    ResultSet rs=statement.executeQuery(sql);
                    shows(rs);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablemodel.setColumnCount(0);
                tablemodel.setRowCount(0);
                String sql = "select * from person order by phoneNumber ";
                try {
                    ResultSet rs=statement.executeQuery(sql);
                    shows(rs);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        j4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablemodel.setColumnCount(0);
                tablemodel.setRowCount(0);
                String sql = "select * from person order by postnumber ";
                try {
                    ResultSet rs=statement.executeQuery(sql);
                    shows(rs);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        j5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablemodel.setColumnCount(0);
                tablemodel.setRowCount(0);
                String sql = "select * from person order by email ";
                try {
                    ResultSet rs=statement.executeQuery(sql);
                    shows(rs);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        j6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablemodel.setColumnCount(0);
                tablemodel.setRowCount(0);
                String sql = "select * from person order by homephoneNumber ";
                try {
                    ResultSet rs=statement.executeQuery(sql);
                    shows(rs);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    //将结果集的元素可视化
    public  void shows(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metadate = (ResultSetMetaData)resultSet.getMetaData();
        String[] tille = new String[metadate.getColumnCount()];
        for (int i = 0; i < metadate.getColumnCount(); i++) {
            tille[i] = metadate.getColumnName(i + 1);
            tablemodel.addColumn(tille[i]);
        }
        while (resultSet.next()) {
            String cid = resultSet.getString("nameid");
            String cname = resultSet.getString("address");
            String ctel = resultSet.getString("phoneNumber");
            String post = resultSet.getString("postNumber");
            String ema = resultSet.getString("email");
            String home = resultSet.getString("homephoneNumber");
            tablemodel.addRow(new Object[]{cid, cname, ctel, post, ema, home});
        }

    }

    public void dateinti() throws SQLException, ClassNotFoundException {
        Statement stat = Link.Connection();
        try {
            ResultSet res;
            String sql = "select * from person";
            res = stat.executeQuery(sql);
            ResultSetMetaData metadate = (ResultSetMetaData) res.getMetaData();
            System.out.println(res);
            String[] tille = new String[metadate.getColumnCount()];
            for (int i = 0; i < metadate.getColumnCount(); i++) {
                tille[i] = metadate.getColumnName(i + 1);
                tablemodel.addColumn(tille[i]);
            }

            while (res.next()) {
                String cid = res.getString("nameid");
                String cname = res.getString("address");
                String ctel = res.getString("phoneNumber");
                String post = res.getString("postNumber");
                String ema = res.getString("email");
                String home = res.getString("homephoneNumber");
                tablemodel.addRow(new Object[]{cid, cname, ctel, post, ema, home});
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
