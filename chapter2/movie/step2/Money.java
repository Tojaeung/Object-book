package chapter2.movie.step2;

import java.math.BigDecimal;

public class Money {
	// 이건 어디에 쓰이는 걸까?
	public static final Money ZERO = Money.wons(0);

	// 자바에서 돈과 소수점을 다룬다면 BigDecimal 사용
	// double은 이진수 근사치를 저장하기 때문에 소수점 정밀도에 한계
	private final BigDecimal amount;

	public Money(BigDecimal amount) {
		this.amount = amount;
	}

	public static Money wons(long amount) {
		return new Money(BigDecimal.valueOf(amount));
	}

	public static Money wons(double amount) {
		return new Money(BigDecimal.valueOf(amount));
	}

	public Money plus(Money money) {
		// add는 BigDecimal의 메서드
		return new Money(this.amount.add(money.amount));
	}

	public Money minus(Money money) {
		// subtract는 BigDecimal의 메서드
		return new Money(this.amount.subtract(money.amount));
	}

	public Money times(double percent) {
		// multiply는 BigDecimal의 메서드
		return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
	}

	public boolean isLessThan(Money money) {
		return amount.compareTo(money.amount) < 0;
	}

	public boolean isGreaterThanOrEqual(Money money) {
		return amount.compareTo(money.amount) >= 0;
	}
}
