import java.util.Random;
import java.util.Scanner;

public class Main {
    /*
     * ��������
     * 8-15λ�������
     * ��Сд��ĸ�����֣�
     * ����һ���������֮һ��_ ,- ,@
     * �����������ɻ��˳�
     * */
    public static String outPass() {
        //ʹ��StringBuffer �ַ�����������
        StringBuffer str = new StringBuffer();
        //ʹ�������������
        Random random = new Random();
        //��������ĳ��ȣ������������
        int length = (int) (Math.random() * 10 + 8);
        if (length > 15) {
            length = 15 - (int) (Math.random() * 5 + 3);
        }
        System.out.println("生成密码的长度是：" + length);
        char ch[] = {'_', '-', '@'};
        for (int i = 0; i < length - 1; i++) {
            double rand = Math.random() * 3;
            double val = Math.random();
            if (rand >= 0 && rand < 1) {
                str.append((char) (val * ('9' - '0') + '0'));
            } else if (rand >= 1 && rand < 2) {
                str.append((char) (val * ('Z' - 'A') + 'A'));
            } else if (rand >= 2 && rand < 3) {
                str.append((char) (val * ('z' - 'a') + 'a'));
            }
        }
        //�����������������������
        int j = random.nextInt(ch.length);
        //���ȷ��������ŵ�λ��
        int k = random.nextInt(3);
        str.insert(k + 4, ch[j]);
        System.out.println(str);
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println("密码生成系统");
        System.out.println("请选择你想要的操作：");
        System.out.println("1:生成密码");
        System.out.println("0：退出系统");

        Scanner in = new Scanner(System.in);
        int num = -1;
        while (num != 0) {
            num = in.nextInt();
            if (num == 1) {
                //�����������ɺ���
                Main.outPass();
            } else if (num == 0) {
                System.out.println("即将退出系统！");
                System.out.println("退出系统成功！");
            } else {
                System.out.println("退出系统失败！");
            }
        }
    }
}
