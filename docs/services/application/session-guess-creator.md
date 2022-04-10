# Caso de uso: Session Guess Creator

## Responsabilidad
La clase [SessionGuessCreator]() es la responsable de crear una [Session]() con un Usuario por defecto.

## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    machine SessionGuessCreator
    SessionGuessCreator ->> SessionRepository: Session session
````

### Dependencias
- [SessionRepository]()