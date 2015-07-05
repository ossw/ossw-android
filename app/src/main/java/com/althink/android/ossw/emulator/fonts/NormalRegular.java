package com.althink.android.ossw.emulator.fonts;

/**
 * Created by krzysiek on 05/07/15.
 */
public class NormalRegular implements EmulatorFont {

    private static final byte[] smallRegularFontBitmaps =
            {
    /* @0 '!' (1 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
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
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @18 '"' (3 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xA0, // # #
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @36 '#' (9 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x09, (byte) 0x00, //     #  #
                    (byte) 0x09, (byte) 0x00, //     #  #
                    (byte) 0x12, (byte) 0x00, //    #  #
                    (byte) 0x7F, (byte) 0x80, //  ########
                    (byte) 0x12, (byte) 0x00, //    #  #
                    (byte) 0x24, (byte) 0x00, //   #  #
                    (byte) 0x24, (byte) 0x00, //   #  #
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0x24, (byte) 0x00, //   #  #
                    (byte) 0x48, (byte) 0x00, //  #  #
                    (byte) 0x48, (byte) 0x00, //  #  #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @72 '$' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x10, //    #
                    (byte) 0x7C, //  #####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x30, //   ##
                    (byte) 0x08, //     #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0xF8, // #####
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x00, //

	/* @90 '%' (9 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x60, (byte) 0x80, //  ##     #
                    (byte) 0x91, (byte) 0x00, // #  #   #
                    (byte) 0x92, (byte) 0x00, // #  #  #
                    (byte) 0x94, (byte) 0x00, // #  # #
                    (byte) 0x94, (byte) 0x00, // #  # #
                    (byte) 0x6B, (byte) 0x00, //  ## # ##
                    (byte) 0x14, (byte) 0x80, //    # #  #
                    (byte) 0x14, (byte) 0x80, //    # #  #
                    (byte) 0x24, (byte) 0x80, //   #  #  #
                    (byte) 0x44, (byte) 0x80, //  #   #  #
                    (byte) 0x83, (byte) 0x00, // #     ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @126 '&' (9 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x78, (byte) 0x00, //  ####
                    (byte) 0x88, (byte) 0x00, // #   #
                    (byte) 0x80, (byte) 0x00, // #
                    (byte) 0x84, (byte) 0x00, // #    #
                    (byte) 0x84, (byte) 0x00, // #    #
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0x84, (byte) 0x00, // #    #
                    (byte) 0x84, (byte) 0x00, // #    #
                    (byte) 0x84, (byte) 0x00, // #    #
                    (byte) 0x84, (byte) 0x00, // #    #
                    (byte) 0x84, (byte) 0x00, // #    #
                    (byte) 0x7B, (byte) 0x80, //  #### ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @162 ''' (1 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @180 '(' (3 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #

	/* @198 ')' (3 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x80, // #

	/* @216 '*' (5 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0xF8, // #####
                    (byte) 0x70, //  ###
                    (byte) 0x50, //  # #
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

	/* @234 '+' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0xFE, // #######
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @252 ',' (2 pixels wide) */
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x80, // #

	/* @270 '-' (4 pixels wide) */
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
                    (byte) 0xF0, // ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @288 '.' (2 pixels wide) */
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @306 '/' (5 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
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
                    (byte) 0x00, //

	/* @324 '0' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x44, //  #   #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x44, //  #   #
                    (byte) 0x38, //   ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @342 '1' (3 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0xA0, // # #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @360 '2' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x84, // #    #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @378 '3' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x84, // #    #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x08, //     #
                    (byte) 0x30, //   ##
                    (byte) 0x0C, //     ##
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x84, // #    #
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @396 '4' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x04, //      #
                    (byte) 0x0C, //     ##
                    (byte) 0x14, //    # #
                    (byte) 0x24, //   #  #
                    (byte) 0x24, //   #  #
                    (byte) 0x44, //  #   #
                    (byte) 0x84, // #    #
                    (byte) 0xFE, // #######
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @414 '5' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x88, // #   #
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @432 '6' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0xB0, // # ##
                    (byte) 0xC8, // ##  #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x48, //  #  #
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @450 '7' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @468 '8' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x68, //  ## #
                    (byte) 0x58, //  # ##
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @486 '9' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x48, //  #  #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x4C, //  #  ##
                    (byte) 0x34, //   ## #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @504 ':' (2 pixels wide) */
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @522 ';' (2 pixels wide) */
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x80, // #

	/* @540 '<' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x04, //      #
                    (byte) 0x18, //    ##
                    (byte) 0x60, //  ##
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x18, //    ##
                    (byte) 0x04, //      #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @558 '=' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @576 '>' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x60, //  ##
                    (byte) 0x18, //    ##
                    (byte) 0x0C, //     ##
                    (byte) 0x18, //    ##
                    (byte) 0x60, //  ##
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @594 '?' (4 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @612 '@' (10 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x1E, (byte) 0x00, //    ####
                    (byte) 0x21, (byte) 0x00, //   #    #
                    (byte) 0x40, (byte) 0x80, //  #      #
                    (byte) 0x8C, (byte) 0x80, // #   ##  #
                    (byte) 0x82, (byte) 0x40, // #     #  #
                    (byte) 0x8E, (byte) 0x40, // #   ###  #
                    (byte) 0x92, (byte) 0x40, // #  #  #  #
                    (byte) 0x92, (byte) 0x80, // #  #  # #
                    (byte) 0x9F, (byte) 0x80, // #  ######
                    (byte) 0x80, (byte) 0x00, // #
                    (byte) 0x41, (byte) 0x80, //  #     ##
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @648 'A' (9 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @684 'B' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0xF8, // #####
                    (byte) 0x84, // #    #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x84, // #    #
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @702 'C' (8 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x1E, //    ####
                    (byte) 0x21, //   #    #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x21, //   #    #
                    (byte) 0x1E, //    ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @720 'D' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x84, // #    #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x84, // #    #
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @738 'E' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xFC, // ######
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @756 'F' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xFC, // ######
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @774 'G' (8 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x1E, //    ####
                    (byte) 0x21, //   #    #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x87, // #    ###
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x41, //  #     #
                    (byte) 0x21, //   #    #
                    (byte) 0x1E, //    ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @792 'H' (8 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0xFF, // ########
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @810 'I' (1 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
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
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @828 'J' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x84, // #    #
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @846 'K' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x82, // #     #
                    (byte) 0x84, // #    #
                    (byte) 0x88, // #   #
                    (byte) 0x90, // #  #
                    (byte) 0xA0, // # #
                    (byte) 0xA0, // # #
                    (byte) 0xD0, // ## #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x84, // #    #
                    (byte) 0x82, // #     #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @864 'L' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
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
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @882 'M' (11 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x20, (byte) 0x80, //   #     #
                    (byte) 0x20, (byte) 0x80, //   #     #
                    (byte) 0x20, (byte) 0x80, //   #     #
                    (byte) 0x51, (byte) 0x40, //  # #   # #
                    (byte) 0x51, (byte) 0x40, //  # #   # #
                    (byte) 0x51, (byte) 0x40, //  # #   # #
                    (byte) 0x4A, (byte) 0x40, //  #  # #  #
                    (byte) 0x4A, (byte) 0x40, //  #  # #  #
                    (byte) 0x8A, (byte) 0x20, // #   # #   #
                    (byte) 0x84, (byte) 0x20, // #    #    #
                    (byte) 0x84, (byte) 0x20, // #    #    #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @918 'N' (8 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x81, // #      #
                    (byte) 0xC1, // ##     #
                    (byte) 0xA1, // # #    #
                    (byte) 0xA1, // # #    #
                    (byte) 0x91, // #  #   #
                    (byte) 0x89, // #   #  #
                    (byte) 0x89, // #   #  #
                    (byte) 0x85, // #    # #
                    (byte) 0x85, // #    # #
                    (byte) 0x83, // #     ##
                    (byte) 0x81, // #      #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @936 'O' (9 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @972 'P' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x84, // #    #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x84, // #    #
                    (byte) 0xF8, // #####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @990 'Q' (10 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x02, (byte) 0x00, //       #
                    (byte) 0x01, (byte) 0xC0, //        ###
                    (byte) 0x00, (byte) 0x00, //

	/* @1026 'R' (8 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x84, // #    #
                    (byte) 0xF8, // #####
                    (byte) 0x90, // #  #
                    (byte) 0x88, // #   #
                    (byte) 0x84, // #    #
                    (byte) 0x82, // #     #
                    (byte) 0x81, // #      #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1044 'S' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x30, //   ##
                    (byte) 0x08, //     #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1062 'T' (9 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @1098 'U' (8 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x42, //  #    #
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1116 'V' (9 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @1152 'W' (13 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x82, (byte) 0x08, // #     #     #
                    (byte) 0x82, (byte) 0x08, // #     #     #
                    (byte) 0x45, (byte) 0x10, //  #   # #   #
                    (byte) 0x45, (byte) 0x10, //  #   # #   #
                    (byte) 0x45, (byte) 0x10, //  #   # #   #
                    (byte) 0x28, (byte) 0xA0, //   # #   # #
                    (byte) 0x28, (byte) 0xA0, //   # #   # #
                    (byte) 0x28, (byte) 0xA0, //   # #   # #
                    (byte) 0x28, (byte) 0xC0, //   # #   ##
                    (byte) 0x10, (byte) 0x40, //    #     #
                    (byte) 0x10, (byte) 0x40, //    #     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @1188 'X' (9 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @1224 'Y' (9 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @1260 'Z' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1278 '[' (3 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
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
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xE0, // ###

	/* @1296 '\' (5 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x08, //     #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1314 ']' (3 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0xE0, // ###

	/* @1332 '^' (5 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0x50, //  # #
                    (byte) 0x50, //  # #
                    (byte) 0x88, // #   #
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
                    (byte) 0x00, //

	/* @1350 '_' (8 pixels wide) */
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0x00, //

	/* @1368 '`' (3 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x20, //   #
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1386 'a' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x84, // #    #
                    (byte) 0x04, //      #
                    (byte) 0x7C, //  #####
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x8C, // #   ##
                    (byte) 0x74, //  ### #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1404 'b' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xF8, // #####
                    (byte) 0x84, // #    #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x84, // #    #
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1422 'c' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
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
                    (byte) 0x00, //

	/* @1440 'd' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x02, //       #
                    (byte) 0x02, //       #
                    (byte) 0x02, //       #
                    (byte) 0x02, //       #
                    (byte) 0x3E, //   #####
                    (byte) 0x42, //  #    #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x42, //  #    #
                    (byte) 0x3E, //   #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1458 'e' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x44, //  #   #
                    (byte) 0x82, // #     #
                    (byte) 0xFE, // #######
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x42, //  #    #
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1476 'f' (5 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x18, //    ##
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0xF0, // ####
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1494 'g' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x7E, //  ######
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x78, //  ####
                    (byte) 0x80, // #
                    (byte) 0xFC, // ######
                    (byte) 0x02, //       #
                    (byte) 0x82, // #     #
                    (byte) 0x7C, //  #####

	/* @1512 'h' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xB8, // # ###
                    (byte) 0xC4, // ##   #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1530 'i' (2 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1548 'j' (4 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0xE0, // ###

	/* @1566 'k' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x88, // #   #
                    (byte) 0x90, // #  #
                    (byte) 0xA0, // # #
                    (byte) 0xA0, // # #
                    (byte) 0xD0, // ## #
                    (byte) 0x88, // #   #
                    (byte) 0x84, // #    #
                    (byte) 0x82, // #     #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1584 'l' (2 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
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
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1602 'm' (11 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xB9, (byte) 0xC0, // # ###  ###
                    (byte) 0xC6, (byte) 0x20, // ##   ##   #
                    (byte) 0x84, (byte) 0x20, // #    #    #
                    (byte) 0x84, (byte) 0x20, // #    #    #
                    (byte) 0x84, (byte) 0x20, // #    #    #
                    (byte) 0x84, (byte) 0x20, // #    #    #
                    (byte) 0x84, (byte) 0x20, // #    #    #
                    (byte) 0x84, (byte) 0x20, // #    #    #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @1638 'n' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xB8, // # ###
                    (byte) 0xC4, // ##   #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1656 'o' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
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
                    (byte) 0x00, //

	/* @1674 'p' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0x84, // #    #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x84, // #    #
                    (byte) 0xF8, // #####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #

	/* @1692 'q' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x3E, //   #####
                    (byte) 0x42, //  #    #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x82, // #     #
                    (byte) 0x42, //  #    #
                    (byte) 0x3E, //   #####
                    (byte) 0x02, //       #
                    (byte) 0x02, //       #
                    (byte) 0x02, //       #

	/* @1710 'r' (5 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xB8, // # ###
                    (byte) 0xC0, // ##
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1728 's' (4 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
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
                    (byte) 0x00, //

	/* @1746 't' (5 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0xF0, // ####
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x38, //   ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1764 'u' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x8C, // #   ##
                    (byte) 0x74, //  ### #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1782 'v' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
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
                    (byte) 0x00, //

	/* @1800 'w' (13 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x82, (byte) 0x08, // #     #     #
                    (byte) 0x45, (byte) 0x10, //  #   # #   #
                    (byte) 0x45, (byte) 0x10, //  #   # #   #
                    (byte) 0x45, (byte) 0x10, //  #   # #   #
                    (byte) 0x28, (byte) 0xA0, //   # #   # #
                    (byte) 0x28, (byte) 0xA0, //   # #   # #
                    (byte) 0x28, (byte) 0xA0, //   # #   # #
                    (byte) 0x10, (byte) 0x40, //    #     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @1836 'x' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x82, // #     #
                    (byte) 0x44, //  #   #
                    (byte) 0x28, //   # #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x28, //   # #
                    (byte) 0x44, //  #   #
                    (byte) 0x82, // #     #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1854 'y' (8 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x81, // #      #
                    (byte) 0x42, //  #    #
                    (byte) 0x42, //  #    #
                    (byte) 0x42, //  #    #
                    (byte) 0x24, //   #  #
                    (byte) 0x24, //   #  #
                    (byte) 0x18, //    ##
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x60, //  ##

	/* @1872 'z' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0x04, //      #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1890 '{' (4 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x30, //   ##

	/* @1908 '|' (1 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
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
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //

	/* @1926 '}' (4 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0xC0, // ##

	/* @1944 '~' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x64, //  ##  #
                    (byte) 0x98, // #  ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @1962 'Ó' (9 pixels wide) */
                    (byte) 0x06, (byte) 0x00, //      ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

	/* @1998 'ó' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x0C, //     ##
                    (byte) 0x18, //    ##
                    (byte) 0x10, //    #
                    (byte) 0x00, //
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
                    (byte) 0x00, //

	/* @2016 'A' (10 pixels wide) */
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x80, (byte) 0x80, // #       #
                    (byte) 0x01, (byte) 0x00, //        #
                    (byte) 0x01, (byte) 0x00, //        #
                    (byte) 0x00, (byte) 0xC0, //         ##

	/* @2052 'a' (8 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x84, // #    #
                    (byte) 0x04, //      #
                    (byte) 0x7C, //  #####
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x8C, // #   ##
                    (byte) 0x74, //  ### #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x03, //       ##

	/* @2070 'C' (8 pixels wide) */
                    (byte) 0x03, //       ##
                    (byte) 0x06, //      ##
                    (byte) 0x04, //      #
                    (byte) 0x00, //
                    (byte) 0x1E, //    ####
                    (byte) 0x21, //   #    #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x21, //   #    #
                    (byte) 0x1E, //    ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @2088 'c' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x06, //      ##
                    (byte) 0x0C, //     ##
                    (byte) 0x08, //     #
                    (byte) 0x00, //
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
                    (byte) 0x00, //

	/* @2106 'E' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xFC, // ######
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xFE, // #######
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x06, //      ##

	/* @2124 'e' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x44, //  #   #
                    (byte) 0x82, // #     #
                    (byte) 0xFE, // #######
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x42, //  #    #
                    (byte) 0x7C, //  #####
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x18, //    ##

	/* @2142 'L' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x60, //  ##
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x7E, //  ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @2160 'l' (3 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x60, //  ##
                    (byte) 0x40, //  #
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x20, //   #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @2178 'N' (8 pixels wide) */
                    (byte) 0x06, //      ##
                    (byte) 0x0C, //     ##
                    (byte) 0x08, //     #
                    (byte) 0x00, //
                    (byte) 0x81, // #      #
                    (byte) 0xC1, // ##     #
                    (byte) 0xA1, // # #    #
                    (byte) 0xA1, // # #    #
                    (byte) 0x91, // #  #   #
                    (byte) 0x89, // #   #  #
                    (byte) 0x89, // #   #  #
                    (byte) 0x85, // #    # #
                    (byte) 0x85, // #    # #
                    (byte) 0x83, // #     ##
                    (byte) 0x81, // #      #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @2196 'n' (6 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x0C, //     ##
                    (byte) 0x18, //    ##
                    (byte) 0x10, //    #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xB8, // # ###
                    (byte) 0xC4, // ##   #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @2214 'S' (6 pixels wide) */
                    (byte) 0x0C, //     ##
                    (byte) 0x18, //    ##
                    (byte) 0x10, //    #
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x30, //   ##
                    (byte) 0x08, //     #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @2232 's' (5 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x20, //   #
                    (byte) 0x00, //
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
                    (byte) 0x00, //

	/* @2250 'Z' (7 pixels wide) */
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x20, //   #
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @2268 'z' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x20, //   #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0x04, //      #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @2286 'Z' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

	/* @2304 'z' (7 pixels wide) */
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0x04, //      #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
            };

    private static final CharInfo[] smallRegularFontDescriptorsBlock0 =
            {
                    new CharInfo(1, 0), 		/* ! */
                    new CharInfo(3, 18), 		/* " */
                    new CharInfo(9, 36), 		/* # */
                    new CharInfo(6, 72), 		/* $ */
                    new CharInfo(9, 90), 		/* % */
                    new CharInfo(9, 126), 		/* & */
                    new CharInfo(1, 162), 		/* ' */
                    new CharInfo(3, 180), 		/* ( */
                    new CharInfo(3, 198), 		/* ) */
                    new CharInfo(5, 216), 		/* * */
                    new CharInfo(7, 234), 		/* + */
                    new CharInfo(2, 252), 		/* , */
                    new CharInfo(4, 270), 		/* - */
                    new CharInfo(2, 288), 		/* . */
                    new CharInfo(5, 306), 		/* / */
                    new CharInfo(7, 324), 		/* 0 */
                    new CharInfo(3, 342), 		/* 1 */
                    new CharInfo(6, 360), 		/* 2 */
                    new CharInfo(6, 378), 		/* 3 */
                    new CharInfo(7, 396), 		/* 4 */
                    new CharInfo(6, 414), 		/* 5 */
                    new CharInfo(6, 432), 		/* 6 */
                    new CharInfo(7, 450), 		/* 7 */
                    new CharInfo(6, 468), 		/* 8 */
                    new CharInfo(6, 486), 		/* 9 */
                    new CharInfo(2, 504), 		/* : */
                    new CharInfo(2, 522), 		/* ; */
                    new CharInfo(6, 540), 		/* < */
                    new CharInfo(7, 558), 		/* = */
                    new CharInfo(6, 576), 		/* > */
                    new CharInfo(4, 594), 		/* ? */
                    new CharInfo(10, 612), 		/* @ */
                    new CharInfo(9, 648), 		/* A */
                    new CharInfo(7, 684), 		/* B */
                    new CharInfo(8, 702), 		/* C */
                    new CharInfo(7, 720), 		/* D */
                    new CharInfo(7, 738), 		/* E */
                    new CharInfo(7, 756), 		/* F */
                    new CharInfo(8, 774), 		/* G */
                    new CharInfo(8, 792), 		/* H */
                    new CharInfo(1, 810), 		/* I */
                    new CharInfo(6, 828), 		/* J */
                    new CharInfo(7, 846), 		/* K */
                    new CharInfo(6, 864), 		/* L */
                    new CharInfo(11, 882), 		/* M */
                    new CharInfo(8, 918), 		/* N */
                    new CharInfo(9, 936), 		/* O */
                    new CharInfo(7, 972), 		/* P */
                    new CharInfo(10, 990), 		/* Q */
                    new CharInfo(8, 1026), 		/* R */
                    new CharInfo(6, 1044), 		/* S */
                    new CharInfo(9, 1062), 		/* T */
                    new CharInfo(8, 1098), 		/* U */
                    new CharInfo(9, 1116), 		/* V */
                    new CharInfo(13, 1152), 		/* W */
                    new CharInfo(9, 1188), 		/* X */
                    new CharInfo(9, 1224), 		/* Y */
                    new CharInfo(7, 1260), 		/* Z */
                    new CharInfo(3, 1278), 		/* [ */
                    new CharInfo(5, 1296), 		/* \ */
                    new CharInfo(3, 1314), 		/* ] */
                    new CharInfo(5, 1332), 		/* ^ */
                    new CharInfo(8, 1350), 		/* _ */
                    new CharInfo(3, 1368), 		/* ` */
                    new CharInfo(6, 1386), 		/* a */
                    new CharInfo(7, 1404), 		/* b */
                    new CharInfo(6, 1422), 		/* c */
                    new CharInfo(7, 1440), 		/* d */
                    new CharInfo(7, 1458), 		/* e */
                    new CharInfo(5, 1476), 		/* f */
                    new CharInfo(7, 1494), 		/* g */
                    new CharInfo(6, 1512), 		/* h */
                    new CharInfo(2, 1530), 		/* i */
                    new CharInfo(4, 1548), 		/* j */
                    new CharInfo(7, 1566), 		/* k */
                    new CharInfo(2, 1584), 		/* l */
                    new CharInfo(11, 1602), 		/* m */
                    new CharInfo(6, 1638), 		/* n */
                    new CharInfo(7, 1656), 		/* o */
                    new CharInfo(7, 1674), 		/* p */
                    new CharInfo(7, 1692), 		/* q */
                    new CharInfo(5, 1710), 		/* r */
                    new CharInfo(4, 1728), 		/* s */
                    new CharInfo(5, 1746), 		/* t */
                    new CharInfo(6, 1764), 		/* u */
                    new CharInfo(7, 1782), 		/* v */
                    new CharInfo(13, 1800), 		/* w */
                    new CharInfo(7, 1836), 		/* x */
                    new CharInfo(8, 1854), 		/* y */
                    new CharInfo(7, 1872), 		/* z */
                    new CharInfo(4, 1890), 		/* new CharInfo( */
                    new CharInfo(1, 1908), 		/* | */
                    new CharInfo(4, 1926), 		/* ) */
                    new CharInfo(6, 1944), 		/* ~ */
            };

    private static final CharInfo[] smallRegularFontDescriptorsBlock1 =
            {
                    new CharInfo(9, 1962), 		/* Ó */
                    new CharInfo(0, 0), 		/* Ô */
                    new CharInfo(0, 0), 		/* Õ */
                    new CharInfo(0, 0), 		/* Ö */
                    new CharInfo(0, 0), 		/* × */
                    new CharInfo(0, 0), 		/* Ø */
                    new CharInfo(0, 0), 		/* Ù */
                    new CharInfo(0, 0), 		/* Ú */
                    new CharInfo(0, 0), 		/* Û */
                    new CharInfo(0, 0), 		/* Ü */
                    new CharInfo(0, 0), 		/* Ý */
                    new CharInfo(0, 0), 		/* Þ */
                    new CharInfo(0, 0), 		/* ß */
                    new CharInfo(0, 0), 		/* à */
                    new CharInfo(0, 0), 		/* á */
                    new CharInfo(0, 0), 		/* â */
                    new CharInfo(0, 0), 		/* ã */
                    new CharInfo(0, 0), 		/* ä */
                    new CharInfo(0, 0), 		/* å */
                    new CharInfo(0, 0), 		/* æ */
                    new CharInfo(0, 0), 		/* ç */
                    new CharInfo(0, 0), 		/* è */
                    new CharInfo(0, 0), 		/* é */
                    new CharInfo(0, 0), 		/* ê */
                    new CharInfo(0, 0), 		/* ë */
                    new CharInfo(0, 0), 		/* ì */
                    new CharInfo(0, 0), 		/* í */
                    new CharInfo(0, 0), 		/* î */
                    new CharInfo(0, 0), 		/* ï */
                    new CharInfo(0, 0), 		/* ð */
                    new CharInfo(0, 0), 		/* ñ */
                    new CharInfo(0, 0), 		/* ò */
                    new CharInfo(7, 1998), 		/* ó */
                    new CharInfo(0, 0), 		/* ô */
                    new CharInfo(0, 0), 		/* õ */
                    new CharInfo(0, 0), 		/* ö */
                    new CharInfo(0, 0), 		/* ÷ */
                    new CharInfo(0, 0), 		/* ø */
                    new CharInfo(0, 0), 		/* ù */
                    new CharInfo(0, 0), 		/* ú */
                    new CharInfo(0, 0), 		/* û */
                    new CharInfo(0, 0), 		/* ü */
                    new CharInfo(0, 0), 		/* ý */
                    new CharInfo(0, 0), 		/* þ */
                    new CharInfo(0, 0), 		/* ÿ */
                    new CharInfo(0, 0), 		/* A */
                    new CharInfo(0, 0), 		/* a */
                    new CharInfo(0, 0), 		/* A */
                    new CharInfo(0, 0), 		/* a */
                    new CharInfo(10, 2016), 		/* A */
                    new CharInfo(8, 2052), 		/* a */
                    new CharInfo(8, 2070), 		/* C */
                    new CharInfo(7, 2088), 		/* c */
                    new CharInfo(0, 0), 		/* C */
                    new CharInfo(0, 0), 		/* c */
                    new CharInfo(0, 0), 		/* C */
                    new CharInfo(0, 0), 		/* c */
                    new CharInfo(0, 0), 		/* C */
                    new CharInfo(0, 0), 		/* c */
                    new CharInfo(0, 0), 		/* D */
                    new CharInfo(0, 0), 		/* d */
                    new CharInfo(0, 0), 		/* Ð */
                    new CharInfo(0, 0), 		/* d */
                    new CharInfo(0, 0), 		/* E */
                    new CharInfo(0, 0), 		/* e */
                    new CharInfo(0, 0), 		/* E */
                    new CharInfo(0, 0), 		/* e */
                    new CharInfo(0, 0), 		/* E */
                    new CharInfo(0, 0), 		/* e */
                    new CharInfo(7, 2106), 		/* E */
                    new CharInfo(7, 2124), 		/* e */
            };

    private static final CharInfo[] smallRegularFontDescriptorsBlock2 =
            {
                    new CharInfo(7, 2142), 		/* L */
                    new CharInfo(3, 2160), 		/* l */
                    new CharInfo(8, 2178), 		/* N */
                    new CharInfo(6, 2196), 		/* n */
                    new CharInfo(0, 0), 		/* N */
                    new CharInfo(0, 0), 		/* n */
                    new CharInfo(0, 0), 		/* N */
                    new CharInfo(0, 0), 		/* n */
                    new CharInfo(0, 0), 		/* ? */
                    new CharInfo(0, 0), 		/* ? */
                    new CharInfo(0, 0), 		/* ? */
                    new CharInfo(0, 0), 		/* O */
                    new CharInfo(0, 0), 		/* o */
                    new CharInfo(0, 0), 		/* O */
                    new CharInfo(0, 0), 		/* o */
                    new CharInfo(0, 0), 		/* O */
                    new CharInfo(0, 0), 		/* o */
                    new CharInfo(0, 0), 		/* Œ */
                    new CharInfo(0, 0), 		/* œ */
                    new CharInfo(0, 0), 		/* R */
                    new CharInfo(0, 0), 		/* r */
                    new CharInfo(0, 0), 		/* R */
                    new CharInfo(0, 0), 		/* r */
                    new CharInfo(0, 0), 		/* R */
                    new CharInfo(0, 0), 		/* r */
                    new CharInfo(6, 2214), 		/* S */
                    new CharInfo(5, 2232), 		/* s */
                    new CharInfo(0, 0), 		/* S */
                    new CharInfo(0, 0), 		/* s */
                    new CharInfo(0, 0), 		/* S */
                    new CharInfo(0, 0), 		/* s */
                    new CharInfo(0, 0), 		/* Š */
                    new CharInfo(0, 0), 		/* š */
                    new CharInfo(0, 0), 		/* T */
                    new CharInfo(0, 0), 		/* t */
                    new CharInfo(0, 0), 		/* T */
                    new CharInfo(0, 0), 		/* t */
                    new CharInfo(0, 0), 		/* T */
                    new CharInfo(0, 0), 		/* t */
                    new CharInfo(0, 0), 		/* U */
                    new CharInfo(0, 0), 		/* u */
                    new CharInfo(0, 0), 		/* U */
                    new CharInfo(0, 0), 		/* u */
                    new CharInfo(0, 0), 		/* U */
                    new CharInfo(0, 0), 		/* u */
                    new CharInfo(0, 0), 		/* U */
                    new CharInfo(0, 0), 		/* u */
                    new CharInfo(0, 0), 		/* U */
                    new CharInfo(0, 0), 		/* u */
                    new CharInfo(0, 0), 		/* U */
                    new CharInfo(0, 0), 		/* u */
                    new CharInfo(0, 0), 		/* W */
                    new CharInfo(0, 0), 		/* w */
                    new CharInfo(0, 0), 		/* Y */
                    new CharInfo(0, 0), 		/* y */
                    new CharInfo(0, 0), 		/* Ÿ */
                    new CharInfo(7, 2250), 		/* Z */
                    new CharInfo(7, 2268), 		/* z */
                    new CharInfo(7, 2286), 		/* Z */
                    new CharInfo(7, 2304), 		/* z */
            };

    private static final CharInfoLookup[] smallRegularFontBlockLookup =
            {
                    new CharInfoLookup('!', '~', smallRegularFontDescriptorsBlock0),
                    new CharInfoLookup('Ó', (char) 281, smallRegularFontDescriptorsBlock1),
                    new CharInfoLookup((char) 321, (char) 380, smallRegularFontDescriptorsBlock2),
            };

    private static final FontInfo smallRegularFontInfo = new FontInfo(
            18,
            '!',
            (char) 380,
            2,
            4,
            smallRegularFontBlockLookup,
            smallRegularFontBitmaps
    );

    @Override
    public FontInfo getFontInfo() {
        return smallRegularFontInfo;
    }
}
