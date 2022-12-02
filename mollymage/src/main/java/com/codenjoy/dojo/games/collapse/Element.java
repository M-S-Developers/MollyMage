package com.codenjoy.dojo.games.collapse;

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

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public enum Element implements CharElement {

    NONE(' ',    "Пустое место – место которое заполнится фишкой в следующий тик."),

    BORDER('☼',  "Граница поля, в игре не участвует (не перемещается)."),

    ONE('1',     "Перемещаемая фишка 1."),

    TWO('2',     "Перемещаемая фишка 2."),

    THREE('3',   "Перемещаемая фишка 3."),

    FOUR('4',    "Перемещаемая фишка 4."),

    FIVE('5',    "Перемещаемая фишка 5."),

    SIX('6',     "Перемещаемая фишка 6."),

    SEVEN('7',   "Перемещаемая фишка 7."),

    EIGHT('8',   "Перемещаемая фишка 8."),

    NINE('9',    "Перемещаемая фишка 9.");

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

    public static Element[] valuesExcept(Element... excluded) {
        List<Element> list = Arrays.asList(excluded);
        return Arrays.stream(values())
                .filter(el -> !list.contains(el))
                .collect(toList())
                .toArray(new Element[0]);
    }

    public static Element valueOf(char ch) {
        for (Element el : Element.values()) {
            if (el.ch == ch) {
                return el;
            }
        }
        throw new IllegalArgumentException("No such element for " + ch);
    }

    public int number() {
        if (this == NONE || this == BORDER) {
            return -1;
        }
        return Integer.parseInt("" + ch);
    }
}
