package com.example.hilt;

import android.content.res.ColorStateList;

public class BitmapUtil {
    /**

     * 对TextView设置不同状态时其文字颜色

     * @param normal

     * @param pressed

     * @param focused

     * @param unable

     * @return

     */

    public static ColorStateList createColorStateList(int normal, int pressed, int focused, int unable) {
        int[] colors = new int[] { pressed, focused, normal, focused, unable, normal };

        int[][] states = new int[6][];

        states[0] = new int[] { android.R.attr.state_pressed, android.R.attr.state_enabled };

        states[1] = new int[] { android.R.attr.state_enabled, android.R.attr.state_focused };

        states[2] = new int[] { android.R.attr.state_enabled };

        states[3] = new int[] { android.R.attr.state_focused };

        states[4] = new int[] { android.R.attr.state_window_focused };

        states[5] = new int[] {};

        ColorStateList colorList = new ColorStateList(states, colors);

        return colorList;

    }
}
