public class Gerente {
    private String nome;
    private int idade;

    Gerente(String nome, int idade){
        this.idade = idade;
        this.setNome(nome);
    }
    public String getNome() {
        return nome;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }

}

