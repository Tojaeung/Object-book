package chapter2.movie.step2.pricing;

import chapter2.movie.step2.Money;
import chapter2.movie.step2.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
	private double percent;

	public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
		super(conditions);
		this.percent = percent;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return screening.getMovieFee().times(percent);
	}

}
