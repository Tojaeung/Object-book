package chapter2.movie.step2.pricing;

import chapter2.movie.step2.Money;
import chapter2.movie.step2.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
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
