package com.codenjoy.dojo.games.mollymage;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2012 - 2022 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.services.printer.CharElement;
import com.codenjoy.dojo.services.printer.TeamElement;

import static java.util.Arrays.asList;

public enum Element implements CharElement, TeamElement {

/// the potions

    POTION_TIMER_5('5',        "After Molly set the potion, the timer starts (5 ticks)."),

    POTION_TIMER_4('4',        "This potion will blow up after 4 ticks."),

    POTION_TIMER_3('3',        "This after 3..."),

    POTION_TIMER_2('2',        "Two.."),

    POTION_TIMER_1('1',        "One."),

    BLAST('҉',                  "Boom! this is what is potion does, everything that is " +
                               "destroyable got destroyed."),

/// walls

    WALL('☼',                  "Indestructible wall - it will not fall from potion."),

    TREASURE_BOX('#',          "This is a treasure box, it opens with an explosion."),

    TREASURE_BOX_OPENING('H',  "This is like a treasure box opens looks like, it will " +
                               "disappear on next move. If it's you did it - you'll " +
                               "get score points. Perhaps a prize will appear."),

/// soulless creatures

    GHOST('&',                 "This guys runs over the board randomly and gets in the way " +
                               "all the time. If it will touch Molly - she will die. " +
                               "You'd better kill this piece of ... soul, you'll get score " +
                               "points for it."),

    GHOST_DEAD('x',            "This is ghost corpse."),

/// perks

    POTION_BLAST_RADIUS_INCREASE('+', "Temporarily increase potion radius blast. " +
                                      "Applicable only to new potions."),

    POTION_COUNT_INCREASE('c', "Temporarily increase available potions count. " +
                               "Number of extra potions can be set in settings*."),

    POTION_REMOTE_CONTROL('r', "Next several potions would be with remote control. " +
                               "Activating by command ACT. Number of RC triggers " +
                               "is limited and can be set in settings*."),

    POTION_IMMUNE('i',         "Temporarily gives you immunity from potion blasts " +
                               "(own potion and others as well)."),

    POISON_THROWER('T',        "Hero can shoot by poison cloud. Using: ACT(1)+Direction. " +
                               "Temporary."),

    POTION_EXPLODER('A',       "Hero can explode all potions on the field. " +
                               "Using: ACT(2). Temporary."),

/// a void

    NONE(' ',                  "A void. This is the only place where you can move your Molly."),

/// your Molly

    HERO('☺',                  "This is what your Molly usually looks like."),

    HERO_POTION('☻',           "This is if your Molly is sitting on own potion."),

    HERO_DEAD('Ѡ',             "Oops, your Molly is dead (don't worry, she will appear " +
                               "somewhere in next move). You're getting penalty points " +
                               "for each death."),

/// other players heroes

    OTHER_HERO('♥',            "This is what other heroes looks like."),

    OTHER_HERO_POTION('♠',     "This is if other hero is sitting on own potion."),

    OTHER_HERO_DEAD('♣',       "Other hero corpse (it will disappear shortly, right " +
                               "on the next move). If you've done it you'll get " +
                               "score points."),

/// enemy players heroes

    ENEMY_HERO('ö',            "This is what enemy heroes looks like."),

    ENEMY_HERO_POTION('Ö',     "This is if enemy hero is sitting on own potion."),

    ENEMY_HERO_DEAD('ø',       "Enemy hero corpse (it will disappear shortly, right " +
                               "on the next move). If you've done it you'll get " +
                               "score points.");

    private final char ch;
    private final String info;

    Element(char ch, String info) {
        this.ch = ch;
        this.info = info;
    }

    @Override
    public char ch() {
        return ch;
    }

    @Override
    public String info() {
        return info;
    }

    @Override
    public String toString() {
        return String.valueOf(ch);
    }

    public static Element valueOf(char ch) {
        for (Element element : Element.values()) {
            if (element.ch == ch) {
                return element;
            }
        }
        throw new IllegalArgumentException("No such element for " + ch);
    }

    public boolean isPotion() {
        return asList(potions()).contains(this);
    }

    public boolean isHero() {
        return asList(heroes()).contains(this);
    }

    public boolean isEnemyHero() {
        return asList(enemyHeroes()).contains(this);
    }

    public boolean isOtherHero() {
        return asList(otherHeroes()).contains(this);
    }

    public boolean isPerk() {
        return asList(perks()).contains(this);
    }

    public boolean isGhost() {
        return asList(ghosts()).contains(this);
    }

    public boolean isWall() {
        return asList(walls()).contains(this);
    }

    public boolean isTreasureBox() {
        return asList(treasureBoxes()).contains(this);
    }

    public boolean isBlast() {
        return asList(blasts()).contains(this);
    }

    public static Element[] heroes() {
        return new Element[]{
                HERO,
                HERO_POTION,
                HERO_DEAD,
        };
    }

    public static Element[] enemyHeroes() {
        return new Element[]{
                ENEMY_HERO,
                ENEMY_HERO_POTION,
                ENEMY_HERO_DEAD,
        };
    }

    public static Element[] otherHeroes() {
        return new Element[]{
                OTHER_HERO,
                OTHER_HERO_POTION,
                OTHER_HERO_DEAD,
        };
    }

    public static Element[] potions() {
        return new Element[]{
                POTION_TIMER_1,
                POTION_TIMER_2,
                POTION_TIMER_3,
                POTION_TIMER_4,
                POTION_TIMER_5,
                HERO_POTION,
                OTHER_HERO_POTION,
                ENEMY_HERO_POTION,
        };
    }

    public static Element[] perks() {
        return new Element[]{
                POTION_BLAST_RADIUS_INCREASE,
                POTION_COUNT_INCREASE,
                POTION_IMMUNE,
                POTION_REMOTE_CONTROL,
                POISON_THROWER,
                POTION_EXPLODER,
        };
    }

    public static Element[] ghosts() {
        return new Element[]{
                GHOST,
                GHOST_DEAD,
        };
    }

    public static Element[] walls() {
        return new Element[]{
                WALL,
        };
    }

    public static Element[] treasureBoxes() {
        return new Element[]{
                TREASURE_BOX,
                TREASURE_BOX_OPENING,
        };
    }

    public static Element[] blasts() {
        return new Element[]{
                BLAST,
        };
    }

    public static Element[] barriers() {
        return new Element[]{
                GHOST,
                //GHOST_DEAD,
                WALL,
                POTION_TIMER_1,
                POTION_TIMER_2,
                POTION_TIMER_3,
                POTION_TIMER_4,
                POTION_TIMER_5,
                HERO_POTION,
                OTHER_HERO_POTION,
                ENEMY_HERO_POTION,
                TREASURE_BOX,
                //TREASURE_BOX_OPENING,
                OTHER_HERO,
                OTHER_HERO_POTION,
                OTHER_HERO_DEAD,
                ENEMY_HERO,
                ENEMY_HERO_POTION,
                ENEMY_HERO_DEAD,
        };
    }

    @Override
    public Element otherHero() {
        switch (this) {
            case HERO: return OTHER_HERO;
            case HERO_DEAD: return OTHER_HERO_DEAD;
            case HERO_POTION: return OTHER_HERO_POTION;
        }
        throw new IllegalArgumentException("Bad hero state: " + this);
    }

    @Override
    public Element enemyHero() {
        switch (this) {
            case HERO: return ENEMY_HERO;
            case HERO_DEAD: return ENEMY_HERO_DEAD;
            case HERO_POTION: return ENEMY_HERO_POTION;
        }
        throw new IllegalArgumentException("Bad hero state: " + this);
    }
}
