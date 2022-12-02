package com.codenjoy.dojo.games.pong;

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
                 "          \n" +
                 "----------\n" +
                 "|       H|\n" +
                 "|       H|\n" +
                 "|    o  H|\n" +
                 "|#       |\n" +
                 "|#       |\n" +
                 "|#       |\n" +
                 "----------\n" +
                 "          \n");
    }

    @Test
    public void shouldToString() {
        asrtBrd("Board:\n" +
                "          \n" +
                "----------\n" +
                "|       H|\n" +
                "|       H|\n" +
                "|    o  H|\n" +
                "|#       |\n" +
                "|#       |\n" +
                "|#       |\n" +
                "----------\n" +
                "          \n");
    }

    private void asrtBrd(String expected) {
        assertEquals(expected, board.toString());
    }

    @Test
    public void shouldGetElement() {
        assertEquals("{ =[[0,0], [0,9], [1,0], [1,2], [1,3], [1,4], [1,9], [2,0], [2,2], [2,3], [2,4], [2,5], [2,6], [2,7], [2,9], [3,0], [3,2], [3,3], [3,4], [3,5], [3,6], [3,7], [3,9], [4,0], [4,2], [4,3], [4,4], [4,5], [4,6], [4,7], [4,9], [5,0], [5,2], [5,3], [5,5], [5,6], [5,7], [5,9], [6,0], [6,2], [6,3], [6,4], [6,5], [6,6], [6,7], [6,9], [7,0], [7,2], [7,3], [7,4], [7,5], [7,6], [7,7], [7,9], [8,0], [8,5], [8,6], [8,7], [8,9], [9,0], [9,9]], \n" +
                    "|=[[0,2], [0,3], [0,4], [0,5], [0,6], [0,7], [9,2], [9,3], [9,4], [9,5], [9,6], [9,7]], \n" +
                    "-=[[0,1], [0,8], [1,1], [1,8], [2,1], [2,8], [3,1], [3,8], [4,1], [4,8], [5,1], [5,8], [6,1], [6,8], [7,1], [7,8], [8,1], [8,8], [9,1], [9,8]], \n" +
                    "o=[[5,4]], \n" +
                    "#=[[1,5], [1,6], [1,7]], \n" +
                    "H=[[8,2], [8,3], [8,4]]}",
                Utils.elements(board, Element.values()));
    }

    @Test
    public void shouldGetAt() {
        assertEquals("-", board.getAt(0, 1).toString());
        assertEquals("|", board.getAt(0, 2).toString());
        assertEquals("o", board.getAt(5, 4).toString());
        assertEquals(" ", board.getAt(5, 3).toString());
        assertEquals("#", board.getAt(1, 5).toString());
        assertEquals("-", board.getAt(1, 1).toString());
        assertEquals("H", board.getAt(8, 2).toString());
    }

    @Test
    public void shouldIsAt() {
        assertEquals(false, board.isAt(0, 1, Element.PANEL));
        assertEquals(true,  board.isAt(0, 1, Element.HORIZONTAL_WALL));
    }
}