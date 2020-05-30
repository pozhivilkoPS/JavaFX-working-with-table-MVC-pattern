package sample;

import sample.Model.FootballPlayer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class FootballPlayerGenerator {
    String[] names={
            "Кочерёжкин Максим Якубович",
            "Шурша Семен Кондратиевич",
            "Долгоруков Никанор Леонович",
            "Галыгин Моисей Назарович",
            "Копцев Измаил Андреевич",
            "Клюев Ярослав Прохорович",
            "Капишников Петр Андриянович",
            "Шадрин Игнатий Яковович",
            "Гаголин Валентин Александрович",
            "Соломин Максимильян Иосифович",
            "Куклин Артемий Касьянович",
            "Кутяков Тимур Демьянович",
            "Смирнитский Евгений Модестович",
            "Мальцев Никита Серафимович",
            "Любимцев Мирон Сергеевич",
            "Суслов Валентин Иннокентиевич",
            "Акулиничев Яков Владимирович",
            "Кубланов Василий Валерьянович",
            "Куликов Владлен Гаврилевич",
            "Жигунов Демьян Никифорович",
            "Забиров Николай Самсонович",
            "Филипов Яков Евгениевич",
            "Достоевский Павел Кондратович",
            "Шулёв Андриян Сергеевич",
            "Чазов Виталий Дмитриевич",
            "Толбугин Никанор Проклович",
            "Рыбяк Ипполит Иосифович",
            "Митрохин Ким Матвеевич",
            "Домаш Максимильян Брониславович",
            "Ахматов Анатолий Эрнстович",
            "Другов Андриян Панкратиевич",
            "Енютин Денис Самуилович",
            "Лебединцев Мирон Алексеевич",
            "Белкин Вацлав Яковович",
            "Бузыцков Наум Никитевич",
            "Ширинов Клавдий Эдуардович",
            "Янушко Савелий Никифорович",
            "Ягупов Николай Артемович",
            "Кривоухов Никон Глебович",
            "Яробкин Викентий Федотович",
            "Бабин Герасим Фролович",
            "Жестакова Кондрат Геннадиевич",
            "Рыков Архип Тимурович",
            "Кривонос Герасим Серафимович",
            "Ящин Юлиан Викентиевич",
            "Сухоруков Вениамин Эдуардович",
            "Яламов Никанор Михаилович ",
            "Киселев Алексей  Несторович ",
            "Лукьяненко Евграф Трофимович",
            "Жигунов Всеслав Трофимович" };
    public static int number = 0;

        

        public FootballPlayer generate(){
            FootballPlayer tmp=new FootballPlayer();
        for(int currentNumber=0;currentNumber<50;currentNumber++) {
            if (currentNumber == number) {
                number++;
                tmp.setName(names[currentNumber]);
                Random random = new Random();
                int day = Math.abs(random.nextInt() % 28) + 1;
                int month = Math.abs(random.nextInt() % 12) + 1;
                int year = Math.abs(random.nextInt() % 30) + 1970;
                tmp.setDateBirthday(day, month, year);
                tmp.setTeam("Команда" + Math.abs(random.nextInt() % 3));
                tmp.setTown("Город" + Math.abs(random.nextInt() % 3));
                if (Math.abs(random.nextInt() % 2) == 0)
                    tmp.setCast("Основной");
                else
                    tmp.setCast("Запасной");
                if (Math.abs(random.nextInt() % 11) == 0)
                    tmp.setPosition("Ворота");
                else if (Math.abs(random.nextInt() % 11) > 5)
                    tmp.setPosition("Атака");
                else
                    tmp.setPosition("Защита");
                break;
            }
        }

        return tmp;
    }


}
