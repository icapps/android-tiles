package com.icapps.tiles.service;

import android.graphics.drawable.Icon;
import android.provider.Settings;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

import com.icapps.tiles.R;

import static android.provider.Settings.Global.ADB_ENABLED;
import static android.provider.Settings.Global.DEVELOPMENT_SETTINGS_ENABLED;
import static android.provider.Settings.Global.STAY_ON_WHILE_PLUGGED_IN;

/**
 * Created by mariannedeturck
 */

public class DeveloperOptionsService extends TileService {

    @Override
    public void onStartListening() {
        super.onStartListening();
        updateTile();
    }

    @Override
    public void onClick() {
        super.onClick();
        if (!isLocked()) {
            final int enable = isDeveloperOptionsEnabled() ? 0 : 1;
            Settings.Global.putInt(getContentResolver(), DEVELOPMENT_SETTINGS_ENABLED, enable);
            Settings.Global.putInt(getContentResolver(), ADB_ENABLED, enable);
            Settings.Global.putInt(getContentResolver(), STAY_ON_WHILE_PLUGGED_IN, enable);
            updateTile();
        }
    }

    private void updateTile() {
        getQsTile().setIcon(isDeveloperOptionsEnabled() ? Icon.createWithResource(getApplicationContext(), R.drawable.ic_developer_options_enabled) : Icon.createWithResource(getApplicationContext(), R.drawable.ic_developer_options_disabled));
        getQsTile().setState(isDeveloperOptionsEnabled() ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
        getQsTile().updateTile();
    }

    private boolean isDeveloperOptionsEnabled() {
        return Settings.Global.getInt(getContentResolver(), DEVELOPMENT_SETTINGS_ENABLED, 0) == 1;
    }
}
