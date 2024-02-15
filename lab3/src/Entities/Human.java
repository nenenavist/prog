package Entities;

import Enums.Gender;

public abstract class Human {
    protected String name;
    protected Gender sex;

    public void setName(String name){
        this.name = name;
    }

    public void setGender(Gender gender){
        this.sex = gender;
    }
    public Gender getGender(Gender gender){
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



