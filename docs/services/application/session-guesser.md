# Caso de uso: Session Guesser

## Responsabilidad
La clase [SessionGuesser]() intenta adivinar la [Word]() probando caracteres mediante [DomainSessionTryer]() del 
usuario por defecto Machine.

## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant SessionGuesser
    participant DomainSessionFinder
    participant DomainSessionTryer
    SessionGuesser ->> DomainSessionFinder : find(USER_MACHINE)
    DomainSessionFinder -->> SessionGuesser: session
    loop 
        SessionGuesser ->> DomainSessionTryer: execute(session, character, max_tries)
    end
    Note left of SessionGuesser: Luego se crea un SessionResponse
````

### Dependencias
- [DomainSessionFinder]()
- [DomainSessionTryer]()