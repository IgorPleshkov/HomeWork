package Home_work.Stream;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PupilTask {

    private static Collection<Object> key;

    public static void main(String[] args) {
        // обращение к enum Gender через имя класса - Pupil.Gender

        // Используя Stream API:
        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        // 2. Найти средний возраст учеников
        // 3. Найти самого младшего ученика
        // 4. Найти самого старшего ученика
        // 5. Собрать учеников в группы по году рождения
        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        // 8. Вывести в консоль всех учеников в возрасте от N до M лет
        // 9. Собрать в список всех учеников с именем=someName
        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола

        List<Pupil> pupils = new ArrayList<>();
        pupils.add(new Pupil("Иван", "Иванов", LocalDate.parse("1985-05-19"), Pupil.Gender.MALE));
        pupils.add(new Pupil("Петр", "Иванов", LocalDate.parse("1985-03-02"), Pupil.Gender.MALE));
        pupils.add(new Pupil("Иван", "Александров", LocalDate.parse("1984-09-29"), Pupil.Gender.MALE));
        pupils.add(new Pupil("Владимир", "Власов", LocalDate.parse("1992-07-03"), Pupil.Gender.MALE));
        pupils.add(new Pupil("Мария", "Иванова", LocalDate.parse("1987-05-19"), Pupil.Gender.FEMALE));
        pupils.add(new Pupil("Денис", "Денисов", LocalDate.parse("1984-01-28"), Pupil.Gender.MALE));
        pupils.add(new Pupil("Юлия", "Петрова", LocalDate.parse("1981-06-15"), Pupil.Gender.FEMALE));
        pupils.add(new Pupil("Виктория", "Павлова", LocalDate.parse("1980-08-12"), Pupil.Gender.FEMALE));
        pupils.add(new Pupil("Мария", "Ковалева", LocalDate.parse("1988-11-11"), Pupil.Gender.FEMALE));

        //1
        Map<Pupil.Gender, ArrayList<Pupil>> mapGenderInfo = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));
        System.out.println(mapGenderInfo);

        //2
        Double middleAge = pupils.stream().map(pupilAge -> Period.between(pupilAge.getBirthDate(), LocalDate.now()).getYears()
        ).collect(Collectors.averagingInt(x -> x)).doubleValue();
        System.out.println("Средний возраст учеников: " + middleAge);

        //3
        Pupil minAgePupil = pupils.stream().min(Comparator.comparing(pupilAge ->
                Period.between(pupilAge.getBirthDate(), LocalDate.now()).getYears())).orElse(null);
        System.out.println("Самый младший ученик: " + minAgePupil);

        //4
        Pupil maxAgePupil = pupils.stream().max(Comparator.comparing(pupilAge ->
                Period.between(pupilAge.getBirthDate(), LocalDate.now()).getYears())).orElse(null);
        System.out.println("Самый старший ученик: " + maxAgePupil);

        //5
        Map<Integer, ArrayList<Pupil>> mapYearInfo = pupils.stream()
                .collect(Collectors.groupingBy(year -> year.getBirthDate().getYear(), Collectors.toCollection(ArrayList::new)));
        System.out.println(mapYearInfo);

        //6
        Map<String, LocalDate> mapNameDate = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getName, Collectors.toCollection(ArrayList::new)))
                .entrySet().stream().filter(s -> s.getValue().size() == 1)
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().get(0).getBirthDate()));
        System.out.println(mapNameDate);

        // 7
        List<Pupil> sortPupil = pupils.stream()
                .sorted(Comparator.comparing(Pupil::getGender))
                .sorted(Comparator.comparing(Pupil::getBirthDate))
                .sorted(Comparator.comparing(Pupil::getName, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println(sortPupil);

        //8
        pupils.stream().filter(age -> Period.between(age.getBirthDate(), LocalDate.now()).getYears() >= 32
                && Period.between(age.getBirthDate(), LocalDate.now()).getYears() <= 35).forEach(System.out::println);

        //9
        pupils.stream().filter(name -> name.getName().equals("Иван")).forEach(System.out::println);

        //10
        Map<Pupil.Gender, Integer> sumAge = pupils.stream()
                .collect(Collectors.toMap(Pupil::getGender, v -> Period.between(v.getBirthDate(), LocalDate.now()).getYears(), (v1, v2) -> v1 + v2));
        System.out.println(sumAge);


    }
}