# Caso de uso: Session Finder

## Responsabilidad
La clase [SessionFinder]() se encarga de buscar una [Session]() por nombre de usuario.
## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    parcipant SessionFinder
    SessionFinder --> SessionResponse:Username
    SessionResponse --> DomainSessionFinder:Username
    DomainSessionFinder --> SessionResponse:Session
    SessionResponse --> SessionFinder:SessionResponse
  
````

### Dependencias
- [DomainSessionFinder]()