package chapter1.theater.step2;

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

	public Ticket getTicket() {
		return tickets.remove(0);
	}

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public void plusAmount(Long amount) {
		this.amount += amount;
	}
}
