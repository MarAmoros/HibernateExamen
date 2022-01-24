package examen.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @Column(name = "idGame")
    private int idGame;

    @Column(name = "idCharacter")
    private int idCharacter;

    @Column(name = "Date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "idAdventure")
    private AdventureEntity adventureEntity;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "games",cascade = CascadeType.ALL)
    private List<ChoicesEntity> choices;

    public GameEntity() {
    }

    public GameEntity(int idGame, int idCharacter, Date date, AdventureEntity adventureEntity, UserEntity userEntity, List<ChoicesEntity> choices) {
        this.idGame = idGame;
        this.idCharacter = idCharacter;
        this.date = date;
        this.adventureEntity = adventureEntity;
        this.userEntity = userEntity;
        this.choices = choices;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(int idCharacter) {
        this.idCharacter = idCharacter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AdventureEntity getAdventureEntity() {
        return adventureEntity;
    }

    public void setAdventureEntity(AdventureEntity adventureEntity) {
        this.adventureEntity = adventureEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<ChoicesEntity> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoicesEntity> choices) {
        this.choices = choices;
    }
}
