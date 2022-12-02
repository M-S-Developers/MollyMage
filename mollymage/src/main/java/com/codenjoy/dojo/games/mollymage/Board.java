package com.codenjoy.dojo.games.mollymage;

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
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.codenjoy.dojo.games.mollymage.Element.*;
import static com.codenjoy.dojo.services.Direction.*;

/**
 * The class is a wrapper over the board string
 * coming from the server. Contains a number of
 * inherited methods {@link AbstractBoard},
 * but you can add any methods based on them here.
 */
public class Board extends AbstractBoard<Element> {

    private static final int BLAST_RANGE = 3;

    @Override
    public Element valueOf(char ch) {
        return Element.valueOf(ch);
    }

    @Override
    protected int inversionY(int y) {
        return size - 1 - y;
    }

    @Override
    protected boolean withoutCorners() {
        return true;
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

    public List<Point> getEnemyHeroes() {
        return get(enemyHeroes());
    }

    public List<Point> getGhosts() {
        return get(ghosts());
    }

    public List<Point> getWalls() {
        return get(walls());
    }

    public List<Point> getTreasureBoxes() {
        return get(treasureBoxes());
    }

    public List<Point> getPotions() {
        return get(potions());
    }

    public List<Point> getPerks() {
        return get(perks());
    }

    public List<Point> getBlasts() {
        return get(blasts());
    }

    public List<Point> getFutureBlasts() {
        List<Point> result = new ArrayList<>();
        for (Point pt : get(POTION_TIMER_1)) {
            result.addAll(getFutureBlasts(pt, RIGHT));
            result.addAll(getFutureBlasts(pt, LEFT));
            result.addAll(getFutureBlasts(pt, UP));
            result.addAll(getFutureBlasts(pt, DOWN));
        }
        return result;
    }

    private List<Point> getFutureBlasts(Point pt, Direction direction) {
        Collection<Point> barriers = getBarriers();

        List<Point> result = new ArrayList<>();
        for (int index = 0; index < BLAST_RANGE; index++) {
            pt = direction.change(pt);
            if (pt.isOutOf(size)) {
                break;
            }
            if (barriers.contains(pt)) {
                break;
            }
            result.add(pt);
        }
        return result;
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

    public boolean isEnemyHeroAt(Point pt) {
        return isAt(pt, enemyHeroes());
    }

    public boolean isGhostAt(Point pt) {
        return isAt(pt, ghosts());
    }

    public boolean isWallAt(Point pt) {
        return isAt(pt, walls());
    }

    public boolean isTreasureBoxAt(Point pt) {
        return isAt(pt, treasureBoxes());
    }

    public boolean isPotionAt(Point pt) {
        return isAt(pt, potions());
    }

    public boolean isPerkAt(Point pt) {
        return isAt(pt, perks());
    }

    public boolean isBlastAt(Point pt) {
        return isAt(pt, blasts());
    }

    public boolean isFutureBlastAt(Point pt) {
       return getFutureBlasts().contains(pt);
    }

    public boolean isBarrierAt(Point pt) {
        return isAt(pt, barriers());
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                        "Hero at: %s\n" +
                        "Other heroes at: %s\n" +
                        "Enemy heroes at: %s\n" +
                        "Ghosts at: %s\n" +
                        "Treasure boxes at: %s\n" +
                        "Potions at: %s\n" +
                        "Blasts: %s\n" +
                        "Expected blasts at: %s",
                boardAsString(),
                getHero(),
                getOtherHeroes(),
                getEnemyHeroes(),
                getGhosts(),
                getTreasureBoxes(),
                getPotions(),
                getBlasts(),
                getFutureBlasts());
    }
}