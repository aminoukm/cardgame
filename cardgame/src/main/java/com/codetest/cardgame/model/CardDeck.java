package com.codetest.cardgame.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**Representation d'une carte
 *
 * @author aminou
 *
 */

@Getter
@Setter
@EqualsAndHashCode
public class CardDeck {
    private final CardValue cardValue;
    private final CardColor cardColor;
    private  int orderColor;
    private int orderValue;


    public CardDeck(CardValue cardValue, CardColor cardColor) {
        this.cardValue = cardValue;
        this.cardColor = cardColor;
    }
}
