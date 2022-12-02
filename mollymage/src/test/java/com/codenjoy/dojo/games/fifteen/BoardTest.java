package com.codenjoy.dojo.games.fifteen;

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
                 "******" +
                 "*abcd*" +
                 "*efgh*" +
                 "*ij+k*" +
                 "*mnol*" +
                 "******");
    }

    @Test
    public void shouldToString() {
        asrtBrd("Board:\n" +
                "******\n" +
                "*abcd*\n" +
                "*efgh*\n" +
                "*ij+k*\n" +
                "*mnol*\n" +
                "******\n");
    }

    private void asrtBrd(String expected) {
        assertEquals(expected, board.toString());
    }

    @Test
    public void shouldGetElement() {
        assertEquals("{a=[[1,1]], \n" +
                        "b=[[2,1]], \n" +
                        "c=[[3,1]], \n" +
                        "d=[[4,1]], \n" +
                        "e=[[1,2]], \n" +
                        "f=[[2,2]], \n" +
                        "g=[[3,2]], \n" +
                        "h=[[4,2]], \n" +
                        "i=[[1,3]], \n" +
                        "j=[[2,3]], \n" +
                        "k=[[4,3]], \n" +
                        "l=[[4,4]], \n" +
                        "m=[[1,4]], \n" +
                        "n=[[2,4]], \n" +
                        "o=[[3,4]], \n" +
                        "+=[[3,3]], \n" +
                        "*=[[0,0], [0,1], [0,2], [0,3], [0,4], [0,5], [1,0], [1,5], [2,0], [2,5], [3,0], [3,5], [4,0], [4,5], [5,0], [5,1], [5,2], [5,3], [5,4], [5,5]]}",
                Utils.elements(board, Element.values()));
    }

    @Test
    public void shouldGetAt() {
        assertEquals("*", board.getAt(0, 1).toString());
        assertEquals("*", board.getAt(1, 5).toString());
        assertEquals("n", board.getAt(2, 4).toString());
        assertEquals("+", board.getAt(3, 3).toString());
        assertEquals("h", board.getAt(4, 2).toString());
        assertEquals("*", board.getAt(5, 1).toString());
        assertEquals("*", board.getAt(5, 0).toString());
    }

    @Test
    public void shouldIsAt() {
        assertEquals(false, board.isAt(5, 2, Element.A));
        assertEquals(true,  board.isAt(4, 2, Element.H));
    }
}