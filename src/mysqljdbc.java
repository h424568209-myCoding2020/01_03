import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
class mysqljdbc {
    Connection connect;
    ResultSet rSet;
    java.sql.PreparedStatement preStmt;
    public void initializeDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序
            //Class.forName("org.gjt.mm.mysql.Driver");
            System.out.println("Success loading Mysql Driver!");
            connect= DriverManager.getConnection(
                    "","","");
            //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
            System.out.println("Success connect Mysql server!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}