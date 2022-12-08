package subway.domain;


public class Line {
    /*
     * 생성자 추가 불가능
     * 필드(인스턴스 변수)인 name의 접근 제어자 private을 변경할 수 없다.
     * 가능하면 setter 메소드(ex. setXXX)를 추가하지 않고 구현한다.
     * */

    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
