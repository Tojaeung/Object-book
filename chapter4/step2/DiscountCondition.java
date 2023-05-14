package chapter4.step2;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
	private DiscountConditionType type;

	private int sequence;

	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;

	// 캡슐화 실패
	public DiscountConditionType getType() {
		return type;
	}

	// 캡슐화 실패
	// 만약 DiscountCondition의 속성이 변경 된다면, 이 함수의 파라미터는 물론 의존하는 함수들도 변경되야한다.
	public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
		if (type != DiscountConditionType.PERIOD)
			throw new IllegalArgumentException();

		return this.dayOfWeek.equals(dayOfWeek) &&
				this.startTime.compareTo(time) <= 0 &&
				this.endTime.compareTo(time) >= 0;
	}

	// 캡슐화 실패
	// 만약 DiscountCondition의 속성이 변경 된다면, 이 함수의 파라미터는 물론 의존하는 함수들도 변경되야한다.
	public boolean isDiscountable(int sequence) {
		if (type != DiscountConditionType.SEQUENCE)
			throw new IllegalArgumentException();

		return this.sequence == sequence;
	}
}
