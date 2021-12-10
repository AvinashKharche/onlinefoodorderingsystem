package org.nyu.onlinefoodorderingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private long contactNumber;
    private Date createdDate;
    private boolean admin;
    private boolean active;

}
