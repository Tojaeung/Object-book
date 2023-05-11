package chapter2.movie.step2.pricing;

import chapter2.movie.step2.Screening;

public class SequenceCondition implements DiscountCondition {
	private int sequence;

	public SequenceCondition(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return screening.isSequence(sequence);
	}

}
