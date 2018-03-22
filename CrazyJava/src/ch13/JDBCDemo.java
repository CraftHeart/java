package ch13;

import java.sql.*;

public class JDBCDemo {
    public static void connectMysql() throws Exception {
        // 1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        try {
            // 2.使用DriverManager获取数据库连接
            // 其中返回的Connection就代表了Java程序和数据库的连接
            // 不同数据库的URL写法需要查询驱动文档，用户名、密码由DBA分配
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cuber"
                    , "cuber", "2017"
            );
            // 3.使用Connection来创建一个Statement对象
            Statement statement = conn.createStatement();

            // 4.执行SQL语句
        /*
        * Statement有三种执行SQL语句的方法：
        * 1.execute()可执行任何SQL语句——返回一个Boolean值 如果执行后第一个结果是ResultSet，则返回true，否则返回false
        * 2.executeQuery()执行select语句——返回查询到的结果集
        * 3.executeUpdate()用于执行DML语句——返回一个整数，代表被SQL语句影响的记录的条数*/
            ResultSet resultSet = statement.executeQuery("SELECT * FROM websites");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" +
                        resultSet.getString(3));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void executeDDL() throws Exception{
        /*
        * 执行DDL语句返回0，执行DML语句返回影响的条数*/
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuber", "cuber", "2017");
        Statement statement = conn.createStatement();
//        statement.executeUpdate("DROP TABLE IF EXISTS jdbc_test ");
        statement.executeUpdate("CREATE table IF NOT EXISTS jdbc_test (id int auto_increment PRIMARY KEY , name VARCHAR(255), sex VARCHAR(4))");
        System.out.println("create table success");
        statement.executeUpdate("INSERT INTO jdbc_test (name, sex) values ('cuber', 'male')");
        System.out.println("insert success");
    }

    public static void prepareStatementDemo() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuber", "cuber", "2017");
        Statement statement = conn.createStatement();

        statement.executeUpdate("DROP TABLE IF EXISTS jdbc_test ");
        statement.executeUpdate("CREATE table IF NOT EXISTS jdbc_test (id int auto_increment PRIMARY KEY , name VARCHAR(255), sex VARCHAR(4))");

        for (int i=0;i<10;i++) {
            statement.executeUpdate("INSERT INTO jdbc_test (name, sex) VALUES ("
                    + "'cuber"+i+"', 'male')");
        }

        PreparedStatement preparedStatement = conn.prepareStatement("INSERT into jdbc_test (name, sex) VALUES (?, ?)");
        for (int i=0; i<10;i++) {
            preparedStatement.setString(1, "bobo" + i);
            preparedStatement.setString(2, ""+i);
            preparedStatement.executeUpdate();
        }
    }

    public static void manageResult() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuber", "cuber", "2017");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM jdbc_test WHERE sex = 'male'");

        resultSet.last();
        System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) +
                "\t" + resultSet.getString(3));

        resultSet.previous();
        System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) +
                "\t" + resultSet.getString(3));

        int rowCount = resultSet.getRow();  // 获得当前在结果集的第几行
        for (int i=1; i<=rowCount;i++) {
            resultSet.absolute(i);
            System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) +
                    "\t" + resultSet.getString(3));
            /**
             * Statement返回的结果集无法改变表内容
             */
//            resultSet.updateString(2, "cuberqiu" + i);
//            resultSet.updateRow();
        }

        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM jdbc_test WHERE sex = 'male'",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        ResultSet preResultSet = preparedStatement.executeQuery();

        System.out.println("--------preStatement get result-------------");

        preResultSet.last();
        System.out.println(preResultSet.getInt(1) + "\t" + preResultSet.getString(2) +
                "\t" + preResultSet.getString(3));

        preResultSet.previous();
        System.out.println(preResultSet.getInt(1) + "\t" + preResultSet.getString(2) +
                "\t" + preResultSet.getString(3));

        int preRowCount = preResultSet.getRow();
        for(int i=1;i<=preRowCount;i++) {
            preResultSet.absolute(i);
            System.out.println(preResultSet.getInt(1) + "\t" + preResultSet.getString(2) +
                    "\t" + preResultSet.getString(3));
            /**
             * PreStatement 返回的结果集可以改变表内容
             */
            preResultSet.updateString(2, "cuberqiu" + i);
            preResultSet.updateRow();
        }
    }
    public static void main(String[] args) throws Exception{
        connectMysql();
//        executeDDL();
//        prepareStatementDemo();
//        manageResult();
    }
}
