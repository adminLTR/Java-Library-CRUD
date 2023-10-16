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
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author usuario
 */
public class Controller {
    private FrmMain view;
    private JConnection connection;
    private int selectedId = -1; // if search button is pressed, book's id will be set in this variable in case we want to update book's information
    public Controller(FrmMain v) {
        connection = new JConnection();
        this.view = v;
        fillTable(getBooks());
        
        // register button
        this.view.registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get all input values
                String name = view.nameField.getText();
                String desc = view.descriptionTxtArea.getText();
                String author = view.authorField.getText();
                int stock = Integer.parseInt(view.stockField.getText());
                String category = view.categoryField.getText();
                Book book = new Book(name, author, desc, stock, category);
                //If registration success, reloads the table and clear all input fields
                if (register(book) == 1) {
                    JOptionPane.showMessageDialog(view, "Book succesfully registered.");
                    fillTable(getBooks());
                    clear();
                    selectedId = -1;
                } else {
                    JOptionPane.showMessageDialog(view, "Error");
                }
            }
        });
        // search button
        this.view.searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* 
                you input an ID and searches in DDBB,
                in case it's not found, shows an error message, else, fill all inputs with book's information
                */
                int id = Integer.parseInt(JOptionPane.showInputDialog(view, "Insert book's ID:"));
                Book book = getBookByID(id);
                if (book==null) {
                    JOptionPane.showMessageDialog(view, "Book not found");
                } else {
                    view.nameField.setText(book.getName());
                    view.descriptionTxtArea.setText(book.getDescription());
                    view.stockField.setText(book.getStock()+"");
                    view.authorField.setText(book.getAuthor());
                    view.categoryField.setText(book.getCategory());
                    selectedId = id; // sets variable value in case we want to update this information
                }
            }
        });
        // update button
        this.view.updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                Uses 'selectedId' variable to update this book's information, considering input
                fields as the new values.
                */
                String name = view.nameField.getText();
                String desc = view.descriptionTxtArea.getText();
                String author = view.authorField.getText();
                int stock = Integer.parseInt(view.stockField.getText());
                String category = view.categoryField.getText();
                Book book = new Book(name, author, desc, stock, category);
                if (update(selectedId, book)==1) {
                    JOptionPane.showMessageDialog(view, "Successfully updated book "+selectedId);
                    fillTable(getBooks());
                    selectedId = -1;
                    clear();
                } else {
                    JOptionPane.showMessageDialog(view, "Error");
                }
            }
        });
        // delete button
        this.view.deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                Just ask for an ID and deletes book's information if found. Shows an error message in other case
                */
                int id = Integer.parseInt(JOptionPane.showInputDialog(view, "Insert book's ID:"));
                if (delete(id) == 1) {
                    JOptionPane.showMessageDialog(view, "Successfully deleted book "+id);
                    fillTable(getBooks());
                    selectedId = -1;
                    clear();    
                } else {
                    JOptionPane.showMessageDialog(view, "Error");
                }
            }
        });
        // clear button
        this.view.clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // clears the screen and reloads table
                clear();
                selectedId = -1;
                fillTable(getBooks());
            }
        });
    }
    
    public void run() {
        this.view.setVisible(true);
        view.setLocationRelativeTo(null);
    }

    private Book getBookByID(int id) {        
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from books where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setDescription(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setStock(rs.getInt(5));
                book.setCategory(rs.getString(6));
                return book;
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }
    // get all books
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
        } catch (SQLException e) {
            return r;
        }  
        return r;
    }
    
    private int update(int id, Book book) {  
        int r=0;
        String sql="update books set name=?,description=?,author=?, stock=?, category=? where id=?";        
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setString(1,book.getName());
            ps.setString(2,book.getDescription());
            ps.setString(3,book.getAuthor());
            ps.setInt(4,book.getStock());
            ps.setString(5,book.getCategory());
            ps.setInt(6,id);
            r=ps.executeUpdate();                
        } catch (SQLException e) {
            r = -1;
        }  
        return r;
    }
    
    public int delete(int id){
        int r = 0;
        String sql="delete from books where id="+id;
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (Exception e) {
            r = -1;
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
