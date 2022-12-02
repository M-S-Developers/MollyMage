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


import com.codenjoy.dojo.client.AbstractBoard;
import com.codenjoy.dojo.services.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is a wrapper over the board string
 * coming from the server. Contains a number of
 * inherited methods {@link AbstractBoard},
 * but you can add any methods based on them here.
 */
public class Board extends AbstractBoard<Element> {

    @Override
    protected int inversionY(int y) {
        return size() - 1 - y;
    }

    @Override
    public Element valueOf(char ch) {
        return Element.of(ch);
    }

    @Override
    public String toString() {
        return String.format("%s", boardAsString());
    }

    public Element getAt(int x, int y) {
        if (isOutOfField(x, y)) {
            return null;
        }
        return super.getAt(x, y);
    }

    public List<Point> getBarriers() {
        return get(Element.BARRIER);
    }

    public boolean isBarrier(int x, int y) {
        return getAt(x, y) == Element.BARRIER;
    }

    public boolean isBarrier(Point position) {
        return isBarrier(position.getX(), position.getY());
    }

    public Color getColor(int x, int y) {
        return getAt(x, y).color();
    }

    public Color getColor(Point position) {
        return getColor(position.getX(), position.getY());
    }

    public List<Point> getSquares() {
        List<Point> positions = new ArrayList<>();
        positions.addAll(get(Element.SQUARE));
        positions.addAll(get(Element.pieces()));
        return positions;
    }

    public List<Point> getPieces(Color color) {
        return get(Element.elements(color).toArray(Element[]::new));
    }
}
