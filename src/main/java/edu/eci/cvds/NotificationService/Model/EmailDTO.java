package edu.eci.cvds.NotificationService.Model;

public class EmailDTO {

    private String responsableEconomico;
    private String asunto; 
    private String mensaje;
    private String templateName;

    public String getResponsableEconomico() {
        return this.responsableEconomico;
    }

    public void setResponsableEconomico(String responsableEconomico) {
        this.responsableEconomico = responsableEconomico;
    }

    public String getAsunto() {
        return this.asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getTemplateName(){
        return templateName;
    }

    public void setTemplateName(String templateName){
        this.templateName=templateName;
    }
}
