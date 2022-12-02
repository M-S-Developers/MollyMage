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

        assertEquals("ACT,LEFT",  Command.CRACK_AT.apply(LEFT));
        assertEquals("ACT,RIGHT", Command.CRACK_AT.apply(RIGHT));

        assertEquals("ACT,LEFT",  Command.CRACK_LEFT);
        assertEquals("ACT,RIGHT", Command.CRACK_RIGHT);

        assertEquals("ACT(1),LEFT",  Command.SHOOT_AT.apply(LEFT));
        assertEquals("ACT(1),RIGHT", Command.SHOOT_AT.apply(RIGHT));

        assertEquals("ACT(1),LEFT",  Command.SHOOT_LEFT);
        assertEquals("ACT(1),RIGHT", Command.SHOOT_RIGHT);

        assertEquals("ACT(2),LEFT",  Command.OPEN_DOOR_AT.apply(LEFT));
        assertEquals("ACT(2),RIGHT", Command.OPEN_DOOR_AT.apply(RIGHT));

        assertEquals("ACT(2),LEFT",  Command.OPEN_DOOR_LEFT);
        assertEquals("ACT(2),RIGHT", Command.OPEN_DOOR_RIGHT);

        assertEquals("ACT(3),LEFT",  Command.CLOSE_DOOR_AT.apply(LEFT));
        assertEquals("ACT(3),RIGHT", Command.CLOSE_DOOR_AT.apply(RIGHT));

        assertEquals("ACT(3),LEFT",  Command.CLOSE_DOOR_LEFT);
        assertEquals("ACT(3),RIGHT", Command.CLOSE_DOOR_RIGHT);
    }
}