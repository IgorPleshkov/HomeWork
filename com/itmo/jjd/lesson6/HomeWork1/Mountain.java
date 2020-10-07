package com.itmo.jjd.lesson6.HomeWork1;

public class Mountain {
    private String name;
    private String country;
    private int height;

    public Mountain(String name, String country, int height) {
        setName(name);
        setCountry(country);
        setHeight(height);

        this.name = name;
        this.country = country;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().length() < 4) throw new IllegalArgumentException("Наименование не может быть меньше 4 символов!");
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country.trim().length() < 4) throw new IllegalArgumentException("Страна не может быть меньше 4 символов!");
        this.country = country;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 100) throw new IllegalArgumentException("Высота не может быть меньше 100м!");
        this.height = height;
    }

    public String getMountainInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Наименование: ").append(name).
                                    append("\nСтрана: ").
                                    append(country).
                                    append("\nВысота: ").
                                    append(height);
        return sb.toString();
    }
}
