# Caso de uso: Domain session finder

## Responsabilidad
La clase [DomainSessionFinder]() tiene la responsabilidad de buscar una [Session]() alojada en un [SessionRepository]()
 indicándole un nombre de usuario. En caso de que la session no exista se arrojará una excepción [SessionNotExists]()

## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant DomainSessionFinder
    participant SessionRepository
    DomainSessionFinder ->> SessionRepository: User name
    SessionRepository ->> DomainSessionFinder: Session
````

### Dependencias
- [SessionRepository]()