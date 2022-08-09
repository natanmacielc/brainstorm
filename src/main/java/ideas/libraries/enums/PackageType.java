package ideas.libraries.enums;

public enum PackageType {
    ODIN("com.globalcards.odin"),
    HIBERNATE("org.hibernate");

    String value;

    PackageType(String value) {
        this.value = value;
    }

    public String getName() {
        return value;
    }
}
