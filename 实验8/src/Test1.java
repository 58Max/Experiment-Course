import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test1 {
    private static Connection conn = null;

    public static void main(String []args){
        try {
            //获取连接对象
            conn = JDBCUtil.getConnection();

            //预编译语句
            String sql1 = " insert into Test.StudentInfo values(?,?,?)";
            //对象sql语句进行预编译
            PreparedStatement pst = conn.prepareStatement(sql1);
            //批量处理
            pst.setString(1,"陈永泽");
            pst.setString(2,"男");
            pst.setInt(3,21);
            pst.addBatch();

            pst.setString(1,"吴帅龙");
            pst.setString(2,"男");
            pst.setInt(3,21);
            pst.addBatch();

            pst.setString(1,"王一");
            pst.setString(2,"男");
            pst.setInt(3,20);
            pst.addBatch();

            pst.setString(1,"苏勃");
            pst.setString(2,"男");
            pst.setInt(3,19);
            pst.addBatch();

            pst.setString(1,"邸石");
            pst.setString(2,"男");
            pst.setInt(3,20);
            pst.addBatch();

            pst.setString(1,"闻天富");
            pst.setString(2,"男");
            pst.setInt(3,21);
            pst.addBatch();
            //执行
            pst.executeBatch();
            pst.close();

            String selectsql = "select * from Test.StudentInfo where age >= 18 ";

            pst = conn.prepareStatement(selectsql);

            ResultSet res = pst.executeQuery(selectsql);
            //遍历
            while(res.next()){
                System.out.println(res.getString("name") +" " +res.getString("sex") +" " + res.getInt("age"));
            }
            JDBCUtil.close(conn,pst,res);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
