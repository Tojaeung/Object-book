package chapter2.movie.step2.pricing;

import chapter2.movie.step2.Money;
import chapter2.movie.step2.Screening;

class NoneDiscountPolicy implements DiscountPolicy {
	@Override
	public Money calculateDiscountAmount(Screening screening) {
		return Money.ZERO;
	}

}
