import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Antilopa> antilopes = new ArrayList<>();
        System.out.println("Введите количество антилоп: ");
        int numberOfAntilopes = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfAntilopes; i++) {
            System.out.println("Введите имя антилопы: ");
            String name = scanner.nextLine();
            System.out.println("Введите скорость антилопы: ");
            double speed = Double.parseDouble(scanner.nextLine());
            antilopes.add(new Antilopa(name, speed));
        }
        System.out.println("Список антилоп: " + antilopes);
        Gepard gepard = new Gepard("Гепа", 5, 80);
        gepard.hunt(antilopes);
        System.out.println("Оставшиеся антилопы: " + antilopes);
    }
}

class Antilopa {
    private String name;
    private double speed;

    public Antilopa(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }
    public String getName() {
        return name;
    }
    public double getSpeed() {
        return speed;
    }
    public String toString() {
        return "Antilopa{name='" + name + "', speed=" + speed + "}";
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Antilopa)) return false;
        Antilopa antilopa = (Antilopa) o;
        return Double.compare(antilopa.speed, speed) == 0 && Objects.equals(name, antilopa.name);
    }
    public int hashCode() {
        return Objects.hash(name, speed);
    }
}

class Gepard {
    private String name;
    private int age;
    private double speed;

    public Gepard(String name, int age, double speed) {
        this.name = name;
        this.age = age;
        this.speed = speed;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getSpeed() {
        return speed;
    }
    public void hunt(List<Antilopa> antilopes) {
        if (antilopes.isEmpty()) {
            System.out.println(name + " не нашёл антилоп для охоты");
            return;
        }
        Antilopa slowest = null;
        for(Antilopa antilopa : antilopes) {
            if(slowest == null || antilopa.getSpeed() < slowest.getSpeed()) {
                slowest = antilopa;
            }
        }
        if(slowest != null) {
            if(speed > slowest.getSpeed()) {
                System.out.println(name + " преследует " + slowest.getName() + " и схвачена");
                antilopes.remove(slowest);
            }else {
                System.out.println(name + " преследует " + slowest.getName() + ", но она не схвачена");
            }
        }
    }
}