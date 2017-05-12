package com.kou.test;

import java.io.*;
import java.sql.*;

/**
 * Created by KouJiaxing on 2017-4-14.
 */
public class MySqlImportAndExport {


    public static void main(String[] args) {
        Connection conn;
        String url = "jdbc:mysql://10.33.106.139:3306/merlin?"
                + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8&useSSL=true";
        String url1 = "jdbc:mysql://localhost:3306/springdemo?" +
                "user=koujx&password=19920308&useUnicode=true&characterEncoding=UTF8&useSSL=true";
        FileInputStream fis;
        BufferedReader reader;
        try {
            fis = new FileInputStream("D:\\work\\logs\\details.20170417.txt");
            reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            //System.out.println("Reading File line by line using BufferedReader");
            String line = reader.readLine();
            int countlines = 0;
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动");
            conn = DriverManager.getConnection(url1);

            String query = " insert ignore into request_details (time,url_name,user_code,user_name,position_code,position,city_code,city,region_code,region,shop_code,shop,param) " +
                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            conn.setAutoCommit(false);
            while (line != null) {
                String[] array;//Read lines from files.Put every line in an array
                array = line.split("\\|");
                line = reader.readLine();
                countlines++;

                preparedStmt.setString(1, array[0]);
                preparedStmt.setString(2, array[1]);
                preparedStmt.setInt(3, Integer.valueOf(array[2]));
                preparedStmt.setString(4, array[3]);
                preparedStmt.setInt(5, Integer.parseInt(array[4]));
                preparedStmt.setString(6, array[5]);
                preparedStmt.setString(7, array[6]);
                preparedStmt.setString(8, array[7]);
                preparedStmt.setString(9, array[8]);
                preparedStmt.setString(10, array[9]);
                preparedStmt.setString(11, array[10]);
                if (array.length == 13) {
                    preparedStmt.setString(12, array[11]);
                    preparedStmt.setString(13, array[12]);
                }
                // Execute the preparedstatement
                preparedStmt.addBatch();
                System.out.println(preparedStmt);
            }
            conn.setAutoCommit(true);
            preparedStmt.executeBatch();
            System.out.println("================");
            conn.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

