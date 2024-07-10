package org.mtz;

import java.util.ArrayList;
import java.util.Scanner;

public class Tools {
    //字符表
    static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', ':', '/', '.', '-', '_', '?', '=', '&', '%'};

    public static ArrayList<Integer> Transform(char[] text) {
        ArrayList<Integer> list = new ArrayList<>();
        for (char c : text) {
            for (int j = 0; j < alphabet.length; j++) {
                if (c == alphabet[j]) {
                    list.add(j);
                }
            }
        }
        return list;
    }

    public static void Longer(ArrayList<Integer> passwdList, ArrayList<Integer> list) {
        int i = 0;
        while (passwdList.size() < list.size()) {
            passwdList.add(passwdList.get(i));
            i++;
        }
    }

    public static int Input() {
        //防止玩家输入其他字符的输入数字方法
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("请输入数字！");
            System.out.print("请输入：");
            return Input();
        }
    }
}
