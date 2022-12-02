package com.codenjoy.dojo.games.japanese;

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

    WHITE('-', 1,  "Игрок утверждает, что пиксель белый."),

    BLACK('*', 0,  "Игрок утверждает, что пиксель черный."),

    UNSET(' ', -1, "Игрок пока не определился, какого цвета этот пиксель."),

    NAN('.', -1,   "Пустое место в полое для цифр."),

    _0('0', 0,     "Блок отсутствует."),

    _1('1', 1,     "Блок длинной в 1 пиксель."),

    _2('2', 2,     "Блок длинной в 2 пикселя."),

    _3('3', 3,     "Блок длинной в 3 пикселя."),

    _4('4', 4,     "Блок длинной в 4 пикселя."),

    _5('5', 5,     "Блок длинной в 5 пикселей."),

    _6('6', 6,     "Блок длинной в 6 пикселей."),

    _7('7', 7,     "Блок длинной в 7 пикселей."),

    _8('8', 8,     "Блок длинной в 8 пикселей."),

    _9('9', 9,     "Блок длинной в 9 пикселей."),

    _10('a', 10,   "Блок длинной в 10 пикселей."),

    _11('b', 11,   "Блок длинной в 11 пикселей."),

    _12('c', 12,   "Блок длинной в 12 пикселей."),

    _13('d', 13,   "Блок длинной в 13 пикселей."),

    _14('e', 14,   "Блок длинной в 14 пикселей."),

    _15('f', 15,   "Блок длинной в 15 пикселей."),

    _16('g', 16,   "Блок длинной в 16 пикселей."),

    _17('h', 17,   "Блок длинной в 17 пикселей."),

    _18('i', 18,   "Блок длинной в 18 пикселей."),

    _19('j', 19,   "Блок длинной в 19 пикселей."),

    _20('k', 20,   "Блок длинной в 20 пикселей."),

    _21('l', 21,   "Блок длинной в 21 пиксель."),

    _22('m', 22,   "Блок длинной в 22 пикселя."),

    _23('n', 23,   "Блок длинной в 23 пикселя."),

    _24('o', 24,   "Блок длинной в 24 пикселя."),

    _25('p', 25,   "Блок длинной в 25 пикселей."),

    _26('q', 26,   "Блок длинной в 26 пикселей."),

    _27('r', 27,   "Блок длинной в 27 пикселей."),

    _28('s', 28,   "Блок длинной в 28 пикселей."),

    _29('t', 29,   "Блок длинной в 29 пикселей."),

    _30('u', 30,   "Блок длинной в 30 пикселей."),

    _31('v', 31,   "Блок длинной в 31 пиксель."),

    _32('w', 32,   "Блок длинной в 32 пикселя."),

    _33('x', 33,   "Блок длинной в 33 пикселя."),

    _34('y', 34,   "Блок длинной в 34 пикселя."),

    _35('z', 35,   "Блок длинной в 35 пикселей."),

    _36('A', 36,   "Блок длинной в 36 пикселей."),

    _37('B', 37,   "Блок длинной в 37 пикселей."),

    _38('C', 38,   "Блок длинной в 38 пикселей."),

    _39('D', 39,   "Блок длинной в 39 пикселей."),

    _40('E', 40,   "Блок длинной в 40 пикселей."),

    _41('F', 41,   "Блок длинной в 41 пиксель."),

    _42('G', 42,   "Блок длинной в 42 пикселя."),

    _43('H', 43,   "Блок длинной в 43 пикселя."),

    _44('I', 44,   "Блок длинной в 44 пикселя."),

    _45('J', 45,   "Блок длинной в 45 пикселей."),

    _46('K', 46,   "Блок длинной в 46 пикселей."),

    _47('L', 47,   "Блок длинной в 47 пикселей."),

    _48('M', 48,   "Блок длинной в 48 пикселей."),

    _49('N', 49,   "Блок длинной в 49 пикселей."),

    _50('O', 50,   "Блок длинной в 50 пикселей."),

    _51('P', 51,   "Блок длинной в 51 пиксель."),

    _52('Q', 52,   "Блок длинной в 52 пикселя."),

    _53('R', 53,   "Блок длинной в 53 пикселя."),

    _54('S', 54,   "Блок длинной в 54 пикселя."),

    _55('T', 55,   "Блок длинной в 55 пикселей."),

    _56('U', 56,   "Блок длинной в 56 пикселей."),

    _57('V', 57,   "Блок длинной в 57 пикселей."),

    _58('W', 58,   "Блок длинной в 58 пикселей."),

    _59('X', 59,   "Блок длинной в 59 пикселей."),

    _60('Y', 60,   "Блок длинной в 60 пикселей."),

    _61('Z', 61,   "Блок длинной в 61 пиксель.");

    public static Element forNumber(int number) {
        return Element.valueOf("_" + number);
    }

    public static Element[] getNumbers() {
        return valuesExcept(NAN, WHITE, BLACK, UNSET);
    }

    private final char ch;
    private final String info;
    private final int code;

    Element(char ch, int code, String info) {
        this.ch = ch;
        this.code = code;
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

    public int code() {
        return code;
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

    public static Element[] valuesExcept(Element... excluded) {
        List<Element> list = Arrays.asList(excluded);
        return Arrays.stream(values())
                .filter(el -> !list.contains(el))
                .collect(toList())
                .toArray(new Element[0]);
    }

}
