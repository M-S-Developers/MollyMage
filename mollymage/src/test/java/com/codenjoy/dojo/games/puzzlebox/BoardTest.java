package com.codenjoy.dojo.games.puzzlebox;

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


import com.codenjoy.dojo.client.Utils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    private Board board;

    @Before
    public void setup() {
         board = (Board) new Board().forString(
                 "☼☼☼☼☼☼☼☼☼\n" +
                 "☼    ☼  ☼\n" +
                 "☼☼☼     ☼\n" +
                 "☼   0  ☼☼\n" +
                 "☼      0☼\n" +
                 "☼  #    ☼\n" +
                 "☼       ☼\n" +
                 "☼#   0# ☼\n" +
                 "☼☼☼☼☼☼☼☼☼\n");
    }

    @Test
    public void shouldToString() {
        asrtBrd("Board:\n" +
                "☼☼☼☼☼☼☼☼☼\n" +
                "☼    ☼  ☼\n" +
                "☼☼☼     ☼\n" +
                "☼   0  ☼☼\n" +
                "☼      0☼\n" +
                "☼  #    ☼\n" +
                "☼       ☼\n" +
                "☼#   0# ☼\n" +
                "☼☼☼☼☼☼☼☼☼\n");
    }

    private void asrtBrd(String expected) {
        assertEquals(expected, board.toString());
    }

    @Test
    public void shouldGetElement() {
        assertEquals("{ =[[1,1], [1,3], [1,4], [1,5], [1,6], [2,1], [2,3], [2,4], [2,5], [2,6], [2,7], [3,1], [3,2], [3,3], [3,4], [3,6], [3,7], [4,1], [4,2], [4,4], [4,5], [4,6], [4,7], [5,2], [5,3], [5,4], [5,5], [5,6], [6,1], [6,2], [6,3], [6,4], [6,5], [6,6], [7,1], [7,2], [7,5], [7,6], [7,7]], \n" +
                    "☼=[[0,0], [0,1], [0,2], [0,3], [0,4], [0,5], [0,6], [0,7], [0,8], [1,0], [1,2], [1,8], [2,0], [2,2], [2,8], [3,0], [3,8], [4,0], [4,8], [5,0], [5,1], [5,8], [6,0], [6,8], [7,0], [7,3], [7,8], [8,0], [8,1], [8,2], [8,3], [8,4], [8,5], [8,6], [8,7], [8,8]], \n" +
                    "☺=[], \n" +
                    "#=[[1,7], [3,5], [6,7]], \n" +
                    "1=[], \n" +
                    "@=[], \n" +
                    "0=[[4,3], [5,7], [7,4]]}",
                Utils.elements(board, Element.values()));
    }

    @Test
    public void shouldGetAt() {
        assertEquals("☼", board.getAt(0, 1).toString());
        assertEquals("#", board.getAt(1, 7).toString());
        assertEquals("0", board.getAt(4, 3).toString());
        assertEquals("#", board.getAt(3, 5).toString());
        assertEquals("☼", board.getAt(0, 0).toString());
        assertEquals(" ", board.getAt(1, 4).toString());
        assertEquals(" ", board.getAt(1, 6).toString());
    }

    @Test
    public void shouldIsAt() {
        assertEquals(false, board.isAt(0, 1, Element.BOX));
        assertEquals(true,  board.isAt(0, 1, Element.WALL));
    }
}