#Tiles contains a few utilities for Android developers

##Features

1) Enable/ disable the "do not keep activities" setting

2) Enable/ disable the developer options

##How to

1) Check out this repo

2) Go to terminal

3) Navigate to your folder containing the ADB (SDK/platform-tools/)

4) Execute the following:


    adb shell "pm grant com.icapps.tiles android.permission.WRITE_SECURE_SETTINGS"


5) Install the APK on your device
