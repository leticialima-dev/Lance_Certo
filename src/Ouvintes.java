import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ouvintes {


    private String nome;

    private String localidade;

    private double lance;

    private int numeroJogadas;

    private int numeroAcertos;


    // para criar um OUVINTE com nome e localidade
    public Ouvintes(String nome, String localidade) {
        this.nome = nome;
        this.localidade = localidade;
    }

    // para criar um objeto do tipo OUVINTE
    public Ouvintes(String nome) {
        this.nome = nome;
    }


    // posso criar um ouvinte vazio (null)
    public Ouvintes() {

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public double getLance() {
        return lance;
    }

    public void setLance(int lance) {
        this.lance = lance;
    }

    public int getNumeroJogadas() {
        return numeroJogadas;
    }

    public void setNumeroJogadas(int numeroJogadas) {
        this.numeroJogadas = numeroJogadas;
    }

    public int getNumeroAcertos() {
        return numeroAcertos;
    }

    public void setNumeroAcertos(int numeroAcertos) {
        this.numeroAcertos = numeroAcertos;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean criarOuvinte(Ouvintes ouvintes, ArrayList<Ouvintes> ouvintesArrayList) {
        //ouvintes.setLocalidade("Braga"); // todos ouvintes ficam setados com a mesma localidade
        boolean add = ouvintesArrayList.add(ouvintes);

        return add;
    }


    public void listarTodos(ArrayList<Ouvintes> ouvintesArrayList) {

        if (ouvintesArrayList.isEmpty()) {
            System.out.println("Lista vazia");

        } else {

            for (Ouvintes ouvinte : ouvintesArrayList) {

                System.out.println(ouvinte.toString());
            }
        }
    }


    public void listarPorIndex(ArrayList<Ouvintes> ouvintesArrayList, int index) {

        System.out.println(ouvintesArrayList.get(index));
    }

    public void apagarPorIndex(ArrayList<Ouvintes> ouvintesArrayList, int index) {



        try {
            String nomeExcluido = ouvintesArrayList.get(index).getNome();
            ouvintesArrayList.remove(index ) ;
            System.out.println("O ouvinte " + nomeExcluido +" foi  excluído");

        } catch (Exception e) {
            System.out.println("Posição inválida, verifique sua lista e tente novamente");
        }
    }


    public void editarPorIndex(ArrayList<Ouvintes> ouvintesArrayList, int index, String novoNome) {


        try {
            ouvintesArrayList.get(index).setNome(novoNome);
            System.out.println("Nome alterado com sucesso");


        } catch (Exception e) {
            System.out.println("Posição inválida, verifique sua lista e tente novamente");
        }
    }


    public void jogadaUsuario(ArrayList<Ouvintes> ouvintesArrayList, int index, double pesoDoSaco, double lance) {
        try {


            ouvintesArrayList.get(index).setNumeroJogadas(
                    ouvintesArrayList.get(index).getNumeroJogadas() + 1
            );

            this.numeroJogadas++;

            if (
                    lance >= pesoDoSaco - 150 &&
                            lance <= pesoDoSaco + 150

            ) {
                ouvintesArrayList.get(index).setNumeroAcertos(
                        ouvintesArrayList.get(index).getNumeroAcertos() + 1
                );

                System.out.println("Ouvinte acertou o lance!!");
                System.out.println(ouvintesArrayList.get(index).mostrarDadosUltimoLance(lance));
            } else {
                System.out.println("Infelizmente o ouvinte não acertou o lance");
            }


        } catch (Exception e) {
            System.out.println("Posição inválida, verifique sua lista e tente novamente");
        }
    }

    public void verRanking(ArrayList<Ouvintes> ouvintesArrayList) {
        ArrayList<Ouvintes> ouvintesArrayList1 = ouvintesArrayList;

        Collections.sort(ouvintesArrayList1, new Ranking());
        listarTodos(ouvintesArrayList);
    }


    @Override
    public String toString() {
        return "Nome: " + getNome() + " - Localidade:  " + getLocalidade() + " -  | Número de de lances: " + numeroJogadas + " | Número de acertos " + numeroAcertos;
    }


    public String mostrarDadosUltimoLance(double valorLance) {
        return "Nome: " + getNome() + " - Localidade:  " + getLocalidade() + " - Lance: " + valorLance + " | Número de de lances: " + numeroJogadas + " | Número de acertos " + numeroAcertos;
    }

}