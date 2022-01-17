package com.codetest.cardgame.service;

import com.codetest.cardgame.model.CardColor;
import com.codetest.cardgame.model.CardDeck;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/** Service pour le trie des cartes
 *
 * @author aminou
 *
 */

public class CardsSorted {

    /**
     *
     * @param cardTab
     * @param orderColor
     * @param orderValue
     * @return 10 Cartes trieee par couleurs et valeurs
     */
    public static CardDeck[] sortCard(CardDeck[] cardTab, Integer[] orderColor, Integer[] orderValue){
        return Stream.of(cardTab).sorted((c1,c2)->
                            {
                                int indexOrdreValue1 = Arrays.asList(orderValue).indexOf(c1.getCardValue().getCardValue());
                                int indexOrdreValue2 = Arrays.asList(orderValue).indexOf(c2.getCardValue().getCardValue());
                                int indexOrdreColor1 = Arrays.asList(orderColor).indexOf(c1.getCardColor().getColorValue());
                                int indexOrdreColor2 =Arrays.asList(orderColor).indexOf(c2.getCardColor().getColorValue());
                                c1.setOrderColor(indexOrdreColor1);
                                c1.setOrderValue(indexOrdreValue1);
                                c2.setOrderColor(indexOrdreColor2);
                                c2.setOrderValue(indexOrdreValue2);
                                Comparator<CardDeck> colorCompator = (p1,p2)->p1.getOrderColor()- p2.getOrderColor();
                                Comparator<CardDeck> valueCompator = (p1,p2)->p1.getOrderValue()- p2.getOrderValue();
                                int resultatCompColor = colorCompator.compare(c1,c2);

                                if(resultatCompColor!=0){
                                    return resultatCompColor;
                                }
                                return valueCompator.compare(c1,c2);

                            }).toArray(CardDeck[]::new);
    }


}
