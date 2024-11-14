package edu.eci.cvds.NotificationService.Service;


import org.thymeleaf.context.Context;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@Service
public class TemplateLateEngine {
    private final TemplateEngine templateEngine;

public TemplateLateEngine(TemplateEngine templateEngine){
    this.templateEngine=templateEngine;
}
    

/**
 * Procesa una plantilla Thymeleaf con un contexto dado.
 * 
 * @param templateName El nombre de la plantilla (sin la extensión .html)
 * @param context      El contexto que contiene las variables a usar en la plantilla
 * @return Una cadena con el contenido procesado
 */
public String process(String templateName, Context context) {
    return templateEngine.process(templateName, context);
    }
}