/*
 * MIT License
 *
 * Copyright (c) 2018 Paulo Lobo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.agamulator.ui;

import com.agamulator.core.AGamulator;
import com.agamulator.core.Gamer;

/**
 * Actions are interactions made by some {@link Gamer} to {@link AGamulator}.
 *
 * Actions are typically {@link Command} executions with a set of parameters.
 *
 */
public interface Action {

    /**
     * Gamer which called this {@link Action}.
     * @return Gamer
     */
    Gamer caller();

    /**
     * {@link Command} to be executed.
     * @return Command to be executed
     */
    Command command();

    /**
     * Parameters to execute the {@link Command}.
     * @return Parameters
     */
    Object[] parameters();

    /**
     * Simple command.
     */
    final class Simple implements Action {

        /**
         * Who called the action.
         */
        private final Gamer caller;

        /**
         * Which command to perform.
         */
        private final Command command;

        /**
         * Which parameter to use.
         */
        private final Object[] parameter;

        /**
         * Simple constructor.
         * @param caller Gamer
         * @param command Commadn
         * @param parameters Parameters
         */
        Simple(final Gamer caller, final Command command,
            final Object...parameters){
            this.caller = caller;
            this.command = command;
            this.parameter = parameters;
        }

        @Override
        public Gamer caller() {
            return this.caller;
        }

        @Override
        public Command command() {
            return this.command;
        }

        @Override
        public Object[] parameters() {
            return this.parameters();
        }
    }
}
