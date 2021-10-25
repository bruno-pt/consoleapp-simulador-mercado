import java.util.ArrayList;
import java.util.Iterator;

public class Estoque {
    private int i;
    ArrayList<Produto> estoque;

    Estoque(){
        estoque = new ArrayList<Produto>();

    }
    void receberProduto(Produto produto){
        estoque.add(produto);
    }

    public void visitar() {
        System.out.println();
        System.out.println("Consutando Estoque");
        Iterator var2 = this.estoque.iterator();

        while(var2.hasNext()) {
            Produto produto = (Produto)var2.next();
            System.out.println("Nome: " + produto.getNome()+ " - " + "Quantidade: " + produto.getQuantidade());
        }

    }


    public void visita(){
        for(Produto produto: estoque){
            System.out.println("Produto: " + produto.getNome() + " Quantidade: " + produto.getQuantidade() );
        }
    }



}
