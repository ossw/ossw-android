package com.althink.android.ossw.emulator.fonts;

/**
 * Created by krzysiek on 05/07/15.
 */
public class OptionsNormal implements EmulatorFont {

    private static final byte[] optionNormalFontBitmaps =
            {
                    // @0 '!' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
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
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @18 '"' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
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

                    // @36 '#' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @72 '%' (18 pixels wide)
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFC, (byte) 0x30, (byte) 0x00, // ######    ##
                    (byte) 0xFC, (byte) 0x30, (byte) 0x00, // ######    ##
                    (byte) 0xCC, (byte) 0x30, (byte) 0x00, // ##  ##    ##
                    (byte) 0xCC, (byte) 0x30, (byte) 0x00, // ##  ##    ##
                    (byte) 0xFC, (byte) 0xC0, (byte) 0x00, // ######  ##
                    (byte) 0xFC, (byte) 0xC0, (byte) 0x00, // ######  ##
                    (byte) 0x00, (byte) 0xCF, (byte) 0xC0, //         ##  ######
                    (byte) 0x00, (byte) 0xCF, (byte) 0xC0, //         ##  ######
                    (byte) 0x03, (byte) 0x0C, (byte) 0xC0, //       ##    ##  ##
                    (byte) 0x03, (byte) 0x0C, (byte) 0xC0, //       ##    ##  ##
                    (byte) 0x03, (byte) 0x0F, (byte) 0xC0, //       ##    ######
                    (byte) 0x03, (byte) 0x0F, (byte) 0xC0, //       ##    ######
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //

                    // @126 ''' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
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

                    // @144 '(' (4 pixels wide)
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @162 ')' (4 pixels wide)
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @180 '*' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0x3F, (byte) 0x00, //   ######
                    (byte) 0x3F, (byte) 0x00, //   ######
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @216 '+' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @252 ',' (2 pixels wide)
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
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##

                    // @270 '-' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
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

                    // @288 '.' (2 pixels wide)
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
                    (byte) 0x00, //

                    // @306 '/' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @324 '0' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @342 '1' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0xF0, // ####
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @360 '2' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @378 '3' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x3F, //   ######
                    (byte) 0x3F, //   ######
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @396 '4' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @414 '5' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @432 '6' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @450 '7' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @468 '8' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @486 '9' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @504 ':' (2 pixels wide)
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @522 ';' (2 pixels wide)
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##

                    // @540 '<' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x03, (byte) 0xC0, //       ####
                    (byte) 0x03, (byte) 0xC0, //       ####
                    (byte) 0x3C, (byte) 0x00, //   ####
                    (byte) 0x3C, (byte) 0x00, //   ####
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0x3C, (byte) 0x00, //   ####
                    (byte) 0x3C, (byte) 0x00, //   ####
                    (byte) 0x03, (byte) 0xC0, //       ####
                    (byte) 0x03, (byte) 0xC0, //       ####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @576 '=' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @594 '>' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xF0, (byte) 0x00, // ####
                    (byte) 0xF0, (byte) 0x00, // ####
                    (byte) 0x0F, (byte) 0x00, //     ####
                    (byte) 0x0F, (byte) 0x00, //     ####
                    (byte) 0x00, (byte) 0xC0, //         ##
                    (byte) 0x00, (byte) 0xC0, //         ##
                    (byte) 0x0F, (byte) 0x00, //     ####
                    (byte) 0x0F, (byte) 0x00, //     ####
                    (byte) 0xF0, (byte) 0x00, // ####
                    (byte) 0xF0, (byte) 0x00, // ####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @630 '?' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x3F, //   ######
                    (byte) 0x3F, //   ######
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @648 '@' (14 pixels wide)
                    (byte) 0xFF, (byte) 0xFC, // ##############
                    (byte) 0xFF, (byte) 0xFC, // ##############
                    (byte) 0xC0, (byte) 0x0C, // ##          ##
                    (byte) 0xC0, (byte) 0x0C, // ##          ##
                    (byte) 0xCF, (byte) 0xCC, // ##  ######  ##
                    (byte) 0xCF, (byte) 0xCC, // ##  ######  ##
                    (byte) 0xCC, (byte) 0xCC, // ##  ##  ##  ##
                    (byte) 0xCC, (byte) 0xCC, // ##  ##  ##  ##
                    (byte) 0xCF, (byte) 0xFC, // ##  ##########
                    (byte) 0xCF, (byte) 0xFC, // ##  ##########
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xFF, (byte) 0xFC, // ##############
                    (byte) 0xFF, (byte) 0xFC, // ##############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @684 'A' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @702 'B' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @720 'C' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @738 'D' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @756 'E' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @774 'F' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @792 'G' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xCF, // ##  ####
                    (byte) 0xCF, // ##  ####
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @810 'H' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @828 'I' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
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
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @846 'J' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @864 'K' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @882 'L' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @900 'M' (14 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xFC, // ##############
                    (byte) 0xFF, (byte) 0xFC, // ##############
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @936 'N' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @954 'O' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @972 'P' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @990 'Q' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xCC, (byte) 0xC0, // ##  ##  ##
                    (byte) 0xCC, (byte) 0xC0, // ##  ##  ##
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1026 'R' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1044 'S' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1062 'T' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1098 'U' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1116 'V' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x3C, //   ####
                    (byte) 0x3C, //   ####
                    (byte) 0x3C, //   ####
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1134 'W' (14 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xFF, (byte) 0xFC, // ##############
                    (byte) 0xFF, (byte) 0xFC, // ##############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1170 'X' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x3C, //   ####
                    (byte) 0x3C, //   ####
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1188 'Y' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1224 'Z' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x3C, //   ####
                    (byte) 0x3C, //   ####
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1242 '[' (4 pixels wide)
                    (byte) 0xF0, // ####
                    (byte) 0xF0, // ####
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xF0, // ####
                    (byte) 0xF0, // ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1260 '\' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1278 ']' (4 pixels wide)
                    (byte) 0xF0, // ####
                    (byte) 0xF0, // ####
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0xF0, // ####
                    (byte) 0xF0, // ####
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1296 '^' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
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

                    // @1314 '_' (8 pixels wide)
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
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1332 '`' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
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

                    // @1350 'a' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1368 'b' (8 pixels wide)
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1386 'c' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1404 'd' (8 pixels wide)
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1422 'e' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1440 'f' (8 pixels wide)
                    (byte) 0x3F, //   ######
                    (byte) 0x3F, //   ######
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1458 'g' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########

                    // @1476 'h' (8 pixels wide)
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1494 'i' (2 pixels wide)
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
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
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1512 'j' (2 pixels wide)
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##

                    // @1530 'k' (8 pixels wide)
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1548 'l' (2 pixels wide)
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
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
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1566 'm' (14 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xFC, // ##############
                    (byte) 0xFF, (byte) 0xFC, // ##############
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1602 'n' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1620 'o' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1638 'p' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##

                    // @1656 'q' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##

                    // @1674 'r' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1692 's' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1710 't' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x3C, //   ####
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1728 'u' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1746 'v' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x3C, //   ####
                    (byte) 0x3C, //   ####
                    (byte) 0x3C, //   ####
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1764 'w' (14 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xC3, (byte) 0x0C, // ##    ##    ##
                    (byte) 0xFF, (byte) 0xFC, // ##############
                    (byte) 0xFF, (byte) 0xFC, // ##############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1800 'x' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x3C, //   ####
                    (byte) 0x3C, //   ####
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1818 'y' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##

                    // @1836 'z' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x3C, //   ####
                    (byte) 0x3C, //   ####
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1854 '|' (2 pixels wide)
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
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

                    // @1872 '&' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1908 '$' (8 pixels wide)
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //
            };

    private static final CharInfo[] optionNormalFontDescriptors =
            {
                    new CharInfo(2, 0),        // !
                    new CharInfo(6, 18),        // "
                    new CharInfo(10, 36),        // #
                    new CharInfo(8, 1908),        // $
                    new CharInfo(18, 72),        // %
                    new CharInfo(10, 1872),        // &
                    new CharInfo(2, 126),        // '
                    new CharInfo(4, 144),        // (
                    new CharInfo(4, 162),        // )
                    new CharInfo(10, 180),        // *
                    new CharInfo(10, 216),        // +
                    new CharInfo(2, 252),        // ,
                    new CharInfo(8, 270),        // -
                    new CharInfo(2, 288),        // .
                    new CharInfo(6, 306),        // /
                    new CharInfo(8, 324),        // 0
                    new CharInfo(4, 342),        // 1
                    new CharInfo(8, 360),        // 2
                    new CharInfo(8, 378),        // 3
                    new CharInfo(8, 396),        // 4
                    new CharInfo(8, 414),        // 5
                    new CharInfo(8, 432),        // 6
                    new CharInfo(8, 450),        // 7
                    new CharInfo(8, 468),        // 8
                    new CharInfo(8, 486),        // 9
                    new CharInfo(2, 504),        // :
                    new CharInfo(2, 522),        // ;
                    new CharInfo(10, 540),        // <
                    new CharInfo(8, 576),        // =
                    new CharInfo(10, 594),        // >
                    new CharInfo(8, 630),        // ?
                    new CharInfo(14, 648),        // @
                    new CharInfo(8, 684),        // A
                    new CharInfo(8, 702),        // B
                    new CharInfo(8, 720),        // C
                    new CharInfo(8, 738),        // D
                    new CharInfo(8, 756),        // E
                    new CharInfo(8, 774),        // F
                    new CharInfo(8, 792),        // G
                    new CharInfo(8, 810),        // H
                    new CharInfo(2, 828),        // I
                    new CharInfo(6, 846),        // J
                    new CharInfo(8, 864),        // K
                    new CharInfo(8, 882),        // L
                    new CharInfo(14, 900),        // M
                    new CharInfo(8, 936),        // N
                    new CharInfo(8, 954),        // O
                    new CharInfo(8, 972),        // P
                    new CharInfo(10, 990),        // Q
                    new CharInfo(8, 1026),        // R
                    new CharInfo(8, 1044),        // S
                    new CharInfo(10, 1062),        // T
                    new CharInfo(8, 1098),        // U
                    new CharInfo(8, 1116),        // V
                    new CharInfo(14, 1134),        // W
                    new CharInfo(8, 1170),        // X
                    new CharInfo(10, 1188),        // Y
                    new CharInfo(8, 1224),        // Z
                    new CharInfo(4, 1242),        // [
                    new CharInfo(6, 1260),        // \
                    new CharInfo(4, 1278),        // ]
                    new CharInfo(6, 1296),        // ^
                    new CharInfo(8, 1314),        // _
                    new CharInfo(2, 1332),        // `
                    new CharInfo(8, 1350),        // a
                    new CharInfo(8, 1368),        // b
                    new CharInfo(8, 1386),        // c
                    new CharInfo(8, 1404),        // d
                    new CharInfo(8, 1422),        // e
                    new CharInfo(8, 1440),        // f
                    new CharInfo(8, 1458),        // g
                    new CharInfo(8, 1476),        // h
                    new CharInfo(2, 1494),        // i
                    new CharInfo(2, 1512),        // j
                    new CharInfo(8, 1530),        // k
                    new CharInfo(2, 1548),        // l
                    new CharInfo(14, 1566),        // m
                    new CharInfo(8, 1602),        // n
                    new CharInfo(8, 1620),        // o
                    new CharInfo(8, 1638),        // p
                    new CharInfo(8, 1656),        // q
                    new CharInfo(8, 1674),        // r
                    new CharInfo(8, 1692),        // s
                    new CharInfo(6, 1710),        // t
                    new CharInfo(8, 1728),        // u
                    new CharInfo(8, 1746),        // v
                    new CharInfo(14, 1764),        // w
                    new CharInfo(8, 1800),        // x
                    new CharInfo(8, 1818),        // y
                    new CharInfo(8, 1836),        // z
                    new CharInfo(0, 0),        // new CharInfo(
                    new CharInfo(2, 1854),        // |
            };


    private static final CharInfoLookup[] optionNormalFontBlockLookup =
            {
                    new CharInfoLookup('!', '|', optionNormalFontDescriptors)
            };

    private static final FontInfo optionNormalFontInfo = new FontInfo(
            18,
            '!',
            '|',
            2,
            5,
            optionNormalFontBlockLookup,
            optionNormalFontBitmaps
    );

    @Override
    public FontInfo getFontInfo() {
        return optionNormalFontInfo;
    }
}
