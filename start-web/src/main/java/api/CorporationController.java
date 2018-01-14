package api;

import common.MiscUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Book;
import pojo.TsC500035JbxxZtsbFrjc;
import pubenum.RecordNum;
import service.CorporationService;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by hldev on 18-1-14.
 */
@RestController
@RequestMapping("/api/corporation")
public class CorporationController {

    @Autowired
    private CorporationService corporationService;


    @GetMapping("create")
    public void getBooks() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        for (int num = 0; num < RecordNum.LARGER.getValue(); num++) {
            TsC500035JbxxZtsbFrjc tsC500035JbxxZtsbFrjc = new TsC500035JbxxZtsbFrjc();
            Random random = new Random();
            String randomChinese = MiscUtils.getChinese(random.nextLong(), random.nextInt(50));
            String xdr = randomChinese == null ? String.valueOf(random.nextDouble()) : randomChinese.trim() + "有限公司";
            tsC500035JbxxZtsbFrjc.setXdr(xdr);
            tsC500035JbxxZtsbFrjc.setId(UUID.randomUUID().toString());
            tsC500035JbxxZtsbFrjc.setEtlDate(new Date());
            String xdrShxym = UUID.randomUUID().toString().replace("-", "");
            String md5 = md5(xdrShxym).toUpperCase().substring(0,18);
            tsC500035JbxxZtsbFrjc.setZtDm(md5);
            tsC500035JbxxZtsbFrjc.setSjSource("500001");
            tsC500035JbxxZtsbFrjc.setGjfs("sss");
            corporationService.create(tsC500035JbxxZtsbFrjc);
        }
    }

    private static String md5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        return number.toString(18);
    }

}
