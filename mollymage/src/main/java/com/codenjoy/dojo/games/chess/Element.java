package com.codenjoy.dojo.games.chess;

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

/// Поле

    SQUARE('.',       "."),
    BARRIER(' ',      "."),

/// Фигуры белых

    WHITE_KING('W',   "Король белых."),
    WHITE_QUEEN('Q',  "Ферзь белых."),
    WHITE_ROOK('R',   "Ладья белых."),
    WHITE_BISHOP('B', "Слон белых."),
    WHITE_KNIGHT('K', "Конь белых."),
    WHITE_PAWN('P',   "Пешка белых."),

/// Фигуры черных

    BLACK_KING('w',   "Король черных."),
    BLACK_QUEEN('q',  "Ферзь черных."),
    BLACK_ROOK('r',   "Ладья черных."),
    BLACK_BISHOP('b', "Слон черных."),
    BLACK_KNIGHT('k', "Конь черных."),
    BLACK_PAWN('p',   "Пешка черных."),

/// Фигуры красных

    RED_KING('Y',     "Король красных."),
    RED_QUEEN('X',    "Ферзь красных."),
    RED_ROOK('I',     "Ладья красных."),
    RED_BISHOP('G',   "Слон красных."),
    RED_KNIGHT('L',   "Конь красных."),
    RED_PAWN('Z',     "Пешка красных."),

/// Фигуры синих

    BLUE_KING('y',    "Король синих."),
    BLUE_QUEEN('x',   "Ферзь синих."),
    BLUE_ROOK('i',    "Ладья синих."),
    BLUE_BISHOP('g',  "Слон синих."),
    BLUE_KNIGHT('l',  "Конь синих."),
    BLUE_PAWN('z',    "Пешка синих."),

// Системные спрайты

    BACKGROUND('-',   "Системный спрайт - изображение шахматной доски.");

    private final char ch;
    private final String info;
    private final Color color;

    Element(char ch, String info) {
        this.ch = ch;
        this.info = info;
        switch (name().split("_")[0]) {
            case "RED" : color = Color.RED; break;
            case "BLACK" : color = Color.BLACK; break;
            case "WHITE" : color = Color.WHITE; break;
            case "BLUE" : color = Color.BLUE; break;
            default: color = null;
        }
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

    public Color color() {
        return color;
    }

    public static List<Element> elements(Color color) {
        return Arrays.stream(Element.values())
                .filter(element -> color.equals(element.color()))
                .collect(toList());
    }

    public static Element of(char ch) {
        for (Element element : Element.values()) {
            if (element.ch == ch) {
                return element;
            }
        }
        return null;
    }

    public static Element[] pieces() {
        return Arrays.stream(Element.values())
                .filter(e -> e != SQUARE)
                .filter(e -> e != BARRIER)
                .toArray(Element[]::new);
    }
}
