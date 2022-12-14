package com.codenjoy.dojo.client;

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


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AbstractBoardTest {
    private AbstractBoard board;

    public static AbstractBoard board(String boardString) {
        return (AbstractBoard)new AbstractBoard<Element>(){
            @Override
            public Element valueOf(char ch) {
                return Element.valueOf(ch);
            }
        }.forString(boardString);
    }

    @Before
    public void before() {
        board = board(
                "1111" +
                "1221" +
                "1331" +
                "1111");
    }

    @Test
    public void shouldWork_toString() {
        assertEquals(
                "Board:\n" +
                "1111\n" +
                "1221\n" +
                "1331\n" +
                "1111\n", board.toString());
    }

    @Test
    public void shouldWork_getField() {
        assertEquals(
                "[[1, 1, 1, 1], " +
                "[1, 2, 3, 1], " +
                "[1, 2, 3, 1], " +
                "[1, 1, 1, 1]]",
                Arrays.deepToString(board.getField(0)));
    }

    @Test
    public void shouldWork_getAllAt() {
        assertEquals(Arrays.asList(Element.ONE), board.getAllAt(0, 0));
        assertEquals(Arrays.asList(Element.TWO), board.getAllAt(2, 1));
        assertEquals(Arrays.asList(Element.THREE), board.getAllAt(2, 2));
    }

    @Test
    public void shouldWork_getAt() {
        assertEquals(Element.ONE, board.getAt(0, 0));
        assertEquals(Element.TWO, board.getAt(2, 1));
        assertEquals(Element.THREE, board.getAt(2, 2));
    }

    @Test
    public void shouldWork_isAt() {
        assertEquals(true, board.isAt(0, 0, Element.ONE));
        assertEquals(false, board.isAt(1, 1, Element.ONE));
        assertEquals(false, board.isAt(2, 2, Element.ONE));

        assertEquals(true, board.isAt(1, 1, Element.TWO, Element.THREE));
        assertEquals(true, board.isAt(2, 2, Element.TWO, Element.THREE));
        assertEquals(false, board.isAt(2, 2, Element.TWO, Element.ONE));
    }

    @Test
    public void shouldWork_isNear() {
        assertEquals(true, board.isNear(1, 1, Element.ONE));
        assertEquals(false, board.isNear(5, 5, Element.TWO));
    }

    @Test
    public void shouldWork_getNear() {
        assertEquals("[1, 1, 1, 1, 3, 1, 2, 3]", board.getNear(1, 1).toString());
        assertEquals("[2, 3, 1, 2, 1, 1, 1, 1]", board.getNear(2, 2).toString());
        assertEquals("[3, 1, 1]", board.getNear(3, 3).toString());
        assertEquals("[]", board.getNear(5, 5).toString());
        assertEquals("[1]", board.getNear(-1, -1).toString());
    }

    @Test
    public void shouldWork_isOutOfField() {
        assertEquals(true, board.isOutOfField(-1, 1));
        assertEquals(true, board.isOutOfField(1, -1));
        assertEquals(true, board.isOutOfField(4, 1));
        assertEquals(true, board.isOutOfField(1, 4));

        assertEquals(false, board.isOutOfField(0, 1));
        assertEquals(false, board.isOutOfField(1, 0));
        assertEquals(false, board.isOutOfField(3, 1));
        assertEquals(false, board.isOutOfField(1, 3));
    }

    @Test
    public void shouldWork_countNear() {
        assertEquals(2, board.countNear(0, 0, Element.ONE));
        assertEquals(1, board.countNear(0, 0, Element.TWO));
        assertEquals(0, board.countNear(0, 0, Element.THREE));

        assertEquals(5, board.countNear(1, 1, Element.ONE));
        assertEquals(1, board.countNear(1, 1, Element.TWO));
        assertEquals(2, board.countNear(1, 1, Element.THREE));

        assertEquals(5, board.countNear(2, 2, Element.ONE));
        assertEquals(2, board.countNear(2, 2, Element.TWO));
        assertEquals(1, board.countNear(2, 2, Element.THREE));

        assertEquals(2, board.countNear(3, 3, Element.ONE));
        assertEquals(0, board.countNear(3, 3, Element.TWO));
        assertEquals(1, board.countNear(3, 3, Element.THREE));

        assertEquals(0, board.countNear(-1, -1, Element.THREE));
    }

    @Test
    public void shouldWork_oneElement_get() {
        assertEquals("[[0,0], [0,1], [0,2], [0,3], [1,0], [1,3], " +
                        "[2,0], [2,3], [3,0], [3,1], [3,2], [3,3]]",
                board.get(Element.ONE).toString());

        assertEquals("[[1,1], [2,1]]",
                board.get(Element.TWO).toString());

        assertEquals("[[1,2], [2,2]]",
                board.get(Element.THREE).toString());
    }

    @Test
    public void shouldWork_severalElements_get() {
        assertEquals("[[0,0], [0,1], [0,2], [0,3], [1,0], [1,1], [1,2], " +
                        "[1,3], [2,0], [2,1], [2,2], [2,3], [3,0], [3,1], " +
                        "[3,2], [3,3]]",
                board.get(Element.ONE, Element.TWO, Element.THREE).toString());
    }

    @Test
    public void shouldWork_oneElement_getFirst() {
        assertEquals("[0,0]",
                board.getFirst(Element.ONE).toString());

        assertEquals("[1,1]",
                board.getFirst(Element.TWO).toString());

        assertEquals("[1,2]",
                board.getFirst(Element.THREE).toString());
    }

    @Test
    public void shouldWork_severalElements_getFirst() {
        assertEquals("[0,0]",
                board.getFirst(Element.ONE, Element.TWO, Element.THREE).toString());
    }

    @Test
    public void shouldWork_size() {
        assertEquals(4, board.size());
    }

    @Test
    public void shouldWork_set() {
        // given
        assertEquals("[[1,2], [2,2]]",
                board.get(Element.THREE).toString());

        // when
        board.set(1, 1, Element.THREE.ch());

        // then
        assertEquals("[[1,1], [1,2], [2,2]]",
                board.get(Element.THREE).toString());
    }

    @Test
    public void getBoardAsString() {
        assertEquals(
                "1111\n" +
                "1221\n" +
                "1331\n" +
                "1111\n", board.boardAsString());
    }

    @Test
    public void shouldWorks_countLayers() {
        assertEquals(1, board.countLayers());
    }

}
