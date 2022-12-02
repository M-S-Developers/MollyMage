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

import org.junit.Test;

import static com.codenjoy.dojo.services.Direction.*;
import static org.junit.Assert.assertEquals;

public class CommandTest {

    @Test
    public void test() {
        assertEquals("LEFT",  Command.MOVE.apply(LEFT));
        assertEquals("RIGHT", Command.MOVE.apply(RIGHT));
        assertEquals("UP",    Command.MOVE.apply(UP));
        assertEquals("DOWN",  Command.MOVE.apply(DOWN));
        
        assertEquals("LEFT",  Command.MOVE_LEFT);
        assertEquals("RIGHT", Command.MOVE_RIGHT);
        assertEquals("UP",    Command.MOVE_UP);
        assertEquals("DOWN",  Command.MOVE_DOWN);

        assertEquals("ACT",   Command.DROP_POTION);

        assertEquals("ACT,LEFT",  Command.DROP_POTION_THEN_MOVE.apply(LEFT));
        assertEquals("ACT,RIGHT", Command.DROP_POTION_THEN_MOVE.apply(RIGHT));
        assertEquals("ACT,UP",    Command.DROP_POTION_THEN_MOVE.apply(UP));
        assertEquals("ACT,DOWN",  Command.DROP_POTION_THEN_MOVE.apply(DOWN));

        assertEquals("LEFT,ACT",  Command.MOVE_THEN_DROP_POTION.apply(LEFT));
        assertEquals("RIGHT,ACT", Command.MOVE_THEN_DROP_POTION.apply(RIGHT));
        assertEquals("UP,ACT",    Command.MOVE_THEN_DROP_POTION.apply(UP));
        assertEquals("DOWN,ACT",  Command.MOVE_THEN_DROP_POTION.apply(DOWN));

        assertEquals("LEFT,ACT(1)",  Command.THROW_POTION_AT.apply(LEFT));
        assertEquals("RIGHT,ACT(1)", Command.THROW_POTION_AT.apply(RIGHT));
        assertEquals("UP,ACT(1)",    Command.THROW_POTION_AT.apply(UP));
        assertEquals("DOWN,ACT(1)",  Command.THROW_POTION_AT.apply(DOWN));

        assertEquals("ACT(2),LEFT",  Command.EXPLODE_POTIONS_THEN_MOVE.apply(LEFT));
        assertEquals("ACT(2),RIGHT", Command.EXPLODE_POTIONS_THEN_MOVE.apply(RIGHT));
        assertEquals("ACT(2),UP",    Command.EXPLODE_POTIONS_THEN_MOVE.apply(UP));
        assertEquals("ACT(2),DOWN",  Command.EXPLODE_POTIONS_THEN_MOVE.apply(DOWN));

        assertEquals("LEFT,ACT(2)",  Command.MOVE_THEN_EXPLODE_POTIONS.apply(LEFT));
        assertEquals("RIGHT,ACT(2)", Command.MOVE_THEN_EXPLODE_POTIONS.apply(RIGHT));
        assertEquals("UP,ACT(2)",    Command.MOVE_THEN_EXPLODE_POTIONS.apply(UP));
        assertEquals("DOWN,ACT(2)",  Command.MOVE_THEN_EXPLODE_POTIONS.apply(DOWN));
    }
}