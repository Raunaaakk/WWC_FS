import java.util.*;
class Student {
    private String id , name;
    private int marks ;

    public Student(String id, String name, int marks) {
        this.id = id;
        this.name  = name;
        this.marks = marks;
    }

    public String getId(){
        return id;
    }
    public int getMarks(){
        return marks;
    }

    public String getRole()
    {
        return "undergrade";
    }
    @Override
    public String toString(){
        return id + " " + name + " (" + marks + ")" + getRole();
    }
};

class Teacher {
    private String id, name;

    public Teacher(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void printReport(Student s) {
        System.out.println("ID: " + s.getId());
        System.out.println("Marks: " + s.getMarks());
        System.out.println("Role: " + s.getRole());
    }
}


class GraduateStudent extends Student {
    private String area;

    public GraduateStudent(String id, String name, int marks, String area) {
        super(id, name, marks);
        this.area = area;
    }

    @Override
    public String getRole() {
        return "Grad(" + area + ")";
    }
}
    class Repository<T>
    {
        private Map<String , T> data = new HashMap<>();

        public void save(String id, T obj) {
            data.put(id, obj);
        }
        public T find(String id)
            {
                return data.get(id);
            }
        public void delete(String id) {
            data.remove(id);
        }
    }

    public class Main
    {
        public static void main(String[] args)
        {
            List<Student> list = new ArrayList<>();
            list.add(new Student("s1" ,"Tarak", 100));
            list.add(new Student("s2" ,"Rom", 90));
            list.add(new Student("s1" ,"Tilak", 86));
            list.add(new GraduateStudent("g1","Ansh",100 ,"CSE" ));

            Repository<Student> repo = new Repository<>();

            for (Student s : list) {
                repo.save(s.getId(), s);
            }
            System.out.println("ALL:");
            list.forEach(System.out::println);
            System.out.println("\n LOOKUP S2: ");
            Student s = repo.find("s2");
            System.out.println(s != null ? s : "NOT FOUND");


            Teacher t = new Teacher("T1", "Mr. John");
            System.out.println("\nREPORT FOR s1:");
            t.printReport(repo.find("s1"));

            Iterator<Student> itr = list.iterator();
            while (itr.hasNext()) {
                Student next = itr.next();
                System.out.println(next != null ? next.toString() : "NOT FOUND");
            }
        }
    }
