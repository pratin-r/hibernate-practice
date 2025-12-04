package org.example.teacher;

import org.example.laptop.Laptop;
import jakarta.persistence.*;

import java.util.List;

@Entity // Entity allows the class to be represented as a table.
@Table(name = "teachers") // This annotation is used to map the data in the class to the table in database.
public class Teacher {
    @Id
    @Column(name = "teacher_id")
    private int id;
    @Column(name = "teacher_name")
    private String name;
    @Column(name = "teacher_age")
    private int age;
    /*
    *  When we use transient, the data will not be stored in table.
    *  This is done when some data are not required to be stored in the table.
    */
    @Transient
    private boolean attendance;
//    @OneToOne
//    private Laptop laptop;

    /*
    When we run the Main file without mappedBy, Teacher class creates a teacher_laptop table which contains both teacher_id and laptop_id.
    However, since Laptop class is in ManyToOne, it has teacher_id inside its table to map which Teacher owns the Laptop.
    To prevent the Teacher class from creating teacher_laptop table which is redundant,
    we are using mappedBy which tells that Laptop table will take care of mapping the laptop id by creating a column for foreign key inside its table.
    <-- mappedBy -->
    mappedBy is used on the inverse (non-owning) side of a relationship to point to the field that owns the foreign key.
    In simple words:
        mappedBy tells Hibernate:
        “The other side of this relationship manages the foreign key—NOT me.”
    */
//    @OneToMany(mappedBy = "teacher")
//    private List<Laptop> laptops;

//    @ManyToMany(mappedBy = "teachers")
//    private List<Laptop> laptops;

    /*
    * fetch = FetchType.LAZY or fetch = FetchType.EAGER is only applied for relationship annotation.
    * The below line is done for EAGER and LAZY fetch impl. By default fetch type is LAZY
    * */

    @OneToMany
    private  List<Laptop> laptops;

//    @OneToMany(fetch = FetchType.EAGER)  // making it an EAGER type
//    private List<Laptop> laptops;

    public boolean isAttendance() {
        return attendance;
    }

    public Teacher(){}

    public Teacher(int id, String name, int age, boolean attendance, List<Laptop>  laptops){
        setId(id);
        setName(name);
        setAge(age);
        setAttendance(attendance);
        setLaptops(laptops);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", attendance=" + attendance +
                ", laptops=" + laptops +
                '}';
    }
}
