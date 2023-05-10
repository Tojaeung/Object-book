package chapter1.theater.step2;

public class TicketSeller {
	private TicketOffice ticketOffice;

	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}

	// 캡슐화
	// public TicketOffice getTicketOffice() {
	// return ticketOffice;
	// }

	// 판매원이 스스로 판매를 하는 자율적인 존재가 되었다.
	public void sellTo(Audience audience) {
		ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
	}
}
