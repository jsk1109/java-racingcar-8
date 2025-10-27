package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class View {

    public static String readCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String readCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public static void runResult() {
        System.out.println("실행 결과");
    }

    public static void printRoundStatus(List<Car> cars) {
        for (Car car : cars) {
            String name = car.getName();
            int position = car.getPosition();

            System.out.print(name + " : ");
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.getName());
        }
        System.out.println(String.join(", ", winnerNames));
    }
}
