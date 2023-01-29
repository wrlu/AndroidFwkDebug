package com.wrlus.module.fwkdebug;

import java.util.ArrayList;
import java.util.List;

public final class Mapping {
    public static final List<Info> mSpecialServiceList;

    public static final class Info {
        public String className;
        public String[] fieldName;
        public Info(String className, String[] fieldName) {
            this.className = className;
            this.fieldName = fieldName;
        }
    }

    static {
        mSpecialServiceList = new ArrayList<>();
        initSpecialServiceList();
    }

    private static void initSpecialServiceList() {
        mSpecialServiceList.add(new Info(
                "com.android.server.wm.ActivityTaskManagerDebugConfig",
                new String[]{ "TAG_WITH_CLASS_NAME", "APPEND_CATEGORY_NAME", "DEBUG_ALL",
                        "DEBUG_ALL_ACTIVITIES", "DEBUG_RECENTS", "DEBUG_RECENTS_TRIM_TASKS",
                        "DEBUG_ROOT_TASK", "DEBUG_SWITCH", "DEBUG_TRANSITION", "DEBUG_VISIBILITY",
                        "DEBUG_APP", "DEBUG_IDLE", "DEBUG_RELEASE", "DEBUG_USER_LEAVING",
                        "DEBUG_PERMISSIONS_REVIEW", "DEBUG_RESULTS", "DEBUG_ACTIVITY_STARTS",
                        "DEBUG_CLEANUP", "DEBUG_METRICS" } ));
        mSpecialServiceList.add(new Info(
                "com.android.server.pm.verify.domain.DomainVerificationDebug",
                new String[]{ "DEBUG_ANY", "DEBUG_ALL" } ));
        mSpecialServiceList.add(new Info(
                "com.android.server.pm.PackageManagerService",
                new String[]{ "DEBUG_SETTINGS", "DEBUG_PREFERRED", "DEBUG_UPGRADE",
                        "DEBUG_DOMAIN_VERIFICATION", "DEBUG_BACKUP", "DEBUG_INSTALL",
                        "DEBUG_REMOVE", "DEBUG_PACKAGE_INFO", "DEBUG_INTENT_MATCHING",
                        "DEBUG_PACKAGE_SCANNING", "DEBUG_VERIFY", "DEBUG_PERMISSIONS",
                        "DEBUG_COMPRESSION", "TRACE_SNAPSHOTS", "DEBUG_PER_UID_READ_TIMEOUTS",
                        "DEBUG_DEXOPT", "DEBUG_ABI_SELECTION", "DEBUG_INSTANT" } ));
        mSpecialServiceList.add(new Info(
                "com.android.server.pm.OtaDexoptService",
                new String[]{ "DEBUG_DEXOPT" } ));
        mSpecialServiceList.add(new Info(
                "com.android.server.wm.WindowManagerDebugConfig",
                new String[]{ "TAG_WITH_CLASS_NAME", "DEBUG", "DEBUG_LAYOUT", "DEBUG_LAYERS",
                        "DEBUG_INPUT", "DEBUG_INPUT_METHOD", "DEBUG_VISIBILITY",
                        "DEBUG_CONFIGURATION", "DEBUG_STARTING_WINDOW_VERBOSE", "DEBUG_WALLPAPER",
                        "DEBUG_DRAG", "DEBUG_SCREENSHOT", "DEBUG_LAYOUT_REPEATS",
                        "DEBUG_WINDOW_TRACE", "DEBUG_TASK_MOVEMENT", "DEBUG_TASK_POSITIONING",
                        "DEBUG_ROOT_TASK", "DEBUG_DISPLAY", "DEBUG_POWER",
                        "SHOW_VERBOSE_TRANSACTIONS", "SHOW_LIGHT_TRANSACTIONS", "SHOW_STACK_CRAWLS",
                        "DEBUG_WINDOW_CROP", "DEBUG_UNKNOWN_APP_VISIBILITY" } ));
        mSpecialServiceList.add(new Info(
                "com.android.server.TelephonyRegistry",
                new String[]{ "DBG", "DBG_LOC", "VDBG" } ));
        mSpecialServiceList.add(new Info(
                "com.android.server.devicepolicy.DevicePolicyManagerService",
                new String[]{ "VERBOSE_LOG" } ));
    }

}