# Java Design Patterns ![Java CI with Gradle](https://github.com/ElinaValieva/design-patterns/workflows/Java%20CI%20with%20Gradle/badge.svg?branch=master)

|Creational|Structural|Behavioral|
|--|--|--|
|:hammer_and_wrench: [Abstract Factory](https://github.com/ElinaValieva/design-patterns/tree/master/abstract_factory)|:memo: [Adapter](https://github.com/ElinaValieva/design-patterns/tree/master/adapter)|:running: [Chain of responsibilities](https://github.com/ElinaValieva/design-patterns/tree/master/chain-responsibilities)|
|:hammer_and_wrench: [Builder](https://github.com/ElinaValieva/design-patterns/tree/master/builder)|:memo: [Bridge](https://github.com/ElinaValieva/design-patterns/tree/master/bridge)| :running: [Command](https://github.com/ElinaValieva/design-patterns/tree/master/command)|
|:hammer_and_wrench: [Prototype](https://github.com/ElinaValieva/design-patterns/tree/master/prototype)|:memo: [Composite](https://github.com/ElinaValieva/design-patterns/tree/master/composite)| :running: [Iterator](https://github.com/ElinaValieva/design-patterns/tree/master/iterator)|
|:hammer_and_wrench: [Factory Method](https://github.com/ElinaValieva/design-patterns/tree/master/factory_method)|:memo: [Decorator](https://github.com/ElinaValieva/design-patterns/tree/master/decorator)|:running: [Memento](https://github.com/ElinaValieva/design-patterns/tree/master/memento)|
|:hammer_and_wrench: [Singleton](https://github.com/ElinaValieva/design-patterns/tree/master/singleton)|:memo: [Facade](https://github.com/ElinaValieva/design-patterns/tree/master/facade)|:running: [Mediator](https://github.com/ElinaValieva/design-patterns/tree/master/mediator)|
|:hammer_and_wrench:[Value object](https://github.com/ElinaValieva/design-patterns/tree/master/value-object)|:memo: [Flyweight](https://github.com/ElinaValieva/design-patterns/tree/master/flyweight)|:running: [Observer](https://github.com/ElinaValieva/design-patterns/tree/master/observer)|
||:memo: [Proxy](https://github.com/ElinaValieva/design-patterns/tree/master/proxy)|:running: [State](https://github.com/ElinaValieva/design-patterns/tree/master/state)|
|||:running: [Strategy](https://github.com/ElinaValieva/design-patterns/tree/master/strategy)|
|||:running: [Template Method](https://github.com/ElinaValieva/design-patterns/tree/master/template-method)|
|||:running: [Visitor](https://github.com/ElinaValieva/design-patterns/tree/master/visitor)|

&nbsp;

## Principles
### :one:   **KISS** - *Keep Is Simple Stupid*
> Не усложняйте код
> Стремитесь к максимально простой архитектуре
> Используйте паттерны проектирования, чтобы не строить велосипед

### :two:   **DRY** - *Don't Repeat Yourself*
> Избегайте дублирования кода

### :three:   **DIE** - *Duplications Is Evil*
> Избегайте дублирования кода

### :four:  **YAGNI** - *You Aren't Gonna Need It*
> Реализовывайте только то, что необходимо. Избегайте неиспользованного кода


### :five:  **SOLID**

#### **S** - Single Responsibilities
> Каждый программный объект имеет только одну отвественность и одно назначение. Идентичен - KISS. 

:heavy_exclamation_mark: Если изменение кода отвечающий за одну ответственность, влечет изменение другой отвественности - нарушение принципа

:heavy_check_mark: Упрощает написание юнит-тестов

:heavy_check_mark: Повышает читабельность

:heavy_check_mark: Помогает снизить связность 

:anger: Chain of responsibilities, ~~Singleton~~

#### **O** - Open/Close
> Расширяйте классы, но не изменяйте их первоначальный код.

:heavy_exclamation_mark: `Открытость для расширения` - поведение сущностей может быть расширено за счет внедрения новых сущностей

:heavy_exclamation_mark: `Закрытость для изменения` - исходный код неприкасаем

:anger: Abstract Factory, Factory Method, Bridge, Chain of responsibilities, Command, Observer, Strategy, ~~Singleton~~

#### **L** - Liskov Substitution
> Подкласс должен дополнять, но не замещать поведение супер-класса

:heavy_exclamation_mark: Тип возвращаемого значения метода подкласса должно совпадать или быть подклассом возвращаемого значения супер-класса

:heavy_exclamation_mark: Тип аргумента метода подкласса должно совпадать или быть более абстрактным

:heavy_exclamation_mark: Метод подкласса не должен выбрасывать исключения не свойственные базовому классу.

:heavy_exclamation_mark: Подкласс не должен изменять значение приватных полей базового класса

:anger: ~~Template Method~~

#### **I** - Interface Segregation
> Избегайте использования монолитного интерфейса, клиенты не должны зависеть от методов, которые они не используют

:heavy_exclamation_mark: Интерфейсы должны быть узкими, чтобы классам не пришлось реализовывать избыточное поведение

#### **D** - Dependency Inversion
> Классы верхнего уровня (бизнес логика) не должны зависеть от классов нижнего уровня (низко-уровневые операции). Оба уровня должны зависеть от абстракции, но абстракция не зависит от деталей, только детали зависят от абстракции. 

:anger: Bridge
