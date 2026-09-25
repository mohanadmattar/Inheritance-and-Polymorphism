import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * الكلاس الرئيسي للتجربة والتطبيق: Main
 * مخصص لاستكشاف مفاهيم الوراثة (Inheritance) وتعدد الأشكال (Polymorphism)
 * والتغليف (Encapsulation) وفقاً لما ورد في السلايد (صفحات 63 - 66 ومن 86 - 91).
 * 
 * يتضمن البرنامج:
 * 1. استكشاف إنشاء الكائنات واستدعاء دوالها بشكل تلقائي.
 * 2. التحقق من التغليف ومعالجة القيم غير الصحيحة.
 * 3. استكشاف تعدد الأشكال الديناميكي عبر مصفوفة كائنات من النوع Shape.
 * 4. قائمة تفاعلية مرنة (Interactive Menu) باستخدام Scanner للمستخدم.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // لضمان قراءة الكسور العشرية بالنقطة (.) في مختلف بيئات التشغيل
        boolean running = true;

        System.out.println("========================================================================");
        System.out.println("  5A - Self Exercise / Exploration of Inheritance and Polymorphism");
        System.out.println("  Object-Oriented Programming (PBO) - Informatics Engineering UNRAM");
        System.out.println("========================================================================");

        while (running) {
            System.out.println("\n----------------------------- MAIN MENU -----------------------------");
            System.out.println("1. Run Automated Exploration (Tests Inheritance, Encapsulation, Polymorphism)");
            System.out.println("2. Explore Square Object (Create & Test Methods)");
            System.out.println("3. Explore Circle Object (Create & Test Methods)");
            System.out.println("4. Explore Cylinder Object (Create & Test Methods)");
            System.out.println("5. Explore Polymorphic Array (Shape[] with Dynamic Binding)");
            System.out.println("6. Exit");
            System.out.print("Please enter your choice (1-6): ");

            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer number.");
                scanner.nextLine(); // تفريغ المدخل الخاطئ
                continue;
            }

            switch (choice) {
                case 1:
                    // تشغيل الاستكشاف التلقائي الشامل
                    runAutomatedExploration();
                    break;
                case 2:
                    // استكشاف تفاعلي للمربع
                    exploreSquareInteractive(scanner);
                    break;
                case 3:
                    // استكشاف تفاعلي للدائرة
                    exploreCircleInteractive(scanner);
                    break;
                case 4:
                    // استكشاف تفاعلي للأسطوانة
                    exploreCylinderInteractive(scanner);
                    break;
                case 5:
                    // استكشاف تفاعلي لمصفوفة الأشكال متعدّدة الأشكال
                    explorePolymorphismInteractive(scanner);
                    break;
                case 6:
                    // إنهاء البرنامج
                    System.out.println("\nThank you for exploring Inheritance and Polymorphism! Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("Option out of range. Please choose between 1 and 6.");
            }
        }

        scanner.close();
    }

    /**
     * استكشاف آلي شامل (Automated Exploration)
     * يوضح بالدليل العملي والمخرجات كل مفاهيم الـ OOP المطلوبة:
     * - التغليف (Encapsulation)
     * - الوراثة الفردية ومتعددة المستويات (Single & Multilevel Inheritance)
     * - تعدد الأشكال في وقت التشغيل (Runtime Polymorphism / Dynamic Binding)
     */
    public static void runAutomatedExploration() {
        System.out.println("\n=======================================================");
        System.out.println("       AUTOMATED EXPLORATION OF OOP CONCEPTS");
        System.out.println("=======================================================");

        // ---------------------------------------------------------------------
        // 1. استكشاف إنشاء الكائنات واستدعاء دوالها المباشرة
        // ---------------------------------------------------------------------
        System.out.println("\n[1] EXPLORING OBJECT CREATION & DIRECT CALLS (Pages 63-66):");
        
        Square sq = new Square(5.0, "red");
        Circle cr = new Circle(7.0, "yellow");
        Cylinder cy = new Cylinder(10.0, 3.0, "green");

        System.out.print("-> Square printInfo():   ");
        sq.printInfo();
        System.out.println("   Side: " + sq.getSide() + ", Area: " + sq.area());

        System.out.print("-> Circle printInfo():   ");
        cr.printInfo();
        System.out.println("   Radius: " + cr.getRadius() + ", Area: " + cr.area());

        System.out.print("-> Cylinder printInfo(): ");
        cy.printInfo();
        System.out.println("   Radius: " + cy.getRadius() + ", Height: " + cy.getHeight() + ", Volume: " + cy.volume());

        // ---------------------------------------------------------------------
        // 2. استكشاف مبدأ التغليف وحماية البيانات (Encapsulation)
        // ---------------------------------------------------------------------
        System.out.println("\n[2] EXPLORING ENCAPSULATION & DATA VALIDATION:");
        System.out.println("-> Attempting to set negative side on Square (-4.5):");
        sq.setSide(-4.5); // سيتم رفض القيمة وتطبيق الحماية
        System.out.println("   Current side after protection: " + sq.getSide());

        System.out.println("-> Attempting to set invalid radius on Circle (-2.0):");
        cr.setRadius(-2.0); // سيتم رفض القيمة وحماية كائن الدائرة
        System.out.println("   Current radius after protection: " + cr.getRadius());

        // ---------------------------------------------------------------------
        // 3. استكشاف الوراثة وسلسلة المنشئات (Inheritance & Constructor Chaining)
        // ---------------------------------------------------------------------
        System.out.println("\n[3] EXPLORING INHERITANCE (is-a Relationship):");
        System.out.println("-> 'Square extends Shape' (Single Inheritance):");
        System.out.println("   Square color inherited from Shape: " + sq.getColor());

        System.out.println("-> 'Cylinder extends Circle extends Shape' (Multilevel Inheritance):");
        System.out.println("   Cylinder inherits color from Shape:   " + cy.getColor());
        System.out.println("   Cylinder inherits radius from Circle: " + cy.getRadius());
        System.out.println("   Cylinder reuses base area() method:   " + cy.area());
        System.out.println("   Cylinder computes its volume:         " + cy.volume());

        // ---------------------------------------------------------------------
        // 4. استكشاف تعدد الأشكال في وقت التشغيل (Runtime Polymorphism / Dynamic Binding)
        // كما ورد في السلايد (الصفحات 87-91): حلقة واحدة للتعامل مع أنواع متعددة
        // ---------------------------------------------------------------------
        System.out.println("\n[4] EXPLORING RUNTIME POLYMORPHISM (Shape[] Array - Slides 89-91):");
        Shape[] shapeCollection = new Shape[4];
        shapeCollection[0] = new Shape("purple");
        shapeCollection[1] = new Square(4.0, "orange");
        shapeCollection[2] = new Circle(2.5, "cyan");
        shapeCollection[3] = new Cylinder(8.0, 2.5, "magenta");

        System.out.println("Iterating over Shape[] array with dynamic method dispatch:");
        for (int i = 0; i < shapeCollection.length; i++) {
            System.out.print("Element [" + i + "] (" + shapeCollection[i].getClass().getSimpleName() + "): ");
            // استدعاء دالة printInfo عبر المرجع Shape، وفي وقت التشغيل يتم تنفيذ النسخة الخاصة بالكائن الفعلي
            shapeCollection[i].printInfo();
        }

        System.out.println("\n=======================================================");
        System.out.println("           END OF AUTOMATED EXPLORATION");
        System.out.println("=======================================================");
    }

    /**
     * استكشاف تفاعلي لكائن المربع (Square)
     */
    private static void exploreSquareInteractive(Scanner scanner) {
        System.out.println("\n--- Interactive Square Exploration ---");
        try {
            System.out.print("Enter side length for Square: ");
            double side = scanner.nextDouble();
            System.out.print("Enter color for Square: ");
            String color = scanner.next();

            Square sq = new Square(side, color);
            System.out.println("\nResulting Object State:");
            System.out.println("- Calling printInfo():");
            System.out.print("  ");
            sq.printInfo();
            System.out.println("- Calling getSide():  " + sq.getSide());
            System.out.println("- Calling getColor(): " + sq.getColor());
            System.out.println("- Calling area():     " + sq.area());
        } catch (InputMismatchException e) {
            System.out.println("Invalid numeric input!");
            scanner.nextLine();
        }
    }

    /**
     * استكشاف تفاعلي لكائن الدائرة (Circle)
     */
    private static void exploreCircleInteractive(Scanner scanner) {
        System.out.println("\n--- Interactive Circle Exploration ---");
        try {
            System.out.print("Enter radius for Circle: ");
            double radius = scanner.nextDouble();
            System.out.print("Enter color for Circle: ");
            String color = scanner.next();

            Circle cr = new Circle(radius, color);
            System.out.println("\nResulting Object State:");
            System.out.println("- Calling printInfo():");
            System.out.print("  ");
            cr.printInfo();
            System.out.println("- Calling getRadius(): " + cr.getRadius());
            System.out.println("- Calling getColor():  " + cr.getColor());
            System.out.println("- Calling area():      " + cr.area());
            System.out.println("- Class Constant PI:   " + Circle.PI);
        } catch (InputMismatchException e) {
            System.out.println("Invalid numeric input!");
            scanner.nextLine();
        }
    }

    /**
     * استكشاف تفاعلي لكائن الأسطوانة (Cylinder)
     */
    private static void exploreCylinderInteractive(Scanner scanner) {
        System.out.println("\n--- Interactive Cylinder Exploration ---");
        try {
            System.out.print("Enter height for Cylinder: ");
            double height = scanner.nextDouble();
            System.out.print("Enter radius for Cylinder: ");
            double radius = scanner.nextDouble();
            System.out.print("Enter color for Cylinder: ");
            String color = scanner.next();

            Cylinder cy = new Cylinder(height, radius, color);
            System.out.println("\nResulting Object State:");
            System.out.println("- Calling printInfo():");
            System.out.print("  ");
            cy.printInfo();
            System.out.println("- Calling getHeight(): " + cy.getHeight());
            System.out.println("- Calling getRadius(): " + cy.getRadius());
            System.out.println("- Calling getColor():  " + cy.getColor());
            System.out.println("- Calling area() [Base Area]: " + cy.area());
            System.out.println("- Calling volume():    " + cy.volume());
        } catch (InputMismatchException e) {
            System.out.println("Invalid numeric input!");
            scanner.nextLine();
        }
    }

    /**
     * استكشاف تفاعلي لتعدد الأشكال (Polymorphic List)
     */
    private static void explorePolymorphismInteractive(Scanner scanner) {
        System.out.println("\n--- Interactive Polymorphism Demonstration ---");
        System.out.println("Creating a polymorphic list containing Shape, Square, Circle, and Cylinder...");

        ArrayList<Shape> shapesList = new ArrayList<>();
        shapesList.add(new Shape("Gray"));
        shapesList.add(new Square(6.0, "Red"));
        shapesList.add(new Circle(4.0, "Blue"));
        shapesList.add(new Cylinder(9.0, 4.0, "Green"));

        System.out.println("\nDemonstrating Dynamic Method Dispatch (Late Binding):");
        System.out.println("Notice how a single loop executes different printInfo() behaviors depending on object type:");
        
        int index = 1;
        for (Shape s : shapesList) {
            System.out.print("Shape #" + index + " [" + s.getClass().getSimpleName() + "]: ");
            s.printInfo(); // استدعاء متعدد الأشكال
            index++;
        }
    }
}
