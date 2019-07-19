package onlinejudge;

import java.util.Scanner;

public class XiaoMiOJ5 {
    //返回的是中间数字的下标
    public static int search(int[] a){
        int index = 0;
        for(int i = 0;i < a.length;i++){
            if(a[index] > a[i]) {
                //找最小的数字的下标
                index = i;
            }
        }
//        System.out.println("最小的数字下标："+index);
        int count = a.length / 2;
        //count为累加次数
        for(int i = 0;i < count;i++,index++){
            //如果到了最后一个数字，就让index赋值为1，保证循环
            if(index == a.length - 1){
                index = -1;
            }
        }
        return index;
    }

    //将字符串数组转化为整形数组
    public static void change(int[] a,String[] s,int len){
        for(int i = 0; i < len;i++){
            a[i] = Integer.parseInt(s[i]);
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] temp = s.split(",");
        int[] a = new int[temp.length];
        change(a,temp,a.length);
        int index = search(a);
        System.out.println(a[index]);
    }
}
