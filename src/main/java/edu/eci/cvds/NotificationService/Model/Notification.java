package edu.eci.cvds.NotificationService.Model;

import java.time.LocalDateTime;

public class Notification {
    private long id;
    private String message;
    private LocalDateTime timeNotification;
    private long bookID;
    private long studentID;
    private long ResponsableID;
    private String state;

    public Notification(){
        
    }

    public Notification(long id, String message,LocalDateTime timeNotification, long bookID, long studentID, long ResponsableID, String state){
        this.id = id;
        this.message = message;
        this.timeNotification=timeNotification;
        this.bookID= bookID;
        this.studentID=studentID;
        this.ResponsableID=ResponsableID;
        this.state = state;

    }
    //getters
    public long getId(){
        return id;
    }

    public String getmessage(){
        return message;
    
    }

    public LocalDateTime getLocaldate(){
        return timeNotification;

    }

    public long getBookId(){
        return bookID;

    }

    public long getStudentId(){
        return studentID;
        
    }

    public long getResponsableID(){
        return ResponsableID;
    }

    public String getState(){
        return state;
    }

    //setters

    public void setId(long id){
        this.id=id;
    }

    public void setmessage(String message){
        this.message=message;
    }

    public void setLocaldate(LocalDateTime timeNotification){
        this.timeNotification=timeNotification;
    }

    public void setBookId(long bookID){
        this.bookID=bookID;

    }

    public void setStudentId(long studentID){
        this.studentID=studentID;
    }

    public void setResponsableId(long ResponsableID){
        this.ResponsableID=ResponsableID;
    }

    public void setState(String state){
        this.state=state;
    }

}


