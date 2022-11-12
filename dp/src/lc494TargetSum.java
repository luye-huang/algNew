import org.testng.annotations.Test;

public class lc494TargetSum {

    private String handleFields(String input) {
        String[] arr = input.split(",");
        StringBuilder sb = new StringBuilder();
        sb.append("\"fields\":[");
        for (String str : arr) {
            String[] array = str.toString().split(" ");
            if (array[array.length - 1].equalsIgnoreCase("timestamp")) {
                array[array.length - 1] = "{\"logicalType\": \"timestamp-millis\", \"type\":\"long\" }";
            } else if (array[array.length - 1].equalsIgnoreCase("bigint")) {
                array[array.length - 1] = "\"long\"";
            } else {
                array[array.length - 1] = "\"" + array[array.length - 1] + "\"";
            }
            String s = "{\"name\": \"" + array[array.length - 2] + "\",\"type\":" + array[array.length - 1] + "},";
            sb.append(s);
        }
        sb.replace(sb.length() - 1, sb.length(), "]");
        return sb.toString();
    }

    @Test
    public void test() {
        String s = " c_time timestamp,\n" +
                "    c_pcode string,\n" +
                "    c_nodeip bigint,\n" +
                "    c_protocol int,\n" +
                "    c_sip string,\n" +
                "    c_dip string,\n" +
                "    c_domain string,\n" +
                "    c_class int,\n" +
                "    c_value string";
        System.out.println(handleFields(s));
        System.out.println(String.valueOf(11));
        System.out.println(String.valueOf(11D));
        System.out.println(String.valueOf(11.2f));
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(333L));


        System.out.println(handleFields(s));
//        System.out.println(Long.parseLong(null));
        System.out.println(Integer.parseInt(null));
        System.out.println(String.valueOf(11.2f));
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(333L));
    }
}
