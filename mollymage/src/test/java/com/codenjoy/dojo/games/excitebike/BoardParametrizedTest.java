package com.codenjoy.dojo.games.excitebike;

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

import com.codenjoy.dojo.games.excitebike.element.BikeElement;
import com.codenjoy.dojo.games.excitebike.element.GameElement;
import com.codenjoy.dojo.games.excitebike.element.SpringboardElement;
import com.codenjoy.dojo.services.printer.CharElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class BoardParametrizedTest {

    private char elementChar;
    private String elementName;
    private Class elementClass;

    public <T extends Enum & CharElement> BoardParametrizedTest(T element) {
        elementChar = element.ch();
        elementName = element.name();
        elementClass = element.getClass();
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection data() {
        return Stream.of(
                Arrays.stream(GameElement.values()),
                Arrays.stream(SpringboardElement.values()),
                Arrays.stream(BikeElement.values())
        ).flatMap(Function.identity()).collect(Collectors.toList());
    }

    @Test
    public void valueOf__shouldReturnCorrectElement() {
        //given
        Board board = new Board();

        //when
        CharElement result = board.valueOf(elementChar);

        //then
        assertThat(result, is(Enum.valueOf(elementClass, elementName)));
    }
}
