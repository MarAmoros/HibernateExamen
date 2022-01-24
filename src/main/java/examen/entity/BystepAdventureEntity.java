package examen.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bystep_adventure")
public class BystepAdventureEntity {

	@Id
	@Column(name = "idByStep_Adventure")
	private int idByStepAdventure;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "idAdventure")
	private AdventureEntity adventureEntity;

	@Column(name = "Description")
	private String description;

	@Column(name = "Final_Step")
	private byte finalStep;

	@OneToMany(mappedBy = "bystepAdventure",cascade = CascadeType.ALL)
	private List<ChoicesEntity> choices;

	public BystepAdventureEntity() {
	}

	public BystepAdventureEntity(int idByStepAdventure, AdventureEntity adventureEntity, String description, byte finalStep, List<ChoicesEntity> choices) {
		this.idByStepAdventure = idByStepAdventure;
		this.adventureEntity = adventureEntity;
		this.description = description;
		this.finalStep = finalStep;
		this.choices = choices;
	}

	public int getIdByStepAdventure() {
		return idByStepAdventure;
	}

	public void setIdByStepAdventure(int idByStepAdventure) {
		this.idByStepAdventure = idByStepAdventure;
	}

	public AdventureEntity getAdventureEntity() {
		return adventureEntity;
	}

	public void setAdventureEntity(AdventureEntity adventureEntity) {
		this.adventureEntity = adventureEntity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getFinalStep() {
		return finalStep;
	}

	public void setFinalStep(byte finalStep) {
		this.finalStep = finalStep;
	}

	public List<ChoicesEntity> getChoices() {
		return choices;
	}

	public void setChoices(List<ChoicesEntity> choices) {
		this.choices = choices;
	}
}
