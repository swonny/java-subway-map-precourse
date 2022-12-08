package subway;

import subway.domain.Station;
import subway.domain.StationMaker;
import subway.domain.StationRepository;
import subway.enums.StationManage;
import view.InputView;
import view.OutputView;

import java.util.List;

public class StationController {

    public static void runMenu(String selectedMenu) {
        if (StationManage.FIRST.get().equals(selectedMenu)) {
            addStation();
        }
        if (StationManage.SECOND.get().equals(selectedMenu)) {
            deleteStation();
        }
        if (StationManage.THIRD.get().equals(selectedMenu)) {
            printStations();
        }
        if (StationManage.BACK.get().equals(selectedMenu)) {
            OutputView.print("[INFO] 메인 메뉴로 돌아갑니다.");
        }
    }

    private static void printStations() {
        StationRepository.stations().stream()
                .forEach(StationManage.SECOND::printInfo);
    }

    private static void deleteStation() {
        List<String> followingMessages = StationManage.FIRST.getFollowingMessages();
        OutputView.print(followingMessages.get(0));
        StationRepository.deleteStation(InputView.read());
        StationManage.SECOND.printInfo();
    }

    private static void addStation() {
        List<String> followingMessages = StationManage.FIRST.getFollowingMessages();
        OutputView.print(followingMessages.get(0));
        StationMaker.make(InputView.read());
        StationManage.FIRST.printInfo();
    }
}
