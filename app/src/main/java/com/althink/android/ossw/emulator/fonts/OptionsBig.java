package com.althink.android.ossw.emulator.fonts;

/**
 * Created by krzysiek on 05/07/15.
 */
public class OptionsBig implements EmulatorFont {

    private static final byte[] optionBigFontBitmaps =
            {
                    // @0 '!' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
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
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @26 '"' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xE3, (byte) 0x80, // ###   ###
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

                    // @78 '#' (15 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @130 '%' (26 pixels wide)
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0x83, (byte) 0x80, (byte) 0x00, // #########     ###
                    (byte) 0xFF, (byte) 0x83, (byte) 0x80, (byte) 0x00, // #########     ###
                    (byte) 0xFF, (byte) 0x83, (byte) 0x80, (byte) 0x00, // #########     ###
                    (byte) 0xE3, (byte) 0x83, (byte) 0x80, (byte) 0x00, // ###   ###     ###
                    (byte) 0xE3, (byte) 0x83, (byte) 0x80, (byte) 0x00, // ###   ###     ###
                    (byte) 0xFF, (byte) 0x8E, (byte) 0x00, (byte) 0x00, // #########   ###
                    (byte) 0xFF, (byte) 0x8E, (byte) 0x00, (byte) 0x00, // #########   ###
                    (byte) 0xFF, (byte) 0x8E, (byte) 0x00, (byte) 0x00, // #########   ###
                    (byte) 0x00, (byte) 0x0E, (byte) 0x7F, (byte) 0xC0, //             ###  #########
                    (byte) 0x00, (byte) 0x0E, (byte) 0x7F, (byte) 0xC0, //             ###  #########
                    (byte) 0x00, (byte) 0x0E, (byte) 0x7F, (byte) 0xC0, //             ###  #########
                    (byte) 0x00, (byte) 0x70, (byte) 0x71, (byte) 0xC0, //          ###     ###   ###
                    (byte) 0x00, (byte) 0x70, (byte) 0x71, (byte) 0xC0, //          ###     ###   ###
                    (byte) 0x00, (byte) 0x70, (byte) 0x71, (byte) 0xC0, //          ###     ###   ###
                    (byte) 0x00, (byte) 0x70, (byte) 0x7F, (byte) 0xC0, //          ###     #########
                    (byte) 0x00, (byte) 0x70, (byte) 0x7F, (byte) 0xC0, //          ###     #########
                    (byte) 0x00, (byte) 0x70, (byte) 0x7F, (byte) 0xC0, //          ###     #########
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, //

                    // @234 ''' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
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

                    // @260 '(' (6 pixels wide)
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @286 ')' (6 pixels wide)
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @312 '*' (15 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0x1F, (byte) 0xF0, //    #########
                    (byte) 0x1F, (byte) 0xF0, //    #########
                    (byte) 0x1F, (byte) 0xF0, //    #########
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
                    (byte) 0x1C, (byte) 0x70, //    ###   ###
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

                    // @364 '+' (15 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @416 ',' (3 pixels wide)
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
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###

                    // @442 '-' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
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

                    // @494 '.' (3 pixels wide)
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
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @520 '/' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @572 '0' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @624 '1' (6 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @650 '2' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @702 '3' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x1F, (byte) 0xF0, //    #########
                    (byte) 0x1F, (byte) 0xF0, //    #########
                    (byte) 0x1F, (byte) 0xF0, //    #########
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @754 '4' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @806 '5' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @858 '6' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @910 '7' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @962 '8' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1014 '9' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1066 ':' (3 pixels wide)
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
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1092 ';' (3 pixels wide)
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
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###

                    // @1118 '<' (15 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x7E, //          ######
                    (byte) 0x00, (byte) 0x7E, //          ######
                    (byte) 0x00, (byte) 0x7E, //          ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x00, (byte) 0x7E, //          ######
                    (byte) 0x00, (byte) 0x7E, //          ######
                    (byte) 0x00, (byte) 0x7E, //          ######
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1170 '=' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
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

                    // @1222 '>' (15 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0x03, (byte) 0xF0, //       ######
                    (byte) 0x03, (byte) 0xF0, //       ######
                    (byte) 0x03, (byte) 0xF0, //       ######
                    (byte) 0x00, (byte) 0x0E, //             ###
                    (byte) 0x00, (byte) 0x0E, //             ###
                    (byte) 0x00, (byte) 0x0E, //             ###
                    (byte) 0x03, (byte) 0xF0, //       ######
                    (byte) 0x03, (byte) 0xF0, //       ######
                    (byte) 0x03, (byte) 0xF0, //       ######
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0xFC, (byte) 0x00, // ######
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1274 '?' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x1F, (byte) 0xF0, //    #########
                    (byte) 0x1F, (byte) 0xF0, //    #########
                    (byte) 0x1F, (byte) 0xF0, //    #########
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1326 '@' (20 pixels wide)
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xE0, (byte) 0x00, (byte) 0x70, // ###              ###
                    (byte) 0xE0, (byte) 0x00, (byte) 0x70, // ###              ###
                    (byte) 0xE3, (byte) 0xFE, (byte) 0x70, // ###   #########  ###
                    (byte) 0xE3, (byte) 0xFE, (byte) 0x70, // ###   #########  ###
                    (byte) 0xE3, (byte) 0xFE, (byte) 0x70, // ###   #########  ###
                    (byte) 0xE3, (byte) 0x8E, (byte) 0x70, // ###   ###   ###  ###
                    (byte) 0xE3, (byte) 0x8E, (byte) 0x70, // ###   ###   ###  ###
                    (byte) 0xE3, (byte) 0x8E, (byte) 0x70, // ###   ###   ###  ###
                    (byte) 0xE3, (byte) 0xFF, (byte) 0xF0, // ###   ##############
                    (byte) 0xE3, (byte) 0xFF, (byte) 0xF0, // ###   ##############
                    (byte) 0xE3, (byte) 0xFF, (byte) 0xF0, // ###   ##############
                    (byte) 0xE0, (byte) 0x00, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //

                    // @1404 'A' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1456 'B' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1508 'C' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1560 'D' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0xFF, (byte) 0xE0, // ###########
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xE0, // ###########
                    (byte) 0xFF, (byte) 0xC0, // ##########
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1612 'E' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1664 'F' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1716 'G' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE3, (byte) 0xF0, // ###   ######
                    (byte) 0xE3, (byte) 0xF0, // ###   ######
                    (byte) 0xE3, (byte) 0xF0, // ###   ######
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1768 'H' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1820 'I' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @1846 'J' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1898 'K' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @1950 'L' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2002 'M' (20 pixels wide)
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //

                    // @2080 'N' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2132 'O' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2184 'P' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2236 'Q' (15 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE3, (byte) 0x8E, // ###   ###   ###
                    (byte) 0xE3, (byte) 0x8E, // ###   ###   ###
                    (byte) 0xE3, (byte) 0x8E, // ###   ###   ###
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2288 'R' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2340 'S' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2392 'T' (15 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2444 'U' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2496 'V' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2548 'W' (20 pixels wide)
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //

                    // @2626 'X' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2678 'Y' (15 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xE0, (byte) 0x0E, // ###         ###
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0xFF, (byte) 0xFE, // ###############
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2730 'Z' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2782 '[' (6 pixels wide)
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @2808 '\' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x03, (byte) 0x80, //       ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2860 ']' (6 pixels wide)
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0x1C, //    ###
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0xFC, // ######
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @2886 '^' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xE3, (byte) 0x80, // ###   ###
                    (byte) 0xE3, (byte) 0x80, // ###   ###
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
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2938 '_' (12 pixels wide)
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
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @2990 '`' (3 pixels wide)
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
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

                    // @3016 'a' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @3068 'b' (12 pixels wide)
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @3120 'c' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @3172 'd' (12 pixels wide)
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @3224 'e' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @3276 'f' (12 pixels wide)
                    (byte) 0x1F, (byte) 0xF0, //    #########
                    (byte) 0x1F, (byte) 0xF0, //    #########
                    (byte) 0x1F, (byte) 0xF0, //    #########
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @3328 'g' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############

                    // @3380 'h' (12 pixels wide)
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @3432 'i' (3 pixels wide)
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @3458 'j' (3 pixels wide)
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###

                    // @3484 'k' (12 pixels wide)
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @3536 'l' (3 pixels wide)
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //

                    // @3562 'm' (20 pixels wide)
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //

                    // @3640 'n' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @3692 'o' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @3744 'p' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###

                    // @3796 'q' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###

                    // @3848 'r' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @3900 's' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @3952 't' (9 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0xFF, (byte) 0x80, // #########
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1C, (byte) 0x00, //    ###
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @4004 'u' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @4056 'v' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @4108 'w' (20 pixels wide)
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xE0, (byte) 0x70, (byte) 0x70, // ###      ###     ###
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0xFF, (byte) 0xFF, (byte) 0xF0, // ####################
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, (byte) 0x00, //

                    // @4186 'x' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @4238 'y' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xE0, (byte) 0x70, // ###      ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###

                    // @4290 'z' (12 pixels wide)
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x00, (byte) 0x70, //          ###
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0x1F, (byte) 0x80, //    ######
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xE0, (byte) 0x00, // ###
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0xFF, (byte) 0xF0, // ############
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //
                    (byte) 0x00, (byte) 0x00, //

                    // @4342 '|' (3 pixels wide)
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0xE0, // ###
                    (byte) 0x00, //
                    (byte) 0x00, //
                    (byte) 0x00, //
            };

    private static final CharInfo[] optionBigFontDescriptors =
            {
                    new CharInfo(3, 0),        // !
                    new CharInfo(9, 26),        // "
                    new CharInfo(15, 78),        // #
                    new CharInfo(0, 0),        // $
                    new CharInfo(26, 130),        // %
                    new CharInfo(0, 0),        // &
                    new CharInfo(3, 234),        // '
                    new CharInfo(6, 260),        // (
                    new CharInfo(6, 286),        // )
                    new CharInfo(15, 312),        // *
                    new CharInfo(15, 364),        // +
                    new CharInfo(3, 416),        // ,
                    new CharInfo(12, 442),        // -
                    new CharInfo(3, 494),        // .
                    new CharInfo(9, 520),        // /
                    new CharInfo(12, 572),        // 0
                    new CharInfo(6, 624),        // 1
                    new CharInfo(12, 650),        // 2
                    new CharInfo(12, 702),        // 3
                    new CharInfo(12, 754),        // 4
                    new CharInfo(12, 806),        // 5
                    new CharInfo(12, 858),        // 6
                    new CharInfo(12, 910),        // 7
                    new CharInfo(12, 962),        // 8
                    new CharInfo(12, 1014),        // 9
                    new CharInfo(3, 1066),        // :
                    new CharInfo(3, 1092),        // ;
                    new CharInfo(15, 1118),        // <
                    new CharInfo(12, 1170),        // =
                    new CharInfo(15, 1222),        // >
                    new CharInfo(12, 1274),        // ?
                    new CharInfo(20, 1326),        // @
                    new CharInfo(12, 1404),        // A
                    new CharInfo(12, 1456),        // B
                    new CharInfo(12, 1508),        // C
                    new CharInfo(12, 1560),        // D
                    new CharInfo(12, 1612),        // E
                    new CharInfo(12, 1664),        // F
                    new CharInfo(12, 1716),        // G
                    new CharInfo(12, 1768),        // H
                    new CharInfo(3, 1820),        // I
                    new CharInfo(9, 1846),        // J
                    new CharInfo(12, 1898),        // K
                    new CharInfo(12, 1950),        // L
                    new CharInfo(20, 2002),        // M
                    new CharInfo(12, 2080),        // N
                    new CharInfo(12, 2132),        // O
                    new CharInfo(12, 2184),        // P
                    new CharInfo(15, 2236),        // Q
                    new CharInfo(12, 2288),        // R
                    new CharInfo(12, 2340),        // S
                    new CharInfo(15, 2392),        // T
                    new CharInfo(12, 2444),        // U
                    new CharInfo(12, 2496),        // V
                    new CharInfo(20, 2548),        // W
                    new CharInfo(12, 2626),        // X
                    new CharInfo(15, 2678),        // Y
                    new CharInfo(12, 2730),        // Z
                    new CharInfo(6, 2782),        // [
                    new CharInfo(9, 2808),        // \
                    new CharInfo(6, 2860),        // ]
                    new CharInfo(9, 2886),        // ^
                    new CharInfo(12, 2938),        // _
                    new CharInfo(3, 2990),        // `
                    new CharInfo(12, 3016),        // a
                    new CharInfo(12, 3068),        // b
                    new CharInfo(12, 3120),        // c
                    new CharInfo(12, 3172),        // d
                    new CharInfo(12, 3224),        // e
                    new CharInfo(12, 3276),        // f
                    new CharInfo(12, 3328),        // g
                    new CharInfo(12, 3380),        // h
                    new CharInfo(3, 3432),        // i
                    new CharInfo(3, 3458),        // j
                    new CharInfo(12, 3484),        // k
                    new CharInfo(3, 3536),        // l
                    new CharInfo(20, 3562),        // m
                    new CharInfo(12, 3640),        // n
                    new CharInfo(12, 3692),        // o
                    new CharInfo(12, 3744),        // p
                    new CharInfo(12, 3796),        // q
                    new CharInfo(12, 3848),        // r
                    new CharInfo(12, 3900),        // s
                    new CharInfo(9, 3952),        // t
                    new CharInfo(12, 4004),        // u
                    new CharInfo(12, 4056),        // v
                    new CharInfo(20, 4108),        // w
                    new CharInfo(12, 4186),        // x
                    new CharInfo(12, 4238),        // y
                    new CharInfo(12, 4290),        // z
                    new CharInfo(0, 0),        // new CharInfo(
                    new CharInfo(3, 4342),        // |
            };

    private static final CharInfoLookup[] optionBigFontBlockLookup =
            {
                    new CharInfoLookup('!', '|', optionBigFontDescriptors)
            };

    private static final FontInfo optionBigFontInfo = new FontInfo(
            26,
            '!',
            '|',
            3,
            6,
            optionBigFontBlockLookup,
            optionBigFontBitmaps
    );

    @Override
    public FontInfo getFontInfo() {
        return optionBigFontInfo;
    }
}
