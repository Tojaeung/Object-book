package chapter2.movie.step2.pricing;

import chapter2.movie.step2.Screening;

public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}
