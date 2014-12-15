package nicebank;

public class Account {

	private TransactionQueue queue = new TransactionQueue();

	public void credit(MonetaryAmount amount) {
		queue.write("+" + amount.toString());
	}

	public void debit(int dollars) {
		MonetaryAmount amount = new MonetaryAmount(dollars, 0);
		queue.write("-" + amount.toString());
	}

	public MonetaryAmount getBalance() {
		return BalanceStore.getBalance();
	}

}
