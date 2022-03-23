/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DABarang {
    Connection con;
    final String queryInsert = "INSERT INTO barang (nama, jenis, jumlah, deskripsi) values(?,?,?,?);";
    final String querySelect = "select * from barang;";
    final String queryUpdate = "update barang set nama=?, jenis=?, jumlah=?, deskripsi=? where id=?;";
    final String queryDelete = "delete from barang where id=?;";
    
    public DABarang() 
    {
        con = Koneksi.getConnection();
    }

    public void insert(Barang b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(queryInsert);
            statement.setString(1, b.getNama());
            statement.setString(2, b.getJenis());
            statement.setInt(3, b.getJumlah());
            statement.setString(4, b.getDeskripsi());
            System.out.println("berhasil input");
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Gagal Input");
        }
    }
    
    public void update(Barang b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(queryUpdate);
            statement.setString(1, b.getNama());
            statement.setString(2, b.getJenis());
            statement.setInt(3, b.getJumlah());
            statement.setString(4, b.getDeskripsi());
            statement.setInt(5, b.getId());
            System.out.println("berhasil update");
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Gagal update" + ex);
        }
    }

    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(queryDelete);
            statement.setInt(1, id);
            System.out.println("berhasil update");
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Gagal update" + e);
        }
    }

    public List<Barang> getAll() {
        List<Barang> listBarang = null;
        try {
            listBarang = new ArrayList<Barang>();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(querySelect);
            while(result.next()) {
                Barang b = new Barang();
                b.setId(result.getInt("id"));
                b.setNama(result.getString("nama"));
                b.setJenis(result.getString("jenis"));
                b.setJumlah(result.getInt("jumlah"));
                b.setDeskripsi(result.getString("deskripsi"));
                listBarang.add(b);
            }
        } catch (SQLException error) {
                System.out.println("Gagal" + error);
        }
        return listBarang;
    }
}
