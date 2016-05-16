package xdptdr.ulhiunteco.bd;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "MESSAGE_BD")
@Entity
public class MessageBD {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "TEXT")
	private String text;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="NEXT_MESSAGE")
	private MessageBD nextMessage;

	public MessageBD() {
	}

	public MessageBD(String text) {
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MessageBD getNextMessage() {
		return nextMessage;
	}

	public void setNextMessage(MessageBD nextMessage) {
		this.nextMessage = nextMessage;
	}

}
