# Caso de uso: Session Finder

## Responsabilidad
La clase [SessionFinder]() se encarga de buscar una [Session]() por nombre de usuario.
## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant SessionFinder
    participant DomainSessionFinder
    SessionFinder ->> DomainSessionFinder:User
    DomainSessionFinder ->> SessionFinder:SessionResponse
  
````

### Dependencias
- [DomainSessionFinder]()