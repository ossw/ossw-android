package com.althink.android.ossw.emulator.fonts;

/**
 * Created by krzysiek on 05/07/15.
 */
public class NormalBold implements EmulatorFont {

    private static final byte[] smallBoldFontBitmaps =
            {
	/* @0 '!' (2 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @18 '"' (5 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xD8, // ## ##
                    (byte)0xD8, // ## ##
                    (byte)0xD8, // ## ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @36 '#' (10 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x19, (byte)0x80, //    ##  ##
                    (byte)0x1B, (byte)0x80, //    ## ###
                    (byte)0x7F, (byte)0xC0, //  #########
                    (byte)0x7F, (byte)0xC0, //  #########
                    (byte)0x33, (byte)0x00, //   ##  ##
                    (byte)0x66, (byte)0x00, //  ##  ##
                    (byte)0xFF, (byte)0x80, // #########
                    (byte)0xFF, (byte)0x80, // #########
                    (byte)0x66, (byte)0x00, //  ##  ##
                    (byte)0xCC, (byte)0x00, // ##  ##
                    (byte)0xCC, (byte)0x00, // ##  ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @72 '$' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x30, //   ##
                    (byte)0x7C, //  #####
                    (byte)0xFE, // #######
                    (byte)0xCC, // ##  ##
                    (byte)0xE0, // ###
                    (byte)0xF8, // #####
                    (byte)0x3C, //   ####
                    (byte)0x0E, //     ###
                    (byte)0x06, //      ##
                    (byte)0xC6, // ##   ##
                    (byte)0xFE, // #######
                    (byte)0x78, //  ####
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x00, //

	/* @90 '%' (9 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x61, (byte)0x00, //  ##    #
                    (byte)0x92, (byte)0x00, // #  #  #
                    (byte)0x92, (byte)0x00, // #  #  #
                    (byte)0x94, (byte)0x00, // #  # #
                    (byte)0x64, (byte)0x00, //  ##  #
                    (byte)0x08, (byte)0x00, //     #
                    (byte)0x13, (byte)0x00, //    #  ##
                    (byte)0x14, (byte)0x80, //    # #  #
                    (byte)0x24, (byte)0x80, //   #  #  #
                    (byte)0x24, (byte)0x80, //   #  #  #
                    (byte)0x43, (byte)0x00, //  #    ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @126 '&' (9 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x78, (byte)0x00, //  ####
                    (byte)0xFC, (byte)0x00, // ######
                    (byte)0xC2, (byte)0x00, // ##    #
                    (byte)0xC6, (byte)0x00, // ##   ##
                    (byte)0x7F, (byte)0x80, //  ########
                    (byte)0xFF, (byte)0x80, // #########
                    (byte)0xC6, (byte)0x00, // ##   ##
                    (byte)0xC6, (byte)0x00, // ##   ##
                    (byte)0xC6, (byte)0x00, // ##   ##
                    (byte)0xE6, (byte)0x00, // ###  ##
                    (byte)0x7F, (byte)0x80, //  ########
                    (byte)0x3F, (byte)0x80, //   #######
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @162 ''' (2 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @180 '(' (4 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x10, //    #
                    (byte)0x30, //   ##
                    (byte)0x70, //  ###
                    (byte)0x60, //  ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x40, //  #
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x30, //   ##
                    (byte)0x10, //    #

	/* @198 ')' (4 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x80, // #
                    (byte)0xC0, // ##
                    (byte)0xE0, // ###
                    (byte)0x60, //  ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x20, //   #
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0xC0, // ##
                    (byte)0x80, // #

	/* @216 '*' (6 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0xFC, // ######
                    (byte)0x78, //  ####
                    (byte)0x78, //  ####
                    (byte)0x48, //  #  #
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @234 '+' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0xFF, // ########
                    (byte)0xFF, // ########
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @252 ',' (3 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x40, //  #
                    (byte)0x80, // #

	/* @270 '-' (4 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xF0, // ####
                    (byte)0xF0, // ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @288 '.' (2 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @306 '/' (6 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x0C, //     ##
                    (byte)0x1C, //    ###
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x38, //   ###
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0xC0, // ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @324 '0' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x3C, //   ####
                    (byte)0x7E, //  ######
                    (byte)0xE7, // ###  ###
                    (byte)0xC3, // ##    ##
                    (byte)0xC3, // ##    ##
                    (byte)0xC3, // ##    ##
                    (byte)0xC3, // ##    ##
                    (byte)0xC3, // ##    ##
                    (byte)0xE7, // ###  ###
                    (byte)0x7E, //  ######
                    (byte)0x3C, //   ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @342 '1' (4 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x30, //   ##
                    (byte)0x70, //  ###
                    (byte)0xF0, // ####
                    (byte)0xF0, // ####
                    (byte)0xB0, // # ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @360 '2' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x78, //  ####
                    (byte)0xFC, // ######
                    (byte)0x4C, //  #  ##
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0x18, //    ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x60, //  ##
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @378 '3' (6 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x78, //  ####
                    (byte)0xFC, // ######
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0x38, //   ###
                    (byte)0x3C, //   ####
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0xFC, // ######
                    (byte)0x78, //  ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @396 '4' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x0C, //     ##
                    (byte)0x1C, //    ###
                    (byte)0x1C, //    ###
                    (byte)0x3C, //   ####
                    (byte)0x6C, //  ## ##
                    (byte)0x4C, //  #  ##
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @414 '5' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFC, // ######
                    (byte)0xFC, // ######
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xFC, // ######
                    (byte)0xFE, // #######
                    (byte)0x86, // #    ##
                    (byte)0x06, //      ##
                    (byte)0x46, //  #   ##
                    (byte)0xFC, // ######
                    (byte)0x78, //  ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @432 '6' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x18, //    ##
                    (byte)0x30, //   ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0xFC, // ######
                    (byte)0xFE, // #######
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0x7C, //  #####
                    (byte)0x38, //   ###
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @450 '7' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFF, // ########
                    (byte)0xFF, // ########
                    (byte)0x06, //      ##
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x60, //  ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @468 '8' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x7C, //  #####
                    (byte)0xFE, // #######
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0x7C, //  #####
                    (byte)0x7C, //  #####
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xFE, // #######
                    (byte)0x7C, //  #####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @486 '9' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x38, //   ###
                    (byte)0x7C, //  #####
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0x7E, //  ######
                    (byte)0x3E, //   #####
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0x18, //    ##
                    (byte)0x30, //   ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @504 ':' (2 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @522 ';' (3 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x40, //  #
                    (byte)0x80, // #

	/* @540 '<' (5 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x08, //     #
                    (byte)0x38, //   ###
                    (byte)0x70, //  ###
                    (byte)0xC0, // ##
                    (byte)0x70, //  ###
                    (byte)0x38, //   ###
                    (byte)0x08, //     #
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @558 '=' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @576 '>' (6 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x80, // #
                    (byte)0xE0, // ###
                    (byte)0x78, //  ####
                    (byte)0x0C, //     ##
                    (byte)0x78, //  ####
                    (byte)0xE0, // ###
                    (byte)0x80, // #
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @594 '?' (5 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x70, //  ###
                    (byte)0xF8, // #####
                    (byte)0x98, // #  ##
                    (byte)0x18, //    ##
                    (byte)0x38, //   ###
                    (byte)0x30, //   ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x00, //
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @612 '@' (9 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x3E, (byte)0x00, //   #####
                    (byte)0x63, (byte)0x00, //  ##   ##
                    (byte)0x59, (byte)0x80, //  # ##  ##
                    (byte)0x94, (byte)0x80, // #  # #  #
                    (byte)0x9C, (byte)0x80, // #  ###  #
                    (byte)0xA4, (byte)0x80, // # #  #  #
                    (byte)0xA4, (byte)0x80, // # #  #  #
                    (byte)0xDF, (byte)0x00, // ## #####
                    (byte)0x62, (byte)0x00, //  ##   #
                    (byte)0x3C, (byte)0x00, //   ####
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @648 'A' (11 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x0E, (byte)0x00, //     ###
                    (byte)0x0E, (byte)0x00, //     ###
                    (byte)0x0E, (byte)0x00, //     ###
                    (byte)0x1B, (byte)0x00, //    ## ##
                    (byte)0x1B, (byte)0x00, //    ## ##
                    (byte)0x31, (byte)0x80, //   ##   ##
                    (byte)0x31, (byte)0x80, //   ##   ##
                    (byte)0x7F, (byte)0xC0, //  #########
                    (byte)0x7F, (byte)0xC0, //  #########
                    (byte)0x60, (byte)0xC0, //  ##     ##
                    (byte)0xC0, (byte)0x60, // ##       ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @684 'B' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFC, // ######
                    (byte)0xFE, // #######
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xFC, // ######
                    (byte)0xFE, // #######
                    (byte)0xC3, // ##    ##
                    (byte)0xC3, // ##    ##
                    (byte)0xC3, // ##    ##
                    (byte)0xFE, // #######
                    (byte)0xFC, // ######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @702 'C' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x3E, //   #####
                    (byte)0x7F, //  #######
                    (byte)0x62, //  ##   #
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x62, //  ##   #
                    (byte)0x7F, //  #######
                    (byte)0x3E, //   #####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @720 'D' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xF8, // #####
                    (byte)0xFE, // #######
                    (byte)0xC6, // ##   ##
                    (byte)0xC3, // ##    ##
                    (byte)0xC3, // ##    ##
                    (byte)0xC3, // ##    ##
                    (byte)0xC3, // ##    ##
                    (byte)0xC3, // ##    ##
                    (byte)0xC6, // ##   ##
                    (byte)0xFE, // #######
                    (byte)0xF8, // #####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @738 'E' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xF8, // #####
                    (byte)0xF8, // #####
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @756 'F' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xF8, // #####
                    (byte)0xF8, // #####
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @774 'G' (9 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x1E, (byte)0x00, //    ####
                    (byte)0x7F, (byte)0x00, //  #######
                    (byte)0x70, (byte)0x00, //  ###
                    (byte)0xE0, (byte)0x00, // ###
                    (byte)0xC7, (byte)0x80, // ##   ####
                    (byte)0xC7, (byte)0x80, // ##   ####
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0x61, (byte)0x80, //  ##    ##
                    (byte)0x7F, (byte)0x80, //  ########
                    (byte)0x1F, (byte)0x00, //    #####
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @810 'H' (9 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xFF, (byte)0x80, // #########
                    (byte)0xFF, (byte)0x80, // #########
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @846 'I' (2 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @864 'J' (6 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0x0C, //     ##
                    (byte)0xCC, // ##  ##
                    (byte)0xF8, // #####
                    (byte)0x78, //  ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @882 'K' (9 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0xC3, (byte)0x00, // ##    ##
                    (byte)0xC6, (byte)0x00, // ##   ##
                    (byte)0xCC, (byte)0x00, // ##  ##
                    (byte)0xD8, (byte)0x00, // ## ##
                    (byte)0xD8, (byte)0x00, // ## ##
                    (byte)0xF8, (byte)0x00, // #####
                    (byte)0xFC, (byte)0x00, // ######
                    (byte)0xCC, (byte)0x00, // ##  ##
                    (byte)0xC6, (byte)0x00, // ##   ##
                    (byte)0xC3, (byte)0x00, // ##    ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @918 'L' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @936 'M' (12 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x30, (byte)0xC0, //   ##    ##
                    (byte)0x30, (byte)0xC0, //   ##    ##
                    (byte)0x30, (byte)0xC0, //   ##    ##
                    (byte)0x39, (byte)0xC0, //   ###  ###
                    (byte)0x79, (byte)0xE0, //  ####  ####
                    (byte)0x69, (byte)0x60, //  ## #  # ##
                    (byte)0x6F, (byte)0x60, //  ## #### ##
                    (byte)0x6F, (byte)0x60, //  ## #### ##
                    (byte)0x66, (byte)0x60, //  ##  ##  ##
                    (byte)0xC6, (byte)0x30, // ##   ##   ##
                    (byte)0xC6, (byte)0x30, // ##   ##   ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @972 'N' (9 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0xE1, (byte)0x80, // ###    ##
                    (byte)0xE1, (byte)0x80, // ###    ##
                    (byte)0xF1, (byte)0x80, // ####   ##
                    (byte)0xF9, (byte)0x80, // #####  ##
                    (byte)0xD9, (byte)0x80, // ## ##  ##
                    (byte)0xCD, (byte)0x80, // ##  ## ##
                    (byte)0xCF, (byte)0x80, // ##  #####
                    (byte)0xC7, (byte)0x80, // ##   ####
                    (byte)0xC7, (byte)0x80, // ##   ####
                    (byte)0xC3, (byte)0x80, // ##    ###
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @1008 'O' (10 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x1E, (byte)0x00, //    ####
                    (byte)0x7F, (byte)0x80, //  ########
                    (byte)0x61, (byte)0x80, //  ##    ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0x61, (byte)0x80, //  ##    ##
                    (byte)0x7F, (byte)0x80, //  ########
                    (byte)0x3F, (byte)0x00, //   ######
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @1044 'P' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xF8, // #####
                    (byte)0xFE, // #######
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xFC, // ######
                    (byte)0xF8, // #####
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1062 'Q' (12 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x1E, (byte)0x00, //    ####
                    (byte)0x7F, (byte)0x80, //  ########
                    (byte)0x61, (byte)0x80, //  ##    ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0x61, (byte)0x80, //  ##    ##
                    (byte)0x7F, (byte)0x80, //  ########
                    (byte)0x1E, (byte)0x00, //    ####
                    (byte)0x01, (byte)0xF0, //        #####
                    (byte)0x00, (byte)0xF0, //         ####
                    (byte)0x00, (byte)0x00, //

	/* @1098 'R' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xF8, // #####
                    (byte)0xFE, // #######
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xFC, // ######
                    (byte)0xF8, // #####
                    (byte)0xCC, // ##  ##
                    (byte)0xCC, // ##  ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC3, // ##    ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1116 'S' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x7C, //  #####
                    (byte)0xFE, // #######
                    (byte)0xC4, // ##   #
                    (byte)0xE0, // ###
                    (byte)0x70, //  ###
                    (byte)0x3C, //   ####
                    (byte)0x0E, //     ###
                    (byte)0x06, //      ##
                    (byte)0x46, //  #   ##
                    (byte)0xFC, // ######
                    (byte)0x78, //  ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1134 'T' (10 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0xFF, (byte)0xC0, // ##########
                    (byte)0xFF, (byte)0xC0, // ##########
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @1170 'U' (9 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0xE3, (byte)0x80, // ###   ###
                    (byte)0x7F, (byte)0x00, //  #######
                    (byte)0x3E, (byte)0x00, //   #####
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @1206 'V' (10 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0x61, (byte)0x80, //  ##    ##
                    (byte)0x61, (byte)0x80, //  ##    ##
                    (byte)0x61, (byte)0x80, //  ##    ##
                    (byte)0x33, (byte)0x00, //   ##  ##
                    (byte)0x33, (byte)0x00, //   ##  ##
                    (byte)0x33, (byte)0x00, //   ##  ##
                    (byte)0x1E, (byte)0x00, //    ####
                    (byte)0x1E, (byte)0x00, //    ####
                    (byte)0x1E, (byte)0x00, //    ####
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @1242 'W' (14 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0xC3, (byte)0x0C, // ##    ##    ##
                    (byte)0xE3, (byte)0x1C, // ###   ##   ###
                    (byte)0x67, (byte)0x98, //  ##  ####  ##
                    (byte)0x67, (byte)0x98, //  ##  ####  ##
                    (byte)0x77, (byte)0xB8, //  ### #### ###
                    (byte)0x77, (byte)0xB8, //  ### #### ###
                    (byte)0x34, (byte)0xB0, //   ## #  # ##
                    (byte)0x3C, (byte)0xF0, //   ####  ####
                    (byte)0x3C, (byte)0xF0, //   ####  ####
                    (byte)0x18, (byte)0x60, //    ##    ##
                    (byte)0x18, (byte)0x60, //    ##    ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @1278 'X' (10 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0x61, (byte)0x80, //  ##    ##
                    (byte)0x33, (byte)0x00, //   ##  ##
                    (byte)0x1E, (byte)0x00, //    ####
                    (byte)0x1E, (byte)0x00, //    ####
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x1E, (byte)0x00, //    ####
                    (byte)0x3F, (byte)0x00, //   ######
                    (byte)0x33, (byte)0x00, //   ##  ##
                    (byte)0x61, (byte)0x80, //  ##    ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @1314 'Y' (10 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0x61, (byte)0x80, //  ##    ##
                    (byte)0x33, (byte)0x00, //   ##  ##
                    (byte)0x33, (byte)0x00, //   ##  ##
                    (byte)0x1E, (byte)0x00, //    ####
                    (byte)0x1E, (byte)0x00, //    ####
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @1350 'Z' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x0C, //     ##
                    (byte)0x1C, //    ###
                    (byte)0x18, //    ##
                    (byte)0x38, //   ###
                    (byte)0x30, //   ##
                    (byte)0x70, //  ###
                    (byte)0x60, //  ##
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1368 '[' (4 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xF0, // ####
                    (byte)0xF0, // ####
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xF0, // ####
                    (byte)0xF0, // ####

	/* @1386 '\' (6 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xE0, // ###
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x70, //  ###
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x0C, //     ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1404 ']' (4 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xF0, // ####
                    (byte)0xF0, // ####
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0xF0, // ####
                    (byte)0xF0, // ####

	/* @1422 '^' (6 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x30, //   ##
                    (byte)0x78, //  ####
                    (byte)0x78, //  ####
                    (byte)0xCC, // ##  ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1440 '_' (9 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0xFF, (byte)0x80, // #########
                    (byte)0xFF, (byte)0x80, // #########

	/* @1476 '`' (3 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0x60, //  ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1494 'a' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x7C, //  #####
                    (byte)0x7E, //  ######
                    (byte)0x06, //      ##
                    (byte)0x7E, //  ######
                    (byte)0xFE, // #######
                    (byte)0xC6, // ##   ##
                    (byte)0xFE, // #######
                    (byte)0x7E, //  ######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1512 'b' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xF8, // #####
                    (byte)0xFC, // ######
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xFC, // ######
                    (byte)0xB8, // # ###
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1530 'c' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x3C, //   ####
                    (byte)0x7E, //  ######
                    (byte)0xE4, // ###  #
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xE4, // ###  #
                    (byte)0x7E, //  ######
                    (byte)0x3C, //   ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1548 'd' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x06, //      ##
                    (byte)0x06, //      ##
                    (byte)0x06, //      ##
                    (byte)0x06, //      ##
                    (byte)0x3E, //   #####
                    (byte)0x7E, //  ######
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0x7E, //  ######
                    (byte)0x3E, //   #####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1566 'e' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x38, //   ###
                    (byte)0x7C, //  #####
                    (byte)0xC6, // ##   ##
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0xC0, // ##
                    (byte)0x7C, //  #####
                    (byte)0x3C, //   ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1584 'f' (6 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x1C, //    ###
                    (byte)0x3C, //   ####
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0xF8, // #####
                    (byte)0xF8, // #####
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1602 'g' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x7E, //  ######
                    (byte)0xFE, // #######
                    (byte)0xC6, // ##   ##
                    (byte)0xFE, // #######
                    (byte)0x7C, //  #####
                    (byte)0xC0, // ##
                    (byte)0xFE, // #######
                    (byte)0x7F, //  #######
                    (byte)0x43, //  #    ##
                    (byte)0xFF, // ########
                    (byte)0x7C, //  #####

	/* @1620 'h' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xFC, // ######
                    (byte)0xFE, // #######
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1638 'i' (3 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x00, //
                    (byte)0xE0, // ###
                    (byte)0xE0, // ###
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1656 'j' (5 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x00, //
                    (byte)0x78, //  ####
                    (byte)0x78, //  ####
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0xF8, // #####
                    (byte)0xE0, // ###

	/* @1674 'k' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC6, // ##   ##
                    (byte)0xCC, // ##  ##
                    (byte)0xD8, // ## ##
                    (byte)0xF8, // #####
                    (byte)0xF8, // #####
                    (byte)0xCC, // ##  ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC3, // ##    ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1692 'l' (3 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x60, //  ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1710 'm' (12 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0xFD, (byte)0xE0, // ###### ####
                    (byte)0xFF, (byte)0xF0, // ############
                    (byte)0xC6, (byte)0x30, // ##   ##   ##
                    (byte)0xC6, (byte)0x30, // ##   ##   ##
                    (byte)0xC6, (byte)0x30, // ##   ##   ##
                    (byte)0xC6, (byte)0x30, // ##   ##   ##
                    (byte)0xC6, (byte)0x30, // ##   ##   ##
                    (byte)0xC6, (byte)0x30, // ##   ##   ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @1746 'n' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFC, // ######
                    (byte)0xFE, // #######
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1764 'o' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x3C, //   ####
                    (byte)0x7E, //  ######
                    (byte)0xE7, // ###  ###
                    (byte)0xC3, // ##    ##
                    (byte)0xC3, // ##    ##
                    (byte)0xE7, // ###  ###
                    (byte)0x7E, //  ######
                    (byte)0x3C, //   ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1782 'p' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xF8, // #####
                    (byte)0xFC, // ######
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xFC, // ######
                    (byte)0xF8, // #####
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##

	/* @1800 'q' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x3E, //   #####
                    (byte)0x7E, //  ######
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0x7E, //  ######
                    (byte)0x3E, //   #####
                    (byte)0x06, //      ##
                    (byte)0x06, //      ##
                    (byte)0x06, //      ##

	/* @1818 'r' (5 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xF8, // #####
                    (byte)0xF8, // #####
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1836 's' (5 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x78, //  ####
                    (byte)0xF8, // #####
                    (byte)0xC0, // ##
                    (byte)0xF0, // ####
                    (byte)0x78, //  ####
                    (byte)0x18, //    ##
                    (byte)0xF8, // #####
                    (byte)0xF0, // ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1854 't' (4 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0xF0, // ####
                    (byte)0xF0, // ####
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x70, //  ###
                    (byte)0x30, //   ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1872 'u' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xFE, // #######
                    (byte)0x7E, //  ######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1890 'v' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC3, // ##    ##
                    (byte)0x66, //  ##  ##
                    (byte)0x66, //  ##  ##
                    (byte)0x66, //  ##  ##
                    (byte)0x3C, //   ####
                    (byte)0x3C, //   ####
                    (byte)0x3C, //   ####
                    (byte)0x18, //    ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1908 'w' (14 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0xE3, (byte)0x1C, // ###   ##   ###
                    (byte)0x63, (byte)0x18, //  ##   ##   ##
                    (byte)0x77, (byte)0xB8, //  ### #### ###
                    (byte)0x77, (byte)0xB8, //  ### #### ###
                    (byte)0x34, (byte)0xB0, //   ## #  # ##
                    (byte)0x3C, (byte)0xF0, //   ####  ####
                    (byte)0x3C, (byte)0xF0, //   ####  ####
                    (byte)0x18, (byte)0x60, //    ##    ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @1944 'x' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC3, // ##    ##
                    (byte)0x66, //  ##  ##
                    (byte)0x3C, //   ####
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x3C, //   ####
                    (byte)0x66, //  ##  ##
                    (byte)0xC3, // ##    ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1962 'y' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC3, // ##    ##
                    (byte)0x66, //  ##  ##
                    (byte)0x66, //  ##  ##
                    (byte)0x66, //  ##  ##
                    (byte)0x3C, //   ####
                    (byte)0x3C, //   ####
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x70, //  ###
                    (byte)0x60, //  ##

	/* @1980 'z' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x0C, //     ##
                    (byte)0x18, //    ##
                    (byte)0x30, //   ##
                    (byte)0x60, //  ##
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @1998 '{' (5 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x38, //   ###
                    (byte)0x78, //  ####
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x78, //  ####
                    (byte)0x38, //   ###

	/* @2016 '|' (2 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##

	/* @2034 '}' (6 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xF0, // ####
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x1C, //    ###
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x30, //   ##
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0xF0, // ####

	/* @2052 '~' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x66, //  ##  ##
                    (byte)0xDC, // ## ###
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @2070 'Ó' (10 pixels wide) */
                    (byte)0x03, (byte)0x00, //       ##
                    (byte)0x06, (byte)0x00, //      ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x1E, (byte)0x00, //    ####
                    (byte)0x7F, (byte)0x80, //  ########
                    (byte)0x61, (byte)0x80, //  ##    ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0xC0, (byte)0xC0, // ##      ##
                    (byte)0x61, (byte)0x80, //  ##    ##
                    (byte)0x7F, (byte)0x80, //  ########
                    (byte)0x3F, (byte)0x00, //   ######
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @2106 'ó' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x0C, //     ##
                    (byte)0x18, //    ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x3C, //   ####
                    (byte)0x7E, //  ######
                    (byte)0xE7, // ###  ###
                    (byte)0xC3, // ##    ##
                    (byte)0xC3, // ##    ##
                    (byte)0xE7, // ###  ###
                    (byte)0x7E, //  ######
                    (byte)0x3C, //   ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @2124 'A' (11 pixels wide) */
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x04, (byte)0x00, //      #
                    (byte)0x0E, (byte)0x00, //     ###
                    (byte)0x0E, (byte)0x00, //     ###
                    (byte)0x1B, (byte)0x00, //    ## ##
                    (byte)0x1B, (byte)0x00, //    ## ##
                    (byte)0x31, (byte)0x80, //   ##   ##
                    (byte)0x31, (byte)0x80, //   ##   ##
                    (byte)0x3F, (byte)0x80, //   #######
                    (byte)0x7F, (byte)0xC0, //  #########
                    (byte)0x60, (byte)0xC0, //  ##     ##
                    (byte)0xC0, (byte)0x60, // ##       ##
                    (byte)0x00, (byte)0x80, //         #
                    (byte)0x00, (byte)0x80, //         #
                    (byte)0x00, (byte)0xE0, //         ###

	/* @2160 'a' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x7C, //  #####
                    (byte)0x7E, //  ######
                    (byte)0x06, //      ##
                    (byte)0x7E, //  ######
                    (byte)0xFE, // #######
                    (byte)0xC6, // ##   ##
                    (byte)0xFE, // #######
                    (byte)0x7F, //  #######
                    (byte)0x04, //      #
                    (byte)0x04, //      #
                    (byte)0x07, //      ###

	/* @2178 'C' (8 pixels wide) */
                    (byte)0x06, //      ##
                    (byte)0x0C, //     ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x3E, //   #####
                    (byte)0x7F, //  #######
                    (byte)0x62, //  ##   #
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0x62, //  ##   #
                    (byte)0x7F, //  #######
                    (byte)0x3E, //   #####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @2196 'c' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x0C, //     ##
                    (byte)0x18, //    ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x3C, //   ####
                    (byte)0x7E, //  ######
                    (byte)0xE4, // ###  #
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xE4, // ###  #
                    (byte)0x7E, //  ######
                    (byte)0x3C, //   ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @2214 'E' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xF8, // #####
                    (byte)0xF8, // #####
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xC0, // ##
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x08, //     #
                    (byte)0x08, //     #
                    (byte)0x0E, //     ###

	/* @2232 'e' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x38, //   ###
                    (byte)0x7C, //  #####
                    (byte)0xC6, // ##   ##
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0xC0, // ##
                    (byte)0x7C, //  #####
                    (byte)0x3C, //   ####
                    (byte)0x10, //    #
                    (byte)0x10, //    #
                    (byte)0x1C, //    ###

	/* @2250 'L' (8 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x70, //  ###
                    (byte)0x60, //  ##
                    (byte)0xE0, // ###
                    (byte)0xE0, // ###
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x7F, //  #######
                    (byte)0x7F, //  #######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @2268 'l' (4 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x70, //  ###
                    (byte)0x70, //  ###
                    (byte)0xE0, // ###
                    (byte)0xE0, // ###
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x60, //  ##
                    (byte)0x30, //   ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @2286 'N' (9 pixels wide) */
                    (byte)0x06, (byte)0x00, //      ##
                    (byte)0x0C, (byte)0x00, //     ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0xE1, (byte)0x80, // ###    ##
                    (byte)0xE1, (byte)0x80, // ###    ##
                    (byte)0xF1, (byte)0x80, // ####   ##
                    (byte)0xF9, (byte)0x80, // #####  ##
                    (byte)0xD9, (byte)0x80, // ## ##  ##
                    (byte)0xCD, (byte)0x80, // ##  ## ##
                    (byte)0xCF, (byte)0x80, // ##  #####
                    (byte)0xC7, (byte)0x80, // ##   ####
                    (byte)0xC7, (byte)0x80, // ##   ####
                    (byte)0xC3, (byte)0x80, // ##    ###
                    (byte)0xC1, (byte)0x80, // ##     ##
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //
                    (byte)0x00, (byte)0x00, //

	/* @2322 'n' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x0C, //     ##
                    (byte)0x18, //    ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFC, // ######
                    (byte)0xFE, // #######
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0xC6, // ##   ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @2340 'S' (7 pixels wide) */
                    (byte)0x06, //      ##
                    (byte)0x0C, //     ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x7C, //  #####
                    (byte)0xFE, // #######
                    (byte)0xC4, // ##   #
                    (byte)0xE0, // ###
                    (byte)0x70, //  ###
                    (byte)0x3C, //   ####
                    (byte)0x0E, //     ###
                    (byte)0x06, //      ##
                    (byte)0x46, //  #   ##
                    (byte)0xFC, // ######
                    (byte)0x78, //  ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @2358 's' (5 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x18, //    ##
                    (byte)0x30, //   ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x78, //  ####
                    (byte)0xF8, // #####
                    (byte)0xC0, // ##
                    (byte)0xF0, // ####
                    (byte)0x78, //  ####
                    (byte)0x18, //    ##
                    (byte)0xF8, // #####
                    (byte)0xF0, // ####
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @2376 'Z' (7 pixels wide) */
                    (byte)0x18, //    ##
                    (byte)0x30, //   ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x0C, //     ##
                    (byte)0x1C, //    ###
                    (byte)0x18, //    ##
                    (byte)0x38, //   ###
                    (byte)0x30, //   ##
                    (byte)0x70, //  ###
                    (byte)0x60, //  ##
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @2394 'z' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x18, //    ##
                    (byte)0x30, //   ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x0C, //     ##
                    (byte)0x18, //    ##
                    (byte)0x30, //   ##
                    (byte)0x60, //  ##
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @2412 'Z' (7 pixels wide) */
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x0C, //     ##
                    (byte)0x1C, //    ###
                    (byte)0x18, //    ##
                    (byte)0x38, //   ###
                    (byte)0x30, //   ##
                    (byte)0x70, //  ###
                    (byte)0x60, //  ##
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //

	/* @2430 'z' (7 pixels wide) */
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x18, //    ##
                    (byte)0x18, //    ##
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x0C, //     ##
                    (byte)0x18, //    ##
                    (byte)0x30, //   ##
                    (byte)0x60, //  ##
                    (byte)0xFE, // #######
                    (byte)0xFE, // #######
                    (byte)0x00, //
                    (byte)0x00, //
                    (byte)0x00, //
            };

