# Caso de uso: session tryer

## Responsabilidad
La clase SessionTryer busca la [Session]() de un usuario pidiendosela a [DomainSessionFinder]() para luego pedirle al [DomainSessionTryer]()
que intente con una letra teniendo en cuenta los intentos maximos en la Session encontrada.

## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant SessionTryer
    participant DomainSessionFinder
    participant DomainSessionTryer
    SessionTryer ->> DomainSessionFinder : find(user);
    DomainSessionFinder -->> SessionTryer : session
    SessionTryer ->> DomainSessionTryer : execute(session, character, MAX_TRIES);
    
````

### Dependencias
- [DomainSessionTryer]()
- [DomainSessionFinder]()