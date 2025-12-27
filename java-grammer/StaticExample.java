/**
 * staticの動作を理解するサンプル
 */
public class StaticExample {

    public static void main(String[] args) {
        System.out.println("=== static の理解 ===\n");

        // 1. staticメソッドはオブジェクト生成なしで呼べる
        System.out.println("【1. staticメソッド】");
        Calculator.add(10, 20);  // クラス名.メソッド名で呼び出し

        // 2. インスタンスメソッドはオブジェクトが必要
        System.out.println("\n【2. インスタンスメソッド】");
        Calculator calc = new Calculator();  // オブジェクト生成
        calc.multiply(5, 3);  // オブジェクト.メソッド名で呼び出し

        // 3. staticフィールドは全インスタンスで共有
        System.out.println("\n【3. staticフィールドの共有】");
        Counter c1 = new Counter("C1");
        Counter c2 = new Counter("C2");
        Counter c3 = new Counter("C3");

        System.out.println("総カウント: " + Counter.totalCount);  // 3
        c1.showInfo();
        c2.showInfo();
        c3.showInfo();

        // 4. 実際の使用例
        System.out.println("\n【4. 実際の使用例】");

        // Math クラス（全メソッドがstatic）
        double result = Math.sqrt(16);  // オブジェクト生成不要
        System.out.println("Math.sqrt(16) = " + result);
        System.out.println("Math.PI = " + Math.PI);

        // System クラス
        System.out.println("現在時刻: " + System.currentTimeMillis());

        // Integer クラス
        int num = Integer.parseInt("123");  // staticメソッド
        System.out.println("Integer.parseInt(\"123\") = " + num);
    }
}

// ========== Calculator クラス ==========
class Calculator {

    // staticメソッド - オブジェクト生成なしで使える
    static void add(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println("→ staticメソッドなのでオブジェクト不要");
    }

    // インスタンスメソッド - オブジェクトが必要
    void multiply(int a, int b) {
        System.out.println(a + " × " + b + " = " + (a * b));
        System.out.println("→ インスタンスメソッドなのでオブジェクトが必要");
    }
}

// ========== Counter クラス ==========
class Counter {
    // staticフィールド - 全インスタンスで共有される
    static int totalCount = 0;

    // インスタンスフィールド - 各インスタンスごとに別々
    String name;
    int myNumber;

    Counter(String name) {
        this.name = name;
        totalCount++;  // 共有カウンタを増やす
        this.myNumber = totalCount;  // 自分の番号を記録
    }

    void showInfo() {
        System.out.println(name + ": 私の番号=" + myNumber +
                         ", 総カウント=" + totalCount);
    }
}

// ========== ユーティリティクラスの例 ==========
class StringUtils {
    // ユーティリティクラスは通常すべてstaticにする
    // オブジェクト生成を防ぐためprivateコンストラクタを使う
    private StringUtils() {
        // インスタンス化を防ぐ
    }

    static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
