<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.br.dao.DBConnection" %>
<%@ page import="com.br.dao.DBBook" %>
<%@ page import="com.br.model.Book" %>
<html>
<head>
    <title>Cadastro</title>
    <link rel="stylesheet" href="/pages/cadastro.css" />
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
</head>
<body>
<div class="CadastroCard">
    <form action="cadastro" method="post" onsubmit="return validate($(form))">
        <h1>Cadastre seu Livro</h1>
        <div class="mb-3">
            <label class="form-label">Nome do Livro</label>
            <input type="text" class="form-control" name="bookName" />
        </div>
        <div class="mb-3" style="width: 100%">
            <label class="control-label" id="campo">Data de Publicação</label>
            <input type="date" class="form-control" name="publishDate" />
        </div>
        <div class="mb-3" style="width: 100%">
            <label class="control-label" id="campo">Nome do Autor</label>
            <input type="text" class="form-control" name="authorName"/>
        </div>
        <div class="mb-3" style="width: 100%">
            <label class="control-label" id="campo">CPF do Autor</label>
            <input id="cpf" type="text" class="form-control" name="cpf" maxlength="11" oninput="cpfMask(this)" />
        </div>
        <div class="mb-3">
            <label class="form-label">Email de Contato</label>
            <input
                    type="email"
                    class="form-control"
                    name="email"
                    aria-describedby="emailHelp"
            />
        </div>
        <button type="submit" class="btn btn-primary">
            Criar
        </button>
        <a href="/">
            <button type="button" class="btn btn-primary">
                Voltar
            </button>
        </a>
    </form>

</div>

</body>
</html>