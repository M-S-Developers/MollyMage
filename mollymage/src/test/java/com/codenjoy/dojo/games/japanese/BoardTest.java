package com.codenjoy.dojo.games.japanese;

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
                 "........\n" +
                 "....1.1.\n" +
                 "...01100\n" +
                 "..0-----\n" +
                 ".11-*-*-\n" +
                 "..0     \n" +
                 "..3 *** \n" +
                 "..0     \n");
    }

    @Test
    public void shouldToString() {
        asrtBrd("Board:\n" +
                "........\n" +
                "....1.1.\n" +
                "...01100\n" +
                "..0-----\n" +
                ".11-*-*-\n" +
                "..0     \n" +
                "..3 *** \n" +
                "..0     \n");
    }

    private void asrtBrd(String expected) {
        assertEquals(expected, board.toString());
    }

    @Test
    public void shouldGetElement() {
        assertEquals("{-=[[3,3], [3,4], [4,3], [5,3], [5,4], [6,3], [7,3], [7,4]], \n" +
                    "*=[[4,4], [4,6], [5,6], [6,4], [6,6]], \n" +
                    " =[[3,5], [3,6], [3,7], [4,5], [4,7], [5,5], [5,7], [6,5], [6,7], [7,5], [7,6], [7,7]], \n" +
                    ".=[[0,0], [0,1], [0,2], [0,3], [0,4], [0,5], [0,6], [0,7], [1,0], [1,1], [1,2], [1,3], [1,5], [1,6], [1,7], [2,0], [2,1], [2,2], [3,0], [3,1], [4,0], [5,0], [5,1], [6,0], [7,0], [7,1]], \n" +
                    "0=[[2,3], [2,5], [2,7], [3,2], [6,2], [7,2]], \n" +
                    "1=[[1,4], [2,4], [4,1], [4,2], [5,2], [6,1]], \n" +
                    "2=[], \n" +
                    "3=[[2,6]], \n" +
                    "4=[], \n" +
                    "5=[], \n" +
                    "6=[], \n" +
                    "7=[], \n" +
                    "8=[], \n" +
                    "9=[], \n" +
                    "a=[], \n" +
                    "b=[], \n" +
                    "c=[], \n" +
                    "d=[], \n" +
                    "e=[], \n" +
                    "f=[], \n" +
                    "g=[], \n" +
                    "h=[], \n" +
                    "i=[], \n" +
                    "j=[], \n" +
                    "k=[], \n" +
                    "l=[], \n" +
                    "m=[], \n" +
                    "n=[], \n" +
                    "o=[], \n" +
                    "p=[], \n" +
                    "q=[], \n" +
                    "r=[], \n" +
                    "s=[], \n" +
                    "t=[], \n" +
                    "u=[], \n" +
                    "v=[], \n" +
                    "w=[], \n" +
                    "x=[], \n" +
                    "y=[], \n" +
                    "z=[], \n" +
                    "A=[], \n" +
                    "B=[], \n" +
                    "C=[], \n" +
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
                    "T=[], \n" +
                    "U=[], \n" +
                    "V=[], \n" +
                    "W=[], \n" +
                    "X=[], \n" +
                    "Y=[], \n" +
                    "Z=[]}",
                Utils.elements(board, Element.values()));
    }

    @Test
    public void shouldGetAt() {
        assertEquals(".", board.getAt(0, 1).toString());
        assertEquals(".", board.getAt(1, 5).toString());
        assertEquals("1", board.getAt(2, 4).toString());
        assertEquals("-", board.getAt(3, 3).toString());
        assertEquals("1", board.getAt(4, 2).toString());
        assertEquals(" ", board.getAt(3, 5).toString());
        assertEquals(".", board.getAt(3, 1).toString());
    }

    @Test
    public void shouldIsAt() {
        assertEquals(false, board.isAt(2, 4, Element._0));
        assertEquals(true,  board.isAt(2, 4, Element._1));
    }
}