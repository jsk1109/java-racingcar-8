package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class RacingGameTest {

    @Test
    void 자동차이름이5자를초과하면예외() {

        RacingGame game = new RacingGame();
        String invalidInput = "pobi,javaji";
            assertThatThrownBy(() -> game.validateCarNames(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름1자미만예외() {
        RacingGame game = new RacingGame();
        String invalidInput = "pobi,,jun";
        assertThatThrownBy(() -> game.validateCarNames(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수가숫자가아니면예외() {
        RacingGame game = new RacingGame();
        String invalidInput = "abc";
        assertThatThrownBy(() -> game.validateCount(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수가1미만이면예외발생() {
        RacingGame game = new RacingGame();
        String invalidInput = "0";
        assertThatThrownBy(() -> game.validateCount(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 자동차생성() {
        RacingGame game = new RacingGame();
        String carNames = "pobi,woni,jun";

        game.createCars(carNames);
        List<Car> cars = game.getCars();

        assertThat(cars).isNotNull();
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
    }

    @Test
    void 시도횟수저장() {
        RacingGame game = new RacingGame();
        String tryCountInput = "5";
        game.saveTryCount(tryCountInput);
        assertThat(game.getTryCount()).isEqualTo(5);
    }

    @Test
    void 선수가4를받으면전진한다() {
        RacingGame game = new RacingGame();
        game.createCars("pobi");
        Car pobi = game.getCars().get(0);
        pobi.move(4);
        assertThat(pobi.getPosition()).isEqualTo(1);
    }

    @Test
    void 선수가3을받으면정지한다() {
        RacingGame game = new RacingGame();
        game.createCars("pobi");
        Car pobi = game.getCars().get(0);
        pobi.move(3);
        assertThat(pobi.getPosition()).isEqualTo(0);
    }
}

