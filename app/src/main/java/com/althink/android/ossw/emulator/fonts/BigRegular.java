package com.althink.android.ossw.emulator.fonts;

/**
 * Created by krzysiek on 05/07/15.
 */
public class BigRegular implements EmulatorFont {

    private static final byte[] bigRegularFontBitmaps =
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
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @19 '"' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xD8, // ## ##
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
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @38 '#' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x08, (byte) 0x80, //     #   #
                    (byte) 0x08, (byte) 0x80, //     #   #
                    (byte) 0x11, (byte) 0x00, //    #   #
                    (byte) 0x11, (byte) 0x00, //    #   #
                    (byte) 0x7F, (byte) 0xC0, //  #########
                    (byte) 0x21, (byte) 0x00, //   #    #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0x22, (byte) 0x00, //   #   #
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0x44, (byte) 0x00, //  #   #
                    (byte) 0x44, (byte) 0x00, //  #   #
                    (byte) 0x88, (byte) 0x00, // #   #
                    (byte) 0x88, (byte) 0x00, // #   #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @76 '$' (8 pixels wide)
                    (byte) 0x18, //    ##
                    (byte) 0x3E, //   #####
                    (byte) 0x7E, //  ######
                    (byte) 0xE0, // ###
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xE0, // ###
                    (byte) 0x78, //  ####
                    (byte) 0x1E, //    ####
                    (byte) 0x07, //      ###
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x47, //  #   ###
                    (byte) 0xFE, // #######
                    (byte) 0x7C, //  #####
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @95 '%' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x71, (byte) 0x00, //  ###   #
                    (byte) 0x8A, (byte) 0x00, // #   # #
                    (byte) 0x8A, (byte) 0x00, // #   # #
                    (byte) 0x8C, (byte) 0x00, // #   ##
                    (byte) 0x8C, (byte) 0x00, // #   ##
                    (byte) 0x78, (byte) 0x00, //  ####
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x10, (byte) 0x00, //    #
                    (byte) 0x17, (byte) 0x00, //    # ###
                    (byte) 0x28, (byte) 0x80, //   # #   #
                    (byte) 0x28, (byte) 0x80, //   # #   #
                    (byte) 0x48, (byte) 0x80, //  #  #   #
                    (byte) 0x48, (byte) 0x80, //  #  #   #
                    (byte) 0x87, (byte) 0x00, // #    ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @133 '&' (11 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x3C, (byte) 0x00, //   ####
                    (byte) 0x7E, (byte) 0x00, //  ######
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0x7F, (byte) 0xC0, //  #########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xE3, (byte) 0x00, // ###   ##
                    (byte) 0x7F, (byte) 0xE0, //  ##########
                    (byte) 0x3C, (byte) 0xC0, //   ####  ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @171 ''' (2 pixels wide)
                    (byte) 0x00, //
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @190 '(' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x10, //    #
                    (byte) 0x30, //   ##
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
                    (byte) 0x30, //   ##
                    (byte) 0x10, //    #

                    // @209 ')' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0xC0, // ##
                    (byte) 0x40, //  #
                    (byte) 0x60, //  ##
                    (byte) 0x20, //   #
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x20, //   #
                    (byte) 0x60, //  ##
                    (byte) 0x40, //  #
                    (byte) 0xC0, // ##
                    (byte) 0x80, // #

                    // @228 '*' (6 pixels wide)
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @247 '+' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @266 ',' (4 pixels wide)
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
                    (byte) 0x70, //  ###
                    (byte) 0x70, //  ###
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x80, // #
                    (byte) 0x00, //

                    // @285 '-' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xF8, // #####
                    (byte) 0xF8, // #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @304 '.' (3 pixels wide)
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
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @323 '/' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x06, //      ##
                    (byte) 0x0C, //     ##
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @342 '0' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x3C, //   ####
                    (byte) 0x7E, //  ######
                    (byte) 0x66, //  ##  ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x66, //  ##  ##
                    (byte) 0x7E, //  ######
                    (byte) 0x3C, //   ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @361 '1' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x08, //     #
                    (byte) 0x18, //    ##
                    (byte) 0x78, //  ####
                    (byte) 0xF8, // #####
                    (byte) 0x98, // #  ##
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

