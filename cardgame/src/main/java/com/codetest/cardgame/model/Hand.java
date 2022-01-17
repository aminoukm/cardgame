package com.codetest.cardgame.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**Representation de la main de jeux
 *
 * @author aminou
 *
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hand {
    List<CardDeck> cardsPicked;
    List<CardDeck> cardsSorted;
}
