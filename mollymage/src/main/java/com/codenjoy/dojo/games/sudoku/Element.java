package com.codenjoy.dojo.games.sudoku;

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

    NONE(' ',   "Пустое место – циферку в котором предстоит отгадать."),

    BORDER('☼', "Граница, проигнорируй ее - она не учитывается в координатах."),

    HIDDEN('*', "Если число не отображается на поле."),

    ONE('1',    "Цифра 1."),

    TWO('2',    "Цифра 2."),

    THREE('3',  "Цифра 3."),

    FOUR('4',   "Цифра 4."),

    FIVE('5',   "Цифра 5."),

    SIX('6',    "Цифра 6."),

    SEVEN('7',  "Цифра 7."),

    EIGHT('8',  "Цифра 8."),

    NINE('9',   "Цифра 9.");

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

    public static Element valueOf(int n) {
        for (Element el : Element.values()) {
            if (String.valueOf(n).equals("" + el.ch)) {
                return el;
            }
        }
        throw new IllegalArgumentException("Нет такого елемента: " + n);
    }

    public static Element valueOf(char ch) {
        for (Element el : Element.values()) {
            if (el.ch == ch) {
                return el;
            }
        }
        throw new IllegalArgumentException("No such element for " + ch);
    }

    public static Element[] valuesExcept(Element... excluded) {
        List<Element> list = Arrays.asList(excluded);
        return Arrays.stream(values())
                .filter(el -> !list.contains(el))
                .collect(toList())
                .toArray(new Element[0]);
    }

    public Integer value() {
        if (this == NONE) {
            return 0;
        }
        if (this == BORDER || this == HIDDEN) {
            return -1;
        }
        return Integer.valueOf("" + ch);
    }
}
