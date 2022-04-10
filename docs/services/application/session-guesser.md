# Caso de uso: Session Guesser

## Responsabilidad
Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sit amet odio nunc. Sed venenatis posuere
scelerisque. Pellentesque hendrerit orci non nisi placerat accumsan.

## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    Alice ->> Bob: Hello Bob, how are you?
    Bob-->>John: How about you John?
    Bob--x Alice: I am good thanks!
    Bob-x John: I am good thanks!
    Note right of John: Bob thinks a long<br/>long time, so long<br/>that the text does<br/>not fit on a row.

    Bob-->Alice: Checking with John...
    Alice->John: Yes... John, how are you?
````

### Dependencias
- [DomainSessionFinder]()
- [DomainSessionTryer]()