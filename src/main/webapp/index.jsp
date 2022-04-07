<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
    <link rel="stylesheet" href="index.css" />
    <link rel="stylesheet" href="/pages/global.css">
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
</head>
<body>
<div class="HomeCard">
    <h1>
        HOME
    </h1>
    <ul class="buttonUl">
        <div class="linksWrapper">
            <form method="get" action="cadastro">
                <button class="btn btn-primary">
                            Cadastro
                </button>
            </form>
            <form method="get" action="listagem">
                <button class="btn btn-primary">
                    Listagem
                </button>
            </form>
        </div>
    </ul>
</div>
</body>
</html>
