package chapter2.movie.step1.pricing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import chapter2.movie.step1.Money;
import chapter2.movie.step1.Screening;

public abstract class DiscountPolicy {
	private List<DiscountCondition> conditions = new ArrayList<>();

	public DiscountPolicy(DiscountCondition... conditions) {
		this.conditions = Arrays.asList(conditions);
	}

	// 템플릿 메서드: 부모클래스에서 구조만 처리는 자식클래스에서..
	public Money calculateDiscountAmount(Screening screening) {
		for (DiscountCondition condition : conditions) {
			// 할인 조건에 하나라도 해당된다면 할인된 금액을 반환한다.
			if (condition.isSatisfiedBy(screening)) {
				// 자식클래스에 있는 getDiscountAmount를 호출
				return getDiscountAmount(screening);
			}
		}

		// 할인 조건에 해당하지 않는다면 할인 금액은 0원이다.
		return Money.ZERO;
	}

	abstract protected Money getDiscountAmount(Screening screening);

}
