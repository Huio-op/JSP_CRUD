<%@ page import="com.br.dao.DBBook" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.br.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: felipe
  Date: 4/4/22
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/pages/listagem.css"/>
    <link rel="stylesheet" href="/pages/global.css">
    <script src="../validation/validation.js" type="text/javascript"></script>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
    />
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"
    ></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
</head>
<body>
<a href="/" class="buttonWrapper">
    <button type="button" class="btn btn-primary backButton">
        <span class="material-icons">
        arrow_back
        </span>
        <span>Voltar</span>
    </button>
</a>
<div class="BodyCard">

    <table>
        <thead>
        <th>
            Nome do Livro
        </th>
        <th>
            Data de Publicação
        </th>
        <th>
            Autor
        </th>
        <th>
            CPF do Autor
        </th>
        <th>
            E-mail do Autor
        </th>
        <th>
            Ações
        </th>
        <tbody>
        <c:forEach items="${booksList}" var="b">
            <tr>
                <td><c:out value="${b.bookName}"/></td>
                <td><c:out value="${b.publishDate}"/></td>
                <td><c:out value="${b.authorName}"/></td>
                <td><c:out value="${b.cpf}"/></td>
                <td><c:out value="${b.email}"/></td>
                <td class="actionCol">
                    <div class="actionsWrapper">
                        <form method="get" action="edit">
                            <button name="id" value='${b.id}' title="Editar" class="btn btn-success">
                            <span class="material-icons">
                                edit
                            </span>
                            </button>
                        </form>
                        <form method="post" action="delete">
                            <button name="id" value='${b.id}' title="Deletar" class="btn btn-danger">
                            <span class="material-icons">
                                delete
                            </span>
                            </button>
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
