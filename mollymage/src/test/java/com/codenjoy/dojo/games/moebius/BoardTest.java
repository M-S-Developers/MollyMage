package com.codenjoy.dojo.games.moebius;

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
                 "╔═══╗\n" +
                 "║╔╗═║\n" +
                 "║╚ ║║\n" +
                 "║╝ ╬║\n" +
                 "╚═══╝\n");
    }

    @Test
    public void shouldToString() {
        asrtBrd("Board:\n" +
                "╔═══╗\n" +
                "║╔╗═║\n" +
                "║╚ ║║\n" +
                "║╝ ╬║\n" +
                "╚═══╝\n");
    }

    private void asrtBrd(String expected) {
        assertEquals(expected, board.toString());
    }

    @Test
    public void shouldGetElement() {
        assertEquals("{╝=[[1,3], [4,4]], \n" +
                    "╚=[[0,4], [1,2]], \n" +
                    "╔=[[0,0], [1,1]], \n" +
                    "╗=[[2,1], [4,0]], \n" +
                    "═=[[1,0], [1,4], [2,0], [2,4], [3,0], [3,1], [3,4]], \n" +
                    "║=[[0,1], [0,2], [0,3], [3,2], [4,1], [4,2], [4,3]], \n" +
                    "╬=[[3,3]], \n" +
                    " =[[2,2], [2,3]]}",
                Utils.elements(board, Element.values()));
    }

    @Test
    public void shouldGetAt() {
        assertEquals("║", board.getAt(0, 1).toString());
        assertEquals("╚", board.getAt(1, 2).toString());
        assertEquals("═", board.getAt(2, 4).toString());
        assertEquals("╬", board.getAt(3, 3).toString());
        assertEquals(" ", board.getAt(2, 2).toString());
        assertEquals("╔", board.getAt(1, 1).toString());
        assertEquals(" ", board.getAt(2, 3).toString());
    }

    @Test
    public void shouldIsAt() {
        assertEquals(false, board.isAt(0, 1, Element.CROSS));
        assertEquals(true,  board.isAt(0, 1, Element.UP_DOWN));
    }
}