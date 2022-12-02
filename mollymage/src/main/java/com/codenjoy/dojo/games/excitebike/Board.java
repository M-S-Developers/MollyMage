package com.codenjoy.dojo.games.excitebike;

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
import com.codenjoy.dojo.games.excitebike.element.BikeElement;
import com.codenjoy.dojo.games.excitebike.element.GameElement;
import com.codenjoy.dojo.games.excitebike.element.SpringboardElement;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.printer.CharElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class is a wrapper over the board string
 * coming from the server. Contains a number of
 * inherited methods {@link AbstractBoard},
 * but you can add any methods based on them here.
 */
public class Board extends AbstractBoard<CharElement> {

    private static final String OTHER_BIKE_PREFIX = "OTHER";
    private static final String FALLEN_BIKE_SUFFIX = "FALLEN";

    // optimized for performance
    public static final BikeElement[] BIKE_TYPES = Arrays.stream(BikeElement.values())
            .filter(v -> !v.name().contains(OTHER_BIKE_PREFIX))
            .collect(Collectors.toList())
            .toArray(new BikeElement[]{});

    // optimized for performance
    // TODO заменить символы в Element и укоротить этот массив до 255
    public static CharElement[] ALL_ELEMENTS; static {
        if (ALL_ELEMENTS == null) {
            ALL_ELEMENTS = new CharElement[10000];
            Arrays.stream(GameElement.values())
                    .forEach(el -> ALL_ELEMENTS[el.ch()] = el);
            Arrays.stream(SpringboardElement.values())
                    .forEach(el -> ALL_ELEMENTS[el.ch()] = el);
            Arrays.stream(BikeElement.values())
                    .forEach(el -> ALL_ELEMENTS[el.ch()] = el);
        }
    }

    @Override
    public CharElement valueOf(char ch) {
        CharElement result = ALL_ELEMENTS[ch];
        if (result == null) {
            throw new IllegalArgumentException("No such element for " + ch);
        }
        return result;
    }

    public Point getMe() {
        return getFirst(BIKE_TYPES);
    }

    public boolean isGameOver() {
        Point me = getMe();
        return me == null || Arrays.stream(BikeElement.values())
                .filter(v -> !v.name().contains(OTHER_BIKE_PREFIX) && v.name().contains(FALLEN_BIKE_SUFFIX))
                .anyMatch(v -> isAt(me, v));
    }

    public boolean checkNearMe(List<Direction> directions, CharElement... elements) {
        Point point = getMe();
        if (point == null) {
            return false;
        }
        for (Direction direction : directions) {
            point = direction.change(point);
        }
        return isAt(point.getX(), point.getY(), elements);
    }

    public boolean checkNearMe(Direction direction, CharElement... elements) {
        Point me = getMe();
        if (me == null) {
            return false;
        }
        Point atDirection = direction.change(me);
        return isAt(atDirection.getX(), atDirection.getY(), elements);
    }

    public boolean checkAtMe(CharElement... elements) {
        Point me = getMe();
        return me != null && isAt(me, elements);
    }

    public boolean isOutOfFieldRelativeToMe(Direction direction) {
        Point me = getMe();
        if (me == null) {
            return false;
        }
        Point atDirection = direction.change(me);
        return isOutOfField(atDirection.getX(), atDirection.getY());
    }

    @Override
    public String toString() {
        String superToString = super.toString();
        int indexOfFirstFence = superToString.indexOf(GameElement.FENCE.ch());
        int nextLineStatementLength = 2;
        return superToString.substring(indexOfFirstFence >= nextLineStatementLength
                ? indexOfFirstFence - nextLineStatementLength
                : indexOfFirstFence);
    }
}
