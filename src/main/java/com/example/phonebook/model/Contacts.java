package com.example.phonebook.model;

import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "phone_number")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String patronymic;
    @NonNull
    private String phoneNumber;
    private String email;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
