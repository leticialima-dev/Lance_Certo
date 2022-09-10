import java.util.Comparator;

public class Ranking implements Comparator<Ouvintes> {


    @Override
    public int compare(Ouvintes ouvinte1, Ouvintes ouvinte2) {

        if(ouvinte1.getNumeroAcertos() < ouvinte2.getNumeroAcertos()){
            return 1;
        }else  if(ouvinte1.getNumeroAcertos() < ouvinte2.getNumeroAcertos()){
            return 0;
        }


        return -1;
    }
}
