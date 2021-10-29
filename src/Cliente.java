import java.util.*;

public class Cliente {
    static int corredorAtual;
    static String setorAtual;
    static int caixaEscolhido;
    static ArrayList<Produto> carrinho = new ArrayList<Produto>();

    public void corredores(){
        Scanner sc = new Scanner(System.in);
        int option=0;
        try {
            System.out.println("$ Tipo Login > Cliente");
            System.out.println("===========================");
            System.out.println("Corredor - Setor");
            System.out.println("===========================");
            System.out.println("1 - Alimentos");
            System.out.println("2 - Limpeza");
            System.out.println("3 - Acougue, Bebidas");
            System.out.println("4 - Hortifruti, Padaria");
            System.out.println();
            System.out.println("Any Number - Para voltar");
            System.out.println("===========================");
            System.out.print("Digite o numero do corredor > ");
            option = sc.nextInt();

        }catch (InputMismatchException ex){
            Principal.clear();
            System.out.println("Erro! Opção Inválida!\nException{"+ex.toString()+'}');
            System.out.print("\nPressione qualquer tecla para continuar > ");
            sc.nextLine();
            sc.nextLine();
            Principal.clear();
            corredores();
        }


        if(option >=1 && option <=4) {
            this.corredorAtual = option;
            setores();
        }
        else{
            Principal.clear();
            Principal.opSistema();
        }
    }

    public void setores(){

        Scanner sc = new Scanner(System.in);

        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
        System.out.println("$ Tipo Login > Cliente");
        System.out.println("=============================");
        System.out.println("Setores do corredor atual (" + this.corredorAtual + ")");
        System.out.println("=============================");

        switch (this.corredorAtual){
            case 1:
                System.out.println("{Alimentos}");
                break;

            case 2:
                System.out.println("{Limpeza}");
                break;

            case 3:
                System.out.print("{Acougue, ");
                System.out.println("Bebidas}");
                break;

            case 4:
                System.out.print("{Hortifruti, ");
                System.out.println("Padaria}");
                break;
        }
        System.out.println();
        System.out.println("Any - Para voltar");
        System.out.println("==========================");
        System.out.print("Digite o nome do setor > ");

        String option = sc.nextLine().toLowerCase();

        if(this.corredorAtual == 1 && option.equals("alimentos")){
            this.setorAtual = option;
            consultarProdutos();
        }
        else if(this.corredorAtual == 2 && option.equals("limpeza")){
            this.setorAtual = option;
            consultarProdutos();
        }
        else if(this.corredorAtual == 3 && (option.equals("acougue") || option.equals("bebidas"))){
            this.setorAtual = option;
            consultarProdutos();
        }
        else if(this.corredorAtual == 4 && (option.equals("hortifruti") || option.equals("padaria"))){
            this.setorAtual = option;
            consultarProdutos();
        }
        else{
            Principal.clear();
            corredores();
        }
    }

    public void consultarProdutos(){

        Scanner sc = new Scanner(System.in);

        Principal.clear();
        System.out.println("$ Tipo Login > Cliente");
        System.out.println("======================================");
        System.out.println("Consulta de produtos");
        System.out.println("Corredor - " + this.corredorAtual + " | " + "Setor - " + this.setorAtual);
        System.out.println("=======================================");

        switch (this.setorAtual){
            case "alimentos":
                for(Produto produto: Estoque.setorAlimento){System.out.println(produto);}
                break;

            case "limpeza":
                for(Produto produto: Estoque.setorLimpeza){System.out.println(produto);}
                break;

            case "acougue":
                for(Produto produto: Estoque.setorAcougue){System.out.println(produto);}
                break;

            case "bebidas":
                for(Produto produto: Estoque.setorBebidas){System.out.println(produto);}
                break;

            case "hortifruti":
                for(Produto produto: Estoque.setorHortifruti){System.out.println(produto);}
                break;

            case "padaria":
                for(Produto produto: Estoque.setorPadaria){System.out.println(produto);}
                break;
        }
        int option = 0;
        try{
            System.out.println("=======================================");
            System.out.println("1 - Realizar compra de produtos");
            System.out.println();
            System.out.println("Any Number - Voltar");
            System.out.println("=======================================");
            System.out.print("Digite a escolha > ");

            option = sc.nextInt();
        }catch (InputMismatchException ex){
            Principal.clear();
            System.out.println("Erro! Opção Inválida!\nException{"+ex.toString()+'}');
            System.out.print("\nPressione qualquer tecla para continuar > ");
            sc.nextLine();
            sc.nextLine();
            Principal.clear();
            consultarProdutos();
        }


        if (option == 1){
            comprar();
        }
        else
            setores();
    }

