package chapter4.step2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Movie {
	private String title;
	private Duration runningTime;
	private Money fee;
	private List<DiscountCondition> discountConditions;

	private MovieType movieType;
	private Money discountAmount;
	private double discountPercent;

	// 캡슐화 실패
	public MovieType getMovieType() {
		return movieType;
	}

	// 캡슐화 실패
	// 만약 할인정책이 추가되거나 제거되면 어떻하나... 생각만 해도 끔찍한 변경이 예상된다..
	public Money calculateAmountDiscountedFee() {
		if (movieType != MovieType.AMOUNT_DISCOUNT)
			throw new IllegalArgumentException();

		return fee.minus(discountAmount);
	}

	// 캡슐화 실패
	// 만약 할인정책이 추가되거나 제거되면 어떻하나... 생각만 해도 끔찍한 변경이 예상된다..
	public Money calculatePercentDiscountedFee() {
		if (movieType != MovieType.PERCENT_DISCOUNT)
			throw new IllegalArgumentException();

		return fee.minus(fee.times(discountPercent));
	}

	// 캡슐화 실패
	// 만약 할인정책이 추가되거나 제거되면 어떻하나... 생각만 해도 끔찍한 변경이 예상된다..
	public Money calculateNoneDiscountedFee() {
		if (movieType != MovieType.NONE_DISCOUNT)
			throw new IllegalArgumentException();

		return fee;
	}

	public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
		for (DiscountCondition condition : discountConditions) {
			if (condition.getType() == DiscountConditionType.PERIOD) {
				if (condition.isDiscountable(whenScreened.getDayOfWeek(),
						whenScreened.toLocalTime()))
					return true;
			} else {
				if (condition.isDiscountable(sequence))
					return true;
			}
		}

		return false;
	}
}
