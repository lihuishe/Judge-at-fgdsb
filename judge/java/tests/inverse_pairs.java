package tests;
import java.util.*;
import java.lang.*;
import java.io.*;
import judge.*;

public class inverse_pairs {
    public static int num_test = 60;
    public static int[][] in_0;
    public static int[][] in_org_0;
    public static int[] out;


    public static void load_test() {
        File fil = new File("judge/tests/inverse-pairs.txt");
        FileReader inputFil = null;
        try {
            inputFil = new FileReader(fil);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader in = new BufferedReader(inputFil);
        try {
            in_0 = common.read_int_matrix(in);
            in_org_0 = test_common.copy(in_0);
            out = common.read_int_array(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void judge() {
        load_test();
        Solution s = new Solution();

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < num_test; ++i) {
            int answer = s.num_inverse_pairs(in_0[i]);
            if(answer != out[i]) {
                System.out.printf("%d / %d;", i+1, num_test);
                String outs = common.to_string(inverse_pairs.in_org_0[i]);
                System.out.print(outs + ";");
                System.out.print(common.to_string(answer) + ";");
                System.out.println(common.to_string(out[i]));
                return;
            }
        }

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Accepted;");
        System.out.println(estimatedTime);
    }
}
