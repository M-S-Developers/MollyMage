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

import com.codenjoy.dojo.client.Utils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElementTest {

    @Test
    public void testElementProperties() {
        assertEquals("CLEAR[ ]                 =\n" +
                    "CONTAGION_EIGHT[8]       =contagions\n" +
                    "CONTAGION_FIVE[5]        =contagions\n" +
                    "CONTAGION_FOUR[4]        =contagions\n" +
                    "CONTAGION_ONE[1]         =contagions\n" +
                    "CONTAGION_SEVEN[7]       =contagions\n" +
                    "CONTAGION_SIX[6]         =contagions\n" +
                    "CONTAGION_THREE[3]       =contagions\n" +
                    "CONTAGION_TWO[2]         =contagions\n" +
                    "ENEMY_HERO[♣]            =enemyHeroes\n" +
                    "ENEMY_HERO_DEAD[Z]       =enemyHeroes\n" +
                    "ENEMY_HERO_HEALING[z]    =healing\n" +
                    "HERO[♥]                  =hero\n" +
                    "HERO_CURE[!]             =cure\n" +
                    "HERO_DEAD[X]             =hero\n" +
                    "HERO_HEALING[x]          =healing\n" +
                    "HIDDEN[*]                =hidden\n" +
                    "INFECTION[o]             =infections\n" +
                    "OTHER_HERO[♠]            =otherHero\n" +
                    "OTHER_HERO_CURE[+]       =cure\n" +
                    "OTHER_HERO_DEAD[Y]       =otherHero\n" +
                    "OTHER_HERO_HEALING[y]    =healing\n" +
                    "PATHLESS[☼]              =pathless",
                Utils.elements(Element.values()));
    }
}