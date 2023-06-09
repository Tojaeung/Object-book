package chapter2.movie.step1.pricing;

import chapter2.movie.step1.Money;
import chapter2.movie.step1.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
	private Money discountAmount;


	public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
		super(conditions);
		this.discountAmount = discountAmount;
	}


	@Override
	protected Money getDiscountAmount(Screening screening) {
		return discountAmount;
	}

}
