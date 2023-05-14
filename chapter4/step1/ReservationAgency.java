package chapter4.step1;

public class ReservationAgency {
	public Reservation reserve(Screening screening, Customer customer,
			int audienceCount) {
		Movie movie = screening.getMovie();

		boolean discountable = false;
		for (DiscountCondition condition : movie.getDiscountConditions()) {
			if (condition.getType() == DiscountConditionType.PERIOD) {
				discountable =
						screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek())
								&&
								condition.getStartTime()
										.compareTo(screening.getWhenScreened().toLocalTime()) <= 0
								&&
								condition.getEndTime()
										.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
			} else {
				discountable = condition.getSequence() == screening.getSequence();
			}

			if (discountable) {
				break;
			}
		}

		// fee의 타입이 변경되면 영향을 받는다.
		// 결합도가 강하다.. (안좋다.)
		Money fee;
		if (discountable) {
			Money discountAmount = Money.ZERO;
			switch (movie.getMovieType()) {
				case AMOUNT_DISCOUNT:
					discountAmount = movie.getDiscountAmount();
					break;
				case PERCENT_DISCOUNT:
					discountAmount = movie.getFee().times(movie.getDiscountPercent());
					break;
				case NONE_DISCOUNT:
					discountAmount = Money.ZERO;
					break;
			}

			fee = movie.getFee().minus(discountAmount).times(audienceCount);
		} else {
			fee = movie.getFee().times(audienceCount);
		}

		return new Reservation(customer, screening, fee, audienceCount);
	}
}

