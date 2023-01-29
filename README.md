# FwkDebug
**!!! NOT RECOMMAND TO INSTALL ON DAILY USE DEVICES !!!**

A LSPosed/Xposed module for hooking framework system services debug variable. In order to get more useful log messages for security research or other purpose.

## Usage
Enable `FwDebug` module in your LSPosed or Xposed app, select `system framework` (only for LSPosed) then reboot phone. 

## Tested devices
* Pixel 6, Android 12L, SQ3A.220705.004.X2 (Developer Support builds)
* Pixel 5, Android 11, RQ3A.210905.001
* Pixel 2 XL, Android 9, PQ3A.190801.002

## Known issues
* All debug variables and sources are removed on Pixel 7 stock ROMs (Android 13 build), so this module will not work.
