/**
 * الفئة الفرعية (Subclass): Circle
 * ترث من الفئة الأساسية Shape لتمثيل الدائرة.
 * بناءً على السلايد (صفحة 64 و 66 - النسخة الإنجليزية).
 * 
 * مفاهيم البرمجة كائنية التوجه (OOP) المطبقة هنا:
 * 1. Inheritance (الوراثة): الدائرة هي شكل هندسي (Circle IS-A Shape)، وترث خصائص Shape مثل color.
 *    - كما أنها الفئة الأم (Superclass) للفئة اللاحقة Cylinder (الأسطوانة)، مما يشكل وراثة متعددة المستويات (Multilevel Inheritance).
 * 2. Encapsulation (التغليف):
 *    - الحقل radius معرّف كـ protected ليتم الوصول إليه بأمان داخل الفئات المشتقة كـ Cylinder.
 *    - توفير دوال getRadius و setRadius مع التحقق من صحة القيمة المدخلة.
 * 3. Polymorphism (تعدد الأشكال):
 *    - Overriding: إعادة كتابة دالة printInfo() لتناسب خصائص الدائرة.
 *    - Constant: الثابت الرياضي PI معرّف كـ public static final ثابتاً على مستوى الفئة.
 */
public class Circle extends Shape {
    // ثابت النسبة التقريبية (Class Constant) مطلوب في السلايد صفحة 64 و 66
    public static final double PI = Math.PI;

    // نصف القطر (محمي protected للوصول المباشر في الفئة الفرعية Cylinder أو عبر الـ Getter)
    protected double radius;

    /**
     * منشئ افتراضي (Default Constructor)
     */
    public Circle() {
        super("blue");
        this.radius = 1.0;
    }

    /**
     * منشئ يستقبل نصف القطر فقط (Constructor Overloading)
     * 
     * @param radius نصف القطر
     */
    public Circle(double radius) {
        super("blue");
        setRadius(radius);
    }

    /**
     * المنشئ الرئيسي المطلوب في السلايد (صفحة 66)
     * 
     * @param radius نصف القطر
     * @param color لون الدائرة
     */
    public Circle(double radius, String color) {
        super(color); // استدعاء منشئ الفئة الأم Shape لتمرير اللون
        setRadius(radius); // التحقق من نصف القطر
    }

    /**
     * دالة الحصول على نصف القطر (Getter)
     * 
     * @return نصف قطر الدائرة
     */
    public double getRadius() {
        return radius;
    }

    /**
     * دالة تعديل نصف القطر (Setter)
     * تطبق مبدأ التغليف لمنع القيم الصفرية أو السالبة.
     * 
     * @param radius نصف القطر الجديد
     */
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Warning: Invalid radius (" + radius + "). Radius must be positive! Setting default 1.0");
            this.radius = 1.0;
        }
    }

    /**
     * دالة حساب مساحة الدائرة (area)
     * القانون: PI * radius * radius
     * 
     * @return مساحة الدائرة
     */
    public double area() {
        return PI * radius * radius;
    }

    /**
     * إعادة تعريف الدالة (Method Overriding) لتحقيق تعدد الأشكال (Polymorphism).
     * التنسيق المطلوب في السلايد (صفحة 66):
     * "Circle [color], area = [area]"
     */
    @Override
    public void printInfo() {
        System.out.println("Circle " + getColor() + ", area = " + area());
    }
}
