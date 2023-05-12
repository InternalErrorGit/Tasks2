package net.internalerror.mytasks.data;

import androidx.room.Entity;

import java.util.Date;

@Entity
public class Task {

    private long id;

    private String name;

    private Date deadline;

    private boolean completed;


}
