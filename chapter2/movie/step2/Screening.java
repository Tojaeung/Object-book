package chapter2.movie.step2;

import java.time.LocalDateTime;

public class Screening {
	private Movie movie;
	private int sequence;
	private LocalDateTime whenScreened;

	public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
		this.movie = movie;
		this.sequence = sequence;
		this.whenScreened = whenScreened;
	}

	public LocalDateTime getStartTime() {
		return whenScreened;
	}

	// 순번 일치 여부 조사
	public boolean isSequence(int sequence) {
		return this.sequence == sequence;
	}

	public Money getMovieFee() {
		return movie.getFee();
	}

	public Reservation reserve(Customer customer, int audienceCount) {
		// 여기서 this는 Screening 자신을 말한다.
		return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
	}

	// 자율성을 위해 캡슐화 한다.
	private Money calculateFee(int audienceCount) {
		// 여기서 this는 Screening 자신을 말한다.
		return movie.calculateMovieFee(this).times(audienceCount);
	}

}
