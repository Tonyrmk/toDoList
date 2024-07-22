package com.todoList.entity.mok;

import lombok.*;

import javax.validation.constraints.Size;
import java.util.Date;


@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ToDo {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    private String user;
    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    @Size(min = 10, message = "Enter 10 Characters at least.")
    private String desc;
    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    private Date targetDate;
    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    private boolean isDone;

    public ToDo(){

    }


}
