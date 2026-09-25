/**
 * الفئة الفرعية (Subclass): Cylinder
 * ترث من الفئة Circle لتمثيل الأسطوانة ثلاثية الأبعاد.
 * بناءً على السلايد (صفحة 65 و 66 - النسخة الإنجليزية).
 * 
 * مفاهيم البرمجة كائنية التوجه (OOP) المطبقة هنا:
 * 1. Multilevel Inheritance (الوراثة متعددة المستويات):
 *    - الفئة ترث من Circle، و Circle ترث من Shape.
 *    - بالتالي الأسطوانة تمتلك اللون (color) من Shape، ونصف القطر (radius) ودالة المساحة (area) من Circle،
 *      وتضيف الارتفاع (height) الخاص بها.
 * 2. Constructor Chaining (سلسلة المنشئات):
 *    - يستدعي المنشئ super(radius, color) لتمرير نصف القطر واللون إلى Circle التي تمرر بدورها اللون إلى Shape.
 * 3. Encapsulation (التغليف):
 *    - الحقل height معرّف كـ private ومحمي بدوال get و set مع التحقق من صحة القيمة.
 * 4. Code Reusability (إعادة استخدام الكود):
 *    - حساب الحجم volume() يعيد استخدام دالة المساحة الموروثة area() بضربها في الارتفاع: area() * height.
 * 5. Polymorphism (تعدد الأشكال):
 *    - Overriding: إعادة تعريف الدالة printInfo() لطباعة لون وحجم الأسطوانة.
 */
public class Cylinder extends Circle {
    // خاصية الارتفاع (خاصة private لضمان مبدأ التغليف)
    private double height;

    /**
     * منشئ افتراضي (Default Constructor)
     */
    public Cylinder() {
        super(1.0, "green");
        this.height = 1.0;
    }

    /**
     * منشئ يستقبل الارتفاع ونصف القطر (Constructor Overloading)
     * 
     * @param height الارتفاع
     * @param radius نصف القطر
     */
    public Cylinder(double height, double radius) {
        super(radius, "green");
        setHeight(height);
    }

    /**
     * المنشئ الرئيسي المطلوب في السلايد (صفحة 66)
     * 
     * @param height الارتفاع
     * @param radius نصف القطر
     * @param color لون الأسطوانة
     */
    public Cylinder(double height, double radius, String color) {
        super(radius, color); // استدعاء منشئ الفئة الأم Circle (الذي يستدعي بدوره منشئ Shape)
        setHeight(height);    // ضبط الارتفاع مع التحقق من الصحة
    }

    /**
     * دالة الحصول على الارتفاع (Getter)
     * 
     * @return ارتفاع الأسطوانة
     */
    public double getHeight() {
        return height;
    }

    /**
     * دالة ضبط الارتفاع (Setter)
     * تطبق مبدأ التغليف لمنع إدخال ارتفاع صفر أو سالب.
     * 
     * @param height الارتفاع الجديد
     */
    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Warning: Invalid height (" + height + "). Height must be positive! Setting default 1.0");
            this.height = 1.0;
        }
    }

    /**
     * دالة حساب حجم الأسطوانة (volume)
     * القانون: مساحة القاعدة الدائرية * الارتفاع
     * تظهر إعادة استخدام الكود عبر استدعاء دالة area() الموروثة من الفئة Circle.
     * 
     * @return حجم الأسطوانة
     */
    public double volume() {
        return area() * height;
    }

    /**
     * إعادة تعريف الدالة (Method Overriding) لتحقيق تعدد الأشكال (Polymorphism).
     * التنسيق المطلوب في السلايد (صفحة 66):
     * "Cylinder [color], volume = [volume]"
     */
    @Override
    public void printInfo() {
        System.out.println("Cylinder " + getColor() + ", volume = " + volume());
    }
}
