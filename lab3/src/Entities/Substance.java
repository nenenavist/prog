package Entities;

public abstract class Substance {
    private String name;

    public Substance(){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Substance substance = (Substance) o;
        return java.util.Objects.equals(name, substance.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name);
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return  this.getName();
    }
}

