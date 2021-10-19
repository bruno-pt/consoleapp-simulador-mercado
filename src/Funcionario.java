public class Funcionario {
    private String nome;
    private int idade;

    Funcionario(String nome, int idade){
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