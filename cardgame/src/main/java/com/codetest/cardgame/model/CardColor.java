package com.codetest.cardgame.model;

import lombok.Getter;
/**
 *Enum representant les couleurs des cartes
 *
 */

@Getter
public enum CardColor {
    CARREAUX (1),
    COUEUR (2),
    PIQUE (3),
    TREFLE (4);

    int colorValue;
    private CardColor(int value) {
        colorValue = value;
    }

    public int value(){
        return  colorValue;
    }
}
