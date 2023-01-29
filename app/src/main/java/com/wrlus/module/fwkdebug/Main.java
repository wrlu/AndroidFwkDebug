package com.wrlus.module.fwkdebug;

import android.annotation.SuppressLint;
import android.os.IBinder;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.XposedHelpers;

import java.lang.reflect.Field;

public class Main implements IXposedHookLoadPackage {
    public static final String TAG = "FwkDebug";
    public static final String[] knownFieldNames = new String[]
            { "DEBUG", "DBG", "VDBG", "LOG" };

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        if ("android".equals(loadPackageParam.packageName)) {
            hookServiceAdd(loadPackageParam.classLoader);
            hookSpecialServices(loadPackageParam.classLoader);
        }
    }

    @SuppressLint("PrivateApi")
    public void hookServiceAdd(ClassLoader classLoader) {
        try {
            XposedHelpers.findAndHookMethod("android.os.ServiceManager",
                    classLoader, "addService",
                    String.class, IBinder.class, boolean.class, int.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            String name = (String) param.args[0];
                            Object service = param.args[1];
                            if (service == null) {
                                return;
                            }
                            String serviceClassName = service.getClass().getName();
                            Log.d(TAG, "SM.addService: " + name + " [" + serviceClassName + "]");
                            hookServiceFields(classLoader,
                                    escapeInnerClass(serviceClassName),
                                    knownFieldNames);
                        }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hookSpecialServices(ClassLoader classLoader) {
        // Hook special services
        for (Mapping.Info info : Mapping.mSpecialServiceList) {
            hookServiceFields(classLoader, info.className, info.fieldName);
        }
    }

    private void hookServiceFields(ClassLoader classLoader, String className, String[] fieldNames) {
        Class<?> targetClass = XposedHelpers
                .findClassIfExists(className, classLoader);
        if (targetClass == null) {
            Log.e(TAG, "Class not found: " + className);
            return;
        }
        for (String fieldName : fieldNames) {
            Field targetField = XposedHelpers
                    .findFieldIfExists(targetClass, fieldName);
            if (targetField == null) {
                continue;
            }
            XposedHelpers.setStaticBooleanField(targetClass, fieldName, true);
            Log.d(TAG, "Hook variable: " + className
                    + ":" + fieldName);
        }
    }

    private String escapeInnerClass(String className) {
        String[] classSplit = className.split("\\$", 2);
        if (classSplit.length == 2) {
            return classSplit[0];
        }
        if (className.endsWith(".Lifecycle")) {
            return className.replace(".Lifecycle", "");
        }
        return className;
    }
}
