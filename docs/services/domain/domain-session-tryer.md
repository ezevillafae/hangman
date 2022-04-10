# Caso de uso: Domain session tryer

## Responsabilidad
La clase [DomainSessionTryer]() se encarga de pedirle a [Session]() que intente con una letra, al obtener
una respuesta se determina si fue un intento exitoso, un intento fallido o si la sesión termina.
En el caso de que termine la session se arroja una excepción [SessionFinished](). Una session puede terminar
si se completó la palabra o si se terminaron los intentos.

## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant DomainSessionTryer
    participant Session
    
    DomainSessionTryer ->>  Session: intenta con la letra 'a'
    Session -->> DomainSessionTryer: posiciones de la letra 'a'
    DomainSessionTryer ->>  Session: guarda la letra 'a' en esas posiciones
    
````

### Dependencias
- [DomainSessionFinder]()
- [SessionRepository]()