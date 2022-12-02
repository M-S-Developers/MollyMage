package com.codenjoy.dojo.games.kata;

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


import com.codenjoy.dojo.JavaRunner;

/**
 * Author: your name
 *
 * This is your AI algorithm for the game.
 * Implement it at your own discretion.
 * Pay attention to {@link YourSolverTest} - there is
 * a test framework for you.
 */
public class YourSolver extends AbstractTextSolver {

    @Override
    public Strings getAnswers(int level, Strings questions) {
        Strings answers = new Strings();
        for (String question : questions) {
            answers.add(algorithm(level, question));
        }
        return answers;
    }

    private String algorithm(int level, String question) {
        if (level == 0) {
            if (question.equals("hello")) {
                return "world";
            }

            if (question.equals("world")) {
                return "hello";
            }
            
            return question;
        }

        if (level == 1) {

            // TODO your code here

            return "your answer";
        }

        return "your answer";
    }

    // Use this command to start next level
    public static class StartNextLevel {
        public static void main(String[] args) {
            new JavaRunner().send("message('" + Element.START_NEXT_LEVEL + "')", new Board());
        }
    }

    // Use this command to skip this level
    public static class SkipThisLevel extends YourSolver {
        public static void main(String[] args) {
            new JavaRunner().send("message('" + Element.SKIP_THIS_LEVEL + "')", new Board());
        }
    }
}