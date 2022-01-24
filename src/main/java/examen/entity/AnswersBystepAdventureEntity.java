package examen.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "answers_bystep_adventure")
public class AnswersBystepAdventureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAnswers_ByStep_Adventure")
    private int idAnswersByStepAdv;

    @Column(name = "Description")
    private String description;

    @Column(name = "Resolution_Anwer")
    private String resolutionAnswer;

    @OneToMany(mappedBy = "answersBystepAdventure",cascade = CascadeType.ALL)
    private List<ChoicesEntity> choices;

    public AnswersBystepAdventureEntity() {
    }

    public AnswersBystepAdventureEntity(int idAnswersByStepAdv, String description, String resolutionAnswer, List<ChoicesEntity> choices) {
        this.idAnswersByStepAdv = idAnswersByStepAdv;
        this.description = description;
        this.resolutionAnswer = resolutionAnswer;
        this.choices = choices;
    }

    public int getIdAnswersByStepAdv() {
        return idAnswersByStepAdv;
    }

    public void setIdAnswersByStepAdv(int idAnswersByStepAdv) {
        this.idAnswersByStepAdv = idAnswersByStepAdv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolutionAnswer() {
        return resolutionAnswer;
    }

    public void setResolutionAnswer(String resolutionAnswer) {
        this.resolutionAnswer = resolutionAnswer;
    }

    public List<ChoicesEntity> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoicesEntity> choices) {
        this.choices = choices;
    }
}
