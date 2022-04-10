# Caso de uso: Session Guesser

## Responsabilidad
La clase [SessionGuesser]() intenta adivinar la [Word]() probando caracteres meidante [DomainSessionTryer]() del usuario por defecto Machine.

## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    machine SessionGuesser
    SessionGuesser ->> SessionFinder:User_Machine
    SessionFinder ->> SessionGuesser: Session session
    SessionGuesser ->> DomainSessionTryer: Session session, Character character
    SessionGuesser ->> DomainSessionGuesser :Session session, Character character
    SessionResponse ->> SessionGuesser: Session session

````

### Dependencias
- [DomainSessionFinder]()
- [DomainSessionTryer]()