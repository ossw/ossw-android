package com.althink.android.ossw.emulator.fonts;

/**
 * Created by krzysiek on 05/07/15.
 */
public class NormalRegular implements EmulatorFont {

    private static final byte[] normalRegularFontBitmaps =
            {
                    // @0 '!' (1 pixels wide)
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
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @15 '"' (3 pixels wide)
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

                    // @30 '#' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x09, (byte) 0x00, //     #  #
                    (byte) 0x09, (byte) 0x00, //     #  #
                    (byte) 0x12, (byte) 0x00, //    #  #
                    (byte) 0x7F, (byte) 0x80, //  ########
                    (byte) 0x12, (byte) 0x00, //    #  #
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x24, (byte) 0x00, //   #  #
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0x24, (byte) 0x00, //   #  #
                    (byte) 0x48, (byte) 0x00, //  #  #
                    (byte) 0x48, (byte) 0x00, //  #  #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @60 '$' (6 pixels wide)
                    (byte) 0x20, //   #
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
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x00, //

                    // @75 '%' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x61, //  ##    #
                    (byte) 0x92, // #  #  #
                    (byte) 0x94, // #  # #
                    (byte) 0x94, // #  # #
                    (byte) 0x68, //  ## #
                    (byte) 0x18, //    ##
                    (byte) 0x16, //    # ##
                    (byte) 0x29, //   # #  #
                    (byte) 0x29, //   # #  #
                    (byte) 0x49, //  #  #  #
                    (byte) 0x86, // #    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @90 '&' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x88, // #   #
                    (byte) 0x80, // #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x7F, //  #######
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x7B, //  #### ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @105 ''' (1 pixels wide)
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

                    // @120 '(' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
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
                    (byte) 0x40, //  #

                    // @135 ')' (2 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x80, // #

                    // @150 '*' (5 pixels wide)
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

                    // @165 '+' (7 pixels wide)
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

                    // @180 ',' (2 pixels wide)
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

                    // @195 '-' (4 pixels wide)
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

                    // @210 '.' (2 pixels wide)
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

                    // @225 '/' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
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

                    // @240 '0' (7 pixels wide)
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

                    // @255 '1' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0x60, //  ##
                    (byte) 0xA0, // # #
                    (byte) 0x20, //   #
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

                    // @270 '2' (6 pixels wide)
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

                    // @285 '3' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x84, // #    #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x08, //     #
                    (byte) 0x30, //   ##
                    (byte) 0x08, //     #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x84, // #    #
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @300 '4' (7 pixels wide)
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

                    // @315 '5' (6 pixels wide)
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

                    // @330 '6' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x48, //  #  #
                    (byte) 0x30, //   ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @345 '7' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0x04, //      #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @360 '8' (6 pixels wide)
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

                    // @375 '9' (6 pixels wide)
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

                    // @390 ':' (2 pixels wide)
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

                    // @405 ';' (2 pixels wide)
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

                    // @420 '<' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x04, //      #
                    (byte) 0x18, //    ##
                    (byte) 0x60, //  ##
                    (byte) 0x80, // #
                    (byte) 0x60, //  ##
                    (byte) 0x18, //    ##
                    (byte) 0x04, //      #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @435 '=' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @450 '>' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x60, //  ##
                    (byte) 0x18, //    ##
                    (byte) 0x04, //      #
                    (byte) 0x18, //    ##
                    (byte) 0x60, //  ##
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @465 '?' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
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

                    // @480 '@' (10 pixels wide)
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
                    (byte) 0x40, (byte) 0x00, //  #
                    (byte) 0x3F, (byte) 0x00, //   ######
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @510 'A' (9 pixels wide)
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

                    // @540 'B' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @555 'C' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x3C, //   ####
                    (byte) 0x42, //  #    #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x42, //  #    #
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @570 'D' (7 pixels wide)
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

                    // @585 'E' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xF8, // #####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @600 'F' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0xF8, // #####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @615 'G' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x1E, //    ####
                    (byte) 0x21, //   #    #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x87, // #    ###
                    (byte) 0x81, // #      #
                    (byte) 0x41, //  #     #
                    (byte) 0x21, //   #    #
                    (byte) 0x1E, //    ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @630 'H' (8 pixels wide)
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

                    // @645 'I' (1 pixels wide)
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

                    // @660 'J' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x88, // #   #
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @675 'K' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x82, // #     #
                    (byte) 0x84, // #    #
                    (byte) 0x88, // #   #
                    (byte) 0x88, // #   #
                    (byte) 0x90, // #  #
                    (byte) 0xA0, // # #
                    (byte) 0xD0, // ## #
                    (byte) 0x90, // #  #
                    (byte) 0x88, // #   #
                    (byte) 0x84, // #    #
                    (byte) 0x82, // #     #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @690 'L' (6 pixels wide)
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

                    // @705 'M' (11 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x20, (byte) 0x80, //   #     #
                    (byte) 0x20, (byte) 0x80, //   #     #
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x51, (byte) 0x40, //  # #   # #
                    (byte) 0x51, (byte) 0x40, //  # #   # #
                    (byte) 0x5B, (byte) 0x40, //  # ## ## #
                    (byte) 0x4A, (byte) 0x40, //  #  # #  #
                    (byte) 0x4A, (byte) 0x40, //  #  # #  #
                    (byte) 0x8A, (byte) 0x20, // #   # #   #
                    (byte) 0x84, (byte) 0x20, // #    #    #
                    (byte) 0x84, (byte) 0x20, // #    #    #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @735 'N' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x81, // #      #
                    (byte) 0xC1, // ##     #
                    (byte) 0xA1, // # #    #
                    (byte) 0xA1, // # #    #
                    (byte) 0x91, // #  #   #
                    (byte) 0x91, // #  #   #
                    (byte) 0x89, // #   #  #
                    (byte) 0x85, // #    # #
                    (byte) 0x85, // #    # #
                    (byte) 0x83, // #     ##
                    (byte) 0x81, // #      #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @750 'O' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x3C, //   ####
                    (byte) 0x42, //  #    #
                    (byte) 0x42, //  #    #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x81, // #      #
                    (byte) 0x42, //  #    #
                    (byte) 0x42, //  #    #
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @765 'P' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x88, // #   #
                    (byte) 0xF0, // ####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @780 'Q' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x3C, (byte) 0x00, //   ####
                    (byte) 0x42, (byte) 0x00, //  #    #
                    (byte) 0x42, (byte) 0x00, //  #    #
                    (byte) 0x81, (byte) 0x00, // #      #
                    (byte) 0x81, (byte) 0x00, // #      #
                    (byte) 0x81, (byte) 0x00, // #      #
                    (byte) 0x81, (byte) 0x00, // #      #
                    (byte) 0x81, (byte) 0x00, // #      #
                    (byte) 0x42, (byte) 0x00, //  #    #
                    (byte) 0x42, (byte) 0x00, //  #    #
                    (byte) 0x3C, (byte) 0x00, //   ####
                    (byte) 0x06, (byte) 0x00, //      ##
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x00, (byte) 0x00, //

                    // @810 'R' (8 pixels wide)
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

                    // @825 'S' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x20, //   #
                    (byte) 0x10, //    #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0xF0, // ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @840 'T' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFE, // #######
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @855 'U' (8 pixels wide)
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

                    // @870 'V' (9 pixels wide)
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

                    // @900 'W' (13 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x82, (byte) 0x08, // #     #     #
                    (byte) 0x82, (byte) 0x08, // #     #     #
                    (byte) 0x45, (byte) 0x10, //  #   # #   #
                    (byte) 0x45, (byte) 0x10, //  #   # #   #
                    (byte) 0x45, (byte) 0x10, //  #   # #   #
                    (byte) 0x68, (byte) 0xB0, //  ## #   # ##
                    (byte) 0x28, (byte) 0xA0, //   # #   # #
                    (byte) 0x28, (byte) 0xA0, //   # #   # #
                    (byte) 0x28, (byte) 0xA0, //   # #   # #
                    (byte) 0x10, (byte) 0x40, //    #     #
                    (byte) 0x10, (byte) 0x40, //    #     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @930 'X' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x81, // #      #
                    (byte) 0x42, //  #    #
                    (byte) 0x24, //   #  #
                    (byte) 0x24, //   #  #
                    (byte) 0x18, //    ##
                    (byte) 0x10, //    #
                    (byte) 0x18, //    ##
                    (byte) 0x24, //   #  #
                    (byte) 0x24, //   #  #
                    (byte) 0x42, //  #    #
                    (byte) 0x81, // #      #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @945 'Y' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x82, // #     #
                    (byte) 0x44, //  #   #
                    (byte) 0x44, //  #   #
                    (byte) 0x28, //   # #
                    (byte) 0x28, //   # #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @960 'Z' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0x08, //     #
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x80, // #
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @975 '[' (3 pixels wide)
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
                    (byte) 0xE0, // ###

                    // @990 '\' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x20, //   #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x08, //     #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1005 ']' (3 pixels wide)
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
                    (byte) 0xE0, // ###

                    // @1020 '^' (5 pixels wide)
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

                    // @1035 '_' (8 pixels wide)
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

                    // @1050 '`' (2 pixels wide)
                    (byte) 0x00, //
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1065 'a' (6 pixels wide)
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

                    // @1080 'b' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
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
                    (byte) 0x00, //

                    // @1095 'c' (6 pixels wide)
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

                    // @1110 'd' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x3C, //   ####
                    (byte) 0x44, //  #   #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x44, //  #   #
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1125 'e' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x30, //   ##
                    (byte) 0x48, //  #  #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0xFC, // ######
                    (byte) 0x80, // #
                    (byte) 0x44, //  #   #
                    (byte) 0x38, //   ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1140 'f' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x38, //   ###
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

                    // @1155 'g' (7 pixels wide)
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

                    // @1170 'h' (6 pixels wide)
                    (byte) 0x00, //
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

                    // @1185 'i' (2 pixels wide)
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

                    // @1200 'j' (4 pixels wide)
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

                    // @1215 'k' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x88, // #   #
                    (byte) 0x90, // #  #
                    (byte) 0xA0, // # #
                    (byte) 0xC0, // ##
                    (byte) 0xE0, // ###
                    (byte) 0x90, // #  #
                    (byte) 0x88, // #   #
                    (byte) 0x84, // #    #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1230 'l' (2 pixels wide)
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
                    (byte) 0x40, //  #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1245 'm' (11 pixels wide)
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

                    // @1275 'n' (6 pixels wide)
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

                    // @1290 'o' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1305 'p' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0x88, // #   #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x88, // #   #
                    (byte) 0xF0, // ####
                    (byte) 0x80, // #
                    (byte) 0x80, // #
                    (byte) 0x80, // #

                    // @1320 'q' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x3C, //   ####
                    (byte) 0x44, //  #   #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x84, // #    #
                    (byte) 0x44, //  #   #
                    (byte) 0x3C, //   ####
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #
                    (byte) 0x04, //      #

                    // @1335 'r' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xB0, // # ##
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

                    // @1350 's' (4 pixels wide)
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

                    // @1365 't' (5 pixels wide)
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

                    // @1380 'u' (6 pixels wide)
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

                    // @1395 'v' (7 pixels wide)
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

                    // @1410 'w' (11 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x84, (byte) 0x20, // #    #    #
                    (byte) 0x44, (byte) 0x40, //  #   #   #
                    (byte) 0x4A, (byte) 0x40, //  #  # #  #
                    (byte) 0x4A, (byte) 0x40, //  #  # #  #
                    (byte) 0x2A, (byte) 0x80, //   # # # #
                    (byte) 0x2A, (byte) 0x80, //   # # # #
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x11, (byte) 0x00, //    #   #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1440 'x' (7 pixels wide)
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

                    // @1455 'y' (7 pixels wide)
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
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x60, //  ##

                    // @1470 'z' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0x08, //     #
                    (byte) 0x10, //    #
                    (byte) 0x10, //    #
                    (byte) 0x20, //   #
                    (byte) 0x40, //  #
                    (byte) 0x40, //  #
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1485 '{' (4 pixels wide)
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

                    // @1500 '|' (1 pixels wide)
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
                    (byte) 0x00, //

                    // @1515 '}' (4 pixels wide)
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

                    // @1530 '~' (6 pixels wide)
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

    private static final CharInfo[] normalRegularFontDescriptors =
            {
                    new CharInfo(1, 0),        // !
                    new CharInfo(3, 15),        // "
                    new CharInfo(9, 30),        // #
                    new CharInfo(6, 60),        // $
                    new CharInfo(8, 75),        // %
                    new CharInfo(8, 90),        // &
                    new CharInfo(1, 105),        // '
                    new CharInfo(2, 120),        // (
                    new CharInfo(2, 135),        // )
                    new CharInfo(5, 150),        // *
                    new CharInfo(7, 165),        // +
                    new CharInfo(2, 180),        // ,
                    new CharInfo(4, 195),        // -
                    new CharInfo(2, 210),        // .
                    new CharInfo(5, 225),        // /
                    new CharInfo(7, 240),        // 0
                    new CharInfo(3, 255),        // 1
                    new CharInfo(6, 270),        // 2
                    new CharInfo(6, 285),        // 3
                    new CharInfo(7, 300),        // 4
                    new CharInfo(6, 315),        // 5
                    new CharInfo(6, 330),        // 6
                    new CharInfo(6, 345),        // 7
                    new CharInfo(6, 360),        // 8
                    new CharInfo(6, 375),        // 9
                    new CharInfo(2, 390),        // :
                    new CharInfo(2, 405),        // ;
                    new CharInfo(6, 420),        // <
                    new CharInfo(6, 435),        // =
                    new CharInfo(6, 450),        // >
                    new CharInfo(4, 465),        // ?
                    new CharInfo(10, 480),        // @
                    new CharInfo(9, 510),        // A
                    new CharInfo(6, 540),        // B
                    new CharInfo(7, 555),        // C
                    new CharInfo(7, 570),        // D
                    new CharInfo(6, 585),        // E
                    new CharInfo(6, 600),        // F
                    new CharInfo(8, 615),        // G
                    new CharInfo(8, 630),        // H
                    new CharInfo(1, 645),        // I
                    new CharInfo(5, 660),        // J
                    new CharInfo(7, 675),        // K
                    new CharInfo(6, 690),        // L
                    new CharInfo(11, 705),        // M
                    new CharInfo(8, 735),        // N
                    new CharInfo(8, 750),        // O
                    new CharInfo(6, 765),        // P
                    new CharInfo(9, 780),        // Q
                    new CharInfo(8, 810),        // R
                    new CharInfo(5, 825),        // S
                    new CharInfo(7, 840),        // T
                    new CharInfo(8, 855),        // U
                    new CharInfo(9, 870),        // V
                    new CharInfo(13, 900),        // W
                    new CharInfo(8, 930),        // X
                    new CharInfo(7, 945),        // Y
                    new CharInfo(6, 960),        // Z
                    new CharInfo(3, 975),        // [
                    new CharInfo(5, 990),        // \
                    new CharInfo(3, 1005),        // ]
                    new CharInfo(5, 1020),        // ^
                    new CharInfo(8, 1035),        // _
                    new CharInfo(2, 1050),        // `
                    new CharInfo(6, 1065),        // a
                    new CharInfo(6, 1080),        // b
                    new CharInfo(6, 1095),        // c
                    new CharInfo(6, 1110),        // d
                    new CharInfo(6, 1125),        // e
                    new CharInfo(5, 1140),        // f
                    new CharInfo(7, 1155),        // g
                    new CharInfo(6, 1170),        // h
                    new CharInfo(2, 1185),        // i
                    new CharInfo(4, 1200),        // j
                    new CharInfo(6, 1215),        // k
                    new CharInfo(2, 1230),        // l
                    new CharInfo(11, 1245),        // m
                    new CharInfo(6, 1275),        // n
                    new CharInfo(6, 1290),        // o
                    new CharInfo(6, 1305),        // p
                    new CharInfo(6, 1320),        // q
                    new CharInfo(4, 1335),        // r
                    new CharInfo(4, 1350),        // s
                    new CharInfo(5, 1365),        // t
                    new CharInfo(6, 1380),        // u
                    new CharInfo(7, 1395),        // v
                    new CharInfo(11, 1410),        // w
                    new CharInfo(7, 1440),        // x
                    new CharInfo(7, 1455),        // y
                    new CharInfo(6, 1470),        // z
                    new CharInfo(4, 1485),        // {
                    new CharInfo(1, 1500),        // |
                    new CharInfo(4, 1515),        // }
                    new CharInfo(6, 1530)        // ~
            };

    private static final CharInfoLookup[] normalRegularFontBlockLookup =
            {
                    new CharInfoLookup('!', '~', normalRegularFontDescriptors)
            };

    private static final FontInfo smallRegularFontInfo = new FontInfo(
            15,
            '!',
            '~',
            1,
            2,
            normalRegularFontBlockLookup,
            normalRegularFontBitmaps
    );

    @Override
    public FontInfo getFontInfo() {
        return smallRegularFontInfo;
    }
}
