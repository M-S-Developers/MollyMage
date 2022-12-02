package com.codenjoy.dojo.games.fifteen;

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

/// Фишки

    A('a',    "Фишка 1. Герой ее может переместить на свое место."),

    B('b',    "Фишка 2."),

    C('c',    "Фишка 3."),

    D('d',    "Фишка 4."),

    E('e',    "Фишка 5."),

    F('f',    "Фишка 6."),

    G('g',    "Фишка 7."),

    H('h',    "Фишка 8."),

    I('i',    "Фишка 9."),

    J('j',    "Фишка 10."),

    K('k',    "Фишка 11."),

    L('l',    "Фишка 12."),

    M('m',    "Фишка 13."),

    N('n',    "Фишка 14."),

    O('o',    "Фишка 15."),

/// Разное на поле

    HERO('+', "Твой герой. Герой перемещает фишки меняясь с ними местами."),

    WALL('*', "Стена. Препятствие для перемещения фишек.");

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
