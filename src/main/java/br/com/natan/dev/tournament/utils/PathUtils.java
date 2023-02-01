package br.com.natan.dev.tournament.utils;

public class PathUtils {
    public static String getCurrentDirectory() {
        return System.getProperty("user.dir");
    }

    public static String getResourcesDirectory() {
        return getCurrentDirectory().concat("\\src\\main\\resources\\");
    }

    public static String getPackageDirectory(Class clazz) {
        return getResourcesDirectory().concat(clazz.getPackageName()).replace(".", "\\");
    }
}
