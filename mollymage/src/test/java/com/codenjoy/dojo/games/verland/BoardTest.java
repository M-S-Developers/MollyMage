package com.codenjoy.dojo.games.verland;

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

import static com.codenjoy.dojo.games.verland.Element.*;
import static com.codenjoy.dojo.services.PointImpl.pt;
import static org.junit.Assert.assertEquals;

public class BoardTest {

    private Board board;

    public static Board board(String boardString) {
        return (Board)new Board().forString(boardString);
    }

    @Before
    public void before() {
        board = board(
                "☼☼☼☼☼☼☼☼☼" +
                "☼1 Y   y☼" +
                "☼*2  x  ☼" +
                "☼o 3 ♠ +☼" +
                "☼♥  4   ☼" +
                "☼   Z  ♣☼" +
                "☼z  5678☼" +
                "☼  !  X ☼" +
                "☼☼☼☼☼☼☼☼☼");
    }

    @Test
    public void shouldWorkToString() {
        assertEquals(
           /*8*/"☼☼☼☼☼☼☼☼☼\n" +
           /*7*/"☼1 Y   y☼\n" +
           /*6*/"☼*2  x  ☼\n" +
           /*5*/"☼o 3 ♠ +☼\n" +
           /*4*/"☼♥  4   ☼\n" +
           /*3*/"☼   Z  ♣☼\n" +
           /*2*/"☼z  5678☼\n" +
           /*1*/"☼  !  X ☼\n" +
           /*0*/"☼☼☼☼☼☼☼☼☼\n" +
               /*012345678*/
                "\n" +
                "Hero at: [1,4]\n" +
                "Other heroes at: [[3,7], [5,5]]\n" +
                "Enemy heroes at: [[4,3], [7,3]]\n" +
                "Contagions at: [[1,7], [2,6], [3,5], [4,2], " +
                                "[4,4], [5,2], [6,2], [7,2]]\n", board.toString());
    }

    @Test
    public void shouldWork_getAt() {
        assertEquals(HERO, board.getAt(1, 4));
        assertEquals(OTHER_HERO_HEALING, board.getAt(7, 7));
    }

    @Test
    public void shouldWork_getAt_point() {
        assertEquals(HERO, board.getAt(pt(1, 4)));
        assertEquals(OTHER_HERO_HEALING, board.getAt(pt(7, 7)));
    }

    @Test
    public void shouldWork_getNear() {
        assertEquals("[7,  ,  , 8,  , ☼, ☼, ☼]", board.getNear(7, 3).toString());
        assertEquals("[☼, 1, ☼]", board.getNear(0, 8).toString());
        assertEquals("[ ,  ,  , ♠,  ,  ,  ,  ]", board.getNear(5, 6).toString());
    }

    @Test
    public void shouldWork_getNear_point() {
        assertEquals("[7,  ,  , 8,  , ☼, ☼, ☼]", board.getNear(pt(7, 3)).toString());
        assertEquals("[☼, 1, ☼]", board.getNear(pt(0, 8)).toString());
        assertEquals("[ ,  ,  , ♠,  ,  ,  ,  ]", board.getNear(pt(5, 6)).toString());
    }

    @Test
    public void shouldWork_getAt_outOfBoard() {
        assertEquals(PATHLESS, board.getAt(-1, 1));
        assertEquals(PATHLESS, board.getAt(1, -1));
        assertEquals(PATHLESS, board.getAt(100, 1));
        assertEquals(PATHLESS, board.getAt(1, 100));

        assertEquals(PATHLESS, board.getAt(pt(-1, 1)));
        assertEquals(PATHLESS, board.getAt(pt(1, -1)));
        assertEquals(PATHLESS, board.getAt(pt(100, 1)));
        assertEquals(PATHLESS, board.getAt(pt(1, 100)));
    }

    @Test
    public void shouldWork_getOtherHeroes() {
        assertEquals("[[3,7], [5,5]]", board.getOtherHeroes().toString());
    }

    @Test
    public void shouldWork_getEnemyHeroes() {
        assertEquals("[[4,3], [7,3]]", board.getEnemyHeroes().toString());
    }

    @Test
    public void shouldWork_getHero() {
        assertEquals("[1,4]", board.getHero().toString());
    }

