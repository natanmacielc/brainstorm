package br.com.natan.dev.libraries.enums;

public enum PackageType {
    HIBERNATE("org.hibernate");

    String value;

    PackageType(String value) {
        this.value = value;
    }

    public String getName() {
        return value;
    }
}
