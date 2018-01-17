package common;

import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 *
 * @author hldev
 * @date 18-1-14
 */
public class MiscUtils {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MiscUtils.class);

    /**
     * 生成MD5
     *
     * @param input
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String md5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        return number.toString(18);
    }

    /**
     * 返回长度为【strLength】的随机数，在前面补0
     *
     * @param strLength
     * @return
     */
    private static String getFixLenthString(int strLength) {

        Random rm = new Random();

        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);

        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);

        // 返回固定的长度的随机数
        return fixLenthString.substring(1, strLength + 1);
    }


    /**
     * 获取指定长度随机简体中文
     *
     * @param length int
     * @return String
     */
    public static String getRandomFixLengthChinese(int length) {
        String resultFixChinese = "";
        for (int i = 0; i < length; i++) {
            String singleChinese = null;
            int highPosition, lowPosition;
            Random random = new Random();
            highPosition = (176 + Math.abs(random.nextInt(39)));
            lowPosition = (161 + Math.abs(random.nextInt(93)));
            byte[] singByteArray = new byte[2];
            singByteArray[0] = (new Integer(highPosition).byteValue());
            singByteArray[1] = (new Integer(lowPosition).byteValue());
            try {
                singleChinese = new String(singByteArray, "GBK");
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }

            resultFixChinese += singleChinese;
        }
        return resultFixChinese;
    }

    /**
     * 根据指定长度生成纯数字的随机数
     * @param length
     */
    public static String createRandomNumber(int length) {
        StringBuilder sb=new StringBuilder();
        Random rand=new Random();
        for(int i=0;i<length;i++)
        {
            sb.append(rand.nextInt(10));
        }
        String data=sb.toString();
        return data;
    }
}
