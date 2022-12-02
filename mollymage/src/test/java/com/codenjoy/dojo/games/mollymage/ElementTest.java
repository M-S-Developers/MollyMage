package com.codenjoy.dojo.games.mollymage;

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
        assertEquals("BLAST[҉]                 =blast\n" +
                    "ENEMY_HERO[ö]            =enemyHero\n" +
                    "ENEMY_HERO_DEAD[ø]       =enemyHero\n" +
                    "ENEMY_HERO_POTION[Ö]     =enemyHero, potion\n" +
                    "GHOST[&]                 =ghost\n" +
                    "GHOST_DEAD[x]            =ghost\n" +
                    "HERO[☺]                  =hero\n" +
                    "HERO_DEAD[Ѡ]             =hero\n" +
                    "HERO_POTION[☻]           =potion, hero\n" +
                    "NONE[ ]                  =\n" +
                    "OTHER_HERO[♥]            =otherHero\n" +
                    "OTHER_HERO_DEAD[♣]       =otherHero\n" +
                    "OTHER_HERO_POTION[♠]     =potion, otherHero\n" +
                    "POISON_THROWER[T]        =perk\n" +
                    "POTION_BLAST_RADIUS_INCREASE[+]=perk\n" +
                    "POTION_COUNT_INCREASE[c] =perk\n" +
                    "POTION_EXPLODER[A]       =perk\n" +
                    "POTION_IMMUNE[i]         =perk\n" +
                    "POTION_REMOTE_CONTROL[r] =perk\n" +
                    "POTION_TIMER_1[1]        =potion\n" +
                    "POTION_TIMER_2[2]        =potion\n" +
                    "POTION_TIMER_3[3]        =potion\n" +
                    "POTION_TIMER_4[4]        =potion\n" +
                    "POTION_TIMER_5[5]        =potion\n" +
                    "TREASURE_BOX[#]          =treasureBox\n" +
                    "TREASURE_BOX_OPENING[H]  =treasureBox\n" +
                    "WALL[☼]                  =wall",
                Utils.elements(Element.values()));
    }
}