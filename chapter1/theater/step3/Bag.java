package chapter1.theater.step3;

public class Bag {
	private Long amount;
	private Invitation invitation;
	private Ticket ticket;

	public Bag(Long amount) {
		this(amount, null); // 아래 생성자를 이용해서 중복최소화
	}

	public Bag(Long amount, Invitation invitation) {
		this.amount = amount;
		this.invitation = invitation;
	}

	// 초대장을 가지고 있는지 여부
	private boolean hasInvitation() {
		return invitation != null;
	}

	// 초대장으로 티켓을 받거나 티켓을 돈주고 구매하거나
	private void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	// 초대장 없으면 티켓구매 -> 가방에 돈 소비
	private void minusAmount(Long amount) {
		this.amount -= amount;
	}

	// 가방은 비록 무생물이지만 자율적인 존재가 되어 초대장이 있는지 스스로 확인한다.(객체지향의 세계 의인화)
	public Long hold(Ticket ticket) {
		if (hasInvitation()) {
			setTicket(ticket);
			return 0L;
		} else {
			setTicket(ticket);
			minusAmount(ticket.getFee());
			return ticket.getFee();
		}
	}
}
