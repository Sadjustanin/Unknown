import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Unknown {

    /*
     *                  0
     *                 0
     *                0
     *               0
     *              0        0
     *              0       0 0
     *               0     0   0
     *                0   0     0
     *                 0 0       0
     *                  0         0
     *         0       0 0
     *          0     0   0
     *           0   0     0
     *            0 0     0
     *             0     0
     *                  0
     *                 0
     *                0
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * */
    private enum Numbers {
        ;
        public static final int ZERO = 0,
                ONE = 1,
                TWO = 2,
                THREE = 3,
                FOUR = 4,
                FIVE = 5,
                SIX = 6,
                SEVEN = 7,
                EIGHT = 8,
                NINE = 9;
    }

    private static final int COUNTER = 0;
    private static final String AWE = "awe";

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Rows = ");
//        int rows = sc.nextInt();
        int rows = 50;
        System.out.print("Cols = ");
//        int cols = sc.nextInt();
        int cols = 50;
        System.out.println();
        sc.close();

//        String[] paths = new String[4];
        String pathWin = "C:/Users/" + System.getProperty("user.name") + "/Desktop";
        String pathWinTest = "C:/Users/" + System.getProperty("user.name") + "/Desktop/Test";
        String pathLin = "/home/void/Рабочий стол/varenye";
        String pathLinTest = "/home/void/Рабочий стол/Test";
        Files.createDirectories(Paths.get(pathWinTest));
        BufferedWriter writer;
        File file;
        for (int i = 0; i < 10000; i++) {
            file = createFile(pathWinTest, AWE);
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(artemDaun(rows, cols));
            writer.close();
//            Thread.sleep((rows + cols) * 10L);
        }
    }

    private static File createFile(String path, String name) {
        boolean is_0 = new File(path, name).exists();
        File[] matchingFiles;

        File file = new File(path, name);
        StringBuilder str = new StringBuilder(String.valueOf(file));
        StringBuilder sb;

        if (!is_0)
            for (Numbers i : Numbers.values())
                if (new File(String.valueOf(str.append(i))).exists()) {
                    is_0 = true;
                    break;
                } else
                    str.deleteCharAt(str.length() - 1);

        if (is_0) {
            int i;
            File dir = new File(path);
            matchingFiles = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir1, String name1) {
                    return name1.startsWith(AWE);
                }
            });
            assert matchingFiles != null;
            sb = new StringBuilder(name);
            i = matchingFiles.length;
            sb.append(i);
            file = new File(path, String.valueOf(sb));
        }

//        StringBuilder sb = new StringBuilder(name);
//
//        try {
//            if (is_0) {
//                int i;
//                if (Character.isDigit(file.getName().charAt(file.getName().length() - 1)))
//                    i = sb.charAt(sb.length() - 1);
//                else
//                    i = 0;
//                int ii;
//                int iii = 10;
//                int iiii = 0;
//
//                for (ii = 0; ii < sb.length() - 3; ii++) { // determining how many digits are after "awe"
//                }
//
//                iii *= ii; // maximum number
//
//                for (int iiiii = 0; iiiii < ii; iiiii++) // removing extra digits
//                    sb.deleteCharAt(sb.length() - 1);
//
//                do {
//                    if (i % 10 == 0 && i != 0) // every bit appends final '1' that means this bit
//                        sb.append(1);
//                    else
//                        sb.append(++i);
//
////                    if (new File(path, String.valueOf(sb)).isAbsolute())
////                        break;
////                    else
////                        sb.deleteCharAt(sb.length() - 1);
//                    file = new File(path, String.valueOf(sb));
//                } while (++iiii <= iii);
//            } else
//                System.out.println("Artem ne daun");
//
//            System.out.println(file.getName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return file;
    }

    private static String artemDaun(int rows, int cols) {
        StringBuilder sb = new StringBuilder();

        for (int u = 0; u < rows; u++) {
            for (int v = 0; v < cols; v++) {
                if (u < rows / 2) {
                    if (v < cols / 2) {
                        if (v == 0) {
                            sb.append(COUNTER);
                        }
                        // else appends space
                        else {
                            sb.append(" " + " ");
                        }
                    } else if (v == cols / 2) {
                        sb.append(" " + COUNTER);
                    } else {
                        if (u == 0)
                            sb.append(" " + COUNTER);
                    }
                } else if (u == rows / 2) {
                    sb.append(COUNTER + " ");
                } else {
                    if (v == cols / 2 || v == cols - 1) {
                        sb.append(COUNTER + " ");
                    } else if (u == rows - 1) {
                        if (v <= cols / 2 || v == cols - 1) {
                            sb.append(COUNTER + " ");
                        } else {
                            sb.append(" " + " ");
                        }
                    } else
                        sb.append(" " + " ");
                }
            }
            sb.append("\n");
        }
        return String.valueOf(sb);
    }
}