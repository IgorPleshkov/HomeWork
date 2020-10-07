package com.itmo.jjd.lesson6.HomeWork1;

import java.util.Arrays;

public class AlpinistGroup {
    private boolean groupIsCompleted;
    private Alpinist[] alpinists;
    private Mountain mountain;
    private int maxNumberOfPersons = 10;
    private int minNumberOfPersons = 1;


    public AlpinistGroup (int numberOfPersons, Mountain mountain){
        if (numberOfPersons < minNumberOfPersons || numberOfPersons > maxNumberOfPersons)
            throw new IllegalArgumentException("Количество человек в группе не может быть меньше 3-х");
        alpinists = new Alpinist[numberOfPersons];
        this.mountain = mountain;
    }

   // public AlpinistGroup(boolean groupIsCompleted) {
   //     setGroupIsCompleted(groupIsCompleted);
   //     this.groupIsCompleted = groupIsCompleted;
    // }

    public int getMaxNumberOfPersons() {
        return maxNumberOfPersons;
    }

    public void setMaxNumberOfPersons(int maxNumber) {
        if (maxNumber > maxNumberOfPersons) throw new IllegalArgumentException("Группа не может превышать 10 чел.!");
        this.maxNumberOfPersons = maxNumber;
    }

    public int getMinNumberOfPersons() {
        return minNumberOfPersons;
    }

    public void setMinNumberOfPersons(int minNumber) {
        if (minNumber < minNumberOfPersons) throw new IllegalArgumentException("Группа не может быть меньше 1 чел.!");
        this.minNumberOfPersons = minNumber;
    }

    public boolean getGroupIsCompleted() {
        return groupIsCompleted;
    }

    public void setGroupIsCompleted(boolean groupIsCompleted) {
        this.groupIsCompleted = groupIsCompleted;
    }

    public void addAlpinist(Alpinist alpinist) {
        if (groupIsCompleted) {
            throw new IllegalArgumentException("Группа " + "\"" + mountain.getName() + "\"" + " уже скомплектована!");
        }
        for (int i = 0; i < alpinists.length; i++){
            if (alpinists[i] == null){
              alpinists[i] = alpinist;
              return;
            }
        }
        groupIsCompleted = true;
        throw new IllegalArgumentException("Мест в группе " + "\"" + mountain.getName() + "\"" + " нет!");
    }

    public String groupInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Гора: ").append(mountain.getName())
                .append("\nСтрана: ")
                .append(mountain.getCountry())
                .append("\nВысота: ")
                .append(mountain.getHeight())
                .append("\nГруппа скомплектована: ")
                .append(groupIsCompleted)
                .append("\nСостав группы: ");
        for (Alpinist s: alpinists){
            if (s != null){
                sb.append(" \n- ").append(s.getName()).append(", ").append(s.getAddress());
            }
        }
        sb.append("\n");
        return sb.toString();
    }


    @Override
    public String toString() {
        return "AlpinistGroup{" +
                "groupIsCompleted=" + groupIsCompleted +
                ", alpinists=" + Arrays.toString(alpinists) +
                ", mountain=" + mountain +
                '}';
    }
}
