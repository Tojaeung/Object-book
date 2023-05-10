package chapter1.theater.step2;

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
		if (bag.hasInvitation()) {
			bag.setTicket(ticket);
			return 0L;
		} else {
			bag.setTicket(ticket);
			bag.minusAmount(ticket.getFee());
			return ticket.getFee();
		}
	}

}
