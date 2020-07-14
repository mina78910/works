package base;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBManager {
    public static Connection getConnection(){
    	System.out.println("DBmanagerの中!!");
        Connection con = null;
        try{
        	System.out.println("DBmanager12行目");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DBmanager14行目");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db?serverTimezone=JST","root","");
            System.out.println("DBConnected!!");
            return con;
        }catch(ClassNotFoundException e){
        	//データベースに接続失敗のメッセージ
            throw new IllegalMonitorStateException("接続に失敗しました");
        } catch (SQLException e) {
        	System.out.println(e);
            throw new IllegalMonitorStateException("接続に失敗しました");
        }
        catch (Exception e) {
            throw new IllegalMonitorStateException("接続に失敗しました");
        }
    }
}
