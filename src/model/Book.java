/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author usuario
 */
public class Book {
    private String name;
    private String author;
    private String description;
    private int id;
    private int stock;
    private String category;

    public Book() {
    }

    public Book(String name, String autor, String description, int id, int stock, String category) {
        this.name = name;
        this.author = autor;
        this.description = description;
        this.id = id;
        this.stock = stock;
        this.category = category;
    }

    public Book(String name, String author, String description, int stock, String category) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.stock = stock;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
