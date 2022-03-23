/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kentank-ID
 */
public class TabelModel extends AbstractTableModel{
    private final String[] columnName = {"Id", "Nama", "Jenis", "Jumlah", "Deskripsi"};
    List<Barang> listBarang;
    
    public TabelModel (List<Barang> lb)
    {
        listBarang = lb;
    }
    
    @Override
    public int getRowCount(){
        return listBarang.size();
    }
    
    @Override
    public int getColumnCount(){
        return columnName.length;
    }
    
    public String getColumnName(int col) {
      return columnName[col];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex)
        {
            case 0:
                return listBarang.get(rowIndex).getId();
            case 1:
                return listBarang.get(rowIndex).getNama();
            case 2:
                return listBarang.get(rowIndex).getJenis();
            case 3:
                return listBarang.get(rowIndex).getJumlah();
            case 4:
                return listBarang.get(rowIndex).getDeskripsi();
            default:
                return null;
        }
    }
}
