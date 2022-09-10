import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //ArrayList<Ouvintes> ouvintes = new ArrayList<Ouvintes>();

        ArrayList<Ouvintes> ouvintesArrayList = new ArrayList<>();

        double pesoDoSaco = 4000;

        Ouvintes ouvinte = new Ouvintes();

        int index = 0;

        Scanner in = new Scanner(System.in);

        ouvintesArrayList.add(new Ouvintes("RITA", "OLIVAIS"));
        ouvintesArrayList.add(new Ouvintes("ANTÔNIO", "BRAGA"));
        ouvintesArrayList.add(new Ouvintes("MIGUEL", "PORTO"));
        ouvintesArrayList.add(new Ouvintes("FILIPE", "SETUBAL"));
        ouvintesArrayList.add(new Ouvintes("PALOMA", "VISEU"));
        ouvintesArrayList.add(new Ouvintes("MARGARIDA", "GUIMARÃES"));


        int opcao = 0;


        while (true) {


            System.out.println(
                    "1 - Criar um novo ouvinte  " +
                            "\n2 - Editar um novo ouvinte" +
                            "\n3 - Apagar um ouvinte" +
                            "\n4 - Listar todos os ouvintes" +
                            "\n5 - Ver usuario por index" +
                            "\n6 - Ver Ranking" +
                            "\n7 - jogar");


            opcao = in.nextInt();
            System.out.println("==================================================================================");


            while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5 && opcao != 6 && opcao != 7
            ) {
                System.out.println("Valor invalido, tente novamente: ");
                opcao = in.nextInt();
            }

            switch (opcao) {
                case 1:

                    System.out.println("Informe o nome do ouvinte");
                    String nome = in.next();
                    System.out.println("Informe  sua  Localidade");
                    String localidade = in.next();


                    boolean foiInserido = ouvinte.criarOuvinte(new Ouvintes(nome, localidade), ouvintesArrayList);

                    System.out.println(foiInserido ? "Novo ouvinte registado" : "Ouvinte não foi registado"); // mostrar ouvinte
                    System.out.println("==================================================================================");


                    break;


                case 2:

                    System.out.println("Informe a posição do ouvinte que deseja EDITAR");
                    index = in.nextInt();
                    System.out.println(ouvintesArrayList.get(index).getNome());

                    System.out.println("Informe o novo NOME do ouvinte");
                    String novoNome = in.next();

                    ouvinte.editarPorIndex(ouvintesArrayList, index, novoNome);

                    System.out.println("===================================================================================");

                    break;

                case 3:
                    ouvinte.listarTodos(ouvintesArrayList);
                    System.out.println("Informe a POSIÇÃO do ouvinte que deseja EXCLUIR");
                    index = in.nextInt();
                    //System.out.println(ouvintesArrayList.get(index).getNome());
                    ouvinte.apagarPorIndex(ouvintesArrayList, index);
                    System.out.println("==================================================================================");

                    break;

                case 4:
                    ouvinte.listarTodos(ouvintesArrayList);
                    System.out.println("==================================================================================");

                    break;

                case 5:
                    System.out.println("Informe a POSIÇÃO do ouvinte que deseja VERIFICAR");
                    index = in.nextInt();
                    ouvinte.listarPorIndex(ouvintesArrayList, index);
                    System.out.println("==================================================================================");


                    break;

                case 6:

                    ouvinte.verRanking(ouvintesArrayList);
                    break;


                case 7:
                    System.out.println("Informe a posição do ouvinte que deseja Jogar");
                    index = in.nextInt();
                    System.out.println("Informe o lance do ouvinte " + ouvintesArrayList.get(index).getNome());
                    double valor = in.nextDouble();
                    // buscar os valores do lance
                    ouvinte.jogadaUsuario(ouvintesArrayList, index, pesoDoSaco, valor);
                    System.out.println("==================================================================================");

                    break;

                default:
                    System.out.println("Encerrando");
                    System.out.println("==================================================================================");

                    break;

            }

        }
    }
}



