/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.program.services;

import com.program.dao.FoodDAO;
import java.util.List;
import com.program.models.FoodModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diknas 113
 */
@Service
public class FoodManager {
    @Autowired
    FoodDAO dao;
    
    public List<FoodModel> getAllFoodData()
    {
        boolean isSuccess = dao.createConnection();
        List foodList = null;
        
        if (isSuccess) {
            foodList = dao.showData();
        }
        dao.closeConnection();
        return foodList;
    }
    
    public FoodModel getFoodData(int id)
    {
        FoodModel model = null;
        boolean isSuccess = dao.createConnection();

        if (isSuccess) {
            model = dao.showDataAtId(id);

            if (model == null)
                System.out.print("<script> alert('Data tidak ditemukan'); </script>");
        } else
            System.out.print("<script> alert('Koneksi gagal dibuat'); </script>");
        
        dao.closeConnection();
        return model;
    }
    
    public void addFoodData(FoodModel foodModel)
    {
        boolean isSuccess = dao.createConnection();
        if (isSuccess) {
            int hasil = dao.insertData(foodModel);
            if (hasil == 1)
                System.out.print("<script> alert('Data berhasil ditambahkan'); </script>");
            else
                System.out.print("<script> alert('Data tidak berhasil ditambahkan'); </script>");
        } else
            System.out.print("<script> alert('Koneksi gagal dibuat'); </script>");
        dao.closeConnection();
    }
    
    public void updateFoodData(FoodModel foodModel)
    {
        boolean isSuccess = dao.createConnection();
        if (isSuccess) {
            int hasil = dao.updateData(foodModel);
            if (hasil == 1)
                System.out.print("<script> alert('Data berhasil ditambahkan'); </script>");
            else
                System.out.print("Gagal"+ foodModel.toString());
        } else
            System.out.print("<script> alert('Koneksi gagal dibuat'); </script>");
        dao.closeConnection();
        
    }
    
    public void updateFoodPicture(String fileName, int id)
    {
        boolean isSuccess = dao.createConnection();
        if (isSuccess) {
            int hasil = dao.updateGambar(fileName, id);
            if (hasil == 1)
                System.out.print("<script> alert('Data berhasil ditambahkan'); </script>");
            else
                System.out.print("<script> alert('Data tidak berhasil ditambahkan'); </script>");
        } else
            System.out.print("<script> alert('Koneksi gagal dibuat'); </script>");
        dao.closeConnection();
    }
    
    public void deleteFoodData(int id)
    {
        boolean isSuccess = dao.createConnection();
        if (isSuccess) {
            int hasil = dao.deleteData(id);
            if (hasil == 1)
                System.out.print("<script> alert('Data berhasil ditambahkan'); </script>");
            else
                System.out.print("<script> alert('Data tidak berhasil ditambahkan'); </script>");
        } else
            System.out.print("<script> alert('Koneksi gagal dibuat'); </script>");
        dao.closeConnection();
    }
    
}
