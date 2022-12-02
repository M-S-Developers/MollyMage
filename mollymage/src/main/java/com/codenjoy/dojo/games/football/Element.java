package com.codenjoy.dojo.games.football;

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

    NONE(' ',                "Пустое место, куда можно перейти игроку."),

    WALL('☼',                "Внешняя разметка поля, через которую нельзя пройти."),

    HERO('☺',                "Твой игроку."),

    HERO_W_BALL('☻',         "Игрок с мячом."),

    BALL('*',                "Мяч в движении."),

    STOPPED_BALL('∙',        "Мяч остановился."),

    TOP_GOAL('┴',            "Верхние ворота."),

    BOTTOM_GOAL('┬',         "Нижние ворота."),

    MY_GOAL('=',             "Твои ворота."),

    ENEMY_GOAL('⌂',          "Чужие ворота."),

    HITED_GOAL('x',          "Гол в ворота."),

    HITED_MY_GOAL('#',       "Гол в твои ворота."),

    TEAM_MEMBER('♦',         "Игрок твоей команды."),

    TEAM_MEMBER_W_BALL('♥',  "Игрок твоей команды с мячем."),

    ENEMY('♣',               "Игрок команды противников."),

    ENEMY_W_BALL('♠',        "Игрок команды противников с мячем.");

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
