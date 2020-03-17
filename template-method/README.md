# :robot: Template Method 

:heavy_check_mark: Поведенческий паттерн позволяющий определить шаги алгоритма в базовом классе, делегируя некоторые шаги алгоритма его подклассам

:heavy_check_mark: Использует наследование, чтобы расширить шаги алгоритма

:x: Жестко ограничены шагами алгоритма

:x: С ростом шагов, тяжело поддерживать

:x: Нарушение принципа Барбары Лисков

:arrow_forward: public abstract class AbstractList<E>
  
:arrow_forward: public abstract class AbstractSet<E>

:arrow_forward: public abstract class AbstractMap<E>

