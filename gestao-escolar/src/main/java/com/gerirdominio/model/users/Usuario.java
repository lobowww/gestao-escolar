package com.gerirdominio.model.users;

public abstract class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String login;
    private String senha;
    
    protected Usuario(int id, String nome, String cpf, String telefone, String email, String login, String senha) {//Construtor com validação geral dos dados
        if (nome == null || nome.isEmpty() ||
        cpf == null || cpf.isEmpty() ||
        telefone == null || telefone.isEmpty() ||
        email == null || email.isEmpty() ||
        login == null || login.isEmpty() ||
        senha == null || senha.isEmpty()) {
        throw new IllegalArgumentException("Todos os campos do usuário devem ser preenchidos.");
        }
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    //Falta método autenticar para login
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("O CPF não pode ser vazio.");
        }
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("O E-mail não pode ser vazio.");
        }
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("O Login não pode ser vazio.");
        }
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String novaSenha) {
        if (novaSenha == null || novaSenha.isEmpty()) {
            throw new IllegalArgumentException("A Senha não pode ser vazia.");
        }
        if(this.senha != null && this.senha.equals(novaSenha)){//Verificação se senha nova é igual a atual
            throw new IllegalArgumentException("A nova senha não pode ser igual à senha atual.");
        }
        this.senha = novaSenha;
    }
      
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isEmpty()) {
            throw new IllegalArgumentException("O Telefone não pode ser vazio.");
        }
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Usuario #" + id + 
        "\nNome: " + nome + 
        "\nCPF: " + cpf + 
        "\nTelefone: " + telefone + 
        "\nEmail: " + email + 
        "\nLogin: " + login;//Sem mostrar a senha por mmotivos óbvios
    }
}
