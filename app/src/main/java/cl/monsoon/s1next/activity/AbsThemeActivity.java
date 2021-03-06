package cl.monsoon.s1next.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import cl.monsoon.s1next.Config;

/**
 * Change theme depends on settings.
 */
public abstract class AbsThemeActivity extends ActionBarActivity {

    private int mThemeResId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // default theme is DarkTheme
        if (Config.getTheme() == Config.LIGHT_THEME) {
            setTheme(Config.LIGHT_THEME);
        }
        mThemeResId = Config.getTheme();

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // change theme when night mode setting changes
        if (mThemeResId != Config.getTheme()) {
            setTheme(Config.getTheme());

            recreate();
        }
    }
}
