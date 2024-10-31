# README del Módulo de Notificaciones y Alertas

## Descripción General

El **Módulo de Notificaciones y Alertas** está diseñado para gestionar las comunicaciones automatizadas que se envían a los responsables económicos y a los estudiantes. Este módulo garantiza que todas las partes interesadas estén informadas sobre el estado de los préstamos de libros, facilitando la gestión eficiente del sistema.

## Tipos de Notificaciones

El módulo envía diferentes tipos de notificaciones en función de eventos específicos:

1. **Notificación de Préstamo Realizado**:
   - Enviada al responsable económico cuando un estudiante toma prestado un libro.
   - Incluye la fecha límite de devolución.

2. **Recordatorio de Préstamo por Vencer**:
   - Enviada tres días antes de la fecha límite de devolución del libro.

3. **Notificación de Préstamo Vencido**:
   - Enviada el mismo día en que el préstamo vence, alertando sobre la falta de devolución.

4. **Notificación de Multa** (opcional):
   - En caso de que se establezca una política de multas, se envía una notificación con el monto adeudado si el préstamo no se devuelve en la fecha estipulada.

## Condiciones de Activación

Las notificaciones se activan bajo las siguientes condiciones:

- **Préstamo Realizado**: 
  - Se genera inmediatamente después de que el administrador registra un nuevo préstamo en el sistema.

- **Préstamo por Vencer**: 
  - Se activa automáticamente cuando faltan 3 días para la fecha de devolución.

- **Préstamo Vencido**: 
  - Se genera automáticamente en la fecha de vencimiento del préstamo.

- **Multas (opcional)**: 
  - Se activa al registrar el monto por día de retraso en la devolución, notificando al responsable económico.

## Integración

Este módulo puede integrarse con servicios de mensajería (como correos electrónicos o notificaciones push) para asegurar que las notificaciones sean entregadas de manera efectiva. 

## Contribuciones

Se anima a los desarrolladores a contribuir con mejoras o correcciones. Para contribuir, por favor sigue las pautas de contribución en este repositorio.

## Licencia

