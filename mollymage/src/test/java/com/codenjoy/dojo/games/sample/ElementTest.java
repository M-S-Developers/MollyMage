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
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElementTest {

    @Test
    public void testElementProperties() {
        assertEquals("BOMB[x]                  =bomb\n" +
                    "ENEMY_HERO[♥]            =\n" +
                    "ENEMY_HERO_DEAD[Z]       =\n" +
                    "GOLD[$]                  =gold\n" +
                    "HERO[☺]                  =hero\n" +
                    "HERO_DEAD[X]             =hero\n" +
                    "NONE[ ]                  =\n" +
                    "OTHER_HERO[☻]            =otherHero\n" +
                    "OTHER_HERO_DEAD[Y]       =otherHero\n" +
                    "WALL[☼]                  =wall",
                Utils.elements(Element.values()));
    }
}