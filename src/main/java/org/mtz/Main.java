package org.mtz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.mtz.Tools.alphabet;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);

        int operate = 0;
        while (operate != 3) {
            System.out.println("""
                    请选择操作：
                    1.加密
                    2.解密
                    3.退出程序""");
            operate = Tools.Input();
            if (operate == 1) {
                //加密
                System.out.println("请输入密钥：");
                String passwd = input.nextLine();
                char[] passwd1 = passwd.toCharArray();
                ArrayList<Integer> passwdList = Tools.Transform(passwd1);
//                System.out.println("密钥转换为密钥数字串为：" + passwdList);

                System.out.println("请输入明文：");
                String plaintext = input.nextLine();
                char[] plaintext1 = plaintext.toCharArray();
                ArrayList<Integer> plaintextList = Tools.Transform(plaintext1);
//                System.out.println("明文转换为明文数字串为" + plaintextList);

                Tools.Longer(passwdList, plaintextList);
//                System.out.println("增加后的密钥数字串：" + passwdList);

                //输出密文
                System.out.println("密文为：");
                for (int i = 0; i < plaintextList.size(); i++) {
                    if ((plaintextList.get(i) + passwdList.get(i)) >= alphabet.length) {
                        plaintextList.set(i, (passwdList.get(i) + plaintextList.get(i) - alphabet.length));
                    } else {
                        plaintextList.set(i, (passwdList.get(i) + plaintextList.get(i)));
                    }
                    System.out.print(alphabet[plaintextList.get(i)]);
                }
                System.out.println("\n按任意键继续...");
                System.in.read();
            } else if (operate == 2) {
                //解密
                System.out.println("请输入密钥：");
                String passwd = input.nextLine();
                char[] passwd1 = passwd.toCharArray();
                ArrayList<Integer> passwdList = Tools.Transform(passwd1);
//                System.out.println("密钥转换为密钥数字串为：" + passwdList);

                System.out.println("请输入密文：");
                String ciphertext = input.nextLine();
                char[] ciphertext1 = ciphertext.toCharArray();
                ArrayList<Integer> ciphertextList = Tools.Transform(ciphertext1);
//                System.out.println("密文转换为密文数字串为" + ciphertextList);

                Tools.Longer(passwdList, ciphertextList);
//                System.out.println("增加后的密钥数字串：" + passwdList);

                //输出明文
                System.out.println("明文为：");
                for (int i = 0; i < ciphertextList.size(); i++) {
                    if ((ciphertextList.get(i) - passwdList.get(i)) < 0) {
                        ciphertextList.set(i, ciphertextList.get(i) - passwdList.get(i) + alphabet.length);
                    } else {
                        ciphertextList.set(i, ciphertextList.get(i) - passwdList.get(i));
                    }
                    System.out.print(alphabet[ciphertextList.get(i)]);
                }
                System.out.println("\n按任意键继续...");
                System.in.read();
            } else {
                System.out.println("请输入1、2或者3");
            }
        }
    }
}