package com.codenjoy.dojo.games.verland;

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

import static com.codenjoy.dojo.games.verland.Element.*;

/**
 * The class is a wrapper over the board string
 * coming from the server. Contains a number of
 * inherited methods {@link AbstractBoard},
 * but you can add any methods based on them here.
 */
public class Board extends AbstractBoard<Element> {

    @Override
    public Element valueOf(char ch) {
        return Element.valueOf(ch);
    }

    @Override
    protected int inversionY(int y) {
        return size - 1 - y;
    }

    public Point getHero() {
        List<Point> list = get(heroes());
        return (list.isEmpty()) ? null : list.get(0);
    }

    public Element getAt(int x, int y) {
        if (isOutOfField(x, y)) {
            return PATHLESS;
        }
        return super.getAt(x, y);
    }

    public boolean isGameOver() {
        return !get(HERO_DEAD).isEmpty();
    }

    public boolean isWin() {
        return !isGameOver() && !get(HERO_HEALING).isEmpty();
    }

    public List<Point> getOtherHeroes() {
        return get(otherHeroes());
    }

    public List<Point> getEnemyHeroes() {
        return get(enemyHeroes());
    }

    public List<Point> getContagions() {
        return get(contagions());
    }

    public List<Point> getHealing() {
        return get(healing());
    }

    public List<Point> getCure() {
        return get(cure());
    }

    public List<Point> getPathless() {
        return get(pathless());
    }

    public List<Point> getInfections() {
        return get(infections());
    }

    public List<Point> getHidden() {
        return get(hidden());
    }

    public List<Point> getClear() {
        return get(clear());
    }

    public boolean isHeroAt(Point pt) {
        return isAt(pt, heroes());
    }

    public boolean isOtherHeroAt(Point pt) {
        return isAt(pt, otherHeroes());
    }

    public boolean isEnemyHeroAt(Point pt) {
        return isAt(pt, enemyHeroes());
    }

    public boolean isContagionAt(Point pt) {
        return isAt(pt, contagions());
    }

    public boolean isPathlessAt(Point pt) {
        return isAt(pt, pathless());
    }

    public boolean isInfectionsAt(Point pt) {
        return isAt(pt, infections());
    }

    public boolean isHiddenAt(Point pt) {
        return isAt(pt, hidden());
    }

    public boolean isClearAt(Point pt) {
        return isAt(pt, clear());
    }

    public int countContagions(Point pt) {
        return isAt(pt, contagions())
                ? getAt(pt).value()
                : 0;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                        "Hero at: %s\n" +
                        "Other heroes at: %s\n" +
                        "Enemy heroes at: %s\n" +
                        "Contagions at: %s\n",
                boardAsString(),
                getHero(),
                getOtherHeroes(),
                getEnemyHeroes(),
                getContagions());
    }
}