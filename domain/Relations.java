package domain;

public class Relations {
	private int from_user_id;
	private int to_user_id;
	private int type_id;
	private int status_id;

	public Relations() {

	}

	public Relations(int from_user_id, int to_user_id, int type_id, int status_id) {
		super();
		setFrom_user_id(from_user_id);
		setTo_user_id(to_user_id);
		setType_id(type_id);
		setStatus_id(status_id);
	}

	public int getFrom_user_id() {
		return from_user_id;
	}

	public void setFrom_user_id(int from_user_id) {
		this.from_user_id = from_user_id;
	}

	public int getTo_user_id() {
		return to_user_id;
	}

	public void setTo_user_id(int to_user_id) {
		this.to_user_id = to_user_id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

}
