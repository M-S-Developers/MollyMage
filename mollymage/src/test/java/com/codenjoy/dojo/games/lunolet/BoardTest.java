package com.codenjoy.dojo.games.lunolet;

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

public class BoardTest {

    @Test
    public void parseBoard() {
        String input =
                "{ 'level': 10.1, 'x': 11.2, 'y': 12.3, " +
                "'time': 13.4, " +
                "'target':{'x': 1.5, 'y': 2.6}, " +
                "'relief':[{'x': 3.7, 'y': 4.8}], " +
                "'history':[{'x': 5.9, 'y': 6.1}], " +
                "'hspeed': 7.2, 'angle': 8.3, 'vspeed': 9.4, " +
                "'fuelmass': 14.5, 'state': 'START' }";

        Board board = (Board) new Board().forString(input);

        assertEquals("{\n" +
                    "  'HSpeed': 7.2,\n" +
                    "  'VSpeed': 9.4,\n" +
                    "  'angle': 8.3,\n" +
                    "  'data': '{ 'level': 10.1, 'x': 11.2, 'y': 12.3, 'time': 13.4, 'target':{'x': 1.5, 'y': 2.6}, 'relief':[{'x': 3.7, 'y': 4.8}], 'history':[{'x': 5.9, 'y': 6.1}], 'hspeed': 7.2, 'angle': 8.3, 'vspeed': 9.4, 'fuelmass': 14.5, 'state': 'START' }',\n" +
                    "  'fuelMass': 14.5,\n" +
                    "  'gameOver': false,\n" +
                    "  'history': ['Point2D.Double[5.9, 6.1]'],\n" +
                    "  'point': 'Point2D.Double[11.2, 12.3]',\n" +
                    "  'relief': ['Point2D.Double[3.7, 4.8]'],\n" +
                    "  'state': {},\n" +
                    "  'target': 'Point2D.Double[1.5, 2.6]',\n" +
                    "  'time': 13.4\n" +
                    "}", Utils.prettyPrintObject(board));
    }
}