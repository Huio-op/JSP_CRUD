package com.br.web;

import com.br.dao.DBBook;
import com.br.dao.DataBaseException;
import com.br.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "editServlet", value = {"/edit"})
public class EditServlet extends HttpServlet {

    private String message;
    private DBBook dao;
    private Book book;

    public void init() {
        message = "Hello World!";
        this.dao = new DBBook();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getServletPath();

        int bookId = Integer.parseInt(request.getParameter("id"));
        try {
            this.book = dao.load(bookId);
            getServletContext().setAttribute("book", book);
        } catch (DataBaseException | SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/pages/edit.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        book.setCpf(request.getParameter("cpf"));
        book.setBookName(request.getParameter("bookName"));
        book.setPublishDate(Date.valueOf(request.getParameter("publishDate")));
        book.setEmail(request.getParameter("email"));
        book.setAuthorName(request.getParameter("authorName"));

        try {
            if (dao.edit(book)) {
                response.sendRedirect("listagem");
            }
        } catch (DataBaseException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
    }

}
