package model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Auction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String name;
    private Date starDate;
    private Date endDate;
    private Date window_time;
	
	@JoinColumn()
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Userr owner;
	
	
	public Auction() {
		
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getWindow_time() {
        return window_time;
    }

    public void setWindow_time(Date window_time) {
        this.window_time = window_time;
    }

    public Userr getOwner() {
        return owner;
    }

    public void setOwner(Userr owner) {
        this.owner = owner;
    }
}