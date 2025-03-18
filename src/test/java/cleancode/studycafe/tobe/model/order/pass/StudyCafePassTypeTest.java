package cleancode.studycafe.tobe.model.order.pass;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassTypeTest {

    @Test
    @DisplayName("1인 고정석 결제 시 사물함 이용 가능")
    void fixedPass_CanUseLocker() {
        // given
        StudyCafePassType passType = StudyCafePassType.FIXED;

        // when
        boolean canUseLocker = passType.isLockerType();

        // then
        assertThat(canUseLocker).isTrue();
    }

    @Test
    @DisplayName("시간권 결제 시 사물함 이용 불가능")
    void hourlyPass_CannotUseLocker() {
        // given
        StudyCafePassType passType = StudyCafePassType.HOURLY;

        // when
        boolean canUseLocker = passType.isLockerType();

        // then
        assertThat(canUseLocker).isFalse();
    }

    @Test
    @DisplayName("주간권 결제 시 사물함 이용 불가능")
    void weeklyPass_CannotUseLocker() {
        // given
        StudyCafePassType passType = StudyCafePassType.WEEKLY;

        // when
        boolean canUseLocker = passType.isLockerType();

        // then
        assertThat(canUseLocker).isFalse();
    }
}