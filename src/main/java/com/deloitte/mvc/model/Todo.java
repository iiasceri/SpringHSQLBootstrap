package com.deloitte.mvc.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "todos")
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "last_change")
    @DateTimeFormat()
    private Date lastChange = new java.util.Date();

//    @Column(name = "due_date")
//    @DateTimeFormat()
//    private Date dueDate = new java.util.Date();

    @Column(name = "todo_status")
    @Enumerated(EnumType.STRING)
    private TodoStatus todoStatus = TodoStatus.TODO;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private User user;

}
