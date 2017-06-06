package com.program.dao;

import java.sql.*;
import java.util.ArrayList;
import com.program.models.FoodModel;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {
    
    private Connection connection;

    public FoodDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        connection = null;
    }

    public boolean createConnection() {
        String url = "jdbc:mysql://localhost:3306/coba";
        String username = "root";
        String password = "";

        boolean isSuccess = true;

        try {
            connection = DriverManager.getConnection(url, username, password); // Membuat koneksi ke database
        } catch (SQLException e) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public boolean closeConnection() {
        boolean isSuccess = true;

        try {
            connection.close();
        } catch (SQLException e) {
            isSuccess = false;
        }

        return isSuccess;
    }

    private Statement createStatement() {
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
        }

        return statement;
    }

    public int insertData(FoodModel itemModel) {
        Statement statement = createStatement();
        int hasil = -1;
        java.sql.Date date = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());

        if (statement != null) {
            String sql = "INSERT INTO data_makanan(nama, deskripsi, rating, gambar, tanggal) VALUES("
                    + "'" + itemModel.getNama() + "', "
                    + "'" + itemModel.getDeskripsi() + "', "
                    + itemModel.getRating() + ", "
                    + "'file/default.png', "
                    + "'" + date + "')";
            try {
                hasil = statement.executeUpdate(sql);
            } catch (SQLException e) {
            }
        }

        return hasil;
    }

    public int updateData(FoodModel itemModel) {
        Statement statement = createStatement();
        int hasil = -1;

        if (statement != null) {
            String sql = "UPDATE data_makanan SET "
                    + "nama = '" + itemModel.getNama() + "', "
                    + "deskripsi = '" + itemModel.getDeskripsi() + "', "
                    + "rating = " + itemModel.getRating() + " "
                    + "WHERE id = " + itemModel.getId();

            try {
                hasil = statement.executeUpdate(sql);
            } catch (SQLException e) {
            }
        }

        return hasil;
    }
    
    public int updateGambar(String filename, int id) {
        Statement statement = createStatement();
        int hasil = -1;

        if (statement != null) {
            String sql = "UPDATE data_makanan SET "
                    + "gambar = 'file/" + filename + "' "
                    + "WHERE id = " + id;

            try {
                hasil = statement.executeUpdate(sql);
            } catch (SQLException e) {
            }
        }

        return hasil;
    }

    public ArrayList<FoodModel> showData() {
        ArrayList<FoodModel> dataList = null;
        Statement statement = createStatement();

        if (statement != null) {
            String sql = "SELECT * FROM data_makanan";
            ResultSet resultSet = null;

            try {
                resultSet = statement.executeQuery(sql);
            } catch (SQLException e) {
            }

            if (resultSet != null) {
                dataList = new ArrayList<>();

                try {
                    while (resultSet.next()) {
                        FoodModel itemModel = new FoodModel();

                        itemModel.setId(resultSet.getInt(1));
                        itemModel.setNama(resultSet.getString(2));
                        itemModel.setDeskripsi(resultSet.getString(3));
                        itemModel.setRating(resultSet.getInt(4));
                        itemModel.setGambar(resultSet.getString(5));

                        dataList.add(itemModel);
                    }
                } catch (SQLException e) {
                }
            }
        }

        return dataList;
    }

    public FoodModel showDataAtId(int id) {
        FoodModel model = null;
        Statement statement = createStatement();

        if (statement != null) {
            String sql = "SELECT * FROM data_makanan WHERE id = " + id;
            ResultSet resultSet = null;

            try {
                resultSet = statement.executeQuery(sql);
            } catch (SQLException e) {
            }

            if (resultSet != null) {
                model = new FoodModel();

                try {
                    while (resultSet.next()) {
                        model.setId(resultSet.getInt(1));
                        model.setNama(resultSet.getString(2));
                        model.setDeskripsi(resultSet.getString(3));
                        model.setRating(resultSet.getInt(4));
                        model.setGambar(resultSet.getString(5));
                    }
                } catch (SQLException e) {
                }
            }
        }

        return model;
    }

    public int deleteData(int id) {
        Statement statement = createStatement();
        int hasil = -1;

        if (statement != null) {
            String sql = "DELETE FROM data_makanan WHERE id = " + id;
            String sql2 = "ALTER TABLE data_makanan AUTO_INCREMENT = " + id;

            try {
                hasil = statement.executeUpdate(sql);
                hasil = statement.executeUpdate(sql2);
            } catch (SQLException e) {
            }
        }

        return hasil;
    }

    public Connection getConnection() {
        return connection;
    }
}