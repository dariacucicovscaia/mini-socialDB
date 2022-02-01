package domain;


public class User{
	private int id;
	private String nickname;
	private String email;
	private String password;

	public User() {

	}

	public User(int id, String nickname, String email, String password) {
		super();
		setId(id);
		setNickname(nickname);
		setEmail(email);
		setPassword(password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
