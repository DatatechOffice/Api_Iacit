<?php
    if(isset($_POST['submit'])) {
        include_once('conexao.php');

        $inputNome = $_POST['inputNome'];
        $inputEmail = $_POST['inputEmail'];
        $inputPassword = $_POST['inputPassword'];

        $result = postgres_query(
            $conexao, "INSERT INTO usuario(
                usu_nome, usu_email, usu_senha
            ) VALUES(
                '$inputNome', '$inputEmail', '$inputPassword'
            )"
        );
    }
?>

<!doctype html>
<html lang="pt-br">
    <head>
        <title>Cadastro</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
            rel="stylesheet" 
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
            crossorigin="anonymous"
        >
        <link href="../static/css/cadastro.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
                <!-- Esse Div armazena as opções do -->
                <div class="container-fluid">
                    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link" 
                                aria-current="page" 
                                href="../templates/index.html">
                                    Home
                                </a>
                            </li>
                            <!-- Encaminha para os filtros-->
                            <li class="nav-item">
                                <a
                                    class="nav-link"
                                    aria-current="page"
                                    href="../templates/cadastro.html"
                                >
                                    Cadastro de Usuário
                                </a>
                            </li>
                            <li class="nav-item dropdown">
                                <a
                                    class="nav-link dropdown-toggle me-2" href="#" id="navbarDropdown"
                                    role="button" data-bs-toggle="dropdown" aria-expanded="false"
                                >
                                    Menu
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li>
                                        <a class="dropdown-item" href="#">Configurações de Usuário</a>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="../templates/login.html">Logout</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- Final do Div das opções do menu -->
            <br><br>
        </header>
        <div class="cadastro" action="cadastro.php" method="POST"> 
            <form class="row g-3">
                <h1 class="text-center">Cadastro de Usuário</h1>
                <div class="col-12">
                    <label for="inputNome" class="form-label">Nome Completo</label>
                    <input type="text" class="form-control" name="inputNome" id="inputNome">
                </div>
                <div class="col-12">
                    <label for="inputEmail4" class="form-label">Email</label>
                    <input type="email" class="form-control" name="inputEmail" id="inputEmail">
                </div>
                <div class="col-md-4">
                    <label for="inputPassword" class="form-label">Senha</label>
                    <input type="password" class="form-control" name="inputPassword" id="inputPassword">
                </div>
                <div class="col-md-4">
                    <label for="inputRepeatPassword" class="form-label">Repetir Senha</label>
                    <input
                        type="password" class="form-control" 
                        name="inputRepeatPassword" id="inputRepeatPassword"
                    >
                </div>
                <div class="col-12">
                    <button id="buttonCad" name="submit" type="submit" class="btn btn-primary">
                        Cadastrar
                    </button>
                </div>
            </form>
        </div>
        <!-- Optional JavaScript; choose one of the two! -->
        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous">
        </script>
        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous">
        </script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" 
            crossorigin="anonymous">
        </script>
        -->
    </body>
</html>    