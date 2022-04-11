# Caso de uso: Session Guess Creator

## Responsabilidad
La clase [SessionGuessCreator]() es la responsable de crear una [Session]() con un Usuario por defecto. La diferencia de
esta clase con SessionDefaultCreator es que esta no tiene dependencia con DomainWordRandomPicker, es decir no se elije una
palabra aleatoria, sino que se requiere una palabra para crear el [Session]()

## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant SessionGuessCreator
    participant Session
    participant SessionRepository
    SessionGuessCreator ->> Session: USER_MACHINE and Word
    Session -->> SessionGuessCreator: session
    SessionGuessCreator -->> SessionRepository: save(session)
````

### Dependencias
- [SessionRepository]()