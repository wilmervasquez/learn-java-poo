package com.wvl;

import com.wvl.gui.WindowView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Book {
  String id;
  String titulo;
  String autor;
  String editora;

  Book(String titulo, String autor, String editora) {
    this.id = UUID.randomUUID().toString();
    this.titulo = titulo;
    this.autor = autor;
    this.editora = editora;
  }
}

class Library {
  List<Book> books;
  Library() {
    this.books = new ArrayList<>();
  }
  void addBook(Book book) {
    this.books.add(book);
  }
  void deleteBook(Book book) {
    books.remove(book);
  }
}
public class Main {
  public static void main(String[] args) {
    System.out.println(Math.sin(Math.toRadians(60)));

    WindowView windowView = new WindowView();
    windowView.size();
    String bug = JOptionPane.showInputDialog("Ingrese su nombre: ");
    String bug2 = JOptionPane.showInputDialog("Ingrese su nombre: ");
    JOptionPane.showMessageDialog(null,"222");

    System.out.println(bug);

    Library library = new Library();

    library.addBook(new Book("Principito", "Diego", "IBMD"));
  }
}