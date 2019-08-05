# CashDesk
******************************************************************
Система **_Кассовый_ _Аппарат_**. _Кассир_ может открыть чек, добавить
выбранные товары по коду из базы данных (петрушка = 234, хлеб = 222) или
по названию товара, указать кол-во товаров или вес. Закрыть чек. _Старший_
_кассир_ может отменить чек, отменить один товар в чеке и вернуть деньги
покупателю. Сделать X и Z отчеты. _Товаровед_ может создавать товары и
указывать их кол-во на складе.
*******************************************************************
# Общие требования

**Необходимо построить веб-приложение, поддерживающую следующую
функциональность:**
1. На основе сущностей предметной области создать классы их
описывающие.
2. **Классы** и **методы** должны иметь отражающую их функциональность
названия и должны быть грамотно структурированы по пакетам
3. Информацию о предметной области хранить в **БД**, для доступа
использовать **API JDBC** с использованием пула соединений,
стандартного или разработанного самостоятельно. В качестве **СУБД**
рекомендуется **MySQL**.
4. **Приложение** должно поддерживать работу с **кириллицей** (быть
многоязычной), в том числе и при хранении информации в БД.
5. Код должен быть **документирован**.
6. Приложение должно быть покрыто **Юнит-тестами**
7. При разработке бизнес логики использовать **сессии** и **фильтры**, и
события в системе обрабатывать с помощью **Log4j**.
8. В приложении необходимо реализовать **Pagination**, **Transaction** в
зависимости от Вашего проекта
9. Используя **сервлеты** и **JSP**, реализовать функциональности,
предложенные в постановке конкретной задачи.
10. В страницах **JSP** применять библиотеку **JSTL**
11. Приложение должно корректно реагировать на ошибки и исключения
разного рода (Пользователь никогда не должен видеть **stack-trace** на
стороне **front-end**).
12. В приложении должна быть реализована система **Авторизации** и
**Аутентификации**
*********************************************************************
# Инструкция по установке
1. Создать базу данных по EER диаграме.
*![screenshot of sample](https://github.com/diasel2000/CashDesk/blob/master/src/main/webapp/images/EER.png)

