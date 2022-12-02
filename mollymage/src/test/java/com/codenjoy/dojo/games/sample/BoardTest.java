package com.codenjoy.dojo.games.sample;

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

import static com.codenjoy.dojo.services.PointImpl.pt;
import static org.junit.Assert.assertEquals;

public class BoardTest {

    private Board board;

    public static Board board(String boardString) {
        return (Board)new Board().forString(boardString);
    }
    
    @Before
    public void setup() {
         board = board(
            /*6*/"☼☼☼☼☼☼☼\n" +
            /*5*/"☼  x ♥☼\n" +
            /*4*/"☼ $  Z☼\n" +
            /*3*/"☼X   Y☼\n" +
            /*2*/"☼ ☺ $ ☼\n" +
            /*1*/"☼  ☻  ☼\n" +
            /*0*/"☼☼☼☼☼☼☼\n");
                /*0123456*/
    }

    @Test
    public void shouldToString() {
        assertBoard(
                "☼☼☼☼☼☼☼\n" +
                "☼  x ♥☼\n" +
                "☼ $  Z☼\n" +
                "☼X   Y☼\n" +
                "☼ ☺ $ ☼\n" +
                "☼  ☻  ☼\n" +
                "☼☼☼☼☼☼☼\n" +
                "\n" +
                "Hero at: [1,3]\n" +
                "Other heroes at: [[3,1], [5,3]]\n" +
                "Bombs at: [[3,5]]\n" +
                "Gold at: [[2,4], [4,2]]\n");
    }

    private void assertBoard(String expected) {
        assertEquals(expected, board.toString());
    }

    @Test
    public void shouldWork_getElement() {
        assertEquals("{ =[[1,1], [1,2], [1,4], [1,5], [2,1], [2,3], [2,5], [3,2], [3,3], [3,4], [4,1], [4,3], [4,4], [4,5], [5,1], [5,2]], \n" +
                        "☼=[[0,0], [0,1], [0,2], [0,3], [0,4], [0,5], [0,6], [1,0], [1,6], [2,0], [2,6], [3,0], [3,6], [4,0], [4,6], [5,0], [5,6], [6,0], [6,1], [6,2], [6,3], [6,4], [6,5], [6,6]], \n" +
                        "☺=[[2,2]], \n" +
                        "X=[[1,3]], \n" +
                        "☻=[[3,1]], \n" +
                        "Y=[[5,3]], \n" +
                        "♥=[[5,5]], \n" +
                        "Z=[[5,4]], \n" +
                        "$=[[2,4], [4,2]], \n" +
                        "x=[[3,5]]}",
                Utils.elements(board, Element.values()));
    }

    @Test
    public void shouldWork_getAt() {
        assertEquals(Element.WALL, board.getAt(0, 0));
        assertEquals(Element.HERO, board.getAt(2, 2));
        assertEquals(Element.OTHER_HERO, board.getAt(3, 1));
        assertEquals(Element.HERO_DEAD, board.getAt(1, 3));
        assertEquals(Element.OTHER_HERO_DEAD, board.getAt(5, 3));
        assertEquals(Element.GOLD, board.getAt(2, 4));
        assertEquals(Element.GOLD, board.getAt(4, 2));
        assertEquals(Element.BOMB, board.getAt(3, 5));
        assertEquals(Element.NONE, board.getAt(1, 1));
    }

    @Test
    public void shouldWork_getAt_point() {
        assertEquals(Element.WALL, board.getAt(pt(0, 0)));
        assertEquals(Element.HERO, board.getAt(pt(2, 2)));
        assertEquals(Element.OTHER_HERO, board.getAt(pt(3, 1)));
        assertEquals(Element.HERO_DEAD, board.getAt(pt(1, 3)));
        assertEquals(Element.OTHER_HERO_DEAD, board.getAt(pt(5, 3)));
        assertEquals(Element.GOLD, board.getAt(pt(2, 4)));
        assertEquals(Element.GOLD, board.getAt(pt(4, 2)));
        assertEquals(Element.BOMB, board.getAt(pt(3, 5)));
        assertEquals(Element.NONE, board.getAt(pt(1, 1)));
    }

