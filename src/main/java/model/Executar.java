package model;


import dao.util.Fabrica;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Random;


public class Executar {

	public static String generateString()
	{
        Random rng = new Random();
        String characters = "abcdefghijklmnopqrstuvxz0123456789";
        int length = rng.nextInt(10) + 3;
		char[] text = new char[length];

		for (int i = 0; i < length; i++)
		{
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}

	public static void main(String[] args) {


        Address a = new Address();
		a.setCep(generateString());
		a.setCity(generateString());
		a.setNeighborhood(generateString());
		a.setNumber(generateString());
		a.setStreet(generateString());

		Person p = new Person();
		p.setBornDate(new Date());
		p.setCellphone(generateString());
		p.setEmail(generateString());
		p.setName(generateString());
		p.setSex(generateString());
		p.setTelephone(generateString());
		p.setAddress(a);

		Userr u = new Userr();
		u.setAdmin(false);
		u.setRegisterDate(new Date());
		u.setUsername(generateString());
		u.setPerson(p);

        Auction auc = new Auction();
        auc.setEndDate(new Date());
        auc.setName(generateString());
        auc.setOwner(u);
        auc.setStarDate(new Date());
        auc.setWindow_time(new Date());

        Item i = new Item();
        i.setName(generateString());
        i.setPrice(2.55);
        i.setQuantity(3);
        i.setAuction(auc);

        Item i2 = new Item();
        i2.setName(generateString());
        i2.setPrice(98.4);
        i2.setQuantity(2);
        i2.setAuction(auc);

        Bid bid = new Bid();
        bid.setBidTime(new Date());
        bid.setValue(265.3);
        bid.setItem(i);
        bid.setUser(u);

        Inscription ins = new Inscription();
        ins.setUser(u);
        ins.setAuction(auc);


		try {
			EntityManager em = Fabrica.getEntityManager();
			em.getTransaction().begin();
			em.persist(auc);
            em.persist(i);
            em.persist(i2);
            em.persist(bid);
            em.persist(ins);
			em.getTransaction().commit();

		} catch (NullPointerException e) {
			System.out.println("Proprietario nao encontrado!");
		}

		Fabrica.fecharFabrica();

	}
}
