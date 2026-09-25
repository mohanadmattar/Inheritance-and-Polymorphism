/**
 * الفئة الفرعية (Subclass): Square
 * ترث من الفئة الأساسية Shape لتمثيل المربع.
 * بناءً على السلايد (صفحة 63 و 66 - النسخة الإنجليزية).
 * 
 * مفاهيم البرمجة كائنية التوجه (OOP) المطبقة هنا:
 * 1. Inheritance (الوراثة): ترث الفئة Square الخصائص والدوال من Shape عبر الكلمة المفتاحية 'extends'.
 *    - علاقة الكينونة: المربع هو شكل هندسي (Square IS-A Shape).
 *    - استخدام super(color) لاستدعاء منشئ الفئة الأم في السطر الأول.
 * 2. Encapsulation (التغليف): الحقل side معرّف كـ private لمنع التعديل غير المباشر،
 *    مع التحقق من أن طول الضلع موجب تماماً في الـ Setter لحماية صحة البيانات (Class Invariant).
 * 3. Polymorphism (تعدد الأشكال):
 *    - Overriding: إعادة تعريف الدالة printInfo() بصيغة مخصصة للمربع.
 *    - Overloading: توفير أكثر من منشئ (Constructor Overloading).
 */
public class Square extends Shape {
    // خاصية طول الضلع (خاصة private لضمان مبدأ التغليف)
    private double side;

    /**
     * منشئ افتراضي (Default Constructor)
     */
    public Square() {
        super("white");
        this.side = 1.0;
    }

    /**
     * منشئ يستقبل طول الضلع فقط (Constructor Overloading)
     * 
     * @param side طول الضلع
     */
    public Square(double side) {
        super("red");
        setSide(side);
    }

    /**
     * المنشئ الرئيسي المطلوب في السلايد (صفحة 66)
     * يمرر اللون للفئة الأم باستخدام super(color) ويضبط طول الضلع.
     * 
     * @param side طول الضلع
     * @param color لون المربع
     */
    public Square(double side, String color) {
        super(color); // استدعاء منشئ الفئة الأم Shape لتمرير اللون
        setSide(side); // استخدام دالة الضبط لضمان تطبيق شروط التحقق
    }

    /**
     * دالة الحصول على طول الضلع (Getter)
     * 
     * @return طول الضلع
     */
    public double getSide() {
        return side;
    }

    /**
     * دالة ضبط وتعديل طول الضلع (Setter)
     * تطبق مبدأ التغليف بمنع إدخال أطوال سالبة أو مساوية للصفر.
     * 
     * @param side القيمة الجديدة لطول الضلع
     */
    public void setSide(double side) {
        if (side > 0) {
            this.side = side;
        } else {
            System.out.println("Warning: Invalid side length (" + side + "). Side must be positive! Setting default 1.0");
            this.side = 1.0;
        }
    }

    /**
     * دالة حساب مساحة المربع (area)
     * القانون: الضلع * الضلع
     * 
     * @return مساحة المربع
     */
    public double area() {
        return side * side;
    }

    /**
     * إعادة تعريف الدالة (Method Overriding) لتحقيق تعدد الأشكال (Polymorphism).
     * التنسيق المطلوب في السلايد (صفحة 66):
     * "Square colored [color], area = [area]"
     */
    @Override
    public void printInfo() {
        System.out.println("Square colored " + getColor() + ", area = " + area());
    }
}
