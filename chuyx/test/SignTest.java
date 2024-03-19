package test;

import test.util.MD5Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author yuxiang_chu
 * @since 2024/1/16 14:47
 */
public class SignTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = "accountNo=6210980200722062267&accountSetResult=3&acctType=1&bankName=我的&checkTime=2024-01-16 16:30:41&code=0000&companyName=竹溪县子怡鞋店&key=MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1JWKefnkFmkR4vzDppY3NdTCCIGhcKrLFxP091xeX5n0922GxJZQoJuYek78vNBLr0JoVvZa0QhacSVblN3UDtwSt0N/sjsmdfKP7OOwHloVSkrK3NOMV26/1GhRUl5tDAaPgrhJViedIWsPm/Y/25ZGOOB4ZVw0knqe7YdWawdiRpwvaJ4CxACBr1JmNCPRAjPhLVdl8umRJtSa81KRszmVVChY8p3Nxfe2d2uD0/o4JFfH1/DeboYbgR+YqdVdXEJu9CqFglaZyOsCFCiTEQo1XV6QEAGVJKwPrpYGz9JSsPQDAdRLzhTRzwQ+Dw8bGVSvTTj8y9nqfxEdIvtfJQIDAQAB&legalIds=420324197711160623&legalName=王三华&legalPhone=18284005849&parentBankName=包商银行股份有限公司鞍山道支行&sysId=1683383834678181889&timestamp=20240116163042&uniCredit=92420324MA4D68J28J&unionBank=123456654321&useId=1536461113480359937#7&v=2.0&yunid=cd878360430c4140ba253bcb2bd21a6c";
        String s = a.toLowerCase();
        String sign = MD5Utils.MD5Encode(a);
        //1.3.5 对sign进行url编码
        System.out.println(URLEncoder.encode(sign, "utf-8"));;

    }

    static class ValueComparator implements Comparator<String> {
        Map<String, String> base;

        public ValueComparator(Map<String, String> base) {
            this.base = base;
        }

        public int compare(String a, String b) {
            int compareResult = base.get(a).compareTo(base.get(b));
            if (compareResult != 0) {
                return compareResult;
            } else {
                return a.compareTo(b);
            }
        }
    }
}
