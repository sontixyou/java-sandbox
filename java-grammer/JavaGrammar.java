import java.util.*;
import java.util.stream.*;

/**
 * Java文法総合サンプル
 * このファイルを実行すると、Javaの主要な文法を確認できます
 */
public class JavaGrammar {

    public static void main(String[] args) {
        System.out.println("=== Java 文法サンプル ===\n");

        // 1. 基本型（プリミティブ型）
        basics();

        // 2. 演算子
        operators();

        // 3. 制御構文
        controlFlow();

        // 4. 配列
        arrays();

        // 5. メソッド
        methods();

        // 6. クラスとオブジェクト
        classesAndObjects();

        // 7. 文字列操作
        stringOperations();

        // 8. コレクション
        collections();

        // 9. 例外処理
        exceptionHandling();

        // 10. ラムダ式とStream API
        lambdaAndStreams();
    }

    // ========== 1. 基本型 ==========
    static void basics() {
        System.out.println("【1. 基本型（プリミティブ型）】");

        // 整数型
        byte b = 127;                    // 8ビット: -128 ~ 127
        short s = 32000;                 // 16ビット: -32,768 ~ 32,767
        int i = 2147483647;              // 32ビット: -2^31 ~ 2^31-1
        long l = 9223372036854775807L;   // 64ビット: -2^63 ~ 2^63-1

        // 浮動小数点型
        float f = 3.14f;                 // 32ビット単精度
        double d = 3.141592653589793;    // 64ビット倍精度

        // 文字・真偽値
        char c = 'A';                    // 16ビット Unicode文字
        boolean bool = true;             // true または false

        // var（Java 10+）- ローカル変数の型推論
        var message = "Hello, Java!";    // String型と推論される
        var number = 42;                 // int型と推論される

        System.out.println("int: " + i);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + bool);
        System.out.println("var(String): " + message);
        System.out.println();
    }

    // ========== 2. 演算子 ==========
    static void operators() {
        System.out.println("【2. 演算子】");

        int a = 10, b = 3;

        // 算術演算子
        System.out.println("a + b = " + (a + b));  // 13
        System.out.println("a - b = " + (a - b));  // 7
        System.out.println("a * b = " + (a * b));  // 30
        System.out.println("a / b = " + (a / b));  // 3（整数除算）
        System.out.println("a % b = " + (a % b));  // 1（剰余）

        // インクリメント・デクリメント
        int x = 5;
        System.out.println("x++ = " + (x++));      // 5（後置: 使用後に+1）
        System.out.println("x = " + x);            // 6
        System.out.println("++x = " + (++x));      // 7（前置: +1後に使用）

        // 比較演算子
        System.out.println("a == b: " + (a == b)); // false
        System.out.println("a != b: " + (a != b)); // true
        System.out.println("a > b: " + (a > b));   // true
        System.out.println("a <= b: " + (a <= b)); // false

        // 論理演算子
        boolean p = true, q = false;
        System.out.println("p && q: " + (p && q)); // false（AND）
        System.out.println("p || q: " + (p || q)); // true（OR）
        System.out.println("!p: " + (!p));         // false（NOT）

        // 三項演算子
        int max = (a > b) ? a : b;
        System.out.println("max(a, b) = " + max);
        System.out.println();
    }

    // ========== 3. 制御構文 ==========
    static void controlFlow() {
        System.out.println("【3. 制御構文】");

        // if-else
        int score = 85;
        if (score >= 90) {
            System.out.println("優秀");
        } else if (score >= 70) {
            System.out.println("良好");
        } else {
            System.out.println("要努力");
        }

        // switch文（Java 14+ の新しい構文も使用可能）
        String day = "月曜日";
        switch (day) {
            case "月曜日":
            case "火曜日":
                System.out.println("週の始まり");
                break;
            case "金曜日":
                System.out.println("週末前");
                break;
            default:
                System.out.println("その他の日");
        }

        // for文
        System.out.print("for: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 拡張for文（for-each）
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.print("for-each: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // while文
        int count = 0;
        System.out.print("while: ");
        while (count < 3) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();

        // do-while文
        int i = 0;
        System.out.print("do-while: ");
        do {
            System.out.print(i + " ");
            i++;
        } while (i < 3);
        System.out.println("\n");
    }

    // ========== 4. 配列 ==========
    static void arrays() {
        System.out.println("【4. 配列】");

        // 配列の宣言と初期化
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[5];  // 全要素0で初期化

        arr2[0] = 10;
        arr2[1] = 20;

        System.out.println("arr1[0] = " + arr1[0]);
        System.out.println("配列の長さ: " + arr1.length);

        // 多次元配列
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("matrix[1][1] = " + matrix[1][1]);  // 5

        // 配列のコピー
        int[] copy = Arrays.copyOf(arr1, arr1.length);
        System.out.println("コピー: " + Arrays.toString(copy));

        // 配列のソート
        int[] unsorted = {5, 2, 8, 1, 9};
        Arrays.sort(unsorted);
        System.out.println("ソート後: " + Arrays.toString(unsorted));
        System.out.println();
    }

    // ========== 5. メソッド ==========
    static void methods() {
        System.out.println("【5. メソッド】");

        // メソッド呼び出し
        int sum = add(10, 20);
        System.out.println("add(10, 20) = " + sum);

        String greeting = greet("太郎");
        System.out.println(greeting);

        // 可変長引数
        int total = sumAll(1, 2, 3, 4, 5);
        System.out.println("sumAll(1,2,3,4,5) = " + total);

        // オーバーロード
        System.out.println("multiply(3, 4) = " + multiply(3, 4));
        System.out.println("multiply(2.5, 3.0) = " + multiply(2.5, 3.0));
        System.out.println();
    }

    static int add(int a, int b) {
        return a + b;
    }

    static String greet(String name) {
        return "こんにちは、" + name + "さん！";
    }

    // 可変長引数
    static int sumAll(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    // メソッドのオーバーロード
    static int multiply(int a, int b) {
        return a * b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    // ========== 6. クラスとオブジェクト ==========
    static void classesAndObjects() {
        System.out.println("【6. クラスとオブジェクト】");

        // オブジェクトの生成
        Person person = new Person("山田太郎", 25);
        person.introduce();

        // ゲッター・セッターの使用
        person.setAge(26);
        System.out.println("更新後の年齢: " + person.getAge());

        // staticメソッドの呼び出し
        System.out.println("円の面積: " + Circle.calculateArea(5.0));
        System.out.println();
    }

    // ========== 7. 文字列操作 ==========
    static void stringOperations() {
        System.out.println("【7. 文字列操作】");

        String str = "Hello, Java!";

        // 基本メソッド
        System.out.println("長さ: " + str.length());
        System.out.println("大文字: " + str.toUpperCase());
        System.out.println("小文字: " + str.toLowerCase());
        System.out.println("含む?: " + str.contains("Java"));
        System.out.println("開始?: " + str.startsWith("Hello"));
        System.out.println("部分文字列: " + str.substring(0, 5));

        // 文字列の結合
        String s1 = "Java";
        String s2 = "Programming";
        System.out.println("結合: " + s1 + " " + s2);
        System.out.println("concat: " + s1.concat(" ").concat(s2));

        // String.format（フォーマット）
        String formatted = String.format("名前: %s, 年齢: %d", "太郎", 25);
        System.out.println(formatted);

        // テキストブロック（Java 15+）
        String json = """
            {
                "name": "太郎",
                "age": 25
            }
            """;
        System.out.println("JSONテキスト:\n" + json);

        // 分割
        String csv = "apple,banana,orange";
        String[] fruits = csv.split(",");
        System.out.println("分割: " + Arrays.toString(fruits));
        System.out.println();
    }

    // ========== 8. コレクション ==========
    static void collections() {
        System.out.println("【8. コレクション】");

        // List（順序付きコレクション）
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("List: " + list);
        System.out.println("要素取得: " + list.get(1));

        // Set（重複なしコレクション）
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(2);  // 重複は無視される
        set.add(3);
        System.out.println("Set: " + set);

        // Map（キー・バリューのペア）
        Map<String, Integer> map = new HashMap<>();
        map.put("太郎", 25);
        map.put("花子", 23);
        map.put("次郎", 30);
        System.out.println("Map: " + map);
        System.out.println("太郎の年齢: " + map.get("太郎"));

        // Mapの反復処理
        System.out.println("Map反復:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    // ========== 9. 例外処理 ==========
    static void exceptionHandling() {
        System.out.println("【9. 例外処理】");

        // try-catch
        try {
            int result = 10 / 0;  // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("エラー捕捉: " + e.getMessage());
        }

        // try-catch-finally
        try {
            String str = null;
            // str.length();  // NullPointerException
            System.out.println("正常処理");
        } catch (NullPointerException e) {
            System.out.println("nullエラー");
        } finally {
            System.out.println("finally: 必ず実行される");
        }

        // 複数の例外をキャッチ
        try {
            int[] arr = {1, 2, 3};
            // int x = arr[10];  // ArrayIndexOutOfBoundsException
            int y = Integer.parseInt("abc");  // NumberFormatException
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("配列または数値エラー: " + e.getClass().getSimpleName());
        }

        System.out.println();
    }

    // ========== 10. ラムダ式とStream API ==========
    static void lambdaAndStreams() {
        System.out.println("【10. ラムダ式とStream API】");

        // ラムダ式の基本
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("元のリスト: " + numbers);

        // forEach（ラムダ式）
        System.out.print("forEach: ");
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // filter（フィルタリング）
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("偶数のみ: " + evenNumbers);

        // map（変換）
        List<Integer> doubled = numbers.stream()
            .map(n -> n * 2)
            .collect(Collectors.toList());
        System.out.println("2倍: " + doubled);

        // reduce（集約）
        int sum = numbers.stream()
            .reduce(0, (a, b) -> a + b);
        System.out.println("合計: " + sum);

        // 複合的な操作
        int result = numbers.stream()
            .filter(n -> n > 2)        // 2より大きい
            .map(n -> n * n)           // 二乗
            .reduce(0, Integer::sum);  // 合計
        System.out.println("3,4,5の二乗の合計: " + result);

        // ソート
        List<String> names = Arrays.asList("Taro", "Hanako", "Jiro", "Aki");
        List<String> sorted = names.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("ソート: " + sorted);

        System.out.println();
    }
}

// ========== クラス定義の例 ==========

class Person {
    // フィールド（プライベート）
    private String name;
    private int age;

    // コンストラクタ
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // ゲッター
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // セッター
    public void setAge(int age) {
        this.age = age;
    }

    // メソッド
    public void introduce() {
        System.out.println("私の名前は" + name + "、" + age + "歳です。");
    }
}

class Circle {
    // staticメソッド
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
}
