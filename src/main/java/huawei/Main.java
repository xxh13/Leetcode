package huawei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String ipv6Address = in.nextLine();
        String result = main.resolveIpv6Address(ipv6Address);

        if (result == null) {
            System.out.println("Error");
        } else {
            System.out.println(result);
        }
    }


    /**
     * return null if the address is invalid
     *
     * @param ipv6Address
     * @return String
     */
    private String resolveIpv6Address(String ipv6Address) {
        if (ipv6Address.startsWith(":") && !ipv6Address.startsWith("::")) return null;
        if (ipv6Address.endsWith(":") && !ipv6Address.endsWith("::")) return null;
        if (!isValidFullAddress(ipv6Address)) return null;
        String[] result = new String[8];
        //step1: 判断地址是否使用缩略简写::
        if (ipv6Address.contains("::")) {

            int index = 0;
            String subAddressPre = ipv6Address.substring(0, ipv6Address.indexOf("::"));
            String subAddressPost = ipv6Address.substring(ipv6Address.indexOf("::") + 1, ipv6Address.length());

            String[] subAddressPreArray = subAddressPre.split(":");
            String[] subAddressPostArray = subAddressPost.split(":");

            //如果去掉省略之后的字地址长度大于等于8
            if (subAddressPostArray.length + subAddressPreArray.length >= 8) {
                return null;
            }

            for (int i = 0; i < subAddressPreArray.length; i++) {
                if (subAddressPreArray[i].length() > 4) {
                    return null;
                }
                result[index++] = getFullSubAddress(subAddressPreArray[i]);
            }

            for (int i = 0; i < 8 - subAddressPostArray.length - subAddressPreArray.length; i++) {
                result[index++] = "0000";
            }

            for (int i = 0; i < subAddressPostArray.length; i++) {
                if (subAddressPostArray[i].length() > 4) {
                    return null;
                }
                result[index++] = getFullSubAddress(subAddressPostArray[i]);
            }
        } else {
            String[] subAddress = ipv6Address.split(":");
            int length = subAddress.length;
            if (length != 8) {
                return null;
            }
            for (int i = 0; i < 8; i++) {
                if (subAddress[i].length() > 4) {
                    return null;
                }
                result[i] = getFullSubAddress(subAddress[i]);
            }

        }

        return String.join(":", result);
    }

    /**
     * 补全单个的地址
     *
     * @param s
     * @return
     */
    private String getFullSubAddress(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < 4) {
            sb.insert(0, '0');
        }

        return sb.toString();
    }

    private boolean isValidFullAddress(String s) {
        char[] validCharacters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
                'A', 'B', 'C', 'D', 'E', 'F'};

        int count = 0;
        int count2 = 0;
        boolean isValid = false;
        for (char c : s.toCharArray()) {
            if (c == ':') {
                count++;
                if (count == 2) {
                    //符号::只能出现一次
                    count2++;
                    if (count2 > 1) {
                        return false;
                    }
                }
                // 只能出现:或者::符号
                if (count > 2) {
                    return false;
                }
            } else {
                count = 0;
                for (int i = 0; i < validCharacters.length; i++) {
                    if (validCharacters[i] == c) {
                        isValid = true;
                    }
                }
                if (!isValid) {
                    return false;
                }
            }
        }
        return true;
    }
}
