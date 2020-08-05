import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test2 {
    private static Connection conn = null;
    private static ResultSet res = null;
    private static PreparedStatement pst = null;
    private static int i = 0;

    public static void main(String []args){
        try {
            conn = JDBCUtil.getConnection();
            //插入语句
            String sql1 = " insert into Test.studentScore values(?,?,?)";
            //对象sql语句进行预编译
            pst = conn.prepareStatement(sql1);
            //批量处理
            pst.setInt(1,174401);
            pst.setString(2,"陈永泽");
            pst.setDouble(3,92);
            pst.addBatch();

            pst.setInt(1,174402);
            pst.setString(2,"吴帅龙");
            pst.setDouble(3,93.2);
            pst.addBatch();

            pst.setInt(1,174403);
            pst.setString(2,"王一");
            pst.setDouble(3,99);
            pst.addBatch();

            pst.setInt(1,174404);
            pst.setString(2,"苏勃");
            pst.setDouble(3,98.2);
            pst.addBatch();

            pst.setInt(1,174405);
            pst.setString(2,"邸石 ");
            pst.setDouble(3,93.5);
            pst.addBatch();

            pst.setInt(1,174415);
            pst.setString(2,"闻天富");
            pst.setDouble(3,92.5);
            pst.addBatch();

            pst.setInt(1,174400);
            pst.setString(2,"MASIWEI");
            pst.setDouble(3,99);
            pst.addBatch();
            //执行
            pst.executeBatch();
            //修改语句
            String sql2 = "update Test.studentScore set score = 98.5 where no = 174404";
            pst = conn.prepareStatement(sql2);
            i = pst.executeUpdate();
            if(i == 1){
                System.out.println("修改成功");
            }
            //删除语句
            String sql3 = "delete  from Test.studentScore where no = 174400";
            pst = conn.prepareStatement(sql3);
            i = pst.executeUpdate();
            if(i == 1){
                System.out.println("删除成功");
            }
            //查询语句
            String sql4 = "select * from Test.studentScore where score > 90";
            pst=conn.prepareStatement(sql4);
            res = pst.executeQuery();
            while(res.next()){
                System.out.println(res.getInt("no") +" "+ res.getString("name")+ " " +res.getDouble("score"));
            }
            //成绩统计
            String sql5 = "select sum(score)/count(name)'平均成绩' from Test.studentScore";
            pst = conn.prepareStatement(sql5);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                System.out.println(res.getDouble("平均成绩"));
            }
            JDBCUtil.close(conn,pst,res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
