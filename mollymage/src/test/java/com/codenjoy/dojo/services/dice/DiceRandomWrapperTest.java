package com.codenjoy.dojo.services.dice;

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

import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.dice.DiceRandomWrapper;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiceRandomWrapperTest {

    @Test
    public void test() {
        // given
        Dice dice = mock(Dice.class);
        Random random = new DiceRandomWrapper(dice);
        when(dice.next(anyInt())).thenReturn(24);

        // when then
        assertEquals(-1155484576, random.nextInt());
        assertEquals(-723955400, random.nextInt());

        assertEquals(false, random.nextBoolean());
        assertEquals(true, random.nextBoolean());

        assertEquals(-6688467811848818630L, random.nextLong());
        assertEquals(-8292973307042192125L, random.nextLong());
    }

}