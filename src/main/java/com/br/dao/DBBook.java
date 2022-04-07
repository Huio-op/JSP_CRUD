package com.br.dao;

import com.br.model.Book;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBBook {

    private DBConnection connection;

    public DBBook() {
        this.connection = DBApp.getConnection();
    }

    public boolean save(Book book) throws DataBaseException {

        if(book != null) {
            this.connection.connect();
            try {
                connection.runSQL("INSERT INTO book(cpf, email, publishdate, bookname, authorname) VALUES( '" + book.getCpf() + "', '"+book.getEmail()+"', " +
                        "'"+book.getPublishDate()+"', '"+book.getBookName()+"', '" + book.getAuthorName() + "');");
                return true;
            } catch (DataBaseException e) {
                e.printStackTrace();
                return false;
            } finally {
                this.connection.closeConnection();
            }

        }

        return false;

    }

    public boolean delete(int bookId) throws DataBaseException {

            this.connection.connect();
            connection.runSQL("DELETE FROM book WHERE id = '" + bookId + "';");
            this.connection.closeConnection();
            return true;

    }

    public boolean edit(Book book) throws DataBaseException {

        if(book != null) {
            this.connection.connect();
            connection.runSQL("UPDATE book SET bookName = '"+book.getBookName()+"', publishDate = '"+book.getPublishDate()+"', email = '" +book.getEmail()+"', " +
                    "authorName = '"+book.getAuthorName()+"', cpf = '" + book.getCpf() + "' " +
                    "WHERE id = '" + book.getId() + "';");

            this.connection.closeConnection();
            return true;

        }

        return false;

    }

    public Book load(int bookId) throws DataBaseException, SQLException {

        String sql = "SELECT * FROM book WHERE id = '"+bookId+"';";
        Book b = null;

        this.connection.connect();
        ResultSet rs = connection.runQuerySQL(sql);

        if(rs.isBeforeFirst()) {
            rs.next();
            String email = rs.getString("email");
            String bookName = rs.getString("bookName");
            String cpf = rs.getString("cpf");
            Date publishDate = rs.getDate("publishDate");
            String authorName = rs.getString("authorname");
            int id = rs.getInt("id");

            b = new Book(id, cpf,bookName,publishDate,email, authorName);

        }

        this.connection.closeConnection();
        return b;

    }

    public ArrayList<Book> loadAll() throws DataBaseException, SQLException {

        this.connection.connect();
        ArrayList<Book> array = new ArrayList<Book>();
        String sql = "SELECT * FROM book;";

        ResultSet rs = connection.runQuerySQL(sql);

        if(rs.isBeforeFirst()) {
            while(rs.next()) {

                String email = rs.getString("email");
                String bookName = rs.getString("bookName");
                String cpf = rs.getString("cpf");
                Date publishDate = rs.getDate("publishDate");
                String authorName = rs.getString("authorname");
                int id = rs.getInt("id");

                Book b = new Book(id, cpf,bookName,publishDate,email, authorName);
                array.add(b);
            }
        }

        this.connection.closeConnection();
        return array;

    }
}
