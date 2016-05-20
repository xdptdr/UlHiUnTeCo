package xdptdr.ulhiunteco.test.interception.events;

import org.hibernate.Transaction;

public class TransactionEvent extends HibernateEvent {

	public static enum TransactionEventType {
		AFTER_BEGIN, BEFORE_COMPLETION, AFTER_COMPLETION
	};

	private Transaction transaction;
	private TransactionEventType type;

	public TransactionEvent(TransactionEventType type, Transaction tx) {
		this.type = type;
		this.transaction = tx;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public TransactionEventType getType() {
		return type;
	}

	@Override
	public boolean MatchNotNull(HibernateEvent other) {
		if (other == null) {
			return false;
		}
		if (other instanceof TransactionEvent) {
			if (((TransactionEvent) other).getType() != this.getType()
					&& ((TransactionEvent) other).getType() != null) {
				return false;
			}
			if (((TransactionEvent) other).getTransaction() != this.getTransaction()
					&& ((TransactionEvent) other).getTransaction() != null) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
}
