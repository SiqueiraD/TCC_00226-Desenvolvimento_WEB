
<%@page import="aplicacao.Administradores"%>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop" id="novoAdm">
    Novo
</button>
<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Cadastro</h5>
                <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <h4>Administrador</h4> 
                <div class="col-6 mt-5">

                    <%
                        if (request.getAttribute("editar") != null) {
                            Administradores admin = (Administradores) request.getAttribute("admin");
                    %>

                    <form method="POST" action="Administrador" name="fvalida" >


                        <input type="hidden" name="tipo" value="editarAdministrador" >
                        <input type="hidden" name="id" value="<% out.println(admin.getId()); %>" >

                        <div class="form-group">
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" name="nome" required size="30" maxlength="100" placeholder="Seu Nome" value="<% out.println(admin.getNome()); %>">
                        </div>
                        <div class="form-group">
                            <label for="login">CPF</label>
                            <input type="text" class="form-control" name="login" required size="30" maxlength="100" value="<% out.println(admin.getCpf()); %>">
                        </div>
                        <div class="form-group">
                            <label for="senha">Senha</label>
                            <input type="password" class="form-control"  name="senha" required size="3" maxlength="3" value="<% out.println(admin.getSenha()); %>">
                        </div>
                        <button type="submit" class="btn btn-primary">Editar</button>
                    </form>
                    <%  } else { %>  
                    <form method="POST" action="Administrador" name="fvalida" >


                        <input type="hidden" name="tipo" value="cadastroAdministrador" >

                        <div class="form-group">
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" name="nome" required size="30" maxlength="100" placeholder="Seu Nome">
                        </div>
                        <div class="form-group">
                            <label for="login">CPF</label>
                            <input type="text" class="form-control" name="login" required size="30" maxlength="100" placeholder="Seu cpf">
                        </div>
                        <div class="form-group">
                            <label for="senha">Senha</label>
                            <input type="password" class="form-control"  name="senha" required size="3" maxlength="3" placeholder="Sua Senha">
                        </div>
                        <button type="submit" class="btn btn-primary">Criar</button>
                    </form>
                    <%  }%>  
                </div>
            </div>
                <!--            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>-->
        </div>
    </div>
</div>

<script>
    <%
        if (request.getAttribute("editar") != null) {
    %>

    window.onload = function () {
        $('#novoAdm').click();
    }

    <%  }%>
</script>