    @Test
    public void shouldWork_countNear() {
        assertEquals(1, board.countNear(2, 5, INFECTION));
        assertEquals(1, board.countNear(5, 3, ENEMY_HERO_DEAD));
        assertEquals(1, board.countNear(2, 7, OTHER_HERO_DEAD));

        assertEquals(5, board.countNear(1, 7, PATHLESS));
        assertEquals(5, board.countNear(1, 1, PATHLESS));
        assertEquals(5, board.countNear(7, 7, PATHLESS));
        assertEquals(5, board.countNear(7, 1, PATHLESS));
        assertEquals(3, board.countNear(1, 6, PATHLESS));
    }

    @Test
    public void shouldWork_countNear_point() {
        assertEquals(1, board.countNear(pt(2, 5), INFECTION));
        assertEquals(1, board.countNear(pt(5, 3), ENEMY_HERO_DEAD));
        assertEquals(1, board.countNear(pt(2, 7), OTHER_HERO_DEAD));

        assertEquals(5, board.countNear(pt(1, 7), PATHLESS));
        assertEquals(5, board.countNear(pt(1, 1), PATHLESS));
        assertEquals(5, board.countNear(pt(7, 7), PATHLESS));
        assertEquals(5, board.countNear(pt(7, 1), PATHLESS));
        assertEquals(3, board.countNear(pt(1, 6), PATHLESS));
    }

    @Test
    public void shouldWork_isAt() {
        assertEquals(true, board.isAt(1, 5, INFECTION));
        assertEquals(false, board.isAt(2, 1, INFECTION));

        assertEquals(true, board.isAt(1, 5, OTHER_HERO_DEAD, INFECTION));
        assertEquals(false, board.isAt(2, 1, INFECTION, OTHER_HERO_DEAD));
    }

    @Test
    public void shouldWork_isAt_point() {
        assertEquals(true, board.isAt(pt(1, 5), INFECTION));
        assertEquals(false, board.isAt(pt(2, 1), INFECTION));

        assertEquals(true, board.isAt(pt(1, 5), OTHER_HERO_DEAD, INFECTION));
        assertEquals(false, board.isAt(pt(2, 1), INFECTION, OTHER_HERO_DEAD));
    }

    @Test
    public void shouldWork_isNear() {
        assertEquals(true, board.isNear(1, 1, PATHLESS));
        assertEquals(false, board.isNear(1, 7, OTHER_HERO_DEAD));
    }

    @Test
    public void shouldWork_isNear_point() {
        assertEquals(true, board.isNear(pt(1, 1), PATHLESS));
        assertEquals(false, board.isNear(pt(1, 7), OTHER_HERO_DEAD));
    }

    @Test
    public void shouldWork_getWalls() {
        assertEquals("[[0,0], [0,1], [0,2], [0,3], [0,4], [0,5], [0,6], [0,7], [0,8], " +
                "[1,0], [1,8], [2,0], [2,8], [3,0], [3,8], [4,0], [4,8], [5,0], [5,8], " +
                "[6,0], [6,8], [7,0], [7,8], [8,0], [8,1], [8,2], [8,3], [8,4], [8,5], " +
                "[8,6], [8,7], [8,8]]", board.getPathless().toString());
    }

    @Test
    public void shouldWork_isGameOver() {
        assertEquals(true, board.isGameOver());
        assertEquals(false, board("♥").isGameOver());
    }

    @Test
    public void shouldWork_IsHeroAt() {
        assertEquals(true, board.isHeroAt(pt(1, 4)));;
    }

    @Test
    public void shouldWork_IsOtherHeroAt() {
        assertEquals(true, board.isOtherHeroAt(pt(3, 7)));;
    }

    @Test
    public void shouldWork_IsEnemyHeroAt() {
        assertEquals(true, board.isEnemyHeroAt(pt(4, 3)));;
    }

    @Test
    public void shouldWork_CountContagions() {
        assertEquals(board.countContagions(pt(1, 7)), 1);
        assertEquals(board.countContagions(pt(2, 6)), 2);
        assertEquals(board.countContagions(pt(3, 5)), 3);
        assertEquals(board.countContagions(pt(4, 4)), 4);
    }

    @Test
    public void shouldWork_IsWin() {
        assertEquals(false, board.isWin());
        assertEquals(false, board("♥").isWin());
        assertEquals(true, board("x").isWin());
    }
}