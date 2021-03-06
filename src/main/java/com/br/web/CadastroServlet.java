package com.br.web;

import com.br.dao.DBBook;
import com.br.dao.DataBaseException;
import com.br.model.Book;

import java.io.*;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "cadastroServlet", value = {"/cadastro"})
public class CadastroServlet extends HttpServlet {
    private String message;
    private DBBook dao;

    public void init() {
        message = "Hello World!";
        this.dao = new DBBook();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getServletPath();

        if (action.equals("/edit")) {
            int bookId = Integer.parseInt(request.getParameter("id"));
            try {
                Book book = dao.load(bookId);
                getServletContext().setAttribute("book", book);
            } catch (DataBaseException | SQLException e) {
                e.printStackTrace();
            }
        }

        getServletContext().getRequestDispatcher("/pages/cadastro.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        Book book = new Book();
        book.setCpf(request.getParameter("cpf"));
        book.setBookName(request.getParameter("bookName"));
        book.setPublishDate(Date.valueOf(request.getParameter("publishDate")));
        book.setEmail(request.getParameter("email"));
        book.setAuthorName(request.getParameter("authorName"));

        try {
            if (dao.save(book)) {
                response.sendRedirect("listagem");
            }
        } catch (DataBaseException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
    }
}