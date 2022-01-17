package com.codetest.cardgame.model;

import lombok.Getter;

/**
 *Enum representant les valeurs des cartes
 *
 */

@Getter
public enum CardValue {
    As (1),
    DEUX (2),
    TROIS (3),
    QUATRE (4),
    CINQ (5),
    SIX (6),
    SETP (7),
    HUIT (8),
    NEUF (9),
    DIX(10),
    VALET (11),
    DAME(12),
    ROI (13),
    ;
    int cardValue;
    private CardValue(int value) {
        cardValue = value;
    }

    public int value(){
        return cardValue;
    }
}
