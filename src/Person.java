import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Person {
    public String name;
    public String address;
    public String phoneNumber;
    public String postNumber;
    public String Email;
    public String homephoneNumber;

    public Person(){}
    public Person(String name, String address, String phoneNumber, String postNumber, String email, String homephoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.postNumber = postNumber;
        Email = email;
        this.homephoneNumber = homephoneNumber;
    }

      public static  final   List<Person> list  = new ArrayList<>();

    @Override
    public String toString() {
        return  "name='" + name + '\'' + ", address='" + address + '\'' + "," +
                " phoneNumber='" + phoneNumber + '\'' + ", postNumber='" + postNumber + '\'' + ", Email='" + Email + '\'' + "," +
                " homephoneNumber='" + homephoneNumber ;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBook?useSSL=false", "root", "123456789");
        Statement s = connection.createStatement();
        boolean flag = true;
        while (flag) {
            show();
            System.out.println("选择你要进行的操作 : ");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                        addPerson();
                    break;
                case 2:
                      showPerson();
                    break;
                case 3:
                     StorePerson(s);
                    break;
                case 4:
                    System.out.println("输入你想查找的姓名： ");
                    SearchPerson();
                    break;
                case 5:
                     updataPerson();
                    break;
                case 6:
                     SortPerson();
                    break;
                case 7:
                    flag = false;
                    break;
                    default:
                        System.out.println("输入有误，重新输入");
                        break;
            }
        }
        s.close();

    }

    private static void StorePerson(Statement s) throws SQLException {
        Iterator<Person> it = list.iterator();
        while(it.hasNext()){
            Person p = it.next();
            String names = p.name;
            String address = p.address;
            String phoneNumber = p.phoneNumber;
            String post = p.postNumber;
            String email = p.Email;
            String home = p.homephoneNumber;
            int rows  = s.executeUpdate(
                    "insert into person(name,address,phoneNumber,postNumber,email,homephoneNumber)" +
                    "values("+names+","+address+","+phoneNumber+" , "+post+","+email+","+home+");"
                    );
            System.out.println(rows);
        }
    }

    private static void SortPerson  () {
        showSort();
        System.out.println("选择要进行排序的属性");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        switch (num){
            case 1:
                list.sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                      return   o1.address.compareTo(o2.address);
                    }
                });
                break;
            case 2:
                list.sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.phoneNumber.compareTo(o2.phoneNumber);
                    }
                });
                break;
            case 3:
                list.sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                       return    o1.postNumber.compareTo(o2.postNumber);
                    }
                });
                break;
            case 4:
                list.sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return    o1.Email.compareTo(o2.Email);
                    }
                });
                break;
            case 5:
                list.sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return    o1.homephoneNumber.compareTo(o2.homephoneNumber);
                    }
                });
                break;
            case  6:
                list.sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.name.compareTo(o2.name);
                    }
                });
                break;
                default:
                    System.out.println("输入有误，重新输入");
                    break;
        }
    }

    private static void showSort() {
        System.out.println("*****************************************");
        System.out.println("****  1 地址排序      2 电话号码排序 ******");
        System.out.println("****  3 邮政编码排序   4 Email排序   ******");
        System.out.println("****  5 家庭电话排序   6 姓名排序   *******");
        System.out.println("*****************************************");
    }

    private static void updataPerson() {
        Scanner scanner=  new Scanner(System.in);
        System.out.println("输入要修改的人的姓名：");
        Person p = SearchPerson();
        if(p== null){
            return;
        }
        boolean flag = true;
        while(flag) {
            shows();
            System.out.println("选择修改的信息: ");
            int num  = scanner.nextInt();
            switch (num){
                case 1: {
                    System.out.println("输入新的地址: ");
                    p.address = scanner.next();
                    break;
                }
                case 2:
                    System.out.println("输入新的电话号码 :");
                    p.phoneNumber = scanner.next();
                    break;
                case 3:
                    System.out.println("输入新的邮政编码");
                    p.postNumber = scanner.next();
                    break;
                case 4:
                    System.out.println("输入新的Email");
                    p.postNumber = scanner.next();
                    break;
                case 5:
                    System.out.println("输入新的家庭电话");
                    p.homephoneNumber = scanner.next();
                    break;
                case 6:
                    flag=false;
                    break;
                    default:
                        System.out.println("输入有误，重新输入");
                        break;
            }
        }
    }

    private static void shows() {
        System.out.println("*****************************************");
        System.out.println("****  1 修改地址      2 修改电话号码 ******");
        System.out.println("****  3 修改邮政编码   4 修改Email   ******");
        System.out.println("****  5 修改家庭电话   6 退出      *******");
        System.out.println("*****************************************");
    }

    private static Person SearchPerson() {
         Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if(name == null){
            System.out.println("姓名不能为空");
            return  null;
        }
        boolean flag = false;
        Iterator <Person>it= list.iterator();
        Person p =null ;
        while(it.hasNext()){
            p = it.next();
            if((p.name.equals(name))){
                System.out.println("name='" + p.name + '\'' + ", address='" +p.address + '\'' + "," +
                        " phoneNumber='" + p.phoneNumber + '\'' + ", postNumber='" +p.postNumber + '\'' + ", Email='" + p.Email + '\'' + "," +
                        " homephoneNumber='" + p.homephoneNumber );
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("查无此人");
            return null;
        }
        return p;
    }

    private static void showPerson() {
        list.forEach(System.out::println);
    }

    private static void addPerson() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("输入要添加的用户姓名： ");
        String name = scanner.nextLine();
        if(name.equals("")){
            System.out.println("姓名不能为空");
            return;
        }
        System.out.println("输入要添加的用户地址： ");
        String address = scanner.nextLine();
        System.out.println("输入要添加的用户电话号码： ");
        String phonenum = scanner.nextLine();

        Iterator <Person>it= list.iterator();
        while(it.hasNext()){
            Person p = it.next();
            if((p.phoneNumber.equals(phonenum))){
                System.out.println("电话已经存在");
                return;
            }
        }
        System.out.println("输入要添加的用户邮政编码： ");
        String postnum = scanner.nextLine();
        System.out.println("输入要添加的用户Email： ");
        String email = scanner.nextLine();
        System.out.println("输入要添加的用户家庭电话： ");
        String homephonenum = scanner.nextLine();
        Person p = new Person(name,address,phonenum,postnum,email,homephonenum);
        list.add(p);
    }


    private static void show() {
        System.out.println("**************************************");
        System.out.println("************* 1     添加 *************");
        System.out.println("************* 2     显示 *************");
        System.out.println("************* 3     存储 *************");
        System.out.println("************* 4     查询 *************");
        System.out.println("************* 5     修改 *************");
        System.out.println("************* 6     排序 *************");
        System.out.println("************* 7     退出 *************");
    }
}
