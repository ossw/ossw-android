package com.althink.android.ossw.emulator.fonts;

/**
 * Created by krzysiek on 05/07/15.
 */
public class NormalBold implements EmulatorFont {

    private static final byte[] normalBoldFontBitmaps =
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
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @16 '"' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xD8, // ## ##
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

                    // @32 '#' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x12, //    #  #
                    (byte) 0x12, //    #  #
                    (byte) 0x24, //   #  #
                    (byte) 0x7E, //  ######
                    (byte) 0x24, //   #  #
                    (byte) 0x68, //  ## #
                    (byte) 0x48, //  #  #
                    (byte) 0xFC, // ######
                    (byte) 0x48, //  #  #
                    (byte) 0x90, // #  #
                    (byte) 0x90, // #  #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @48 '$' (7 pixels wide)
                    (byte) 0x30, //   ##
                    (byte) 0x7C, //  #####
                    (byte) 0xFE, // #######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xE0, // ###
                    (byte) 0xF8, // #####
                    (byte) 0x3C, //   ####
                    (byte) 0x0E, //     ###
                    (byte) 0x06, //      ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFE, // #######
                    (byte) 0x78, //  ####
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @64 '%' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x61, (byte) 0x00, //  ##    #
                    (byte) 0x92, (byte) 0x00, // #  #  #
                    (byte) 0x92, (byte) 0x00, // #  #  #
                    (byte) 0x94, (byte) 0x00, // #  # #
                    (byte) 0x64, (byte) 0x00, //  ##  #
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x13, (byte) 0x00, //    #  ##
                    (byte) 0x14, (byte) 0x80, //    # #  #
                    (byte) 0x24, (byte) 0x80, //   #  #  #
                    (byte) 0x24, (byte) 0x80, //   #  #  #
                    (byte) 0x43, (byte) 0x00, //  #    ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @96 '&' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x78, (byte) 0x00, //  ####
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0xC2, (byte) 0x00, // ##    #
                    (byte) 0xC6, (byte) 0x00, // ##   ##
                    (byte) 0x7F, (byte) 0x80, //  ########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xC6, (byte) 0x00, // ##   ##
                    (byte) 0xC6, (byte) 0x00, // ##   ##
                    (byte) 0xC6, (byte) 0x00, // ##   ##
                    (byte) 0x7F, (byte) 0x80, //  ########
                    (byte) 0x7F, (byte) 0x80, //  ########
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @128 ''' (2 pixels wide)
                    (byte) 0x00, //
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
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @144 '(' (3 pixels wide)
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x60, //  ##
                    (byte) 0x40, //  #
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x60, //  ##
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #

                    // @160 ')' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x40, //  #
                    (byte) 0xC0, // ##
                    (byte) 0x80, // #
                    (byte) 0x80, // #

                    // @176 '*' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0xFC, // ######
                    (byte) 0x30, //   ##
                    (byte) 0x78, //  ####
                    (byte) 0x48, //  #  #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @192 '+' (7 pixels wide)
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
                    (byte) 0x00, //

                    // @208 ',' (2 pixels wide)
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
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x00, //

                    // @224 '-' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0xF0, // ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @240 '.' (2 pixels wide)
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

                    // @256 '/' (6 pixels wide)
                    (byte) 0x00, //
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @272 '0' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x3C, //   ####
                    (byte) 0x7E, //  ######
                    (byte) 0xE7, // ###  ###
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xE7, // ###  ###
                    (byte) 0x7E, //  ######
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @288 '1' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x70, //  ###
                    (byte) 0xF0, // ####
                    (byte) 0xB0, // # ##
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

                    // @304 '2' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0xFC, // ######
                    (byte) 0x4C, //  #  ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0xFE, // #######
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @320 '3' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0xFC, // ######
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x38, //   ###
                    (byte) 0x3C, //   ####
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0xFC, // ######
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @336 '4' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x02, //       #
                    (byte) 0x06, //      ##
                    (byte) 0x0E, //     ###
                    (byte) 0x1E, //    ####
                    (byte) 0x36, //   ## ##
                    (byte) 0x66, //  ##  ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @352 '5' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFC, // ######
                    (byte) 0xFE, // #######
                    (byte) 0x86, // #    ##
                    (byte) 0x06, //      ##
                    (byte) 0x46, //  #   ##
                    (byte) 0xFC, // ######
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @368 '6' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x08, //     #
                    (byte) 0x38, //   ###
                    (byte) 0x70, //  ###
                    (byte) 0x60, //  ##
                    (byte) 0xFC, // ######
                    (byte) 0xFE, // #######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x7C, //  #####
                    (byte) 0x38, //   ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @384 '7' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x02, //       #
                    (byte) 0x04, //      #
                    (byte) 0x0C, //     ##
                    (byte) 0x08, //     #
                    (byte) 0x18, //    ##
                    (byte) 0x10, //    #
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @400 '8' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x7C, //  #####
                    (byte) 0xFE, // #######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x7C, //  #####
                    (byte) 0x7C, //  #####
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFE, // #######
                    (byte) 0x7C, //  #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @416 '9' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x7C, //  #####
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x7E, //  ######
                    (byte) 0x3E, //   #####
                    (byte) 0x0C, //     ##
                    (byte) 0x1C, //    ###
                    (byte) 0x38, //   ###
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @432 ':' (2 pixels wide)
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
                    (byte) 0x00, //

                    // @448 ';' (2 pixels wide)
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
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x00, //

                    // @464 '<' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x04, //      #
                    (byte) 0x18, //    ##
                    (byte) 0x70, //  ###
                    (byte) 0xC0, // ##
                    (byte) 0x70, //  ###
                    (byte) 0x18, //    ##
                    (byte) 0x04, //      #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @480 '=' (7 pixels wide)
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

                    // @496 '>' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x60, //  ##
                    (byte) 0x38, //   ###
                    (byte) 0x0C, //     ##
                    (byte) 0x38, //   ###
                    (byte) 0x60, //  ##
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @512 '?' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0xF8, // #####
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x70, //  ###
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @528 '@' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x41, (byte) 0x00, //  #     #
                    (byte) 0x98, (byte) 0x80, // #  ##   #
                    (byte) 0x84, (byte) 0x80, // #    #  #
                    (byte) 0x9C, (byte) 0x80, // #  ###  #
                    (byte) 0xA4, (byte) 0x80, // # #  #  #
                    (byte) 0xA4, (byte) 0x80, // # #  #  #
                    (byte) 0x9F, (byte) 0x00, // #  #####
                    (byte) 0x40, (byte) 0x00, //  #
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @560 'A' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @592 'B' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0xFE, // #######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFC, // ######
                    (byte) 0xFE, // #######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFC, // ######
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @608 'C' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x3C, //   ####
                    (byte) 0x7E, //  ######
                    (byte) 0x60, //  ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x7E, //  ######
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @624 'D' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0xFE, // #######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFE, // #######
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @640 'E' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0xFE, // #######
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xF8, // #####
                    (byte) 0xF8, // #####
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFE, // #######
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @656 'F' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0xFE, // #######
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xF8, // #####
                    (byte) 0xF8, // #####
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @672 'G' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x1E, (byte) 0x00, //    ####
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0x70, (byte) 0x00, //  ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xC3, (byte) 0x80, // ##    ###
                    (byte) 0xC3, (byte) 0x80, // ##    ###
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0x61, (byte) 0x80, //  ##    ##
                    (byte) 0x7F, (byte) 0x80, //  ########
                    (byte) 0x1F, (byte) 0x00, //    #####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @704 'H' (8 pixels wide)
                    (byte) 0x00, //
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @720 'I' (2 pixels wide)
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @736 'J' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xF8, // #####
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @752 'K' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC6, (byte) 0x00, // ##   ##
                    (byte) 0xCC, (byte) 0x00, // ##  ##
                    (byte) 0xD8, (byte) 0x00, // ## ##
                    (byte) 0xF8, (byte) 0x00, // #####
                    (byte) 0xF8, (byte) 0x00, // #####
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0xCC, (byte) 0x00, // ##  ##
                    (byte) 0xC6, (byte) 0x00, // ##   ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @784 'L' (7 pixels wide)
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
                    (byte) 0xFE, // #######
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @800 'M' (11 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x20, (byte) 0x80, //   #     #
                    (byte) 0x20, (byte) 0x80, //   #     #
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x71, (byte) 0xC0, //  ###   ###
                    (byte) 0x71, (byte) 0xC0, //  ###   ###
                    (byte) 0x7B, (byte) 0xC0, //  #### ####
                    (byte) 0x7B, (byte) 0xC0, //  #### ####
                    (byte) 0x6A, (byte) 0xC0, //  ## # # ##
                    (byte) 0xCE, (byte) 0x60, // ##  ###  ##
                    (byte) 0xCE, (byte) 0x60, // ##  ###  ##
                    (byte) 0xC4, (byte) 0x60, // ##   #   ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @832 'N' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x83, // #     ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xE3, // ###   ##
                    (byte) 0xF3, // ####  ##
                    (byte) 0xF3, // ####  ##
                    (byte) 0xDB, // ## ## ##
                    (byte) 0xCF, // ##  ####
                    (byte) 0xCF, // ##  ####
                    (byte) 0xC7, // ##   ###
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC1, // ##     #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @848 'O' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @880 'P' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0xFE, // #######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFC, // ######
                    (byte) 0xF8, // #####
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @896 'Q' (11 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0x1E, (byte) 0x00, //    ####
                    (byte) 0x03, (byte) 0xE0, //       #####
                    (byte) 0x00, (byte) 0xE0, //         ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @928 'R' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0xFE, // #######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFC, // ######
                    (byte) 0xF8, // #####
                    (byte) 0xCC, // ##  ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @944 'S' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x3E, //   #####
                    (byte) 0xFE, // #######
                    (byte) 0xC0, // ##
                    (byte) 0xE0, // ###
                    (byte) 0x70, //  ###
                    (byte) 0x3C, //   ####
                    (byte) 0x0E, //     ###
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0xFC, // ######
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @960 'T' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @976 'U' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xE7, // ###  ###
                    (byte) 0x7E, //  ######
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @992 'V' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1024 'W' (13 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC2, (byte) 0x18, // ##    #    ##
                    (byte) 0xC7, (byte) 0x18, // ##   ###   ##
                    (byte) 0x67, (byte) 0x30, //  ##  ###  ##
                    (byte) 0x67, (byte) 0x30, //  ##  ###  ##
                    (byte) 0x6D, (byte) 0xB0, //  ## ## ## ##
                    (byte) 0x6D, (byte) 0xB0, //  ## ## ## ##
                    (byte) 0x2D, (byte) 0xA0, //   # ## ## #
                    (byte) 0x38, (byte) 0xE0, //   ###   ###
                    (byte) 0x38, (byte) 0xE0, //   ###   ###
                    (byte) 0x18, (byte) 0xC0, //    ##   ##
                    (byte) 0x10, (byte) 0x40, //    #     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1056 'X' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1088 'Y' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0x61, (byte) 0x80, //  ##    ##
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0x1E, (byte) 0x00, //    ####
                    (byte) 0x1E, (byte) 0x00, //    ####
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1120 'Z' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0x18, //    ##
                    (byte) 0x38, //   ###
                    (byte) 0x38, //   ###
                    (byte) 0x30, //   ##
                    (byte) 0x70, //  ###
                    (byte) 0x70, //  ###
                    (byte) 0x60, //  ##
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1136 '[' (4 pixels wide)
                    (byte) 0x00, //
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
                    (byte) 0xF0, // ####
                    (byte) 0xF0, // ####
                    (byte) 0x00, //

                    // @1152 '\' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x70, //  ###
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1168 ']' (4 pixels wide)
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
                    (byte) 0xF0, // ####
                    (byte) 0xF0, // ####
                    (byte) 0x00, //

                    // @1184 '^' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0x70, //  ###
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

                    // @1200 '_' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0x00, (byte) 0x00, //

                    // @1232 '`' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
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

                    // @1248 'a' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x7C, //  #####
                    (byte) 0x7E, //  ######
                    (byte) 0x06, //      ##
                    (byte) 0x7E, //  ######
                    (byte) 0xFE, // #######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFE, // #######
                    (byte) 0x7E, //  ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1264 'b' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xF8, // #####
                    (byte) 0xFC, // ######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFC, // ######
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1280 'c' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x3C, //   ####
                    (byte) 0x7E, //  ######
                    (byte) 0xE4, // ###  #
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xE4, // ###  #
                    (byte) 0x7E, //  ######
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1296 'd' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x3E, //   #####
                    (byte) 0x7E, //  ######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x7E, //  ######
                    (byte) 0x3E, //   #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1312 'e' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x3C, //   ####
                    (byte) 0x7E, //  ######
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0x7E, //  ######
                    (byte) 0x3E, //   #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1328 'f' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x3C, //   ####
                    (byte) 0x7C, //  #####
                    (byte) 0x60, //  ##
                    (byte) 0xF8, // #####
                    (byte) 0xF8, // #####
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1344 'g' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x7E, //  ######
                    (byte) 0xFE, // #######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFE, // #######
                    (byte) 0x7C, //  #####
                    (byte) 0xC0, // ##
                    (byte) 0xFC, // ######
                    (byte) 0xFE, // #######
                    (byte) 0x46, //  #   ##
                    (byte) 0xFE, // #######
                    (byte) 0x7C, //  #####
                    (byte) 0x00, //

                    // @1360 'h' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFC, // ######
                    (byte) 0xFE, // #######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1376 'i' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1392 'j' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x38, //   ###
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0xF8, // #####
                    (byte) 0xE0, // ###
                    (byte) 0x00, //

                    // @1408 'k' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xD8, // ## ##
                    (byte) 0xF0, // ####
                    (byte) 0xF0, // ####
                    (byte) 0xF8, // #####
                    (byte) 0xD8, // ## ##
                    (byte) 0xCC, // ##  ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1424 'l' (3 pixels wide)
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
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1440 'm' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFD, (byte) 0xE0, // ###### ####
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xC6, (byte) 0x30, // ##   ##   ##
                    (byte) 0xC6, (byte) 0x30, // ##   ##   ##
                    (byte) 0xC6, (byte) 0x30, // ##   ##   ##
                    (byte) 0xC6, (byte) 0x30, // ##   ##   ##
                    (byte) 0xC6, (byte) 0x30, // ##   ##   ##
                    (byte) 0xC6, (byte) 0x30, // ##   ##   ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1472 'n' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0xFE, // #######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1488 'o' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x7C, //  #####
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x7C, //  #####
                    (byte) 0x38, //   ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1504 'p' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0xFC, // ######
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFC, // ######
                    (byte) 0xF8, // #####
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //

                    // @1520 'q' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x3E, //   #####
                    (byte) 0x7E, //  ######
                    (byte) 0xE6, // ###  ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x7E, //  ######
                    (byte) 0x7E, //  ######
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x00, //

                    // @1536 'r' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0xF0, // ####
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

                    // @1552 's' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0xF8, // #####
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x38, //   ###
                    (byte) 0x18, //    ##
                    (byte) 0xF8, // #####
                    (byte) 0xF0, // ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1568 't' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0xF8, // #####
                    (byte) 0xF8, // #####
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x78, //  ####
                    (byte) 0x38, //   ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1584 'u' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFE, // #######
                    (byte) 0x7E, //  ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1600 'v' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1632 'w' (13 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE2, (byte) 0x38, // ###   #   ###
                    (byte) 0x67, (byte) 0x30, //  ##  ###  ##
                    (byte) 0x67, (byte) 0x30, //  ##  ###  ##
                    (byte) 0x6D, (byte) 0xB0, //  ## ## ## ##
                    (byte) 0x2D, (byte) 0xA0, //   # ## ## #
                    (byte) 0x38, (byte) 0xE0, //   ###   ###
                    (byte) 0x38, (byte) 0xE0, //   ###   ###
                    (byte) 0x10, (byte) 0x40, //    #     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1664 'x' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC6, // ##   ##
                    (byte) 0x6C, //  ## ##
                    (byte) 0x28, //   # #
                    (byte) 0x38, //   ###
                    (byte) 0x38, //   ###
                    (byte) 0x38, //   ###
                    (byte) 0x6C, //  ## ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1680 'y' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xC3, // ##    ##
                    (byte) 0x66, //  ##  ##
                    (byte) 0x66, //  ##  ##
                    (byte) 0x64, //  ##  #
                    (byte) 0x3C, //   ####
                    (byte) 0x3C, //   ####
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x10, //    #
                    (byte) 0x70, //  ###
                    (byte) 0x60, //  ##
                    (byte) 0x00, //

                    // @1696 'z' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0xFE, // #######
                    (byte) 0x0C, //     ##
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0xFE, // #######
                    (byte) 0xFE, // #######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1712 '{' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
                    (byte) 0x78, //  ####
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x78, //  ####
                    (byte) 0x38, //   ###
                    (byte) 0x00, //

                    // @1728 '|' (1 pixels wide)
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
                    (byte) 0x80, // #
                    (byte) 0x00, //

                    // @1744 '}' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0xE0, // ###
                    (byte) 0x00, //

                    // @1760 '~' (6 pixels wide)
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
            };

    private static final CharInfo[] normalBoldFontDescriptors =
            {
                    new CharInfo(2, 0),        // !
                    new CharInfo(5, 16),        // "
                    new CharInfo(7, 32),        // #
                    new CharInfo(7, 48),        // $
                    new CharInfo(9, 64),        // %
                    new CharInfo(9, 96),        // &
                    new CharInfo(2, 128),        // '
                    new CharInfo(3, 144),        // (
                    new CharInfo(3, 160),        // )
                    new CharInfo(6, 176),        // *
                    new CharInfo(7, 192),        // +
                    new CharInfo(2, 208),        // ,
                    new CharInfo(4, 224),        // -
                    new CharInfo(2, 240),        // .
                    new CharInfo(6, 256),        // /
                    new CharInfo(8, 272),        // 0
                    new CharInfo(4, 288),        // 1
                    new CharInfo(7, 304),        // 2
                    new CharInfo(6, 320),        // 3
                    new CharInfo(8, 336),        // 4
                    new CharInfo(7, 352),        // 5
                    new CharInfo(7, 368),        // 6
                    new CharInfo(8, 384),        // 7
                    new CharInfo(7, 400),        // 8
                    new CharInfo(7, 416),        // 9
                    new CharInfo(2, 432),        // :
                    new CharInfo(2, 448),        // ;
                    new CharInfo(6, 464),        // <
                    new CharInfo(7, 480),        // =
                    new CharInfo(6, 496),        // >
                    new CharInfo(5, 512),        // ?
                    new CharInfo(9, 528),        // @
                    new CharInfo(9, 560),        // A
                    new CharInfo(7, 592),        // B
                    new CharInfo(7, 608),        // C
                    new CharInfo(8, 624),        // D
                    new CharInfo(7, 640),        // E
                    new CharInfo(7, 656),        // F
                    new CharInfo(9, 672),        // G
                    new CharInfo(8, 704),        // H
                    new CharInfo(2, 720),        // I
                    new CharInfo(6, 736),        // J
                    new CharInfo(9, 752),        // K
                    new CharInfo(7, 784),        // L
                    new CharInfo(11, 800),        // M
                    new CharInfo(8, 832),        // N
                    new CharInfo(9, 848),        // O
                    new CharInfo(7, 880),        // P
                    new CharInfo(11, 896),        // Q
                    new CharInfo(8, 928),        // R
                    new CharInfo(7, 944),        // S
                    new CharInfo(8, 960),        // T
                    new CharInfo(8, 976),        // U
                    new CharInfo(9, 992),        // V
                    new CharInfo(13, 1024),        // W
                    new CharInfo(9, 1056),        // X
                    new CharInfo(10, 1088),        // Y
                    new CharInfo(6, 1120),        // Z
                    new CharInfo(4, 1136),        // [
                    new CharInfo(5, 1152),        // \
                    new CharInfo(4, 1168),        // ]
                    new CharInfo(5, 1184),        // ^
                    new CharInfo(9, 1200),        // _
                    new CharInfo(3, 1232),        // `
                    new CharInfo(7, 1248),        // a
                    new CharInfo(7, 1264),        // b
                    new CharInfo(7, 1280),        // c
                    new CharInfo(7, 1296),        // d
                    new CharInfo(8, 1312),        // e
                    new CharInfo(6, 1328),        // f
                    new CharInfo(7, 1344),        // g
                    new CharInfo(7, 1360),        // h
                    new CharInfo(3, 1376),        // i
                    new CharInfo(5, 1392),        // j
                    new CharInfo(7, 1408),        // k
                    new CharInfo(3, 1424),        // l
                    new CharInfo(12, 1440),        // m
                    new CharInfo(7, 1472),        // n
                    new CharInfo(7, 1488),        // o
                    new CharInfo(7, 1504),        // p
                    new CharInfo(7, 1520),        // q
                    new CharInfo(4, 1536),        // r
                    new CharInfo(5, 1552),        // s
                    new CharInfo(5, 1568),        // t
                    new CharInfo(7, 1584),        // u
                    new CharInfo(9, 1600),        // v
                    new CharInfo(13, 1632),        // w
                    new CharInfo(7, 1664),        // x
                    new CharInfo(8, 1680),        // y
                    new CharInfo(7, 1696),        // z
                    new CharInfo(5, 1712),        // {
                    new CharInfo(1, 1728),        // |
                    new CharInfo(5, 1744),        // }
                    new CharInfo(6, 1760)        // ~
            };

    private static final CharInfoLookup[] normalBoldFontBlockLookup =
            {
                    new CharInfoLookup('!', '~', normalBoldFontDescriptors)
            };

    private static final FontInfo normalBoldFontInfo = new FontInfo(
            16,
            '!',
            '~',
            1,
            2,
            normalBoldFontBlockLookup,
            normalBoldFontBitmaps
    );

    @Override
    public FontInfo getFontInfo() {
        return normalBoldFontInfo;
    }
}