    public void comprar(){
        try {
            Scanner sc = new Scanner(System.in);
            int continuar = 1;

            System.out.println("======================================");
            System.out.println("Compra de produtos");
            System.out.println();

            while (continuar == 1) {
                String produtoNome;
                int qntCompra;
                boolean achou = false;

                System.out.print("Digite o nome do produto > ");
                produtoNome = sc.nextLine().toLowerCase();
                System.out.print("Digite a quantidade (un) > ");
                qntCompra = sc.nextInt();

                switch (this.setorAtual) {
                    case "alimentos":
                        for (Produto produto : Estoque.setorAlimento) {
                            achou = checkProduto(produto, produtoNome, qntCompra, achou);
                        }

                    case "limpeza":
                        for (Produto produto : Estoque.setorLimpeza) {
                            achou = checkProduto(produto, produtoNome, qntCompra, achou);
                        }

                    case "acougue":
                        for (Produto produto : Estoque.setorAcougue) {
                            achou = checkProduto(produto, produtoNome, qntCompra, achou);
                        }

                    case "bebidas":
                        for (Produto produto : Estoque.setorBebidas) {
                            achou = checkProduto(produto, produtoNome, qntCompra, achou);
                        }

                    case "hortifruti":
                        for (Produto produto : Estoque.setorHortifruti) {
                            achou = checkProduto(produto, produtoNome, qntCompra, achou);
                        }

                    case "padaria":
                        for (Produto produto : Estoque.setorPadaria) {
                            achou = checkProduto(produto, produtoNome, qntCompra, achou);
                        }
                }
                System.out.println();
                if (!achou) {
                    Principal.clear();
                    System.out.println("Produto {" + produtoNome + "} não cadastrado ou sem estoque!");
                }
                else {
                    System.out.println("Produto inserido no carrinho com sucesso!");
                }
                System.out.println("======================================");
                //alterar aqui
                System.out.println("1 - Finalizar carrinho");
                System.out.println("2 - Continuar comprando nesse setor");
                System.out.println("Any Number - Continuar comprando e sair do setor");
                System.out.println("======================================");
                System.out.print("Digite a opção > ");
                int op = sc.nextInt();
                sc.nextLine();

                switch (op) {
                    case 1:
                        finalizarCarrinho(sc);
                        continuar = 0;
                        break;

                    case 2:
                        consultarProdutos();
                        break;

                    default:
                        setores();
                        break;
                }
            }
            int i = 0;
            for (Caixa caixa : Principal.caixas) {
                if (i + 1 == caixaEscolhido) {
                    caixa.finalizarCompra();
                } else
                    i++;
            }
        }catch (InputMismatchException ex){
            Scanner sc = new Scanner(System.in);
            Principal.clear();
            System.out.println("Erro! Opção Inválida!\nException{"+ex.toString()+'}');
            System.out.print("\nPressione qualquer tecla para continuar > ");
            sc.nextLine();
            Principal.clear();
            consultarProdutos();
        }
    }

    private boolean checkProduto(Produto produto, String produtoNome, int qntCompra, boolean achou){
        if (produtoNome.equals(produto.getNome().toLowerCase())) {
            if(qntCompra > produto.getQuantidadeEstoque()){
                return achou;
                //System.err.println("Produto {" + produtoNome + "} sem estoque suficiente!");
            }
            else {
                carrinho.add(produto);
                produto.setQuantidadeCompra(qntCompra);
                achou = true;
            }
        }
        return achou;
    }

    private void finalizarCarrinho(Scanner sc){
        try{
            Collections.shuffle(Principal.funcionarios);

            int i = 0;
            for (Caixa caixa : Principal.caixas) {
                caixa.setFuncionario(Principal.funcionarios.get(i));
                i++;
            }

            System.out.println("Escolha o caixa para finalizar a venda:");
            System.out.println("1 - Funcionario: "+Principal.caixas.get(0).getFuncionario().getNome());
            System.out.println("2 - Funcionario: "+Principal.caixas.get(0).getFuncionario().getNome());
            System.out.println("3 - Funcionario: "+Principal.caixas.get(0).getFuncionario().getNome());
            System.out.println();
            System.out.print("> ");
            caixaEscolhido = sc.nextInt();
            sc.nextLine();

            if(caixaEscolhido < 1 || caixaEscolhido > 3)
                throw new InputMismatchException();

        }catch (InputMismatchException ex){
            Principal.clear();
            System.out.println("Erro! Opção Inválida!\nException{"+ex.toString()+'}');
            System.out.print("\nPressione qualquer tecla para continuar > ");
            sc.nextLine();
            Principal.clear();
            finalizarCarrinho(sc);
        }

    }

}