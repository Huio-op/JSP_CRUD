package com.br.model;

import java.sql.Date;

public class Book {

    private String cpf;
    private String bookName;
    private Date publishDate;
    private String email;

    public Book() {

    }

    public Book(String cpf, String bookName, Date publishDate, String email) {
        this.cpf = cpf;
        this.bookName = bookName;
        this.publishDate = publishDate;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
