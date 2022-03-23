/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Barang;
import Model.DABarang;
import Model.TabelModel;
import View.Menu;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Controller {
    Menu menu;
    DABarang Barang;
    List<Barang> listBarang;

    public Controller(Menu menu) {
        this.menu = menu;
        Barang = new DABarang();
        listBarang = Barang.getAll();
    }
    
    public void isiTable()
    {
        listBarang = Barang.getAll();
        TabelModel tmb = new TabelModel(listBarang);
        menu.getTabel().setModel(tmb);
    }
    
    public void insert()
    {
        if(!menu.getNama().trim().isEmpty())
        {
            Barang b = new Barang();
            b.setNama(menu.getNama());
            b.setJenis(menu.getJenis());
            b.setJumlah(menu.getJumlah());
            b.setDeskripsi(menu.getDeskripsi());
            Barang.insert(b);
            JOptionPane.showMessageDialog(null, "Simpan Sukses");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "NIK tidak boleh kosong");
        }
    }
    
    public void update()
    {
        if(!menu.getNama().trim().isEmpty())
        {
            Barang b = new Barang();
            b.setId(menu.getId());
            b.setNama(menu.getNama());
            b.setJenis(menu.getJenis());
            b.setJumlah(menu.getJumlah());
            b.setDeskripsi(menu.getDeskripsi());
            Barang.update(b);
            JOptionPane.showMessageDialog(null, "Update Sukses");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "NIK tidak boleh kosong");
        }
    }
    
    public void delete(){
        if(!menu.getNama().trim().isEmpty()) 
        {
            int b = menu.getId();
            Barang.delete(b);
            JOptionPane.showMessageDialog(null, "Delete Sukses");
        }
        else {
          JOptionPane.showMessageDialog(null, "NIK Tidak Boleh Kosong!");  
        }
    }
    
    public void isianForm(int indx)
    {
        menu.setId(listBarang.get(indx).getId());
        menu.setNama(listBarang.get(indx).getNama());
        menu.setJenis(listBarang.get(indx).getJenis());
        menu.setJumlah(listBarang.get(indx).getJumlah());
        menu.setDeskripsi(listBarang.get(indx).getDeskripsi());
    } 
    
    public void reset(){
        menu.setId(0);
        menu.setNama("");
        menu.setJumlah(0);
        menu.setDeskripsi("");
    }
}
