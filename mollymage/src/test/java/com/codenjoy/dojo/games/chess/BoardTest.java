package com.codenjoy.dojo.games.chess;

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
import com.codenjoy.dojo.services.Point;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.codenjoy.dojo.services.PointImpl.pt;
import static org.junit.Assert.assertEquals;

public class BoardTest {

    protected Board board;

    @Test
    public void shouldWork_getAt() {

        // when
        given(classicFFABoard());

        // then
        assertEquals(Element.BARRIER, board.getAt(0, 0));
        assertEquals(Element.WHITE_ROOK, board.getAt(3, 0));
        assertEquals(Element.SQUARE, board.getAt(3, 3));
        assertEquals(Element.WHITE_PAWN, board.getAt(3, 1));
    }

    @Test
    public void shouldWork_getBarriers() {

        // when
        given(classicFFABoard());

        Set<Point> barriers = newHashSet(
                // left down corner
                pt(0, 0),
                pt(0, 1),
                pt(0, 2),
                pt(1, 0),
                pt(1, 1),
                pt(1, 2),
                pt(2, 0),
                pt(2, 1),
                pt(2, 2),
                // left up corner
                pt(0, 11),
                pt(0, 12),
                pt(0, 13),
                pt(1, 11),
                pt(1, 12),
                pt(1, 13),
                pt(2, 11),
                pt(2, 12),
                pt(2, 13),
                // right down corner
                pt(11, 0),
                pt(11, 1),
                pt(11, 2),
                pt(12, 0),
                pt(12, 1),
                pt(12, 2),
                pt(13, 0),
                pt(13, 1),
                pt(13, 2),
                // right up corner
                pt(11, 11),
                pt(11, 12),
                pt(11, 13),
                pt(12, 11),
                pt(12, 12),
                pt(12, 13),
                pt(13, 11),
                pt(13, 12),
                pt(13, 13)
        );

        // then
        assertEquals(barriers, newHashSet(board.getBarriers().toArray(new Point[0])));
    }

    private Set<Point> newHashSet(Point... points) {
        return new LinkedHashSet<>(Arrays.asList(points));
    }

    @Test
    public void shouldWork_isBarrier() {

        // when
        given(classicFFABoard());

        // then
        assertEquals(true, board.isBarrier(11, 11));
        assertEquals(true, board.isBarrier(pt(0, 0)));
    }

    @Test
    public void shouldWork_getColor() {

        // when
        given(classicFFABoard());

        // then
        assertEquals(Color.WHITE, board.getColor(5, 0));
        assertEquals(Color.BLACK, board.getColor(4, 12));
        assertEquals(Color.RED, board.getColor(pt(0, 6)));
        assertEquals(Color.BLUE, board.getColor(pt(13, 7)));
    }

    @Test
    public void shouldWork_getPieces() {

        // when
        given(classicFFABoard());

        Set<Point> whitePieces = newHashSet(
                pt(3, 0),
                pt(4, 0),
                pt(5, 0),
                pt(6, 0),
                pt(7, 0),
                pt(8, 0),
                pt(9, 0),
                pt(10, 0),
                pt(3, 1),
                pt(4, 1),
                pt(5, 1),
                pt(6, 1),
                pt(7, 1),
                pt(8, 1),
                pt(9, 1),
                pt(10, 1)
        );

        // then
        assertEquals(whitePieces, newHashSet(board.getPieces(Color.WHITE).toArray(Point[]::new)));
    }
            
    protected void given(String board) {
        String cleanBoard = Utils.clean(board);
        this.board = (Board) new Board().forString(cleanBoard);
    }

    protected String classicFFABoard() {
        return  "   rkbwqbkr   \n" +
                "   pppppppp   \n" +
                "   ........   \n" +
                "IZ..........zi\n" +
                "LZ..........zl\n" +
                "GZ..........zg\n" +
                "YZ..........zx\n" +
                "XZ..........zy\n" +
                "GZ..........zg\n" +
                "LZ..........zl\n" +
                "IZ..........zi\n" +
                "   ........   \n" +
                "   PPPPPPPP   \n" +
                "   RKBQWBKR   \n";
    }

    protected String classicBoard() {
        return  "rkbqwbkr\n" +
                "pppppppp\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "PPPPPPPP\n" +
                "RKBQWBKR\n";
    }
}