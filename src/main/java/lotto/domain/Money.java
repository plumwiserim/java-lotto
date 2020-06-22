package lotto.domain;

import static lotto.domain.Lotto.LOTTO_GAME_PRICE;

public class Money {

    private int money;

    public Money(String money) {
        this(Integer.parseInt(money));
    }

    public Money(int inputMoney) {
        if (inputMoney < LOTTO_GAME_PRICE) {
            throw new IllegalArgumentException("돈이 " + LOTTO_GAME_PRICE + "원 보다 작을 수 없습니다.");
        }
        this.money = inputMoney;
    }

    public int getBuyCount() {
        return this.money / LOTTO_GAME_PRICE;
    }

}
