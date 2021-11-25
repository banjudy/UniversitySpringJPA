package springboot.UniSpringJPA.model;

public enum MajorType {

    ANG("anglisztika"),
    GER("germanisztika"),
    INF("informatikus könyvtáros"),
    JAP("japán"),
    CLF("klasszika filológia"),
    HUN("magyar"),
    SCA("skandinavisztika"),
    HIS("történelem"),
    OTHER("other");

    public final String label;

    MajorType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static MajorType getFacultyTypePerLabel(String str) {
        for (MajorType facultyType : MajorType.values())
            if (facultyType.label.equals(str)) {
                return facultyType;
            }
        return MajorType.OTHER;
    }
}
