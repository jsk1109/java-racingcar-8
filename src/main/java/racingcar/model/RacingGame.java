package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> cars;
    private int tryCount; // "시도 횟수"를 저장할 변수

    public void validateCarNames(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            validateName(name);
        }
    }

    public void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        if (name.length() < 1) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
        }
    }

    public void validateCount(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        if (number < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public void createCars(String input) {
        this.cars = new ArrayList<>();
        String[] names = input.split(",");
        for (String name : names) {
            this.cars.add(new Car(name));
        }
    }

    public void saveTryCount(String input) {
        this.tryCount = Integer.parseInt(input);
    }
    public List<Car> getCars() {
        return this.cars;
    }
    public int getTryCount() {
        return this.tryCount;
    }

    public void raceRound() {
        for (Car car : this.cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<Car> getWinners() {
        int Position = findPosition();

        List<Car> winners = new ArrayList<>();

        for (Car car : this.cars) {
            if (car.getPosition() == Position) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int findPosition() {
        int max = 0;
        for (Car car : this.cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }
}
