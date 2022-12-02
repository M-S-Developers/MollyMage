package com.codenjoy.dojo.games.hex;

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

import java.util.Collection;
import java.util.List;

import static com.codenjoy.dojo.services.PointImpl.pt;

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

    public List<Point> getBarriers() {
        return get(Element.WALL,
                Element.MY_HERO,
                Element.HERO1,
                Element.HERO2,
                Element.HERO3,
                Element.HERO4,
                Element.HERO5,
                Element.HERO6,
                Element.HERO7,
                Element.HERO8,
                Element.HERO9,
                Element.HERO10,
                Element.HERO11);
    }

    public Collection<Point> getWalls() {
        return get(Element.WALL);
    }

    public boolean isBarrierAt(int x, int y) {
        Point pt = pt(x, y);
        return getBarriers().contains(pt) || pt.isOutOf(size());
    }

    public boolean isGameOver() {
        return get(Element.MY_HERO).isEmpty() || get(Element.NONE).isEmpty();
    }
}
