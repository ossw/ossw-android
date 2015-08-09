package com.althink.android.ossw.emulator.fonts;

/**
 * Created by krzysiek on 05/07/15.
 */
public class SmallBold implements EmulatorFont {

    private static final byte[] smallBoldFontBitmaps =
            {
                    // @0 '!' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @11 '"' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xA0, // # #
                    (byte) 0xA0, // # #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @22 '#' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x28, //   # #
                    (byte) 0x28, //   # #
                    (byte) 0xF8, // #####
                    (byte) 0x50, //  # #
                    (byte) 0x50, //  # #
                    (byte) 0xF8, // #####
                    (byte) 0xA0, // # #
                    (byte) 0xA0, // # #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @33 '$' (5 pixels wide)
                    (byte) 0x20, //   #
                    (byte) 0x70, //  ###
                    (byte) 0xC8, // ##  #
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x30, //   ##
                    (byte) 0x18, //    ##
                    (byte) 0x98, // #  ##
                    (byte) 0x70, //  ###
                    (byte) 0x20, //   #
                    (byte) 0x00, //

                    // @44 '%' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xE4, // ###  #
                    (byte) 0xA8, // # # #
                    (byte) 0xA8, // # # #
                    (byte) 0xF0, // ####
                    (byte) 0x1E, //    ####
                    (byte) 0x2A, //   # # #
                    (byte) 0x2A, //   # # #
                    (byte) 0x4E, //  #  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @55 '&' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0xC8, // ##  #
                    (byte) 0xCC, // ##  ##
                    (byte) 0x7E, //  ######
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x7E, //  ######
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @66 ''' (1 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @77 '(' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0x60, //  ##
                    (byte) 0x40, //  #
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x60, //  ##
                    (byte) 0x20, //   #

                    // @88 ')' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x40, //  #
                    (byte) 0xC0, // ##
                    (byte) 0x80, // #

                    // @99 '*' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0xF8, // #####
                    (byte) 0x70, //  ###
                    (byte) 0x70, //  ###
                    (byte) 0x50, //  # #
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
                    (byte) 0xC0, // ##
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

                    // @143 '.' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @154 '/' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @165 '0' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @176 '1' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x70, //  ###
                    (byte) 0xB0, // # ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @187 '2' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0xD8, // ## ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x40, //  #
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @198 '3' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0xD8, // ## ##
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0xD8, // ## ##
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @209 '4' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x08, //     #
                    (byte) 0x18, //    ##
                    (byte) 0x38, //   ###
                    (byte) 0x58, //  # ##
                    (byte) 0x58, //  # ##
                    (byte) 0xFC, // ######
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @220 '5' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0xC0, // ##
                    (byte) 0xF0, // ####
                    (byte) 0x98, // #  ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x98, // #  ##
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @231 '6' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0xF0, // ####
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @242 '7' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @253 '8' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0x70, //  ###
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @264 '9' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0x78, //  ####
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @275 ':' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @286 ';' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
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

                    // @308 '=' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
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
                    (byte) 0xB0, // # ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @341 '@' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x44, //  #   #
                    (byte) 0x92, // #  #  #
                    (byte) 0x8A, // #   # #
                    (byte) 0x9A, // #  ## #
                    (byte) 0xAA, // # # # #
                    (byte) 0x9C, // #  ###
                    (byte) 0x40, //  #
                    (byte) 0x3C, //   ####

                    // @352 'A' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x38, //   ###
                    (byte) 0x28, //   # #
                    (byte) 0x6C, //  ## ##
                    (byte) 0x6C, //  ## ##
                    (byte) 0x7C, //  #####
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @363 'B' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xF8, // #####
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @374 'C' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x6C, //  ## ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x6C, //  ## ##
                    (byte) 0x38, //   ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @385 'D' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0xD8, // ## ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xF0, // ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @396 'E' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xF0, // ####
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @407 'F' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xF0, // ####
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @418 'G' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x6C, //  ## ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xDC, // ## ###
                    (byte) 0xCC, // ##  ##
                    (byte) 0x6C, //  ## ##
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @429 'H' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFE, // #######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @440 'I' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @451 'J' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0xD8, // ## ##
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @462 'K' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xCC, // ##  ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xD0, // ## #
                    (byte) 0xF0, // ####
                    (byte) 0xF0, // ####
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @473 'L' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @484 'M' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC6, // ##   ##
                    (byte) 0xEE, // ### ###
                    (byte) 0xEE, // ### ###
                    (byte) 0xFE, // #######
                    (byte) 0xD6, // ## # ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @495 'N' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x8C, // #   ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xEC, // ### ##
                    (byte) 0xEC, // ### ##
                    (byte) 0xDC, // ## ###
                    (byte) 0xDC, // ## ###
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @506 'O' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x6C, //  ## ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x6C, //  ## ##
                    (byte) 0x38, //   ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @517 'P' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xF0, // ####
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @528 'Q' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x6C, //  ## ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x6C, //  ## ##
                    (byte) 0x38, //   ###
                    (byte) 0x0C, //     ##
                    (byte) 0x07, //      ###

                    // @539 'R' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xF8, // #####
                    (byte) 0xD8, // ## ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @550 'S' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0xD8, // ## ##
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x30, //   ##
                    (byte) 0x18, //    ##
                    (byte) 0xD8, // ## ##
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @561 'T' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @572 'U' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @583 'V' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC6, // ##   ##
                    (byte) 0x44, //  #   #
                    (byte) 0x6C, //  ## ##
                    (byte) 0x6C, //  ## ##
                    (byte) 0x28, //   # #
                    (byte) 0x38, //   ###
                    (byte) 0x38, //   ###
                    (byte) 0x10, //    #
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @594 'W' (11 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC4, (byte) 0x60, // ##   #   ##
                    (byte) 0x6E, (byte) 0xC0, //  ## ### ##
                    (byte) 0x6E, (byte) 0xC0, //  ## ### ##
                    (byte) 0x6A, (byte) 0xC0, //  ## # # ##
                    (byte) 0x3B, (byte) 0x80, //   ### ###
                    (byte) 0x3B, (byte) 0x80, //   ### ###
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x11, (byte) 0x00, //    #   #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @616 'X' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC6, // ##   ##
                    (byte) 0x6C, //  ## ##
                    (byte) 0x28, //   # #
                    (byte) 0x38, //   ###
                    (byte) 0x38, //   ###
                    (byte) 0x28, //   # #
                    (byte) 0x6C, //  ## ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @627 'Y' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC3, // ##    ##
                    (byte) 0x66, //  ##  ##
                    (byte) 0x66, //  ##  ##
                    (byte) 0x3C, //   ####
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @638 'Z' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0x08, //     #
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x40, //  #
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @649 '[' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xE0, // ###

                    // @660 '\' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @671 ']' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0xE0, // ###

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
                    (byte) 0x18, //    ##
                    (byte) 0x78, //  ####
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @726 'b' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xF8, // #####
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @737 'c' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0xCC, // ##  ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @748 'd' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x7C, //  #####
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x7C, //  #####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @759 'e' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0xCC, // ##  ##
                    (byte) 0xFC, // ######
                    (byte) 0xC0, // ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @770 'f' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0xC0, // ##
                    (byte) 0xE0, // ###
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @781 'g' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0x70, //  ###
                    (byte) 0xC0, // ##
                    (byte) 0x78, //  ####
                    (byte) 0xCC, // ##  ##
                    (byte) 0x78, //  ####

                    // @792 'h' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xF8, // #####
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @803 'i' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @814 'j' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0xE0, // ###

                    // @825 'k' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xF0, // ####
                    (byte) 0xF8, // #####
                    (byte) 0xD8, // ## ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @836 'l' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @847 'm' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xB6, // # ## ##
                    (byte) 0xDB, // ## ## ##
                    (byte) 0xDB, // ## ## ##
                    (byte) 0xDB, // ## ## ##
                    (byte) 0xDB, // ## ## ##
                    (byte) 0xDB, // ## ## ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @858 'n' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @869 'o' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @880 'p' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xF8, // #####
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##

                    // @891 'q' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x7C, //  #####
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x7C, //  #####
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##

                    // @902 'r' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0xD0, // ## #
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @913 's' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0xC0, // ##
                    (byte) 0xE0, // ###
                    (byte) 0x70, //  ###
                    (byte) 0x30, //   ##
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @924 't' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0xF0, // ####
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @935 'u' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x7C, //  #####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @946 'v' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0x50, //  # #
                    (byte) 0x70, //  ###
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @957 'w' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC9, (byte) 0x80, // ##  #  ##
                    (byte) 0xDD, (byte) 0x80, // ## ### ##
                    (byte) 0x55, (byte) 0x00, //  # # # #
                    (byte) 0x77, (byte) 0x00, //  ### ###
                    (byte) 0x77, (byte) 0x00, //  ### ###
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @979 'x' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xCC, // ##  ##
                    (byte) 0x78, //  ####
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x78, //  ####
                    (byte) 0xCC, // ##  ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @990 'y' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0x48, //  #  #
                    (byte) 0x78, //  ####
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0xE0, // ###
                    (byte) 0xC0, // ##

                    // @1001 'z' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0xC0, // ##
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1012 '{' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x30, //   ##

                    // @1023 '|' (1 pixels wide)
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
                    (byte) 0x80, // #

                    // @1034 '}' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0xC0, // ##

                    // @1045 '~' (5 pixels wide)
                    (byte) 0x00, //
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
            };

    private static final CharInfo[] smallBoldFontDescriptors =
            {
                    new CharInfo(2, 0),        // !
                    new CharInfo(3, 11),        // "
                    new CharInfo(5, 22),        // #
                    new CharInfo(5, 33),        // $
                    new CharInfo(7, 44),        // %
                    new CharInfo(7, 55),        // &
                    new CharInfo(1, 66),        // '
                    new CharInfo(3, 77),        // (
                    new CharInfo(3, 88),        // )
                    new CharInfo(5, 99),        // *
                    new CharInfo(5, 110),        // +
                    new CharInfo(2, 121),        // ,
                    new CharInfo(3, 132),        // -
                    new CharInfo(2, 143),        // .
                    new CharInfo(4, 154),        // /
                    new CharInfo(5, 165),        // 0
                    new CharInfo(4, 176),        // 1
                    new CharInfo(5, 187),        // 2
                    new CharInfo(5, 198),        // 3
                    new CharInfo(6, 209),        // 4
                    new CharInfo(5, 220),        // 5
                    new CharInfo(5, 231),        // 6
                    new CharInfo(5, 242),        // 7
                    new CharInfo(5, 253),        // 8
                    new CharInfo(5, 264),        // 9
                    new CharInfo(2, 275),        // :
                    new CharInfo(2, 286),        // ;
                    new CharInfo(4, 297),        // <
                    new CharInfo(5, 308),        // =
                    new CharInfo(4, 319),        // >
                    new CharInfo(4, 330),        // ?
                    new CharInfo(7, 341),        // @
                    new CharInfo(7, 352),        // A
                    new CharInfo(6, 363),        // B
                    new CharInfo(6, 374),        // C
                    new CharInfo(6, 385),        // D
                    new CharInfo(5, 396),        // E
                    new CharInfo(5, 407),        // F
                    new CharInfo(6, 418),        // G
                    new CharInfo(7, 429),        // H
                    new CharInfo(2, 440),        // I
                    new CharInfo(5, 451),        // J
                    new CharInfo(6, 462),        // K
                    new CharInfo(5, 473),        // L
                    new CharInfo(7, 484),        // M
                    new CharInfo(6, 495),        // N
                    new CharInfo(7, 506),        // O
                    new CharInfo(5, 517),        // P
                    new CharInfo(8, 528),        // Q
                    new CharInfo(7, 539),        // R
                    new CharInfo(5, 550),        // S
                    new CharInfo(6, 561),        // T
                    new CharInfo(6, 572),        // U
                    new CharInfo(7, 583),        // V
                    new CharInfo(11, 594),        // W
                    new CharInfo(7, 616),        // X
                    new CharInfo(8, 627),        // Y
                    new CharInfo(6, 638),        // Z
                    new CharInfo(3, 649),        // [
                    new CharInfo(4, 660),        // \
                    new CharInfo(3, 671),        // ]
                    new CharInfo(5, 682),        // ^
                    new CharInfo(6, 693),        // _
                    new CharInfo(2, 704),        // `
                    new CharInfo(5, 715),        // a
                    new CharInfo(6, 726),        // b
                    new CharInfo(6, 737),        // c
                    new CharInfo(6, 748),        // d
                    new CharInfo(6, 759),        // e
                    new CharInfo(4, 770),        // f
                    new CharInfo(6, 781),        // g
                    new CharInfo(6, 792),        // h
                    new CharInfo(2, 803),        // i
                    new CharInfo(4, 814),        // j
                    new CharInfo(6, 825),        // k
                    new CharInfo(3, 836),        // l
                    new CharInfo(8, 847),        // m
                    new CharInfo(6, 858),        // n
                    new CharInfo(6, 869),        // o
                    new CharInfo(6, 880),        // p
                    new CharInfo(6, 891),        // q
                    new CharInfo(4, 902),        // r
                    new CharInfo(4, 913),        // s
                    new CharInfo(4, 924),        // t
                    new CharInfo(6, 935),        // u
                    new CharInfo(5, 946),        // v
                    new CharInfo(9, 957),        // w
                    new CharInfo(6, 979),        // x
                    new CharInfo(6, 990),        // y
                    new CharInfo(5, 1001),        // z
                    new CharInfo(4, 1012),        // {
                    new CharInfo(1, 1023),        // |
                    new CharInfo(4, 1034),        // }
                    new CharInfo(5, 1045)        // ~
            };

    private static final CharInfoLookup[] smallBoldFontBlockLookup =
            {
                    new CharInfoLookup('!', '~', smallBoldFontDescriptors)
            };

    private static final FontInfo smallBoldFontInfo = new FontInfo(
            11,
            '!',
            '~',
            1,
            2,
            smallBoldFontBlockLookup,
            smallBoldFontBitmaps
    );

    @Override
    public FontInfo getFontInfo() {
        return smallBoldFontInfo;
    }
}