    @Test
    public void shouldWork_getNear() {
        assertEquals("[ ,  ,  , $,  ,  , Y, Z]", board.getNear(4, 3).toString());
        assertEquals("[☼, ☼,  ,  , ☼]", board.getNear(0, 5).toString());
        assertEquals("[☻,  ,  ,  ,  ,  ,  , Y]", board.getNear(4, 2).toString());
    }

    @Test
    public void shouldWork_getNearPoint() {
        assertEquals("[ ,  ,  , $,  ,  , Y, Z]", board.getNear(pt(4, 3)).toString());
        assertEquals("[☼, ☼,  ,  , ☼]", board.getNear(pt(0, 5)).toString());
        assertEquals("[☻,  ,  ,  ,  ,  ,  , Y]", board.getNear(pt(4, 2)).toString());
    }

    @Test
    public void shouldWork_getAt_outOfBoard() {
        assertEquals(Element.WALL, board.getAt(-1, 1));
        assertEquals(Element.WALL, board.getAt(1, -1));
        assertEquals(Element.WALL, board.getAt(100, 1));
        assertEquals(Element.WALL, board.getAt(1, 100));

        assertEquals(Element.WALL, board.getAt(pt(-1, 1)));
        assertEquals(Element.WALL, board.getAt(pt(1, -1)));
        assertEquals(Element.WALL, board.getAt(pt(100, 1)));
        assertEquals(Element.WALL, board.getAt(pt(1, 100)));
    }

    @Test
    public void shouldWork_getOtherHeroes() {
        assertEquals("[[3,1], [5,3]]",
                board.getOtherHeroes().toString());
    }

    @Test
    public void shouldWork_isOtherHeroAt_point() {
        assertEquals(true, board.isOtherHeroAt(pt(3, 1)));
        assertEquals(false, board.isOtherHeroAt(pt(3, 2)));

        assertEquals(true, board("Y").isOtherHeroAt(pt(0, 0)));

        assertEquals(false, board("☺").isOtherHeroAt(pt(0, 0)));
        assertEquals(false, board("X").isOtherHeroAt(pt(0, 0)));
        assertEquals(false, board("x").isOtherHeroAt(pt(0, 0)));
    }

    @Test
    public void shouldWork_getBarriers() {
        assertEquals("[[0,0], [0,1], [0,2], [0,3], [0,4], [0,5], [0,6], " +
                        "[1,0], [1,6], [2,0], [2,6], [3,0], [3,1], [3,5], " +
                        "[3,6], [4,0], [4,6], [5,0], [5,3], [5,6], [6,0], " +
                        "[6,1], [6,2], [6,3], [6,4], [6,5], [6,6]]",
                board.getBarriers().toString());
    }

    @Test
    public void shouldWork_isBarrierAt_point() {
        assertEquals(false, board.isBarrierAt(pt(-1, -1)));
        assertEquals(true, board.isBarrierAt(pt(0, 0)));
        assertEquals(false, board.isBarrierAt(pt(5, 1)));
    }

    @Test
    public void shouldWork_getHero() {
        assertEquals("[1,3]", board.getHero().toString());
        assertEquals("[0,0]", board("X").getHero().toString());
        assertEquals(null, board("☻").getHero());
        assertEquals(null, board("Y").getHero());
    }

    @Test
    public void shouldWork_isHeroAt_point() {
        assertEquals(true, board.isHeroAt(pt(1, 3)));
        assertEquals(false, board.isHeroAt(pt(1, 4)));

        assertEquals(true, board("X").isHeroAt(pt(0, 0)));

        assertEquals(false, board("☻").isHeroAt(pt(0, 0)));
        assertEquals(false, board("Y").isHeroAt(pt(0, 0)));
        assertEquals(false, board("x").isHeroAt(pt(0, 0)));
    }