                    // @380 '2' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0xFE, // #######
                    (byte) 0x86, // #    ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x7F, //  #######
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @399 '3' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x7C, //  #####
                    (byte) 0xFE, // #######
                    (byte) 0x47, //  #   ###
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x06, //      ##
                    (byte) 0x1C, //    ###
                    (byte) 0x1E, //    ####
                    (byte) 0x07, //      ###
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x47, //  #   ###
                    (byte) 0xFE, // #######
                    (byte) 0x7C, //  #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @418 '4' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x80, //         #
                    (byte) 0x01, (byte) 0x80, //        ##
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x07, (byte) 0x80, //      ####
                    (byte) 0x0D, (byte) 0x80, //     ## ##
                    (byte) 0x19, (byte) 0x80, //    ##  ##
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x61, (byte) 0x80, //  ##    ##
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0x01, (byte) 0x80, //        ##
                    (byte) 0x01, (byte) 0x80, //        ##
                    (byte) 0x01, (byte) 0x80, //        ##
                    (byte) 0x01, (byte) 0x80, //        ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @456 '5' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xF8, // #####
                    (byte) 0xFC, // ######
                    (byte) 0x8E, // #   ###
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x4E, //  #  ###
                    (byte) 0xFC, // ######
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @475 '6' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x06, (byte) 0x00, //      ##
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x38, (byte) 0x00, //   ###
                    (byte) 0x30, (byte) 0x00, //   ##
                    (byte) 0x60, (byte) 0x00, //  ##
                    (byte) 0x5E, (byte) 0x00, //  # ####
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0x63, (byte) 0x80, //  ##   ###
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @513 '7' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0x03, (byte) 0x00, //       ##
                    (byte) 0x07, (byte) 0x00, //      ###
                    (byte) 0x06, (byte) 0x00, //      ##
                    (byte) 0x0E, (byte) 0x00, //     ###
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x18, (byte) 0x00, //    ##
                    (byte) 0x18, (byte) 0x00, //    ##
                    (byte) 0x30, (byte) 0x00, //   ##
                    (byte) 0x30, (byte) 0x00, //   ##
                    (byte) 0x70, (byte) 0x00, //  ###
                    (byte) 0x60, (byte) 0x00, //  ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @551 '8' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x3C, //   ####
                    (byte) 0x7E, //  ######
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0xC3, // ##    ##
                    (byte) 0x76, //  ### ##
                    (byte) 0x3C, //   ####
                    (byte) 0x66, //  ##  ##
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

                    // @570 '9' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0xE3, (byte) 0x00, // ###   ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0x7F, (byte) 0x80, //  ########
                    (byte) 0x3D, (byte) 0x00, //   #### #
                    (byte) 0x03, (byte) 0x00, //       ##
                    (byte) 0x06, (byte) 0x00, //      ##
                    (byte) 0x0E, (byte) 0x00, //     ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x30, (byte) 0x00, //   ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @608 ':' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @627 ';' (4 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x70, //  ###
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x70, //  ###
                    (byte) 0x70, //  ###
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x80, // #
                    (byte) 0x00, //

                    // @646 '<' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x02, //       #
                    (byte) 0x1E, //    ####
                    (byte) 0x78, //  ####
                    (byte) 0xC0, // ##
                    (byte) 0x78, //  ####
                    (byte) 0x1E, //    ####
                    (byte) 0x02, //       #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @665 '=' (8 pixels wide)
                    (byte) 0x00, //
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

