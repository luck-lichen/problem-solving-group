package com.threeclear.pollution.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * title: 类
 * <br>description:
 *
 * @author liuxx
 * @version 1.0
 * @date 2022/1/28 15:50
 */
@Component
public class WhiteCompanyConfig implements CommandLineRunner {
    public static final Map<String, String> map = new HashMap<String, String>();

    @Override
    public void run(String... args) throws Exception {
        map.put("15b37093cc0542cd8ff7f80b2593faf4","赤城县日新环宇供热有限公司");
        map.put("0e5556ecdb0444e2a5ec865bb6fc07d3","大唐国际发电股份有限公司下花园发电厂");
        map.put("bec303b917604ceaab1a117c92ae0520","大唐国际发电股份有限公司张家口发电厂");
        map.put("cb4b9fecf91144a0827171c515323999","国能怀安热电有限公司");
        map.put("7480baea93a0485baf7e89dc7bfbecc5","河北大唐国际张家口热电有限责任公司");
        map.put("5794578778e2477089a5bd46a7aaf7e7","河北建投宣化热电有限责任公司");
        map.put("5ca528529d2c425ab2dbeeb42332ba46","河北省矾山磷矿有限公司");
        map.put("661ad95655324ffb9346785fd6b0ed87","河北蔚州能源综合开发有限公司");
        map.put("74ab80c6e45b402688edc838ac52ee12","恒泰张家口节能减排有限公司");
        map.put("171a1f150db842329c2a18b942f4b506","康保县康达热力有限责任公司");
        map.put("49804ff9c2c44dd7a52256d9c7b89efd","康保县天润热力有限公司");
        map.put("0157a2fd03c44b1f99c38aefbe894d78","善能康保生物质热电有限公司");
        map.put("31265ea6b7e94e0698e7bfb4d622378f","蔚县华维峰煤制品有限公司");
        map.put("695fa70011804854a6fda0a264284b51","蔚县金泰洁净能源有限责任公司");
        map.put("c63eef50e47343f8ab7a8cb01c2451cd","阳原县华阳集中供热有限公司");
        map.put("6854085ac6af4e17884cae6071afbe25","阳原县兴安热力有限公司");
        map.put("d80487501d464e498e209ead6e843732","张北华盈热力有限公司");
        map.put("03efbcaa622a4d869e736a7962a981b2","张北县星火供热有限公司");
        map.put("a1b81e28d1db49af8a8001371ac41cfd","张家口好兴供热有限公司");
        map.put("d0112165e13c44bf89b5718114ec1c11","张家口卷烟厂有限责任公司");
        map.put("bc006c60f0c744ceb7d3266f17944fab","张家口启迪新能源有限公司");
        map.put("67b58b2e77534aed89ab8707388e03e2","张家口荣庆热力股份有限公司");
        map.put("f1002674679c406097232ec697e36da3","张家口市察北飞腾园区投资开发有限公司");
        map.put("4c06f09c71934b1a92f50da8d7454b5e","张家口市塞北奥德热力能源有限公司");
        map.put("63524aa8105241eaa54212cecaa878aa","张家口万全区东阳热力有限公司");
        map.put("5ebca4d10b09437b9d20c16413a96611","张家口万全区通源热力有限公司");
        map.put("bdf5431820014b969c4fdb8765d3e914","张家口源通华盛热力有限公司");
        map.put("e510adb41f6b4db99ac1152306b80315","浙江吉利汽车有限公司张家口分公司");
        map.put("e1b31c6650b644d1981884411acb29d9","涿鹿华达生物热电有限公司");
        map.put("6843c60f65c14535af6fd702784f142b","涿鹿县轩辕城市供热有限公司");
        //map.put("","中节能（蔚县）环保能源有限公司");
        //map.put("","张家口泓凯供热有限责任公司");
        //map.put("","尚义县耀慈热力有限公司");
    }
}
