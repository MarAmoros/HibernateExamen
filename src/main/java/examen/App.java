package examen;

import examen.dao.AdventureDao;
import examen.dao.CharacterDao;
import examen.dao.UserDao;
import examen.dao.impl.AdventureDaoImpl;
import examen.dao.impl.CharacterDaoImpl;
import examen.dao.impl.UserDaoImpl;
import examen.entity.AdventureEntity;
import examen.entity.CharacterEntity;
import examen.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class App {
/* TODO:
    DONE 1. CHOICES ENTITY
    DONE 2. CHOICES DAO
    3. TEST THAT EVERY DAO WORKS PROPERLY
*/
	public static void main(String[] args) {

	/*TODO:
	   1. CHARACTER
	   2. ADVENTURE
	   3. GAME
	   DONE 4. USER
	   5. BY STEP ADVENTURE
	   6. ANSWERS BY STEP ADVENTURE
	   7. CHOICES
		*/
		//CHARACTER


			AdventureDao adventureDao = new AdventureDaoImpl();
			CharacterDao characterDao = new CharacterDaoImpl();
			CharacterEntity characterEntity= new CharacterEntity(1,"tusMuertos",adventureDao.findAll());
			CharacterEntity characterEntity2= new CharacterEntity(2,"2character2",adventureDao.findAll());
		//SAVE OR UPDATE
			characterDao.saveOrUpdate(characterEntity);
			characterDao.saveOrUpdate(characterEntity2);
		//GET
			System.out.println("id: "+characterDao.get(1).getIdCharacter()+"nombre: "+characterDao.get(1).getCharacterName());
			System.out.println("id: "+characterDao.get(2).getIdCharacter()+"nombre: "+characterDao.get(2).getCharacterName());
		//FIND ALL
			characterDao.findAll().forEach(entity -> System.out.println("id: "+entity.getIdCharacter()+"nombre: "+ entity.getCharacterName()));
		//DELETE
			characterDao.delete(2);

	//WORKS:
		/*//USER
			UserDao userDao = new UserDaoImpl();
			UserEntity user = new UserEntity(2,"holaaa","23453");
		//SAVE OR UPDATE
			System.out.println(user.getIdUser());
			userDao.saveOrUpdate(user);
		//GET
			UserEntity user1= userDao.get(1);
			UserEntity user0= userDao.get(2);
			System.out.println("User0: "+user0.getIdUser()+user0.getUsername());
			System.out.println("User1: "+user1.getIdUser()+user1.getUsername());
		//FIND ALL
			userDao.findAll().forEach(entity -> System.out.println("id: "+entity.getIdUser()+"name: "+ entity.getUsername()));
		//DELETE works
			userDao.delete(0);*/


	}

}
