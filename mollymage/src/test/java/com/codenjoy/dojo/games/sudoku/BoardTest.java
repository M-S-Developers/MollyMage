package com.codenjoy.dojo.games.sudoku;

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

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    @Before
    public void setup() {
        board = (Board) new Board().forString(
                "☼☼☼☼☼☼☼☼☼☼☼☼☼" +
                "☼53 ☼ 7 ☼   ☼" +
                "☼6  ☼195☼   ☼" +
                "☼ 98☼   ☼ 6 ☼" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼" +
                "☼8  ☼ 6 ☼  3☼" +
                "☼4  ☼8 3☼  1☼" +
                "☼7  ☼ 2 ☼  6☼" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼" +
                "☼ 6 ☼   ☼28 ☼" +
                "☼   ☼419☼  5☼" +
                "☼   ☼ 8 ☼ 79☼" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼");
    }

    @Test
    public void shouldToString() {
        asrtBrd("☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼53 ☼ 7 ☼   ☼\n" +
                "☼6  ☼195☼   ☼\n" +
                "☼ 98☼   ☼ 6 ☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼8  ☼ 6 ☼  3☼\n" +
                "☼4  ☼8 3☼  1☼\n" +
                "☼7  ☼ 2 ☼  6☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼ 6 ☼   ☼28 ☼\n" +
                "☼   ☼419☼  5☼\n" +
                "☼   ☼ 8 ☼ 79☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n");
    }

    private void asrtBrd(String expected) {
        assertEquals(expected, board.toString());
    }

    @Test
    public void shouldGetElement() {
        assertEquals("{ =[[1,3], [1,9], [1,10], [1,11], [2,2], [2,5], [2,6], [2,7], [2,10], [2,11], [3,1], [3,2], [3,5], [3,6], [3,7], [3,9], [3,10], [3,11], [5,1], [5,3], [5,5], [5,7], [5,9], [5,11], [6,3], [6,6], [6,9], [7,1], [7,3], [7,5], [7,7], [7,9], [7,11], [9,1], [9,2], [9,3], [9,5], [9,6], [9,7], [9,10], [9,11], [10,1], [10,2], [10,5], [10,6], [10,7], [10,10], [11,1], [11,2], [11,3], [11,9]], \n" +
                        "☼=[[0,0], [0,1], [0,2], [0,3], [0,4], [0,5], [0,6], [0,7], [0,8], [0,9], [0,10], [0,11], [0,12], [1,0], [1,4], [1,8], [1,12], [2,0], [2,4], [2,8], [2,12], [3,0], [3,4], [3,8], [3,12], [4,0], [4,1], [4,2], [4,3], [4,4], [4,5], [4,6], [4,7], [4,8], [4,9], [4,10], [4,11], [4,12], [5,0], [5,4], [5,8], [5,12], [6,0], [6,4], [6,8], [6,12], [7,0], [7,4], [7,8], [7,12], [8,0], [8,1], [8,2], [8,3], [8,4], [8,5], [8,6], [8,7], [8,8], [8,9], [8,10], [8,11], [8,12], [9,0], [9,4], [9,8], [9,12], [10,0], [10,4], [10,8], [10,12], [11,0], [11,4], [11,8], [11,12], [12,0], [12,1], [12,2], [12,3], [12,4], [12,5], [12,6], [12,7], [12,8], [12,9], [12,10], [12,11], [12,12]], \n" +
                        "*=[], \n" +
                        "1=[[5,2], [6,10], [11,6]], \n" +
                        "2=[[6,7], [9,9]], \n" +
                        "3=[[2,1], [7,6], [11,5]], \n" +
                        "4=[[1,6], [5,10]], \n" +
                        "5=[[1,1], [7,2], [11,10]], \n" +
                        "6=[[1,2], [2,9], [6,5], [10,3], [11,7]], \n" +
                        "7=[[1,7], [6,1], [10,11]], \n" +
                        "8=[[1,5], [3,3], [5,6], [6,11], [10,9]], \n" +
                        "9=[[2,3], [6,2], [7,10], [11,11]]}",
                Utils.elements(board, Element.values()));
    }

    @Test
    public void shouldGetAt() {
        assertEquals(
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼53 ☼ 7 ☼   ☼\n" +
                "☼6  ☼195☼   ☼\n" +
                "☼ 98☼   ☼ 6 ☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼8  ☼ 6 ☼  3☼\n" +
                "☼4  ☼8 3☼  1☼\n" +
                "☼7  ☼ 2 ☼  6☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼ 6 ☼   ☼28 ☼\n" +
                "☼   ☼419☼  5☼\n" +
                "☼   ☼ 8 ☼ 79☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n", checkXY());
    }

    private String checkXY() {
        String result = "";
        for (int y = 0; y < board.size(); y++) {
            for (int x = 0; x < board.size(); x++) {
                result += format(board.getAt(x, y).toString());
            }
            result += '\n';
        }
        return result;
    }

    @Test
    public void shouldIsAt() {
        assertFalse(board.isAt(2, 9, Element.FIVE));
        assertTrue(board.isAt(2, 9, Element.SIX));
    }

    @Test
    public void shouldGetY() {
        assertEquals(
            "530070000\n" +
            "600195000\n" +
            "098000060\n" +
            "800060003\n" +
            "400803001\n" +
            "700020006\n" +
            "060000280\n" +
            "000419005\n" +
            "000080079\n", checkY());
    }

    private String checkY() {
        String result = "";
        for (int y = 1; y <= 9; y++) {
            result += format(board.getY(y).toString()) + "\n";
        }
        return result;
    }

    private String format(String s) {
        return s.replaceAll("(, )", "").replaceAll("[\\[\\]]", "").replaceAll("-1", "*");
    }

    private String checkX() {
        String result = "";
        for (int x = 1; x <= 9; x++) {
            result += format(board.getX(x).toString()) + "\n";
        }
        return result;
    }

    @Test
    public void shouldGetX() {
        assertEquals(
            "560847000\n" +
            "309000600\n" +
            "008000000\n" +
            "010080040\n" +
            "790602018\n" +
            "050030090\n" +
            "000000200\n" +
            "006000807\n" +
            "000316059\n", checkX());
    }

    @Test
    public void shouldGetC() {
        assertEquals(
            "530600098\n" +
            "800400700\n" +
            "060000000\n" +
            "070195000\n" +
            "060803020\n" +
            "000419080\n" +
            "000000060\n" +
            "003001006\n" +
            "280005079\n", checkC());
    }

    private String checkC() {
        String result = "";
        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                result += format(board.getC(x, y).toString()) + "\n";
            }
        }
        return result;
    }

    @Test
    public void shouldSet() {
        board.set(1, 9, 1);

        asrtBrd("☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼53 ☼ 7 ☼   ☼\n" +
                "☼6  ☼195☼   ☼\n" +
                "☼ 98☼   ☼ 6 ☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼8  ☼ 6 ☼  3☼\n" +
                "☼4  ☼8 3☼  1☼\n" +
                "☼7  ☼ 2 ☼  6☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼ 6 ☼   ☼28 ☼\n" +
                "☼   ☼419☼  5☼\n" +
                "☼1  ☼ 8 ☼ 79☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n");

        board.set(3, 3, 3);

        asrtBrd("☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼53 ☼ 7 ☼   ☼\n" +
                "☼6  ☼195☼   ☼\n" +
                "☼ 93☼   ☼ 6 ☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼8  ☼ 6 ☼  3☼\n" +
                "☼4  ☼8 3☼  1☼\n" +
                "☼7  ☼ 2 ☼  6☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼ 6 ☼   ☼28 ☼\n" +
                "☼   ☼419☼  5☼\n" +
                "☼1  ☼ 8 ☼ 79☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n");

        board.set(9, 9, 2);

        asrtBrd("☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼53 ☼ 7 ☼   ☼\n" +
                "☼6  ☼195☼   ☼\n" +
                "☼ 93☼   ☼ 6 ☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼8  ☼ 6 ☼  3☼\n" +
                "☼4  ☼8 3☼  1☼\n" +
                "☼7  ☼ 2 ☼  6☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                "☼ 6 ☼   ☼28 ☼\n" +
                "☼   ☼419☼  5☼\n" +
                "☼1  ☼ 8 ☼ 72☼\n" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼\n");
    }
}
