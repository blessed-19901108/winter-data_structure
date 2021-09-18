package Second_week;

import java.util.Random;

public class Shuffle {
    //卡牌除大小王是52张牌
    //赌神
    public static int[] GodOfGamblers(int[] OldCard) {
        int[] NewCard = new int[52];
        int left = 0, right = 26, pos = 0;
        while (left < 26) {
            NewCard[pos++] = OldCard[left++];
            NewCard[pos++] = OldCard[right++];
        }
        return NewCard;
    }

    //荷官
    public static int[] Croupier(int[] OldCard) {
        int[] NewCard = new int[52];
        int rd = Shuffle.Random(4);
        //牌的左右边界
        int boundary = 26 + rd;

        int left = 0, right = boundary, pos = 0;
        while (left < boundary && right < 52) {
            if (rd == 0 || rd == 2) {
                NewCard[pos++] = OldCard[left++];
                NewCard[pos++] = OldCard[right++];
            } else {
                NewCard[pos++] = OldCard[right++];
                NewCard[pos++] = OldCard[left++];
            }
        }
        if (left == boundary) {
            while (right < 52) {
                NewCard[pos++] = OldCard[right++];
            }
        } else {
            while (left < boundary) {
                NewCard[pos++] = OldCard[left++];
            }
        }
        return NewCard;
    }

    //普通人
    public static int[] Ordinary(int[] OldCard) {
        int[] NewCard = new int[52];
        int rd = Shuffle.Random(4);
        //牌的左右边界
        int boundary = 26 + rd;
        int left = 0, right = boundary, pos = 0;
        while (left < boundary && right < 52) {
            int leftrd = Shuffle.Random(3);
            //延时 改变随机数种子
            Shuffle.Delay(10);
            int rightrd = Shuffle.Random(3);
            if (left + leftrd > boundary) {
                while (left < boundary) {
                    NewCard[pos++] = OldCard[left++];
                }
            } else if (right + rightrd > 52) {
                while (right < 52) {
                    NewCard[pos++] = OldCard[right++];
                }
            } else {
                for (int i = 0; i < leftrd; i++) {
                    NewCard[pos++] = OldCard[left++];
                }
                for (int i = 0; i < rightrd; i++) {
                    NewCard[pos++] = OldCard[right++];
                }
            }

        }
        if (left == boundary) {
            while (right < 52) {
                NewCard[pos++] = OldCard[right++];
            }
        } else {
            while (left < boundary) {
                NewCard[pos++] = OldCard[left++];
            }
        }
        return NewCard;
    }

    //随机数 [0~4)
    public static int Random(int bound) {
        //获得当前时间的毫秒数
        long t = System.currentTimeMillis();
        //作为种子数传入到Random的构造器
        Random rd = new Random(t);
        //生成随即整数
        return rd.nextInt(bound);
    }
    //int n=(int)(Math.random()*3+1);//另一种随机数方法

    //延时--毫秒
    public static void Delay(int time) {
        try {
            //毫秒
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }

    //按顺序排的牌
    public static int[] Card() {
        int[] card = new int[52];
        for (int i = 0; i < card.length; i++) {
            card[i] = i;
        }
        return card;
    }

    public static void main(String[] args) {
        int[] card = Shuffle.Card();
        int[] gog = Shuffle.GodOfGamblers(card);
        int[] cp = Shuffle.Croupier(card);
        int[] odn = Shuffle.Ordinary(card);

        int[] text = odn;
        for (int i = 0; i < text.length; i++) {
            System.out.print(text[i] + "  ");
        }

    }
}
