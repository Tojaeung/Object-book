package chapter1.theater.step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
	private Long amount;
	private List<Ticket> tickets = new ArrayList<>();

	/**
	 * @param amount
	 * @param tickets 가변인자, 배열로 들어온다.
	 */
	public TicketOffice(Long amount, Ticket... tickets) {
		this.amount = amount;
		this.tickets.addAll(Arrays.asList(tickets)); // 배열로 들어오기때문에 List 자료형으로 변경
	}

	private Ticket getTicket() {
		return tickets.remove(0);
	}

	private void plusAmount(Long amount) {
		this.amount += amount;
	}

	// 무생물이지만 자율적인 존재가 되어 티켓을 판매하고 있다.
	// 단점으로 관객에 대한 의존성이 생긴다.
	public void sellTicketTo(Audience audience) {
		plusAmount(audience.buy(getTicket()));
	}

}
