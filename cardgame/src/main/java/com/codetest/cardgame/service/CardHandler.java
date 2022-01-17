package com.codetest.cardgame.service;
import com.codetest.cardgame.model.CardColor;
import com.codetest.cardgame.model.CardDeck;
import com.codetest.cardgame.model.CardValue;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**Service pour la gestion du jeux de carte
 *
 * @author aminou
 *
 */
@Service
public class CardHandler {

    public static final int NBR_MAX_COLOR = 4;
    public static final int NBR_MAX_CARDS = 10;
    public static final int NBR_MAX_VALUE = 13;
    public static final int NBR_MIN = 1;

    /**
     *
     * @param min
     * @param max
     * @return nombre aleatoire pour ordonne les cartes
     */
    public static Integer[] getRandom(int min, int max){
      List<Integer> nums = IntStream.rangeClosed(min,max).boxed()
              .distinct().collect(Collectors.toList());
       Collections.shuffle(nums);
      return nums.toArray(new Integer[nums.size()]);
  }

    /**
     *
     * @param colorTab
     * @param valueTab
     * @return une main de jeux de 10 couleurs de cartes tirees au hazard
     */
  public static CardDeck[] cardColorGenertor(Integer[] colorTab, Integer[] valueTab){
        CardDeck[] cardDeckstab = new CardDeck[10];
        if(colorTab!=null && valueTab!=null){

            for (int i = 0; i < NBR_MAX_CARDS  ; i++) {
                CardColor cardColor = getMatchingColor(colorTab[i]);
                CardValue cardValue = getMatchingValue(valueTab[i]);
                CardDeck cardDeck = new CardDeck(cardValue,cardColor);
                cardDeckstab[i] = cardDeck;
            }
            return cardDeckstab;
        }
        return null;
  }

    /**
     *
     * @param min
     * @param max
     * @return une main de jeux de 10 valeurs de cartes tirees au hazard
     */
    public static Integer[] generateHandCard(int min, int max){
      Random randNum = new Random();

      List<Integer> nums = randNum.ints(NBR_MAX_CARDS,min,max).boxed()
              .collect(Collectors.toList());
      return nums.toArray(new Integer[nums.size()]);
  }
    public static CardColor getMatchingColor(int i) {
        switch (i){
            case 1:
                return CardColor.CARREAUX;
            case 2:
                return CardColor.COUEUR;
            case 3:
                return CardColor.PIQUE;
            case 4:
                return CardColor.TREFLE;
        }
        return null;
    }

    /**
     *
     * @param i
     * @return la correspondance entre une carte et sa valeur
     */

    public static CardValue getMatchingValue(int i) {
        switch (i){
            case 1:
                return CardValue.As;
            case 2:
                return CardValue.DEUX;
            case 3:
                return CardValue.TROIS;
            case 4:
                return CardValue.QUATRE;
            case 5:
                return CardValue.CINQ;
            case 6:
                return CardValue.SIX;
            case 7:
                return CardValue.SETP;
            case 8:
                return CardValue.HUIT;
            case 9:
                return CardValue.NEUF;
            case 10:
                return CardValue.DIX;
            case 11:
                return CardValue.VALET;
            case 12:
                return CardValue.DAME;
            case 13:
                return CardValue.ROI;
        }
        return null;
    }
}
