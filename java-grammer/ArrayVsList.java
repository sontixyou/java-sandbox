import java.util.*;

/**
 * 配列（Array）とリスト（List）の違いを理解するサンプル
 */
public class ArrayVsList {

    public static void main(String[] args) {
        System.out.println("=== 配列 vs リスト ===\n");

        arrayExample();
        listExample();
        comparison();
        whenToUse();
    }

    // ========== 配列の例 ==========
    static void arrayExample() {
        System.out.println("【1. 配列（Array）】");

        // 1. サイズは固定（作成後に変更不可）
        int[] numbers = new int[3];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        // numbers[3] = 40;  // ❌ エラー！サイズを超えている

        System.out.println("配列のサイズ: " + numbers.length);
        System.out.println("要素: " + Arrays.toString(numbers));

        // 2. プリミティブ型を直接格納できる
        int[] primitives = {1, 2, 3, 4, 5};
        System.out.println("プリミティブ型: " + Arrays.toString(primitives));

        // 3. 多次元配列が簡単
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("2次元配列[0][1] = " + matrix[0][1]);

        // 4. メソッドが少ない（Arraysクラスを使う必要がある）
        Arrays.sort(primitives);  // ソートもArraysクラス経由
        System.out.println("ソート後: " + Arrays.toString(primitives));

        System.out.println();
    }

    // ========== リストの例 ==========
    static void listExample() {
        System.out.println("【2. リスト（List）】");

        // 1. サイズは可変（自由に追加・削除できる）
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);  // ✅ どんどん追加できる
        System.out.println("リストのサイズ: " + numbers.size());
        System.out.println("要素: " + numbers);

        // 2. 要素の追加・削除が簡単
        numbers.remove(1);  // インデックス1を削除（20が削除される）
        System.out.println("削除後: " + numbers);

        numbers.add(1, 25);  // インデックス1に25を挿入
        System.out.println("挿入後: " + numbers);

        // 3. 便利なメソッドが豊富
        System.out.println("30を含む？: " + numbers.contains(30));
        System.out.println("最初の要素: " + numbers.get(0));
        System.out.println("最後の要素: " + numbers.get(numbers.size() - 1));

        // 4. ジェネリクスで型安全
        List<String> names = new ArrayList<>();
        names.add("太郎");
        names.add("花子");
        // names.add(123);  // ❌ コンパイルエラー！String以外は入れられない

        // 5. ソートも簡単
        Collections.sort(numbers);
        System.out.println("ソート後: " + numbers);

        // 6. ラムダ式やStreamと相性が良い
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println("\n");
    }

    // ========== 比較表 ==========
    static void comparison() {
        System.out.println("【3. 比較表】");
        System.out.println("┌────────────────┬──────────────────┬──────────────────┐");
        System.out.println("│     項目       │     配列 (Array)  │    リスト (List)  │");
        System.out.println("├────────────────┼──────────────────┼──────────────────┤");
        System.out.println("│ サイズ         │ 固定              │ 可変              │");
        System.out.println("│ 型             │ プリミティブ型OK  │ オブジェクト型のみ│");
        System.out.println("│ 要素追加       │ できない          │ add()で簡単       │");
        System.out.println("│ 要素削除       │ できない          │ remove()で簡単    │");
        System.out.println("│ メソッド       │ 少ない            │ 豊富              │");
        System.out.println("│ パフォーマンス │ 高速              │ やや遅い          │");
        System.out.println("│ メモリ効率     │ 良い              │ やや悪い          │");
        System.out.println("│ 使いやすさ     │ シンプル          │ 多機能            │");
        System.out.println("└────────────────┴──────────────────┴──────────────────┘");
        System.out.println();
    }

    // ========== 使い分け ==========
    static void whenToUse() {
        System.out.println("【4. 使い分けのガイドライン】");
        System.out.println();

        System.out.println("✅ 配列を使う場合：");
        System.out.println("  • サイズが固定で変更しない");
        System.out.println("  • プリミティブ型を大量に扱う（メモリ効率重視）");
        System.out.println("  • パフォーマンスが重要");
        System.out.println("  • 多次元データ（行列など）");
        System.out.println();
        System.out.println("  例：");
        System.out.println("    int[] scores = {85, 90, 78, 92, 88};  // テストスコア（固定）");
        System.out.println("    int[][] board = new int[8][8];        // チェス盤");
        System.out.println();

        System.out.println("✅ リストを使う場合：");
        System.out.println("  • サイズが変動する");
        System.out.println("  • 要素の追加・削除が頻繁");
        System.out.println("  • 便利なメソッドを使いたい");
        System.out.println("  • Stream APIやラムダ式を使う");
        System.out.println();
        System.out.println("  例：");
        System.out.println("    List<String> todoList = new ArrayList<>();  // TODOリスト（可変）");
        System.out.println("    List<User> users = fetchUsersFromDB();      // DBから取得");
        System.out.println();

        System.out.println("💡 Webアプリでは通常Listを使う方が便利！");
        System.out.println();
    }
}

// ========== 実践例：配列とリストの相互変換 ==========
class ConversionExample {

    static void examples() {
        System.out.println("【変換例】");

        // 配列 → リスト
        String[] arrayNames = {"太郎", "花子", "次郎"};
        List<String> listNames = Arrays.asList(arrayNames);
        // または
        List<String> listNames2 = new ArrayList<>(Arrays.asList(arrayNames));

        System.out.println("配列→リスト: " + listNames);

        // リスト → 配列
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] arrayNumbers = numbers.toArray(new Integer[0]);

        System.out.println("リスト→配列: " + Arrays.toString(arrayNumbers));

        // プリミティブ型の配列 → リスト（Java 8+）
        int[] primitives = {1, 2, 3, 4, 5};
        List<Integer> listFromPrimitives = Arrays.stream(primitives)
            .boxed()
            .toList();  // Java 16+
        // または .collect(Collectors.toList());  // Java 8+

        System.out.println("プリミティブ配列→リスト: " + listFromPrimitives);
    }
}
