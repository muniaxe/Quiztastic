package quiztastic.core;

import java.util.Objects;

/**
 * How do we store categories?
 */
public class Category {

    private final String name;

    public Category(String name) {
        this.name = name;
        if (name == null)
            throw new NullPointerException();

        if (name.equals(""))
            throw new IllegalArgumentException("The name should not be empty");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
