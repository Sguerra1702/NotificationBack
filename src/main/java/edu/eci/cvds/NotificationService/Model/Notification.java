package edu.eci.cvds.NotificationService.Model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notificaciones")
public class Notification {

    @Id
    private String id;
    private LocalDate date;
    private String message;
    private String tipo;
    private Long bookID;
    private Long studentID;
    private ResponsableEconomic responsableEconomic;
    private NotificationType type;
    private Double mount;
    private String state;
    
    public Notification() {
    
    }

    
        public Notification(String tipo, String message, LocalDate date, ResponsableEconomic responsableEconomic) {
            this.tipo = tipo;
            this.message = message;
            this.date = date;
            this.responsableEconomic = responsableEconomic;
        }

        public Notification(String id,NotificationType type,LocalDate date, Long bookID, Long studentID, ResponsableEconomic responsableEconomic, String state,  String message, double mount){
        this.id = id;
        this.type=type;
        this.date=date;
        this.bookID= bookID;
        this.studentID=studentID;
        this.responsableEconomic = responsableEconomic;
        this.state = state;
        this.message = message;
        this.mount=mount; 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(NotificationType type) {
        this.type=type;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public LocalDate getdate() {
        return date;
    }

    public NotificationType getType(){
        return type;
    }

    public void setdate(LocalDate date) {
        this.date = date;
    }

    public String getState(){
        return state;
    }

    public void setstate(String state){
        this.state = state;
    }

    public ResponsableEconomic getResponsableEconomic() {
        return responsableEconomic;
    }

    public void setResponsableEconomic(ResponsableEconomic responsableEconomic) {
        this.responsableEconomic = responsableEconomic;
    }

    public void setMount(double mount){
        this.mount=mount;
    }

    public Double getMount(){
        return mount;
    }

    public void setStudentId(Long studentID){
        this.studentID=studentID;
    }

    public Long getStudentId(){
        return studentID;
        
    }

    public Long getBookId(){
        return bookID;

    }

    public void setBookId(Long bookID){
        this.bookID=bookID;
    }

}

