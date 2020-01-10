package news;


import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

 public  class showPerson extends JFrame{
	private JPanel panel=new JPanel(new BorderLayout());

	private DefaultTableModel tablemodel=new DefaultTableModel();
	private JTable table=new JTable();
	public showPerson() throws SQLException, ClassNotFoundException {
		super("查看用户");
		this.setSize(800,500);
		this.setLocation(200,30);
		this.setVisible(true);
		this.add(panel);

		dateinti();
		table.setModel(tablemodel);
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
	}
	public void dateinti() throws SQLException, ClassNotFoundException {
		Statement stat = Link.Connection();
			try {
				ResultSet res;
				String sql="select * from person";
				res=stat.executeQuery(sql);
				ResultSetMetaData metadate=(ResultSetMetaData) res.getMetaData();
				System.out.println(res);
				String[] tille=new String[metadate.getColumnCount()];
				for(int i=0;i<metadate.getColumnCount();i++) {
					tille[i]=metadate.getColumnName(i+1);
					tablemodel.addColumn(tille[i]);
				}

				while(res.next()) {
					String cid=res.getString("nameid");
					String cname=res.getString("address");
					String ctel=res.getString("phoneNumber");
					String post = res.getString("postNumber");
					String ema = res.getString("email");
					String home = res.getString("homephoneNumber");
					tablemodel.addRow(new Object[] {cid,cname,ctel,post,ema,home});
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
