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
import java.math.BigDecimal;
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
    public void createCorporationData() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        for (int num = 0; num < RecordNum.LARGER.getValue(); num++) {
            TsC500035JbxxZtsbFrjc tsC500035JbxxZtsbFrjc = new TsC500035JbxxZtsbFrjc();
            Random random = new Random();
            String randomChinese = MiscUtils.getRandomFixLengthChinese(random.nextInt(30));
            String xdr = randomChinese == null ? String.valueOf(random.nextDouble()) : randomChinese.trim() + "有限公司";
            tsC500035JbxxZtsbFrjc.setXdr(xdr);
            Integer randomNumber = random.nextInt(60);
            String randomNumberResult = MiscUtils.createRandomNumber(randomNumber < 5 || randomNumber > 18 ? 18 : randomNumber);
            /**
             * 企业编码
             */
            tsC500035JbxxZtsbFrjc.setQybm(randomNumberResult);
            /**
             * 主键
             */
            tsC500035JbxxZtsbFrjc.setId(UUID.randomUUID().toString());
            tsC500035JbxxZtsbFrjc.setEtlDate(new Date());
            String xdrShxym = UUID.randomUUID().toString().replace("-", "");
            String md5 = MiscUtils.md5(xdrShxym).toUpperCase().substring(0, 18);
            /**
             * 主体代码
             */
            tsC500035JbxxZtsbFrjc.setZtDm(md5);
            /**
             * 代码
             */
            tsC500035JbxxZtsbFrjc.setDm(md5);
            /**
             * 代码类型
             */
            tsC500035JbxxZtsbFrjc.setDmlx("0");
            String fr = MiscUtils.getRandomFixLengthChinese(randomNumber > 3 || randomNumber == 0 ? 3 : randomNumber);
            /**
             * 法定代表人姓名
             */
            tsC500035JbxxZtsbFrjc.setFddbrxm(fr);
            tsC500035JbxxZtsbFrjc.setFddbrzjlx("");
            /**
             * 法定代表人证件号码
             */
            String fddbrRandomNumber = MiscUtils.createRandomNumber(randomNumber < 5 || randomNumber > 18 ? 18 : randomNumber);
            tsC500035JbxxZtsbFrjc.setFddbrzjhm(fddbrRandomNumber);
            tsC500035JbxxZtsbFrjc.setGb("");
            tsC500035JbxxZtsbFrjc.setZczb(BigDecimal.valueOf(random.nextDouble()));

            tsC500035JbxxZtsbFrjc.setZczbbz("");

            tsC500035JbxxZtsbFrjc.setHydm("");

            tsC500035JbxxZtsbFrjc.setLx("");

            String randomChineseJyfw = MiscUtils.getRandomFixLengthChinese(random.nextInt(100));

            tsC500035JbxxZtsbFrjc.setJyfw(randomChineseJyfw);
            String randomChinesezs = MiscUtils.getRandomFixLengthChinese(random.nextInt(25));

            tsC500035JbxxZtsbFrjc.setZs(randomChinesezs);

            tsC500035JbxxZtsbFrjc.setYzbm("");
            String randomChinesedjjg = MiscUtils.getRandomFixLengthChinese(random.nextInt(5));

            tsC500035JbxxZtsbFrjc.setDjjg(randomChinesedjjg + "工商所");
            tsC500035JbxxZtsbFrjc.setClrq(new Date());
            tsC500035JbxxZtsbFrjc.setBgrq(new Date());

            tsC500035JbxxZtsbFrjc.setDjzt("0");

            tsC500035JbxxZtsbFrjc.setDjztmc("存续");
            tsC500035JbxxZtsbFrjc.setHsfs("");
            tsC500035JbxxZtsbFrjc.setYyqxq(new Date());
            tsC500035JbxxZtsbFrjc.setHzrq(new Date());
            String fddbrRandomNumberGs = MiscUtils.createRandomNumber(randomNumber < 5 || randomNumber > 10 ? 10 : randomNumber);

            tsC500035JbxxZtsbFrjc.setGszch(fddbrRandomNumberGs);
            tsC500035JbxxZtsbFrjc.setSjjhsjc(new Date());
            tsC500035JbxxZtsbFrjc.setFlag(1);

            tsC500035JbxxZtsbFrjc.setJylx("有限责任公司(自然人独资)");

            tsC500035JbxxZtsbFrjc.setSfgk("1");
            tsC500035JbxxZtsbFrjc.setSjSourceDesc("市工商局");
            tsC500035JbxxZtsbFrjc.setSjSource("500001");
            tsC500035JbxxZtsbFrjc.setGjfs("1");
            tsC500035JbxxZtsbFrjc.setOrgId("500035");
            tsC500035JbxxZtsbFrjc.setOrgName("市工商局");
            tsC500035JbxxZtsbFrjc.setDfbm("500000");
            tsC500035JbxxZtsbFrjc.setDfName("市级部门");
            tsC500035JbxxZtsbFrjc.setIsFr("1");
            tsC500035JbxxZtsbFrjc.setZtLx("0");
            corporationService.create(tsC500035JbxxZtsbFrjc);
        }
    }


}
