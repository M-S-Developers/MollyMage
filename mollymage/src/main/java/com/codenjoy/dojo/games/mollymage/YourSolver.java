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

import com.codenjoy.dojo.JavaRunner;
import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Point;

import java.util.*;

import static com.codenjoy.dojo.games.mollymage.Element.POISON_THROWER;

/**
 * Author: your name
 * <p>
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

    public static String prevCommand = Command.DROP_POTION;

    public int potionX = -1;

    public int potionY = -1;

    public int potionStepsRemained = 0;

    public static Random random = new Random((new Date()).getTime());

    public boolean isBlastPotion(Element e) {
        return e == Element.POTION_EXPLODER || e == Element.POTION_TIMER_4
                || e == Element.POTION_TIMER_3
                || e == Element.POTION_TIMER_2
                || e == Element.POTION_TIMER_5
                || e == Element.POTION_TIMER_1
                || e == Element.HERO_POTION
                || e == Element.OTHER_HERO_POTION
                || e == Element.ENEMY_HERO_POTION
                || e == Element.GHOST
                || e == Element.GHOST_DEAD
        ;
    }

    public boolean isDamagePotion(Element e) {
        return e == Element.POTION_EXPLODER || e == Element.POTION_TIMER_4
                || e == Element.POTION_TIMER_3
                || e == Element.POTION_TIMER_2
                || e == Element.POTION_TIMER_1

                || e == Element.POTION_IMMUNE
                || e == Element.POTION_COUNT_INCREASE
                || e == Element.POTION_TIMER_5
                || e == Element.POTION_REMOTE_CONTROL
                || e == Element.POISON_THROWER
                || e == Element.HERO_POTION
                || e == Element.OTHER_HERO_POTION
                || e == Element.ENEMY_HERO_POTION
                || e == Element.POTION_BLAST_RADIUS_INCREASE
                ;
    }

    public boolean isBlastPoint(int x, int y) {
        return this.isBlastPotion(this.board.getAt(x, y));
    }

    public boolean badCell(int x, int y) {
        return isDamagePotion(this.board.getAt(x, y));
    }

    public boolean goodMove(int x, int y) {
        for (int i = 1; i <= 6; ++i) { // phony
            if (isBlastPoint(x + i, y) ) return false;
            
			if (isBlastPoint(x - i, y) ) return false;

            if (isBlastPoint(x, y - i))return false;
            
            if (isBlastPoint(x, y + i)) return false;
        }

        return true;
    }


    public boolean goodCell(int x, int y) {
        if (badCell(x, y)) return false;

        Element e = this.board.getAt(x, y);

        return e == Element.NONE
                || e == Element.POTION_IMMUNE
                || e == Element.POTION_COUNT_INCREASE
                || e == Element.POTION_REMOTE_CONTROL
                ;
    }

    public boolean noDamagePotion() {
        int hx = this.board.getHero().getX();

        int hy = this.board.getHero().getY();

        for (int i = 1; i <= 6; ++i) {
            Element e = this.board.getAt(hx + i, hy);

            if (isDamagePotion(e)) {
                return false;
            }

            e = this.board.getAt(hx - i, hy);

            if (isDamagePotion(e)) {
                return false;
            }

            e = this.board.getAt(hx, hy + i);

            if (isDamagePotion(e)) {
                return false;
            }

            e = this.board.getAt(hx, hy - i);

            if (isDamagePotion(e)) {
                return false;
            }
        }

        return true;
    }

    public String getNextCommand() {
        int hx = this.board.getHero().getX();

        int hy = this.board.getHero().getY();

        HashSet<String> hsDiag = new HashSet<>();

        if (this.board.getAt(hx - 1, hy) == Element.NONE) {
            if (this.board.getAt(hx - 1, hy - 1) == Element.NONE) {
                hsDiag.add(Command.MOVE_LEFT);
            }

            if (this.board.getAt(hx - 1, hy + 1) == Element.NONE) {
                hsDiag.add(Command.MOVE_LEFT);
            }
        }

        if (this.board.getAt(hx + 1, hy) == Element.NONE) {
            if (this.board.getAt(hx + 1, hy - 1) == Element.NONE) {
                hsDiag.add(Command.MOVE_RIGHT);
            }

            if (this.board.getAt(hx + 1, hy + 1) == Element.NONE) {
                hsDiag.add(Command.MOVE_RIGHT);
            }
        }

        if (this.board.getAt(hx, hy - 1) == Element.NONE) {
            if (this.board.getAt(hx - 1, hy - 1) == Element.NONE) {
                hsDiag.add(Command.MOVE_DOWN);
            }

            if (this.board.getAt(hx + 1, hy - 1) == Element.NONE) {
                hsDiag.add(Command.MOVE_DOWN);
            }
        }

        if (this.board.getAt(hx, hy + 1) == Element.NONE) {
            if (this.board.getAt(hx - 1, hy + 1) == Element.NONE) {
                hsDiag.add(Command.MOVE_UP);
            }

            if (this.board.getAt(hx + 1, hy + 1) == Element.NONE) {
                hsDiag.add(Command.MOVE_UP);
            }
        }

        if (hsDiag.size() > 0) {
            return hsDiag.toArray()[random.nextInt(hsDiag.size())].toString();
        }

        boolean bfLeft = true;
        boolean bfRight = true;
        boolean bfUp = true;
        boolean bfDown = true;

        for (int i = 1; i <= 4; ++i) { // phony
            if (this.board.getAt(hx - i, hy) != Element.NONE) {
                bfLeft = false;
            }

            if (this.board.getAt(hx + i, hy) != Element.NONE) {
                bfRight = false;
            }

            if (this.board.getAt(hx, hy + i) != Element.NONE) {
                bfUp = false;
            }

            if (this.board.getAt(hx, hy - i) != Element.NONE) {
                bfDown = false;
            }
        }

        HashSet<String> hs = new HashSet<>();

        if (bfLeft) {
            hs.add(Command.MOVE_LEFT);
        }

        if (bfRight) {
            hs.add(Command.MOVE_RIGHT);
        }

        if (bfUp) {
            hs.add(Command.MOVE_UP);
        }

        if (bfDown) {
            hs.add(Command.MOVE_DOWN);
        }

        if (hs.size() > 0) {
            return hs.toArray()[random.nextInt(hs.size())].toString();
        }

        return null;
    }

    public String prevMoveCommand = null;

    public int prevCommandCounter = -1;

    @Override
    public String get(Board board) {
        this.board = board;
        if (board.isGameOver()) return "";

        if (this.nextCommand != null) {

            prevCommand = this.nextCommand;

            this.nextCommand = null;

            return prevCommand;
        }


        HashSet<String> avails = new HashSet<>();

        HashSet<String> avails1 = new HashSet<>();

        HashSet<String> avails2 = new HashSet<>();

        if (goodCell(this.board.getHero().getX() - 1, this.board.getHero().getY()) //&& board.getAt(this.board.getHero().getX() - 1, this.board.getHero().getY()) == Element.NONE
            && board.getAt(this.board.getHero().getX() - 1, this.board.getHero().getY()) != Element.GHOST
                && goodMove(this.board.getHero().getX() - 1, this.board.getHero().getY())
                && board.getAt(this.board.getHero().getX() - 1, this.board.getHero().getY()) != Element.TREASURE_BOX) {
            avails.add(Command.MOVE_LEFT);

            avails1.add(Command.MOVE_LEFT);
        }

        if (goodCell(this.board.getHero().getX() + 1, this.board.getHero().getY())//board.getAt(this.board.getHero().getX() + 1, this.board.getHero().getY()) == Element.NONE
                && board.getAt(this.board.getHero().getX() + 1, this.board.getHero().getY()) != Element.GHOST
                && goodMove(this.board.getHero().getX() + 1, this.board.getHero().getY())
                && board.getAt(this.board.getHero().getX() + 1, this.board.getHero().getY()) != Element.TREASURE_BOX) {
            avails.add(Command.MOVE_RIGHT);

            avails1.add(Command.MOVE_RIGHT);
        }

        if (goodCell(this.board.getHero().getX(), this.board.getHero().getY() - 1)//board.getAt(this.board.getHero().getX(), this.board.getHero().getY() - 1) == Element.NONE
                && board.getAt(this.board.getHero().getX(), this.board.getHero().getY() - 1) != Element.GHOST
                && goodMove(this.board.getHero().getX(), this.board.getHero().getY() - 1)
                && board.getAt(this.board.getHero().getX(), this.board.getHero().getY() - 1) != Element.TREASURE_BOX) {
            avails.add(Command.MOVE_DOWN);

            avails2.add(Command.MOVE_DOWN);
        }

        if (goodCell(this.board.getHero().getX(), this.board.getHero().getY() + 1) //board.getAt(this.board.getHero().getX(), this.board.getHero().getY() + 1) == Element.NONE
                && board.getAt(this.board.getHero().getX(), this.board.getHero().getY() + 1) != Element.GHOST
                && goodMove(this.board.getHero().getX(), this.board.getHero().getY() + 1)
                && board.getAt(this.board.getHero().getX(), this.board.getHero().getY() + 1) != Element.TREASURE_BOX) {
            avails.add(Command.MOVE_UP);

            avails2.add(Command.MOVE_UP);
        }

        String t = this.getNextCommand();

        if ((avails1.size() > 0 || avails2.size() > 0) && t != null && noDamagePotion() /*&& random.nextInt(100) <= 30*/ && numberOfPotions > 0 && potionStepsRemained == 0) {
            potionX = board.getHero().getX();

            potionY = board.getHero().getY();

            potionStepsRemained = 6;

            this.nextCommand = t;

            return Command.DROP_POTION;
        } else if (potionStepsRemained > 0) {
            --potionStepsRemained;

            if ((potionX != this.board.getHero().getX()) && (potionY != this.board.getHero().getY())) {
                return Command.NONE;
            }

            for (String s: avails) {
                if (s.equals(Command.MOVE_DOWN)) {
                    if (potionY - 1 != this.board.getHero().getY() && potionX != this.board.getHero().getX()) {
                        return prevCommand = s;
                    }
                } else if (s.equals(Command.MOVE_UP)) {
                    if (potionY + 1 != this.board.getHero().getY() && potionX != this.board.getHero().getX()) {
                        return prevCommand = s;
                    }
                } else if (s.equals(Command.MOVE_LEFT)) {
                    if (potionX - 1 != this.board.getHero().getX() && potionY != this.board.getHero().getY()) {
                        return prevCommand = s;
                    }
                } else if (s.equals(Command.MOVE_RIGHT)) {
                    if (potionX + 1 != this.board.getHero().getX() && potionY != this.board.getHero().getY()) {
                        return prevCommand = s;
                    }
                }
            }

            if (potionY == this.board.getHero().getY()) {
                if (this.board.getHero().getX() > potionX && avails1.contains(Command.MOVE_RIGHT)) {
                    return prevCommand = Command.MOVE_RIGHT;
                } else if (avails1.contains(Command.MOVE_LEFT)) {
                    return prevCommand = Command.MOVE_LEFT;
                }

                return Command.NONE;
            }

            if (potionX == this.board.getHero().getX()) {
                if (this.board.getHero().getY() > potionY && avails2.contains(Command.MOVE_UP)) {
                    return prevCommand = Command.MOVE_UP;
                } else if (avails2.contains(Command.MOVE_DOWN)) {
                    return prevCommand = Command.MOVE_DOWN;
                }

                return Command.NONE;
            }

        if (avails.size() == 0) {
            return Command.NONE;
        }

        Map<Integer, String> ad = new HashMap<>();

        for (String s: avails) {
            List<Point> ghosts = new ArrayList<>();
            List<Point> potions = this.board.getPotions();

            ghosts.addAll(potions);

            int mean = -1;

            if (s.equals(Command.MOVE_LEFT)) {
                for (Point pt : ghosts) {
                    int k = Math.abs(this.board.getHero().getX() - 1 - pt.getX())
                            + Math.abs(this.board.getHero().getY() - pt.getY());

                    if (k < mean || mean == -1) mean = k;
                }

                if (mean != -1) ad.put(mean, s);
            }

            mean = -1;

            if (s.equals(Command.MOVE_RIGHT)) {
                for (Point pt : ghosts) {
                    int k = Math.abs(this.board.getHero().getX() + 1 - pt.getX())
                            + Math.abs(this.board.getHero().getY() - pt.getY());

                    if (k < mean || mean == -1) mean = k;
                }

                if (mean != -1) ad.put(mean, s);
            }

            mean = -1;

            if (s.equals(Command.MOVE_UP)) {
                for (Point pt : ghosts) {
                    int k = Math.abs(this.board.getHero().getX() - pt.getX())
                            + Math.abs(this.board.getHero().getY() + 1 - pt.getY());

                    if (k < mean || mean == -1) mean = k;
                }

                if (mean != -1) ad.put(mean, s);
            }

            mean = -1;

            if (s.equals(Command.MOVE_DOWN)) {
                for (Point pt : ghosts) {
                    int k = Math.abs(this.board.getHero().getX() - pt.getX())
                            + Math.abs(this.board.getHero().getY() - 1 - pt.getY());

                    if (k < mean || mean == -1) mean = k;
                }

                if (mean != -1) ad.put(mean, s);
            }
        }

        int vmax = -1;

        for (Integer ii: ad.keySet()) {
            if (ii > vmax) {
                vmax = ii;
            }
        }

        if (vmax != -1 && vmax > 0 && vmax < 4) {
            return Command.NONE;
        }

        return avails.toArray()[random.nextInt(avails.size())].toString();
    }
}