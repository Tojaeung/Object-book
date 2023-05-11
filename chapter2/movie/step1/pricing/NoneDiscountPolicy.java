package chapter2.movie.step1.pricing;

import chapter2.movie.step1.Money;
import chapter2.movie.step1.Screening;

class NoneDiscountPolicy extends DiscountPolicy {

	// 부모클래스 DiscountPolicy를 보면, 할인정책이 없다면 getDiscountAmount를 호출하지 않는다.
	// 그러니까, NoneDiscountPolicy의 getDiscountAmount 메서드는 굳이 필욜없다는 말이다.
	@Override
	protected Money getDiscountAmount(Screening screening) {
		return Money.ZERO;
	}

}
