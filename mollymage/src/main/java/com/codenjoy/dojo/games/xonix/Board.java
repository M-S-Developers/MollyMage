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


import com.codenjoy.dojo.client.AbstractBoard;
import com.codenjoy.dojo.services.Point;

import java.util.List;

import static com.codenjoy.dojo.games.xonix.Element.*;

/**
 * Класс, обрабатывающий строковое представление доски.
 * Содержит ряд унаследованных методов {@link AbstractBoard},
 * но ты можешь добавить сюда любые свои методы на их основе.
 */
public class Board extends AbstractBoard<Element> {

    @Override
    protected int inversionY(int y) {
        return size() - 1 - y;
    }

    @Override
    public Element valueOf(char ch) {
        return Element.byCode(ch);
    }

    public Element getAt(int x, int y) {
        if (isOutOfField(x, y)) {
            return null;
        }
        return super.getAt(x, y);
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "Hero at: %s\n" +
                "Hero trace at: %s\n" +
                "Hero land at: %s\n" +
                "Hostile at: %s\n" +
                "Hostile trace at: %s\n" +
                "Hostile land at: %s\n" +
                "Marine enemies at: %s\n" +
                "Land enemies at: %s\n",
                boardAsString(),
                getHero(),
                getHeroTrace(),
                getHeroLand(),
                getHostile(),
                getHostileTrace(),
                getHostileLand(),
                getMarineEnemies(),
                getLandEnemies());
    }

    public Point getHero() {
        List<Point> heroes = get(HERO);
        if (heroes.isEmpty()) {
            return null;
        }
        return heroes.get(0);
    }

    public List<Point> getSea() {
        return get(SEA);
    }

    public List<Point> getHeroLand() {
        return get(HERO_LAND);
    }

    public List<Point> getHeroTrace() {
        return get(HERO_TRACE);
    }

    public List<Point> getHostile() {
        return get(HOSTILE);
    }

    public List<Point> getHostileLand() {
        return get(HOSTILE_LAND);
    }

    public List<Point> getHostileTrace() {
        return get(HOSTILE_TRACE);
    }

    public List<Point> getMarineEnemies() {
        return get(MARINE_ENEMY);
    }

    public List<Point> getLandEnemies() {
        return get(LAND_ENEMY);
    }
}
