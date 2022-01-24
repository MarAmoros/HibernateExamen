package examen.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "adventure")
public class AdventureEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAdventure")
	private int idAdventure;

	@OneToMany(mappedBy = "adventureEntity",cascade = CascadeType.ALL)
	private List<BystepAdventureEntity> bystepAdventureEntities;

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "adventure_has_characters",
			joinColumns = { @JoinColumn(name = "adventure_idAdventure") },
			inverseJoinColumns = { @JoinColumn(name = "characters_idCharacter") }
	)
	private List<CharacterEntity> characterEntities;

	public AdventureEntity() {
	}

	public AdventureEntity(int idAdventure, List<BystepAdventureEntity> bystepAdventureEntities, String name, String description, List<CharacterEntity> characterEntities) {
		this.idAdventure = idAdventure;
		this.bystepAdventureEntities = bystepAdventureEntities;
		this.name = name;
		this.description = description;
		this.characterEntities = characterEntities;
	}

	public int getIdAdventure() {
		return idAdventure;
	}

	public void setIdAdventure(int idAdventure) {
		this.idAdventure = idAdventure;
	}

	public List<BystepAdventureEntity> getBystepAdventureEntities() {
		return bystepAdventureEntities;
	}

	public void setBystepAdventureEntities(List<BystepAdventureEntity> bystepAdventureEntities) {
		this.bystepAdventureEntities = bystepAdventureEntities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CharacterEntity> getCharacterEntities() {
		return characterEntities;
	}

	public void setCharacterEntities(List<CharacterEntity> characterEntities) {
		this.characterEntities = characterEntities;
	}
}