                    // @684 '>' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x80, // #
                    (byte) 0xF0, // ####
                    (byte) 0x3C, //   ####
                    (byte) 0x06, //      ##
                    (byte) 0x3C, //   ####
                    (byte) 0xF0, // ####
                    (byte) 0x80, // #
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @703 '?' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0xFC, // ######
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @722 '@' (11 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x1F, (byte) 0x00, //    #####
                    (byte) 0x20, (byte) 0x80, //   #     #
                    (byte) 0x40, (byte) 0x40, //  #       #
                    (byte) 0x8C, (byte) 0x40, // #   ##   #
                    (byte) 0x82, (byte) 0x20, // #     #   #
                    (byte) 0x8E, (byte) 0x20, // #   ###   #
                    (byte) 0x92, (byte) 0x20, // #  #  #   #
                    (byte) 0x92, (byte) 0x20, // #  #  #   #
                    (byte) 0x92, (byte) 0x40, // #  #  #  #
                    (byte) 0x8D, (byte) 0xC0, // #   ## ###
                    (byte) 0x40, (byte) 0x00, //  #
                    (byte) 0x20, (byte) 0x00, //   #
                    (byte) 0x1F, (byte) 0xC0, //    #######
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @760 'A' (11 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x04, (byte) 0x00, //      #
                    (byte) 0x0E, (byte) 0x00, //     ###
                    (byte) 0x0E, (byte) 0x00, //     ###
                    (byte) 0x0A, (byte) 0x00, //     # #
                    (byte) 0x1B, (byte) 0x00, //    ## ##
                    (byte) 0x1B, (byte) 0x00, //    ## ##
                    (byte) 0x11, (byte) 0x00, //    #   #
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x3F, (byte) 0x80, //   #######
                    (byte) 0x7F, (byte) 0xC0, //  #########
                    (byte) 0x60, (byte) 0xC0, //  ##     ##
                    (byte) 0x60, (byte) 0xC0, //  ##     ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @798 'B' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFE, (byte) 0x00, // #######
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC7, (byte) 0x00, // ##   ###
                    (byte) 0xFE, (byte) 0x00, // #######
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xC3, (byte) 0x80, // ##    ###
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC3, (byte) 0x80, // ##    ###
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xFE, (byte) 0x00, // #######
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @836 'C' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x1F, (byte) 0x00, //    #####
                    (byte) 0x3F, (byte) 0x80, //   #######
                    (byte) 0x71, (byte) 0x80, //  ###   ##
                    (byte) 0x60, (byte) 0x00, //  ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0x60, (byte) 0x00, //  ##
                    (byte) 0x71, (byte) 0x80, //  ###   ##
                    (byte) 0x3F, (byte) 0x80, //   #######
                    (byte) 0x1E, (byte) 0x00, //    ####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @874 'D' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xC3, (byte) 0x80, // ##    ###
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC1, (byte) 0xC0, // ##     ###
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC3, (byte) 0x80, // ##    ###
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @912 'E' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xFE, // #######
                    (byte) 0xFE, // #######
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

                    // @931 'F' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xFE, (byte) 0x00, // #######
                    (byte) 0xFE, (byte) 0x00, // #######
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @969 'G' (11 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x0F, (byte) 0x80, //     #####
                    (byte) 0x3F, (byte) 0xC0, //   ########
                    (byte) 0x70, (byte) 0x00, //  ###
                    (byte) 0x60, (byte) 0x00, //  ##
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC1, (byte) 0xE0, // ##     ####
                    (byte) 0xC1, (byte) 0xE0, // ##     ####
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0x60, (byte) 0x60, //  ##      ##
                    (byte) 0x70, (byte) 0x60, //  ###     ##
                    (byte) 0x3F, (byte) 0xE0, //   #########
                    (byte) 0x0F, (byte) 0x80, //     #####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1007 'H' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1045 'I' (2 pixels wide)
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1064 'J' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFC, // ######
                    (byte) 0x78, //  ####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1083 'K' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC6, (byte) 0x00, // ##   ##
                    (byte) 0xC6, (byte) 0x00, // ##   ##
                    (byte) 0xCC, (byte) 0x00, // ##  ##
                    (byte) 0xD8, (byte) 0x00, // ## ##
                    (byte) 0xD8, (byte) 0x00, // ## ##
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0xEE, (byte) 0x00, // ### ###
                    (byte) 0xC6, (byte) 0x00, // ##   ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1121 'L' (8 pixels wide)
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
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1140 'M' (15 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x10, (byte) 0x10, //    #       #
                    (byte) 0x18, (byte) 0x30, //    ##     ##
                    (byte) 0x38, (byte) 0x38, //   ###     ###
                    (byte) 0x38, (byte) 0x38, //   ###     ###
                    (byte) 0x3C, (byte) 0x78, //   ####   ####
                    (byte) 0x2C, (byte) 0x68, //   # ##   ## #
                    (byte) 0x2C, (byte) 0x68, //   # ##   ## #
                    (byte) 0x6E, (byte) 0xEC, //  ## ### ### ##
                    (byte) 0x66, (byte) 0xCC, //  ##  ## ##  ##
                    (byte) 0x66, (byte) 0xCC, //  ##  ## ##  ##
                    (byte) 0x63, (byte) 0x8C, //  ##   ###   ##
                    (byte) 0x43, (byte) 0x84, //  #    ###    #
                    (byte) 0xC3, (byte) 0x86, // ##    ###    ##
                    (byte) 0xC1, (byte) 0x06, // ##     #     ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1178 'N' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x80, (byte) 0xC0, // #       ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xE0, (byte) 0xC0, // ###     ##
                    (byte) 0xE0, (byte) 0xC0, // ###     ##
                    (byte) 0xF0, (byte) 0xC0, // ####    ##
                    (byte) 0xD8, (byte) 0xC0, // ## ##   ##
                    (byte) 0xCC, (byte) 0xC0, // ##  ##  ##
                    (byte) 0xCC, (byte) 0xC0, // ##  ##  ##
                    (byte) 0xC6, (byte) 0xC0, // ##   ## ##
                    (byte) 0xC3, (byte) 0xC0, // ##    ####
                    (byte) 0xC1, (byte) 0xC0, // ##     ###
                    (byte) 0xC1, (byte) 0xC0, // ##     ###
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0x40, // ##       #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1216 'O' (11 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x1F, (byte) 0x00, //    #####
                    (byte) 0x3F, (byte) 0x80, //   #######
                    (byte) 0x71, (byte) 0xC0, //  ###   ###
                    (byte) 0x60, (byte) 0xC0, //  ##     ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0x60, (byte) 0xC0, //  ##     ##
                    (byte) 0x71, (byte) 0xC0, //  ###   ###
                    (byte) 0x3F, (byte) 0x80, //   #######
                    (byte) 0x1F, (byte) 0x00, //    #####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1254 'P' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xC3, (byte) 0x80, // ##    ###
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC3, (byte) 0x80, // ##    ###
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1292 'Q' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x1F, (byte) 0x00, //    #####
                    (byte) 0x3F, (byte) 0x80, //   #######
                    (byte) 0x71, (byte) 0xC0, //  ###   ###
                    (byte) 0x60, (byte) 0xC0, //  ##     ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0x60, (byte) 0xC0, //  ##     ##
                    (byte) 0x71, (byte) 0xC0, //  ###   ###
                    (byte) 0x3F, (byte) 0x80, //   #######
                    (byte) 0x1F, (byte) 0x00, //    #####
                    (byte) 0x01, (byte) 0x80, //        ##
                    (byte) 0x00, (byte) 0xF0, //         ####
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x00, //

                    // @1330 'R' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFE, (byte) 0x00, // #######
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xC3, (byte) 0x80, // ##    ###
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC3, (byte) 0x80, // ##    ###
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0xCE, (byte) 0x00, // ##  ###
                    (byte) 0xC6, (byte) 0x00, // ##   ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1368 'S' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x3E, //   #####
                    (byte) 0x7E, //  ######
                    (byte) 0xE0, // ###
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xE0, // ###
                    (byte) 0x78, //  ####
                    (byte) 0x1E, //    ####
                    (byte) 0x07, //      ###
                    (byte) 0x03, //       ##
                    (byte) 0x03, //       ##
                    (byte) 0x07, //      ###
                    (byte) 0xFE, // #######
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1387 'T' (10 pixels wide)
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
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1425 'U' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0xE1, (byte) 0xC0, // ###    ###
                    (byte) 0x7F, (byte) 0x80, //  ########
                    (byte) 0x3F, (byte) 0x00, //   ######
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1463 'V' (11 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0x60, (byte) 0xC0, //  ##     ##
                    (byte) 0x60, (byte) 0xC0, //  ##     ##
                    (byte) 0x60, (byte) 0xC0, //  ##     ##
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x1B, (byte) 0x00, //    ## ##
                    (byte) 0x1B, (byte) 0x00, //    ## ##
                    (byte) 0x1B, (byte) 0x00, //    ## ##
                    (byte) 0x0E, (byte) 0x00, //     ###
                    (byte) 0x0E, (byte) 0x00, //     ###
                    (byte) 0x0E, (byte) 0x00, //     ###
                    (byte) 0x04, (byte) 0x00, //      #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1501 'W' (15 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC1, (byte) 0x06, // ##     #     ##
                    (byte) 0xC1, (byte) 0x06, // ##     #     ##
                    (byte) 0x63, (byte) 0x8C, //  ##   ###   ##
                    (byte) 0x63, (byte) 0x8C, //  ##   ###   ##
                    (byte) 0x62, (byte) 0x8C, //  ##   # #   ##
                    (byte) 0x22, (byte) 0x88, //   #   # #   #
                    (byte) 0x36, (byte) 0xD8, //   ## ## ## ##
                    (byte) 0x36, (byte) 0xD8, //   ## ## ## ##
                    (byte) 0x34, (byte) 0x58, //   ## #   # ##
                    (byte) 0x14, (byte) 0x50, //    # #   # #
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x08, (byte) 0x20, //     #     #
                    (byte) 0x08, (byte) 0x20, //     #     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1539 'X' (11 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0x60, (byte) 0xC0, //  ##     ##
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x1B, (byte) 0x00, //    ## ##
                    (byte) 0x0A, (byte) 0x00, //     # #
                    (byte) 0x0E, (byte) 0x00, //     ###
                    (byte) 0x0E, (byte) 0x00, //     ###
                    (byte) 0x0E, (byte) 0x00, //     ###
                    (byte) 0x1B, (byte) 0x00, //    ## ##
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x31, (byte) 0x80, //   ##   ##
                    (byte) 0x60, (byte) 0xC0, //  ##     ##
                    (byte) 0xC0, (byte) 0x60, // ##       ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1577 'Y' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0x61, (byte) 0x80, //  ##    ##
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
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1615 'Z' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x06, //      ##
                    (byte) 0x0E, //     ###
                    (byte) 0x0C, //     ##
                    (byte) 0x1C, //    ###
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x38, //   ###
                    (byte) 0x30, //   ##
                    (byte) 0x70, //  ###
                    (byte) 0x60, //  ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1634 '[' (4 pixels wide)
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
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xF0, // ####
                    (byte) 0xF0, // ####

                    // @1653 '\' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x06, //      ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1672 ']' (4 pixels wide)
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
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0xF0, // ####
                    (byte) 0xF0, // ####

                    // @1691 '^' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x10, //    #
                    (byte) 0x28, //   # #
                    (byte) 0x6C, //  ## ##
                    (byte) 0x44, //  #   #
                    (byte) 0x82, // #     #
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

                    // @1710 '_' (10 pixels wide)
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
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1748 '`' (4 pixels wide)
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x30, //   ##
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

                    // @1767 'a' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x7C, //  #####
                    (byte) 0x7E, //  ######
                    (byte) 0x06, //      ##
                    (byte) 0x3E, //   #####
                    (byte) 0x7E, //  ######
                    (byte) 0xE6, // ###  ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xC6, // ##   ##
                    (byte) 0xFE, // #######
                    (byte) 0x7B, //  #### ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1786 'b' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xDE, (byte) 0x00, // ## ####
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xC3, (byte) 0x80, // ##    ###
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xBC, (byte) 0x00, // # ####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1824 'c' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x1E, //    ####
                    (byte) 0x7F, //  #######
                    (byte) 0x62, //  ##   #
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xE2, // ###   #
                    (byte) 0x7F, //  #######
                    (byte) 0x3E, //   #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1843 'd' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x01, (byte) 0x80, //        ##
                    (byte) 0x01, (byte) 0x80, //        ##
                    (byte) 0x01, (byte) 0x80, //        ##
                    (byte) 0x01, (byte) 0x80, //        ##
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x7F, (byte) 0x80, //  ########
                    (byte) 0x61, (byte) 0x80, //  ##    ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xE1, (byte) 0x80, // ###    ##
                    (byte) 0x7F, (byte) 0x80, //  ########
                    (byte) 0x3F, (byte) 0x80, //   #######
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1881 'e' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x3C, //   ####
                    (byte) 0x7E, //  ######
                    (byte) 0x67, //  ##  ###
                    (byte) 0xC3, // ##    ##
                    (byte) 0xFF, // ########
                    (byte) 0xFF, // ########
                    (byte) 0xC0, // ##
                    (byte) 0xE1, // ###    #
                    (byte) 0x7F, //  #######
                    (byte) 0x3E, //   #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1900 'f' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x1C, //    ###
                    (byte) 0x3C, //   ####
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0xF8, // #####
                    (byte) 0xF8, // #####
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
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

                    // @1919 'g' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x01, (byte) 0x00, //        #
                    (byte) 0x3F, (byte) 0x00, //   ######
                    (byte) 0x7E, (byte) 0x00, //  ######
                    (byte) 0xE7, (byte) 0x00, // ###  ###
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xE7, (byte) 0x00, // ###  ###
                    (byte) 0x7E, (byte) 0x00, //  ######
                    (byte) 0x3C, (byte) 0x00, //   ####
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0x7F, (byte) 0x80, //  ########
                    (byte) 0x41, (byte) 0x80, //  #     ##
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0x3E, (byte) 0x00, //   #####

                    // @1957 'h' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0xDE, // ## ####
                    (byte) 0xFE, // #######
                    (byte) 0xE7, // ###  ###
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

                    // @1976 'i' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
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

                    // @1995 'j' (5 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x78, //  ####
                    (byte) 0x78, //  ####
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x38, //   ###
                    (byte) 0xF0, // ####
                    (byte) 0xE0, // ###

                    // @2014 'k' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC6, (byte) 0x00, // ##   ##
                    (byte) 0xCC, (byte) 0x00, // ##  ##
                    (byte) 0xD8, (byte) 0x00, // ## ##
                    (byte) 0xF8, (byte) 0x00, // #####
                    (byte) 0xEC, (byte) 0x00, // ### ##
                    (byte) 0xC6, (byte) 0x00, // ##   ##
                    (byte) 0xC6, (byte) 0x00, // ##   ##
                    (byte) 0xC3, (byte) 0x00, // ##    ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2052 'l' (4 pixels wide)
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
                    (byte) 0xF0, // ####
                    (byte) 0x70, //  ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @2071 'm' (14 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xDE, (byte) 0xF8, // ## #### #####
                    (byte) 0xFF, (byte) 0xFC, // ##############
                    (byte) 0xC3, (byte) 0x9C, // ##    ###  ###
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

                    // @2109 'n' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x9E, // #  ####
                    (byte) 0xFF, // ########
                    (byte) 0xE7, // ###  ###
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

                    // @2128 'o' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0x63, (byte) 0x80, //  ##   ###
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0x7F, (byte) 0x00, //  #######
                    (byte) 0x3E, (byte) 0x00, //   #####
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2166 'p' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFE, (byte) 0x00, // #######
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xC3, (byte) 0x80, // ##    ###
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC3, (byte) 0x80, // ##    ###
                    (byte) 0xFF, (byte) 0x00, // ########
                    (byte) 0xFE, (byte) 0x00, // #######
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##
                    (byte) 0xC0, (byte) 0x00, // ##

                    // @2204 'q' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x3F, (byte) 0x80, //   #######
                    (byte) 0x7F, (byte) 0x80, //  ########
                    (byte) 0x61, (byte) 0x80, //  ##    ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0xE1, (byte) 0x80, // ###    ##
                    (byte) 0x7F, (byte) 0x80, //  ########
                    (byte) 0x3F, (byte) 0x80, //   #######
                    (byte) 0x01, (byte) 0x80, //        ##
                    (byte) 0x01, (byte) 0x80, //        ##
                    (byte) 0x01, (byte) 0x80, //        ##
                    (byte) 0x01, (byte) 0x80, //        ##

                    // @2242 'r' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xDC, // ## ###
                    (byte) 0xFC, // ######
                    (byte) 0xE0, // ###
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

                    // @2261 's' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x7E, //  ######
                    (byte) 0xFE, // #######
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x78, //  ####
                    (byte) 0x1C, //    ###
                    (byte) 0x06, //      ##
                    (byte) 0x06, //      ##
                    (byte) 0xFE, // #######
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @2280 't' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x20, //   #
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x7E, //  ######
                    (byte) 0x3E, //   #####
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @2299 'u' (8 pixels wide)
                    (byte) 0x00, //
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
                    (byte) 0xC7, // ##   ###
                    (byte) 0xFF, // ########
                    (byte) 0x7B, //  #### ##
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @2318 'v' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x14, (byte) 0x00, //    # #
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2356 'w' (15 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC1, (byte) 0x06, // ##     #     ##
                    (byte) 0x63, (byte) 0x8C, //  ##   ###   ##
                    (byte) 0x63, (byte) 0x8C, //  ##   ###   ##
                    (byte) 0x62, (byte) 0x8C, //  ##   # #   ##
                    (byte) 0x36, (byte) 0xD8, //   ## ## ## ##
                    (byte) 0x36, (byte) 0xD8, //   ## ## ## ##
                    (byte) 0x14, (byte) 0x50, //    # #   # #
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x08, (byte) 0x20, //     #     #
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2394 'x' (10 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0x61, (byte) 0x80, //  ##    ##
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0x1E, (byte) 0x00, //    ####
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x1E, (byte) 0x00, //    ####
                    (byte) 0x33, (byte) 0x00, //   ##  ##
                    (byte) 0x61, (byte) 0x80, //  ##    ##
                    (byte) 0xC0, (byte) 0xC0, // ##      ##
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2432 'y' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xC1, (byte) 0x80, // ##     ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x63, (byte) 0x00, //  ##   ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x36, (byte) 0x00, //   ## ##
                    (byte) 0x16, (byte) 0x00, //    # ##
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x0C, (byte) 0x00, //     ##
                    (byte) 0x08, (byte) 0x00, //     #
                    (byte) 0x18, (byte) 0x00, //    ##
                    (byte) 0x70, (byte) 0x00, //  ###
                    (byte) 0x60, (byte) 0x00, //  ##

                    // @2470 'z' (8 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xFF, // ########
                    (byte) 0xFE, // #######
                    (byte) 0x06, //      ##
                    (byte) 0x0C, //     ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0x7F, //  #######
                    (byte) 0xFF, // ########
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @2489 '{' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x1E, //    ####
                    (byte) 0x7E, //  ######
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x20, //   #
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x60, //  ##
                    (byte) 0xC0, // ##
                    (byte) 0x60, //  ##
                    (byte) 0x30, //   ##
                    (byte) 0x30, //   ##
                    (byte) 0x20, //   #
                    (byte) 0x60, //  ##
                    (byte) 0x60, //  ##
                    (byte) 0x70, //  ###
                    (byte) 0x7E, //  ######
                    (byte) 0x1E, //    ####

                    // @2508 '|' (2 pixels wide)
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
                    (byte) 0xC0, // ##
                    (byte) 0xC0, // ##
                    (byte) 0x00, //

                    // @2527 '}' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xF0, // ####
                    (byte) 0xFC, // ######
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x08, //     #
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x0C, //     ##
                    (byte) 0x06, //      ##
                    (byte) 0x0C, //     ##
                    (byte) 0x18, //    ##
                    (byte) 0x18, //    ##
                    (byte) 0x08, //     #
                    (byte) 0x0C, //     ##
                    (byte) 0x0C, //     ##
                    (byte) 0x1C, //    ###
                    (byte) 0xFC, // ######
                    (byte) 0xF0, // ####

                    // @2546 '~' (7 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x72, //  ###  #
                    (byte) 0xFE, // #######
                    (byte) 0x9C, // #  ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
            };

    private static final CharInfo[] bigRegularFontDescriptors =
            {
                    new CharInfo(2, 0),        // !
                    new CharInfo(5, 19),        // "
                    new CharInfo(10, 38),        // #
                    new CharInfo(8, 76),        // $
                    new CharInfo(9, 95),        // %
                    new CharInfo(11, 133),        // &
                    new CharInfo(2, 171),        // '
                    new CharInfo(4, 190),        // (
                    new CharInfo(4, 209),        // )
                    new CharInfo(6, 228),        // *
                    new CharInfo(8, 247),        // +
                    new CharInfo(4, 266),        // ,
                    new CharInfo(5, 285),        // -
                    new CharInfo(3, 304),        // .
                    new CharInfo(7, 323),        // /
                    new CharInfo(8, 342),        // 0
                    new CharInfo(5, 361),        // 1
                    new CharInfo(8, 380),        // 2
                    new CharInfo(8, 399),        // 3
                    new CharInfo(10, 418),        // 4
                    new CharInfo(7, 456),        // 5
                    new CharInfo(9, 475),        // 6
                    new CharInfo(9, 513),        // 7
                    new CharInfo(8, 551),        // 8
                    new CharInfo(9, 570),        // 9
                    new CharInfo(3, 608),        // :
                    new CharInfo(4, 627),        // ;
                    new CharInfo(7, 646),        // <
                    new CharInfo(8, 665),        // =
                    new CharInfo(7, 684),        // >
                    new CharInfo(6, 703),        // ?
                    new CharInfo(11, 722),        // @
                    new CharInfo(11, 760),        // A
                    new CharInfo(9, 798),        // B
                    new CharInfo(9, 836),        // C
                    new CharInfo(10, 874),        // D
                    new CharInfo(8, 912),        // E
                    new CharInfo(9, 931),        // F
                    new CharInfo(11, 969),        // G
                    new CharInfo(10, 1007),        // H
                    new CharInfo(2, 1045),        // I
                    new CharInfo(7, 1064),        // J
                    new CharInfo(10, 1083),        // K
                    new CharInfo(8, 1121),        // L
                    new CharInfo(15, 1140),        // M
                    new CharInfo(10, 1178),        // N
                    new CharInfo(11, 1216),        // O
                    new CharInfo(9, 1254),        // P
                    new CharInfo(12, 1292),        // Q
                    new CharInfo(10, 1330),        // R
                    new CharInfo(8, 1368),        // S
                    new CharInfo(10, 1387),        // T
                    new CharInfo(10, 1425),        // U
                    new CharInfo(11, 1463),        // V
                    new CharInfo(15, 1501),        // W
                    new CharInfo(11, 1539),        // X
                    new CharInfo(10, 1577),        // Y
                    new CharInfo(8, 1615),        // Z
                    new CharInfo(4, 1634),        // [
                    new CharInfo(7, 1653),        // \
                    new CharInfo(4, 1672),        // ]
                    new CharInfo(7, 1691),        // ^
                    new CharInfo(10, 1710),        // _
                    new CharInfo(4, 1748),        // `
                    new CharInfo(8, 1767),        // a
                    new CharInfo(9, 1786),        // b
                    new CharInfo(8, 1824),        // c
                    new CharInfo(9, 1843),        // d
                    new CharInfo(8, 1881),        // e
                    new CharInfo(6, 1900),        // f
                    new CharInfo(9, 1919),        // g
                    new CharInfo(8, 1957),        // h
                    new CharInfo(3, 1976),        // i
                    new CharInfo(5, 1995),        // j
                    new CharInfo(9, 2014),        // k
                    new CharInfo(4, 2052),        // l
                    new CharInfo(14, 2071),        // m
                    new CharInfo(8, 2109),        // n
                    new CharInfo(9, 2128),        // o
                    new CharInfo(9, 2166),        // p
                    new CharInfo(9, 2204),        // q
                    new CharInfo(6, 2242),        // r
                    new CharInfo(7, 2261),        // s
                    new CharInfo(7, 2280),        // t
                    new CharInfo(8, 2299),        // u
                    new CharInfo(9, 2318),        // v
                    new CharInfo(15, 2356),        // w
                    new CharInfo(10, 2394),        // x
                    new CharInfo(9, 2432),        // y
                    new CharInfo(8, 2470),        // z
                    new CharInfo(7, 2489),        // {
                    new CharInfo(2, 2508),        // |
                    new CharInfo(7, 2527),        // }
                    new CharInfo(7, 2546),        // ~
            };

    private static final CharInfoLookup[] bigRegularFontBlockLookup =
            {
                    new CharInfoLookup('!', '~', bigRegularFontDescriptors)
            };

    private static final FontInfo bigRegularFontInfo = new FontInfo(
            19,
            '!',
            '~',
            1,
            4,
            bigRegularFontBlockLookup,
            bigRegularFontBitmaps
    );

    @Override
    public FontInfo getFontInfo() {
        return bigRegularFontInfo;
    }
}
