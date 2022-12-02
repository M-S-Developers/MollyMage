package com.codenjoy.dojo.games.clifford;

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

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;
import static org.apache.commons.lang3.StringUtils.rightPad;
import static org.junit.Assert.assertEquals;

public class ElementTest {

    @Test
    public void testElementProperties() {
        assertEquals("BACKWAY[W]               =backWay\n" +
                    "BRICK[#]                 =wall\n" +
                    "BULLET[•]                =bullet\n" +
                    "CLOSED_DOOR_BRONZE[B]    =door\n" +
                    "CLOSED_DOOR_GOLD[G]      =door\n" +
                    "CLOSED_DOOR_SILVER[S]    =door\n" +
                    "CLUE_GLOVE[&]            =clue\n" +
                    "CLUE_KNIFE[$]            =clue\n" +
                    "CLUE_RING[@]             =clue\n" +
                    "CRACK_PIT[*]             =pit\n" +
                    "ENEMY_HERO_DIE[L]        =enemyHero\n" +
                    "ENEMY_HERO_FALL[R]       =enemyHero\n" +
                    "ENEMY_HERO_LADDER[N]     =enemyHero, ladder\n" +
                    "ENEMY_HERO_LEFT[P]       =enemyHero\n" +
                    "ENEMY_HERO_MASK_DIE[l]   =enemyHero\n" +
                    "ENEMY_HERO_MASK_FALL[r]  =enemyHero\n" +
                    "ENEMY_HERO_MASK_LADDER[n]=enemyHero, ladder\n" +
                    "ENEMY_HERO_MASK_LEFT[p]  =enemyHero\n" +
                    "ENEMY_HERO_MASK_PIPE[t]  =enemyHero, pipe\n" +
                    "ENEMY_HERO_MASK_PIT[v]   =enemyHero, pit\n" +
                    "ENEMY_HERO_MASK_RIGHT[q] =enemyHero\n" +
                    "ENEMY_HERO_PIPE[T]       =enemyHero, pipe\n" +
                    "ENEMY_HERO_PIT[V]        =enemyHero, pit\n" +
                    "ENEMY_HERO_RIGHT[Q]      =enemyHero\n" +
                    "HERO_DIE[O]              =hero\n" +
                    "HERO_FALL[U]             =hero\n" +
                    "HERO_LADDER[A]           =hero, ladder\n" +
                    "HERO_LEFT[◄]             =hero\n" +
                    "HERO_MASK_DIE[o]         =hero\n" +
                    "HERO_MASK_FALL[u]        =hero\n" +
                    "HERO_MASK_LADDER[a]      =hero, ladder\n" +
                    "HERO_MASK_LEFT[h]        =hero\n" +
                    "HERO_MASK_PIPE[i]        =hero, pipe\n" +
                    "HERO_MASK_PIT[e]         =hero, pit\n" +
                    "HERO_MASK_RIGHT[w]       =hero\n" +
                    "HERO_PIPE[I]             =hero, pipe\n" +
                    "HERO_PIT[E]              =hero, pit\n" +
                    "HERO_RIGHT[►]            =hero\n" +
                    "KEY_BRONZE[!]            =key\n" +
                    "KEY_GOLD[+]              =key\n" +
                    "KEY_SILVER[-]            =key\n" +
                    "LADDER[H]                =ladder\n" +
                    "MASK_POTION[m]           =maskPotion\n" +
                    "NONE[ ]                  =\n" +
                    "OPENED_DOOR_BRONZE[b]    =door\n" +
                    "OPENED_DOOR_GOLD[g]      =door\n" +
                    "OPENED_DOOR_SILVER[s]    =door\n" +
                    "OTHER_HERO_DIE[C]        =otherHero\n" +
                    "OTHER_HERO_FALL[F]       =otherHero\n" +
                    "OTHER_HERO_LADDER[D]     =ladder, otherHero\n" +
                    "OTHER_HERO_LEFT[«]       =otherHero\n" +
                    "OTHER_HERO_MASK_DIE[c]   =otherHero\n" +
                    "OTHER_HERO_MASK_FALL[f]  =otherHero\n" +
                    "OTHER_HERO_MASK_LADDER[d]=ladder, otherHero\n" +
                    "OTHER_HERO_MASK_LEFT[Z]  =otherHero\n" +
                    "OTHER_HERO_MASK_PIPE[j]  =otherHero, pipe\n" +
                    "OTHER_HERO_MASK_PIT[k]   =otherHero, pit\n" +
                    "OTHER_HERO_MASK_RIGHT[z] =otherHero\n" +
                    "OTHER_HERO_PIPE[J]       =otherHero, pipe\n" +
                    "OTHER_HERO_PIT[K]        =otherHero, pit\n" +
                    "OTHER_HERO_RIGHT[»]      =otherHero\n" +
                    "PIPE[~]                  =pipe\n" +
                    "PIT_FILL_1[1]            =pit\n" +
                    "PIT_FILL_2[2]            =pit\n" +
                    "PIT_FILL_3[3]            =pit\n" +
                    "PIT_FILL_4[4]            =pit\n" +
                    "ROBBER_FALL[x]           =robber\n" +
                    "ROBBER_LADDER[X]         =ladder, robber\n" +
                    "ROBBER_LEFT[)]           =robber\n" +
                    "ROBBER_PIPE[Y]           =robber, pipe\n" +
                    "ROBBER_PIT[y]            =robber, pit\n" +
                    "ROBBER_RIGHT[(]          =robber\n" +
                    "STONE[☼]                 =wall",
                Utils.elements(Element.values()));
    }

