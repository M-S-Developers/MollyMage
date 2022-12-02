package com.codenjoy.dojo.games.lemonade;

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

/// Weather forecast

    SUNNY("Sunny weather."),

    CLOUDY("Cloudy weather."),

    HOT_AND_DRY("Hot and dry weather."),

    UNKNOWN("Unknown weather.");

    private final char ch;
    private final String info;

    Element(String info) {
        this.ch = name().toLowerCase().charAt(0);
        this.info = info;
    }

    @Override
    public String info() {
        return info;
    }

    @Override
    public char ch() {
        return ch;
    }
}