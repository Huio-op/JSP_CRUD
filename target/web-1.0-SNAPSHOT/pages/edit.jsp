<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.br.dao.DBConnection" %>
<%@ page import="com.br.dao.DBBook" %>
<%@ page import="com.br.model.Book" %>
<html>
<head>
    <title>Edição</title>
    <link rel="icon" href="/pages/resources/book-bookmark-icon_34486.ico">
    <link rel="stylesheet" href="/pages/cadastro.css" />
    <link rel="stylesheet" href="/pages/global.css">
    <script src="../validation/validation.js" type="text/javascript"></script>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
<a href="listagem" class="buttonWrapper">
    <button type="button" class="btn btn-primary backButton">
        <span class="material-icons">
        arrow_back
        </span>
        <span>Voltar</span>
    </button>
</a>
<div class="BodyCard">
    <form action="edit" method="post" onsubmit="return validate($(form))">
        <h1>Edite o Livro</h1>
        <div class="mb-3">
            <label class="form-label">Nome do Livro</label>
            <input type="text" class="form-control" name="bookName" value="${book.bookName}"/>
        </div>
        <div class="mb-3" style="width: 100%">
            <label class="control-label" id="campo">Data de Publicação</label>
            <input type="date" class="form-control" name="publishDate" value="${book.publishDate}" />
        </div>
        <div class="mb-3" style="width: 100%">
            <label class="control-label" id="campo">Nome do Autor</label>
            <input type="text" class="form-control" name="authorName" value="${book.authorName}"/>
        </div>
        <div class="mb-3" style="width: 100%">
            <label class="control-label" id="campo">CPF do Autor</label>
            <input id="cpf" type="text" class="form-control" name="cpf" maxlength="11" oninput="cpfMask(this)" value="${book.cpf}" />
        </div>
        <div class="mb-3">
            <label class="form-label">Email de Contato</label>
            <input
                    type="email"
                    class="form-control"
                    name="email"
                    aria-describedby="emailHelp"
                    value="${book.email}"
            />
        </div>
        <button type="submit" class="btn btn-primary">
            Editar
        </button>
        <a href="listagem">
            <button type="button" class="btn btn-primary">
                Cancelar
            </button>
        </a>
    </form>

</div>

</body>
</html>