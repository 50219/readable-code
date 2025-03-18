package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassOrderTest {

    private StudyCafeSeatPass seatPass;
    private StudyCafeLockerPass lockerPass;
    private StudyCafePassOrder studyCafePassOrder;

    @BeforeEach
    void init() {
        seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15);
        lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);
    }

    @Test
    @DisplayName("고정석 12주권 가격 : 625000원")
    void getTotalPrice() {
        // given
        studyCafePassOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        int totalPrice = studyCafePassOrder.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(625000);
    }

    @Test
    @DisplayName("고정석 12주권의 할인된 가격 : 105000원")
    void getDiscountPrice() {
        // given
        studyCafePassOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        int discountPrice = studyCafePassOrder.getDiscountPrice();

        // then
        assertThat(discountPrice).isEqualTo(105000);
    }

    @Test
    @DisplayName("고정석 1주권 가격 : 100000원")
    void getTotalPriceFor1Week() {
        // given
        seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 1, 100000, 0.0);
        studyCafePassOrder = StudyCafePassOrder.of(seatPass, null);

        // when
        int totalPrice = studyCafePassOrder.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(100000);
    }

    @Test
    @DisplayName("고정석 2주권 가격 : 180000원 (10% 할인)")
    void getTotalPriceFor2Weeks() {
        // given
        seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 2, 200000, 0.1);
        studyCafePassOrder = StudyCafePassOrder.of(seatPass, null);

        // when
        int totalPrice = studyCafePassOrder.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(180000);
    }
}
