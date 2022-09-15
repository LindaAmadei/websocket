package co.develhope.Web.Socket1.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SimpleMessageDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String type;
    private String message;


    public SimpleMessageDTO(String s){}

    public SimpleMessageDTO(String type, String message){
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

