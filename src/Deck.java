import java.util.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;

public class Deck {

    public static void main(String[] args) throws IOException, InputMismatchException {
        Card card = new Card();
        int Palos = card.Palo.length;
        int Valores = card.Valor.length;
        int Colores = card.Color.length;

        ArrayList<String> deck = new ArrayList();
        for (int i = 0; i < Valores; i++) {
            for (int j = 0; j < Palos; j++) {
                if (Colores == 1) {
                    deck.add(card.Palo[j] + " Rojo " + card.Valor[i]);
                } else {
                    deck.add(card.Palo[j] + " Negro " + card.Valor[i]);
                }
            }
        }
        showMenu(deck);

    }
    public static void showMenu(ArrayList deck) throws InputMismatchException, IllegalArgumentException{
        Scanner leer = new Scanner(System.in);
        int opc = 0;
        boolean check = true;
        for (int i = 0; i == opc; i++) {
            do {
                try {
                    try{
                        System.out.println("Bienvenido a Poker! \n" + "Selecciona una de las siguientes opciones:");
                        System.out.println("1. Mezclar el deck \n" + "2. Sacar una carta");
                        System.out.println("3.Carta al azar \n" + "4. Generar una mano de 5 cartas");
                        System.out.println("0. Salir del programa\n");
                        opc = leer.nextInt();
                        switch (opc) {
                            case 0: {
                                break;
                            }
                            case 1: {
                                suflle(deck);
                                break;
                            }
                            case 2: {
                                head(deck);
                                break;
                            }
                            case 3: {
                                pick(deck);
                                break;
                            }
                            case 4: {
                                hand(deck);
                                System.out.println("\n");
                                break;
                            }
                            default:
                                System.out.println("Debes elegir una opción del 0 al 4");
                                showMenu(deck);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Debes elegir una opción con número, no una letra, vuelve a intentarlo");
                        showMenu(deck);
                    }

                    } catch (IllegalArgumentException e) {
                    System.out.println("Debes elegir una opción entre el número 0 y 4");
                    showMenu(deck);
                }
            }while (check !=true);
        }
    }



    public static void suflle(ArrayList deck){

        Iterator<String> nombreIterator = deck.iterator();
        while(nombreIterator.hasNext()){
            String elemento = nombreIterator.next();
            System.out.print(elemento+" / ");
        }

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
