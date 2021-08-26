import java.sql.*;

public class DataBaseMethods {
    static Connection connection = null;
    static String databaseName = "";
    static String url = "jdbc:mysql://localhost:3306/camunda_java";
    static String userName = "root";
    static String password = "1234";
    public void Intert(String firstName,String lastName, String phoneNumber,String email) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO `personal_information` SET FirstName=?,phoneNumber=?, lastName=?,email=?");
            ps.setString(1,firstName);
            ps.setString(2,lastName);
            ps.setString(3,phoneNumber);
            ps.setString(4,email);

            int status = ps.executeUpdate();

            if (status != 0) {
                System.out.println("DB connected");
            }
            System.out.println("row inserted");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void Update(int ID,String firstName,String lastName, String phoneNumber,String email) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = connection.prepareStatement("UPDATE `personal_information` SET FirstName=?,phoneNumber=?, lastName=?,email=? WHERE ID=?");
            ps.setString(1,firstName);
            ps.setString(2,lastName);
            ps.setString(3,phoneNumber);
            ps.setString(4,email);
            ps.setString(5, String.valueOf(ID));


            int status = ps.executeUpdate();

            if (status != 0) {
                System.out.println("DB connected");
            }
            System.out.println("row Updated");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void GetAllRows(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM personal_information");
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                System.out.println("-----------------------------------------------------------------------------");

                System.out.println("first name: "+rs.getString("firstName"));
                System.out.println("last name: "+rs.getString("lastName"));
                System.out.println("phone number: "+rs.getString("phoneNumber"));
                System.out.println("email: "+rs.getString("email"));
                System.out.println("-----------------------------------------------------------------------------");

            }        }
        catch (Exception e){}

    }
    }

