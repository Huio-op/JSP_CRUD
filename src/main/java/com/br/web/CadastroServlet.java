package com.br.web;

import com.br.dao.DBBook;
import com.br.dao.DataBaseException;
import com.br.model.Book;

import java.io.*;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "cadastroServlet", value = "/cadastro")
public class CadastroServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        getServletContext().getRequestDispatcher("/pages/cadastro.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String action = request.getServletPath();
        DBBook dao = new DBBook();
        Book book = new Book();


            book.setCpf(request.getParameter("cpf"));
            book.setBookName(request.getParameter("bookName"));
            book.setPublishDate(Date.valueOf(request.getParameter("publishDate")));
            book.setEmail(request.getParameter("email"));

            if (dao.save(book)) {
                response.sendRedirect("/pages/listagem.jsp");
            }

    }

    public void destroy() {
    }
}