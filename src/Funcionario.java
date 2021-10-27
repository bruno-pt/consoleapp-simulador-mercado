import java.util.ArrayList;

public class Funcionario {
    private String nome;
    private int idade;
    ArrayList<Float> vendas = new ArrayList<Float>();


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

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", vendas=" + vendas +
                '}';
    }
}