    private static final CharInfo[] smallBoldFontDescriptorsBlock0 =
            {
                    new CharInfo(2, 0), 		/* ! */
                    new CharInfo(5, 18), 		/* " */
                    new CharInfo(10, 36), 		/* # */
                    new CharInfo(7, 72), 		/* $ */
                    new CharInfo(9, 90), 		/* % */
                    new CharInfo(9, 126), 		/* & */
                    new CharInfo(2, 162), 		/* ' */
                    new CharInfo(4, 180), 		/* ( */
                    new CharInfo(4, 198), 		/* ) */
                    new CharInfo(6, 216), 		/* * */
                    new CharInfo(8, 234), 		/* + */
                    new CharInfo(3, 252), 		/* , */
                    new CharInfo(4, 270), 		/* - */
                    new CharInfo(2, 288), 		/* . */
                    new CharInfo(6, 306), 		/* / */
                    new CharInfo(8, 324), 		/* 0 */
                    new CharInfo(4, 342), 		/* 1 */
                    new CharInfo(7, 360), 		/* 2 */
                    new CharInfo(6, 378), 		/* 3 */
                    new CharInfo(7, 396), 		/* 4 */
                    new CharInfo(7, 414), 		/* 5 */
                    new CharInfo(7, 432), 		/* 6 */
                    new CharInfo(8, 450), 		/* 7 */
                    new CharInfo(7, 468), 		/* 8 */
                    new CharInfo(7, 486), 		/* 9 */
                    new CharInfo(2, 504), 		/* : */
                    new CharInfo(3, 522), 		/* ; */
                    new CharInfo(5, 540), 		/* < */
                    new CharInfo(7, 558), 		/* = */
                    new CharInfo(6, 576), 		/* > */
                    new CharInfo(5, 594), 		/* ? */
                    new CharInfo(9, 612), 		/* @ */
                    new CharInfo(11, 648), 		/* A */
                    new CharInfo(8, 684), 		/* B */
                    new CharInfo(8, 702), 		/* C */
                    new CharInfo(8, 720), 		/* D */
                    new CharInfo(7, 738), 		/* E */
                    new CharInfo(7, 756), 		/* F */
                    new CharInfo(9, 774), 		/* G */
                    new CharInfo(9, 810), 		/* H */
                    new CharInfo(2, 846), 		/* I */
                    new CharInfo(6, 864), 		/* J */
                    new CharInfo(9, 882), 		/* K */
                    new CharInfo(7, 918), 		/* L */
                    new CharInfo(12, 936), 		/* M */
                    new CharInfo(9, 972), 		/* N */
                    new CharInfo(10, 1008), 		/* O */
                    new CharInfo(7, 1044), 		/* P */
                    new CharInfo(12, 1062), 		/* Q */
                    new CharInfo(8, 1098), 		/* R */
                    new CharInfo(7, 1116), 		/* S */
                    new CharInfo(10, 1134), 		/* T */
                    new CharInfo(9, 1170), 		/* U */
                    new CharInfo(10, 1206), 		/* V */
                    new CharInfo(14, 1242), 		/* W */
                    new CharInfo(10, 1278), 		/* X */
                    new CharInfo(10, 1314), 		/* Y */
                    new CharInfo(7, 1350), 		/* Z */
                    new CharInfo(4, 1368), 		/* [ */
                    new CharInfo(6, 1386), 		/* \ */
                    new CharInfo(4, 1404), 		/* ] */
                    new CharInfo(6, 1422), 		/* ^ */
                    new CharInfo(9, 1440), 		/* _ */
                    new CharInfo(3, 1476), 		/* ` */
                    new CharInfo(7, 1494), 		/* a */
                    new CharInfo(7, 1512), 		/* b */
                    new CharInfo(7, 1530), 		/* c */
                    new CharInfo(7, 1548), 		/* d */
                    new CharInfo(7, 1566), 		/* e */
                    new CharInfo(6, 1584), 		/* f */
                    new CharInfo(8, 1602), 		/* g */
                    new CharInfo(7, 1620), 		/* h */
                    new CharInfo(3, 1638), 		/* i */
                    new CharInfo(5, 1656), 		/* j */
                    new CharInfo(8, 1674), 		/* k */
                    new CharInfo(3, 1692), 		/* l */
                    new CharInfo(12, 1710), 		/* m */
                    new CharInfo(7, 1746), 		/* n */
                    new CharInfo(8, 1764), 		/* o */
                    new CharInfo(7, 1782), 		/* p */
                    new CharInfo(7, 1800), 		/* q */
                    new CharInfo(5, 1818), 		/* r */
                    new CharInfo(5, 1836), 		/* s */
                    new CharInfo(4, 1854), 		/* t */
                    new CharInfo(7, 1872), 		/* u */
                    new CharInfo(8, 1890), 		/* v */
                    new CharInfo(14, 1908), 		/* w */
                    new CharInfo(8, 1944), 		/* x */
                    new CharInfo(8, 1962), 		/* y */
                    new CharInfo(7, 1980), 		/* z */
                    new CharInfo(5, 1998), 		/* new CharInfo( */
                    new CharInfo(2, 2016), 		/* | */
                    new CharInfo(6, 2034), 		/* ) */
                    new CharInfo(7, 2052), 		/* ~ */
            };

