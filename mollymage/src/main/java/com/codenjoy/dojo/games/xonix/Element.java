package com.codenjoy.dojo.games.xonix;

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

/// Море и суша

    SEA('.',           "Море, где живут морские враги. Море нужно делать сушей."),

    LAND('X',          "Ничейная суша, по которой можно передвигаться героям " +
                       "и наземным врагам."),

/// Твой герой

    HERO('O',          "Твой герой."),

    HERO_LAND('#',     "Захваченная тобой суша."),

    HERO_TRACE('o',    "След, который оставляет герой двигаясь по морю или по " +
                       "сушам противника. Уязвим для морских врагов. После выхода " +
                       "героя на сушу, море (и/или суша другого противника), " +
                       "очерченное следом, превращается в сушу."),

/// Противник

    HOSTILE('A',       "Герой противника."),

    HOSTILE_LAND('@',  "Захваченные противниками суша."),

    HOSTILE_TRACE('a', "След, оставляемые противником во время захвата суши."),

/// Враги охотники

    MARINE_ENEMY('M',  "Морской враг."),

    LAND_ENEMY('L',    "Сухопутный враг.");

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
