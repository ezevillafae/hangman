# Caso de uso: Session Finder

## Responsabilidad
La clase [SessionFinder]() se encarga de buscar una [Session]() por nombre de usuario.
## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    parcipant SessionFinder
    SessionFinder ->> SessionResponse: User name
    SessionResponse ->> DomainSessionFinder :User name
    DomainSessionFinder ->> SessionResponse: Session session
    SessionResponse ->> SessionFinder : SessionResponse user
````

### Dependencias
- [DomainSessionFinder]()