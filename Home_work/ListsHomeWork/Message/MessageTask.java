package Home_work.ListsHomeWork.Message;

import com.itmo.jjd.Lesson15.Collection.Student;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        int summLow = 0, summMedium = 0, summHigh = 0, summUrgent = 0;

        for (Message m : messageList) {
            if (m.getPriority() == MessagePriority.LOW) summLow++;
            if (m.getPriority() == MessagePriority.MEDIUM) summMedium++;
            if (m.getPriority() == MessagePriority.HIGH) summHigh++;
            if (m.getPriority() == MessagePriority.URGENT) summUrgent++;
        }
        System.out.println(
                " LOW - " + summLow +
                        " MEDIUM - " + summMedium +
                        " HIGH - " + summHigh +
                        " URGENT - " + summUrgent);
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        int[] messageCode = new int[10];
        for (int i = 0; i < messageCode.length; i++) {
            for (Message m : messageList) {
                if (m.getCode() == i) {
                    messageCode[i]++;
                }
            }
        }
        for (int i = 0; i < messageCode.length; i++) {
            System.out.println("Сообщений с кодом " + i + " - " + messageCode[i] + " шт.");
        }

    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message> messagesHashSet = new HashSet<>(messageList);
        System.out.println("Количество уникальных сообщений: " + messagesHashSet.size());

    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        Set<Message> uniqueSet = new LinkedHashSet<>(messageList);
        List<Message> uniqueList = new ArrayList<>(uniqueSet);
        return uniqueList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        System.out.println("До удаления: " + messageList);
        Iterator<Message> messageIterator = messageList.listIterator();
        while (messageIterator.hasNext()) {
            if (messageIterator.next().getPriority() == priority) {
                messageIterator.remove();
            }
        }
        System.out.println("После удаления: " + messageList);

    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        System.out.println("До удаления: " + messageList);
        Iterator<Message> messageIterator = messageList.listIterator();
        while (messageIterator.hasNext()) {
            if (messageIterator.next().getPriority() != priority) {
                messageIterator.remove();
            }
        }
        System.out.println("После удаления: " + messageList);
    }

    public static void main(String[] args) {
        // вызов методов

        List<Message> messages = MessageGenerator.generate(10);

        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        System.out.println(uniqueMessagesInOriginalOrder(messages));
        removeEach(messages, MessagePriority.LOW);
        removeOther(messages, MessagePriority.URGENT);

    }
}