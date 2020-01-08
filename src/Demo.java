import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.text.html.HTMLDocument.Iterator;


class Infro{
    public String id;
    public String name;
    public String sex;
    public String address;
    public String e_mail;
    public String phoneNumber;
    static int index = 0;
    static ArrayList<Infro> list = new ArrayList();
    static int len = list.size();
    //构造函数
    public Infro(String id,String name,String sex,String address,String e_mail,String phoneNumber){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.e_mail = e_mail;
        this.phoneNumber = phoneNumber;
    }
    public String toString(){
        return "编号："+id+" 姓名："+name+" 性别："+sex+" 通讯地址："+address+" 邮箱地址："+e_mail+" 电话："+phoneNumber;
    }

    /*
     * 添加功能
     * */
    public static void addFunction(){//添加功能
        Infro infro = new Infro("","","","","","");
        System.out.println("请输入添加的数据：");
        Scanner in = new Scanner(System.in);
        System.out.println("输入编号：");
        infro.id = in.next();
        System.out.println("输入姓名：");
        infro.name = in.next();
        System.out.println("输入性别：");
        infro.sex = in.next();
        System.out.println("输入通讯地址：");
        infro.address = in.next();
        System.
                out.println("输入邮箱地址：");
        infro.e_mail = in.next();
        System.out.println("输入电话：");
        infro.phoneNumber = in.next();
        list.add(index,infro);
        index++;
        if(list.isEmpty()){
            System.out.println("数据添加失败啦");
        }else{
            System.out.println("数据添加成功啦");
            len++;//list集合长度加一
//          System.out.println(list.get(0).toString());
        }

    }
    //  public static void deleteFunction(){//删除功能
//      System.out.println("输入要删除的联系人的编号");
//      Scanner in_2 = new Scanner(System.in);
//      String d1 = in_2.nextLine();
//      for(int a= 0; a<len;a++){
//          if(d1.equals(list.get(a).id)){
//              list.remove(list.get(a));
//              len --;
//          }
//      }
//  }
    /*
     * 删除功能
     * */
    public static void deleteFunction(){
        System.out.println("输入要删除的联系人的编号");
        Scanner in_2 = new Scanner(System.in);
        String d1 = in_2.nextLine();
        java.util.Iterator<Infro> it = list.iterator();
        while (it.hasNext()){
            Infro infro = it.next();
            if (infro.id.equals(d1)){
                it.remove();
                --index;//一定要加这个，否则当做了删除操作再做添加操作的时候会出现异常（类似于指针，栈）
                System.out.println("删除完毕"+"此时通讯录记录条数为：" + --len);
            }
        }
    }
    /*
     *                     修改功能
     * */
    public static void reditFunction(){
        System.out.println("输入要修改的通讯录的Id");
        Scanner in_r = new Scanner(System.in);
        String r1 = in_r.nextLine();
        for(int a = 0; a < len;a++){
            if(r1.equals(list.get(a).id)){
                System.out.println("输入修改后的姓名：");
                String name_1 = in_r.next();
                list.get(a).name = name_1;
                System.out.println("输入修改后的性别：");
                String sex_1 = in_r.next();
                list.get(a).sex = sex_1;
                System.out.println("输入修改后的通讯地址：");
                String address_1 = in_r.next();
                list.get(a).address = address_1;
                System.out.println("输入修改后的邮箱地址：");
                String e_mail_1 = in_r.next();
                list.get(a).e_mail = e_mail_1;
                System.out.println("输入修改后的电话：");
                String phoneNumber_1 = in_r.next();
                list.get(a).phoneNumber = phoneNumber_1;
                System.out.println("数据修改完毕");
            }
        }
    }
    /*
     * 查询功能
     * */
    public static void searchFunction() throws Exception{//查询功能
        System.out.println("请输入要查询的姓名：");
        Scanner in_1 = new Scanner(System.in);
        String s1=in_1.nextLine();
        for(int a= 0; a<len;a++){//切记，，这里不能用a<=list.seze(),否则会数组越界异常
            if(s1.equals(list.get(a).name)){
                System.out.println(list.get(a).toString());
            }
        }
    }

    /*
     * 显示功能
     * */
    public static void showFunction(){
        for(int i = 0 ;i<len;i++){
            System.out.println(list.get(i).toString());
        }
    }
    /*
     *                      保存功能
     * */
    public static void writeFunction() throws IOException{
        FileWriter writer = new FileWriter("通讯录管理.txt");
        for(int i = 0 ;i<len;i++){
            String []strwriter = new String[len];
            strwriter[i]=list.get(i).toString();
            writer.write(strwriter[i]);
            writer.write("\r\n");
            System.out.println("成功写入一行数据到 通讯录管理.txt 中");
        }
        writer.close();//关闭写入流，释放资源
    }
    /*
     *                      读取功能
     * */
    public static void readFunction() throws IOException{
        FileReader reader = new FileReader("通讯录管理.txt");
        BufferedReader br = new BufferedReader(reader);
        String str;
        while((str = br.readLine()) != null){//每次读取一行文本，判断是否到达文件尾
            System.out.println(str);
        }
        br.close();
    }
}


public class Demo extends JFrame {

    /*
     * 界面设计
     * */
    public Demo(){
        Container c = getContentPane(); //定义一个顶级容器c
        JPanel jp = new JPanel();   //新建JPanel面板--jp
        JButton button1 = new JButton("新建联系人");
        JButton button2 = new JButton("删除联系人");
        JButton button3 = new JButton("编辑联系人");
        JButton button4 = new JButton("查找联系人");
        JButton button5 = new JButton("显示所有联系人");
        JButton button6 = new JButton("保存联系人到本地");
        JButton button7 = new JButton("读取本地联系人");
        jp.setLayout(new GridLayout(2,4,5,5));//新建网格布局管理器（行数，列数，组件间的水平垂直间距）
        jp.add(button1);
        jp.add(button2);
        jp.add(button3);
        jp.add(button4);
        jp.add(button5);
        jp.add(button6);
        jp.add(button7);
        c.add(jp);//将JPanel面板jp添加到顶级容器c中
        setSize(600,500);
        setTitle("*通 讯 录 管 理 系 统*");
        setVisible(true);
        setResizable(false);//窗体大小由程序员决定，用户不能自由改变大小
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        /*
         *按键响应
         *
         * */
        button1.addActionListener(new ActionListener(){//添加功能实现
            public void actionPerformed(ActionEvent arg0){
                Infro.addFunction();
            }
        });
        button2.addActionListener(new ActionListener(){//删除功能实现
            public void actionPerformed(ActionEvent arg0){
                Infro.deleteFunction();
            }
        });
        button3.addActionListener(new ActionListener(){//修改功能实现
            public void actionPerformed(ActionEvent arg0){
                Infro.reditFunction();
            }
        });
        button4.addActionListener(new ActionListener(){//查询功能实现
            public void actionPerformed(ActionEvent arg0){
                try {
                    Infro.searchFunction();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        button5.addActionListener(new ActionListener(){//显示功能实现
            public void actionPerformed(ActionEvent arg0){
                Infro.showFunction();
            }
        });
        button6.addActionListener(new ActionListener(){//保存功能实现
            public void actionPerformed(ActionEvent arg0){
                try {
                    Infro.writeFunction();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        button7.addActionListener(new ActionListener(){//读取功能实现
            public void actionPerformed(ActionEvent arg0){
                try {
                    Infro.readFunction();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Demo();
        Infro a = new Infro("", "", "", "", "", "");
    }

}
