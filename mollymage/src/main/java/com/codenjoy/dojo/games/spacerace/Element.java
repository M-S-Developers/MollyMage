package com.codenjoy.dojo.games.spacerace;

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

public enum Element implements CharElement {

    NONE(' ',        "Пустое место, куда можно перейти герою."),

    EXPLOSION('x',   "Взрыв героя, астероида или мины (мина взрывается сильнее)."),

    WALL('☼',        "Стенка, через которую нельзя пройти."),

    HERO('☺',        "Твой герой."),

    OTHER_HERO('☻',  "Герои других игроков."),

    DEAD_HERO('+',   "Твой герой погиб. Пропадет в следующем тике."),

    GOLD('$',        "Золото - за ним стоит поохотиться."),

    BOMB('♣',        "Мины - их надо избегать, а лучше уничтожать. " +
                     "Взрывная волна от мины размером +1 клеточка с каждой стороны."),

    STONE('0',       "Астероиды - их надо избегать, а лучше уничтожать."),

    BULLET_PACK('7', "Магазин патронов."),

    BULLET('*',      "Пуля.");

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
        for (Element el : Element.values()) {
            if (el.ch == ch) {
                return el;
            }
        }
        throw new IllegalArgumentException("No such element for " + ch);
    }

}
