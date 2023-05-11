package chapter2.movie.step2.pricing;

import chapter2.movie.step2.Money;
import chapter2.movie.step2.Screening;

public interface DiscountPolicy {
	Money calculateDiscountAmount(Screening screening);
}

