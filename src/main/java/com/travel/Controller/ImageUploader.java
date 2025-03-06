package com.travel.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageUploader {

    // 数据库连接信息
    private static final String DB_URL = "jdbc:mysql://localhost:3306/travel"; // 替换为你的数据库名
    private static final String USERNAME = "root"; // 替换为你的用户名
    private static final String PASSWORD = "123456"; // 替换为你的密码

    public static void main(String[] args) {
        // 图片文件路径
        String imagePath = "C:\\Users\\24264\\Desktop\\景点图片\\婺源.png"; // 替换为你要上传的图片路径
        insertImage(imagePath);
    }

    public static void insertImage(String imagePath) {
        // 获取数据库连接
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "update  attractions set image=? where attraction_id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // 读取文件到字节数组
                File imageFile = new File(imagePath);
                try (FileInputStream inputStream = new FileInputStream(imageFile)) {
                    statement.setString(2, "2"); // 设置景点名称
                    statement.setBinaryStream(1, inputStream, (int) imageFile.length()); // 设置图片 BLOB 数据

                    // 执行插入
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("图片上传成功!");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("数据库错误: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("文件读取错误: " + e.getMessage());
        }
    }
}
