package com.icapps.tiles.service;

import android.graphics.drawable.Icon;
import android.provider.Settings;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

import com.icapps.tiles.R;

import static android.provider.Settings.Global.ALWAYS_FINISH_ACTIVITIES;

/**
 * Created by mariannedeturck
 */

public class DoNotKeepActivitiesService extends TileService {

    @Override
    public void onStartListening() {
        super.onStartListening();
        updateTile();
    }

    @Override
    public void onClick() {
        super.onClick();
        if (!isLocked()) {
            Settings.Global.putInt(getContentResolver(), ALWAYS_FINISH_ACTIVITIES, isDoNotKeepActivitiesEnabled() ? 0 : 1);
            updateTile();
        }
    }

    private void updateTile() {
        getQsTile().setIcon(isDoNotKeepActivitiesEnabled() ? Icon.createWithResource(getApplicationContext(), R.drawable.ic_do_not_keep_activities_enabled) : Icon.createWithResource(getApplicationContext(), R.drawable.ic_do_not_keep_activities_disabled));
        getQsTile().setState(isDoNotKeepActivitiesEnabled() ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
        getQsTile().updateTile();
    }

    private boolean isDoNotKeepActivitiesEnabled() {
        return Settings.Global.getInt(getContentResolver(), ALWAYS_FINISH_ACTIVITIES, 0) == 1;
    }
}