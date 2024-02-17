package Place;

import Entities.Rich;

public class Company {
    private String name;
    private Building[] own;
    private Rich owner;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Building[] getOwn() {
        return own;
    }

    public void setOwn(Building[] own) {
        this.own = own;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company= (Company) o;
        return java.util.Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name);
    }

    @Override
    public String toString() {
        return  this.getName();
    }
}

