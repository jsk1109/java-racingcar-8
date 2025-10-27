package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.View;

import java.util.List;

public class Controller {

    public void run() {
        RacingGame game = new RacingGame();

        String carNames = View.readCar();
        game.validateCarNames(carNames);
        game.createCars(carNames);

        String tryCountInput = View.readCount();
        game.validateCount(tryCountInput);
        game.saveTryCount(tryCountInput);

        View.runResult();
        int totalRounds = game.getTryCount();
        for (int i = 0; i < totalRounds; i++) {
            game.raceRound();
            View.printRoundStatus(game.getCars());
        }

        List<Car> winners = game.getWinners();
        View.printWinners(winners);
    }
}
