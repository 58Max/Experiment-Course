import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 import java.sql.*;

    /*
     * 该类为JDBC的工具类
     * */

    public class JDBCUtil {

        private static String url="jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf8";
        private static String name = "root";
        private static String password = "123456";

        static {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        //获取数据库的连接对象
        public static Connection getConnection() throws Exception{
            return DriverManager.getConnection(url,name,password);
        }

        //关闭资源
        public static void close(Connection conn, PreparedStatement pstat, ResultSet rs)throws  Exception{
            if(rs != null){
                rs.close();
            }

            if(pstat != null){
                pstat.close();
            }

            if(conn != null){
                conn.close();
            }
        }
    }
