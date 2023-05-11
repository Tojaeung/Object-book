package chapter2.movie.step1;

import java.time.Duration;
import chapter2.movie.step1.pricing.DiscountPolicy;

public class Movie {
	private String title;
	private Duration runningTime;
	private Money fee;
	// 합성(Compositie)는 상속보다 재사용성이 좋다.
	private DiscountPolicy disCountPolicy;

	public Movie(String title, Duration runningTime, Money fee, DiscountPolicy disCountPolicy) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.disCountPolicy = disCountPolicy;
	}

	public Money getFee() {
		return fee;
	}

	/**
	 * 할인유형과 할인조건을 확인하여 가격(fee)를 변경한다.
	 *
	 * @param screening
	 * @return 할인된 후의 가격 (최종 가격)
	 */
	public Money calculateMovieFee(Screening screening) {
		return fee.minus(disCountPolicy.calculateDiscountAmount(screening));
	}

}
