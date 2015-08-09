package com.althink.android.ossw.emulator.fonts;

/**
 * Created by krzysiek on 05/07/15.
 */
public class SmallRegular implements EmulatorFont {

    private static final byte[] smallRegularFontBitmaps =
            {
                    // @0 '!' (1 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @11 '"' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xA0, // # #
                    (byte) 0xA0, // # #
                    (byte) 0xA0, // # #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @22 '#' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x28, //   # #
                    (byte) 0x28, //   # #
                    (byte) 0xFC, // ######
                    (byte) 0x50, //  # #
                    (byte) 0x50, //  # #
                    (byte) 0xF8, // #####
                    (byte) 0xA0, // # #
                    (byte) 0xA0, // # #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @33 '$' (4 pixels wide)
                    (byte) 0x20, //   #
                    (byte) 0x70, //  ###
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x20, //   #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0xE0, // ###
                    (byte) 0x20, //   #
                    (byte) 0x00, //

                    // @44 '%' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x42, //  #    #
                    (byte) 0xA4, // # #  #
                    (byte) 0xA8, // # # #
                    (byte) 0x50, //  # #
                    (byte) 0x14, //    # #
                    (byte) 0x2A, //   # # #
                    (byte) 0x4A, //  #  # #
                    (byte) 0x84, // #    #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @55 '&' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x90, // #  #
                    (byte) 0x88, // #   #
                    (byte) 0x7C, //  #####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x76, //  ### ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @66 ''' (1 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @77 '(' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #

                    // @88 ')' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x80, // #

                    // @99 '*' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0xF8, // #####
                    (byte) 0x20, //   #
                    (byte) 0x50, //  # #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @110 '+' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0xF8, // #####
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @121 ',' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #

                    // @132 '-' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @143 '.' (1 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @154 '/' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @165 '0' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @176 '1' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0x60, //  ##
                    (byte) 0xA0, // # #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @187 '2' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x88, // #   #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @198 '3' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x88, // #   #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x88, // #   #
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @209 '4' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x08, //     #
                    (byte) 0x18, //    ##
                    (byte) 0x28, //   # #
                    (byte) 0x48, //  #  #
                    (byte) 0x88, // #   #
                    (byte) 0xF8, // #####
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @220 '5' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xE0, // ###
                    (byte) 0x90, // #  #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @231 '6' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @242 '7' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @253 '8' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x70, //  ###
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @264 '9' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x78, //  ####
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @275 ':' (1 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @286 ';' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #

                    // @297 '<' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x10, //    #
                    (byte) 0x60, //  ##
                    (byte) 0x80, // #
                    (byte) 0x60, //  ##
                    (byte) 0x10, //    #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @308 '=' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @319 '>' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x60, //  ##
                    (byte) 0x10, //    #
                    (byte) 0x60, //  ##
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @330 '?' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @341 '@' (8 pixels wide)
                    (byte) 0x3C, //   ####
                    (byte) 0x42, //  #    #
                    (byte) 0xB1, // # ##   #
                    (byte) 0x89, // #   #  #
                    (byte) 0x99, // #  ##  #
                    (byte) 0xA9, // # # #  #
                    (byte) 0xA9, // # # #  #
                    (byte) 0xBE, // # #####
                    (byte) 0x40, //  #
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //

                    // @352 'A' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x50, //  # #
                    (byte) 0x50, //  # #
                    (byte) 0x50, //  # #
                    (byte) 0xF8, // #####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @363 'B' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0xF0, // ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @374 'C' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x44, //  #   #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x44, //  #   #
                    (byte) 0x38, //   ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @385 'D' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x88, // #   #
                    (byte) 0xF0, // ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @396 'E' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xF0, // ####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @407 'F' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xF0, // ####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @418 'G' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x44, //  #   #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x8C, // #   ##
                    (byte) 0x84, // #    #
                    (byte) 0x44, //  #   #
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @429 'H' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0xFC, // ######
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @440 'I' (1 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @451 'J' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x90, // #  #
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @462 'K' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x88, // #   #
                    (byte) 0x90, // #  #
                    (byte) 0xA0, // # #
                    (byte) 0xE0, // ###
                    (byte) 0xA0, // # #
                    (byte) 0x90, // #  #
                    (byte) 0x90, // #  #
                    (byte) 0x88, // #   #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @473 'L' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xF0, // ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @484 'M' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x44, //  #   #
                    (byte) 0x44, //  #   #
                    (byte) 0x44, //  #   #
                    (byte) 0x6C, //  ## ##
                    (byte) 0xAA, // # # # #
                    (byte) 0xAA, // # # # #
                    (byte) 0x92, // #  #  #
                    (byte) 0x92, // #  #  #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @495 'N' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x84, // #    #
                    (byte) 0xC4, // ##   #
                    (byte) 0xA4, // # #  #
                    (byte) 0xA4, // # #  #
                    (byte) 0x94, // #  # #
                    (byte) 0x94, // #  # #
                    (byte) 0x8C, // #   ##
                    (byte) 0x84, // #    #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @506 'O' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x44, //  #   #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x44, //  #   #
                    (byte) 0x38, //   ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @517 'P' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0xF0, // ####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @528 'Q' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x44, //  #   #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x44, //  #   #
                    (byte) 0x38, //   ###
                    (byte) 0x0C, //     ##
                    (byte) 0x03, //       ##

                    // @539 'R' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0xF0, // ####
                    (byte) 0x90, // #  #
                    (byte) 0x88, // #   #
                    (byte) 0x84, // #    #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @550 'S' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x20, //   #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @561 'T' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @572 'U' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @583 'V' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x82, // #     #
                    (byte) 0x44, //  #   #
                    (byte) 0x44, //  #   #
                    (byte) 0x44, //  #   #
                    (byte) 0x28, //   # #
                    (byte) 0x28, //   # #
                    (byte) 0x28, //   # #
                    (byte) 0x10, //    #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @594 'W' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x88, (byte) 0x80, // #   #   #
                    (byte) 0x88, (byte) 0x80, // #   #   #
                    (byte) 0x55, (byte) 0x00, //  # # # #
                    (byte) 0x55, (byte) 0x00, //  # # # #
                    (byte) 0x55, (byte) 0x00, //  # # # #
                    (byte) 0x55, (byte) 0x00, //  # # # #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @616 'X' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x84, // #    #
                    (byte) 0x48, //  #  #
                    (byte) 0x48, //  #  #
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x48, //  #  #
                    (byte) 0x48, //  #  #
                    (byte) 0x84, // #    #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @627 'Y' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x82, // #     #
                    (byte) 0x44, //  #   #
                    (byte) 0x28, //   # #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @638 'Z' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @649 '[' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xC0, // ##

                    // @660 '\' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x10, //    #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @671 ']' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0xC0, // ##

                    // @682 '^' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0x50, //  # #
                    (byte) 0x88, // #   #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @693 '_' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFC, // ######

                    // @704 '`' (2 pixels wide)
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @715 'a' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x08, //     #
                    (byte) 0x78, //  ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @726 'b' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0xF0, // ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @737 'c' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x88, // #   #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x88, // #   #
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @748 'd' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x78, //  ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @759 'e' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x88, // #   #
                    (byte) 0xF8, // #####
                    (byte) 0x80, // #
                    (byte) 0x88, // #   #
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @770 'f' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x40, //  #
                    (byte) 0xE0, // ###
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @781 'g' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x70, //  ###
                    (byte) 0x80, // #
                    (byte) 0x78, //  ####
                    (byte) 0x84, // #    #
                    (byte) 0x78, //  ####

                    // @792 'h' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @803 'i' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @814 'j' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0x00, //
                    (byte) 0x60, //  ##
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0xC0, // ##

                    // @825 'k' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x90, // #  #
                    (byte) 0xA0, // # #
                    (byte) 0xC0, // ##
                    (byte) 0xA0, // # #
                    (byte) 0x90, // #  #
                    (byte) 0x88, // #   #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @836 'l' (1 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @847 'm' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0x92, // #  #  #
                    (byte) 0x92, // #  #  #
                    (byte) 0x92, // #  #  #
                    (byte) 0x92, // #  #  #
                    (byte) 0x92, // #  #  #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @858 'n' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @869 'o' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @880 'p' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0xF0, // ####
                    (byte) 0x80, // #
                    (byte) 0x80, // #

                    // @891 'q' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x78, //  ####
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #

                    // @902 'r' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xA0, // # #
                    (byte) 0xC0, // ##
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @913 's' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x20, //   #
                    (byte) 0x10, //    #
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @924 't' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0xF0, // ####
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @935 'u' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @946 'v' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x50, //  # #
                    (byte) 0x50, //  # #
                    (byte) 0x50, //  # #
                    (byte) 0x20, //   #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @957 'w' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x92, // #  #  #
                    (byte) 0x92, // #  #  #
                    (byte) 0xAA, // # # # #
                    (byte) 0xAA, // # # # #
                    (byte) 0xAA, // # # # #
                    (byte) 0x44, //  #   #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @968 'x' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x88, // #   #
                    (byte) 0x50, //  # #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x50, //  # #
                    (byte) 0x88, // #   #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @979 'y' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x50, //  # #
                    (byte) 0x50, //  # #
                    (byte) 0x50, //  # #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0xC0, // ##

                    // @990 'z' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1001 '{' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x60, //  ##
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x60, //  ##

                    // @1012 '|' (1 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //

                    // @1023 '}' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0xC0, // ##

                    // @1034 '~' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC8, // ##  #
                    (byte) 0xB8, // # ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
            };

    private static final CharInfo[] smallRegularFontDescriptors =
            {
                    new CharInfo(1, 0),        // !
                    new CharInfo(3, 11),        // "
                    new CharInfo(6, 22),        // #
                    new CharInfo(4, 33),        // $
                    new CharInfo(7, 44),        // %
                    new CharInfo(7, 55),        // &
                    new CharInfo(1, 66),        // '
                    new CharInfo(2, 77),        // (
                    new CharInfo(2, 88),        // )
                    new CharInfo(5, 99),        // *
                    new CharInfo(5, 110),        // +
                    new CharInfo(2, 121),        // ,
                    new CharInfo(3, 132),        // -
                    new CharInfo(1, 143),        // .
                    new CharInfo(4, 154),        // /
                    new CharInfo(5, 165),        // 0
                    new CharInfo(3, 176),        // 1
                    new CharInfo(5, 187),        // 2
                    new CharInfo(5, 198),        // 3
                    new CharInfo(5, 209),        // 4
                    new CharInfo(4, 220),        // 5
                    new CharInfo(5, 231),        // 6
                    new CharInfo(5, 242),        // 7
                    new CharInfo(5, 253),        // 8
                    new CharInfo(5, 264),        // 9
                    new CharInfo(1, 275),        // :
                    new CharInfo(2, 286),        // ;
                    new CharInfo(4, 297),        // <
                    new CharInfo(4, 308),        // =
                    new CharInfo(4, 319),        // >
                    new CharInfo(4, 330),        // ?
                    new CharInfo(8, 341),        // @
                    new CharInfo(5, 352),        // A
                    new CharInfo(5, 363),        // B
                    new CharInfo(6, 374),        // C
                    new CharInfo(6, 385),        // D
                    new CharInfo(5, 396),        // E
                    new CharInfo(5, 407),        // F
                    new CharInfo(6, 418),        // G
                    new CharInfo(6, 429),        // H
                    new CharInfo(1, 440),        // I
                    new CharInfo(4, 451),        // J
                    new CharInfo(5, 462),        // K
                    new CharInfo(4, 473),        // L
                    new CharInfo(7, 484),        // M
                    new CharInfo(6, 495),        // N
                    new CharInfo(7, 506),        // O
                    new CharInfo(5, 517),        // P
                    new CharInfo(8, 528),        // Q
                    new CharInfo(6, 539),        // R
                    new CharInfo(4, 550),        // S
                    new CharInfo(5, 561),        // T
                    new CharInfo(6, 572),        // U
                    new CharInfo(7, 583),        // V
                    new CharInfo(9, 594),        // W
                    new CharInfo(6, 616),        // X
                    new CharInfo(7, 627),        // Y
                    new CharInfo(5, 638),        // Z
                    new CharInfo(2, 649),        // [
                    new CharInfo(4, 660),        // \
                    new CharInfo(2, 671),        // ]
                    new CharInfo(5, 682),        // ^
                    new CharInfo(6, 693),        // _
                    new CharInfo(2, 704),        // `
                    new CharInfo(5, 715),        // a
                    new CharInfo(5, 726),        // b
                    new CharInfo(5, 737),        // c
                    new CharInfo(5, 748),        // d
                    new CharInfo(5, 759),        // e
                    new CharInfo(4, 770),        // f
                    new CharInfo(6, 781),        // g
                    new CharInfo(5, 792),        // h
                    new CharInfo(2, 803),        // i
                    new CharInfo(3, 814),        // j
                    new CharInfo(5, 825),        // k
                    new CharInfo(1, 836),        // l
                    new CharInfo(7, 847),        // m
                    new CharInfo(5, 858),        // n
                    new CharInfo(5, 869),        // o
                    new CharInfo(5, 880),        // p
                    new CharInfo(5, 891),        // q
                    new CharInfo(3, 902),        // r
                    new CharInfo(4, 913),        // s
                    new CharInfo(4, 924),        // t
                    new CharInfo(5, 935),        // u
                    new CharInfo(5, 946),        // v
                    new CharInfo(7, 957),        // w
                    new CharInfo(5, 968),        // x
                    new CharInfo(5, 979),        // y
                    new CharInfo(5, 990),        // z
                    new CharInfo(3, 1001),        // {
                    new CharInfo(1, 1012),        // |
                    new CharInfo(3, 1023),        // }
                    new CharInfo(5, 1034),        // ~
            };

    private static final CharInfoLookup[] smallRegularFontBlockLookup =
            {
                    new CharInfoLookup('!', '~', smallRegularFontDescriptors)
            };

    private static final FontInfo smallRegularFontInfo = new FontInfo(
            11,
            '!',
            '~',
            1,
            2,
            smallRegularFontBlockLookup,
            smallRegularFontBitmaps
    );

    @Override
    public FontInfo getFontInfo() {
        return smallRegularFontInfo;
    }
}
