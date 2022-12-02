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


import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Direction;

import java.awt.geom.Point2D;

/**
 * Author: your name
 *
 * This is your AI algorithm for the game.
 * Implement it at your own discretion.
 * Pay attention to {@link YourSolverTest} - there is
 * a test framework for you.
 */
public class YourSolver implements Solver<Board> {

    private Dice dice;
    private Board board;

    public YourSolver(Dice dice) {
        this.dice = dice;
    }

    @Override
    public String get(Board board) {
        Point2D.Double target = board.getTarget();
        Point2D.Double current = board.getPoint();

        if (board.getState() == VesselState.START) {
            return "message('go 0, 0.2, 1')";
        }

        if (current.y < target.y + 4.0 || board.getVSpeed() < -1.5) {
            return Direction.UP.toString();
        } else if (current.x < target.x && board.getHSpeed() < 3.0) {
            return Direction.RIGHT.toString();
        } else if (current.x > target.x && board.getHSpeed() > -3.0) {
            return Direction.LEFT.toString();
        } else {
            return Direction.DOWN.toString();
        }

        // TODO your code here
    }
}