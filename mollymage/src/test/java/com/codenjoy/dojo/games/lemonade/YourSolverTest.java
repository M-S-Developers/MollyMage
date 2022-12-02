package com.codenjoy.dojo.games.lemonade;

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


import com.codenjoy.dojo.client.ClientBoard;
import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Direction;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class YourSolverTest {

    private Dice dice;
    private Solver ai;

    @Before
    public void setup() {
        dice = mock(Dice.class);
        ai = new YourSolver(dice);
    }

    private ClientBoard board(String board) {
        return new Board().forString(board);
    }

    @Test
    public void should() {

        // TODO these asserts are here for an example, delete it and write your own

        asertAI("{" +
                "    history : [" +
                "        {" +
                "            day : 1," +
                "            lemonadeSold : 2," +
                "            lemonadePrice : 0.34," +
                "            income : 0.00," +
                "            lemonadeMade : 4," +
                "            signsMade : 3," +
                "            expenses : 4.3," +
                "            profit : -0.45," +
                "            assetsAfter : 2.55" +
                "        }," +
                "        {" +
                "            day : 2," +
                "            lemonadeSold : 5," +
                "            lemonadePrice : 0.34," +
                "            income : 0.60," +
                "            lemonadeMade : 3," +
                "            signsMade : 3," +
                "            expenses : 4.3," +
                "            profit : -0.45," +
                "            assetsAfter : 2.55" +
                "        }" +
                "    ]," +
                "    day : 3," +
                "    lemonadeCost : 0.02," +
                "    assets : 1.55," +
                "    weatherForecast : \"SUNNY\"," +
                "    messages : \"my test message\"," +
                "    isBankrupt : true" +
                "}",
                "message('go reset')");
    }

    private void asertAI(String board, String expected) {
        assertEquals(expected, ai.get(board(board)));
    }

    private void dice(Direction direction) {
        when(dice.next(anyInt())).thenReturn(direction.value());
    }
}
