package com.br.dao;

import com.br.model.Book;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBBook {

    private DBConnection connection;

    public DBBook() {
        try {
            this.connection = new DBConnection("zfjgczrr", "w3OCd4WUkIzTSPQr8uMbdftKUsmZKxlb", "zfjgczrr", "tuffi.db.elephantsql.com", "5432");
            this.connection.connect();
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
    }

    public boolean save(Book book) {

        if(book != null) {

            try {
                connection.runSQL("INSERT INTO book(cpf, email, publishdate, bookname) VALUES( '" + book.getCpf() + "', '"+book.getEmail()+"', " +
                        "'"+book.getPublishDate()+"', '"+book.getBookName()+"');");
                return true;
            } catch (DataBaseException e) {
                e.printStackTrace();
                return false;
            }

        }

        return false;

    }

    public void delete(Book book) throws DataBaseException {

        if(book != null){

            connection.runSQL("DELETE FROM book WHERE cpf = '" + book.getCpf() + "';");

        }

    }

    public void edit(Book book) throws DataBaseException {

        if(book != null) {

            connection.runSQL("UPDATE book SET bookName = '"+book.getBookName()+"', publishDate = '"+book.getPublishDate()+"', email = " +book.getEmail()+" "+
                    "WHERE cpf = '" + book.getCpf() + "';");

        }

    }

    public Book load(String cpfToFind) throws DataBaseException, SQLException {

        String sql = "SELECT * FROM book WHERE cpf = '"+cpfToFind+"';";
        Book b = null;

        ResultSet rs = connection.runQuerySQL(sql);

        if(rs.isBeforeFirst()) {
            rs.next();
            String email = rs.getString("email");
            String bookName = rs.getString("bookName");
            String cpf = rs.getString("cpf");
            Date publishDate = rs.getDate("publishDate");

            b = new Book(cpf,bookName,publishDate,email);

        }

        return b;

    }

    public ArrayList<Book> loadAll() throws DataBaseException, SQLException {

        ArrayList<Book> array = new ArrayList<Book>();
        String sql = "SELECT * FROM book;";

        ResultSet rs = connection.runQuerySQL(sql);

        if(rs.isBeforeFirst()) {
            while(rs.next()) {

                String email = rs.getString("email");
                String bookName = rs.getString("bookName");
                String cpf = rs.getString("cpf");
                Date publishDate = rs.getDate("publishDate");

                Book b = new Book(cpf,bookName,publishDate,email);
                array.add(b);
            }
        }

        return array;

    }
}
