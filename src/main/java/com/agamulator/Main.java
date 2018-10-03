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
package com.agamulator;

import com.agamulator.core.Copies;
import com.agamulator.core.Gamer;
import com.agamulator.core.Games;
import com.agamulator.core.Locations;
import com.agamulator.core.Platforms;
import com.agamulator.core.Releases;
import com.agamulator.ui.printed.Sysout;
import com.agamulator.ui.printer.PtGames;
import com.agamulator.ui.printer.PtLocations;
import com.agamulator.ui.printer.PtPlatforms;
import com.agamulator.ui.printer.PtReleases;
import com.agamulator.ui.string.StrGames;
import com.agamulator.ui.string.StrLocations;
import com.agamulator.ui.string.StrPlatforms;
import com.agamulator.ui.string.StrReleases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.cactoos.Text;
import org.cactoos.list.ListOf;
import org.cactoos.text.FormattedText;
import org.cactoos.text.JoinedText;
import org.cactoos.text.SplitText;
import org.cactoos.text.TextOf;
import org.cactoos.text.UncheckedText;

/**
 * Main entry point for application.
 *
 * @since 1.0
 */
public final class Main {

    /**
     * Ctor.
     */
    private Main() {
        //It's a utility class.
    }

    /**
     * Main method.
     *
     * @param args Arguments
     */
    public static void main(final String... args) {
        final Games games = new Games.Simple();//game repository
        final PtGames pgames = new PtGames(games);//game frontend
        final Locations locations = new Locations.Simple();//location repository
        final PtLocations plocations = new PtLocations(locations);//location
        final Platforms platforms = new Platforms.Simple();//platform repo
        final PtPlatforms pplatforms = new PtPlatforms(platforms);
        final Gamer gamer = new Gamer.Simple(new TextOf("paulodamaso"));//gamer
        final Releases releases = new Releases.Simple(
            games,
            platforms,
            locations
        );
        //releases repository
        final PtReleases preleases = new PtReleases(releases);//releases
        // frontend

        final Sysout out = new Sysout();

        String command = "";
        while(!"quit".equals(command)){
            out.write("AGamulator");
            out.write("---------------------------------------");
            out.write("> add game 'game title' -  adds game");
            out.write("> add platform 'platform name' -  adds platform");
            out.write("> add location 'location name' -  adds location");
            out.write("> add release 'game' 'platform' 'location' -  adds " +
             "game release");
            out.write("> owned - list owned games");
            out.write("> releases - list known releases");
            out.write("> games - list known games");
            out.write("> locations - list known locations");
            out.write("> platforms - list known platforms");
            out.write("> quit - quits AGamulator");
            Scanner in = new Scanner(System.in);
            Text line = new TextOf(in.nextLine());
            List<Text> cmd = new ListOf<>(new SplitText(line, "\\s+"));
            switch(new UncheckedText(cmd.get(0)).asString()){
                case "games":{
                    out.write(pgames.print(new StrGames()));
                    break;
                }
                case "owned":{
                    out.write(pgames.print(new StrGames()));
                    break;
                }
                case "locations":{
                    out.write(plocations.print(new StrLocations()));
                    break;
                }
                case "platforms":{
                    out.write(pplatforms.print(new StrPlatforms()));
                    break;
                }
                case "releases":{
                    out.write(preleases.print(new StrReleases()));
                    break;
                }
                case "add":{
                    List<Text> parameters = parameters(line);
                    switch(new UncheckedText(cmd.get(1)).asString()){
                        case "game": {
                            games.add(
                                parameters.get(0)
                            );
                            break;
                        }
                        case "platform":{
                            platforms.add(
                                parameters.get(0)
                            );
                            break;
                        }
                        case "location":{
                            locations.add(
                                parameters.get(0)
                            );
                            break;
                        }
                        case "release":{
                            releases.add(
                                parameters.get(0),
                                parameters.get(1),
                                parameters.get(2)
                            );
                            break;
                        }
                        default:{
                            out.write(new UncheckedText(new FormattedText("Argument %s " +
                             "unknown " +
                             "for 'add' command", cmd.get(1))).asString());
                            break;
                        }
                    }
                }
                case "quit":{
                    break;
                }
                default:{
                    out.write(new UncheckedText(new FormattedText(
                    "Unrecognized command: '%s'",cmd.get(0))).asString());
                    break;
                }
            }

        }
    }

    private static List<Text> parameters (final Text command) {
        final List<Text> result = new ArrayList<>(0);
        final Pattern p = Pattern.compile("'([^\\s']+)'");
        final Matcher m = p.matcher(new UncheckedText(command).asString());
        while( m.find()) {
            result.add(new TextOf(m.group( 1 )));
        }
        return result;
    }
}
