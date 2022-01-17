package com.codetest.cardgame;
import static org.junit.jupiter.api.Assertions.*;

import com.codetest.cardgame.model.CardColor;
import com.codetest.cardgame.model.CardDeck;
import com.codetest.cardgame.model.CardValue;
import com.codetest.cardgame.service.CardHandler;
import com.codetest.cardgame.service.CardsSorted;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CardHandlerTest {
   @Test
    public void testIfReturnedValuesBetweenBorder(){
       int min = 1;
       int max = 4;
       Integer[] values = CardHandler.getRandom(min,max);
       boolean resultat = Arrays.stream(values).allMatch(n->(n>=min && n<=max));
       assertEquals(true,resultat);
   }
   @Test
   public void testIfValuesAreDistinct(){
      int min = 1;
      int max = 4;
      Integer[] values = CardHandler.getRandom(min,max);
      boolean resultat = Arrays.stream(values).distinct().count()==CardHandler.NBR_MAX_COLOR;
      System.out.println("ddd "+values);
      assertEquals(true,resultat);
   }
   @Test
   public void testColorValueGeneretor(){

      Integer [] cardColorOrder = CardHandler.generateHandCard(CardColor.CARREAUX.getColorValue(),CardColor.TREFLE.getColorValue());
      Integer [] cardValueOrder = CardHandler.generateHandCard(CardValue.As.getCardValue(),CardValue.ROI.getCardValue());
     CardDeck[] cardDesks= CardHandler.cardColorGenertor(cardColorOrder,cardValueOrder);
      System.out.println("test");
   }

   /**
    * test du jeux de cartes de 10 a trier
    */
   @Test
   public void play(){
      Integer[] ordreImposeDesCouleurs = CardHandler.getRandom(CardHandler.NBR_MIN, CardHandler.NBR_MAX_COLOR);
      String ordImpColor = "";
      for (int i = 0; i < ordreImposeDesCouleurs.length; i++) {
         ordImpColor+=" "+ordreImposeDesCouleurs[i];
      }
      System.out.println("ordre impose des couleurs "+ordImpColor);

      Integer[] ordreImposeDesValeurs = CardHandler.getRandom(CardHandler.NBR_MIN, CardHandler.NBR_MAX_VALUE);
      String ordImpValue = "";
      for (int i = 0; i < ordreImposeDesValeurs.length; i++) {
         ordImpValue+=" "+ordreImposeDesValeurs[i];
      }
      System.out.println("ordre impose des valeurs "+ordImpValue);
      Integer [] cardColorOrder = CardHandler.generateHandCard(CardColor.CARREAUX.getColorValue(),CardColor.TREFLE.getColorValue());
      String  cardColorOrd ="";
      for (int i = 0; i < cardColorOrder.length; i++) {
         cardColorOrd+=" "+cardColorOrder[i];
      }
      System.out.println("les couleurs des cartes tirees sont  "+cardColorOrd);
      Integer [] cardValueOrder = CardHandler.generateHandCard(CardValue.As.getCardValue(),CardValue.ROI.getCardValue());
      String  cardValueOrd ="";
      for (int i = 0; i < cardValueOrder.length; i++) {
         cardValueOrd+=" "+cardValueOrder[i];
      }
      System.out.println("les valeurs des cartes tirees sont  "+cardValueOrd);
      CardDeck[] cardDesks= CardHandler.cardColorGenertor(cardColorOrder,cardValueOrder);
      String  cardMixedHand ="";
      for (int i = 0; i < cardDesks.length; i++) {
         cardMixedHand+=" "+cardDesks[i].getCardColor().value()+"/"+cardDesks[i].getCardValue().value();
      }
      System.out.println("les cartes tirees non ordonne sont  "+cardMixedHand);
      CardDeck[] cardsSorted = CardsSorted.sortCard(cardDesks,ordreImposeDesCouleurs,ordreImposeDesValeurs);
      String cardSortedHand ="";

      for (int i = 0; i < cardsSorted.length; i++) {
         cardSortedHand+=" "+cardsSorted[i].getCardColor().value()+"/"+cardsSorted[i].getCardValue().value();
      }

      System.out.println("les cartes triees ordonne sont "+cardSortedHand);
   }
}
