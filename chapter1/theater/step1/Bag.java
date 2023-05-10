package chapter1.theater.step1;

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
	public boolean hasInvitation() {
		return invitation != null;
	}

	// 티켓을 가지고 있는지 여부
	public boolean hasTicket() {
		return ticket != null;
	}

	// 초대장으로 티켓을 받거나 티켓을 돈주고 구매하거나
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	// 초대장 없으면 티켓구매 -> 가방에 돈 소비
	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public void plusAmount(Long amount) {
		this.amount += amount;
	}
}
