package common;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * Created by hldev on 18-1-14.
 */
public class MiscUtils {

    public static String getChinese(long seed, int length) throws UnsupportedEncodingException {
        String str = null;
        int highpos, lowpos;
        Random random = new Random(seed);
        highpos = (176 + Math.abs(random.nextInt(39)));
        lowpos = (161 + Math.abs(random.nextInt(93)));
        byte[] bb = new byte[length];
        for (int i = 0; i < (int)length / 2; i = i + 2) {
            bb[i] = new Integer(highpos).byteValue();
            bb[i + 1] = new Integer(lowpos).byteValue();
        }
        //String(byte[] bytes, Charset charset)
        //通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String。
        str = new String(bb, "GBK");
        return str;
    }
}