    @Test
    public void testGetMask() {
        assertEquals("HERO_DIE            =HERO_MASK_DIE\n" +
                    "HERO_LADDER         =HERO_MASK_LADDER\n" +
                    "HERO_LEFT           =HERO_MASK_LEFT\n" +
                    "HERO_RIGHT          =HERO_MASK_RIGHT\n" +
                    "HERO_FALL           =HERO_MASK_FALL\n" +
                    "HERO_PIPE           =HERO_MASK_PIPE\n" +
                    "HERO_PIT            =HERO_MASK_PIT\n" +
                    "OTHER_HERO_DIE      =OTHER_HERO_MASK_DIE\n" +
                    "OTHER_HERO_LADDER   =OTHER_HERO_MASK_LADDER\n" +
                    "OTHER_HERO_LEFT     =OTHER_HERO_MASK_LEFT\n" +
                    "OTHER_HERO_RIGHT    =OTHER_HERO_MASK_RIGHT\n" +
                    "OTHER_HERO_FALL     =OTHER_HERO_MASK_FALL\n" +
                    "OTHER_HERO_PIPE     =OTHER_HERO_MASK_PIPE\n" +
                    "OTHER_HERO_PIT      =OTHER_HERO_MASK_PIT\n" +
                    "ENEMY_HERO_DIE      =ENEMY_HERO_MASK_DIE\n" +
                    "ENEMY_HERO_LADDER   =ENEMY_HERO_MASK_LADDER\n" +
                    "ENEMY_HERO_LEFT     =ENEMY_HERO_MASK_LEFT\n" +
                    "ENEMY_HERO_RIGHT    =ENEMY_HERO_MASK_RIGHT\n" +
                    "ENEMY_HERO_FALL     =ENEMY_HERO_MASK_FALL\n" +
                    "ENEMY_HERO_PIPE     =ENEMY_HERO_MASK_PIPE\n" +
                    "ENEMY_HERO_PIT      =ENEMY_HERO_MASK_PIT",
                toString(Element::mask));
    }

    @Test
    public void testGetOtherHero() {
        assertEquals("HERO_DIE            =OTHER_HERO_DIE\n" +
                    "HERO_LADDER         =OTHER_HERO_LADDER\n" +
                    "HERO_LEFT           =OTHER_HERO_LEFT\n" +
                    "HERO_RIGHT          =OTHER_HERO_RIGHT\n" +
                    "HERO_FALL           =OTHER_HERO_FALL\n" +
                    "HERO_PIPE           =OTHER_HERO_PIPE\n" +
                    "HERO_PIT            =OTHER_HERO_PIT\n" +
                    "HERO_MASK_DIE       =OTHER_HERO_MASK_DIE\n" +
                    "HERO_MASK_LADDER    =OTHER_HERO_MASK_LADDER\n" +
                    "HERO_MASK_LEFT      =OTHER_HERO_MASK_LEFT\n" +
                    "HERO_MASK_RIGHT     =OTHER_HERO_MASK_RIGHT\n" +
                    "HERO_MASK_FALL      =OTHER_HERO_MASK_FALL\n" +
                    "HERO_MASK_PIPE      =OTHER_HERO_MASK_PIPE\n" +
                    "HERO_MASK_PIT       =OTHER_HERO_MASK_PIT",
                toString(Element::otherHero));
    }

    @Test
    public void testGetEnemyHero() {
        assertEquals("HERO_DIE            =ENEMY_HERO_DIE\n" +
                        "HERO_LADDER         =ENEMY_HERO_LADDER\n" +
                        "HERO_LEFT           =ENEMY_HERO_LEFT\n" +
                        "HERO_RIGHT          =ENEMY_HERO_RIGHT\n" +
                        "HERO_FALL           =ENEMY_HERO_FALL\n" +
                        "HERO_PIPE           =ENEMY_HERO_PIPE\n" +
                        "HERO_PIT            =ENEMY_HERO_PIT\n" +
                        "HERO_MASK_DIE       =ENEMY_HERO_MASK_DIE\n" +
                        "HERO_MASK_LADDER    =ENEMY_HERO_MASK_LADDER\n" +
                        "HERO_MASK_LEFT      =ENEMY_HERO_MASK_LEFT\n" +
                        "HERO_MASK_RIGHT     =ENEMY_HERO_MASK_RIGHT\n" +
                        "HERO_MASK_FALL      =ENEMY_HERO_MASK_FALL\n" +
                        "HERO_MASK_PIPE      =ENEMY_HERO_MASK_PIPE\n" +
                        "HERO_MASK_PIT       =ENEMY_HERO_PIT",
                toString(Element::enemyHero));
    }

    private String toString(Function<Element, Element> transformer) {
        return allElements(transformer)
                .toString()
                .replace(", ", "\n")
                .replaceAll("[{}]", "");
    }

    private LinkedHashMap<String, String> allElements(Function<Element, Element> transformer) {
        return Arrays.stream(Element.values())
                .map(element -> {
                    try {
                        return new AbstractMap.SimpleEntry<>(
                                rightPad(element.name(), 20),
                                transformer.apply(element).name());
                    } catch (IllegalArgumentException exception) {
                        return null;
                    }
                })
                .filter(entry -> entry != null)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (value1, value2) -> value2,
                        LinkedHashMap::new));
    }
}