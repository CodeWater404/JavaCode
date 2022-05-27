package jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @author ： CodeWater
 * @create ：2022-05-27-22:35
 * @Function Description ：手机验证码
 * 1. 验证码有限期是2分钟
 * 2. 用户最多只能输入三次
 */
public class PhoneCode {

    public static void main(String[] agrs) {
        //模拟发送
        verifyCode("1214332");

        //模拟输入验证
//        getRedisCode( "1214332" , "648236" );

    }

    //生成6位随机验证码
    public static String getCode() {
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            int rand = random.nextInt(10);
            code += rand;
        }
        return code;
    }

    //每个手机每天只能发送三次， 验证码放到redis中，设置过期时间
    public static void verifyCode(String phone) {
        Jedis jedis = new Jedis("ip", 6379);

        //手机发送次数---------------这里都是作为键存在redis中的
        String countKey = "VerifyCode" + phone + ":count";
        //验证码key
        String codeKey = "VerifyCode" + phone + ":code";

        //每个手机每天只能发送三次
        String count = jedis.get(countKey);
        if (count == null) {
            jedis.setex(countKey, 24 * 60 * 60, "1");

        } else if (Integer.parseInt(count) <= 2) {
            //发送次数+1
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) > 2) {
            System.out.println("今天发送次数已经超过三次");
            jedis.close();

            return;
        }

        //存入redis中
        String vcode = getCode();
        //setex: 键  过期时间 值
        jedis.setex(codeKey, 120, vcode);
        jedis.close();
    }

    //验证码校验
    public static void getRedisCode(String phone, String code) {
        Jedis jedis = new Jedis("ip", 6379);

        String codeKey = "VerifyCode" + phone + ":code";
        String redisCode = jedis.get(codeKey);

        //redis中获取的和用户自己的输入的进行比对
        if (redisCode.equals(code)) {
            System.out.println("成功");

        } else {
            System.out.println("失败 ");
        }
        jedis.close();
    }
}
