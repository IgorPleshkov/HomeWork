package com.itmo.jjd.lesson6.HomeWork1;

public class Alpinist {
    private String name;
    private String address;

    public Alpinist(String name, String address) {
        setName(name);
        setAddress(address);
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().length() < 3) throw new IllegalArgumentException("Имя не может быть меньше 3-х символов!");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.trim().length() < 5) throw new IllegalArgumentException("Адрес не может быть меньше 5-ти символов!");
        this.address = address;
    }

    public String getAlpinistInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ").append(name).append(" Адрес: ").append(address);
        return sb.toString();
    }
}
