package uk.ac.liv.comp201;

public class Main {

    public static void main(String[] args) {
        String cardName = "coopesabc";
        // TODO Auto-generated method stub
        //try {
        //Card.createNewCard(cardName);
        //} catch (CardException e) {
        // TODO Auto-generated catch block
        //	e.printStackTrace();
        //}

        Card card;
        try {
            card = Card.loadCard(cardName);
            System.out.println("fire code is " + card.getCardFireCode());
            System.out.println("status " + card.getCardStatus());

        } catch (CardException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
