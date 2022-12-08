package subway.enums;

public enum MainMenu {
    TITLE("## 메인 화면", SectionManage.getMenu()),
    FIRST("1. 역 관리", StationManage),
    SECOND("2. 노선 관리", LineManage),
    THIRD("3. 구간 관리", SectionManage),
    FOURTH("4. 지하철 노선도 출력", SectionManage),
    QUIT("Q. 종료", SectionManage);

    private static String mapped;
    String printing;

    MainMenu(String printing, String mapped) {
        this.printing = printing;
        this.mapped = mapped;
    }

    public Enum whenSelected() {
        this.printing
    }
}
