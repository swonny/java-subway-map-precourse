package subway.domain;

public class Station {
    /*
    * 생성자 추가 불가능
    * 필드(인스턴스 변수)인 name의 접근 제어자 private을 변경할 수 없다.
    * 가능하면 setter 메소드(ex. setXXX)를 추가하지 않고 구현한다.
    * */
    private final int MINIMUM_NAME_LENGTH = 2;
    private String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
