# :bust_in_silhouette: Proxy

:heavy_check_mark: Поведенческий паттерн, позволяющий подставлять вместо реальных объектов - объекты заменители, которые позволяют выполнять действия до и после передачи действия оригиналу

:heavy_check_mark: Ленивая инициализация, в случае тяжелого объекта

:heavy_check_mark: Кеширование объектов, управляет жизненным циклом сервисного объекта

:heavy_check_mark: Контролирует служебный объект независимо от клиента

:x: Увеличивает время отклика от сервиса

:x: Усложняет код из-за введения дополнительных классов

:arrow_forward: `java.lang.reflect.Proxy`

:arrow_forward: `javax.inject.Inject`

:arrow_forward: `javax.persistence.PersistenceContext`