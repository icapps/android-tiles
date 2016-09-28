#Tiles contains a few utilities for Android developers

##Features

1) Enable/ disable the "do not keep activities" setting

2) Enable/ disable the developer options

##How to

1) Install the APK on your device

2) Connect your device to your laptop, which has the Android SDK tools installed. Make sure the developer options and USB debugging on your device are on.

3) Open terminal and navigate to your folder containing the ADB (SDK/platform-tools/)

4) Execute the following:


    adb shell "pm grant com.icapps.tiles android.permission.WRITE_SECURE_SETTINGS"

5) Open your quick settings and edit the tiles. You should see 2 new suggestions.
