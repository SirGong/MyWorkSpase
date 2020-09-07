package huffmanCode;

import java.io.*;
import java.util.*;

public class HuffmanCode {
    /*
        赫夫曼编码步骤：
        1)获取到对应字符串的字节数组
        2)将对应的字符数组经过处理转换成对应的List<Node>集合
        3)进行赫夫曼树的构造
        4)拿到赫夫曼树对应的赫夫曼编码表
        5)赫夫曼编码字节数组
     */
    /*
        赫夫曼解码步骤
        1）先将转换得到的赫夫曼字节数组转换成二进制对应的字符串
        2)将转换后的二进制字符串对照赫夫曼编码进行相应的解析
     */
    public static void main(String[] args) {
//        String content = "i like like like java do you like a java";
//        byte[] contentBytes = content.getBytes();

    /*  编码分步测试
        System.out.println("原始的字节数组为：" + Arrays.toString(contentBytes));
        List<Node> nodes = getNodes(contentBytes);
        System.out.println("node=" + nodes);
        Node huffmanTreeRoot = creatHuffman(nodes);
        huffmanTreeRoot.preOrder();
        getCodes(huffmanTreeRoot);
        System.out.println("生成的赫夫曼编码：" + huffmanCodes);

        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
    */
//        byte[] huffmanCodeBytes = huffmanZip(contentBytes);
//        System.out.println("压缩后的字节码为：" + Arrays.toString(huffmanCodeBytes));
//        byte[] sourceBytes = decode(huffmanCodes, huffmanCodeBytes);
//        System.out.println("原来的字符串：" + new String(sourceBytes));
        //测试压缩文件
//        String srcFile = "d://mpp.png";
//        String dstFile = "d://dst.zip";
//        zipFile(srcFile, dstFile);
//        System.out.println("压缩成功~~");
        //测试解压文件
        String zipFile = "d://dst.zip";
        String dstFile = "d://mpp1.png";
        unZipFile(zipFile,dstFile);
        System.out.println("解压成功~~");


    }
    //封装赫夫曼编码

    /**
     * @param bytes 原始字符串转换的字节数组
     * @return 赫夫曼编码之后转换的字节数组
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        Node huffmanTreeRoot = creatHuffman(nodes);
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        return zip(bytes, huffmanCodes);
    }

    //创建一个方法，获取到对应的Node集合

    /**
     * @param bytes 接收字节数组
     * @return 一个List<Node> 集合
     */
    private static List<Node> getNodes(byte[] bytes) {
        //创建一个ArrayList集合
        ArrayList<Node> nodes = new ArrayList<>();
        //利用map的特性去遍历bytes，并存储每个元素出现的次数
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        //map中已经统计了每个元素出现的次数，将每个键值对转换成Node对象并添加到nodes中
        //遍历map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //创建对应的赫夫曼树
    private static Node creatHuffman(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序，升序
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //创建一颗新的二叉树，没有data，只有权值
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            //删除已经构建的节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }
        //nodes最后的节点就是赫夫曼树的根节点
        return nodes.get(0);
    }

    //为了调用方便，重载getCodes方法
    public static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        //处理左子树
        getCodes(root.left, "0", stringBuilder);
        //处理右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    //将赫夫曼编码表存放到map中Map<Byte,String>
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //用一个StringBuilder 存储对应的编码
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 将node节点的所有叶子节点的哈夫曼编码得到，并存入到huffmanCodes中
     *
     * @param node          传入节点
     * @param code          路径，左子树为0，右子树为1
     * @param stringBuilder 用与拼接路径
     */
    public static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null) {//如果node等于null不作处理
            //判断node是叶子节点还是非叶子结点
            if (node.data == null) {
                //非叶子结点，向左递归
                getCodes(node.left, "0", stringBuilder1);
                //向右递归
                getCodes(node.right, "1", stringBuilder1);
            } else {//说明是一个叶子结点
                huffmanCodes.put(node.data, stringBuilder1.toString());
            }

        }

    }
    //通过生成的赫夫曼编码表，转换成压缩后的Byte数组

    /**
     * @param bytes        原始字符串的字节数组
     * @param huffmanCodes 赫夫曼编码的字节数组
     * @return 返回赫夫曼编码处理后的字节数组
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //利用huffmanCodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        //统计返回的huffmanCodes 对应的字节数组的长度
        //len = (stringBuilder.length()+7)/8;
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        int index = 0;
        //创建一个存储压缩后的byte数组
        byte[] huffmanCodeByte = new byte[len];
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte转成byte数组，放入huffmanCodeByte
            huffmanCodeByte[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeByte;
    }
    //解码为原数组对应的二进制补码

    /**
     * @param huffmanCodes 赫夫曼编码表map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
     */
    public static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //先得到huffmanBytes对应的二进制字符串
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转换成二进制字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
        }
        //将赫夫曼编码表进行调换
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //创建集合存放byte
        List<Byte> list = new ArrayList<>();
        //扫描stringBuilder
        for (int i = 0; i < stringBuilder.length()-1; ) {
            Byte b = null;
            int count = 0;
            boolean flag = true;

            while (flag) {
                String key = stringBuilder.substring(i, i + count);//直到匹配到一个字符
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;


        }
        //循环结束list存放所有字符
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    //赫夫曼解压缩，将字节数组转换成二进制

    /**
     * @param flag 标志是否需要补高位，true需要不高位，false不需要补高位
     * @param b    传入的byte
     * @return b对应的二进制字符串，（按照补码返回）
     */
    private static String byteToBitString(boolean flag, byte b) {
        //临时变量保存b
        int temp = b;
        //如果是正数，需要补高位
        if (flag) {
            temp |= 256; //按位与  256： 1 0000 0000
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }
    //文件压缩

    /**
     * @param srcFile 源文件绝对路径
     * @param dstFile 压缩文件存放路径
     */
    public static void zipFile(String srcFile, String dstFile) {
        OutputStream out = null;
        //输入流
        FileInputStream in = null;
        ObjectOutputStream oos = null;
        try {
            in = new FileInputStream(srcFile);
            //创建和源文件大小相同的字节数组
            byte[] b = new byte[in.available()];
            //读取文件
            in.read(b);
            //直接对源文件进行压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件的输出流，存放压缩文件
            out = new FileOutputStream(dstFile);
            //创建一个对象流，与输出流相关
            oos = new ObjectOutputStream(out);
            oos.writeObject(huffmanBytes);//把赫夫曼编码后的字节数组存入文件
            //同时还要把对应的赫夫曼编码表一并写入
            oos.writeObject(huffmanCodes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                in.close();
                oos.close();
                out.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //对压缩文件的解压
    public static void unZipFile(String zipFile, String dstFile) {
        //定义文件输入流
        InputStream is = null;
        //与输入流关联的对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        OutputStream os = null;
        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建与文件输入相关的对象流
            ois = new ObjectInputStream(is);
            //读取huffmanBytes数组
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取赫夫曼编码表
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            //解码
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            //写入目标文件
             os = new FileOutputStream(dstFile);
             os.write(bytes);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    //先序遍历
    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树~~~~");
        }
    }
}
