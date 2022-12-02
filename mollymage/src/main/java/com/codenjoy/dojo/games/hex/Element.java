package com.codenjoy.dojo.games.hex;

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

import java.util.*;

public enum Element implements CharElement {

/// Разное на поле

    NONE(' ',    "Пустое поле на карте. Сюда можно перемещать " +
                 "свои войска."),

    WALL('☼',    "Непроходимое препятствие. Обычно граница поля, " +
                 "но может появиться в месте, куда два героя " +
                 "одновременно отправят вои войска."),

/// Войска игроков

    MY_HERO('☺', "Твои войска."),

    HERO1('☻',   "Войска противника 1."),

    HERO2('♥',   "Войска противника 2."),

    HERO3('♦',   "Войска противника 3."),

    HERO4('♣',   "Войска противника 4."),

    HERO5('♠',   "Войска противника 5."),

    HERO6('•',   "Войска противника 6."),

    HERO7('◘',   "Войска противника 7."),

    HERO8('○',   "Войска противника 8."),

    HERO9('◙',   "Войска противника 9."),

    HERO10('♂',  "Войска противника 10."),

    HERO11('♀',  "Войска противника 11.");

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

    public static List<Element> heroes() {
        return new LinkedList<>(Arrays.asList(Element.values())) {{
            remove(Element.NONE);
            remove(Element.WALL);
            remove(Element.MY_HERO);
        }};
    }

    private static Map<Character, Element> elements = new HashMap<>(){{
        Arrays.stream(Element.values())
                .forEach(el -> put(el.ch, el));
    }};

    // optimized for performance
    public static Element valueOf(char ch) {
        Element elements = Element.elements.get(ch);
        if (elements == null) {
            throw new IllegalArgumentException("No such element for " + ch);
        }
        return elements;
    }

}
