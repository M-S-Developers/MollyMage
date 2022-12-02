package com.codenjoy.dojo.games.a2048;

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
                 "CB224 \n" +
                 "AB48  \n" +
                 "A8    \n" +
                 " A 2  \n" +
                 "   2  \n" +
                 "2     \n");
    }

    @Test
    public void shouldToString() {
        asrtBrd("Board:\n" +
                "CB224 \n" +
                "AB48  \n" +
                "A8    \n" +
                " A 2  \n" +
                "   2  \n" +
                "2     \n");
    }

    private void asrtBrd(String expected) {
        assertEquals(expected, board.toString());
    }

    @Test
    public void shouldGetElement() {
        assertEquals("{x=[], \n" +
                        "2=[[0,0], [2,5], [3,1], [3,2], [3,5]], \n" +
                        "4=[[2,4], [4,5]], \n" +
                        "8=[[1,3], [3,4]], \n" +
                        "A=[[0,3], [0,4], [1,2]], \n" +
                        "B=[[1,4], [1,5]], \n" +
                        "C=[[0,5]], \n" +
                        "D=[], \n" +
                        "E=[], \n" +
                        "F=[], \n" +
                        "G=[], \n" +
                        "H=[], \n" +
                        "I=[], \n" +
                        "J=[], \n" +
                        "K=[], \n" +
                        "L=[], \n" +
                        "M=[], \n" +
                        "N=[], \n" +
                        "O=[], \n" +
                        "P=[], \n" +
                        "Q=[], \n" +
                        "R=[], \n" +
                        "S=[], \n" +
                        " =[[0,1], [0,2], [1,0], [1,1], [2,0], [2,1], [2,2], [2,3], [3,0], [3,3], [4,0], [4,1], [4,2], [4,3], [4,4], [5,0], [5,1], [5,2], [5,3], [5,4], [5,5]]}",
                Utils.elements(board, Element.values()));
    }

    @Test
    public void shouldGetAt() {
        assertEquals(" ", board.getAt(0, 1).toString());
        assertEquals("B", board.getAt(1, 5).toString());
        assertEquals("4", board.getAt(2, 4).toString());
        assertEquals(" ", board.getAt(3, 3).toString());
        assertEquals(" ", board.getAt(4, 2).toString());
        assertEquals("2", board.getAt(2, 5).toString());
        assertEquals("C", board.getAt(0, 5).toString());
    }

    @Test
    public void shouldIsAt() {
        assertEquals(false, board.isAt(5, 2, Element._2));
        assertEquals(true,  board.isAt(2, 4, Element._4));
    }
}