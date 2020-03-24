package com.pnc.onboarding.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private long ssn;
    private long account_no;
    private String account_type;
    private boolean card_issued;
    private Long card_no;
    @Column(name = "user_id")
    private long userid;

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public long getAccount_no() {
        return account_no;
    }

    public void setAccount_no(long account_no) {
        this.account_no = account_no;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public boolean isCard_issued() {
        return card_issued;
    }

    public void setCard_issued(boolean card_issued) {
        this.card_issued = card_issued;
    }

    public long getCard_no() {
        return card_no;
    }

    public void setCard_no(long card_no) {
        if(Objects.isNull(card_no))
            return;
        this.card_no = card_no;
    }
}
