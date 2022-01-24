package examen.entity;

import com.sun.xml.internal.ws.developer.SchemaValidation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "characters")
public class CharacterEntity {

	@Id
	@Column(name = "idCharacter")
	private int idCharacter;

	@Column(name = "CharacterName")
	private String characterName;

	@ManyToMany(mappedBy = "characterEntities",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<AdventureEntity> adventureEntities;

	public CharacterEntity() {
	}

	public CharacterEntity(int idCharacter, String characterName, List<AdventureEntity> adventureEntities) {
		this.idCharacter = idCharacter;
		this.characterName = characterName;
		this.adventureEntities = adventureEntities;
	}

	public int getIdCharacter() {
		return idCharacter;
	}

	public void setIdCharacter(int idCharacter) {
		this.idCharacter = idCharacter;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public List<AdventureEntity> getAdventureEntities() {
		return adventureEntities;
	}

	public void setAdventureEntities(List<AdventureEntity> adventureEntities) {
		this.adventureEntities = adventureEntities;
	}
}
