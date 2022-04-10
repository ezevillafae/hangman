# Caso de uso: Session Guesser

## Responsabilidad
La clase [SessionGuesser]() intenta adivinar la [Word]() probando caracteres meidante [DomainSessionTryer]() del usuario por defecto Machine.

## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    machine SessionGuesser
    SessionGuesser ->> SessionFinder:User
    SessionGuesser ->> SessionTryher: Character
    SessionResponse ->> SessionGuesser :Session

````

### Dependencias
- [DomainSessionFinder]()
- [DomainSessionTryer]()