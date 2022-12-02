package com.codenjoy.dojo.games.collapse;

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
                 "☼☼☼☼☼☼☼" +
                 "☼12345☼" +
                 "☼67891☼" +
                 "☼23456☼" +
                 "☼78912☼" +
                 "☼3456 ☼" +
                 "☼☼☼☼☼☼☼");
    }

    @Test
    public void shouldToString() {
        asrtBrd("Board:\n" +
                "☼☼☼☼☼☼☼\n" +
                "☼12345☼\n" +
                "☼67891☼\n" +
                "☼23456☼\n" +
                "☼78912☼\n" +
                "☼3456 ☼\n" +
                "☼☼☼☼☼☼☼\n");
    }

    private void asrtBrd(String expected) {
        assertEquals(expected, board.toString());
    }

    @Test
    public void shouldGetElement() {
        assertEquals("{ =[[5,5]], \n" +
                    "☼=[[0,0], [0,1], [0,2], [0,3], [0,4], [0,5], [0,6], [1,0], [1,6], [2,0], [2,6], [3,0], [3,6], [4,0], [4,6], [5,0], [5,6], [6,0], [6,1], [6,2], [6,3], [6,4], [6,5], [6,6]], \n" +
                    "1=[[1,1], [4,4], [5,2]], \n" +
                    "2=[[1,3], [2,1], [5,4]], \n" +
                    "3=[[1,5], [2,3], [3,1]], \n" +
                    "4=[[2,5], [3,3], [4,1]], \n" +
                    "5=[[3,5], [4,3], [5,1]], \n" +
                    "6=[[1,2], [4,5], [5,3]], \n" +
                    "7=[[1,4], [2,2]], \n" +
                    "8=[[2,4], [3,2]], \n" +
                    "9=[[3,4], [4,2]]}",
                Utils.elements(board, Element.values()));
    }

    @Test
    public void shouldGetAt() {
        assertEquals("☼", board.getAt(0, 6).toString());
        assertEquals("3", board.getAt(1, 5).toString());
        assertEquals("8", board.getAt(2, 4).toString());
        assertEquals("4", board.getAt(3, 3).toString());
        assertEquals("9", board.getAt(4, 2).toString());
        assertEquals("5", board.getAt(5, 1).toString());
        assertEquals("☼", board.getAt(6, 0).toString());
    }

    @Test
    public void shouldIsAt() {
        assertEquals(false, board.isAt(2, 5, Element.ONE));
        assertEquals(true,  board.isAt(5, 2, Element.ONE));
    }
}
