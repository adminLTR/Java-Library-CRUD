/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import model.Book;
import model.JConnection;
import view.FrmMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author usuario
 */
public class Controller {
    private FrmMain view;
    private JConnection connection;
    public Controller(FrmMain v) {
        connection = new JConnection();
        this.view = v;
        fillTable(getBooks());
        
        this.view.registerBtn.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.nameField.getText();
                String desc = view.descriptionTxtArea.getText();
                String author = view.authorField.getText();
                int stock = Integer.parseInt(view.stockField.getText());
                String category = view.categoryField.getText();
                Book book = new Book(name, author, desc, stock, category);
                if (register(book) == 1) {
                    JOptionPane.showMessageDialog(view, "Book succesfully registered.");
                    fillTable(getBooks());
                    clear();
                } else {
                    JOptionPane.showMessageDialog(view, "Error");
                }
            }
        });
    }
    
    public void run() {
        this.view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
    
    private LinkedList<Book> getBooks() {
        LinkedList<Book> books = new LinkedList<>();
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from books");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setDescription(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setStock(rs.getInt(5));
                book.setCategory(rs.getString(6));
                books.add(book);
            }
        } catch (Exception e) {
            return null;
        }
        return books;
    }
    public int register(Book book) {  
        int r=0;
        String sql="insert into books(name,description,author,stock,category)values(?,?,?,?,?)";
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);            
            ps.setString(1,book.getName());
            ps.setString(2,book.getDescription());
            ps.setString(3,book.getAuthor());
            ps.setInt(4,book.getStock());
            ps.setString(5,book.getCategory());
            r = ps.executeUpdate();    
        } catch (Exception e) {
        }  
        return r;
    }
    
    private void fillTable(LinkedList<Book> books) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Description");
        model.addColumn("Author");
        model.addColumn("Stock");
        model.addColumn("Category");
        for (Book b : books) {
            model.addRow(new Object[] {b.getId(), b.getName(), b.getDescription(), b.getAuthor(), b.getStock(), b.getCategory()});
        }
        this.view.table.setModel(model);
    }
    
    private void clear() {
        view.nameField.setText("");
        view.descriptionTxtArea.setText("");
        view.stockField.setText("");
        view.authorField.setText("");
        view.categoryField.setText("");
    }
}
