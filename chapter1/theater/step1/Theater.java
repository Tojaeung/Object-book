package chapter1.theater.step1;

public class Theater {
	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public void enter(Audience audience) {
		if (audience.getBag().hasInvitation()) { // 손님이 초대장이 있는 경우 티켓 무료
			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
			audience.getBag().setTicket(ticket);
		} else { // 손님이 초대장이 없다면 티켓 구매
			Ticket ticket = ticketSeller.getTicketOffice().getTicket();

			// 티켓 계산
			audience.getBag().minusAmount(ticket.getFee());
			ticketSeller.getTicketOffice().plusAmount(ticket.getFee());

			audience.getBag().setTicket(ticket);
		}
	}

}
