package topads.tokopedia.com.tinkersample;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Author errysuprayogi on 10,January,2020
 */
public class UserPrefs {

    private static UserPrefs instance;
    private Context context;
    private SharedPreferences settings;

    private UserPrefs(Context context) {
        this.context = context;
        settings = context.getSharedPreferences("MyPref", 0);
    }

    public static UserPrefs getInstance(Context context) {
        if (instance == null) {
            instance = new UserPrefs(context);
        }
        return instance;
    }

    public void saveString(String key, String value) {
        settings.edit().putString(key, value).commit();
    }

    public String getString(String key, String defaultValue) {
        return settings.getString(key, defaultValue);
    }
}