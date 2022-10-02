import java.util.*;

public class Deck {

    public static void main(String[] args) {
        Card card = new Card();
        int Palos = card.Palo.length; int Valores = card.Valor.length; int Colores = card.Color.length;

        ArrayList<String> deck = new ArrayList();
        for (int i = 0; i < Valores; i++) {
            for (int j = 0; j < Palos; j++) {
                if(Colores == 1){
                    deck.add(card.Palo[j] + " Rojo " + card.Valor[i]);
                }
                else{
                    deck.add(card.Palo[j] + " Negro " + card.Valor[i]);
                }
            }
        Iterator<String> nombreIterator = deck.iterator();
        while(nombreIterator.hasNext()){
            String elemento = nombreIterator.next();
            System.out.print(elemento+" / ");
            }
        }

            suflle(deck);
            head(deck);
            pick(deck);
            hand(deck);
    }
    public static void suflle(ArrayList deck){
        ArrayList<String> values = deck;
        Collections.shuffle(values);
        System.out.println("\nSe mezcló el deck.\n");
    }
    public static void head(ArrayList deck){
        System.out.println("Tu primera carta es: " +deck.get(0) + " se removerá del deck");
        deck.remove(0);
        System.out.println("Quedan " + deck.size()+ " cartas en el deck\n");
    }
    public static void pick(ArrayList  deck){
        Random aleatorio = new Random();
        System.out.println("Tu segunda carta es: "+deck.get(aleatorio.nextInt(deck.size())) + " se removerá del deck");
        deck.remove(aleatorio.nextInt(deck.size()));
        System.out.println("Quedan " + deck.size()+ " cartas en el deck\n");
    }
    public static void hand(ArrayList deck){
        System.out.println("Las 5 cartas puestas en la mesa son: ");
        for(int i=0; i<=4; i++){
            System.out.println(deck.get(i));
        }
        for(int i=0; i<=4; i++){
            deck.remove(i);
        }
        System.out.println("Quedan " + deck.size()+ " cartas en el deck");
    }
}
