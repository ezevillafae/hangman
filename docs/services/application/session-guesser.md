# Caso de uso: Session Guesser

## Responsabilidad
La clase [SessionGuesser]() intenta adivinar la [Word]() probando caracteres meidante [DomainSessionTryer]() del usuario por defecto Machine.

## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant SessionGuesser
    parcitipant DomainSessionFinder
    participant DomainSessionTryher
    SessionGuesser ->> DomainSessionFinder:find(user)
    DomainSessionFinder ->> SessionGuesser:Session
    SessionGuesser ->> DomainSessionTryher: execute(session,character, max_tries)
    
````

### Dependencias
- [DomainSessionFinder]()
- [DomainSessionTryer]()