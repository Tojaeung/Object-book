package chapter1.theater.step3;

public class Audience {
	private Bag bag;

	public Audience(Bag bag) {
		this.bag = bag;
	}

	// 캡슐화
	// public Bag getBag() {
	// return bag;
	// }

	// 관객이 스스로 티켓을 구매, 판단하는 자율적인 존재가 되었다.
	public Long buy(Ticket ticket) {
		return bag.hold(ticket);
	}

}
