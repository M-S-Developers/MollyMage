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

import com.codenjoy.dojo.services.Direction;

import java.util.function.Function;

import static com.codenjoy.dojo.services.Direction.*;

public class Command {

    public static final String NONE = "";

    public static final Function<Direction, String> MOVE = Direction::toString;
    public static final String MOVE_LEFT = MOVE.apply(LEFT);
    public static final String MOVE_RIGHT = MOVE.apply(RIGHT);
    public static final String MOVE_UP = MOVE.apply(UP);
    public static final String MOVE_DOWN = MOVE.apply(DOWN);

    public static final Function<Direction, String> CURE_AT = d -> d.ACT(true);
    public static final String CURE_LEFT = CURE_AT.apply(LEFT);
    public static final String CURE_RIGHT = CURE_AT.apply(RIGHT);
    public static final String CURE_UP = CURE_AT.apply(UP);
    public static final String CURE_DOWN = CURE_AT.apply(DOWN);
}
