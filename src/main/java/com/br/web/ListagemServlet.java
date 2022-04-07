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
import java.util.ArrayList;

@WebServlet(name = "listagemServlet", value = {"/listagem"})
public class ListagemServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            DBBook db = new DBBook();
            ArrayList<Book> books = db.loadAll();

            getServletContext().setAttribute("booksList", books);
            getServletContext().getRequestDispatcher("/pages/listagem.jsp").forward(request,response);
        } catch (DataBaseException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    public void destroy() {
    }

}