    private static final CharInfo[] smallBoldFontDescriptorsBlock1 =
            {
                    new CharInfo(10, 2070), 		/* Ó */
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
                    new CharInfo(8, 2106), 		/* ó */
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
                    new CharInfo(11, 2124), 		/* A */
                    new CharInfo(8, 2160), 		/* a */
                    new CharInfo(8, 2178), 		/* C */
                    new CharInfo(7, 2196), 		/* c */
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
                    new CharInfo(7, 2214), 		/* E */
                    new CharInfo(7, 2232), 		/* e */
            };

    private static final CharInfo[] smallBoldFontDescriptorsBlock2 =
            {
                    new CharInfo(8, 2250), 		/* L */
                    new CharInfo(4, 2268), 		/* l */
                    new CharInfo(9, 2286), 		/* N */
                    new CharInfo(7, 2322), 		/* n */
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
                    new CharInfo(7, 2340), 		/* S */
                    new CharInfo(5, 2358), 		/* s */
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
                    new CharInfo(7, 2376), 		/* Z */
                    new CharInfo(7, 2394), 		/* z */
                    new CharInfo(7, 2412), 		/* Z */
                    new CharInfo(7, 2430), 		/* z */
            };

    private static final CharInfoLookup[] smallBoldFontBlockLookup =
            {
                    new CharInfoLookup('!', '|', smallBoldFontDescriptorsBlock0),
                    new CharInfoLookup('Ó', (char)281, smallBoldFontDescriptorsBlock1),
                    new CharInfoLookup((char)321, (char)380, smallBoldFontDescriptorsBlock2)
            };

    private static final FontInfo smallBoldFontInfo = new FontInfo(
            18,
            '!',
            (char)380,
            2,
            5,
            smallBoldFontBlockLookup,
            smallBoldFontBitmaps
    );

    @Override
    public FontInfo getFontInfo() {
        return smallBoldFontInfo;
    }
}
