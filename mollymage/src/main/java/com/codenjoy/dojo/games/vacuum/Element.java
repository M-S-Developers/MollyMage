package com.codenjoy.dojo.games.vacuum;

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

/// Разное

    NONE(' ',                  "Чистая клетка локации. Проезд облагается штрафом. " +
                               "Эффективный пылесос должен меньше гулять по чистым " +
                               "местам и больше убираться."),

    VACUUM('O',                "Сам робот-пылесос."),

    START('S',                 "Стартовая точка робота-пылесоса на уровне."),

    BARRIER('#',               "Барьер, через который нельзя проехать."),

    DUST('*',                  "Грязь/пыль, которую нужно очистить для того, " +
                               "чтобы пройти уровень."),

/// Переключатели движения

    SWITCH_LEFT('←',           "Переключатель движения влево. Заехать можно с любой " +
                               "стороны. Автоматически поворачивает робота в сторону, " +
                               "в которую указывает."),

    SWITCH_RIGHT('→',          "Переключатель движения вправо. Заехать можно с любой " +
                               "стороны. Автоматически поворачивает робота в сторону, " +
                               "в которую указывает. "),

    SWITCH_UP('↑',             "Переключатель движения вверх. Заехать можно с любой " +
                               "стороны. Автоматически поворачивает робота в сторону, " +
                               "в которую указывает. "),

    SWITCH_DOWN('↓',           "Переключатель движения вниз. Заехать можно с любой " +
                               "стороны. Автоматически поворачивает робота в сторону, " +
                               "в которую указывает. "),

/// Ограничители въезда

    LIMITER_LEFT('╡',          "Ограничитель въезда. Заехать можно только слева. " +
                               "Выезжать с ограничителя можно в любом направлении."),

    LIMITER_RIGHT('╞',         "Ограничитель въезда. Заехать можно только справа. " +
                               "Выезжать с ограничителя можно в любом направлении."),

    LIMITER_UP('╨',            "Ограничитель въезда. Заехать можно только сверху. " +
                               "Выезжать с ограничителя можно в любом направлении."),

    LIMITER_DOWN('╥',          "Ограничитель въезда. Заехать можно только снизу. " +
                               "Выезжать с ограничителя можно в любом направлении."),

    LIMITER_VERTICAL('║',      "Ограничитель въезда. Заехать можно как сверху, " +
                               "так и снизу. Выезжать с ограничителя можно в любом " +
                               "направлении."),

    LIMITER_HORIZONTAL('═',    "Ограничитель въезда. Заехать можно как слева, " +
                               "так и справа. Выезжать с ограничителя можно в любом " +
                               "направлении."),

/// Карусели

    ROUNDABOUT_LEFT_UP('┘',    "Карусель. Работает одновременно и как переключатель " +
                               "движения и как ограничитель въезда. Заехать можно " +
                               "слева или сверху, повернет робота наверх или налево " +
                               "соответственно. После проезда карусель поворачиваются " +
                               "по часовой стрелке."),

    ROUNDABOUT_UP_RIGHT('└',   "Карусель. Работает одновременно и как переключатель " +
                               "движения и как ограничитель въезда. Заехать можно " +
                               "сверху или справа, повернет робота направо или наверх " +
                               "соответственно. После проезда карусель поворачиваются " +
                               "по часовой стрелке."),

    ROUNDABOUT_RIGHT_DOWN('┌', "Карусель. Работает одновременно и как переключатель " +
                               "движения и как ограничитель въезда. Заехать можно " +
                               "справа или снизу, повернет робота вниз или направо " +
                               "соответственно. После проезда карусель поворачиваются " +
                               "по часовой стрелке."),

    ROUNDABOUT_DOWN_LEFT('┐',  "Карусель. Работает одновременно и как переключатель " +
                               "движения и как ограничитель въезда. Заехать можно " +
                               "снизу или слева, повернет робота налево или вниз " +
                               "соответственно. После проезда карусель поворачиваются " +
                               "по часовой стрелке.");

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

    public static Element byCode(char ch) {
        for (Element el : Element.values()) {
            if (el.ch == ch) {
                return el;
            }
        }
        throw new IllegalArgumentException("No such element for " + ch);
    }

}
