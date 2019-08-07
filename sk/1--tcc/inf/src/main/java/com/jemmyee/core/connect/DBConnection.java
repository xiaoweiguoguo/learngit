package com.jemmyee.core.connect;

import java.sql.*;
import java.util.*;

/**
 * Created by Administrator on 2017/9/14.
 */
public class DBConnection {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "";
    private String username = "";
    private String password = "";

    private Connection con = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public DBConnection(String url,String username,String password){
        this.url = url;//"jdbc:mysql://192.168.1.254:3306/park"
        this.username = username;//"root"
        this.password = password;//"kktc@ROOT"
        try {
            Class.forName(driver);//加载驱动程序，此处运用隐式注册驱动程序的方法
        } catch(ClassNotFoundException e) {
            System.out.println("驱动加载失败");
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url,username,password);//创建连接对象
        } catch(SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
    }
    private static List resultSetToList(ResultSet rs) throws java.sql.SQLException {
        if (rs == null)
            return Collections.EMPTY_LIST;
        ResultSetMetaData md = rs.getMetaData(); //得到结果集(rs)的结构信息，比如字段数、字段名等
        int columnCount = md.getColumnCount(); //返回此 ResultSet 对象中的列数
        List list = new ArrayList();
        Map rowData = new HashMap();
        while (rs.next()) {
            rowData = new HashMap(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(rowData);
        }
        return list;
    }

    public int insertOrUpdateOrDel(String sql) {
        int i = 0;
        try {
            st = con.prepareStatement(sql);//创建sql执行对象
            i = st.executeUpdate();//执行sql更新语句并返回影响行数
        } catch (SQLException e) {
            System.out.println("sql执行失败");
            e.printStackTrace();
        }
        return i;
    }

    public List select(String sql) {
        List list = Collections.EMPTY_LIST;
        try {
            st = con.prepareStatement(sql);//创建sql执行对象
            rs = st.executeQuery();//执行sql更新语句并返回影响行数
            list = resultSetToList(rs);
        } catch (SQLException e) {
            System.out.println("sql执行失败");
            e.printStackTrace();
        }
        return list;
    }

    public void releaseDB() {
        //关闭相关的对象
        try {
            if(rs != null) rs.close();
            if(st != null) st.close();
            if(con !=null) con.close();
        } catch (SQLException e) {
            System.out.println("释放失败");
            e.printStackTrace();
        }
    }
}
