# Adapter

+ Структурный паттерг позволяющий работать классам с несовместимым интерфейсом вместе
+ Скрывает от клиента способность преобразования форматов
- Усложняет код для создания дополнительных классов
- public static List<T> asList(T... a)
- public static ArrayList<T> list(Enumeration<T> e)
- public static Enumeration<T> enumeration(Collection<T> c)
