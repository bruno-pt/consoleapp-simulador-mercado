import java.util.ArrayList;

public class Produto {
    private String nome;
    private int quantidadeEstoque;
    private int quantidadeCompra = 0;
    private float precoUni;

    public Produto(String nome, int quantidadeEstoque, float precoUni) {
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoUni = precoUni;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", estoque=" + quantidadeEstoque +
                ", preco(un)=" + precoUni +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setQuantidadeCompra(int quantidadeCompra) {
        this.quantidadeCompra = quantidadeCompra;
    }

    public int getQuantidadeCompra() {
        return quantidadeCompra;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public float getPrecoUni() {
        return precoUni;
    }
}