package edu.eci.cvds.NotificationService.Model;

import java.time.LocalDateTime;

public class Notification {
    private long id;
    private String message;
    private LocalDateTime time;
    private long bookID;
    private long studentID;
    private long ResponsableID;
    private String state;
    private NotificationType type;
    private Double mount;
    
    public Notification(){

    }

    public Notification(long id,NotificationType type,LocalDateTime time, long bookID, long studentID, long ResponsableID, String state,  String message, double mount){
        this.id = id;
        this.type=type;
        this.time=time;
        this.bookID= bookID;
        this.studentID=studentID;
        this.ResponsableID=ResponsableID;
        this.state = state;
        this.message = message;
        this.mount=mount;
    }

    //getters
    public long getId(){
        return id;
    }

    public String getmessage(){
        return message;
    
    }

    public LocalDateTime getLocaldate(){
        return time;

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

    public NotificationType getType(){
        return type;
    }
    
    public double getMount(){
        return mount;
    }

    //setters

    public void setId(long id){
        this.id=id;
    }

    public void setmessage(String message){
        this.message=message;
    }

    public void setLocaldate(LocalDateTime time){
        this.time=time;
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

    public void setType(NotificationType type){
        this.type=type;
    }

    public void setMount(double mount){
        this.mount=mount;
}
}

