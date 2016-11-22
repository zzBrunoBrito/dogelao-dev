package model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Bid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private Double value;
    private Date bidTime;
	
	@JoinColumn
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Item item;
	
	@JoinColumn
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Userr user;
	
	public Bid() {
		
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Userr getUser() {
        return user;
    }

    public void setUser(Userr user) {
        this.user = user;
    }
}
