package Entities;

import Enums.Gender;

public abstract class Human {
    private String name;
    private Gender sex;
    public Human(String name, Gender sex){
        this.name = name;
        this.sex = sex;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGender(Gender sex){
        this.sex = sex;
    }
    public Gender getGender(){
        return sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entities.Human human= (Entities.Human) o;
        return java.util.Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name);
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return  this.getName();
    }
}



