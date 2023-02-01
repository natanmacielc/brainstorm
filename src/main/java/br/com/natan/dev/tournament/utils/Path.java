package br.com.natan.dev.tournament.utils;

public enum Path {
    CURRENT_DIRECTORY(System.getProperty("user.dir")),
    RESOURCES_DIRECTORY(getResourcesDirectory()),
    PATH_INSTANCE();
    private final String path;

    Path(String path) {
        this.path = path;
    }

    Path() {
        this.path = "";
    }

    public String getPath() {
        return this.path;
    }

    private static String getResourcesDirectory() {
        return CURRENT_DIRECTORY.getPath().concat("\\src\\main\\resources\\");
    }

    public String getActualPackageDirectory(Class clazz) {
        return RESOURCES_DIRECTORY.getPath().concat(clazz.getPackageName().replace(".", "\\"));
    }
}
