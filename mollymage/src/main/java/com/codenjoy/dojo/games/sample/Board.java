package com.codenjoy.dojo.games.sample;

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

import static com.codenjoy.dojo.games.sample.Element.*;

/**
 * Класс, обрабатывающий строковое представление доски.
 * Содержит ряд унаследованных методов {@link AbstractBoard},
 * но ты можешь добавить сюда любые свои методы на их основе.
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

    @Override
    public Element getAt(int x, int y) {
        if (isOutOfField(x, y)) {
            return WALL;
        }
        return super.getAt(x, y);
    }

    public boolean isGameOver() {
        return !get(HERO_DEAD).isEmpty();
    }

    public Point getHero() {
        List<Point> list = get(heroes());
        return (list.isEmpty()) ? null : list.get(0);
    }

    public List<Point> getOtherHeroes() {
        return get(otherHeroes());
    }

    public List<Point> getWalls() {
        return get(walls());
    }

    public List<Point> getBombs() {
        return get(bombs());
    }

    public List<Point> getGold() {
        return get(gold());
    }

    public List<Point> getBarriers() {
       return get(barriers());
    }

    public boolean isHeroAt(Point pt) {
        return isAt(pt, heroes());
    }

    public boolean isOtherHeroAt(Point pt) {
        return isAt(pt, otherHeroes());
    }

    public boolean isWallAt(Point pt) {
        return isAt(pt, walls());
    }

    public boolean isBombAt(Point pt) {
        return isAt(pt, bombs());
    }

    public boolean isGoldAt(Point pt) {
        return isAt(pt, gold());
    }

    public boolean isBarrierAt(Point pt) {
        return isAt(pt, barriers());
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                        "Hero at: %s\n" +
                        "Other heroes at: %s\n" +
                        "Bombs at: %s\n" +
                        "Gold at: %s\n",
                boardAsString(),
                getHero(),
                getOtherHeroes(),
                getBombs(),
                getGold());
    }
}
