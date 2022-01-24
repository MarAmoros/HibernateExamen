package examen.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@NotNull
	@Column(name = "idUser")
	private int idUser;

	@Column(name = "Username")
	private String username;

	@Column(name = "Password")
	private String password;

	@OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
	private List<GameEntity> gameEntityList;

	public UserEntity() {
	}

	public UserEntity(int idUser, String username, String password, List<GameEntity> gameEntityList) {
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.gameEntityList = gameEntityList;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<GameEntity> getGameEntityList() {
		return gameEntityList;
	}

	public void setGameEntityList(List<GameEntity> gameEntityList) {
		this.gameEntityList = gameEntityList;
	}
}
