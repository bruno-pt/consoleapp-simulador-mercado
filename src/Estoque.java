import java.util.ArrayList;
import java.util.Iterator;

public class Estoque {
    private int i;
    protected int teste = 4;
    //ArrayList<Produto> estoque;
    protected static ArrayList<Produto> setorAlimento;
    protected static ArrayList<Produto> setorLimpeza;
    protected static ArrayList<Produto> setorAcougue;
    protected static ArrayList<Produto> setorBebidas;
    protected static ArrayList<Produto> setorHortifruti;
    protected static ArrayList<Produto> setorPadaria;

    Estoque(){
        //estoque = new ArrayList<Produto>();
        setorAlimento = new ArrayList<Produto>();
        setorLimpeza = new ArrayList<Produto>();
        setorAcougue = new ArrayList<Produto>();
        setorBebidas = new ArrayList<Produto>();
        setorHortifruti = new ArrayList<Produto>();
        setorPadaria = new ArrayList<Produto>();
    }

    public void consultaSetorAlimento() {
        for(Produto produto: setorAlimento){System.out.println(produto);}
    }

    public void consultaSetorLimpeza() {
        for(Produto produto: setorLimpeza){System.out.println(produto);}
    }

    public void consultaSetorAcougue() {
        for(Produto produto: setorAcougue){System.out.println(produto);}
    }

    public void consultaSetorBebidas() {
        for(Produto produto: setorBebidas){System.out.println(produto);}
    }

    public void consultaSetorHortifruti() {
        for(Produto produto: setorHortifruti){System.out.println(produto);}
    }

    public void consultaSetorPadaria() {
        for(Produto produto: setorPadaria){System.out.println(produto);}
    }

    public ArrayList<Produto> getSetorAlimento() {
        return setorAlimento;
    }

    //acredito que deve ser jogado na classe do Cliente
    /*public void consultarEstoque() {
        System.out.println("======================");
        System.out.println("| Consutando Estoque |");
        System.out.println("======================");


        Iterator itLimpeza = this.setorLimpeza.iterator();
        Iterator itAcougue = this.setorAcougue.iterator();
        Iterator itBebidas = this.setorBebidas.iterator();
        Iterator itHortifruti = this.setorHortifruti.iterator();
        Iterator itPadaria = this.setorPadaria.iterator();

        Produto produto;

        //apagar
        while(var2.hasNext()) {
            Produto produto = (Produto)var2.next();
            System.out.println(produto.getNome()+ " - " + "Quantidade: " + produto.getQuantidade() + " preço: R$" + produto.getPreco());
        }

        System.out.println("Setor - Alimentos");
        while(itAlimento.hasNext()) {
            produto = (Produto)itAlimento.next();
            System.out.println(produto);
        }

        System.out.println("Setor - Limpeza");
        while(itLimpeza.hasNext()) {
            produto = (Produto)itLimpeza.next();
            System.out.println(produto);
        }

        System.out.println("Setor - Acougue");
        while(itAcougue.hasNext()) {
            produto = (Produto)itAcougue.next();
            System.out.println(produto);
        }

        System.out.println("Setor - Bebidas");
        while(itBebidas.hasNext()) {
            produto = (Produto)itBebidas.next();
            System.out.println(produto);
        }

        System.out.println("Setor - Hortifruti");
        while(itHortifruti.hasNext()) {
            produto = (Produto)itHortifruti.next();
            System.out.println(produto);
        }

        System.out.println("Setor - Padaria");
        while(itPadaria.hasNext()) {
            produto = (Produto)itPadaria.next();
            System.out.println(produto);
        }*/

}
