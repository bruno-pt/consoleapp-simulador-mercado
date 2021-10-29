/*
Nosso trabalho parte do contexto de um supermercado que está informatizando seus processos. Este supermercado possui
um/a gerente e cinco funcionários/as, sendo que estes/as funcionários/as se revezam em três caixas de pagamento.
Cada caixa está equipado com uma balança, o que permite vendas de produtos tanto por quilo ou por unidade.
 Este sistema possui alguns requisitos:* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void clear(){
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }

    public static void opSistema(){
        int escolha=0;
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("$ Tipo Login");
            System.out.println("======================");
            System.out.println("1 - Login como Gerente");
            System.out.println("2 - Login como Cliente");
            System.out.println();
            System.out.println("Any Number - Sair do Sistema");
            System.out.println("======================");
            System.out.print("> ");
            escolha = sc.nextInt();
        }catch (InputMismatchException ex){
            clear();
            System.out.println("Erro! Opção Inválida!\nException{"+ex.toString()+'}');
            System.out.print("\nPressione qualquer tecla para continuar > ");
            sc.nextLine();
            sc.nextLine();
            clear();
            opSistema();
        }


        clear();

        switch (escolha){
            case 1:
                System.out.println("===============");
                System.out.println("Login - Gerente");
                System.out.println("===============");
                System.out.println();
                System.out.print("Senha > ");
                sc.nextLine();
                String senha = sc.nextLine();

                clear();

                if(senha.equals("")) {
                    opGerente();
                }
                else{
                    System.err.println("Senha Inválida!");
                    opSistema();
                }
                break;

            case 2:
                opCliente();
                break;

            default:
                break;
        }
    }

    public static void opGerente(){
        Scanner sc = new Scanner(System.in);

        System.out.println("$ Tipo Login > Gerente");
        System.out.println("===========================");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Gerar Relatório de Vendas");
        System.out.println("3 - Gerar Relatório de Alteração de Estoque");
        System.out.println("4 - Gerar Relatório de Venda por Funcionario");
        System.out.println();
        System.out.println("Any - Sair do Sistema");
        System.out.println("===========================");
        System.out.print("Digite a opcao > ");

            int option = sc.nextInt();

        switch (option) {
            case 1:
                Principal.clear();

                System.out.println("$ Tipo Login > Gerente");
                System.out.println("===========================");
                System.out.println("Cadastro de Produto");
                System.out.println();

                System.out.print("Digite o nome do produto > ");
                sc.nextLine();
                String nome = sc.nextLine();

                System.out.print("Digite a quantidade de Estoque > ");
                int qntEstoque = sc.nextInt();

                System.out.print("Digite a o preco(un) > ");
                float precoUni = sc.nextFloat();

                System.out.println("Setores disponíveis = {Alimento, Limpeza, Acougue, Bebidas, Hortifruti, Padaria}");
                System.out.print("Digite o setor > ");
                sc.nextLine();
                String setor = sc.nextLine();

                Gerente.cadastrarProduto(new Produto(nome, qntEstoque, precoUni), setor);
                System.out.println("===========================");
                System.out.println("Produto cadastrado com sucesso!");
                System.out.println();
                System.out.print("Any - Para continuar > ");
                sc.nextLine();

                Principal.clear();
                break;

            case 2: Gerente.relatorioVendas();
                break;

            case 3: Gerente.relatorioEstoque();
                break;

            case 4: Gerente.relatorioVendasFuncionario();
                break;

            default: opSistema();
        }
        opGerente();
    }

    public static void opCliente(){
        Cliente cliente = new Cliente();
        cliente.corredores();
    }

    static ArrayList<Caixa> caixas = new ArrayList<Caixa>();
    static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    public ArrayList<Caixa> getCaixas() {
        return caixas;
    }
    private static boolean firstRun = true;

    public static void main(String[] args) {
        funcionarios.add(new Funcionario("Gabriel", 20));
        funcionarios.add(new Funcionario("Maria", 21));
        funcionarios.add(new Funcionario("Romualdo", 43));
        funcionarios.add(new Funcionario("Leandro", 54));
        funcionarios.add(new Funcionario("Josimara", 34));

        Collections.shuffle(funcionarios);

        for(int i = 0; i < 3; i++){
            caixas.add(new Caixa(funcionarios.get(i)));
        }
        instanceProducts();
        opSistema();
    }

    private static void instanceProducts(){
        Gerente.cadastrarProduto(new Produto("Arroz",5, 7.5f), "alimento");
        Gerente.cadastrarProduto(new Produto("Feijao",29, 6), "alimento");
        Gerente.cadastrarProduto(new Produto("Miojo",999, 0.50f), "alimento");
        Gerente.cadastrarProduto(new Produto("Omo",7, 7), "limpeza");
        Gerente.cadastrarProduto(new Produto("Detergente",8, 15), "limpeza");
        Gerente.cadastrarProduto(new Produto("Veja",7, 15), "limpeza");
        Gerente.cadastrarProduto(new Produto("Hortela",30, 15), "hortifruti");
        Gerente.cadastrarProduto(new Produto("Couve",12, 15), "hortifruti");
        Gerente.cadastrarProduto(new Produto("Alface",11, 15), "hortifruti");
        Gerente.cadastrarProduto(new Produto("Skol",15, 2), "bebidas");
        Gerente.cadastrarProduto(new Produto("Glacial",2350, 0.1f), "bebidas");
        Gerente.cadastrarProduto(new Produto("Velho barreiro",20, 9.90f), "bebidas");
        Gerente.cadastrarProduto(new Produto("Pao",60, 4.99f), "padaria");
        Gerente.cadastrarProduto(new Produto("Pao de queijo",30, 2.50f), "padaria");
        Gerente.cadastrarProduto(new Produto("Rosquinha",55,5.50f ), "padaria");
        Gerente.cadastrarProduto(new Produto("Lula",20, 30.50f), "acougue");
        Gerente.cadastrarProduto(new Produto("Linguiça",36,10.50f), "acougue");
        Gerente.cadastrarProduto(new Produto("Picanha",2, 1500), "acougue");
    }
}
