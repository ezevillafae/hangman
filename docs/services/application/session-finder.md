# Caso de uso: Session Finder

## Responsabilidad
La clase [SessionFinder]() tiene la única responsabilidad de crear un [SessionResponse]() luego de haberle pedido a [DomainSessionFinder]()
que encuentre una [Session]().
## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant SessionFinder
    participant DomainSessionFinder
    SessionFinder ->> DomainSessionFinder: user
    DomainSessionFinder -->> SessionFinder: session
    Note left of SessionFinder: Luego se crea el SessionResponse
````

### Dependencias
- [DomainSessionFinder]()