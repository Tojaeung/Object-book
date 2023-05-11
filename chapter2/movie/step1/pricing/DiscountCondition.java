package chapter2.movie.step1.pricing;

import chapter2.movie.step1.Screening;

public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}
