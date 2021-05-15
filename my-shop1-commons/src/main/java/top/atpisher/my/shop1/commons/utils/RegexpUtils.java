package top.atpisher.my.shop1.commons.utils;

/**正则表达式工具类
 * @ClassName: RegexpUtils
 * @Author: l1957
 * @Date: 2021/4/13 23:06
 * @Description: TODO
 */
public class RegexpUtils {
    /**
     * 验证手机号
     */
    public static final String PHONE = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";

    /**
     * 验证邮箱地址
     */
    public static final String EMAIL = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";

    /**
     * 验证手机号
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        return phone.matches(PHONE);
    }

    /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        return email.matches(EMAIL);
    }
}
