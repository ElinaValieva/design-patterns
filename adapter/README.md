# :arrows_clockwise: Adapter 

:heavy_check_mark: Структурный паттерг позволяющий работать классам с несовместимым интерфейсом вместе

:heavy_check_mark: Скрывает от клиента способность преобразования форматов

:x: Усложняет код из-за создания дополнительных классов

:arrow_forward: public static List<T> asList(T... a)
  
:arrow_forward: `public static ArrayList<T> list(Enumeration<T> e)`
  
:arrow_forward: `public static Enumeration<T> enumeration(Collection<T> c)`
