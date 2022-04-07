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

@WebServlet(name = "deleteServlet", value = {"/delete"})
public class DeleteServlet extends HttpServlet {

    private String message;
    private DBBook dao;

    public void init() {
        message = "Hello World!";
        this.dao = new DBBook();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int bookId = Integer.parseInt(request.getParameter("id"));
            if (dao.delete(bookId)) {
                response.sendRedirect("listagem");
            }
        } catch (DataBaseException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
    }

}
