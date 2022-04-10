# Caso de uso: Session Guess Creator

## Responsabilidad
La clase [SessionGuessCreator]() es la responsable de crear una [Session]() con un Usuario por defecto.

## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    machine SessionGuessCreator
    SessionGuessCreator --> Session: User name, Word word
    Session ->> SessionGuessCreator: Session session
    SessionGuessCreator ->> SessionRepository: Session session
````

### Dependencias
- [SessionRepository]()