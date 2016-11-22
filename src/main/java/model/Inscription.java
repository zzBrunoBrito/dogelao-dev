package model;

import javax.persistence.*;

@Entity
public class Inscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@JoinColumn()
	@OneToOne()
    private Userr user;
	
	@JoinColumn()
	@OneToOne
    private Auction auction;
	
	public Inscription() {
		
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Userr getUser() {
        return user;
    }

    public void setUser(Userr user) {
        this.user = user;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
