# Exercício de POO — Funcionários

Resolução em Java da imagem, seguindo o estilo do exemplo `contaBancaria`: classes em arquivos separados, atributos privados, construtores, getters/setters e uma lista de objetos no `App`.

## Executar

Requer JDK 8 ou superior. Na pasta do projeto:

```sh
mkdir -p bin
javac -encoding UTF-8 -d bin src/*.java
java -cp bin App
```

Neste ambiente, o compilador está disponível como módulo Java, sem o comando `javac` no PATH. Use:

```sh
mkdir -p bin
java -m jdk.compiler/com.sun.tools.javac.Main -encoding UTF-8 -d bin src/*.java
java -cp bin App
```

## Como a solução atende ao enunciado

- `Funcionario` é a superclasse abstrata: concentra `nome`, `cpf` e o contrato `calcularSalario()`.
- `Vendedor`, `Consultor` e `Gerente` herdam de `Funcionario`, chamam `super` no construtor e sobrescrevem `calcularSalario()` com `@Override`.
- Vendedor: salário mínimo + comissão por venda × número de vendas.
- Consultor: valor por hora × horas trabalhadas.
- Gerente: 6 × salário mínimo + bonificação.
- `App` cria um objeto de cada tipo e os percorre em `ArrayList<Funcionario>`, exibindo nome, tipo e salário por polimorfismo.
- O salário mínimo de R$ 1.500,00 é fictício, apenas para demonstrar os cálculos; pode ser alterado no `App`.

Com os valores do exemplo, os salários são R$ 2.500,00, R$ 12.800,00 e R$ 11.000,00, respectivamente.

## Extensão: controle de ponto

`RegistroPonto` associa um funcionário a uma entrada e uma saída com `LocalDateTime`. Cada objeto representa um turno; podem existir vários registros para o mesmo funcionário. A saída é registrada depois da entrada e não pode precedê-la nem ser registrada duas vezes. O exemplo usa horários fixos para ser reproduzível; em uso real é possível fornecer `LocalDateTime.now()`.

O ponto não altera automaticamente as horas do consultor: o enunciado define esse valor separadamente e não estabelece regras de intervalo ou arredondamento. Não é necessário usar `instanceof`, pois não há operação que exija verificar uma subclasse específica. O cálculo salarial permanece polimórfico.

## Validar

```sh
java -m jdk.compiler/com.sun.tools.javac.Main -encoding UTF-8 -d bin src/*.java test/*.java
java -cp bin ExercicioTest
```

Em um JDK com `javac` no PATH, também pode usar `javac -encoding UTF-8 -d bin src/*.java test/*.java`.
