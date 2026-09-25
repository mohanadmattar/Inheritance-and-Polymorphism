/**
 * الفئة الأساسية (Superclass): Shape
 * تمثل الشكل الهندسي العام بناءً على متطلبات السلايد (صفحة 63 و 66).
 * 
 * مفاهيم البرمجة كائنية التوجه (OOP) المطبقة هنا:
 * 1. Encapsulation (التغليف): حماية البيانات باستخدام معامل الوصول protected
 *    وتوفير دوال الوصول (Getters) والتعديل (Setters) مع التحقق من صحة البيانات.
 * 2. Polymorphism (تعدد الأشكال): تعريف الدالة printInfo ليتم إعادة كتابتها (Override) في الفئات الفرعية.
 */
public class Shape {
    // خاصية اللون (محمية protected لتسمح للفئات الفرعية بالوصول إليها مباشرة حسب مخطط UML في السلايد)
    protected String color;

    /**
     * منشئ افتراضي (Default Constructor)
     * يحدد لوناً افتراضياً في حال لم يتم تحديد لون.
     */
    public Shape() {
        this.color = "unknown";
    }

    /**
     * منشئ مع معاملات (Parameterized Constructor)
     * يقوم بتهيئة لون الشكل.
     * 
     * @param color لون الشكل
     */
    public Shape(String color) {
        setColor(color);
    }

    /**
     * دالة الحصول على اللون (Getter)
     * تمثل مبدأ التغليف (Encapsulation) بقراءة القيمة بشكل آمن.
     * 
     * @return اسم اللون
     */
    public String getColor() {
        return color;
    }

    /**
     * دالة تعديل اللون (Setter)
     * تمثل مبدأ التغليف (Encapsulation) مع التحقق من صحة المدخلات.
     * 
     * @param color اللون الجديد
     */
    public void setColor(String color) {
        if (color != null && !color.trim().isEmpty()) {
            this.color = color.trim();
        } else {
            this.color = "undefined";
        }
    }

    /**
     * دالة طباعة معلومات الشكل (printInfo)
     * سيتم إعادة تعريفها (Overriding) في الفئات المشتقة لتحقيق تعدد الأشكال في وقت التشغيل (Runtime Polymorphism).
     */
    public void printInfo() {
        System.out.println("Shape colored " + color);
    }
}