    @Test
    public void shouldWork_getBombs() {
        assertEquals("[[3,5]]",
                board.getBombs().toString());
    }

    @Test
    public void shouldWork_isBombAt_point() {
        assertEquals(true, board.isBombAt(pt(3, 5)));
        assertEquals(false, board.isBombAt(pt(3, 6)));
    }

    @Test
    public void shouldWork_getGold() {
        assertEquals("[[2,4], [4,2]]",
                board.getGold().toString());
    }

    @Test
    public void shouldWork_isGoldAt_point() {
        assertEquals(true, board.isGoldAt(pt(2, 4)));
        assertEquals(false, board.isGoldAt(pt(2, 5)));
    }

    @Test
    public void shouldWork_countNear() {
        assertEquals(0, board.countNear(0, 0, Element.BOMB));
        assertEquals(1, board.countNear(3, 4, Element.BOMB));
        assertEquals(1, board.countNear(1, 4, Element.GOLD));

        assertEquals(3, board.countNear(1, 6, Element.WALL));
        assertEquals(5, board.countNear(1, 1, Element.WALL));
        assertEquals(2, board.countNear(6, 6, Element.WALL));
        assertEquals(3, board.countNear(6, 1, Element.WALL));
        assertEquals(5, board.countNear(1, 5, Element.WALL));
    }

    @Test
    public void shouldWork_countNear_point() {
        assertEquals(0, board.countNear(pt(0, 0), Element.BOMB));
        assertEquals(1, board.countNear(pt(3, 4), Element.BOMB));
        assertEquals(1, board.countNear(pt(1, 4), Element.GOLD));

        assertEquals(3, board.countNear(pt(1, 6), Element.WALL));
        assertEquals(5, board.countNear(pt(1, 1), Element.WALL));
        assertEquals(2, board.countNear(pt(6, 6), Element.WALL));
        assertEquals(3, board.countNear(pt(6, 1), Element.WALL));
        assertEquals(5, board.countNear(pt(1, 5), Element.WALL));
    }

    @Test
    public void shouldWork_isAt() {
        assertEquals(true, board.isAt(3, 5, Element.BOMB));
        assertEquals(false, board.isAt(3, 4, Element.BOMB));

        assertEquals(true, board.isAt(4, 2, Element.WALL, Element.GOLD));
        assertEquals(false, board.isAt(4, 1, Element.WALL, Element.GOLD));
    }

    @Test
    public void shouldWork_isAt_point() {
        assertEquals(true, board.isAt(pt(3, 5), Element.BOMB));
        assertEquals(false, board.isAt(pt(3, 4), Element.BOMB));

        assertEquals(true, board.isAt(pt(4, 2), Element.WALL, Element.GOLD));
        assertEquals(false, board.isAt(pt(4, 1), Element.WALL, Element.GOLD));
    }

    @Test
    public void shouldWork_isNear() {
        assertEquals(true, board.isNear(1, 1, Element.WALL));
        assertEquals(false, board.isNear(4, 4, Element.WALL));
    }

    @Test
    public void shouldWork_isNear_point() {
        assertEquals(true, board.isNear(pt(1, 1), Element.WALL));
        assertEquals(false, board.isNear(pt(4, 4), Element.WALL));
    }

    @Test
    public void shouldWork_getWalls() {
        assertEquals("[[0,0], [0,1], [0,2], [0,3], [0,4], [0,5], [0,6], " +
                        "[1,0], [1,6], [2,0], [2,6], [3,0], [3,6], [4,0], " +
                        "[4,6], [5,0], [5,6], [6,0], [6,1], [6,2], [6,3], " +
                        "[6,4], [6,5], [6,6]]",
                board.getWalls().toString());
    }

    @Test
    public void shouldWork_isWallAt_point() {
        assertEquals(true, board.isWallAt(pt(2, 0)));
        assertEquals(false, board.isWallAt(pt(2, 1)));
    }

    @Test
    public void shouldWork_isGameOver() {
        assertEquals(true, board.isGameOver());
        assertEquals(false, board(" ").isGameOver());
    }
}