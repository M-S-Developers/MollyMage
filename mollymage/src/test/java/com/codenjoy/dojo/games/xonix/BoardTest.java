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

import com.codenjoy.dojo.games.xonix.Board;
import org.junit.Before;
import org.junit.Test;

import static com.codenjoy.dojo.services.PointImpl.pt;
import static com.codenjoy.dojo.games.xonix.Element.*;
import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    public static Board board(String boardString) {
        return (Board) new Board().forString(boardString);
    }

    @Before
    public void before() {
        board = board("####################" +
                    "####################" +
                    "##........o.......##" +
                    "##........o.......##" +
                    "##........oooooooO##" +
                    "##................##" +
                    "##................##" +
                    "##...M............##" +
                    "##................L#" +
                    "##................##" +
                    "##................##" +
                    "##................##" +
                    "##................##" +
                    "##................##" +
                    "##................##" +
                    "##................##" +
                    "##................##" +
                    "##................##" +
                    "####################" +
                    "####################");
    }

    @Test
    public void shouldWork_getAt() {
        assertEquals(SEA, board.getAt(2, 2));
        assertEquals(HERO_LAND, board.getAt(0, 0));
        assertEquals(MARINE_ENEMY, board.getAt(5, 12));
        assertEquals(LAND_ENEMY, board.getAt(18, 11));
    }

    @Test
    public void shouldWork_getAt_point() {
        assertEquals(SEA, board.getAt(pt(2, 2)));
        assertEquals(HERO_LAND, board.getAt(pt(0, 0)));
        assertEquals(MARINE_ENEMY, board.getAt(pt(5, 12)));
        assertEquals(LAND_ENEMY, board.getAt(pt(18, 11)));
    }

    @Test
    public void shouldWork_getAt_outOfBoard() {
        assertNull(board.getAt(-1, 1));
        assertNull(board.getAt(1, -1));
        assertNull(board.getAt(100, 1));
        assertNull(board.getAt(1, 100));

        assertNull(board.getAt(pt(-1, 1)));
        assertNull(board.getAt(pt(1, -1)));
        assertNull(board.getAt(pt(100, 1)));
        assertNull(board.getAt(pt(1, 100)));
    }

    @Test
    public void shouldWork_getHero() {
        assertEquals(pt(17, 15), board.getHero());
    }
}
