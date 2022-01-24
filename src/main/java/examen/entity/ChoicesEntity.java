package examen.entity;

import com.sun.istack.internal.NotNull;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "choices")
public class ChoicesEntity implements Serializable {

    @Id
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "idGame")
    private  GameEntity games;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "idByStep_Adventure")
    private  BystepAdventureEntity bystepAdventure;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "idAnswers_ByStep_Adventure")
    private  AnswersBystepAdventureEntity answersBystepAdventure ;

    public ChoicesEntity() {
    }

    public ChoicesEntity(GameEntity games, BystepAdventureEntity bystepAdventure, AnswersBystepAdventureEntity answersBystepAdventure) {
        this.games = games;
        this.bystepAdventure = bystepAdventure;
        this.answersBystepAdventure = answersBystepAdventure;
    }

    public GameEntity getGames() {
        return games;
    }

    public void setGames(GameEntity games) {
        this.games = games;
    }

    public BystepAdventureEntity getBystepAdventure() {
        return bystepAdventure;
    }

    public void setBystepAdventure(BystepAdventureEntity bystepAdventure) {
        this.bystepAdventure = bystepAdventure;
    }

    public AnswersBystepAdventureEntity getAnswersBystepAdventure() {
        return answersBystepAdventure;
    }

    public void setAnswersBystepAdventure(AnswersBystepAdventureEntity answersBystepAdventure) {
        this.answersBystepAdventure = answersBystepAdventure;
    }
}
