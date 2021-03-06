package Resource;

import java.util.ListResourceBundle;

public class ResourceRussian extends ListResourceBundle {
    public static final Object[][] contents = {
            {"loginField", "Логин"},
            {"passwordField", "Пароль"},
            {"loginButton", "Вход"},
            {"registerButton", "Регистрация"},
            {"username", "Имя пользователя"},
            {"execute_script", "Выполнить скрипт"},
            {"clear", "Очистить"},
            {"remove", "Удалить"},
            {"logout", "Выход"},
            {"name", "Имя"},
            {"coordinate_x", "Координата X"},
            {"coordinate_y", "Координата Y"},
            {"area", "Площадь"},
            {"population", "Популяция"},
            {"meters", "Высота над уровнем моря"},
            {"climate", "Климат"},
            {"government", "Правительство"},
            {"standard", "Качество жизни"},
            {"human", "Имя человека"},
            {"ok", "OK"},
            {"add", "Добавить"},
            {"edit", "Редактировать"},
            {"add_if_min", "Добавить если минимальный"},
            {"remove_greater", "Удалить больше"},
            {"remove_lower", "Удалить меньше"},
            {"id", "ID"},
            {"coordinates", "Координаты"},
            {"x", "X"},
            {"y", "Y"},
            {"creation_date", "Время создания"},
            {"governor", "Губернатор"},
            {"sorting_and_filtration", "Сортировка и Фильтрация"},
            {"column", "Колонка"},
            {"order", "Порядок"},
            {"parameter", "Параметр"},
            {"remove_rule", "Удалить правило"},
            {"sort_text", "Сортировать по"},
            {"cancel", "Отмена"},
            {"none", "Ничего"},
            {"sort_increase", "Сортировка по возрастанию"},
            {"sort_decrease", "Сортировка по убыванию"},
            {"files_path", "Расположение файла"},
            {"empty_line", "Введена пустая строка."},
            {"false_requirements", "Введенная строка не соответствует требованиям."},
            {"not_an_option", "Введён несуществующий тип."},
            {"false_arguments", "Что-то не так с введенными аргументами."},
            {"not_a_command", "Введённой команды не существует."},
            {"server_unavailable", "Сервер недоступен."},
            {"empty_account", "Вы не можете отправлять команды, войдите или зарегистрируйтесь."},
            {"error", "Ошибка"},
            {"main", "Главная"},
            {"map", "Карта"},
            {"start", "Начало"},
            {"app", "Приложение"}
    };

    public Object[][] getContents() {
        return contents;
    }
}
