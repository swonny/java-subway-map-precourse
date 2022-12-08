package view;

import org.junit.jupiter.api.Test;
import subway.enums.MainMenu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    @Test
    public void testOutputView() {
        assertThat(MainMenu.getWholeMenu()).isEqualTo("1");
    }
}