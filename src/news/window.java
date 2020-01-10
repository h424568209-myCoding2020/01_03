package news;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class window extends JFrame{

	private JPanel top=new JPanel();
	private JButton adds=new JButton("添加用户");
	private JButton uadates=new JButton("修改用户");
	private JButton shows=new JButton("查看用户");
	private JButton searchs=new JButton("查找用户");
	private JButton sorts=new JButton("排序用户");
	public window(){
		super("通讯录");
		this.setJMenuBar(getJMenuBar());
		this.setSize(800,500);
		this.setLocation(200,30);
		this.setVisible(true);

		this.add(top, BorderLayout.NORTH);
		
		top.add(Box.createHorizontalGlue());
		top.add(adds);
		top.add(Box.createHorizontalStrut(30));
		top.add(uadates);
		
		top.add(Box.createHorizontalStrut(30));
		top.add(shows);

		
		top.add(Box.createHorizontalStrut(30));
		top.add(searchs);
		
		top.add(Box.createHorizontalStrut(30));
		top.add(sorts);
		top.add(Box.createHorizontalGlue());
	


    	this.Listener();
	}
	
	private void Listener() {
		adds.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new addperson();
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});

		shows.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new showPerson();
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});


		uadates.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new updataPerson();
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});


		searchs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				try {
					new SearchPerson();
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});

		sorts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new SortPerson();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});

}

	public static void main(String[] args) {
		new window();
	}
}
