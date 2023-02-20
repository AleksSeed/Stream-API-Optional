public class Person {
    private String name;
    private Integer age;

    public String getName(){ return name; }
    public Integer getAge(){ return age; }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "Имя = '" + name + '\'' +
                ", возраст = '" + age + '\'' +
                '}' + "\n";
    }
}
