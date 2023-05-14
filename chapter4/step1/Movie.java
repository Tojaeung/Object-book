package chapter4.step1;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Movie {
	private String title;
	private Duration runningTime;
	private Money fee;
	private List<DiscountCondition> discountConditions;

	private MovieType movieType;
	private Money discountAmount;
	private double discountPercent;

	public MovieType getMovieType() {
		return movieType;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	// 접근자와 수정자 메서드(getter,setter)는 캡슐화하지 못한다.
	// fee라는 이름을 가진 인스턴스 변수를 인터페이스에 노골적으로 표출한다.
	public Money getFee() {
		return fee;
	}

	public List<DiscountCondition> getDiscountConditions() {
		return Collections.unmodifiableList(discountConditions);
	}

	public void setDiscountConditions(List<DiscountCondition> discountConditions) {
		this.discountConditions = discountConditions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Money getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Money discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
}
