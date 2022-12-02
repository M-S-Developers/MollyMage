package com.codenjoy.dojo.games.moebius;

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
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Point;

import static com.codenjoy.dojo.services.PointImpl.pt;

public enum Element implements CharElement {

    LEFT_UP('╝', pt(-1, 0), pt(0, 1),     "Труба повернута слева вверх."),

    UP_RIGHT('╚', pt(0, 1), pt(1, 0),     "Труба повернута сверху направо."),

    RIGHT_DOWN('╔', pt(1, 0), pt(0, -1),  "Труба повернута справа вниз."),

    DOWN_LEFT('╗', pt(0, -1), pt(-1, 0),  "Труба повернута снизу влево."),

    LEFT_RIGHT('═', pt(-1, 0),  pt(1, 0), "Прямая труба слева направо."),

    UP_DOWN('║', pt(0, 1),  pt(0, -1),    "Прямая труба сверху вниз."),

    CROSS('╬', null, null,                "Две пересеченные прямые трубы, " +
                                          "одна сверху вниз, другая слева направо."),

    EMPTY(' ', null, null,                "Пустое место на поле.");

    private final char ch;
    private final String info;
    private final Point from;
    private final Point to;

    Element(char ch, Point from, Point to, String info) {
        this.ch = ch;
        this.from = from;
        this.to = to;
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

    public static Element random(Dice dice) {
        return Element.values()[dice.next(Element.values().length - 1)];
    }

    public Point from() {
        return from;
    }

    public Point to() {
        return to;
    }
}
